package com.droidlink.app.ui.camera

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.ui.platform.LocalContext
import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

/**
 * Camera permission wrapper for QR scanner
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermissionWrapper(
    onQrCodeDetected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    
    LaunchedEffect(Unit) {
        android.util.Log.d("CameraPermissionWrapper", "Launching permission request")
        cameraPermissionState.launchPermissionRequest()
    }
    
    android.util.Log.d("CameraPermissionWrapper", "Permission status: ${cameraPermissionState.status}")
    
    if (cameraPermissionState.status == com.google.accompanist.permissions.PermissionStatus.Granted) {
        QrScanner(
            onQrCodeDetected = onQrCodeDetected,
            modifier = modifier
        )
    } else {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Camera permission required")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                    Text("Grant Permission")
                }
            }
        }
    }
}