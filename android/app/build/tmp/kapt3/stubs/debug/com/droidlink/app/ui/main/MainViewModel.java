package com.droidlink.app.ui.main;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.droidlink.core.network.TlsTcpClient;
import com.droidlink.core.security.DeviceInfo;
import com.droidlink.core.security.QRCodeParser;
import com.droidlink.core.security.ValidationResult;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/droidlink/app/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/droidlink/app/ui/main/MainUiState;", "qrCodeParser", "Lcom/droidlink/core/security/QRCodeParser;", "tlsClient", "Lcom/droidlink/core/network/TlsTcpClient;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelPairing", "", "disconnect", "onCleared", "onQRCodeScanned", "qrData", "", "startPairing", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.droidlink.app.ui.main.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.droidlink.app.ui.main.MainUiState> uiState = null;
    @org.jetbrains.annotations.Nullable()
    private com.droidlink.core.network.TlsTcpClient tlsClient;
    @org.jetbrains.annotations.NotNull()
    private final com.droidlink.core.security.QRCodeParser qrCodeParser = null;
    
    public MainViewModel() {
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
    
    @java.lang.Override()
    protected void onCleared() {
    }
}