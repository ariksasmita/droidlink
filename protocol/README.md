# DroidLink Protocol Definitions

This directory contains the Protocol Buffer schemas for DroidLink communication.

## Overview

All communication between Android and Mac devices uses Protocol Buffers for efficient, binary serialization with built-in backward compatibility.

## Files

- **droidlink.proto** - Root message type and message type enum
- **system.proto** - Connection lifecycle (HELLO, HEARTBEAT, ERROR)
- **clipboard.proto** - Clipboard synchronization
- **notification.proto** - Notification mirroring
- **file.proto** - File transfer operations
- **screen.proto** - Screen mirroring (H.264 streaming)
- **media.proto** - Virtual webcam and microphone
- **call.proto** - Call handling

## Message Framing

Every Protocol Buffer message is framed with a 4-byte header:

```
┌────────────────────────────────────┐
│  Header (4 bytes)                  │
│  ├─ Length (3 bytes, big-endian)  │
│  └─ Type (1 byte)                 │
│      ├─ 0x01: DATA                │
│      ├─ 0x02: HEARTBEAT           │
│      └─ 0x03: ERROR               │
├────────────────────────────────────┤
│  Protobuf Message (variable)      │
└────────────────────────────────────┘
```

## Generating Code

### Android (Kotlin)

```bash
cd android
protoc --kotlin_out=app/src/main/kotlin/droidlink/protocol \
  --proto_path=../protocol/protos \
  ../protocol/protos/*.proto
```

### Mac (Swift)

```bash
cd mac
protoc --swift_out=DroidLinkKit/Generated \
  --proto_path=../protocol/protos \
  ../protocol/protos/*.proto
```

## Versioning

Protocol version follows semantic versioning (`MAJOR.MINOR.PATCH`):
- **MAJOR**: Breaking changes (both devices must update)
- **MINOR**: New features (backward compatible)
- **PATCH**: Bug fixes (backward compatible)

## Compatibility

Protocol Buffers ensures:
- ✅ Old clients can read new messages (unknown fields ignored)
- ✅ New clients can read old messages (default values for new fields)
- ❌ Removing fields breaks old clients
- ❌ Changing field numbers breaks all clients

## Documentation

See [PROTOCOL.md](../docs/PROTOCOL.md) for detailed protocol specification.
