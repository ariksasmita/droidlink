package droidlink.protocol;

/**
 * ```
 * Screen mirroring messages
 * ```
 *
 * Protobuf type `droidlink.protocol.ScreenMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/ScreenMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class ScreenMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.ScreenMessageKt INSTANCE = null;
    
    private ScreenMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u00105\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u000207J\u0006\u0010:\u001a\u000207J\u0006\u0010;\u001a\u000207J\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u000207J\u0006\u0010?\u001a\u00020#R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0004R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001a8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R$\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020#8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020)8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020)8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u0015\u00102\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006A"}, d2 = {"Ldroidlink/protocol/ScreenMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "config", "getConfig", "()Lerror/NonExistentClass;", "setConfig", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "event", "getEvent", "setEvent", "", "eventValue", "getEventValue", "()I", "setEventValue", "(I)V", "Lcom/google/protobuf/ByteString;", "frameData", "getFrameData", "()Lcom/google/protobuf/ByteString;", "setFrameData", "(Lcom/google/protobuf/ByteString;)V", "frameNumber", "getFrameNumber", "setFrameNumber", "", "isKeyframe", "getIsKeyframe", "()Z", "setIsKeyframe", "(Z)V", "", "pausedAt", "getPausedAt", "()J", "setPausedAt", "(J)V", "timestamp", "getTimestamp", "setTimestamp", "configOrNull", "getConfigOrNull", "(Ldroidlink/protocol/ScreenMessageKt$Dsl;)Lerror/NonExistentClass;", "_build", "clearConfig", "", "clearErrorMessage", "clearEvent", "clearFrameData", "clearFrameNumber", "clearIsKeyframe", "clearPausedAt", "clearTimestamp", "hasConfig", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Screen.ScreenMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.ScreenMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Screen.ScreenMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getEvent")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Screen.ScreenMessage.StreamEventType getEvent() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setEvent")
        public final void setEvent(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Screen.ScreenMessage.StreamEventType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getEventValue")
        public final int getEventValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setEventValue")
        public final void setEventValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.ScreenMessage.StreamEventType event = 1;`
         */
        public final void clearEvent() {
        }
        
        @kotlin.jvm.JvmName(name = "getConfig")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Screen.StreamConfig getConfig() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setConfig")
        public final void setConfig(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Screen.StreamConfig value) {
        }
        
        /**
         * ```
         * For START
         * ```
         *
         * `.droidlink.protocol.StreamConfig config = 2;`
         */
        public final void clearConfig() {
        }
        
        /**
         * ```
         * For START
         * ```
         *
         * `.droidlink.protocol.StreamConfig config = 2;`
         * @return Whether the config field is set.
         */
        public final boolean hasConfig() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.Screen.StreamConfig getConfigOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.ScreenMessageKt.Dsl $this$configOrNull) {
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
         * For FRAME
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
         * ```
         * Sync frame
         * ```
         *
         * `bool is_keyframe = 6;`
         */
        public final void clearIsKeyframe() {
        }
        
        @kotlin.jvm.JvmName(name = "getErrorMessage")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getErrorMessage() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setErrorMessage")
        public final void setErrorMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For ERROR
         * ```
         *
         * `string error_message = 7;`
         */
        public final void clearErrorMessage() {
        }
        
        @kotlin.jvm.JvmName(name = "getPausedAt")
        public final long getPausedAt() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setPausedAt")
        public final void setPausedAt(long value) {
        }
        
        /**
         * ```
         * For PAUSE/RESUME
         * ```
         *
         * `int64 paused_at = 8;`
         */
        public final void clearPausedAt() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/ScreenMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/ScreenMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/ScreenMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}