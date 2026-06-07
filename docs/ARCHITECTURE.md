# DroidLink Architecture Blueprint

**System architecture for local-first Android ↔ Mac device bridging**

---

## Table of Contents
1. [System Overview](#system-overview)
2. [Architecture Principles](#architecture-principles)
3. [Component Architecture](#component-architecture)
4. [Data Flow](#data-flow)
5. [Protocol Design](#protocol-design)
6. [Security Model](#security-model)
7. [Error Handling](#error-handling)
8. [Performance Considerations](#performance-considerations)

---

## System Overview

DroidLink uses a **client-server architecture** with bidirectional communication:

```
┌──────────────────┐                    ┌──────────────────┐
│     Android      │                    │       Mac        │
│                  │                    │                  │
│  ┌────────────┐ │                    │ ┌────────────┐   │
│  │  Feature   │ │                    │ │  Feature  │   │
│  │  Modules   │ │                    │ │  Modules  │   │
│  └────────────┘ │                    │ └────────────┘   │
│         │        │                    │         │        │
│  ┌─────▼─────┐  │    Protocol Buffer │ ┌─────▼─────┐   │
│  │ Protocol  │◄─┼─────────────────────┼─┤  Protocol │   │
│  │   Layer   │  │     (TCP + TLS)    │ │   Layer   │   │
│  └─────┬─────┘  │                    │ └─────┬─────┘   │
│         │        │                    │         │        │
│  ┌─────▼─────┐  │                    │ ┌─────▼─────┐   │
│  │ Transport │◄─┼────── USB/Wi-Fi ───┼─┤ Transport │   │
│  │   Layer   │  │                    │ │   Layer   │   │
│  └────────────┘ │                    │ └────────────┘   │
└──────────────────┘                    └──────────────────┘
```

### Key Design Decisions

1. **Local-First**: All communication is device-to-device, no cloud relay
2. **Protocol Buffers**: Binary protocol for efficiency and backward compatibility
3. **Feature Modules**: Each feature is an independent module with clear API boundaries
4. **Clean Architecture**: Separation of concerns with clear dependency rules
5. **Event-Driven**: Async streams (Coroutines/Flow on Android, Combine on Mac)

---

## Architecture Principles

### 1. Modularity
Each feature is a separate module with API/IMPL pattern:
- `:feature-clipboard:api` — Public interface
- `:feature-clipboard:impl` — Implementation
- Core modules provide shared utilities

### 2. Separation of Concerns
- **UI Layer**: Views, ViewModels, State management
- **Domain Layer**: Business logic, Use cases
- **Data Layer**: Repositories, Data sources, Protocol clients

### 3. Dependency Direction
```
UI → Domain → Data → Protocol → Transport
```
Dependencies flow downward, never upward.

### 4. Testability
- All layers are unit testable with mocked dependencies
- Protocol layer is protocol-agnostic (can use fake transport for tests)
- UI layer can be tested with fake protocol layer

---

## Component Architecture

### Android App Structure

```
android/
├── app/                                    # Main application
│   ├── MainActivity.kt                     # App entry point
│   ├── DroidLinkApplication.kt            # DI setup
│   └── ui/                                 # Compose UI
│
├── core/                                   # Shared core utilities
│   ├── network/                           # Protocol + Transport
│   │   ├── protocol/                      # Protocol Buffer messages
│   │   │   ├── ProtobufSerializer.kt      # Proto serialization
│   │   │   └── MessageFramer.kt           # Message framing
│   │   ├── transport/                     # Transport layer
│   │   │   ├── Transport.kt               # Transport interface
│   │   │   ├── UsbTransport.kt           # USB implementation
│   │   │   └── WifiTransport.kt           # Wi-Fi implementation
│   │   └── DroidLinkClient.kt             # Main client
│   │
│   ├── permissions/                       # Permission handling
│   │   ├── PermissionManager.kt           # Permission requests
│   │   └── NotificationPermission.kt      # Notification listener
│   │
│   ├── security/                           # Security & crypto
│   │   ├── CertificateManager.kt         # Certificate generation
│   │   ├── TlsManager.kt                 # TLS setup
│   │   └── KeyStoreManager.kt            # Secure storage
│   │
│   └── discovery/                         # Device discovery
│       ├── MdnsDiscoveryManager.kt        # mDNS/Bonjour
│       └── PairingManager.kt             # QR pairing flow
│
├── feature-clipboard/                     # Clipboard sync
│   ├── api/
│   │   └── ClipboardRepository.kt         # Public interface
│   └── impl/
│       ├── ClipboardRepositoryImpl.kt     # Implementation
│       ├── ClipboardListener.kt           # Android clipboard monitoring
│       └── ClipboardSyncService.kt        # Sync service
│
├── feature-notifications/                 # Notification mirror
│   ├── api/
│   │   └── NotificationRepository.kt
│   └── impl/
│       ├── NotificationRepositoryImpl.kt
│       ├── DroidLinkNotificationService.kt
│       └── NotificationConverter.kt       # Android → Mac format
│
├── feature-files/                         # File transfer
│   ├── api/
│   │   └── FileRepository.kt
│   └── impl/
│       ├── FileRepositoryImpl.kt
│       ├── FileServer.kt                 # Ktor HTTP server
│       └── FileTransferManager.kt
│
├── feature-screen/                        # Screen mirroring
│   ├── api/
│   │   └── ScreenRepository.kt
│   └── impl/
│       ├── ScreenRepositoryImpl.kt
│       ├── ScreenCaptureService.kt        # MediaProjection
│       ├── VideoEncoder.kt               # H.264 encoding
│       └── StreamingServer.kt            # Video streaming
│
├── feature-media/                         # Virtual webcam/mic
│   ├── api/
│   │   └── MediaRepository.kt
│   └── impl/
│       ├── MediaRepositoryImpl.kt
│       ├── CameraCaptureService.kt        # CameraX
│       └── AudioCaptureService.kt        # AudioRecord
│
└── feature-calls/                         # Call handling
    ├── api/
    │   └── CallRepository.kt
    └── impl/
        ├── CallRepositoryImpl.kt
        └── TelephonyMonitor.kt           # TelephonyManager
```

### Mac App Structure

```
mac/
├── DroidLink/                             # Main app
│   ├── App/
│   │   ├── DroidLinkApp.swift            # App entry point
│   │   └── AppDelegate.swift             # App lifecycle
│   ├── Views/
│   │   ├── MainView.swift                # Main window
│   │   ├── PairingView.swift             # QR pairing UI
│   │   ├── SettingsView.swift            # Settings
│   │   └── FeatureViews/                 # Per-feature views
│   │       ├── ClipboardView.swift
│   │       ├── NotificationsView.swift
│   │       ├── FilesView.swift
│   │       └── ScreenMirroringView.swift
│   ├── ViewModels/
│   │   ├── MainViewModel.swift
│   │   ├── PairingViewModel.swift
│   │   └── FeatureViewModels/
│   ├── Models/
│   │   ├── AppState.swift                # App state
│   │   └── PairedDevice.swift           # Paired device info
│   └── Resources/                        # Assets, localization
│
├── DroidLinkMenu/                         # Menu bar extension
│   ├── MenuBarController.swift           # NSStatusBar
│   ├── MenuBarViewModel.swift
│   └── Views/
│       ├── ClipboardMenuView.swift
│       └── QuickActionsMenu.swift
│
├── DroidLinkKit/                          # Shared framework
│   ├── Networking/
│   │   ├── protocol/                     # Protocol Buffer messages
│   │   │   ├── ProtobufSerializer.swift
│   │   │   └── MessageFramer.swift
│   │   ├── transport/                    # Transport layer
│   │   │   ├── Transport.swift
│   │   │   ├── UsbTransport.swift        # libusb
│   │   │   └── WifiTransport.swift
│   │   └── DroidLinkServer.swift         # Main server
│   │
│   ├── Discovery/
│   │   ├── BonjourManager.swift          # mDNS/Bonjour
│   │   └── PairingManager.swift          # QR pairing
│   │
│   ├── VirtualDevices/
│   │   ├── VirtualCamera/                # CMIO DAL plug-in
│   │   │   ├── CMIO-Plug-in/
│   │   │   ├── CameraStream.swift
│   │   │   └── FrameReceiver.swift
│   │   └── VirtualMicrophone/
│   │       ├── CMIO-Plug-in/
│   │       ├── AudioStream.swift
│   │       └── AudioReceiver.swift
│   │
│   ├── Repositories/                     # Feature repositories
│   │   ├── ClipboardRepository.swift
│   │   ├── NotificationRepository.swift
│   │   ├── FileRepository.swift
│   │   ├── ScreenRepository.swift
│   │   └── MediaRepository.swift
│   │
│   └── Security/
│       ├── CertificateManager.swift
│       ├── TlsManager.swift
│       └── KeychainManager.swift
│
└── DroidLinkTests/                        # Test suite
    ├── ProtocolTests/
    ├── TransportTests/
    └── RepositoryTests/
```

---

## Data Flow

### Example: Clipboard Sync

```
1. User copies text on Android
   │
   ▼
2. ClipboardListener detects change
   │
   ▼
3. ClipboardSyncService validates (not empty, not same as last)
   │
   ▼
4. ClipboardRepository.sendToMac(ClipboardData)
   │
   ▼
5. DroidLinkClient.send(ClipboardMessage)
   │
   ▼
6. ProtobufSerializer.serialize(ClipboardMessage)
   │
   ▼
7. MessageFramer.frame(serializedMessage)
   │
   ▼
8. Transport.send(framedMessage)
   │
   ▼
9. USB or Wi-Fi transfer
   │
   ▼
10. Mac Transport receives framed message
    │
    ▼
11. MessageFramer.deframe(message)
    │
    ▼
12. ProtobufSerializer.deserialize(message)
    │
    ▼
13. DroidLinkServer.handle(ClipboardMessage)
    │
    ▼
14. ClipboardRepository.updateMacClipboard(data)
    │
    ▼
15. NSPasteboard.general.setString(data)
```

### Error Handling Flow

```
Transport Error
    │
    ▼
Transport.onError(error)
    │
    ▼
DroidLinkClient.handleTransportError(error)
    │
    ├─── if reconnection needed ──> ReconnectManager.scheduleReconnect()
    │
    └─── if fatal ──> AppState.notifyUser(error)
```

---

## Protocol Design

### Message Framing

```
┌─────────────────────────────────────────────────┐
│  Frame Header (4 bytes)                         │
│  ├─ Length (3 bytes, big-endian)               │
│  └─ Type (1 byte)                               │
│      ├─ 0x01: Data                              │
│      ├─ 0x02: Heartbeat                         │
│      └─ 0x03: Error                             │
├─────────────────────────────────────────────────┤
│  Protobuf Message (variable length)            │
│  └─ Serialized Protocol Buffer message         │
└─────────────────────────────────────────────────┘
```

### Message Types (Protocol Buffers)

```proto
// Root message type
message DroidLinkMessage {
  uint64 id = 1;           // Unique message ID
  uint64 timestamp = 2;    // Unix timestamp (ms)
  MessageType type = 3;    // Message type

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

### Clipboard Message

```proto
message ClipboardMessage {
  ClipboardData data = 1;
  string source_device_id = 2;
}

message ClipboardData {
  DataType type = 1;
  string text = 2;
  bytes image_data = 3;      // PNG or JPEG
  string url = 4;
}

enum DataType {
  UNKNOWN = 0;
  TEXT = 1;
  IMAGE = 2;
  URL = 3;
}
```

### Notification Message

```proto
message NotificationMessage {
  string id = 1;             // Android notification ID
  string package_name = 2;   // App package name
  string app_name = 3;       // Display name
  string title = 4;
  string text = 5;
  repeated NotificationAction actions = 6;
  int64 timestamp = 7;
  bytes icon = 8;            // App icon (PNG)
  bool is_clearable = 9;     // Can be dismissed
}

message NotificationAction {
  string id = 1;
  string label = 2;
  ActionType type = 3;
}

enum ActionType {
  UNKNOWN = 0;
  REPLY = 1;
  DISMISS = 2;
  CUSTOM = 3;
}
```

### File Transfer Message

```proto
message FileMessage {
  enum FileOperation {
    UNKNOWN = 0;
    LIST_REQUEST = 1;       // Request file listing
    LIST_RESPONSE = 2;      // File listing
    DOWNLOAD_REQUEST = 3;   // Request download
    DOWNLOAD_RESPONSE = 4;  // File data
    UPLOAD_REQUEST = 5;     // Push file
    DELETE = 6;             // Delete file
  }

  FileOperation operation = 1;
  string file_path = 2;
  int64 file_size = 3;
  string mime_type = 4;
  bytes file_data = 5;      // Chunked data
  int32 chunk_index = 6;    // For multi-chunk transfers
  int32 total_chunks = 7;
}
```

### Screen Mirroring Message

```proto
message ScreenMessage {
  enum StreamEventType {
    START = 0;
    FRAME = 1;
    STOP = 2;
    ERROR = 3;
  }

  StreamEventType event = 1;
  int32 width = 2;
  int32 height = 3;
  bytes frame_data = 4;     // H.264 encoded frame
  int32 frame_number = 5;
  int64 timestamp = 6;
}
```

---

## Security Model

### Pairing Flow (Certificate-Based)

```
1. Mac generates self-signed certificate
   │
   ▼
2. Mac displays QR code with certificate fingerprint
   │
   ▼
3. Android scans QR code
   │
   ▼
4. Android generates own certificate
   │
   ▼
5. TLS handshake with mutual certificate verification
   │
   ▼
6. Android stores Mac certificate fingerprint
   │
   ▼
7. Mac stores Android certificate fingerprint
   │
   ▼
8. All further connections use TLS 1.3 with stored certificates
```

### Certificate Storage

- **Android**: AndroidKeyStore (hardware-backed if available)
- **Mac**: Keychain (encrypted with user password)
- **Certificate format**: X.509 with SHA-256 fingerprints
- **Key size**: 2048-bit RSA or 256-bit ECC

### Attack Mitigation

| Threat | Mitigation |
|--------|-----------|
| Man-in-the-middle | TLS 1.3 + certificate pinning |
| QR code tampering | User visual verification (fingerprint display) |
| Device spoofing | Certificate fingerprint validation |
| Replay attacks | Nonce in pairing handshake |
| Unauthorized access | No API exposed outside local network |

---

## Error Handling

### Error Categories

```kotlin
// Android
sealed class DroidLinkError {
    object NetworkUnavailable : DroidLinkError()
    object PairingFailed : DroidLinkError()
    data class TransportError(val cause: Throwable) : DroidLinkError()
    data class ProtocolError(val message: String) : DroidLinkError()
    object PermissionDenied : DroidLinkError()
    object Disconnected : DroidLinkError()
}
```

```swift
// Mac
enum DroidLinkError: Error {
    case networkUnavailable
    case pairingFailed
    case transportError(Error)
    case protocolError(String)
    case permissionDenied
    case disconnected
}
```

### Retry Strategy

```kotlin
data class RetryPolicy(
    val maxRetries: Int = 3,
    val initialDelayMs: Long = 1000,
    val maxDelayMs: Long = 30000,
    val backoffMultiplier: Double = 2.0
)

fun shouldRetry(attempt: Int, policy: RetryPolicy): Boolean {
    return attempt < policy.maxRetries
}

fun calculateDelay(attempt: Int, policy: RetryPolicy): Long {
    val delay = policy.initialDelayMs * policy.backoffMultiplier.pow(attempt)
    return delay.toLong().coerceAtMost(policy.maxDelayMs)
}
```

---

## Performance Considerations

### Clipboard Sync
- **Latency target**: <100ms
- **Optimization**: Debounce rapid changes (100ms window)
- **Payload size**: <1MB for images (compress if larger)

### Notification Mirror
- **Latency target**: <500ms
- **Optimization**: Batch notifications if multiple arrive quickly
- **Payload size**: <100KB per notification (icon compression)

### File Transfer
- **Throughput target**: >20MB/s (USB), >5MB/s (Wi-Fi)
- **Optimization**: Chunked transfers with resume support
- **Chunk size**: 256KB

### Screen Mirroring
- **Latency target**: <200ms
- **Frame rate**: 30fps
- **Resolution**: Adaptive (720p base, scale based on bandwidth)
- **Bitrate**: 2-5Mbps H.264

### Battery Optimization
- **Idle drain**: <2%/hour
- **Active drain**: <10%/hour (screen mirroring)
- **Optimization**: Suspend unused features, adaptive polling

---

## Concurrency Model

### Android (Coroutines)

```kotlin
// Feature repository with concurrent streams
class ClipboardRepositoryImpl(
    private val client: DroidLinkClient,
    private val clipboardManager: ClipboardManager
) : ClipboardRepository {

    private val _incomingClipboard = MutableSharedFlow<ClipboardData>()
    override val incomingClipboard: SharedFlow<ClipboardData> = _incomingClipboard.asSharedFlow()

    init {
        // Launch coroutine for incoming messages
        CoroutineScope(Dispatchers.IO).launch {
            client.incomingMessages
                .filter { it.type == MessageType.CLIPBOARD_SYNC }
                .collect { message ->
                    _incomingClipboard.emit(message.clipboard.data)
                }
        }

        // Launch coroutine for outgoing changes
        CoroutineScope(Dispatchers.Main).launch {
            clipboardManager.clipboardChanges.collect { data ->
                client.sendClipboard(data)
            }
        }
    }
}
```

### Mac (Combine)

```swift
class ClipboardRepository {
    private let client: DroidLinkServer
    private let pasteboard: NSPasteboard

    var incomingClipboard: AnyPublisher<ClipboardData, Never> {
        client.incomingMessages
            .filter { $0.type == .clipboardSync }
            .compactMap { $0.clipboard?.data }
            .eraseToAnyPublisher()
    }

    init() {
        // Subscribe to clipboard changes
        NSPasteboard.didChangeNotification
            .sink { [weak self] _ in
                self?.sendClipboardToAndroid()
            }
            .store(in: &cancellables)

        // Subscribe to incoming messages
        client.incomingMessages
            .filter { $0.type == .clipboardSync }
            .sink { [weak self] message in
                self?.updateMacClipboard(message.clipboard.data)
            }
            .store(in: &cancellables)
    }
}
```

---

## Thread Safety

### Android
- **UI updates**: Main thread (Dispatchers.Main)
- **Network I/O**: IO dispatcher (Dispatchers.IO)
- **Protocol serialization**: IO dispatcher
- **State changes**: Single-threaded dispatcher (Main)

### Mac
- **UI updates**: @MainActor
- **Network I/O**: Background queue
- **Protocol serialization**: Background queue
- **State changes**: Main actor

---

## Testing Architecture

### Unit Tests

```kotlin
// Example: ClipboardRepository test
class ClipboardRepositoryTest {

    @Test
    fun `incoming clipboard message is emitted`() = runTest {
        // Given
        val fakeClient = FakeDroidLinkClient()
        val repository = ClipboardRepositoryImpl(fakeClient, mockClipboardManager)

        // When
        val message = DroidLinkMessage(
            type = MessageType.CLIPBOARD_SYNC,
            clipboard = ClipboardMessage(data = ClipboardData(text = "Hello"))
        )
        fakeClient.emitIncomingMessage(message)

        // Then
        assertEquals("Hello", repository.incomingClipboard.first().text)
    }
}
```

### Integration Tests

```kotlin
// Example: USB transport integration test
class UsbTransportIntegrationTest {

    @Test
    fun `USB connection lifecycle works end-to-end`() {
        // Given: Real Android device with USB connected

        // When: Connect and send message
        val transport = UsbTransport(device)
        transport.connect()
        transport.send(testMessage)

        // Then: Message received on other side
        assertEquals(testMessage, receivedMessage)
    }
}
```

---

## Deployment Architecture

### Android
- **Build**: Gradle (Kotlin DSL)
- **Distribution**: Google Play Store + F-Droid + APK
- **Signing**: Release APK signed with app signing key
- **Proguard**: Enabled for release builds

### Mac
- **Build**: Xcode (Swift Package Manager)
- **Distribution**: App Store + Direct DMG
- **Signing**: Developer ID certificate
- **Notarization**: Apple notarization for direct downloads

---

## Monitoring & Observability

### Logging Strategy

```kotlin
// Structured logging
sealed class LogEvent {
    data class ConnectionEvent(val status: ConnectionStatus) : LogEvent()
    data class ErrorEvent(val error: DroidLinkError) : LogEvent()
    data class PerformanceEvent(
        val operation: String,
        val durationMs: Long
    ) : LogEvent()
}

// Usage
logger.log(LogEvent.ConnectionEvent(status = "CONNECTED"))
logger.log(LogEvent.PerformanceEvent("clipboard_sync", 45))
```

### Performance Metrics

- Connection establishment time
- Message round-trip latency
- Feature-specific metrics (clipboard sync time, file transfer throughput)
- Battery drain rate
- Memory usage per feature

---

**Status**: ✅ Architecture complete — ready for implementation

**Last Updated**: 2025-06-07
