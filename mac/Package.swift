// swift-tools-version: 6.2
import PackageDescription

let package = Package(
    name: "DroidLink",
    platforms: [
        .macOS(.v14)
    ],
    dependencies: [
        .package(
            url: "https://github.com/apple/swift-protobuf.git",
            from: "1.25.3"
        )
    ],
    targets: [
        .executableTarget(
            name: "DroidLink",
            dependencies: [
                "DroidLinkKit"
            ],
            path: "Sources/DroidLink"
        ),
        .target(
            name: "DroidLinkKit",
            dependencies: [
                .product(name: "SwiftProtobuf", package: "swift-protobuf")
            ],
            path: "DroidLinkKit/Sources",
            exclude: ["Generated"]
        ),
    ]
)