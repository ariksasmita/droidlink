import Foundation
import AppKit

/// Clipboard manager for Mac
public class ClipboardManager {
    public init() {}
    private var pasteboard = NSPasteboard.general
    private var lastContent: String = ""
    
    /// Get current clipboard content
    public func getContent() -> String {
        return pasteboard.string(forType: .string) ?? ""
    }
    
    /// Set clipboard content
    public func setContent(_ text: String) {
        pasteboard.clearContents()
        pasteboard.setString(text, forType: .string)
        lastContent = text
        print("📋 Clipboard set from Android: \(text)")
    }
    
    /// Check if clipboard changed
    func didChange() -> Bool {
        let current = getContent()
        if current != lastContent && !current.isEmpty {
            lastContent = current
            return true
        }
        return false
    }
    
    /// Get changed content
    func getChangedContent() -> String? {
        if didChange() {
            return getContent()
        }
        return nil
    }
}