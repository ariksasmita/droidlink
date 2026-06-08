package com.droidlink.core.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.math.BigInteger
import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.SecureRandom
import java.util.Date
import javax.security.auth.x500.X500Principal

/**
 * Certificate generator for secure pairing
 */
class CertificateGenerator {
    
    companion object {
        private const val ANDROID_KEYSTORE = "AndroidKeyStore"
        private const val KEY_ALIAS = "droidlink_device_cert"
    }
    
    /**
     * Generate a self-signed certificate for this device
     */
    fun generateCertificate(): CertificateResult {
        try {
            // Generate key pair with AndroidKeyStore
            val keyPairGenerator = KeyPairGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_RSA,
                ANDROID_KEYSTORE
            )
            
            val keyGenParameterSpec = KeyGenParameterSpec.Builder(
                KEY_ALIAS,
                KeyProperties.PURPOSE_SIGN or KeyProperties.PURPOSE_VERIFY
            )
                .setKeySize(2048)
                .setDigests(KeyProperties.DIGEST_SHA256)
                .setSignaturePaddings(KeyProperties.SIGNATURE_PADDING_RSA_PKCS1)
                .setCertificateSubject(X500Principal("CN=DroidLink, O=DroidLink, C=US"))
                .build()
            
            keyPairGenerator.initialize(keyGenParameterSpec)
            
            keyPairGenerator.initialize(keyGenParameterSpec)
            val keyPair = keyPairGenerator.generateKeyPair()
            
            // Retrieve certificate from KeyStore
            val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
            val certificate = keyStore.getCertificate(KEY_ALIAS) as java.security.cert.X509Certificate
            
            // Calculate fingerprint
            val fingerprint = calculateFingerprint(certificate)
            
            return CertificateResult(
                certificate = certificate,
                publicKey = certificate.publicKey,
                privateKey = keyPair.private,
                fingerprint = fingerprint
            )
        } catch (e: Exception) {
            throw CertificateGenerationException("Failed to generate certificate", e)
        }
    }
    
    /**
     * Retrieve certificate from KeyStore
     */
    fun retrieveCertificate(): CertificateResult {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
        
        if (!keyStore.containsAlias(KEY_ALIAS)) {
            throw CertificateGenerationException("No certificate found in KeyStore")
        }
        
        val privateKey = keyStore.getKey(KEY_ALIAS, null) as? java.security.PrivateKey
            ?: throw CertificateGenerationException("Private key not found")
        
        val certificate = keyStore.getCertificate(KEY_ALIAS) as? java.security.cert.X509Certificate
            ?: throw CertificateGenerationException("Certificate not found")
        
        val fingerprint = calculateFingerprint(certificate)
        
        return CertificateResult(
            certificate = certificate,
            publicKey = certificate.publicKey,
            privateKey = privateKey,
            fingerprint = fingerprint
        )
    }
    
    /**
     * Get device ID
     */
    fun getDeviceId(): String {
        return android.provider.Settings.Secure.ANDROID_ID
    }
    
    /**
     * Get device name
     */
    fun getDeviceName(): String {
        return android.os.Build.MODEL
    }
    
    /**
     * Calculate SHA-256 fingerprint of certificate
     */
    private fun calculateFingerprint(certificate: java.security.cert.X509Certificate): String {
        val encoded = certificate.encoded
        val digest = java.security.MessageDigest.getInstance("SHA-256").digest(encoded)
        return digest.joinToString(":") { String.format("%02X", it) }
    }
}

data class CertificateResult(
    val certificate: java.security.cert.X509Certificate,
    val publicKey: java.security.PublicKey,
    val privateKey: java.security.PrivateKey,
    val fingerprint: String
)

class CertificateGenerationException(message: String, cause: Throwable? = null) : Exception(message, cause)
