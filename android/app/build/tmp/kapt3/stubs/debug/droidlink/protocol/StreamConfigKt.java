package droidlink.protocol;

/**
 * ```
 * Stream configuration
 * ```
 *
 * Protobuf type `droidlink.protocol.StreamConfig`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/StreamConfigKt;", "", "()V", "Dsl", "app_debug"})
public final class StreamConfigKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.StreamConfigKt INSTANCE = null;
    
    private StreamConfigKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001fR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\f\u00a8\u0006%"}, d2 = {"Ldroidlink/protocol/StreamConfigKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "bitrate", "getBitrate", "()I", "setBitrate", "(I)V", "codec", "getCodec", "()Lerror/NonExistentClass;", "setCodec", "codecValue", "getCodecValue", "setCodecValue", "fps", "getFps", "setFps", "height", "getHeight", "setHeight", "width", "getWidth", "setWidth", "_build", "clearBitrate", "", "clearCodec", "clearFps", "clearHeight", "clearWidth", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Screen.StreamConfig.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.StreamConfigKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Screen.StreamConfig.Builder _builder) {
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
         * ```
         * Video width
         * ```
         *
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
         * ```
         * Video height
         * ```
         *
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
         * ```
         * Target FPS
         * ```
         *
         * `int32 fps = 3;`
         */
        public final void clearFps() {
        }
        
        @kotlin.jvm.JvmName(name = "getBitrate")
        public final int getBitrate() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setBitrate")
        public final void setBitrate(int value) {
        }
        
        /**
         * ```
         * Bitrate (kbps)
         * ```
         *
         * `int32 bitrate = 4;`
         */
        public final void clearBitrate() {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/StreamConfigKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/StreamConfigKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/StreamConfigKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}