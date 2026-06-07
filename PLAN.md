# DroidLink Development Plan

**An open-source LinkMyMac alternative — Android ↔ Mac/iPad local device bridging**

---

## 📋 Executive Summary

DroidLink is a free, privacy-focused alternative to LinkMyMac (https://linkmymac.com/) that enables seamless Android-Apple ecosystem integration through direct local connections. This plan outlines the architecture, development phases, technical challenges, and implementation roadmap.

**Target Users**: Mac users with Android phones who want seamless device integration without paying $20-40/year subscription fees.

**Core Value Proposition**: Local-first, privacy-focused, free and open-source Android ↔ Mac integration.

---

## 🎯 MVP Feature Scope

### Phase 1: Core Infrastructure (Weeks 1-4)
1. **QR Pairing System** — Secure one-time pairing via QR code scan
2. **USB Connection** — Android Open Accessory (AOA) protocol implementation
3. **Wi-Fi Connection** — Local network TCP + mDNS/Bonjour discovery
4. **Protocol Layer** — Protocol Buffers message framing + serialization
5. **Auto-Reconnection** — Graceful reconnection on connection loss

### Phase 2: Essential Features (Weeks 5-12)
6. **Universal Clipboard** — Bidirectional sync (text, images, URLs)
7. **Notification Mirror** — Android notifications → Mac native notifications
8. **File Transfer** — Drag-and-drop between devices (USB + Wi-Fi)
9. **Screen Mirroring** — Real-time H.264 streaming (Android → Mac)
10. **SMS/MMS Reading** — View message threads on Mac

### Phase 3: Advanced Features (Weeks 13-20)
11. **Virtual Webcam** — Android camera → Mac webcam input (CMIO DAL)
12. **Virtual Microphone** — Android mic → Mac audio input
13. **Call Handling** — Incoming calls on Mac, remote answer/decline
14. **LinkMyDrop Alternative** — Web-based iPhone ↔ Android transfers

---

## 🏗️ Architecture Overview

```
┌─────────────────────────────────────────────────────────────────┐
│                         DroidLink Ecosystem                     │
├─────────────────────────────────────────────────────────────────┤
│                                                                   │
│  ┌──────────────┐        ┌──────────────┐        ┌──────────────┐ │
│  │   Android    │        │     Mac      │        │    iPad      │ │
│  │              │        │              │        │              │ │
│  │ ┌──────────┐ │        │ ┌──────────┐ │        │ ┌──────────┐ │ │
│  │ │ Clipboard │ │        │ │ Menu Bar │ │        │ │  Full    │ │ │
│  │ │  Service  │◄────────┤ │   App    │◄────────┤ │  App UI  │ │ │
│  │ └──────────┘ │        │ └──────────┘ │        │ └──────────┘ │ │
│  │ ┌──────────┐ │        │ ┌──────────┐ │        │ ┌──────────┐ │ │
│  │ │  Notify  │ │        │ │ Virtual  │ │        │ │  File    │ │ │
│  │ │ Listener │◄────────┤ │  Webcam  │ │        │ │ Transfer │ │ │
│  │ └──────────┘ │        │ └──────────┘ │        │ └──────────┘ │ │
│  │ ┌──────────┐ │        │ ┌──────────┐ │        │              │ │
│  │ │   File   │ │        │ │  Screen  │ │        │              │ │
│  │ │  Server  │◄────────┤ │  Mirror  │ │        │              │ │
│  │ └──────────┘ │        │ └──────────┘ │        │              │ │
│  │              │        │              │        │              │ │
│  └──────────────┘        └──────────────┘        └──────────────┘ │
│         │                         │                         │       │
│         └─────────────────────────┼─────────────────────────┘       │
│                                   │                                 │
│                        ┌──────────▼──────────┐                      │
│                        │  Protocol Buffers   │                      │
│                        │  (TCP over USB/Wi-Fi)│                     │
│                        └─────────────────────┘                      │
└─────────────────────────────────────────────────────────────────┘
```

### Technology Stack

#### Android App
- **Language**: Kotlin 2.0+ with Coroutines & Flow
- **UI**: Jetpack Compose
- **Architecture**: Clean Architecture (feature-core modularization)
- **Networking**: Ktor client + custom TCP layer
- **Background**: Foreground services (Notification Listener, File Server)
- **USB**: Android Open Accessory (AOA) protocol
- **Discovery**: Network service discovery (NSD) + mDNS client

#### Mac App
- **Language**: Swift 6, SwiftUI
- **Architecture**: MVVM with Combine
- **Menu Bar**: AppKit + NSStatusBar
- **IPC**: XPC for menu bar ↔ main app communication
- **Virtual Devices**: AVFoundation + CMIO DAL plug-in
- **Discovery**: Bonjour/mDNS service registration

#### Communication Protocol
- **Transport**: TCP over USB (AOA) and Wi-Fi
- **Serialization**: Protocol Buffers v3 (binary protocol)
- **Discovery**: mDNS/Bonjour for zero-configuration networking
- **Security**: TLS 1.3 with self-signed certificate pinning

---

## 📁 Project Structure

```
droidlink/
├── android/                         # Android app (Kotlin)
│   ├── app/                        # Main application
│   ├── core/                       # Shared core utilities
│   │   ├── network/               # Protocol buffers + Ktor
│   │   ├── permissions/           # Permission handling
│   │   ├── security/              # Certificate management
│   │   └── discovery/             # Network discovery
│   ├── feature-clipboard/         # Clipboard sync
│   │   ├── api/                   # Public interface
│   │   └── impl/                  # Implementation
│   ├── feature-notifications/     # Notification mirroring
│   ├── feature-files/             # File transfer
│   ├── feature-screen/            # Screen mirroring
│   ├── feature-media/             # Virtual webcam/mic
│   └── feature-calls/             # Call handling
├── mac/                            # macOS app (Swift)
│   ├── DroidLink/                 # Main app
│   ├── DroidLinkMenu/             # Menu bar extension
│   ├── DroidLinkKit/              # Shared framework
│   │   ├── Networking/            # Protocol buffers + server
│   │   ├── VirtualDevices/       # Webcam/mic
│   │   ├── Discovery/             # Bonjour services
│   │   └── Models/                # Data models
│   └── DroidLinkTests/            # Tests
├── protocol/                       # Shared protocol
│   ├── protos/                    # Protocol Buffer schemas
│   │   ├── connection.proto       # Pairing, discovery
│   │   ├── clipboard.proto        # Clipboard sync
│   │   ├── notification.proto     # Notification mirror
│   │   ├── file.proto             # File transfer
│   │   ├── screen.proto           # Screen mirroring
│   │   ├── media.proto            # Virtual webcam/mic
│   │   └── call.proto             # Call handling
│   └── README.md                  # Protocol documentation
├── docs/                           # Architecture docs
│   ├── ARCHITECTURE.md            # System architecture
│   ├── PROTOCOL.md                # Protocol details
│   ├── SECURITY.md                # Security model
│   └── DEVELOPMENT.md             # Dev setup guide
└── README.md                       # Project overview
```

---

## 🔧 Technical Challenges & Solutions

### 1. Android Open Accessory (AOA) Protocol
**Challenge**: USB communication requires implementing Google's AOA protocol for device discovery and data transfer.

**Solution**:
- Implement AOA handshake in Android (accessory mode)
- Use UsbManager API for device enumeration
- Handle USB permission grants gracefully
- Implement bulk endpoint data transfer
- Fallback to Wi-Fi if USB unavailable

**Resources**:
- [Android AOA Documentation](https://developer.android.com/guide/topics/connectivity/usb/host)
- [libusb](https://libusb.info/) for Mac USB side

### 2. Screen Mirroring (H.264 Streaming)
**Challenge**: Real-time screen capture and streaming with minimal latency.

**Solution**:
- Android: `MediaProjection` API + `MediaCodec` H.264 encoding
- Mac: `VideoToolbox` H.264 decoding + AVPlayer rendering
- Adaptive bitrate based on network conditions
- Hardware acceleration where available
- Target: 30fps at 720p with <200ms latency

**Alternatives**:
- MJPEG streaming (simpler, higher latency)
- VNC-like RFB protocol (more complex, cross-platform)

### 3. Virtual Webcam & Microphone (CMIO DAL Plug-in)
**Challenge**: macOS requires implementing a Camera/Microphone DAL (Device Abstraction Layer) plug-in.

**Solution**:
- Create CMIO DAL plug-in in Objective-C++
- Register as virtual camera/microphone device
- Receive video/audio frames from Android via IPC
- Present as `AVCaptureDevice` to apps (Zoom, Teams, etc.)
- Follow [Apple CMIO Documentation](https://developer.apple.com/documentation/coremediaio)

**Simplified Alternative**:
- Skip CMIO, use syphon (video) and Soundflower (audio) injectors
- Less integrated, but easier to implement

### 4. Notification Listener Reliability
**Challenge**: Android Notification Listener Service can be killed by system or disabled by user.

**Solution**:
- Foreground service with persistent notification
- Auto-restart on service death
- Graceful handling of permission revocation
- User education during onboarding

### 5. mDNS/Bonjour Discovery
**Challenge**: Cross-platform service discovery with varying network conditions.

**Solution**:
- Android: Network Service Discovery (NSD) API
- Mac: Bonjour `NetService` registration
- Fallback to manual IP entry if discovery fails
- Handle Wi-Fi network changes gracefully
- Support both USB and Wi-Fi discovery

### 6. Protocol Compatibility
**Challenge**: Apps update independently, need backward/forward compatibility.

**Solution**:
- Semantic versioning for protocol (`major.minor.patch`)
- Protobuf's built-in backward compatibility
- Android app reports protocol version during handshake
- Mac app supports multiple protocol versions
- Migration guide for breaking changes

### 7. Battery Optimization
**Challenge**: Background services drain Android battery.

**Solution**:
- Efficient polling intervals
- Suspend unnecessary features when idle
- Wake locks only when active transfer
- Battery usage stats in app
- User-configurable power saving mode

---

## 📅 Implementation Timeline

### Phase 0: Setup (Week 0)
- [ ] Initialize git repository
- [ ] Set up Android project (Kotlin + Compose)
- [ ] Set up Mac project (Swift + SwiftUI)
- [ ] Create Protocol Buffers project structure
- [ ] Set up CI/CD (GitHub Actions)

### Phase 1: Core Infrastructure (Weeks 1-4)

#### Week 1: Protocol Layer
- [ ] Design Protocol Buffer schemas
- [ ] Implement code generation (Kotlin + Swift)
- [ ] Create message framing protocol
- [ ] Write protocol documentation

#### Week 2: QR Pairing
- [ ] Android: QR code generation (secure pairing token)
- [ ] Mac: QR code display + camera scan
- [ ] Implement TLS handshake with certificate pinning
- [ ] Store paired device info securely

#### Week 3: USB Connection (AOA)
- [ ] Mac: USB device enumeration (libusb)
- [ ] Android: AOA accessory mode activation
- [ ] TCP over USB data transfer
- [ ] Handle USB connection lifecycle

#### Week 4: Wi-Fi Connection + Discovery
- [ ] Mac: Bonjour service registration
- [ ] Android: NSD mDNS discovery
- [ ] TCP over Wi-Fi data transfer
- [ ] Implement auto-reconnection logic
- [ ] Connection preference UI (USB vs Wi-Fi)

### Phase 2: Essential Features (Weeks 5-12)

#### Week 5-6: Universal Clipboard
- [ ] Android: Clipboard monitoring + `ClipboardManager`
- [ ] Mac: `NSPasteboard` monitoring
- [ ] Bidirectional sync (text, images, URLs)
- [ ] "Copy to Mac" Android share menu item
- [ ] Conflict resolution (simultaneous copy)

#### Week 7-8: Notification Mirror
- [ ] Android: `NotificationListenerService` implementation
- [ ] Mac: `NSUserNotification` display
- [ ] Notification actions (reply, dismiss)
- [ ] App icon extraction and display
- [ ] Permission request flow

#### Week 9-10: File Transfer
- [ ] Android: HTTP file server (Ktor)
- [ ] Mac: File browser + drag-and-drop
- [ ] Batch file transfers
- [ ] Resume interrupted transfers
- [ ] File thumbnail generation

#### Week 11-12: Screen Mirroring
- [ ] Android: `MediaProjection` + H.264 encoding
- [ ] Mac: H.264 decoding + AVPlayer rendering
- [ ] Mouse/keyboard input forwarding
- [ ] Adaptive quality scaling
- [ ] Screen recording controls

### Phase 3: Advanced Features (Weeks 13-20)

#### Week 13-14: SMS/MMS Reading
- [ ] Android: `ContentProvider` for SMS/MMS
- [ ] Mac: Message thread UI
- [ ] Quick reply from notification
- [ ] Contact photo integration

#### Week 15-16: Virtual Webcam
- [ ] Mac: CMIO DAL plug-in skeleton
- [ ] Android: Camera capture (CameraX API)
- [ ] Video frame streaming (Android → Mac)
- [ ] Camera switching (front/back)
- [ ] Resolution/fps controls

#### Week 17-18: Virtual Microphone
- [ ] Mac: CMIO DAL audio plug-in
- [ ] Android: Audio capture (AudioRecord)
- [ ] Audio frame streaming
- [ ] Noise reduction option

#### Week 19-20: Call Handling
- [ ] Android: `TelephonyManager` call state monitoring
- [ ] Mac: Incoming call notification
- [ ] Remote answer/decline
- [ ] Caller ID + contact photo

#### Week 21+: LinkMyDrop Alternative (Web App)
- [ ] Next.js 15 PWA setup
- [ ] WebRTC for browser ↔ Android connection
- [ ] QR-based pairing
- [ ] Photo/file/text transfers
- [ ] iPhone ↔ Android workflows

---

## 🧪 Testing Strategy

### Unit Tests
- Android: JVM tests with Robolectric
- Mac: XCTest with mocked dependencies
- Protocol: Proto fuzzing for compatibility

### Integration Tests
- USB connection lifecycle (Android + Mac)
- Wi-Fi discovery and reconnection
- Protocol message round-trips
- File transfer integrity

### E2E Tests
- QR pairing flow
- Clipboard sync (all data types)
- Notification mirror (various apps)
- File transfer (large files, batches)
- Screen mirroring (extended sessions)

### Manual Tests
- Battery drain under continuous use
- Connection stability under network changes
- Multi-device pairing (multiple Android phones)
- Compatibility across Android versions (10+) and macOS versions (14+)

---

## 🚀 Distribution Plan

### Android
- **Google Play Store**: Primary distribution
- **F-Droid**: For FOSS community
- **GitHub Releases**: Direct APK downloads
- **Requirements**: Android 10 (API 29)+

### Mac
- **App Store**: If guidelines allow virtual devices
- **Direct DMG**: GitHub Releases + website download
- **Homebrew Cask**: For developer audience
- **Requirements**: macOS 14 (Sonoma)+

### Protocol & Documentation
- **GitHub Repository**: Apache 2.0 licensed
- **Documentation**: GitHub Pages / Docsify
- **Community**: GitHub Discussions for support

---

## 💰 Cost Estimate

### Development Costs
- **Android Developer**: 3-4 months full-time (MVP)
- **Mac Developer**: 3-4 months full-time (MVP)
- **Protocol Designer**: 1 month part-time
- **Total**: ~6-8 developer-months

### Infrastructure Costs
- **GitHub Actions**: Free for public repo
- **Google Play**: $25 one-time registration
- **Apple Developer**: $99/year
- **Domain/Hosting**: ~$50/year (for website/downloads)

### Ongoing Maintenance
- **Bug fixes**: 2-4 hours/week
- **OS compatibility**: 5-10 hours/month
- **Feature requests**: Community contribution encouraged

**Total First-Year Cost**: ~$250 (infrastructure) + development time (volunteer or crowdfunded)

---

## 📈 Success Metrics

### Technical
- Connection success rate >95%
- Clipboard sync latency <100ms
- Screen mirroring latency <200ms
- File transfer throughput >20MB/s (USB), >5MB/s (Wi-Fi)
- Battery drain <2%/hour (idle)

### User Adoption
- 1,000+ downloads in first 3 months
- 100+ active weekly users
- 4.5+ star rating on Play Store
- 10+ GitHub contributors

### Community
- 50+ GitHub issues filed (feedback)
- 20+ pull requests from community
- Active Discord/Matrix community

---

## 🎓 Learning Outcomes

This project provides deep learning opportunities in:

### Android
- AOA USB protocol
- Foreground services & Notification Listener
- MediaProjection for screen capture
- CameraX for camera streaming
- Clean Architecture modularization

### macOS
- CMIO DAL plug-in development
- XPC for inter-process communication
- Bonjour/mDNS service registration
- AVFoundation for virtual devices
- SwiftUI + AppKit integration

### Cross-Platform
- Protocol Buffers schema design
- Binary protocol implementation
- Network programming (TCP, TLS)
- Security (certificate pinning)
- System-level programming

---

## 🔄 Alternative Approaches Considered

### Why Not Electron + Web Tech?
- ❌ Poor performance for video streaming
- ❌ Limited access to system APIs (virtual devices, USB)
- ❌ Higher resource usage
- ✅ Would enable Windows/Linux support

### Why Not React Native / Flutter?
- ❌ Limited access to platform-specific APIs (AOA, CMIO)
- ❌ Abstraction layer would complicate low-level protocols
- ❌ UI frameworks don't match platform conventions

### Why Not Existing Open Source Projects?
- **KDE Connect**: Linux-focused, no Mac virtual webcam/mic
- **scrcpy**: Screen mirroring only, no clipboard/notifications
- **Pairdrop**: Web-based, no OS integration
- **AirDrop**: Apple ecosystem only

---

## 📚 Reference Material

### Android
- [Android Open Accessory (AOA)](https://developer.android.com/guide/topics/connectivity/usb/host)
- [Notification Listener Service](https://developer.android.com/reference/android/service/notification/NotificationListenerService)
- [MediaProjection API](https://developer.android.com/reference/android/media/projection/MediaProjection)
- [CameraX](https://developer.android.com/training/camerax)

### macOS
- [Core Media IO (CMIO)](https://developer.apple.com/documentation/coremediaio)
- [Bonjour (mDNS)](https://developer.apple.com/bonjour/)
- [AVFoundation](https://developer.apple.com/documentation/avfoundation)
- [XPC](https://developer.apple.com/documentation/xpc)

### Protocols
- [Protocol Buffers](https://developers.google.com/protocol-buffers)
- [mDNS/DNS-SD](https://tools.ietf.org/html/rfc6762)
- [TLS 1.3](https://tools.ietf.org/html/rfc8446)

### Similar Projects
- [KDE Connect](https://github.com/KDE/kdeconnect-kde)
- [scrcpy](https://github.com/Genymobile/scrcpy)
- [Pairdrop](https://github.com/schlagmichdoch/Pairdrop)

---

## 🤝 Contributing

Once MVP is complete, contributions welcome in:
- Additional platform support (Windows, Linux)
- New feature modules (remote control, SMS replies, etc.)
- Localization (i18n)
- Bug fixes and performance improvements
- Documentation and testing

**Contribution Guidelines**: See CONTRIBUTING.md (to be created)

---

## 📞 Next Steps

1. **Review this plan** — Identify gaps, adjust scope/timeline
2. **Set up repositories** — Android, Mac, Protocol as separate repos or mono-repo
3. **Design protocol schemas** — Define all `.proto` files upfront
4. **Start with QR pairing** — This unblocks all other features
5. **Join the community** — Discord/Matrix for coordination

---

**Status**: 📝 Planning Phase — Ready for Architecture Review

**Last Updated**: 2025-06-07
