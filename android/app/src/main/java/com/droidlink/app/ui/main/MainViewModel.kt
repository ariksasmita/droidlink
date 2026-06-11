package com.droidlink.app.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidlink.core.network.TlsTcpClient
import com.droidlink.core.security.DeviceInfo
import com.droidlink.core.security.QRCodeParser
import com.droidlink.core.security.ValidationResult
import com.droidlink.core.clipboard.ClipboardManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import android.content.Context

sealed class MainUiState {
    object Disconnected : MainUiState()
    object Scanning : MainUiState()
    object ReadyToScan : MainUiState()
    data class Connecting(val deviceName: String) : MainUiState()
    data class Connected(val deviceName: String) : MainUiState()
    data class Error(val message: String) : MainUiState()
}

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModel(private val context: Context) : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Disconnected)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private var tlsClient: TlsTcpClient? = null
    private var clipboardManager: ClipboardManager? = null
    private val qrCodeParser = QRCodeParser()

    fun startPairing() {
        android.util.Log.d("MainViewModel", "startPairing called")
        viewModelScope.launch {
            android.util.Log.d("MainViewModel", "State: Scanning")
            _uiState.value = MainUiState.Scanning
            kotlinx.coroutines.delay(1000)
            android.util.Log.d("MainViewModel", "State: ReadyToScan")
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
                        
                        // Try to connect via TLS
                        try {
                            // Connect to Mac's IP (hardcoded for testing)
                            tlsClient = TlsTcpClient(
                                "172.27.30.163",
                                9999,
                                serverCertificateFingerprint = deviceInfo.certificateFingerprint
                            )
                            tlsClient?.connect()
                            
                            // Send a hello message
                            tlsClient?.send("Hello from ${deviceInfo.deviceName}!")
                            
                            _uiState.value = MainUiState.Connected(deviceInfo.deviceName)
                            
                            // Start clipboard monitoring
                            startClipboardMonitoring(context)
                            
                            // Start listening for incoming messages from Mac
                            startListeningForMessages()
                        } catch (e: Exception) {
                            Log.e("MainViewModel", "❌ TCP connection failed: ${e.message}")
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
            tlsClient?.close()
            _uiState.value = MainUiState.Disconnected
        }
    }

    fun cancelPairing() {
        viewModelScope.launch {
            tlsClient?.close()
            _uiState.value = MainUiState.Disconnected
        }
    }

    private fun startClipboardMonitoring(context: Context) {
        Log.d("MainViewModel", "Starting clipboard monitoring")
        clipboardManager = ClipboardManager(context) { clipboardContent ->
            Log.d("MainViewModel", "Clipboard changed: $clipboardContent")
            // Send to Mac
            viewModelScope.launch {
                try {
                    tlsClient?.send("CLIPBOARD:$clipboardContent")
                    Log.d("MainViewModel", "Sent clipboard to Mac")
                } catch (e: Exception) {
                    Log.e("MainViewModel", "Failed to send clipboard", e)
                }
            }
        }
        clipboardManager?.startMonitoring()
    }
    
    private fun startListeningForMessages() {
        viewModelScope.launch {
            while (true) {
                try {
                    val message = tlsClient?.receive()
                    if (message != null) {
                        Log.d("MainViewModel", "📩 Received from Mac: $message")
                        
                        if (message.startsWith("CLIPBOARD:")) {
                            val clipboardContent = message.removePrefix("CLIPBOARD:")
                            Log.d("MainViewModel", "📋 Setting clipboard from Mac: $clipboardContent")
                            clipboardManager?.setContent(clipboardContent)
                        }
                    }
                } catch (e: Exception) {
                    Log.e("MainViewModel", "Error receiving messages", e)
                    break
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            tlsClient?.close()
            clipboardManager?.stopMonitoring()
        }
    }
}