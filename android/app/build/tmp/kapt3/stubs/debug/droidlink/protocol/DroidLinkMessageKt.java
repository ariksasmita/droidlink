package droidlink.protocol;

/**
 * ```
 * Root message type for all DroidLink communication
 * ```
 *
 * Protobuf type `droidlink.protocol.DroidLinkMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/DroidLinkMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class DroidLinkMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.DroidLinkMessageKt INSTANCE = null;
    
    private DroidLinkMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001FB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u00101\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\tJ\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\u0006\u00107\u001a\u000203J\u0006\u00108\u001a\u000203J\u0006\u00109\u001a\u000203J\u0006\u0010:\u001a\u000203J\u0006\u0010;\u001a\u000203J\u0006\u0010<\u001a\u000203J\u0006\u0010=\u001a\u000203J\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\u0006\u0010D\u001a\u00020?J\u0006\u0010E\u001a\u00020?R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u0004R$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u0004R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u0004R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u0004R\u0011\u0010\u001d\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\tR$\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u0004R$\u0010\"\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u0004R$\u0010%\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00118G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u0014\"\u0004\b\'\u0010\u0016R$\u0010(\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u0004R$\u0010,\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020+8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u0006G"}, d2 = {"Ldroidlink/protocol/DroidLinkMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "call", "getCall", "()Lerror/NonExistentClass;", "setCall", "clipboard", "getClipboard", "setClipboard", "file", "getFile", "setFile", "", "id", "getId", "()J", "setId", "(J)V", "media", "getMedia", "setMedia", "notification", "getNotification", "setNotification", "payloadCase", "getPayloadCase", "screen", "getScreen", "setScreen", "system", "getSystem", "setSystem", "timestamp", "getTimestamp", "setTimestamp", "type", "getType", "setType", "", "typeValue", "getTypeValue", "()I", "setTypeValue", "(I)V", "_build", "clearCall", "", "clearClipboard", "clearFile", "clearId", "clearMedia", "clearNotification", "clearPayload", "clearScreen", "clearSystem", "clearTimestamp", "clearType", "hasCall", "", "hasClipboard", "hasFile", "hasMedia", "hasNotification", "hasScreen", "hasSystem", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Droidlink.DroidLinkMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.DroidLinkMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Droidlink.DroidLinkMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getId")
        public final long getId() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setId")
        public final void setId(long value) {
        }
        
        /**
         * ```
         * Unique message ID (timestamp-based)
         * ```
         *
         * `uint64 id = 1;`
         */
        public final void clearId() {
        }
        
        @kotlin.jvm.JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setTimestamp")
        public final void setTimestamp(long value) {
        }
        
        /**
         * ```
         * Unix timestamp (milliseconds)
         * ```
         *
         * `uint64 timestamp = 2;`
         */
        public final void clearTimestamp() {
        }
        
        @kotlin.jvm.JvmName(name = "getType")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Droidlink.MessageType getType() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setType")
        public final void setType(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Droidlink.MessageType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getTypeValue")
        public final int getTypeValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setTypeValue")
        public final void setTypeValue(int value) {
        }
        
        /**
         * ```
         * Message type
         * ```
         *
         * `.droidlink.protocol.MessageType type = 3;`
         */
        public final void clearType() {
        }
        
        @kotlin.jvm.JvmName(name = "getClipboard")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Clipboard.ClipboardMessage getClipboard() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setClipboard")
        public final void setClipboard(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Clipboard.ClipboardMessage value) {
        }
        
        /**
         * `.droidlink.protocol.ClipboardMessage clipboard = 10;`
         */
        public final void clearClipboard() {
        }
        
        /**
         * `.droidlink.protocol.ClipboardMessage clipboard = 10;`
         * @return Whether the clipboard field is set.
         */
        public final boolean hasClipboard() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getNotification")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Notification.NotificationMessage getNotification() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setNotification")
        public final void setNotification(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Notification.NotificationMessage value) {
        }
        
        /**
         * `.droidlink.protocol.NotificationMessage notification = 11;`
         */
        public final void clearNotification() {
        }
        
        /**
         * `.droidlink.protocol.NotificationMessage notification = 11;`
         * @return Whether the notification field is set.
         */
        public final boolean hasNotification() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getFile")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.File.FileMessage getFile() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFile")
        public final void setFile(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.File.FileMessage value) {
        }
        
        /**
         * `.droidlink.protocol.FileMessage file = 12;`
         */
        public final void clearFile() {
        }
        
        /**
         * `.droidlink.protocol.FileMessage file = 12;`
         * @return Whether the file field is set.
         */
        public final boolean hasFile() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getScreen")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Screen.ScreenMessage getScreen() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setScreen")
        public final void setScreen(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Screen.ScreenMessage value) {
        }
        
        /**
         * `.droidlink.protocol.ScreenMessage screen = 13;`
         */
        public final void clearScreen() {
        }
        
        /**
         * `.droidlink.protocol.ScreenMessage screen = 13;`
         * @return Whether the screen field is set.
         */
        public final boolean hasScreen() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getMedia")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Media.MediaMessage getMedia() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setMedia")
        public final void setMedia(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Media.MediaMessage value) {
        }
        
        /**
         * `.droidlink.protocol.MediaMessage media = 14;`
         */
        public final void clearMedia() {
        }
        
        /**
         * `.droidlink.protocol.MediaMessage media = 14;`
         * @return Whether the media field is set.
         */
        public final boolean hasMedia() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getCall")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Call.CallMessage getCall() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCall")
        public final void setCall(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Call.CallMessage value) {
        }
        
        /**
         * `.droidlink.protocol.CallMessage call = 15;`
         */
        public final void clearCall() {
        }
        
        /**
         * `.droidlink.protocol.CallMessage call = 15;`
         * @return Whether the call field is set.
         */
        public final boolean hasCall() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getSystem")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.System.SystemMessage getSystem() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setSystem")
        public final void setSystem(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.System.SystemMessage value) {
        }
        
        /**
         * `.droidlink.protocol.SystemMessage system = 16;`
         */
        public final void clearSystem() {
        }
        
        /**
         * `.droidlink.protocol.SystemMessage system = 16;`
         * @return Whether the system field is set.
         */
        public final boolean hasSystem() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "getPayloadCase")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Droidlink.DroidLinkMessage.PayloadCase getPayloadCase() {
            return null;
        }
        
        public final void clearPayload() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/DroidLinkMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/DroidLinkMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/DroidLinkMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}