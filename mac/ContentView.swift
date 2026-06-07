import SwiftUI

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
                
            case .connecting:
                ProgressView()
                Text("Connecting...")
                    .font(.caption)
                    .foregroundStyle(.secondary)
                
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
    
    func startPairing() {
        state = .connecting
        
        Task {
            // TODO: Implement QR code pairing flow
            // 1. Generate QR code
            // 2. Wait for Android to scan
            // 3. Exchange certificates
            // 4. Establish TLS connection
            
            // For now, simulate connection
            try? await Task.sleep(nanoseconds: 2_000_000_000)
            state = .connected("Android Phone")
        }
    }
    
    func disconnect() {
        // TODO: Implement disconnect
        state = .disconnected
    }
}

enum ConnectionState {
    case disconnected
    case connecting
    case connected(String) // device name
}
