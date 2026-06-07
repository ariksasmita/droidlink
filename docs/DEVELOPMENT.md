# DroidLink Development Guide

**Setup guide for contributing to DroidLink**

---

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Repository Structure](#repository-structure)
3. [Android Development](#android-development)
4. [Mac Development](#mac-development)
5. [Protocol Development](#protocol-development)
6. [Testing](#testing)
7. [Debugging](#debugging)
8. [Release Process](#release-process)

---

## Prerequisites

### Android Development
- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: 17 or later (bundled with Android Studio)
- **Android SDK**: API 34 (Android 14) minimum
- **Kotlin**: 2.0.0 or later
- **Gradle**: 8.5 or later

### Mac Development
- **Xcode**: 15.0 or later
- **Swift**: 6.0 or later
- **macOS**: Sonoma (14.0) or later
- **Xcode Command Line Tools**: `xcode-select --install`

### Protocol Development
- **Protocol Buffer Compiler**: `protoc` 3.19 or later
- **Swift Protobuf**: 1.25.0 or later
- **Kotlin Protobuf**: 3.0.0 or later

### General
- **Git**: 2.30 or later
- **GitHub Account**: For contributing
- **Physical Devices**:
  - Android phone (Android 10+) for testing
  - Mac with Sonoma+ for development

---

## Repository Structure

```
droidlink/
├── android/                   # Android app
├── mac/                       # macOS app
├── protocol/                  # Shared protocol
├── docs/                      # Documentation
├── scripts/                   # Build/deploy scripts
├── AGENTS.md                  # Project context
├── PLAN.md                    # Development plan
└── README.md                  # Project overview
```

### Initial Setup

```bash
# Clone repository
git clone https://github.com/yourusername/droidlink.git
cd droidlink

# Install git hooks (pre-commit, etc.)
cp scripts/pre-commit .git/hooks/
chmod +x .git/hooks/pre-commit

# Initialize submodules (if any)
git submodule update --init --recursive
```

---

## Android Development

### Project Setup

```bash
cd android

# Generate gradle wrapper (if not present)
gradle wrapper --gradle-version 8.5

# Open in Android Studio
# File → Open → select android/ directory
```

### Build Variants

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease

# Install debug APK to connected device
./gradlew installDebug

# Run all tests
./gradlew test

# Run instrumented tests
./gradlew connectedAndroidTest
```

### Key Files

```
android/
├── build.gradle.kts           # Project-level config
├── app/build.gradle.kts       # App module config
├── app/src/main/
│   ├── AndroidManifest.xml    # Permissions, components
│   ├── kotlin/                # Kotlin source
│   └── res/                   # Resources (strings, drawables)
└── gradle.properties          # Gradle properties
```

### Gradle Properties

```properties
# gradle.properties
org.gradle.jvmargs=-Xmx4096m -XX:MaxMetaspaceSize=512m
android.useAndroidX=true
android.enableJetifier=true
kotlin.code.style=official
android.nonTransitiveRClass=true
```

### Common Issues

**Problem**: Gradle sync fails with SSL errors
```bash
# Solution: Add SSL certificates or disable verification (NOT for production)
./gradlew assembleDebug --no-daemon -Djavax.net.ssl.trustStoreType=jks
```

**Problem**: Build fails with "Out of memory"
```bash
# Solution: Increase Gradle heap size
./gradlew assembleDebug -Dorg.gradle.jvmargs="-Xmx8192m"
```

---

## Mac Development

### Project Setup

```bash
cd mac

# Initialize Swift Package (if using SPM)
swift package init --type executable

# Or if using Xcode project:
# File → Open → select mac/DroidLink.xcodeproj
```

### Build from Command Line

```bash
# Build all schemes
xcodebuild -scheme DroidLink build

# Build for testing
xcodebuild -scheme DroidLink -destination 'platform=macOS' build

# Run tests
xcodebuild test -scheme DroidLink

# Clean build folder
xcodebuild clean -scheme DroidLink
```

### Key Files

```
mac/
├── DroidLink.xcodeproj/       # Xcode project
├── DroidLink/                 # Main app
│   ├── Info.plist            # App configuration
│   ├── AppDelegate.swift      # App lifecycle
│   └── Assets.xcassets/      # Assets
└── DroidLinkKit/             # Shared framework
    └── ...
```

### Code Signing

```bash
# Development signing (automatic)
xcodebuild -scheme DroidLink \
  -destination 'platform=macOS' \
  CODE_SIGN_IDENTITY="-" \
  CODE_SIGNING_REQUIRED=NO

# Release signing (requires Apple Developer account)
xcodebuild -scheme DroidLink \
  -destination 'platform=macOS' \
  CODE_SIGN_IDENTITY="Developer ID Application: Your Name" \
  CODE_SIGNING_REQUIRED=YES
```

### Common Issues

**Problem**: Code signing fails
```bash
# Solution: Check certificate provisioning
security find-identity -v -p codesigning

# Or disable for development
CODE_SIGN_IDENTITY="-"
```

**Problem**: Swift Package Manager fails to resolve dependencies
```bash
# Solution: Clean and retry
swift package reset
swift package update
```

---

## Protocol Development

### Protocol Buffer Installation

```bash
# macOS
brew install protobuf

# Linux
sudo apt-get install protobuf-compiler libprotoc-dev

# Verify installation
protoc --version
```

### Generate Code from `.proto` Files

```bash
cd protocol

# Generate Kotlin code
protoc --kotlin_out=../android/app/src/main/kotlin/ \
  --proto_path=. \
  protos/*.proto

# Generate Swift code
protoc --swift_out=../mac/DroidLinkKit/Generated/ \
  --proto_path=. \
  protos/*.proto
```

### Protocol Buffer Compilation Script

```bash
#!/bin/bash
# scripts/generate-protos.sh

set -e

PROTO_DIR="protocol/protos"
ANDROID_OUTPUT="android/app/src/main/kotlin/droidlink/protocol"
MAC_OUTPUT="mac/DroidLinkKit/Generated"

echo "Generating Kotlin code..."
mkdir -p "$ANDROID_OUTPUT"
protoc --kotlin_out="$ANDROID_OUTPUT" \
  --proto_path="$PROTO_DIR" \
  "$PROTO_DIR"/*.proto

echo "Generating Swift code..."
mkdir -p "$MAC_OUTPUT"
protoc --swift_out="$MAC_OUTPUT" \
  --proto_path="$PROTO_DIR" \
  "$PROTO_DIR"/*.proto

echo "✓ Protocol buffers generated"
```

---

## Testing

### Android Tests

```bash
cd android

# Unit tests (JVM)
./gradlew test

# Instrumented tests (requires emulator/device)
./gradlew connectedAndroidTest

# Specific test class
./gradlew test --tests ClipboardRepositoryTest

# With coverage report
./gradlew test jacocoTestReport
```

### Mac Tests

```bash
cd mac

# Run all tests
xcodebuild test -scheme DroidLink

# Run specific test
xcodebuild test -scheme DroidLink -only-testing:DroidLinkTests/ClipboardRepositoryTest

# With coverage
xcodebuild test -scheme DroidLink -enableCodeCoverage YES
```

### Integration Tests

```bash
# Test USB connection (requires physical devices)
./scripts/integration-test-usb.sh

# Test Wi-Fi connection (requires both devices on same network)
./scripts/integration-test-wifi.sh
```

---

## Debugging

### Android Debugging

```bash
# View logs
adb logcat | grep DroidLink

# View logs for specific module
adb logcat | grep -E "(DroidLink|Clipboard|Notification)"

# Clear logs
adb logcat -c

# Debug APK
./gradlew installDebug
adb shell am start -n com.droidlink.app/.MainActivity
```

### Mac Debugging

```bash
# View logs in Console.app
log stream --predicate 'process == "DroidLink"' --level debug

# Or use built-in Xcode debugger
# Run → Debug
```

### Protocol Debugging

```bash
# Capture TCP traffic (requires root)
sudo tcpdump -i any -w droidlink.pcap port 8080

# Analyze with Wireshark
wireshark droidlink.pcap

# View Protocol Buffer messages
python scripts/decode-protobuf.py droidlink.pcap
```

---

## Release Process

### Version Bumping

```bash
# Android: Update version in build.gradle.kts
android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"
    }
}

# Mac: Update version in Info.plist
<key>CFBundleShortVersionString</key>
<string>1.0.0</string>
<key>CFBundleVersion</key>
<string>1</string>
```

### Creating Release

```bash
# 1. Bump version
# 2. Update CHANGELOG.md
# 3. Commit changes
git add .
git commit -m "Release v1.0.0"
git tag v1.0.0

# 4. Build release artifacts
cd android && ./gradlew bundleRelease
cd ../mac && xcodebuild archive -scheme DroidLink

# 5. Push to GitHub
git push origin main --tags
```

### Android Release

```bash
# Generate signed APK
./gradlew assembleRelease \
  -Pandroid.injected.signing.store.file=$KEYSTORE \
  -Pandroid.injected.signing.store.password=$STORE_PASSWORD \
  -Pandroid.injected.signing.key.alias=$KEY_ALIAS \
  -Pandroid.injected.signing.key.password=$KEY_PASSWORD

# Output: app/build/outputs/apk/release/app-release.apk
```

### Mac Release

```bash
# Generate signed DMG
xcodebuild -exportArchive \
  -archivePath DroidLink.xcarchive \
  -exportPath ./build \
  -exportOptionsPlist ExportOptions.plist

# Output: build/DroidLink.dmg
```

---

## IDE Configuration

### Android Studio

**Recommended Plugins**:
- Kotlin
- Protobuf Support
- GitLens
- Rainbow Brackets

**Code Style**:
- Use official Kotlin code style
- Enable "Organize Imports" on save
- Set line length to 120 characters

### Xcode

**Recommended Settings**:
- Enable "Indent using tabs"
- Set line width to 120 characters
- Enable "SwiftLint" for code quality

**Key Bindings**:
- `⌘ + B`: Build
- `⌘ + R`: Run
- `⌘ + .`: Stop
- `⌘ + Shift + K`: Clean Build

---

## Continuous Integration

### GitHub Actions

```yaml
# .github/workflows/ci.yml
name: CI

on: [push, pull_request]

jobs:
  android-tests:
    runs-on: macos-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Run tests
        run: |
          cd android
          ./gradlew test

  mac-tests:
    runs-on: macos-latest
    steps:
      - uses: actions/checkout@v3
      - name: Run tests
        run: |
          cd mac
          xcodebuild test -scheme DroidLink
```

---

## Contributing

### Pull Request Process

1. Fork the repository
2. Create feature branch (`git checkout -b feature/my-feature`)
3. Make changes and commit
4. Run tests (`./gradlew test` and `xcodebuild test`)
5. Push to fork (`git push origin feature/my-feature`)
6. Create pull request on GitHub

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

**Types**:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation change
- `style`: Code style change (formatting)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Build process or tool change

**Example**:
```
feat(clipboard): Add image clipboard sync

Implement bidirectional image clipboard sync between Android and Mac.
Support PNG and JPEG formats with automatic compression.

Closes #42
```

---

## Troubleshooting

### Common Build Issues

**Android: "Unresolved reference" errors**
```bash
# Solution: Clean and rebuild
./gradlew clean build
```

**Mac: "Command SwiftBuild failed"**
```bash
# Solution: Clean build folder
xcodebuild clean -scheme DroidLink
```

**Protocol: "protoc not found"**
```bash
# Solution: Install protobuf compiler
brew install protobuf
```

### Runtime Issues

**Android: "Permission denied" errors**
```bash
# Solution: Grant permissions in Settings
adb shell pm grant com.droidlink.app android.permission.POST_NOTIFICATIONS
```

**Mac: "App can't be opened because it's from an unidentified developer"**
```bash
# Solution: Allow in System Preferences or remove quarantine
xattr -cr /Applications/DroidLink.app
```

---

## Resources

### Documentation
- [Android Developer Guide](https://developer.android.com/guide)
- [Apple Developer Guide](https://developer.apple.com/documentation)
- [Protocol Buffers](https://developers.google.com/protocol-buffers)

### Community
- GitHub Issues: [Bug reports, feature requests](https://github.com/yourusername/droidlink/issues)
- GitHub Discussions: [Q&A, community discussions](https://github.com/yourusername/droidlink/discussions)
- Discord/Matrix: (to be created)

---

**Status**: ✅ Development guide complete

**Last Updated**: 2025-06-07
