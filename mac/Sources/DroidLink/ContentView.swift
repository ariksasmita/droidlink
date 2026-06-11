import SwiftUI
import AppKit
import DroidLinkKit
import Foundation

struct ContentView: View {
    @StateObject private var viewModel = ContentViewModel()
    
    var body: some View {
        VStack(spacing: 20) {
            Image(systemName: "iphone.and.arrow.forward")
                .font(.system(size: 60))
                .foregroundStyle(.blue)
            
            Text("DroidLink")
                .font(.largeTitle)
                .bold()
            
            Text("Free, local-first Android ↔ Mac integration")
                .font(.body)
                .multilineTextAlignment(.center)
                .foregroundColor(.secondary)
            
            switch viewModel.state {
            case .disconnected:
                Button("Pair Device") {
                    viewModel.startPairing()
                }
                .buttonStyle(.borderedProminent)
                
            case .pairing:
                VStack(spacing: 16) {
                    Text("Scan QR code on Android device")
                        .font(.headline)
                    
                    if let qrCode = viewModel.qrCode {
                        Image(nsImage: qrCode)
                            .interpolation(.none)
                            .resizable()
                            .scaledToFit()
                            .frame(width: 250, height: 250)
                            .padding()
                            .background(Color.white)
                            .cornerRadius(12)
                            .shadow(radius: 5)
                    } else {
                        ProgressView("Generating QR code...")
                            .frame(width: 250, height: 250)
                    }
                    
                    Button("Cancel") {
                        viewModel.cancelPairing()
                    }
                    .buttonStyle(.bordered)
                }
                
            case .connecting:
                ProgressView("Connecting...")
                
            case .connected(let deviceName):
                Text("Connected to \(deviceName)")
                    .font(.headline)
                Button("Disconnect") {
                    viewModel.disconnect()
                }
                .buttonStyle(.bordered)
            }
        }
        .padding()
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

@MainActor
class ContentViewModel: ObservableObject {
    @Published var state: ConnectionState = .disconnected
    @Published var qrCode: NSImage? = nil
    
    func startPairing() {
        state = .pairing
        qrCode = nil
        
        Task {
            // Simplified - just generate QR code directly
            let generator = QRCodeGenerator()
            let deviceId = UUID().uuidString
            let deviceName = Host.current().localizedName ?? "Mac"
            let fingerprint = String((0..<64).map { _ in "0123456789abcdef".randomElement()! })
            
            let qr = generator.generateQRCode(
                deviceId: deviceId,
                deviceName: deviceName,
                certificateFingerprint: fingerprint
            )
            
            await MainActor.run {
                self.qrCode = qr
            }
        }
    }
    
    func cancelPairing() {
        state = .disconnected
        qrCode = nil
    }
    
    func disconnect() {
        state = .disconnected
    }
}

enum ConnectionState {
    case disconnected
    case pairing
    case connecting
    case connected(String)
}