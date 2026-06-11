package com.droidlink.core.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Clipboard manager that monitors changes and syncs to remote device
 */
class ClipboardManager(
    private val context: Context,
    private val onClipboardChanged: (String) -> Unit
) {
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var lastContent: String = ""
    private var isMonitoring = false
    
    companion object {
        private const val TAG = "ClipboardManager"
        private const val CHECK_INTERVAL_MS = 500L
    }
    
    /**
     * Start monitoring clipboard changes
     */
    fun startMonitoring() {
        if (isMonitoring) {
            Log.w(TAG, "Already monitoring clipboard")
            return
        }
        
        Log.d(TAG, "📋 Starting clipboard monitoring")
        isMonitoring = true
        lastContent = getCurrentContent()
        
        scope.launch {
            while (isMonitoring) {
                delay(CHECK_INTERVAL_MS)
                checkForChanges()
            }
        }
    }
    
    /**
     * Stop monitoring clipboard changes
     */
    fun stopMonitoring() {
        Log.d(TAG, "🛑 Stopping clipboard monitoring")
        isMonitoring = false
        scope.cancel()
    }
    
    /**
     * Check for clipboard changes and notify if changed
     */
    private fun checkForChanges() {
        try {
            val currentContent = getCurrentContent()
            
            if (currentContent != lastContent && currentContent.isNotEmpty()) {
                Log.d(TAG, "📝 Clipboard changed: \"$currentContent\"")
                lastContent = currentContent
                onClipboardChanged(currentContent)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error checking clipboard", e)
        }
    }
    
    /**
     * Set clipboard content (from remote device)
     */
    fun setContent(text: String) {
        try {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("DroidLink", text)
            clipboard.setPrimaryClip(clip)
            lastContent = text
            Log.d(TAG, "✅ Clipboard set from remote: \"$text\"")
        } catch (e: Exception) {
            Log.e(TAG, "Error setting clipboard", e)
        }
    }
    
    /**
     * Get current clipboard content
     */
    private fun getCurrentContent(): String {
        return try {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = clipboard.primaryClip
            if (clip != null && clip.itemCount > 0) {
                clip.getItemAt(0).text?.toString() ?: ""
            } else {
                ""
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting clipboard content", e)
            ""
        }
    }
}