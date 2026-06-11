import Foundation
import Network

/// Simple TCP server for receiving connections from Android
@MainActor
public class TcpServer {
    private var listener: NWListener?
    private var connections: [NWConnection] = []
    
    public init() {}
    
    /// Start the server on the specified port
    public func start(port: UInt16) throws {
        let parameters = NWParameters.tcp
        parameters.allowLocalEndpointReuse = true
        parameters.allowFastOpen = true
        
        listener = try NWListener(using: parameters, on: NWEndpoint.Port(rawValue: port)!)
        
        listener?.newConnectionHandler = { [weak self] connection in
            print("📱 New connection from \(connection.endpoint)")
            Task { @MainActor in
                self?.handleConnection(connection)
            }
        }
        
        listener?.start(queue: .main)
        print("🚀 Server listening on port \(port)")
    }
    
    private func handleConnection(_ connection: NWConnection) {
        connections.append(connection)
        
        connection.stateUpdateHandler = { state in
            switch state {
            case .ready:
                print("✅ Connection ready")
                Task { @MainActor in
                    self.receiveMessage(from: connection)
                }
            case .failed(let error):
                print("❌ Connection failed: \(error)")
            case .waiting(let error):
                print("⏳ Connection waiting: \(error)")
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
                    NotificationCenter.default.post(name: .messageReceived, object: message)
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
    }
}

extension NSNotification.Name {
    static let messageReceived = NSNotification.Name("messageReceived")
}