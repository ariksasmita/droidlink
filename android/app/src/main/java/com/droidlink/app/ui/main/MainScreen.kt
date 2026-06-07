package com.droidlink.app.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
                is MainUiState.Connecting -> {
                    CircularProgressIndicator()
                    Text("Connecting...")
                }
                is MainUiState.Connected -> {
                    Text("Connected to ${state.deviceName}")
                    Button(onClick = { viewModel.disconnect() }) {
                        Text("Disconnect")
                    }
                }
            }
        }
    }
}
