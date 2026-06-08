import Foundation
import Security
import CryptoKit

/// Certificate generator for secure pairing
public class CertificateGenerator {
    
    public enum CertificateError: Error {
        case generationFailed
        case storageFailed(OSStatus)
        case retrievalFailed(OSStatus)
    }
    
    public init() {}
    
    /// Generate a self-signed certificate for this device
    /// - Returns: Certificate and private key pair
    public func generateCertificate() throws -> (certificate: SecCertificate, privateKey: SecKey, fingerprint: String) {
        // Create certificate subject
        let deviceId = UUID().uuidString
        let commonName = "DroidLink-\(deviceId)"
        
        // Create key pair
        var publicKey: SecKey?
        var privateKey: SecKey?
        
        let keyPairAttributes: [String: Any] = [
            kSecAttrKeyType as String: kSecAttrKeyTypeRSA,
            kSecAttrKeySizeInBits as String: 2048,
            kSecPrivateKeyAttrs as String: [
                kSecAttrIsPermanent as String: false
            ]
        ]
        
        let status = SecKeyGeneratePair(
            keyPairAttributes as CFDictionary,
            &publicKey,
            &privateKey
        )
        
        guard status == errSecSuccess,
              let pubKey = publicKey,
              let privKey = privateKey else {
            throw CertificateError.generationFailed
        }
        
        // Create certificate
        let certificate = try createCertificate(
            publicKey: pubKey,
            privateKey: privKey,
            commonName: commonName,
            deviceId: deviceId
        )
        
        // Calculate fingerprint
        let fingerprint = calculateFingerprint(certificate: certificate)
        
        return (certificate, privKey, fingerprint)
    }
    
    /// Store certificate in Keychain
    public func storeCertificate(_ certificate: SecCertificate) throws {
        let data = SecCertificateCopyData(certificate) as Data
        
        let query: [String: Any] = [
            kSecClass as String: kSecClassCertificate,
            kSecValueRef as String: data,
            kSecAttrLabel as String: "DroidLink Device Certificate",
            kSecReturnData as String: false
        ]
        
        // Delete existing certificate first
        SecItemDelete(query as CFDictionary)
        
        // Add new certificate
        let status = SecItemAdd(query as CFDictionary, nil)
        guard status == errSecSuccess else {
            throw CertificateError.storageFailed(status)
        }
    }
    
    /// Retrieve certificate from Keychain
    public func retrieveCertificate() throws -> SecCertificate {
        let query: [String: Any] = [
            kSecClass as String: kSecClassCertificate,
            kSecAttrLabel as String: "DroidLink Device Certificate",
            kSecReturnRef as String: true
        ]
        
        var result: CFTypeRef?
        let status = SecItemCopyMatching(query as CFDictionary, &result)
        
        guard status == errSecSuccess,
              let certificate = result as? SecCertificate else {
            throw CertificateError.retrievalFailed(status)
        }
        
        return certificate
    }
    
    // MARK: - Private Helpers
    
    private func createCertificate(
        publicKey: SecKey,
        privateKey: SecKey,
        commonName: String,
        deviceId: String
    ) throws -> SecCertificate {
        // Note: Full X.509 certificate creation requires Security framework
        // For now, we'll create a simple certificate using SecKeyCreateSignature
        
        // In a real implementation, you would use Certificate Signing Request (CSR)
        // or a proper certificate library. For MVP, we'll use a simplified approach.
        
        throw CertificateError.generationFailed
    }
    
    private func calculateFingerprint(certificate: SecCertificate) -> String {
        let data = SecCertificateCopyData(certificate) as Data
        let digest = SHA256.hash(data: data)
        return digest.compactMap { String(format: "%02x", $0) }.joined()
    }
}
