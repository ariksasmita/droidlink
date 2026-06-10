import SwiftUI
import AppKit
import DroidLinkKit

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
                        ProgressView()
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
    
    private var certificateGenerator = CertificateGenerator()
    private var qrCodeGenerator = QRCodeGenerator()
    
    func startPairing() {
        state = .pairing
        
        Task {
            do {
                // Generate certificate
                let (certificate, _, fingerprint) = try certificateGenerator.generateCertificate()
                
                // Store certificate
                try certificateGenerator.storeCertificate(certificate)
                
                // Get device info
                let deviceId = getCurrentDeviceId()
                let deviceName = getCurrentDeviceName()
                
                // Generate QR code
                await MainActor.run {
                    self.qrCode = self.qrCodeGenerator.generateQRCode(
                        deviceId: deviceId,
                        deviceName: deviceName,
                        certificateFingerprint: fingerprint
                    )
                }
                
                // Wait for Android to scan (timeout after 5 minutes)
                try await Task.sleep(nanoseconds: 300_000_000_000)
                
                // If no scan, cancel pairing
                await MainActor.run {
                    self.state = .disconnected
                    self.qrCode = nil
                }
                
            } catch {
                print("Error generating certificate: \(error)")
                await MainActor.run {
                    self.state = .disconnected
                    self.qrCode = nil
                }
            }
        }
    }
    
    func cancelPairing() {
        state = .disconnected
        qrCode = nil
    }
    
    func disconnect() {
        // TODO: Implement disconnect
        state = .disconnected
    }
    
    private func getCurrentDeviceId() -> String {
        var size: Int = 0
        sysctlbyname("hw.uuid", nil, &size, nil, 0)
        var uuid = [CChar](repeating: 0, count: size)
        sysctlbyname("hw.uuid", &uuid, &size, nil, 0)
        return String(cString: uuid)
    }
    
    private func getCurrentDeviceName() -> String {
        let host = ProcessInfo.processInfo.hostName
        return Host.current().localizedName ?? host
    }
}

enum ConnectionState {
    case disconnected
    case pairing
    case connecting
    case connected(String) // device name
}