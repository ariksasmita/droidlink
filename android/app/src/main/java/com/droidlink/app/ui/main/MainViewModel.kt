package com.droidlink.app.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidlink.core.network.TcpClient
import com.droidlink.core.security.DeviceInfo
import com.droidlink.core.security.QRCodeParser
import com.droidlink.core.security.ValidationResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class MainUiState {
    object Disconnected : MainUiState()
    object Scanning : MainUiState()
    object ReadyToScan : MainUiState()
    data class Connecting(val deviceName: String) : MainUiState()
    data class Connected(val deviceName: String) : MainUiState()
    data class Error(val message: String) : MainUiState()
}

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Disconnected)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private var tcpClient: TcpClient? = null
    private val qrCodeParser = QRCodeParser()

    fun startPairing() {
        Log.d("DroidLink", "startPairing called")
        viewModelScope.launch {
            Log.d("DroidLink", "State: Scanning")
            _uiState.value = MainUiState.Scanning
            kotlinx.coroutines.delay(1000)
            Log.d("DroidLink", "State: ReadyToScan")
            _uiState.value = MainUiState.ReadyToScan
        }
    }

    fun onQRCodeScanned(qrData: String) {
        Log.d("DroidLink", "onQRCodeScanned: $qrData")
        viewModelScope.launch {
            try {
                Log.d("DroidLink", "Processing QR code...")
                _uiState.value = MainUiState.Connecting("Processing QR...")

                // Parse QR code
                val token = qrCodeParser.parse(qrData)
                
                // Validate
                val validationResult = qrCodeParser.validate(token)
                
                when (validationResult) {
                    is ValidationResult.Valid -> {
                        val deviceInfo = qrCodeParser.extractDeviceInfo(token)
                        
                        // Update UI to show we're connecting to the actual device
                        _uiState.value = MainUiState.Connecting(deviceInfo.deviceName)
                        
                        // Try to connect via TCP
                        try {
                            // Connect to Mac's IP (hardcoded for testing)
                            tcpClient = TcpClient("172.27.30.163", 9999)
                            tcpClient?.connect()
                            
                            // Send a hello message
                            tcpClient?.send("Hello from ${deviceInfo.deviceName}!")
                            
                            // Wait for response
                            val response = tcpClient?.receive()
                            println("📩 Server response: $response")
                            
                            // Simulate connection delay
                            delay(2000)
                            _uiState.value = MainUiState.Connected(deviceInfo.deviceName)
                        } catch (e: Exception) {
                            println("❌ TCP connection failed: ${e.message}")
                            // For now, still show as connected even if TCP fails
                            delay(2000)
                            _uiState.value = MainUiState.Connected(deviceInfo.deviceName)
                        }
                    }
                    is ValidationResult.InvalidVersion -> {
                        _uiState.value = MainUiState.Error(validationResult.message)
                    }
                    is ValidationResult.ExpiredQR -> {
                        _uiState.value = MainUiState.Error(validationResult.message)
                    }
                    is ValidationResult.FutureQR -> {
                        _uiState.value = MainUiState.Error(validationResult.message)
                    }
                }
            } catch (e: Exception) {
                _uiState.value = MainUiState.Error("Invalid QR code: ${e.message}")
            }
        }
    }

    fun disconnect() {
        viewModelScope.launch {
            tcpClient?.close()
            _uiState.value = MainUiState.Disconnected
        }
    }

    fun cancelPairing() {
        viewModelScope.launch {
            tcpClient?.close()
            _uiState.value = MainUiState.Disconnected
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            tcpClient?.close()
        }
    }
}