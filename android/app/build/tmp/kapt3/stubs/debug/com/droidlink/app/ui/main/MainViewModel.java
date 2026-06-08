package com.droidlink.app.ui.main;

import androidx.lifecycle.ViewModel;
import com.droidlink.core.security.CertificateGenerator;
import com.droidlink.core.security.QRCodeParser;
import com.droidlink.core.security.DeviceInfo;
import com.droidlink.core.security.ValidationResult;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/droidlink/app/ui/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "certificateGenerator", "Lcom/droidlink/core/security/CertificateGenerator;", "qrCodeParser", "Lcom/droidlink/core/security/QRCodeParser;", "(Lcom/droidlink/core/security/CertificateGenerator;Lcom/droidlink/core/security/QRCodeParser;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/droidlink/app/ui/main/MainUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelPairing", "", "disconnect", "onQRCodeScanned", "qrCodeData", "", "startPairing", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.droidlink.core.security.CertificateGenerator certificateGenerator = null;
    @org.jetbrains.annotations.NotNull()
    private final com.droidlink.core.security.QRCodeParser qrCodeParser = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.droidlink.app.ui.main.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.droidlink.app.ui.main.MainUiState> uiState = null;
    
    @javax.inject.Inject()
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    com.droidlink.core.security.CertificateGenerator certificateGenerator, @org.jetbrains.annotations.NotNull()
    com.droidlink.core.security.QRCodeParser qrCodeParser) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.droidlink.app.ui.main.MainUiState> getUiState() {
        return null;
    }
    
    public final void startPairing() {
    }
    
    public final void onQRCodeScanned(@org.jetbrains.annotations.NotNull()
    java.lang.String qrCodeData) {
    }
    
    public final void disconnect() {
    }
    
    public final void cancelPairing() {
    }
}