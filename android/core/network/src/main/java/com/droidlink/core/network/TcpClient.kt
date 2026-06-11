package com.droidlink.core.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

/**
 * Simple TCP client for connecting to Mac server
 */
class TcpClient(
    private val host: String,
    private val port: Int
) {
    private var socket: Socket? = null
    private var writer: PrintWriter? = null
    private var reader: BufferedReader? = null

    /**
     * Connect to the server
     */
    suspend fun connect() = withContext(Dispatchers.IO) {
        Log.d("TcpClient", "Connecting to $host:$port")
        socket = Socket(host, port)
        writer = PrintWriter(socket?.getOutputStream(), true)
        reader = BufferedReader(InputStreamReader(socket?.getInputStream()))
        Log.d("TcpClient", "✅ Connected to $host:$port")
    }

    /**
     * Send a message to the server
     */
    suspend fun send(message: String) = withContext(Dispatchers.IO) {
        Log.d("TcpClient", "Sending: $message")
        writer?.println(message)
    }

    /**
     * Receive a message from the server (blocking)
     */
    suspend fun receive(): String? = withContext(Dispatchers.IO) {
        val message = reader?.readLine()
        Log.d("TcpClient", "Received: $message")
        message
    }

    /**
     * Close the connection
     */
    suspend fun close() = withContext(Dispatchers.IO) {
        writer?.close()
        reader?.close()
        socket?.close()
        socket = null
        writer = null
        reader = null
    }

    /**
     * Check if connected
     */
    fun isConnected(): Boolean {
        return socket?.isConnected == true && socket?.isClosed == false
    }
}