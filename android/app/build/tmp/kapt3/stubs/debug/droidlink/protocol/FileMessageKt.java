package droidlink.protocol;

/**
 * ```
 * File transfer messages
 * ```
 *
 * Protobuf type `droidlink.protocol.FileMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/FileMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class FileMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.FileMessageKt INSTANCE = null;
    
    private FileMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u001c\n\u0002\b\r\b\u0007\u0018\u0000 R2\u00020\u0001:\u0002RSB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u00107\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010/J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000209J\u0006\u0010>\u001a\u000209J\u0006\u0010?\u001a\u000209J\u0006\u0010@\u001a\u000209J\u0006\u0010A\u001a\u000209J\'\u0010B\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&2\u0006\u0010\u0006\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\bC\u0010DJ+\u0010E\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030GH\u0007\u00a2\u0006\u0002\bHJ\u001d\u0010I\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&H\u0007\u00a2\u0006\u0002\bJJ(\u0010K\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&2\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\n\u00a2\u0006\u0004\bL\u0010DJ,\u0010K\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030GH\u0087\n\u00a2\u0006\u0002\bMJ0\u0010N\u001a\u000209*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0087\u0002\u00a2\u0006\u0004\bP\u0010QR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00138G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u001f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\'0&8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010*\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R$\u0010-\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0004R$\u00101\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR$\u00104\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\f\u00a8\u0006T"}, d2 = {"Ldroidlink/protocol/FileMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "chunkIndex", "getChunkIndex", "()I", "setChunkIndex", "(I)V", "", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "Lcom/google/protobuf/ByteString;", "fileData", "getFileData", "()Lcom/google/protobuf/ByteString;", "setFileData", "(Lcom/google/protobuf/ByteString;)V", "fileId", "getFileId", "setFileId", "filePath", "getFilePath", "setFilePath", "", "fileSize", "getFileSize", "()J", "setFileSize", "(J)V", "files", "Lcom/google/protobuf/kotlin/DslList;", "Ldroidlink/protocol/FileMessageKt$Dsl$FilesProxy;", "getFiles", "()Lcom/google/protobuf/kotlin/DslList;", "mimeType", "getMimeType", "setMimeType", "operation", "getOperation", "()Lerror/NonExistentClass;", "setOperation", "operationValue", "getOperationValue", "setOperationValue", "totalChunks", "getTotalChunks", "setTotalChunks", "_build", "clearChunkIndex", "", "clearErrorMessage", "clearFileData", "clearFileId", "clearFilePath", "clearFileSize", "clearMimeType", "clearOperation", "clearTotalChunks", "add", "addFiles", "(Lcom/google/protobuf/kotlin/DslList;Lerror/NonExistentClass;)V", "addAll", "values", "", "addAllFiles", "clear", "clearFiles", "plusAssign", "plusAssignFiles", "plusAssignAllFiles", "set", "index", "setFiles", "(Lcom/google/protobuf/kotlin/DslList;ILerror/NonExistentClass;)V", "Companion", "FilesProxy", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.File.FileMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.FileMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.File.FileMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getOperation")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.File.FileMessage.FileOperation getOperation() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setOperation")
        public final void setOperation(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.File.FileMessage.FileOperation value) {
        }
        
        @kotlin.jvm.JvmName(name = "getOperationValue")
        public final int getOperationValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setOperationValue")
        public final void setOperationValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.FileMessage.FileOperation operation = 1;`
         */
        public final void clearOperation() {
        }
        
        @kotlin.jvm.JvmName(name = "getFilePath")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFilePath() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFilePath")
        public final void setFilePath(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For LIST_REQUEST, DOWNLOAD_REQUEST
         * ```
         *
         * `string file_path = 2;`
         */
        public final void clearFilePath() {
        }
        
        @kotlin.jvm.JvmName(name = "getFileSize")
        public final long getFileSize() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setFileSize")
        public final void setFileSize(long value) {
        }
        
        /**
         * ```
         * For DOWNLOAD_REQUEST, DOWNLOAD_RESPONSE
         * ```
         *
         * `int64 file_size = 4;`
         */
        public final void clearFileSize() {
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
         * `string mime_type = 5;`
         */
        public final void clearMimeType() {
        }
        
        @kotlin.jvm.JvmName(name = "getFileData")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getFileData() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFileData")
        public final void setFileData(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * Chunked data
         * ```
         *
         * `bytes file_data = 6;`
         */
        public final void clearFileData() {
        }
        
        @kotlin.jvm.JvmName(name = "getChunkIndex")
        public final int getChunkIndex() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setChunkIndex")
        public final void setChunkIndex(int value) {
        }
        
        /**
         * ```
         * Chunk number (0-based)
         * ```
         *
         * `int32 chunk_index = 7;`
         */
        public final void clearChunkIndex() {
        }
        
        @kotlin.jvm.JvmName(name = "getTotalChunks")
        public final int getTotalChunks() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setTotalChunks")
        public final void setTotalChunks(int value) {
        }
        
        /**
         * ```
         * Total chunks
         * ```
         *
         * `int32 total_chunks = 8;`
         */
        public final void clearTotalChunks() {
        }
        
        @kotlin.jvm.JvmName(name = "getFileId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFileId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setFileId")
        public final void setFileId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * Unique transfer ID
         * ```
         *
         * `string file_id = 9;`
         */
        public final void clearFileId() {
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
         * `string error_message = 10;`
         */
        public final void clearErrorMessage() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/FileMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/FileMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/FileMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
        
        /**
         * An uninstantiable, behaviorless type to represent the field in
         * generics.
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Ldroidlink/protocol/FileMessageKt$Dsl$FilesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "app_debug"})
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        public static final class FilesProxy extends com.google.protobuf.kotlin.DslProxy {
            
            private FilesProxy() {
                super();
            }
        }
    }
}