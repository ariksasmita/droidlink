package droidlink.protocol;

/**
 * ```
 * Virtual webcam and microphone messages
 * ```
 *
 * Protobuf type `droidlink.protocol.MediaMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/MediaMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class MediaMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.MediaMessageKt INSTANCE = null;
    
    private MediaMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010:\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020<J\u0006\u0010>\u001a\u00020<J\u0006\u0010?\u001a\u00020<J\u0006\u0010@\u001a\u00020<J\u0006\u0010A\u001a\u00020<J\u0006\u0010B\u001a\u00020<J\u0006\u0010C\u001a\u00020<J\u0006\u0010D\u001a\u00020<J\u0006\u0010E\u001a\u00020<J\u0006\u0010F\u001a\u00020)J\u0006\u0010G\u001a\u00020)R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u0004R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u0004R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001d8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R$\u0010&\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001d8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R$\u0010*\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020)8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001d8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R$\u00102\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u0015\u00105\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0015\u00108\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b9\u00107\u00a8\u0006I"}, d2 = {"Ldroidlink/protocol/MediaMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "audioConfig", "getAudioConfig", "()Lerror/NonExistentClass;", "setAudioConfig", "Lcom/google/protobuf/ByteString;", "audioData", "getAudioData", "()Lcom/google/protobuf/ByteString;", "setAudioData", "(Lcom/google/protobuf/ByteString;)V", "", "audioTimestamp", "getAudioTimestamp", "()J", "setAudioTimestamp", "(J)V", "cameraConfig", "getCameraConfig", "setCameraConfig", "event", "getEvent", "setEvent", "", "eventValue", "getEventValue", "()I", "setEventValue", "(I)V", "frameData", "getFrameData", "setFrameData", "frameNumber", "getFrameNumber", "setFrameNumber", "", "isKeyframe", "getIsKeyframe", "()Z", "setIsKeyframe", "(Z)V", "sampleCount", "getSampleCount", "setSampleCount", "timestamp", "getTimestamp", "setTimestamp", "audioConfigOrNull", "getAudioConfigOrNull", "(Ldroidlink/protocol/MediaMessageKt$Dsl;)Lerror/NonExistentClass;", "cameraConfigOrNull", "getCameraConfigOrNull", "_build", "clearAudioConfig", "", "clearAudioData", "clearAudioTimestamp", "clearCameraConfig", "clearEvent", "clearFrameData", "clearFrameNumber", "clearIsKeyframe", "clearSampleCount", "clearTimestamp", "hasAudioConfig", "hasCameraConfig", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Media.MediaMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.MediaMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Media.MediaMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getEvent")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.MediaMessage.MediaEventType getEvent() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setEvent")
        public final void setEvent(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.MediaMessage.MediaEventType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getEventValue")
        public final int getEventValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setEventValue")
        public final void setEventValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.MediaMessage.MediaEventType event = 1;`
         */
        public final void clearEvent() {
        }
        
        @kotlin.jvm.JvmName(name = "getCameraConfig")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.CameraConfig getCameraConfig() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCameraConfig")
        public final void setCameraConfig(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.CameraConfig value) {
        }
        
        /**
         * ```
         * For CAMERA_START
         * ```
         *
         * `.droidlink.protocol.CameraConfig camera_config = 2;`
         */
        public final void clearCameraConfig() {
        }
        
        /**
         * ```
         * For CAMERA_START
         * ```
         *
         * `.droidlink.protocol.CameraConfig camera_config = 2;`
         * @return Whether the cameraConfig field is set.
         */
        public final boolean hasCameraConfig() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.Media.CameraConfig getCameraConfigOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.MediaMessageKt.Dsl $this$cameraConfigOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getFrameData")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getFrameData() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFrameData")
        public final void setFrameData(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * For CAMERA_FRAME
         * ```
         *
         * `bytes frame_data = 3;`
         */
        public final void clearFrameData() {
        }
        
        @kotlin.jvm.JvmName(name = "getFrameNumber")
        public final int getFrameNumber() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setFrameNumber")
        public final void setFrameNumber(int value) {
        }
        
        /**
         * `int32 frame_number = 4;`
         */
        public final void clearFrameNumber() {
        }
        
        @kotlin.jvm.JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setTimestamp")
        public final void setTimestamp(long value) {
        }
        
        /**
         * `int64 timestamp = 5;`
         */
        public final void clearTimestamp() {
        }
        
        @kotlin.jvm.JvmName(name = "getIsKeyframe")
        public final boolean getIsKeyframe() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "setIsKeyframe")
        public final void setIsKeyframe(boolean value) {
        }
        
        /**
         * `bool is_keyframe = 6;`
         */
        public final void clearIsKeyframe() {
        }
        
        @kotlin.jvm.JvmName(name = "getAudioConfig")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.AudioConfig getAudioConfig() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setAudioConfig")
        public final void setAudioConfig(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.AudioConfig value) {
        }
        
        /**
         * ```
         * For MICROPHONE_START
         * ```
         *
         * `.droidlink.protocol.AudioConfig audio_config = 7;`
         */
        public final void clearAudioConfig() {
        }
        
        /**
         * ```
         * For MICROPHONE_START
         * ```
         *
         * `.droidlink.protocol.AudioConfig audio_config = 7;`
         * @return Whether the audioConfig field is set.
         */
        public final boolean hasAudioConfig() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.Media.AudioConfig getAudioConfigOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.MediaMessageKt.Dsl $this$audioConfigOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getAudioData")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getAudioData() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setAudioData")
        public final void setAudioData(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * For MICROPHONE_DATA
         * ```
         *
         * `bytes audio_data = 8;`
         */
        public final void clearAudioData() {
        }
        
        @kotlin.jvm.JvmName(name = "getSampleCount")
        public final int getSampleCount() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setSampleCount")
        public final void setSampleCount(int value) {
        }
        
        /**
         * `int32 sample_count = 9;`
         */
        public final void clearSampleCount() {
        }
        
        @kotlin.jvm.JvmName(name = "getAudioTimestamp")
        public final long getAudioTimestamp() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setAudioTimestamp")
        public final void setAudioTimestamp(long value) {
        }
        
        /**
         * `int64 audio_timestamp = 10;`
         */
        public final void clearAudioTimestamp() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/MediaMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/MediaMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/MediaMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}