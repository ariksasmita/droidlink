# DroidLink Protocol Specification

**Binary protocol for local Android ↔ Mac device communication**

---

## Table of Contents
1. [Overview](#overview)
2. [Transport Layer](#transport-layer)
3. [Message Framing](#message-framing)
4. [Protocol Buffer Schemas](#protocol-buffer-schemas)
5. [Feature Protocols](#feature-protocols)
6. [Versioning & Compatibility](#versioning--compatibility)

---

## Overview

DroidLink uses a **binary protocol built on Protocol Buffers** for efficient, backward-compatible communication between Android and Mac devices.

### Design Goals

1. **Efficiency**: Minimal overhead, binary serialization
2. **Backward Compatibility**: Old clients work with new servers
3. **Forward Compatibility**: New fields don't break old clients
4. **Type Safety**: Strongly typed messages
5. **Extensibility**: Easy to add new message types

### Protocol Stack

```
┌─────────────────────────────────────────┐
│   Application Layer                     │
│   (Clipboard, Notifications, etc.)     │
├─────────────────────────────────────────┤
│   Protocol Buffer Layer                 │
│   (Message serialization)               │
├─────────────────────────────────────────┤
│   Framing Layer                         │
│   (Message length prefix + type)        │
├─────────────────────────────────────────┤
│   Transport Layer                       │
│   (TCP over USB or Wi-Fi)               │
├─────────────────────────────────────────┤
│   TLS Layer                             │
│   (Encryption + authentication)         │
└─────────────────────────────────────────┘
```

---

## Transport Layer

### Connection Types

1. **USB (Android Open Accessory)**
   - Maximum speed (~200Mbps theoretical)
   - Zero latency
   - Works without Wi-Fi
   - Preferred for large file transfers

2. **Wi-Fi (Local Network)**
   - Wireless freedom
   - Same network requirement
   - Supports Wi-Fi Direct (device-to-device without router)
   - Falls back from USB when unplugged

### Connection Establishment

```
1. Device Discovery (mDNS/Bonjour)
   │
   ├─ Mac registers Bonjour service: _droidlink._tcp
   │  └─ TXT record: device_id, protocol_version
   │
   └─ Android discovers service via NSD API

2. TLS Handshake
   │
   ├─ Mac presents certificate
   ├─ Android validates against stored fingerprint
   ├─ Android presents certificate
   ├─ Mac validates against stored fingerprint
   └─ TLS 1.3 connection established

3. Protocol Handshake
   │
   ├─ Android sends HelloMessage (protocol_version, device_info)
   ├─ Mac responds with HelloAck (server_info, supported_features)
   └─ Connection ready for feature messages
```

### Connection States

```kotlin
enum class ConnectionState {
    DISCONNECTED,
    CONNECTING,        // During TLS handshake
    CONNECTED,         // TLS established
    AUTHENTICATED,     // Protocol handshake complete
    RECONNECTING,     // Attempting reconnect
    ERROR             // Fatal error
}
```

---

## Message Framing

### Frame Format

Every message is framed with a 4-byte header followed by the serialized Protocol Buffer payload:

```
┌───────────────────────────────────────────────────────────┐
│  Frame Header (4 bytes)                                  │
│  ├─ Length (3 bytes, big-endian, max 16MB)               │
│  └─ Type (1 byte)                                         │
│      ├─ 0x01: DATA (normal Protocol Buffer message)      │
│      ├─ 0x02: HEARTBEAT (keep-alive ping)                │
│      └─ 0x03: ERROR (error notification)                  │
├───────────────────────────────────────────────────────────┤
│  Protocol Buffer Message (variable length, up to 16MB)    │
│  └─ Serialized DroidLinkMessage                         │
└───────────────────────────────────────────────────────────┘
```

### Type Field

| Value | Type | Description |
|-------|------|-------------|
| 0x01 | DATA | Normal Protocol Buffer message |
| 0x02 | HEARTBEAT | Keep-alive ping (empty payload) |
| 0x03 | ERROR | Error occurred (contains ErrorMessage) |

### Framing Implementation

```kotlin
// Android (Kotlin)
class MessageFramer {
    companion object {
        private const val HEADER_SIZE = 4
        private const val MAX_FRAME_SIZE = 16 * 1024 * 1024 // 16MB
    }

    fun frame(message: DroidLinkMessage): ByteArray {
        val serialized = message.toByteArray()
        val length = serialized.size

        require(length <= MAX_FRAME_SIZE) {
            "Message too large: $length bytes (max $MAX_FRAME_SIZE)"
        }

        val frame = ByteArray(HEADER_SIZE + length)

        // Write length (3 bytes, big-endian)
        frame[0] = (length shr 16).toByte()
        frame[1] = (length shr 8).toByte()
        frame[2] = length.toByte()

        // Write type
        frame[3] = FrameType.DATA.code

        // Write payload
        System.arraycopy(serialized, 0, frame, HEADER_SIZE, length)

        return frame
    }

    fun deframe(buffer: ByteBuffer): DroidLinkMessage? {
        if (buffer.remaining() < HEADER_SIZE) return null

        // Read length
        val length = ((buffer[0].toInt() and 0xFF) shl 16) or
                     ((buffer[1].toInt() and 0xFF) shl 8) or
                     (buffer[2].toInt() and 0xFF)

        // Read type
        val typeCode = buffer[3].toInt() and 0xFF
        val type = FrameType.fromCode(typeCode)

        if (buffer.remaining() < length) return null

        // Read payload
        val payload = ByteArray(length)
        buffer.get(payload)

        return when (type) {
            FrameType.DATA -> DroidLinkMessage.parseFrom(payload)
            FrameType.HEARTBEAT -> null // Handled elsewhere
            FrameType.ERROR -> throw ErrorException(
                ErrorMessage.parseFrom(payload)
            )
        }
    }
}

enum class FrameType(val code: Int) {
    DATA(0x01),
    HEARTBEAT(0x02),
    ERROR(0x03);

    companion object {
        fun fromCode(code: Int): FrameType {
            return values().find { it.code == code }
                ?: throw IllegalArgumentException("Unknown frame type: $code")
        }
    }
}
```

```swift
// Mac (Swift)
class MessageFramer {
    private let headerSize = 4
    private let maxFrameSize = 16 * 1024 * 1024 // 16MB

    func frame(message: DroidLinkMessage) throws -> Data {
        let serialized = try message.serializedData()
        let length = serialized.count

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
        frame.append(serialized)

        return frame
    }

    func deframe(from buffer: inout ByteBuffer) throws -> DroidLinkMessage? {
        guard buffer.readableBytes >= headerSize else { return nil }

        // Peek at length
        let length = try buffer.peekBytes(at: 0, length: 3).reduce(0) {
            ($0 << 8) + Int($1)
        }

        guard buffer.readableBytes >= headerSize + length else { return nil }

        // Skip header
        buffer.skip(length: headerSize)

        // Read payload
        let payload = try buffer.readBytes(length: length)

        return try DroidLinkMessage(serializedData: payload)
    }
}

enum FrameType: UInt8 {
    case data = 0x01
    case heartbeat = 0x02
    case error = 0x03
}
```

---

## Protocol Buffer Schemas

### Root Message

```proto
syntax = "proto3";

package droidlink.protocol;

// Root message type for all DroidLink communication
message DroidLinkMessage {
  uint64 id = 1;                    // Unique message ID (timestamp-based)
  uint64 timestamp = 2;             // Unix timestamp (milliseconds)
  MessageType type = 3;             // Message type

  oneof payload {
    ClipboardMessage clipboard = 10;
    NotificationMessage notification = 11;
    FileMessage file = 12;
    ScreenMessage screen = 13;
    MediaMessage media = 14;
    CallMessage call = 15;
    SystemMessage system = 16;
  }
}

enum MessageType {
  UNKNOWN = 0;
  CLIPBOARD_SYNC = 1;
  NOTIFICATION_MIRROR = 2;
  FILE_TRANSFER = 3;
  SCREEN_STREAM = 4;
  WEBCAM_STREAM = 5;
  AUDIO_STREAM = 6;
  CALL_EVENT = 7;
  SYSTEM = 8;
}
```

### System Messages

```proto
// Connection lifecycle messages
message SystemMessage {
  enum SystemEventType {
    UNKNOWN = 0;
    HELLO = 1;           // Initial handshake
    HELLO_ACK = 2;       // Handshake acknowledgment
    HEARTBEAT = 3;       // Keep-alive ping
    GOODBYE = 4;         // Graceful disconnect
    ERROR = 5;           // Error notification
  }

  SystemEventType event = 1;

  // For HELLO
  HelloMessage hello = 10;

  // For HELLO_ACK
  HelloAckMessage hello_ack = 11;

  // For ERROR
  ErrorMessage error = 12;
}

message HelloMessage {
  string protocol_version = 1;      // e.g., "1.0.0"
  string device_id = 2;             // Unique device ID
  string device_name = 3;           // User-friendly name
  DeviceType device_type = 4;       // Android or Mac/iPad
  repeated string supported_features = 5; // Feature list
  string certificate_fingerprint = 6; // For validation
}

message HelloAckMessage {
  string protocol_version = 1;
  string device_id = 2;
  string device_name = 3;
  DeviceType device_type = 4;
  repeated string supported_features = 5;
}

message ErrorMessage {
  ErrorCode code = 1;
  string message = 2;
  string details = 3;
}

enum DeviceType {
  UNKNOWN = 0;
  ANDROID = 1;
  MAC = 2;
  IPAD = 3;
  IPHONE = 4;
}

enum ErrorCode {
  UNKNOWN_ERROR = 0;
  CONNECTION_FAILED = 1;
  AUTHENTICATION_FAILED = 2;
  PROTOCOL_MISMATCH = 3;
  FEATURE_NOT_SUPPORTED = 4;
  PERMISSION_DENIED = 5;
  RESOURCE_UNAVAILABLE = 6;
}
```

---

## Feature Protocols

### 1. Clipboard Sync

```proto
message ClipboardMessage {
  ClipboardData data = 1;
  string source_device_id = 2;
  bool is_remote = 3;               // True if from other device
}

message ClipboardData {
  DataType type = 1;
  string text = 2;
  bytes image_data = 3;             // PNG or JPEG
  string url = 4;
  int64 timestamp = 5;              // When copied
}

enum DataType {
  UNKNOWN = 0;
  TEXT = 1;
  IMAGE = 2;
  URL = 3;
}
```

**Flow**:
1. Android clipboard change detected
2. Send `ClipboardMessage` to Mac
3. Mac updates `NSPasteboard`
4. Same flow in reverse for Mac → Android

---

### 2. Notification Mirror

```proto
message NotificationMessage {
  enum NotificationEventType {
    POSTED = 1;           // New notification
    UPDATED = 2;          // Existing notification updated
    REMOVED = 3;          // Notification removed
    ACTION_CLICKED = 4;   // User tapped action
  }

  NotificationEventType event = 1;

  // For POSTED, UPDATED
  NotificationData notification = 2;

  // For REMOVED
  string notification_id = 3;

  // For ACTION_CLICKED
  string action_id = 4;
  string action_reply_text = 5;    // For reply actions
}

message NotificationData {
  string id = 1;                    // Android notification ID
  string package_name = 2;          // e.g., "com.whatsapp"
  string app_name = 3;              // e.g., "WhatsApp"
  string title = 4;
  string text = 5;
  repeated NotificationAction actions = 6;
  int64 timestamp = 7;
  bytes icon = 8;                   // App icon (PNG, max 100KB)
  bool is_clearable = 9;           // Can be dismissed
  string category = 10;            // e.g., "msg", "call", "alarm"
  map<string, string> extras = 11; // Additional metadata
}

message NotificationAction {
  string id = 1;
  string label = 2;                 // e.g., "Reply", "Dismiss"
  ActionType type = 3;
}

enum ActionType {
  UNKNOWN = 0;
  REPLY = 1;                       // Text input action
  DISMISS = 2;                     // Dismiss notification
  CUSTOM = 3;                     // App-specific action
}
```

**Flow**:
1. Android `NotificationListenerService` detects notification
2. Send `NotificationMessage` (POSTED) to Mac
3. Mac displays native notification
4. User clicks action → Send `NotificationMessage` (ACTION_CLICKED) to Android
5. Android executes action via `NotificationManager`

---

### 3. File Transfer

```proto
message FileMessage {
  enum FileOperation {
    UNKNOWN = 0;
    LIST_REQUEST = 1;              // Request file listing
    LIST_RESPONSE = 2;             // File listing
    DOWNLOAD_REQUEST = 3;          // Request download
    DOWNLOAD_RESPONSE = 4;         // File chunk
    UPLOAD_REQUEST = 5;            // Push file
    UPLOAD_RESPONSE = 6;           // Acknowledge upload
    DELETE = 7;                    // Delete file
    ERROR = 8;                     // Error response
  }

  FileOperation operation = 1;

  // For LIST_REQUEST, DOWNLOAD_REQUEST
  string file_path = 2;

  // For LIST_RESPONSE
  repeated FileInfo files = 3;

  // For DOWNLOAD_REQUEST, DOWNLOAD_RESPONSE
  int64 file_size = 4;
  string mime_type = 5;
  bytes file_data = 6;             // Chunked data
  int32 chunk_index = 7;           // Chunk number (0-based)
  int32 total_chunks = 8;          // Total chunks
  string file_id = 9;              // Unique transfer ID

  // For ERROR
  string error_message = 10;
}

message FileInfo {
  string name = 1;
  string path = 2;
  int64 size = 3;
  int64 modified_time = 4;
  bool is_directory = 5;
  string mime_type = 6;
}
```

**Flow**:
1. Mac requests file listing (`LIST_REQUEST`)
2. Android responds with file list (`LIST_RESPONSE`)
3. Mac requests download (`DOWNLOAD_REQUEST` with chunk_index)
4. Android sends file chunk (`DOWNLOAD_RESPONSE`)
5. Repeat steps 3-4 until all chunks received

---

### 4. Screen Mirroring

```proto
message ScreenMessage {
  enum StreamEventType {
    START = 0;                     // Start streaming
    FRAME = 1;                     // Video frame
    STOP = 2;                      // Stop streaming
    PAUSE = 3;                     // Pause streaming
    RESUME = 4;                    // Resume streaming
    ERROR = 5;                     // Stream error
  }

  StreamEventType event = 1;

  // For START
  StreamConfig config = 2;

  // For FRAME
  bytes frame_data = 3;            // H.264 encoded frame
  int32 frame_number = 4;
  int64 timestamp = 5;
  bool is_keyframe = 6;            // Sync frame

  // For ERROR
  string error_message = 7;
}

message StreamConfig {
  int32 width = 1;                 // Video width
  int32 height = 2;                // Video height
  int32 fps = 3;                   // Target FPS
  int32 bitrate = 4;               // Bitrate (kbps)
  VideoCodec codec = 5;
}

enum VideoCodec {
  UNKNOWN = 0;
  H264 = 1;                        // H.264 baseline
  H265 = 2;                        // H.265/HEVC (future)
}
```

**Flow**:
1. Mac sends `START` with desired config
2. Android starts `MediaProjection` capture
3. Android encodes frames (H.264)
4. Android sends `FRAME` messages continuously
5. Mac decodes and displays frames
6. Mac sends `STOP` to end stream

---

### 5. Virtual Webcam

```proto
message MediaMessage {
  enum MediaEventType {
    CAMERA_START = 1;              // Start camera stream
    CAMERA_FRAME = 2;              // Video frame
    CAMERA_STOP = 3;               // Stop camera stream
    MICROPHONE_START = 4;          // Start mic stream
    MICROPHONE_DATA = 5;           // Audio data
    MICROPHONE_STOP = 6;           // Stop mic stream
  }

  MediaEventType event = 1;

  // For CAMERA_START
  CameraConfig camera_config = 2;

  // For CAMERA_FRAME
  bytes frame_data = 3;            // H.264 encoded
  int32 frame_number = 4;
  int64 timestamp = 5;
  bool is_keyframe = 6;

  // For MICROPHONE_START
  AudioConfig audio_config = 7;

  // For MICROPHONE_DATA
  bytes audio_data = 8;            // PCM or AAC
  int32 sample_count = 9;
}

message CameraConfig {
  int32 width = 1;
  int32 height = 2;
  int32 fps = 3;
  CameraFacing facing = 4;
  VideoCodec codec = 5;
}

enum CameraFacing {
  UNKNOWN = 0;
  FRONT = 1;
  BACK = 2;
}

message AudioConfig {
  int32 sample_rate = 1;           // e.g., 44100, 48000
  int32 channels = 2;              // 1 = mono, 2 = stereo
  AudioCodec codec = 3;
}

enum AudioCodec {
  UNKNOWN = 0;
  PCM = 1;                        // Raw PCM (16-bit)
  AAC = 2;                        // AAC encoded
}
```

**Flow**:
1. Mac app (CMIO plug-in) requests camera stream
2. Mac sends `CAMERA_START` to Android
3. Android starts CameraX capture
4. Android encodes frames (H.264)
5. Android sends `CAMERA_FRAME` messages
6. Mac decodes and presents as virtual webcam
7. Repeat until `CAMERA_STOP`

---

### 6. Call Handling

```proto
message CallMessage {
  enum CallEventType {
    RINGING = 1;                   // Incoming call
    ANSWERED = 2;                  // Call answered
    ENDED = 3;                     // Call ended
    MISSED = 4;                    // Missed call
  }

  CallEventType event = 1;

  // For RINGING, ANSWERED, MISSED
  string phone_number = 2;
  string contact_name = 3;
  bytes contact_photo = 4;         // Contact photo (PNG)
  int64 timestamp = 5;
  string call_id = 6;              // Unique call ID
}

message CallAction {
  enum ActionType {
    ANSWER = 1;
    DECLINE = 2;
    HANGUP = 3;
    MUTE = 4;
    UNMUTE = 5;
    SPEAKER_ON = 6;
    SPEAKER_OFF = 7;
  }

  ActionType action = 1;
  string call_id = 2;
}
```

**Flow**:
1. Android detects incoming call (`TelephonyManager`)
2. Send `CallMessage` (RINGING) to Mac
3. Mac displays incoming call notification
4. User clicks "Answer" → Send `CallAction` (ANSWER) to Android
5. Android answers call
6. On call end, send `CallMessage` (ENDED)

---

## Versioning & Compatibility

### Semantic Versioning

Protocol version follows `MAJOR.MINOR.PATCH`:
- **MAJOR**: Breaking changes (requires both devices to update)
- **MINOR**: New features (backward compatible)
- **PATCH**: Bug fixes (backward compatible)

### Version Negotiation

```
1. Android sends HELLO with protocol_version = "1.2.0"
2. Mac checks version compatibility
   ├─ If compatible (1.x.x): Respond with HELLO_ACK
   └─ If incompatible: Send ERROR with PROTOCOL_MISMATCH
```

### Compatibility Rules

| Old Client | New Server | Result |
|------------|------------|--------|
| 1.0.0 | 1.1.0 | ✅ Compatible (new features ignored) |
| 1.1.0 | 1.0.0 | ✅ Compatible (optional features not used) |
| 1.0.0 | 2.0.0 | ❌ Incompatible (major version mismatch) |

### Field Addition Rules

Protocol Buffers ensures forward compatibility:
- ✅ Adding new `optional` fields (old clients ignore them)
- ✅ Adding new enum values (old clients treat as `UNKNOWN`)
- ❌ Removing fields (breaks old clients)
- ❌ Changing field numbers (breaks all clients)
- ❌ Changing field types (breaks old clients)

### Migration Strategy

When breaking changes are needed:
1. Increment MAJOR version (1.x → 2.0)
2. Support both versions during transition period
3. Mark old version as deprecated
4. Remove old version after 6 months

---

## Implementation Notes

### Message ID Generation

```kotlin
// Generate unique message ID (timestamp + random)
fun generateMessageId(): Long {
    val timestamp = System.currentTimeMillis()
    val random = Random.nextInt(0, 1000)
    return (timestamp * 1000) + random
}
```

### Heartbeat/Ping

```kotlin
// Send heartbeat every 30 seconds
suspend fun heartbeatLoop() {
    while (isActive) {
        delay(30_000)
        transport.sendHeartbeat()
    }
}

// Detect timeout (no data for 60 seconds)
suspend fun timeoutMonitor() {
    while (isActive) {
        delay(60_000)
        if (System.currentTimeMillis() - lastMessageTime > 60_000) {
            disconnect()
        }
    }
}
```

### Error Handling

```kotlin
// Send error message to remote device
fun sendError(error: DroidLinkError) {
    val errorMessage = ErrorMessage(
        code = error.toErrorCode(),
        message = error.toMessage(),
        details = error.toDetails()
    )

    val systemMessage = SystemMessage(
        event = SystemEventType.ERROR,
        error = errorMessage
    )

    val message = DroidLinkMessage(
        id = generateMessageId(),
        timestamp = System.currentTimeMillis(),
        type = MessageType.SYSTEM,
        system = systemMessage
    )

    transport.send(message)
}
```

---

**Status**: ✅ Protocol design complete — ready for implementation

**Last Updated**: 2025-06-07
