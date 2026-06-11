package com.droidlink.app.ui.main;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.droidlink.core.network.TlsTcpClient;
import com.droidlink.core.security.DeviceInfo;
import com.droidlink.core.security.QRCodeParser;
import com.droidlink.core.security.ValidationResult;
import com.droidlink.core.clipboard.ClipboardManager;
import kotlinx.coroutines.flow.StateFlow;
import android.content.Context;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0006\u0010\u001b\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/droidlink/app/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/droidlink/app/ui/main/MainUiState;", "clipboardManager", "Lcom/droidlink/core/clipboard/ClipboardManager;", "qrCodeParser", "Lcom/droidlink/core/security/QRCodeParser;", "tlsClient", "Lcom/droidlink/core/network/TlsTcpClient;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelPairing", "", "disconnect", "onCleared", "onQRCodeScanned", "qrData", "", "startClipboardMonitoring", "startListeningForMessages", "startPairing", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.droidlink.app.ui.main.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.droidlink.app.ui.main.MainUiState> uiState = null;
    @org.jetbrains.annotations.Nullable()
    private com.droidlink.core.network.TlsTcpClient tlsClient;
    @org.jetbrains.annotations.Nullable()
    private com.droidlink.core.clipboard.ClipboardManager clipboardManager;
    @org.jetbrains.annotations.NotNull()
    private final com.droidlink.core.security.QRCodeParser qrCodeParser = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.droidlink.app.ui.main.MainUiState> getUiState() {
        return null;
    }
    
    public final void startPairing() {
    }
    
    public final void onQRCodeScanned(@org.jetbrains.annotations.NotNull()
    java.lang.String qrData) {
    }
    
    public final void disconnect() {
    }
    
    public final void cancelPairing() {
    }
    
    private final void startClipboardMonitoring(android.content.Context context) {
    }
    
    private final void startListeningForMessages() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}