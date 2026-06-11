import Foundation
import Security
import CommonCrypto

/// Simplified TLS certificate generator for Mac (MVP version)
class TlsCertificateGenerator {
    
    /// Generate a certificate fingerprint for display
    func getCertificateFingerprint(_ deviceId: String) -> String {
        // For MVP, generate a SHA256 hash based on device ID
        let data = ("DROIDLINK-" + deviceId).data(using: .utf8)!
        let digest = data.sha256()
        return digest.map { String(format: "%02X", $0) }.joined(separator: ":")
    }
    
    /// Generate a simple fingerprint (placeholder for MVP)
    func generateFingerprint() -> String {
        let timestamp = String(Date().timeIntervalSince1970)
        let data = ("DROIDLINK-" + timestamp).data(using: .utf8)!
        let digest = data.sha256()
        return digest.map { String(format: "%02X", $0) }.joined(separator: ":")
    }
}

extension Data {
    func sha256() -> Data {
        var hash = [UInt8](repeating: 0, count: Int(CC_SHA256_DIGEST_LENGTH))
        self.withUnsafeBytes {
            _ = CC_SHA256($0.baseAddress, CC_LONG(self.count), &hash)
        }
        return Data(hash)
    }
}