package com.droidlink.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidlink.core.security.CertificateGenerator
import com.droidlink.core.security.QRCodeParser
import com.droidlink.core.security.extractDeviceInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val certificateGenerator: CertificateGenerator,
    private val qrCodeParser: QRCodeParser
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Disconnected)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    fun startPairing() {
        viewModelScope.launch {
            _uiState.value = MainUiState.Scanning
            
            // Generate certificate if not exists
            try {
                val certResult = certificateGenerator.retrieveCertificate()
                // Certificate exists, ready to pair
                _uiState.value = MainUiState.ReadyToScan
            } catch (e: Exception) {
                // Generate new certificate
                try {
                    certificateGenerator.generateCertificate()
                    _uiState.value = MainUiState.ReadyToScan
                } catch (e: Exception) {
                    _uiState.value = MainUiState.Error("Failed to generate certificate: ${e.message}")
                }
            }
        }
    }
    
    fun onQRCodeScanned(qrCodeData: String) {
        viewModelScope.launch {
            try {
                // Parse QR code
                val token = qrCodeParser.parse(qrCodeData)
                
                // Validate QR code
                val validationResult = qrCodeParser.validate(token)
                
                when (validationResult) {
                    is com.droidlink.core.security.ValidationResult.Valid -> {
                        // Extract device info
                        val deviceInfo = qrCodeParser.extractDeviceInfo(token)
                        
                        // Store paired device info
                        // TODO: Store in database
                        
                        // Start connecting
                        _uiState.value = MainUiState.Connecting(deviceInfo.deviceName)
                        
                        // TODO: Implement TLS connection
                        // For now, simulate connection
                        kotlinx.coroutines.delay(2000)
                        _uiState.value = MainUiState.Connected(deviceInfo.deviceName)
                    }
                    is com.droidlink.core.security.ValidationResult.InvalidVersion -> {
                        _uiState.value = MainUiState.Error(validationResult.message)
                    }
                    is com.droidlink.core.security.ValidationResult.ExpiredQR -> {
                        _uiState.value = MainUiState.Error(validationResult.message)
                    }
                    is com.droidlink.core.security.ValidationResult.FutureQR -> {
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
            // TODO: Implement disconnect
            _uiState.value = MainUiState.Disconnected
        }
    }
    
    fun cancelPairing() {
        _uiState.value = MainUiState.Disconnected
    }
}

sealed class MainUiState {
    object Disconnected : MainUiState()
    object Scanning : MainUiState()
    object ReadyToScan : MainUiState()
    data class Connecting(val deviceName: String) : MainUiState()
    data class Connected(val deviceName: String) : MainUiState()
    data class Error(val message: String) : MainUiState()
}
