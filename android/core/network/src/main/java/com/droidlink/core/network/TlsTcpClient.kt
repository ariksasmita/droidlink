package com.droidlink.core.network

import android.util.Log
import com.droidlink.core.security.KeyPairAndCertificate
import com.droidlink.core.security.TlsCertificateGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.security.KeyPair
import java.security.cert.X509Certificate
import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager
import java.security.cert.CertificateException

/**
 * TLS-enabled TCP client for secure communication
 */
class TlsTcpClient(
    private val host: String,
    private val port: Int,
    private val serverCertificateFingerprint: String? = null // For validation
) {
    private var sslSocket: SSLSocket? = null
    private var writer: PrintWriter? = null
    private var reader: BufferedReader? = null
    private val certGenerator = TlsCertificateGenerator()
    
    /**
     * Connect to the server with TLS
     */
    suspend fun connect() = withContext(Dispatchers.IO) {
        Log.d("TlsTcpClient", "Connecting to $host:$port with TLS")
        
        // Generate client certificate
        // For MVP, use a simple device ID
        val deviceId = "android-device-" + (System.currentTimeMillis() % 10000)
        val keyPairAndCert = certGenerator.generateCertificate(deviceId)
        val sslContext = certGenerator.createSslContext(
            keyPairAndCert.keyPair,
            keyPairAndCert.certificate
        )
        
        // Create SSL socket factory
        val socketFactory = sslContext.socketFactory
        sslSocket = socketFactory.createSocket(host, port) as SSLSocket
        
        // Enable TLS 1.3
        sslSocket?.enabledProtocols = arrayOf("TLSv1.3", "TLSv1.2")
        
        // Start handshake
        sslSocket?.startHandshake()
        
        // Validate server certificate if fingerprint provided
        if (serverCertificateFingerprint != null) {
            val session = sslSocket?.session
            val serverCerts = session?.peerCertificates
            if (serverCerts != null && serverCerts.isNotEmpty()) {
                val serverCert = serverCerts[0] as X509Certificate
                val fingerprint = certGenerator.getCertificateFingerprint(serverCert)
                Log.d("TlsTcpClient", "Server cert fingerprint: $fingerprint")
                Log.d("TlsTcpClient", "Expected fingerprint: $serverCertificateFingerprint")
                
                if (fingerprint != serverCertificateFingerprint) {
                    throw SecurityException("Server certificate fingerprint mismatch!")
                }
                Log.d("TlsTcpClient", "✅ Server certificate validated")
            }
        }
        
        writer = PrintWriter(sslSocket?.getOutputStream(), true)
        reader = BufferedReader(InputStreamReader(sslSocket?.getInputStream()))
        
        Log.d("TlsTcpClient", "✅ Connected to $host:$port with TLS")
    }
    
    /**
     * Send a message to the server
     */
    suspend fun send(message: String) = withContext(Dispatchers.IO) {
        Log.d("TlsTcpClient", "Sending: $message")
        writer?.println(message)
    }
    
    /**
     * Receive a message from the server (blocking)
     */
    suspend fun receive(): String? = withContext(Dispatchers.IO) {
        val message = reader?.readLine()
        Log.d("TlsTcpClient", "Received: $message")
        message
    }
    
    /**
     * Close the connection
     */
    suspend fun close() = withContext(Dispatchers.IO) {
        writer?.close()
        reader?.close()
        sslSocket?.close()
        sslSocket = null
        writer = null
        reader = null
        Log.d("TlsTcpClient", "Connection closed")
    }
    
    /**
     * Check if connected
     */
    fun isConnected(): Boolean {
        return sslSocket?.isConnected == true && sslSocket?.isClosed == false
    }
}