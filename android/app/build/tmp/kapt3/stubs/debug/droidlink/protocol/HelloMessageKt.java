package droidlink.protocol;

/**
 * ```
 * Initial handshake message from client
 * ```
 *
 * Protobuf type `droidlink.protocol.HelloMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/HelloMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class HelloMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.HelloMessageKt INSTANCE = null;
    
    private HelloMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\b\u000b\b\u0007\u0018\u0000 92\u00020\u0001:\u00029:B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010%\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\'J\u0006\u0010)\u001a\u00020\'J\u0006\u0010*\u001a\u00020\'J\u0006\u0010+\u001a\u00020\'J%\u0010,\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b-J+\u0010.\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000700H\u0007\u00a2\u0006\u0002\b1J\u001d\u00102\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!H\u0007\u00a2\u0006\u0002\b3J&\u00104\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\n\u00a2\u0006\u0002\b5J,\u00104\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000700H\u0087\n\u00a2\u0006\u0002\b6J.\u00107\u001a\u00020\'*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!2\u0006\u00108\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0002\u00a2\u0006\u0002\b3R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00178G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006;"}, d2 = {"Ldroidlink/protocol/HelloMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "certificateFingerprint", "getCertificateFingerprint", "()Ljava/lang/String;", "setCertificateFingerprint", "(Ljava/lang/String;)V", "deviceId", "getDeviceId", "setDeviceId", "deviceName", "getDeviceName", "setDeviceName", "deviceType", "getDeviceType", "()Lerror/NonExistentClass;", "setDeviceType", "", "deviceTypeValue", "getDeviceTypeValue", "()I", "setDeviceTypeValue", "(I)V", "protocolVersion", "getProtocolVersion", "setProtocolVersion", "supportedFeatures", "Lcom/google/protobuf/kotlin/DslList;", "Ldroidlink/protocol/HelloMessageKt$Dsl$SupportedFeaturesProxy;", "getSupportedFeatures", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "clearCertificateFingerprint", "", "clearDeviceId", "clearDeviceName", "clearDeviceType", "clearProtocolVersion", "add", "addSupportedFeatures", "addAll", "values", "", "addAllSupportedFeatures", "clear", "setSupportedFeatures", "plusAssign", "plusAssignSupportedFeatures", "plusAssignAllSupportedFeatures", "set", "index", "Companion", "SupportedFeaturesProxy", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.System.HelloMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.HelloMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.System.HelloMessage.Builder _builder) {
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
         * ```
         * e.g., "1.0.0"
         * ```
         *
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
         * ```
         * Unique device ID
         * ```
         *
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
         * ```
         * User-friendly name
         * ```
         *
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
         * ```
         * Android or Mac/iPad
         * ```
         *
         * `.droidlink.protocol.DeviceType device_type = 4;`
         */
        public final void clearDeviceType() {
        }
        
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.kotlin.DslList<java.lang.String, droidlink.protocol.HelloMessageKt.Dsl.SupportedFeaturesProxy> getSupportedFeatures() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getCertificateFingerprint")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCertificateFingerprint() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCertificateFingerprint")
        public final void setCertificateFingerprint(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For validation
         * ```
         *
         * `string certificate_fingerprint = 6;`
         */
        public final void clearCertificateFingerprint() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/HelloMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/HelloMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/HelloMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
        
        /**
         * An uninstantiable, behaviorless type to represent the field in
         * generics.
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Ldroidlink/protocol/HelloMessageKt$Dsl$SupportedFeaturesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "app_debug"})
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        public static final class SupportedFeaturesProxy extends com.google.protobuf.kotlin.DslProxy {
            
            private SupportedFeaturesProxy() {
                super();
            }
        }
    }
}