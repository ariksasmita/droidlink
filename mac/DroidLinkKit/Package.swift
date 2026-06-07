// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "DroidLinkKit",
    platforms: [
        .macOS(.v14)
    ],
    products: [
        .library(
            name: "DroidLinkKit",
            targets: ["DroidLinkKit"]
        ),
    ],
    dependencies: [
        .package(
            url: "https://github.com/apple/swift-protobuf.git",
            from: "1.25.3"
        ),
        .package(
            url: "https://github.com/apple/swift-log.git",
            from: "1.5.3"
        )
    ],
    targets: [
        .target(
            name: "DroidLinkKit",
            dependencies: [
                .product(name: "SwiftProtobuf", package: "swift-protobuf"),
                .product(name: "SwiftLog", package: "swift-log")
            ],
            sources: [
                "Sources/Generated/*.swift",
                "Sources/*.swift"
            ]
        ),
        .testTarget(
            name: "DroidLinkKitTests",
            dependencies: ["DroidLinkKit"]
        ),
    ]
)
