package droidlink.protocol;

/**
 * ```
 * Clipboard data (text, image, URL)
 * ```
 *
 * Protobuf type `droidlink.protocol.ClipboardData`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/ClipboardDataKt;", "", "()V", "Dsl", "app_debug"})
public final class ClipboardDataKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.ClipboardDataKt INSTANCE = null;
    
    private ClipboardDataKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010&\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\u0006\u0010,\u001a\u00020(R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u0004R$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001d8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012\u00a8\u0006."}, d2 = {"Ldroidlink/protocol/ClipboardDataKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "Lcom/google/protobuf/ByteString;", "imageData", "getImageData", "()Lcom/google/protobuf/ByteString;", "setImageData", "(Lcom/google/protobuf/ByteString;)V", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "type", "getType", "()Lerror/NonExistentClass;", "setType", "", "typeValue", "getTypeValue", "()I", "setTypeValue", "(I)V", "url", "getUrl", "setUrl", "_build", "clearImageData", "", "clearText", "clearTimestamp", "clearType", "clearUrl", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Clipboard.ClipboardData.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.ClipboardDataKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Clipboard.ClipboardData.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getType")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Clipboard.DataType getType() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setType")
        public final void setType(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Clipboard.DataType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getTypeValue")
        public final int getTypeValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setTypeValue")
        public final void setTypeValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.DataType type = 1;`
         */
        public final void clearType() {
        }
        
        @kotlin.jvm.JvmName(name = "getText")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setText")
        public final void setText(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string text = 2;`
         */
        public final void clearText() {
        }
        
        @kotlin.jvm.JvmName(name = "getImageData")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getImageData() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setImageData")
        public final void setImageData(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * PNG or JPEG
         * ```
         *
         * `bytes image_data = 3;`
         */
        public final void clearImageData() {
        }
        
        @kotlin.jvm.JvmName(name = "getUrl")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setUrl")
        public final void setUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string url = 4;`
         */
        public final void clearUrl() {
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
         * When copied
         * ```
         *
         * `int64 timestamp = 5;`
         */
        public final void clearTimestamp() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/ClipboardDataKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/ClipboardDataKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/ClipboardDataKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}