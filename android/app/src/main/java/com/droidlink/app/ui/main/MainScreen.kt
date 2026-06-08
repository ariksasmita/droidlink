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
import androidx.hilt.navigation.compose.hiltViewModel
import com.droidlink.app.ui.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
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
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Ready to scan QR code")
                        Text("Point camera at Mac QR code",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        
                        // TODO: Add QR code scanner UI
                        // For now, simulate scan with test button
                        Button(
                            onClick = {
                                // Simulate QR scan with test data
                                val timestamp = System.currentTimeMillis() / 1000
                                val testQR = "{\"version\": \"1.0.0\", \"deviceId\": \"test-mac-123\", \"deviceName\": \"MacBook Pro\", \"certificateFingerprint\": \"aa:bb:cc:dd\", \"timestamp\": $timestamp}"
                                viewModel.onQRCodeScanned(testQR)
                            }
                        ) {
                            Text("Simulate QR Scan")
                        }
                        
                        Button(
                            onClick = { viewModel.cancelPairing() },
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
