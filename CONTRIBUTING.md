# Contributing to DroidLink

First off, thank you for considering contributing to DroidLink! It's people like you that make DroidLink a free, open-source alternative to LinkMyMac.

## 🤝 How to Contribute

### Reporting Bugs

Before creating bug reports, please check the existing issues as you might find that the problem has already been reported. If you find that your issue hasn't been filed yet, please create a new issue with:

- **Clear title**: Summarize the problem
- **Description**: What happened, what you expected, steps to reproduce
- **Environment**: Android/macOS versions, device model
- **Logs**: Relevant logcat or Console.app output
- **Screenshots**: If applicable

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion:

- **Use a clear title**: Describe the enhancement
- **Detailed description**: What problem it solves, how it should work
- **Examples**: How you envision using it
- **Alternatives considered**: Other approaches you thought about

### Pull Requests

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'feat: Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Create a Pull Request

### Development Setup

See [DEVELOPMENT.md](docs/DEVELOPMENT.md) for detailed setup instructions.

Quick start:

```bash
# Clone your fork
git clone https://github.com/YOUR_USERNAME/droidlink.git
cd droidlink

# Set up upstream
git remote add upstream https://github.com/ACTUAL_REPO/droidlink.git

# Android development
cd android && ./gradlew build

# Mac development
cd mac && xcodebuild build
```

## 📝 Code Style

### Android (Kotlin)

- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use 4 spaces for indentation
- Max line length: 120 characters
- Use explicit types for public APIs
- Document public functions with KDoc

```kotlin
/**
 * Sends clipboard data to paired device
 *
 * @param data The clipboard data to send
 * @return Result indicating success or failure
 */
suspend fun sendClipboard(data: ClipboardData): Result<Unit>
```

### Mac (Swift)

- Follow [Swift API Design Guidelines](https://swift.org/documentation/api-design-guidelines/)
- Use 4 spaces for indentation
- Max line length: 120 characters
- Use SwiftLint for code quality
- Document public APIs with comments

```swift
/// Sends clipboard data to paired device
/// - Parameter data: The clipboard data to send
/// - Returns: Result indicating success or failure
func sendClipboard(_ data: ClipboardData) async -> Result<Void, Error>
```

### Protocol Buffers

- Use snake_case for field names
- Provide comments for all messages and enums
- Document units for numeric fields
- Mark deprecated fields with `deprecated = true`

```proto
// Clipboard sync message
message ClipboardMessage {
  // The clipboard data to sync
  ClipboardData data = 1;

  // ID of the source device
  string source_device_id = 2;

  // Whether this came from a remote device
  bool is_remote = 3;
}
```

## 🧪 Testing

- Write unit tests for new features
- Add integration tests for protocol changes
- Test on physical devices when possible
- Ensure all tests pass before submitting PR

```bash
# Android tests
cd android && ./gradlew test

# Mac tests
cd mac && xcodebuild test -scheme DroidLink
```

## 📖 Commit Messages

Follow [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>(<scope>): <subject>

<body>

<footer>
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Build process or tool changes

Example:
```
feat(clipboard): Add image clipboard sync

Implement bidirectional image clipboard sync between Android and Mac.
Support PNG and JPEG formats with automatic compression.

Closes #42
```

## 🎯 Feature Development

When implementing new features:

1. **Discuss first**: Open an issue to discuss the feature
2. **Design**: Document the approach in the issue
3. **Implement**: Code the feature with tests
4. **Document**: Update relevant documentation
5. **PR**: Submit pull request with description

## 🔒 Security

If you find a security vulnerability, please **DO NOT** open a public issue. Instead, email it to the maintainers (to be created).

## 📜 License

By contributing, you agree that your contributions will be licensed under the Apache License 2.0.

## 🌟 Recognition

Contributors will be recognized in:
- CONTRIBUTORS.md file
- Release notes
- Project website (when created)

## 💬 Getting Help

- **GitHub Issues**: Bug reports, feature requests
- **GitHub Discussions**: Questions, ideas
- **Documentation**: [docs/](docs/) folder

---

Thank you for contributing to DroidLink! 🎉
