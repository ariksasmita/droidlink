package droidlink.protocol;

/**
 * ```
 * File information
 * ```
 *
 * Protobuf type `droidlink.protocol.FileInfo`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/FileInfoKt;", "", "()V", "Dsl", "app_debug"})
public final class FileInfoKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.FileInfoKt INSTANCE = null;
    
    private FileInfoKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\"\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010\'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018\u00a8\u0006,"}, d2 = {"Ldroidlink/protocol/FileInfoKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "isDirectory", "getIsDirectory", "()Z", "setIsDirectory", "(Z)V", "", "mimeType", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "", "modifiedTime", "getModifiedTime", "()J", "setModifiedTime", "(J)V", "name", "getName", "setName", "path", "getPath", "setPath", "size", "getSize", "setSize", "_build", "()Lerror/NonExistentClass;", "clearIsDirectory", "", "clearMimeType", "clearModifiedTime", "clearName", "clearPath", "clearSize", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.File.FileInfo.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.FileInfoKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.File.FileInfo.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getName")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setName")
        public final void setName(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string name = 1;`
         */
        public final void clearName() {
        }
        
        @kotlin.jvm.JvmName(name = "getPath")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPath() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setPath")
        public final void setPath(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string path = 2;`
         */
        public final void clearPath() {
        }
        
        @kotlin.jvm.JvmName(name = "getSize")
        public final long getSize() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setSize")
        public final void setSize(long value) {
        }
        
        /**
         * `int64 size = 3;`
         */
        public final void clearSize() {
        }
        
        @kotlin.jvm.JvmName(name = "getModifiedTime")
        public final long getModifiedTime() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setModifiedTime")
        public final void setModifiedTime(long value) {
        }
        
        /**
         * `int64 modified_time = 4;`
         */
        public final void clearModifiedTime() {
        }
        
        @kotlin.jvm.JvmName(name = "getIsDirectory")
        public final boolean getIsDirectory() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "setIsDirectory")
        public final void setIsDirectory(boolean value) {
        }
        
        /**
         * `bool is_directory = 5;`
         */
        public final void clearIsDirectory() {
        }
        
        @kotlin.jvm.JvmName(name = "getMimeType")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMimeType() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setMimeType")
        public final void setMimeType(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string mime_type = 6;`
         */
        public final void clearMimeType() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/FileInfoKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/FileInfoKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/FileInfoKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}