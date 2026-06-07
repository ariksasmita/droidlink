package com.droidlink.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Disconnected)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    
    fun startPairing() {
        viewModelScope.launch {
            _uiState.value = MainUiState.Connecting
            
            // TODO: Implement QR code pairing flow
            // 1. Show QR code scanner
            // 2. Scan QR code from Mac app
            // 3. Exchange certificates
            // 4. Establish TLS connection
            
            // For now, simulate connection
            _uiState.value = MainUiState.Connected("MacBook Pro")
        }
    }
    
    fun disconnect() {
        viewModelScope.launch {
            // TODO: Implement disconnect
            _uiState.value = MainUiState.Disconnected
        }
    }
}

sealed class MainUiState {
    object Disconnected : MainUiState()
    object Connecting : MainUiState()
    data class Connected(val deviceName: String) : MainUiState()
}
