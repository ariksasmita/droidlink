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
                VStack(spacing: 16) {
                    ProgressView()
                    Text("Connecting...")
                        .font(.caption)
                        .foregroundStyle(.secondary)
                }
                
            case .connected(let deviceName):
                VStack {
                    Text("Connected to \(deviceName)")
                        .font(.headline)
                    if let message = viewModel.lastMessage {
                        Text("Last message: \(message)")
                            .font(.caption)
                            .foregroundColor(.secondary)
                    }
                    Button("Disconnect") {
                        viewModel.disconnect()
                    }
                    .buttonStyle(.bordered)
                }
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
    @Published var lastMessage: String? = nil
    
    private var tcpServer: TcpServer?
    private var qrCodeGenerator = QRCodeGenerator()
    
    init() {
        print("🎨 ContentViewModel initialized")
        // Auto-start pairing for testing
        Task {
            try? await Task.sleep(nanoseconds: 2_000_000_000) // 2 seconds
            startPairing()
        }
    }
    
    func startPairing() {
        print("🚀 Starting pairing process...")
        state = .pairing
        qrCode = nil
        
        Task {
            // Start TCP server
            do {
                print("🌐 Starting TCP server on port 9999...")
                tcpServer = TcpServer()
                try tcpServer?.start(port: 9999)
                print("✅ TCP server started")
            } catch {
                print("❌ Failed to start server: \(error)")
            }
            
            // Generate QR code
            let deviceId = UUID().uuidString
            let deviceName = Host.current().localizedName ?? "Mac"
            let fingerprint = String((0..<64).map { _ in "0123456789abcdef".randomElement()! })
            
            let qr = qrCodeGenerator.generateQRCode(
                deviceId: deviceId,
                deviceName: deviceName,
                certificateFingerprint: fingerprint
            )
            
            self.qrCode = qr
            print("✅ QR code ready for scanning")
        }
    }
    
    func cancelPairing() {
        print("❌ Pairing cancelled")
        state = .disconnected
        qrCode = nil
        lastMessage = nil
        tcpServer?.stop()
    }
    
    func disconnect() {
        print("🔌 Disconnecting")
        state = .disconnected
        tcpServer?.stop()
    }
}

enum ConnectionState {
    case disconnected
    case pairing
    case connecting
    case connected(String)
}