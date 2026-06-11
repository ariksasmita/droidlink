package com.droidlink.app.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.droidlink.app.ui.camera.CameraPermissionWrapper

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "DroidLink",
                style = MaterialTheme.typography.headlineLarge
            )
            
            Text(
                text = "Free, local-first Android ↔ Mac integration",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
            
            when (val state = uiState) {
                is MainUiState.Disconnected -> {
                    Button(onClick = { viewModel.startPairing() }) {
                        Text("Pair Device")
                    }
                }
                is MainUiState.Scanning -> {
                    CircularProgressIndicator()
                    Text("Preparing to scan...")
                }
                is MainUiState.ReadyToScan -> {
                    android.util.Log.d("MainScreen", "ReadyToScan state: showing camera")
                    Box(modifier = Modifier.fillMaxSize()) {
                        // Camera preview with QR detection
                        CameraPermissionWrapper(
                            onQrCodeDetected = { qrData ->
                                viewModel.onQRCodeScanned(qrData)
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                        
                        // Overlay UI
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                                .padding(16.dp)
                        ) {
                            Text(
                                "Point camera at Mac QR code",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                        
                        // Cancel button at bottom
                        Button(
                            onClick = { viewModel.cancelPairing() },
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.secondary
                            )
                        ) {
                            Text("Cancel")
                        }
                    }
                }
                is MainUiState.Connecting -> {
                    CircularProgressIndicator()
                    Text("Connecting to ${state.deviceName}...")
                }
                is MainUiState.Connected -> {
                    Text("Connected to ${state.deviceName}")
                    Button(onClick = { viewModel.disconnect() }) {
                        Text("Disconnect")
                    }
                }
                is MainUiState.Error -> {
                    Text(state.message, color = MaterialTheme.colorScheme.error)
                    Button(onClick = { viewModel.cancelPairing() }) {
                        Text("Back")
                    }
                }
            }
        }
    }
}
