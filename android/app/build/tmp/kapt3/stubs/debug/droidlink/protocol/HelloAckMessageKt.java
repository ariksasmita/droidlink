package droidlink.protocol;

/**
 * ```
 * Handshake acknowledgment from server
 * ```
 *
 * Protobuf type `droidlink.protocol.HelloAckMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/HelloAckMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class HelloAckMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.HelloAckMessageKt INSTANCE = null;
    
    private HelloAckMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\b\u000b\b\u0007\u0018\u0000 52\u00020\u0001:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\"\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010\'\u001a\u00020$J%\u0010(\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b)J+\u0010*\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070,H\u0007\u00a2\u0006\u0002\b-J\u001d\u0010.\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007\u00a2\u0006\u0002\b/J&\u00100\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\n\u00a2\u0006\u0002\b1J,\u00100\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070,H\u0087\n\u00a2\u0006\u0002\b2J.\u00103\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u00104\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b/R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u001e8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u00067"}, d2 = {"Ldroidlink/protocol/HelloAckMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "deviceId", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "deviceName", "getDeviceName", "setDeviceName", "deviceType", "getDeviceType", "()Lerror/NonExistentClass;", "setDeviceType", "", "deviceTypeValue", "getDeviceTypeValue", "()I", "setDeviceTypeValue", "(I)V", "protocolVersion", "getProtocolVersion", "setProtocolVersion", "supportedFeatures", "Lcom/google/protobuf/kotlin/DslList;", "Ldroidlink/protocol/HelloAckMessageKt$Dsl$SupportedFeaturesProxy;", "getSupportedFeatures", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "clearDeviceId", "", "clearDeviceName", "clearDeviceType", "clearProtocolVersion", "add", "addSupportedFeatures", "addAll", "values", "", "addAllSupportedFeatures", "clear", "setSupportedFeatures", "plusAssign", "plusAssignSupportedFeatures", "plusAssignAllSupportedFeatures", "set", "index", "Companion", "SupportedFeaturesProxy", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.System.HelloAckMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.HelloAckMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.System.HelloAckMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getProtocolVersion")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getProtocolVersion() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setProtocolVersion")
        public final void setProtocolVersion(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string protocol_version = 1;`
         */
        public final void clearProtocolVersion() {
        }
        
        @kotlin.jvm.JvmName(name = "getDeviceId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeviceId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setDeviceId")
        public final void setDeviceId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string device_id = 2;`
         */
        public final void clearDeviceId() {
        }
        
        @kotlin.jvm.JvmName(name = "getDeviceName")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeviceName() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setDeviceName")
        public final void setDeviceName(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string device_name = 3;`
         */
        public final void clearDeviceName() {
        }
        
        @kotlin.jvm.JvmName(name = "getDeviceType")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.DeviceType getDeviceType() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setDeviceType")
        public final void setDeviceType(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.DeviceType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getDeviceTypeValue")
        public final int getDeviceTypeValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setDeviceTypeValue")
        public final void setDeviceTypeValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.DeviceType device_type = 4;`
         */
        public final void clearDeviceType() {
        }
        
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.kotlin.DslList<java.lang.String, droidlink.protocol.HelloAckMessageKt.Dsl.SupportedFeaturesProxy> getSupportedFeatures() {
            return null;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/HelloAckMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/HelloAckMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/HelloAckMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
        
        /**
         * An uninstantiable, behaviorless type to represent the field in
         * generics.
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Ldroidlink/protocol/HelloAckMessageKt$Dsl$SupportedFeaturesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "app_debug"})
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        public static final class SupportedFeaturesProxy extends com.google.protobuf.kotlin.DslProxy {
            
            private SupportedFeaturesProxy() {
                super();
            }
        }
    }
}