import Foundation
import SwiftProtobuf

/// Frames and deframes Protocol Buffer messages with a 4-byte header.
///
/// Frame format:
/// ┌────────────────────────────────────────┐
/// │  Header (4 bytes)                        │
/// │  ├─ Length (3 bytes, big-endian)        │
/// │  └─ Type (1 byte)                       │
/// ├────────────────────────────────────────┤
/// │  Protobuf Message (variable length)     │
/// └────────────────────────────────────────┘
public class MessageFramer {
    
    public enum FrameType: UInt8 {
        case data = 0x01
        case heartbeat = 0x02
        case error = 0x03
    }
    
    private let headerSize = 4
    private let maxFrameSize = 16 * 1024 * 1024 // 16MB
    
    public init() {}
    
    /// Frame a Protocol Buffer message with a 4-byte header.
    public func frame(_ message: Data) throws -> Data {
        let length = message.count
        
        guard length <= maxFrameSize else {
            throw FramingError.messageTooLarge(length)
        }
        
        var frame = Data(capacity: headerSize + length)
        
        // Write length (3 bytes, big-endian)
        frame.append(UInt8((length >> 16) & 0xFF))
        frame.append(UInt8((length >> 8) & 0xFF))
        frame.append(UInt8(length & 0xFF))
        
        // Write type
        frame.append(FrameType.data.rawValue)
        
        // Write payload
        frame.append(message)
        
        return frame
    }
    
    /// Frame a heartbeat ping.
    public func frameHeartbeat() -> Data {
        var frame = Data(capacity: headerSize)
        // Length is 0
        frame.append(0)
        frame.append(0)
        frame.append(0)
        // Type is heartbeat
        frame.append(FrameType.heartbeat.rawValue)
        return frame
    }
    
    /// Deframe messages from a data buffer.
    /// Returns array of complete messages.
    public func deframe(from buffer: inout Data) throws -> [Data] {
        var messages: [Data] = []
        
        while buffer.count >= headerSize {
            // Read length (3 bytes, big-endian)
            let b1 = Int(buffer[0])
            let b2 = Int(buffer[1])
            let b3 = Int(buffer[2])
            let length = (b1 << 16) | (b2 << 8) | b3
            
            // Read type
            let typeCode = buffer[3]
            guard let type = FrameType(rawValue: typeCode) else {
                throw FramingError.invalidFrameType(Int(typeCode))
            }
            
            // Validate length
            guard length <= maxFrameSize else {
                throw FramingError.messageTooLarge(length)
            }
            
            // Check if we have enough data
            let totalSize = headerSize + length
            guard buffer.count >= totalSize else {
                // Not enough data yet, wait for more
                break
            }
            
            // Remove header from buffer
            buffer.removeFirst(headerSize)
            
            switch type {
            case .heartbeat:
                // Heartbeat, no payload
                continue
                
            case .error:
                // Error frame
                let payload = buffer.prefix(length)
                buffer.removeFirst(length)
                let errorMessage = String(data: payload, encoding: .utf8) ?? "Unknown error"
                throw FramingError.remoteError(errorMessage)
                
            case .data:
                // Data frame
                let payload = buffer.prefix(length)
                buffer.removeFirst(length)
                messages.append(payload)
            }
        }
        
        return messages
    }
}

public enum FramingError: Error {
    case messageTooLarge(Int)
    case invalidFrameType(Int)
    case remoteError(String)
}
