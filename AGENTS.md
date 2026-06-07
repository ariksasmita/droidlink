# Project: DroidLink

**An open-source, local-first Android ↔ Mac/iPad device bridging platform**

## Project Vision

Build a free, privacy-focused alternative to LinkMyMac that enables seamless Android-Apple ecosystem integration through direct local connections. No cloud, no accounts, no tracking — just device-to-device communication over USB and Wi-Fi.

## Tech Stack (Proposed)

### Android App
- **Language**: Kotlin 2.0+ with Coroutines & Flow
- **UI**: Jetpack Compose
- **Architecture**: Clean Architecture (Feature/Core modularization)
- **Networking**: Ktor for client-server communication
- **Permissions**: Permission handling for notifications, files, camera, mic
- **Background Services**: Foreground services for persistent connections
- **USB**: AOA (Android Open Accessory) protocol support
- **Wi-Fi**: Wi-Fi Direct + Local network discovery

### Mac/iPad App
- **Language**: Swift 6
- **UI**: SwiftUI (iOS 17+, macOS 14+)
- **Architecture**: MVVM with Combine
- **Networking**: Native Network framework + Bonjour/mDNS for discovery
- **IPC**: XPC for menu bar ↔ main app communication
- **Virtual Devices**: AVFoundation for virtual webcam/mic

### Communication Protocol
- **Transport**: TCP over USB (AOA) and Wi-Fi
- **Serialization**: Protocol Buffers for efficient binary protocol
- **Discovery**: mDNS/Bonjour for local network
- **Security**: TLS 1.3 with certificate pinning for initial handshake

### Optional: Web Dashboard (H5/LinkMyDrop alternative)
- **Framework**: Next.js 15 + React 19
- **Styling**: Tailwind CSS
- **Real-time**: WebRTC for direct browser-to-device connection
- **PWA**: Service workers for offline capability

## Project Structure (Planned)

```
droidlink/
├── android/                    # Android app (Kotlin + Compose)
│   ├── app/                    # Main application module
│   ├── core/                   # Core shared utilities
│   │   ├── network/           # Protocol buffers + Ktor client
│   │   ├── permissions/       # Permission handling
│   │   └── security/          # Certificate management
│   ├── feature-clipboard/     # Clipboard sync
│   ├── feature-notifications/ # Notification mirroring
│   ├── feature-files/         # File transfer
│   ├── feature-screen/        # Screen mirroring
│   ├── feature-media/         # Virtual webcam/mic
│   └── feature-calls/         # Call handling
├── mac/                        # macOS app (Swift + SwiftUI)
│   ├── DroidLink/             # Main app
│   ├── DroidLinkMenu/         # Menu bar extension
│   ├── DroidLinkKit/          # Shared framework
│   │   ├── Networking/        # Protocol buffers + server
│   │   ├── VirtualDevices/    # Webcam/mic components
│   │   └── Discovery/         # Bonjour services
│   └── DroidLinkTests/        # Test suite
├── protocol/                   # Shared protocol definitions
│   └── protos/                # Protocol Buffer schemas
└── docs/                      # Architecture & API docs
```

## Conventions (Proposed)

### Android
- **Feature-driven modular architecture** with `:feature-xxx:api` and `:feature-xxx:impl` pattern
- **Coroutines + Flow** for async streams (no RxJava)
- **Jetpack Compose** for all UI (no XML layouts)
- **Hilt** for dependency injection (feature modules contribute to core graph)
- **Repository pattern** for data layer abstraction
- **Foreground services** with persistent notifications for background operations

### Mac
- **SwiftUI** for all UI (no UIKit unless unavoidable)
- **Combine** for reactive streams (no RxSwift)
- **XPC** for menu bar ↔ main app communication
- **AVFoundation** for virtual camera/mic
- **Keychain** for secure certificate storage

### Protocol
- **Protocol Buffers v3** for all message serialization
- **Schema-first** development — `.proto` files are single source of truth
- **Semantic versioning** for protocol compatibility
- **Backward compatibility** mandatory — Mac app must support older Android versions

