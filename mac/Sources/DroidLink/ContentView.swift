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
    
    private var tlsServer: TlsTcpServer?
    private var qrCodeGenerator = QRCodeGenerator()
    private var clipboardManager = ClipboardManager()
    
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
            // Generate device ID first
            let deviceId = UUID().uuidString
            
            // Start TLS server
            do {
                print("🌐 Starting TLS server on port 9999...")
                tlsServer = TlsTcpServer()
                try tlsServer?.start(port: 9999, deviceId: deviceId)
                print("✅ TLS server started")
            } catch {
                print("❌ Failed to start server: \(error)")
            }
            
            // Listen for clipboard changes from Android
            NotificationCenter.default.addObserver(
                forName: .droidlinkClipboardChanged,
                object: nil,
                queue: .main
            ) { [weak self] notification in
                if let clipboardContent = notification.object as? String {
                    print("📋 Setting clipboard from Android: \(clipboardContent)")
                    self?.clipboardManager.setContent(clipboardContent)
                }
            }
            
            // Start monitoring Mac clipboard for changes to send to Android
            startClipboardWatcher()
            
            // Generate QR code
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
        tlsServer?.stop()
    }
    
    func disconnect() {
        print("🔌 Disconnecting")
        state = .disconnected
        tlsServer?.stop()
    }
    
    private func startClipboardWatcher() {
        Task {
            var lastClipboard = clipboardManager.getContent()
            while true {
                try? await Task.sleep(nanoseconds: 500_000_000) // 0.5s
                let currentClipboard = clipboardManager.getContent()
                if currentClipboard != lastClipboard && !currentClipboard.isEmpty {
                    print("📋 Mac clipboard changed: \(currentClipboard)")
                    lastClipboard = currentClipboard
                    tlsServer?.broadcast("CLIPBOARD:\(currentClipboard)")
                }
            }
        }
    }
}

enum ConnectionState {
    case disconnected
    case pairing
    case connecting
    case connected(String)
}