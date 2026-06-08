package droidlink.protocol;

/**
 * ```
 * Call action from Mac to Android
 * ```
 *
 * Protobuf type `droidlink.protocol.CallAction`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/CallActionKt;", "", "()V", "Dsl", "app_debug"})
public final class CallActionKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.CallActionKt INSTANCE = null;
    
    private CallActionKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Ldroidlink/protocol/CallActionKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "action", "getAction", "()Lerror/NonExistentClass;", "setAction", "", "actionValue", "getActionValue", "()I", "setActionValue", "(I)V", "", "callId", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "_build", "clearAction", "", "clearCallId", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Call.CallAction.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.CallActionKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Call.CallAction.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getAction")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Call.CallAction.ActionType getAction() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setAction")
        public final void setAction(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Call.CallAction.ActionType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getActionValue")
        public final int getActionValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setActionValue")
        public final void setActionValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.CallAction.ActionType action = 1;`
         */
        public final void clearAction() {
        }
        
        @kotlin.jvm.JvmName(name = "getCallId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCallId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCallId")
        public final void setCallId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string call_id = 2;`
         */
        public final void clearCallId() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/CallActionKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/CallActionKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/CallActionKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}