### Cross-platform
- **Local-first** design — all features work without internet
- **Privacy-first** — no analytics, no tracking, no cloud
- **Open source** — Apache 2.0 licensed, community-driven
- **Documentation** — Every feature has README with architecture diagram

## Key Commands (TBD)

```bash
# Android
./gradlew :app:installDebug          # Install debug APK
./gradlew connectedAndroidTest       # Run instrumentation tests
./gradlew :protocol:generateProto    # Regenerate protobuf classes

# Mac
xcodebuild -scheme DroidLink build    # Build Mac app
xcodebuild test -scheme DroidLink     # Run tests
swift package update                  # Update Swift dependencies

# Protocol
protoc --swift_out=. protos/*.proto   # Generate Swift from proto
protoc --kotlin_out=. protos/*.proto  # Generate Kotlin from proto
```

## MVP Feature Scope (Phase 1)

### Core Infrastructure
1. **QR Pairing** — One-time secure pairing via QR code
2. **USB Connection** — AOA-based wired connection
3. **Wi-Fi Connection** — Local network TCP + mDNS discovery
4. **Protocol Layer** — Protocol Buffers message framing
5. **Reconnection Logic** — Auto-reconnect on connection loss

### Essential Features
6. **Universal Clipboard** — Bidirectional text/image/URL sync
7. **Notification Mirror** — Android notifications → Mac native notifications
8. **File Transfer** — Drag-and-drop files between devices
9. **Screen Mirroring** — Real-time Android screen → Mac window (H.264)
10. **SMS/MMS Reading** — View message threads on Mac

### Stretch Goals (Phase 2)
11. **Virtual Webcam** — Android camera → Mac webcam input
12. **Virtual Microphone** — Android mic → Mac audio input
13. **Call Handling** — Incoming calls on Mac, answer/decline remotely
14. **LinkMyDrop Alternative** — iPhone ↔ Android direct transfers (Web app)

## Out of Scope (Explicitly Not Building)

- Cloud sync or cloud relay of any kind
- User accounts or authentication
- Analytics or telemetry
- Windows support (Mac/iPad only for MVP)
- iOS companion app (deferred to Phase 2)
- Remote access over internet (local network only)
- Messaging app integrations beyond notification actions

## Technical Challenges to Solve

1. **AOA Protocol** — Implementing Android Open Accessory for USB connection
2. **Video Streaming** — Efficient screen mirroring (H.264 encoding/decoding)
3. **Virtual Devices** — macOS virtual webcam/mic implementation (CMIO DAL)
4. **Notification Permissions** — Android Notification Listener Service reliability
5. **Discovery** — Reliable mDNS/Bonjour discovery across OS versions
6. **Protocol Compatibility** — Forward/backward compatibility as apps evolve
7. **Battery Optimization** — Minimize Android battery drain

## License & Distribution

- **License**: Apache 2.0
- **Distribution**:
  - Android: Google Play Store + F-Droid + APK direct download
  - Mac: App Store (if guidelines allow) + direct DMG download
- **Revenue Model**: Free and open source (optional donations via GitHub Sponsors)

## Notes

**Current Status**: Planning phase — architecture and protocol design

**Why This Matters**: LinkMyMac is $20-40/year for similar features. DroidLink democratizes Android-Apple integration, proves local-first privacy works, and provides a learning platform for systems programming (USB, video streaming, virtual devices).

**First Steps**:
1. Design protocol buffer schema for all message types
2. Implement QR pairing flow (Android + Mac)
3. Build basic USB connection (AOA handshake + data transfer)
4. Implement clipboard sync as proof-of-concept
5. Layer on additional features incrementally

**Architecture Inspiration**:
- KDE Connect (open source, but Linux-focused)
- scrcpy (screen mirroring reference)
- AirDrop (local discovery UX reference)
- LinkMyMac (feature parity target)
