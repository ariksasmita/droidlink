import SwiftUI
import AppKit

@main
struct DroidLinkApp {
    static func main() {
        print("🚀 DroidLink starting...")
        
        let app = NSApplication.shared
        app.setActivationPolicy(.regular)
        
        @MainActor
        class AppDelegate: NSObject, NSApplicationDelegate {
            func applicationDidFinishLaunching(_ notification: Notification) {
                print("✅ App did finish launching")
                
                let app = NSApplication.shared
                
                let window = NSWindow(
                    contentRect: NSRect(x: 0, y: 0, width: 600, height: 400),
                    styleMask: [.titled, .closable, .miniaturizable],
                    backing: .buffered,
                    defer: false
                )
                window.center()
                window.title = "DroidLink"
                
                // Import DroidLinkKit and use ContentView
                let contentView = ContentView()
                window.contentView = NSHostingView(rootView: contentView)
                window.makeKeyAndOrderFront(nil)
                
                app.activate(ignoringOtherApps: true)
                
                print("✅ DroidLink window shown")
            }
            
            func applicationShouldTerminateAfterLastWindowClosed(_ sender: NSApplication) -> Bool {
                return false
            }
        }
        
        let delegate = AppDelegate()
        app.delegate = delegate
        
        print("🔄 Starting run loop...")
        app.run()
    }
}