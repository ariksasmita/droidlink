package droidlink.protocol;

/**
 * ```
 * Error notification
 * ```
 *
 * Protobuf type `droidlink.protocol.ErrorMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/ErrorMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class ErrorMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.ErrorMessageKt INSTANCE = null;
    
    private ErrorMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016\u00a8\u0006 "}, d2 = {"Ldroidlink/protocol/ErrorMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "code", "getCode", "()Lerror/NonExistentClass;", "setCode", "", "codeValue", "getCodeValue", "()I", "setCodeValue", "(I)V", "", "details", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "_build", "clearCode", "", "clearDetails", "clearMessage", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.System.ErrorMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.ErrorMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.System.ErrorMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getCode")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.ErrorCode getCode() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCode")
        public final void setCode(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.ErrorCode value) {
        }
        
        @kotlin.jvm.JvmName(name = "getCodeValue")
        public final int getCodeValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setCodeValue")
        public final void setCodeValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.ErrorCode code = 1;`
         */
        public final void clearCode() {
        }
        
        @kotlin.jvm.JvmName(name = "getMessage")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setMessage")
        public final void setMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string message = 2;`
         */
        public final void clearMessage() {
        }
        
        @kotlin.jvm.JvmName(name = "getDetails")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDetails() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setDetails")
        public final void setDetails(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string details = 3;`
         */
        public final void clearDetails() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/ErrorMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/ErrorMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/ErrorMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}