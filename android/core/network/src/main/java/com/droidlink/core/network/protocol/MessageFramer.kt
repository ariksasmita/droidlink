package com.droidlink.core.network.protocol

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Frames and deframes Protocol Buffer messages with a 4-byte header.
 * 
 * Frame format:
 * ┌────────────────────────────────────────┐
 * │  Header (4 bytes)                        │
 * │  ├─ Length (3 bytes, big-endian)        │
 * │  └─ Type (1 byte)                       │
 * ├────────────────────────────────────────┤
 * │  Protobuf Message (variable length)     │
 * └────────────────────────────────────────┘
 */
class MessageFramer {
    
    companion object {
        private const val HEADER_SIZE = 4
        private const val MAX_FRAME_SIZE = 16 * 1024 * 1024 // 16MB
    }
    
    enum class FrameType(val code: Int) {
        DATA(0x01),
        HEARTBEAT(0x02),
        ERROR(0x03);
        
        companion object {
            fun fromCode(code: Int): FrameType? {
                return values().find { it.code == code }
            }
        }
    }
    
    /**
     * Frame a Protocol Buffer message with a 4-byte header.
     */
    fun frame(message: ByteArray): ByteArray {
        val length = message.size
        
        require(length <= MAX_FRAME_SIZE) {
            "Message too large: $length bytes (max $MAX_FRAME_SIZE)"
        }
        
        val frame = ByteArray(HEADER_SIZE + length)
        
        // Write length (3 bytes, big-endian)
        frame[0] = (length shr 16).toByte()
        frame[1] = (length shr 8).toByte()
        frame[2] = length.toByte()
        
        // Write type
        frame[3] = FrameType.DATA.code.toByte()
        
        // Write payload
        System.arraycopy(message, 0, frame, HEADER_SIZE, length)
        
        return frame
    }
    
    /**
     * Frame a heartbeat ping.
     */
    fun frameHeartbeat(): ByteArray {
        val frame = ByteArray(HEADER_SIZE)
        // Length is 0
        frame[3] = FrameType.HEARTBEAT.code.toByte()
        return frame
    }
    
    /**
     * Deframe messages from a byte buffer.
     * Returns a Flow of complete messages as they become available.
     */
    fun deframe(buffer: ByteBuffer): Flow<ByteArray> {
        val messages = MutableSharedFlow<ByteArray>(replay = 0, extraBufferCapacity = 64)
        buffer.order(ByteOrder.BIG_ENDIAN)
        
        while (buffer.remaining() >= HEADER_SIZE) {
            // Mark current position
            buffer.mark()
            
            // Read length (3 bytes, big-endian)
            val b1 = buffer.get().toInt() and 0xFF
            val b2 = buffer.get().toInt() and 0xFF
            val b3 = buffer.get().toInt() and 0xFF
            val length = (b1 shl 16) or (b2 shl 8) or b3
            
            // Read type
            val typeCode = buffer.get().toInt() and 0xFF
            val type = FrameType.fromCode(typeCode)
            
            // Validate length
            if (length > MAX_FRAME_SIZE) {
                buffer.reset()
                throw FrameException("Frame too large: $length bytes (max $MAX_FRAME_SIZE)")
            }
            
            when (type) {
                FrameType.HEARTBEAT -> {
                    // Heartbeat, no payload
                    continue
                }
                FrameType.ERROR -> {
                    // Error frame
                    if (buffer.remaining() < length) {
                        buffer.reset()
                        break // Not enough data yet
                    }
                    val payload = ByteArray(length)
                    buffer.get(payload)
                    throw FrameException("Remote error: ${String(payload)}")
                }
                FrameType.DATA -> {
                    // Data frame
                    if (buffer.remaining() < length) {
                        buffer.reset()
                        break // Not enough data yet
                    }
                    val payload = ByteArray(length)
                    buffer.get(payload)
                    messages.tryEmit(payload)
                }
                null -> {
                    buffer.reset()
                    throw FrameException("Unknown frame type: $typeCode")
                }
            }
        }
        
        return messages.asSharedFlow()
    }
    
    /**
     * Create a buffer for accumulating incoming data.
     */
    fun createBuffer(): ByteBuffer {
        return ByteBuffer.allocate(MAX_FRAME_SIZE + HEADER_SIZE).order(ByteOrder.BIG_ENDIAN)
    }
}

class FrameException(message: String) : Exception(message)
