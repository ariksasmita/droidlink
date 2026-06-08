import Foundation
import CoreImage
import CoreImage.CIFilterBuiltins
import SwiftUI
import CryptoKit

/// QR code generator for device pairing
public class QRCodeGenerator {
    
    private let context = CIContext()
    
    public init() {}
    
    /// Generate QR code for pairing
    /// - Parameters:
    ///   - deviceId: Unique device ID
    ///   - deviceName: Human-readable device name
    ///   - certificateFingerprint: Certificate fingerprint for validation
    /// - Returns: QR code image
    public func generateQRCode(
        deviceId: String,
        deviceName: String,
        certificateFingerprint: String
    ) -> UIImage? {
        // Create pairing token
        let token = PairingToken(
            version: "1.0.0",
            deviceId: deviceId,
            deviceName: deviceName,
            certificateFingerprint: certificateFingerprint,
            timestamp: Int(Date().timeIntervalSince1970)
        )
        
        // Encode token as JSON
        guard let tokenData = try? JSONEncoder().encode(token),
              let tokenString = String(data: tokenData, encoding: .utf8) else {
            return nil
        }
        
        // Generate QR code
        let filter = CIFilter.qrCodeGenerator()
        filter.message = Data(tokenString.utf8)
        
        // Get output image
        guard let outputImage = filter.outputImage else {
            return nil
        }
        
        // Scale up for better quality
        let scaleX = 200.0 / outputImage.extent.width
        let scaleY = 200.0 / outputImage.extent.height
        let scaledImage = outputImage.transformed(by: CGAffineTransform(scaleX: scaleX, y: scaleY))
        
        // Convert to CGImage
        guard let cgImage = context.createCGImage(scaledImage, from: scaledImage.extent) else {
            return nil
        }
        
        return UIImage(cgImage: cgImage)
    }
}

/// Pairing token encoded in QR code
public struct PairingToken: Codable {
    public let version: String
    public let deviceId: String
    public let deviceName: String
    public let certificateFingerprint: String
    public let timestamp: Int
}
