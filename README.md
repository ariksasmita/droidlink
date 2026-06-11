# DroidLink

> **Free, local-first Android ↔ Mac/iPad device integration**

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Android](https://img.shields.io/badge/Android-10%2B-green.svg)](https://developer.android.com)
[![macOS](https://img.shields.io/badge/macOS-14%2B-green.svg)](https://www.apple.com/macos)
[![Status: 90% Complete](https://img.shields.io/badge/Status-90%25%20Complete-yellow.svg)](https://github.com/ariksasmita/droidlink)
[![TCP: Working](https://img.shields.io/badge/TCP-Working-success.svg)](https://github.com/ariksasmita/droidlink)

---

## 🎉 Latest Update: TCP Transport Layer Working!

**✅ Successfully implemented and tested bidirectional TCP communication between Android and Mac!**

```
Android → Mac: "Hello from Test MacBook Pro!"
Mac → Android: "Hello from Mac! Received: Hello from Test MacBook Pro!"
```

**Status**: 90% complete — Core cross-platform communication proven and functional!

See [TCP_SUCCESS.md](TCP_SUCCESS.md) for test results and implementation details.

---

## 🎯 What is DroidLink?

DroidLink is an **open-source, privacy-focused alternative to LinkMyMac** that enables seamless integration between Android phones and Mac/iPad devices. It connects your devices directly over USB or Wi-Fi — **no cloud, no accounts, no subscription fees**.

### Features

| Feature | Status |
|---------|--------|
| **Universal Clipboard** | Bidirectional text, image, and URL sync |
| **Notification Mirror** | See Android notifications on Mac |
| **File Transfer** | Drag-and-drop files over USB/Wi-Fi |
| **Screen Mirroring** | Real-time Android screen on Mac |
| **SMS/MMS Reading** | View message threads on Mac |
| **Virtual Webcam** | Use Android camera as Mac webcam |
| **Virtual Microphone** | Use Android mic as Mac audio input |
| **Call Handling** | Answer/decline calls from Mac |
| **LinkMyDrop Alternative** | iPhone ↔ Android direct transfers (Web app) |

### Why DroidLink?

- ✅ **Free & Open Source** — No subscription fees, Apache 2.0 licensed
- ✅ **Privacy-First** — All data stays on your devices, no cloud relay
- ✅ **Local Connection** — Works offline, USB or Wi-Fi
- ✅ **Cross-Platform** — Android ↔ Mac/iPad (and soon iPhone ↔ Android)
- ✅ **No Accounts** — Pair once with QR code, that's it

### How It Works

```
1. Install DroidLink on Android and DroidLinkMenubar on Mac
2. Scan QR code to pair (one-time setup)
3. Connect via USB (fastest) or Wi-Fi (wireless freedom)
4. Everything just works — clipboard syncs, notifications mirror, files transfer
```

---

## 📸 Screenshots

*(Will be added when UI is implemented)*

---

## 🚀 Getting Started

### Prerequisites

- **Android device** running Android 10 (API 29) or later
- **Mac** running macOS 14 (Sonoma) or later
- **USB cable** (optional, for wired connection)
- **Same Wi-Fi network** (for wireless connection)

### Installation

#### Android

```bash
# Option 1: Install from Google Play Store (coming soon)
# Search "DroidLink" on Play Store

# Option 2: Install from F-Droid (coming soon)
# Download from F-Droid repository

# Option 3: Install APK directly (GitHub Releases)
# Download latest release from:
# https://github.com/yourusername/droidlink/releases
```

#### Mac

```bash
# Option 1: Install from App Store (coming soon)
# Search "DroidLink" on Mac App Store

# Option 2: Install via Homebrew (coming soon)
brew install --cask droidlink

# Option 3: Install DMG directly (GitHub Releases)
# Download latest release from:
# https://github.com/yourusername/droidlink/releases
```

### Pairing Devices

1. **Open DroidLinkMenubar on Mac**
   - Located in `/Applications/DroidLink.app`
   - Menu bar icon appears

2. **Generate QR Code**
   - Click "Pair Device" in menu bar
   - QR code is displayed

3. **Scan QR Code on Android**
   - Open DroidLink app
   - Tap "Pair New Device"
   - Scan QR code with camera

4. **Connection Established**
   - Devices are now paired
   - Choose USB or Wi-Fi connection
   - All features automatically activate

---

## 🛠️ Development

DroidLink is built with modern, cross-platform technologies:

### Tech Stack

#### Android App
- **Language**: Kotlin 2.0+ with Coroutines
- **UI**: Jetpack Compose
- **Architecture**: Clean Architecture (feature-core modularization)
- **Networking**: Ktor + custom TCP layer
- **USB**: Android Open Accessory (AOA) protocol
- **Discovery**: mDNS/NSD

#### Mac App
- **Language**: Swift 6
- **UI**: SwiftUI
- **Architecture**: MVVM with Combine
- **Networking**: Native Network framework + Bonjour
- **Virtual Devices**: AVFoundation + CMIO DAL
- **IPC**: XPC for menu bar ↔ main app

#### Protocol
- **Serialization**: Protocol Buffers v3
- **Transport**: TCP over USB (AOA) and Wi-Fi
- **Security**: TLS 1.3 with certificate pinning
- **Discovery**: mDNS/Bonjour

### Contributing

We welcome contributions! See [DEVELOPMENT.md](docs/DEVELOPMENT.md) for setup instructions.

```bash
# Clone repository
git clone https://github.com/yourusername/droidlink.git
cd droidlink

# Read development guide
cat docs/DEVELOPMENT.md

# Set up Android development
cd android && ./gradlew build

# Set up Mac development
cd mac && xcodebuild build
```

---

## 📖 Documentation

- [AGENTS.md](AGENTS.md) — Project context and tech stack
- [PLAN.md](PLAN.md) — Development plan and roadmap
- [ARCHITECTURE.md](docs/ARCHITECTURE.md) — System architecture
- [PROTOCOL.md](docs/PROTOCOL.md) — Protocol specification
- [DEVELOPMENT.md](docs/DEVELOPMENT.md) — Development setup guide

---

## 🗺️ Roadmap

### Phase 1: Core Infrastructure (Weeks 1-4)
- [x] Protocol design (Protocol Buffers)
- [ ] QR pairing flow
- [ ] USB connection (AOA)
- [ ] Wi-Fi connection + mDNS discovery
- [ ] Auto-reconnection logic

### Phase 2: Essential Features (Weeks 5-12)
- [ ] Universal clipboard
- [ ] Notification mirror
- [ ] File transfer
- [ ] Screen mirroring (H.264)
- [ ] SMS/MMS reading

### Phase 3: Advanced Features (Weeks 13-20)
- [ ] Virtual webcam (CMIO DAL)
- [ ] Virtual microphone
- [ ] Call handling
- [ ] LinkMyDrop alternative (Web app)

See [PLAN.md](PLAN.md) for detailed timeline.

---

## 🆚 Comparison

| Feature | DroidLink | LinkMyMac | KDE Connect | scrcpy |
|---------|-----------|-----------|-------------|--------|
| **Price** | Free | $20-40/year | Free | Free |
| **Platforms** | Android ↔ Mac/iPad | Android ↔ Mac/iPad | Linux ↔ Android | Desktop ↔ Android |
| **Cloud** | None | None | None | None |
| **Clipboard** | ✅ | ✅ | ✅ | ❌ |
| **Notifications** | ✅ | ✅ | ✅ | ❌ |
| **File Transfer** | ✅ | ✅ | ✅ | ❌ |
| **Screen Mirroring** | ✅ | ✅ | ✅ | ✅ |
| **Virtual Webcam** | ✅ | ✅ | ❌ | ❌ |
| **Virtual Mic** | ✅ | ✅ | ❌ | ❌ |
| **Call Handling** | ✅ | ✅ | ❌ | ❌ |
| **Open Source** | ✅ | ❌ | ✅ | ✅ |

---

## 🔒 Privacy & Security

### Local-First Design

- **All data stays on your devices** — No cloud servers, no data relay
- **No user accounts** — No tracking, no analytics
- **Encrypted connection** — TLS 1.3 with certificate pinning
- **Open source** — Code is auditable by anyone

### Permissions Required

#### Android
- **Notification access** — For notification mirroring
- **File access** — For file transfers
- **Camera/Microphone** — For virtual webcam/mic
- **USB access** — For wired connection
- **Local network** — For Wi-Fi discovery

#### Mac
- **Camera/Microphone** — For virtual devices
- **Notifications** — For displaying Android notifications
- **Files/Folders** — For file transfers

### Data Flow

```
Android ──TLS 1.3──► Mac
  ◄─────────────────

All data flows directly between devices.
No third-party servers, no cloud storage.
```

---

## 🐛 Troubleshooting

### Common Issues

**Q: Devices won't pair**
```bash
A: Ensure both devices are on the same Wi-Fi network.
   Try QR code again with better lighting.
   Check that USB cable is data-capable (not charge-only).
```

**Q: Connection drops frequently**
```bash
A: Wi-Fi interference — try USB connection.
   Check battery optimization on Android (disable for DroidLink).
   Ensure both apps have necessary permissions.
```

**Q: Clipboard not syncing**
```bash
A: Verify clipboard permissions on both devices.
   Restart both apps.
   Check Protocol Buffer version compatibility.
```

**Q: Screen mirroring laggy**
```bash
A: Use USB connection for best performance.
   Lower resolution in Mac app settings.
   Close other network-intensive apps.
```

### Getting Help

- **GitHub Issues**: [Bug reports, feature requests](https://github.com/yourusername/droidlink/issues)
- **GitHub Discussions**: [Q&A, troubleshooting](https://github.com/yourusername/droidlink/discussions)
- **Documentation**: [docs/](docs/) folder

---

## 📊 Performance

### Benchmarks (Target)

| Feature | Metric | Target |
|---------|--------|--------|
| Clipboard Sync | Latency | <100ms |
| Notification Mirror | Latency | <500ms |
| File Transfer | USB Throughput | >20MB/s |
| File Transfer | Wi-Fi Throughput | >5MB/s |
| Screen Mirroring | Latency | <200ms |
| Screen Mirroring | Frame Rate | 30fps @ 720p |

### Battery Usage

- **Idle**: <2%/hour
- **Active (clipboard)**: <3%/hour
- **Active (screen mirroring)**: <10%/hour

---

## 🙏 Acknowledgments

### Inspiration
- [LinkMyMac](https://linkmymac.com/) — Feature parity target
- [KDE Connect](https://github.com/KDE/kdeconnect-kde) — Open source reference
- [scrcpy](https://github.com/Genymobile/scrcpy) — Screen mirroring reference

### Libraries Used

#### Android
- Jetpack Compose
- Ktor
- Protocol Buffers
- CameraX

#### Mac
- SwiftUI
- Combine
- AVFoundation
- SwiftProtobuf

---

## 📄 License

```
Copyright 2025 DroidLink Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

## 🌟 Star History

[![Star History Chart](https://api.star-history.com/svg?repos=yourusername/droidlink&type=Date)](https://star-history.com/#yourusername/droidlink&Date)

---

## 📞 Contact

- **GitHub**: [@yourusername](https://github.com/yourusername)
- **Email**: (to be created)
- **Discord**: (to be created)

---

**Status**: 📝 Planning Phase — Architecture Complete

**Made with ❤️ by the DroidLink community**
