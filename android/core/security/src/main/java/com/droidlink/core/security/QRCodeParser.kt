package com.droidlink.core.security

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * Pairing token data from QR code
 */
@Serializable
data class PairingToken(
    val version: String,
    val deviceId: String,
    val deviceName: String,
    val certificateFingerprint: String,
    val timestamp: Long
)

/**
 * Parser for QR code data
 */
class QRCodeParser {
    
    /**
     * Parse pairing token from QR code string
     */
    fun parse(qrCodeData: String): PairingToken {
        return try {
            Json.decodeFromString<PairingToken>(qrCodeData)
        } catch (e: Exception) {
            throw QRCodeParseException("Invalid QR code format: ${e.message}", e)
        }
    }
    
    /**
     * Validate pairing token
     */
    fun validate(token: PairingToken): ValidationResult {
        // Check version
        if (!token.version.startsWith("1.")) {
            return ValidationResult.InvalidVersion("Unsupported version: ${token.version}")
        }
        
        // Check timestamp (should be within last 5 minutes)
        val currentTime = System.currentTimeMillis() / 1000
        val tokenAge = currentTime - token.timestamp
        
        if (tokenAge > 300) {
            return ValidationResult.ExpiredQR("QR code expired (age: $tokenAge seconds)")
        }
        
        // Check if timestamp is in the future (clock skew)
        if (tokenAge < -60) {
            return ValidationResult.FutureQR("QR code from future (clock skew: ${-tokenAge} seconds)")
        }
        
        return ValidationResult.Valid
    }
    
    /**
     * Extract device info from token
     */
    fun extractDeviceInfo(token: PairingToken): DeviceInfo {
        return DeviceInfo(
            deviceId = token.deviceId,
            deviceName = token.deviceName,
            certificateFingerprint = token.certificateFingerprint
        )
    }
}

sealed class ValidationResult {
    object Valid : ValidationResult()
    data class InvalidVersion(val message: String) : ValidationResult()
    data class ExpiredQR(val message: String) : ValidationResult()
    data class FutureQR(val message: String) : ValidationResult()
}

data class DeviceInfo(
    val deviceId: String,
    val deviceName: String,
    val certificateFingerprint: String
)

class QRCodeParseException(message: String, cause: Throwable? = null) : Exception(message, cause)
