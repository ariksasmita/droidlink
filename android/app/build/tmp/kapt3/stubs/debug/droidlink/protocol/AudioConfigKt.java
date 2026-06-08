package droidlink.protocol;

/**
 * ```
 * Audio configuration
 * ```
 *
 * Protobuf type `droidlink.protocol.AudioConfig`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/AudioConfigKt;", "", "()V", "Dsl", "app_debug"})
public final class AudioConfigKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.AudioConfigKt INSTANCE = null;
    
    private AudioConfigKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f\u00a8\u0006\u001d"}, d2 = {"Ldroidlink/protocol/AudioConfigKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "channels", "getChannels", "()I", "setChannels", "(I)V", "codec", "getCodec", "()Lerror/NonExistentClass;", "setCodec", "codecValue", "getCodecValue", "setCodecValue", "sampleRate", "getSampleRate", "setSampleRate", "_build", "clearChannels", "", "clearCodec", "clearSampleRate", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Media.AudioConfig.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.AudioConfigKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Media.AudioConfig.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getSampleRate")
        public final int getSampleRate() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setSampleRate")
        public final void setSampleRate(int value) {
        }
        
        /**
         * ```
         * e.g., 44100, 48000
         * ```
         *
         * `int32 sample_rate = 1;`
         */
        public final void clearSampleRate() {
        }
        
        @kotlin.jvm.JvmName(name = "getChannels")
        public final int getChannels() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setChannels")
        public final void setChannels(int value) {
        }
        
        /**
         * ```
         * 1 = mono, 2 = stereo
         * ```
         *
         * `int32 channels = 2;`
         */
        public final void clearChannels() {
        }
        
        @kotlin.jvm.JvmName(name = "getCodec")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.AudioCodec getCodec() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCodec")
        public final void setCodec(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.AudioCodec value) {
        }
        
        @kotlin.jvm.JvmName(name = "getCodecValue")
        public final int getCodecValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setCodecValue")
        public final void setCodecValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.AudioCodec codec = 3;`
         */
        public final void clearCodec() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/AudioConfigKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/AudioConfigKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/AudioConfigKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}