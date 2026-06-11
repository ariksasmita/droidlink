import Foundation
import Network

/// Simplified TLS-enabled TCP server for MVP
@MainActor
public class TlsTcpServer {
    private var listener: NWListener?
    private var connections: [NWConnection] = []
    private var certGenerator = TlsCertificateGenerator()
    private var serverFingerprint: String?
    
    /// Start the server on the specified port
    public func start(port: UInt16, deviceId: String) throws {
        print("🔐 Starting TLS server on port \(port)")
        
        // Generate server certificate fingerprint
        self.serverFingerprint = certGenerator.getCertificateFingerprint(deviceId)
        print("🔑 Server fingerprint: \(serverFingerprint!)")
        
        let parameters = NWParameters.tcp
        parameters.allowLocalEndpointReuse = true
        parameters.allowFastOpen = true
        
        listener = try NWListener(using: parameters, on: NWEndpoint.Port(rawValue: port)!)
        
        listener?.newConnectionHandler = { [weak self] connection in
            print("📱 New TLS connection from \(connection.endpoint)")
            Task { @MainActor in
                self?.handleConnection(connection)
            }
        }
        
        listener?.start(queue: .main)
        print("🚀 TLS server listening on port \(port)")
    }
    
    private func handleConnection(_ connection: NWConnection) {
        connections.append(connection)
        
        connection.stateUpdateHandler = { state in
            switch state {
            case .ready:
                print("✅ TLS connection ready")
                Task { @MainActor in
                    self.receiveMessage(from: connection)
                }
            case .failed(let error):
                print("❌ TLS connection failed: \(error)")
            case .waiting(let error):
                print("⏳ TLS connection waiting: \(error)")
            default:
                break
            }
        }
        
        connection.start(queue: .main)
    }
    
    private func receiveMessage(from connection: NWConnection) {
        connection.receive(minimumIncompleteLength: 1, maximumLength: 65536) { data, _, isComplete, error in
            if let data = data, !data.isEmpty {
                let message = String(data: data, encoding: .utf8) ?? "Unable to decode"
                print("📩 Received: \(message)")
                
                DispatchQueue.main.async {
                    NotificationCenter.default.post(
                        name: .messageReceived,
                        object: message
                    )
                }
                
                // Send response
                let response = "Hello from Mac! Received: \(message)".data(using: .utf8)
                if let response = response {
                    connection.send(content: response, completion: .contentProcessed { _ in
                        // Continue receiving
                        Task { @MainActor in
                            self.receiveMessage(from: connection)
                        }
                    })
                }
            }
        }
    }

    /// Stop the server
    public func stop() {
        connections.forEach { $0.cancel() }
        connections.removeAll()
        listener?.cancel()
        listener = nil
        print("🔌 TLS server stopped")
    }
    
    /// Get server certificate fingerprint for display in QR code
    public func getServerCertificateFingerprint() -> String {
        return serverFingerprint ?? certGenerator.generateFingerprint()
    }
    
    public init() {}
}