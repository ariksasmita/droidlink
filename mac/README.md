# DroidLink Mac App

SwiftUI-based macOS application for DroidLink.

## Project Structure

```
mac/
├── DroidLinkApp.swift          # Main app entry point
├── ContentView.swift           # Main UI view
├── DroidLinkKit/              # Swift Package (shared framework)
│   ├── Package.swift          # Package definition
│   └── Sources/
│       └── DroidLinkClient.swift # Protocol client
└── README.md                   # This file
```

## Setup Instructions

### Option 1: Use Xcode (Recommended)

1. **Open Xcode**
   ```bash
   open -a Xcode .
   ```

2. **Create new project**
   - File → New → Project
   - Choose "macOS App" (SwiftUI)
   - Product Name: "DroidLink"
   - Bundle Identifier: "com.droidlink.mac"
   - Save in: `mac/` directory

3. **Add DroidLinkKit dependency**
   - File → Add Package Dependencies
   - Enter: `file://../DroidLinkKit`
   - Or use Swift Package Manager settings

4. **Replace contents**
   - Copy `DroidLinkApp.swift` to your project
   - Copy `ContentView.swift` to your project

5. **Add required capabilities** (in Signing & Capabilities)
   - App Sandbox (for file access)
   - Network (for device communication)
   - Camera (for virtual webcam - Phase 3)
   - Microphone (for virtual mic - Phase 3)

### Option 2: Use Swift Package Manager

```bash
cd mac/DroidLinkKit
swift build

# Run tests
swift test

# Generate Xcode project
swift package generate-xcodeproj
open DroidLinkKit.xcodeproj
```

## Building

```bash
# Build from command line
cd mac
xcodebuild -scheme DroidLink build

# Or using Xcode
# Product → Build (⌘ + B)
```

## Running

```bash
# From Xcode
# Product → Run (⌘ + R)

# From command line
xcodebuild -scheme DroidLink -destination 'platform=macOS' run
```

## Development Notes

### Required Permissions

Add to `Info.plist`:
```xml
<key>NSCameraUsageDescription</key>
<string>DroidLink needs camera access for virtual webcam feature</string>
<key>NSMicrophoneUsageDescription</key>
<string>DroidLink needs microphone access for virtual microphone feature</string>
```

### Code Signing

For development:
```bash
xcodebuild -scheme DroidLink \
  CODE_SIGN_IDENTITY="-" \
  CODE_SIGNING_REQUIRED=NO
```

For release (requires Apple Developer account):
```bash
xcodebuild -scheme DroidLink \
  CODE_SIGN_IDENTITY="Developer ID Application: Your Name" \
  CODE_SIGNING_REQUIRED=YES
```

## Architecture

The Mac app consists of:

1. **Main App** (SwiftUI)
   - Main window with pairing UI
   - Menu bar integration
   - Settings screens

2. **DroidLinkKit** (Swift Package)
   - Protocol client
   - Network layer
   - Virtual devices (CMIO DAL)
   - Discovery (Bonjour)

## Next Steps

1. ✅ Project structure created
2. ⏳ Implement QR code generation
3. ⏳ Implement Bonjour discovery
4. ⏳ Implement TLS connection
5. ⏳ Implement clipboard sync
6. ⏳ Add menu bar integration

## Resources

- [Apple Developer Documentation](https://developer.apple.com/documentation/)
- [SwiftUI Documentation](https://developer.apple.com/documentation/swiftui)
- [Core Media IO (CMIO)](https://developer.apple.com/documentation/coremediaio)
- [Bonjour (mDNS)](https://developer.apple.com/bonjour/)
