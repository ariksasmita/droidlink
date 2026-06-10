import SwiftUI

struct QRCodeView: View {
    let qrCode: NSImage?
    
    var body: some View {
        VStack(spacing:20) {
            if let qrCode = qrCode {
                Image(nsImage: qrCode)
                    .interpolation(.none)
                    .resizable()
                    .scaledToFit()
                    .frame(width: 250, height: 250)
                    .padding()
                    .background(Color.white)
                    .cornerRadius(12)
                    .shadow(radius: 5)
            } else {
                ProgressView()
                    .frame(width: 250, height: 250)
            }
        }
    }
}

#Preview {
    QRCodeView(qrCode: NSImage(systemSymbolName: "qrcode", accessibilityDescription: nil))
}