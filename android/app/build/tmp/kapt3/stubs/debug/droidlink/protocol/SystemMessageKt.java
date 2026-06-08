package droidlink.protocol;

/**
 * ```
 * Connection lifecycle and system control messages
 * ```
 *
 * Protobuf type `droidlink.protocol.SystemMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/SystemMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class SystemMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.SystemMessageKt INSTANCE = null;
    
    private SystemMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010!\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u0004R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u000e8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0004R$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u0004R\u0015\u0010\u001a\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u001d\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\u001f\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001c\u00a8\u0006,"}, d2 = {"Ldroidlink/protocol/SystemMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "error", "getError", "()Lerror/NonExistentClass;", "setError", "event", "getEvent", "setEvent", "", "eventValue", "getEventValue", "()I", "setEventValue", "(I)V", "hello", "getHello", "setHello", "helloAck", "getHelloAck", "setHelloAck", "errorOrNull", "getErrorOrNull", "(Ldroidlink/protocol/SystemMessageKt$Dsl;)Lerror/NonExistentClass;", "helloAckOrNull", "getHelloAckOrNull", "helloOrNull", "getHelloOrNull", "_build", "clearError", "", "clearEvent", "clearHello", "clearHelloAck", "hasError", "", "hasHello", "hasHelloAck", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.System.SystemMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.SystemMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.System.SystemMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getEvent")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.SystemMessage.SystemEventType getEvent() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setEvent")
        public final void setEvent(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.SystemMessage.SystemEventType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getEventValue")
        public final int getEventValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setEventValue")
        public final void setEventValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.SystemMessage.SystemEventType event = 1;`
         */
        public final void clearEvent() {
        }
        
        @kotlin.jvm.JvmName(name = "getHello")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.HelloMessage getHello() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setHello")
        public final void setHello(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.HelloMessage value) {
        }
        
        /**
         * ```
         * For HELLO
         * ```
         *
         * `.droidlink.protocol.HelloMessage hello = 10;`
         */
        public final void clearHello() {
        }
        
        /**
         * ```
         * For HELLO
         * ```
         *
         * `.droidlink.protocol.HelloMessage hello = 10;`
         * @return Whether the hello field is set.
         */
        public final boolean hasHello() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.System.HelloMessage getHelloOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.SystemMessageKt.Dsl $this$helloOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getHelloAck")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.HelloAckMessage getHelloAck() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setHelloAck")
        public final void setHelloAck(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.HelloAckMessage value) {
        }
        
        /**
         * ```
         * For HELLO_ACK
         * ```
         *
         * `.droidlink.protocol.HelloAckMessage hello_ack = 11;`
         */
        public final void clearHelloAck() {
        }
        
        /**
         * ```
         * For HELLO_ACK
         * ```
         *
         * `.droidlink.protocol.HelloAckMessage hello_ack = 11;`
         * @return Whether the helloAck field is set.
         */
        public final boolean hasHelloAck() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.System.HelloAckMessage getHelloAckOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.SystemMessageKt.Dsl $this$helloAckOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getError")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.ErrorMessage getError() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setError")
        public final void setError(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.ErrorMessage value) {
        }
        
        /**
         * ```
         * For ERROR
         * ```
         *
         * `.droidlink.protocol.ErrorMessage error = 12;`
         */
        public final void clearError() {
        }
        
        /**
         * ```
         * For ERROR
         * ```
         *
         * `.droidlink.protocol.ErrorMessage error = 12;`
         * @return Whether the error field is set.
         */
        public final boolean hasError() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.System.ErrorMessage getErrorOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.SystemMessageKt.Dsl $this$errorOrNull) {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/SystemMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/SystemMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/SystemMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}