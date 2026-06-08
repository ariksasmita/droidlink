package droidlink.protocol;

/**
 * ```
 * Clipboard synchronization messages
 * ```
 *
 * Protobuf type `droidlink.protocol.ClipboardMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/ClipboardMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class ClipboardMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.ClipboardMessageKt INSTANCE = null;
    
    private ClipboardMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u000bR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Ldroidlink/protocol/ClipboardMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "data", "getData", "()Lerror/NonExistentClass;", "setData", "", "isRemote", "getIsRemote", "()Z", "setIsRemote", "(Z)V", "", "sourceDeviceId", "getSourceDeviceId", "()Ljava/lang/String;", "setSourceDeviceId", "(Ljava/lang/String;)V", "dataOrNull", "getDataOrNull", "(Ldroidlink/protocol/ClipboardMessageKt$Dsl;)Lerror/NonExistentClass;", "_build", "clearData", "", "clearIsRemote", "clearSourceDeviceId", "hasData", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Clipboard.ClipboardMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.ClipboardMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Clipboard.ClipboardMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getData")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Clipboard.ClipboardData getData() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setData")
        public final void setData(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Clipboard.ClipboardData value) {
        }
        
        /**
         * `.droidlink.protocol.ClipboardData data = 1;`
         */
        public final void clearData() {
        }
        
        /**
         * `.droidlink.protocol.ClipboardData data = 1;`
         * @return Whether the data field is set.
         */
        public final boolean hasData() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.Clipboard.ClipboardData getDataOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.ClipboardMessageKt.Dsl $this$dataOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getSourceDeviceId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSourceDeviceId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setSourceDeviceId")
        public final void setSourceDeviceId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string source_device_id = 2;`
         */
        public final void clearSourceDeviceId() {
        }
        
        @kotlin.jvm.JvmName(name = "getIsRemote")
        public final boolean getIsRemote() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "setIsRemote")
        public final void setIsRemote(boolean value) {
        }
        
        /**
         * ```
         * True if from other device
         * ```
         *
         * `bool is_remote = 3;`
         */
        public final void clearIsRemote() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/ClipboardMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/ClipboardMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/ClipboardMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}