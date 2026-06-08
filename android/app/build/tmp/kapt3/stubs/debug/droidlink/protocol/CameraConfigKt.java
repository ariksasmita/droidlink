package droidlink.protocol;

/**
 * ```
 * Camera configuration
 * ```
 *
 * Protobuf type `droidlink.protocol.CameraConfig`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/CameraConfigKt;", "", "()V", "Dsl", "app_debug"})
public final class CameraConfigKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.CameraConfigKt INSTANCE = null;
    
    private CameraConfigKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010 \u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020\"R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0004R$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010\u00a8\u0006("}, d2 = {"Ldroidlink/protocol/CameraConfigKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "codec", "getCodec", "()Lerror/NonExistentClass;", "setCodec", "", "codecValue", "getCodecValue", "()I", "setCodecValue", "(I)V", "facing", "getFacing", "setFacing", "facingValue", "getFacingValue", "setFacingValue", "fps", "getFps", "setFps", "height", "getHeight", "setHeight", "width", "getWidth", "setWidth", "_build", "clearCodec", "", "clearFacing", "clearFps", "clearHeight", "clearWidth", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Media.CameraConfig.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.CameraConfigKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Media.CameraConfig.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getWidth")
        public final int getWidth() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setWidth")
        public final void setWidth(int value) {
        }
        
        /**
         * `int32 width = 1;`
         */
        public final void clearWidth() {
        }
        
        @kotlin.jvm.JvmName(name = "getHeight")
        public final int getHeight() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setHeight")
        public final void setHeight(int value) {
        }
        
        /**
         * `int32 height = 2;`
         */
        public final void clearHeight() {
        }
        
        @kotlin.jvm.JvmName(name = "getFps")
        public final int getFps() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setFps")
        public final void setFps(int value) {
        }
        
        /**
         * `int32 fps = 3;`
         */
        public final void clearFps() {
        }
        
        @kotlin.jvm.JvmName(name = "getFacing")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.CameraFacing getFacing() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFacing")
        public final void setFacing(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.CameraFacing value) {
        }
        
        @kotlin.jvm.JvmName(name = "getFacingValue")
        public final int getFacingValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setFacingValue")
        public final void setFacingValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.CameraFacing facing = 4;`
         */
        public final void clearFacing() {
        }
        
        @kotlin.jvm.JvmName(name = "getCodec")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Screen.VideoCodec getCodec() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCodec")
        public final void setCodec(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Screen.VideoCodec value) {
        }
        
        @kotlin.jvm.JvmName(name = "getCodecValue")
        public final int getCodecValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setCodecValue")
        public final void setCodecValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.VideoCodec codec = 5;`
         */
        public final void clearCodec() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/CameraConfigKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/CameraConfigKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/CameraConfigKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}