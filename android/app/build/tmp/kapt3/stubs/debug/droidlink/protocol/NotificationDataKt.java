package droidlink.protocol;

/**
 * ```
 * Notification data from Android
 * ```
 *
 * Protobuf type `droidlink.protocol.NotificationData`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/NotificationDataKt;", "", "()V", "Dsl", "app_debug"})
public final class NotificationDataKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.NotificationDataKt INSTANCE = null;
    
    private NotificationDataKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u001c\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 a2\u00020\u0001:\u0003`abB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u00108\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020;J\u0006\u0010>\u001a\u00020;J\u0006\u0010?\u001a\u00020;J\u0006\u0010@\u001a\u00020;J\u0006\u0010A\u001a\u00020;J\u0006\u0010B\u001a\u00020;J\u0006\u0010C\u001a\u00020;J\'\u0010D\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\bE\u0010FJ+\u0010G\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030IH\u0007\u00a2\u0006\u0002\bJJ\u001d\u0010K\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0002\bLJ#\u0010K\u001a\u00020;*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u00a2\u0006\u0002\bMJ(\u0010N\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0087\n\u00a2\u0006\u0004\bO\u0010FJ,\u0010N\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030IH\u0087\n\u00a2\u0006\u0002\bPJ3\u0010Q\u001a\u00020;*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a2\u0006\u0002\bSJ7\u0010T\u001a\u00020;*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0VH\u0007\u00a2\u0006\u0002\bWJ+\u0010X\u001a\u00020;*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010R\u001a\u00020\fH\u0007\u00a2\u0006\u0002\bYJ0\u0010Z\u001a\u00020;*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010[\u001a\u00020\\2\u0006\u0010\u000b\u001a\u00020\u0003H\u0087\u0002\u00a2\u0006\u0004\b]\u0010^J4\u0010Z\u001a\u00020;*\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010R\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\n\u00a2\u0006\u0002\b_R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00078F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R#\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00168G\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u001a8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R$\u0010)\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R$\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R$\u00100\u001a\u00020/2\u0006\u0010\u000b\u001a\u00020/8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011\u00a8\u0006c"}, d2 = {"Ldroidlink/protocol/NotificationDataKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "actions", "Lcom/google/protobuf/kotlin/DslList;", "Ldroidlink/protocol/NotificationDataKt$Dsl$ActionsProxy;", "getActions", "()Lcom/google/protobuf/kotlin/DslList;", "value", "", "appName", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "category", "getCategory", "setCategory", "extras", "Lcom/google/protobuf/kotlin/DslMap;", "Ldroidlink/protocol/NotificationDataKt$Dsl$ExtrasProxy;", "getExtrasMap", "()Lcom/google/protobuf/kotlin/DslMap;", "Lcom/google/protobuf/ByteString;", "icon", "getIcon", "()Lcom/google/protobuf/ByteString;", "setIcon", "(Lcom/google/protobuf/ByteString;)V", "id", "getId", "setId", "", "isClearable", "getIsClearable", "()Z", "setIsClearable", "(Z)V", "packageName", "getPackageName", "setPackageName", "text", "getText", "setText", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "title", "getTitle", "setTitle", "_build", "()Lerror/NonExistentClass;", "clearAppName", "", "clearCategory", "clearIcon", "clearId", "clearIsClearable", "clearPackageName", "clearText", "clearTimestamp", "clearTitle", "add", "addActions", "(Lcom/google/protobuf/kotlin/DslList;Lerror/NonExistentClass;)V", "addAll", "values", "", "addAllActions", "clear", "clearActions", "clearExtras", "plusAssign", "plusAssignActions", "plusAssignAllActions", "put", "key", "putExtras", "putAll", "map", "", "putAllExtras", "remove", "removeExtras", "set", "index", "", "setActions", "(Lcom/google/protobuf/kotlin/DslList;ILerror/NonExistentClass;)V", "setExtras", "ActionsProxy", "Companion", "ExtrasProxy", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Notification.NotificationData.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.NotificationDataKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Notification.NotificationData.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setId")
        public final void setId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * Android notification ID
         * ```
         *
         * `string id = 1;`
         */
        public final void clearId() {
        }
        
        @kotlin.jvm.JvmName(name = "getPackageName")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPackageName() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setPackageName")
        public final void setPackageName(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * e.g., "com.whatsapp"
         * ```
         *
         * `string package_name = 2;`
         */
        public final void clearPackageName() {
        }
        
        @kotlin.jvm.JvmName(name = "getAppName")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAppName() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setAppName")
        public final void setAppName(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * e.g., "WhatsApp"
         * ```
         *
         * `string app_name = 3;`
         */
        public final void clearAppName() {
        }
        
        @kotlin.jvm.JvmName(name = "getTitle")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setTitle")
        public final void setTitle(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string title = 4;`
         */
        public final void clearTitle() {
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
         * `string text = 5;`
         */
        public final void clearText() {
        }
        
        @kotlin.jvm.JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return 0L;
        }
        
        @kotlin.jvm.JvmName(name = "setTimestamp")
        public final void setTimestamp(long value) {
        }
        
        /**
         * `int64 timestamp = 7;`
         */
        public final void clearTimestamp() {
        }
        
        @kotlin.jvm.JvmName(name = "getIcon")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getIcon() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setIcon")
        public final void setIcon(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * App icon (PNG, max 100KB)
         * ```
         *
         * `bytes icon = 8;`
         */
        public final void clearIcon() {
        }
        
        @kotlin.jvm.JvmName(name = "getIsClearable")
        public final boolean getIsClearable() {
            return false;
        }
        
        @kotlin.jvm.JvmName(name = "setIsClearable")
        public final void setIsClearable(boolean value) {
        }
        
        /**
         * ```
         * Can be dismissed
         * ```
         *
         * `bool is_clearable = 9;`
         */
        public final void clearIsClearable() {
        }
        
        @kotlin.jvm.JvmName(name = "getCategory")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCategory() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCategory")
        public final void setCategory(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * e.g., "msg", "call", "alarm"
         * ```
         *
         * `string category = 10;`
         */
        public final void clearCategory() {
        }
        
        /**
         * ```
         * Additional metadata
         * ```
         *
         * `map<string, string> extras = 11;`
         */
        @kotlin.jvm.JvmName(name = "putExtras")
        public final void putExtras(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.kotlin.DslMap<java.lang.String, java.lang.String, droidlink.protocol.NotificationDataKt.Dsl.ExtrasProxy> $this$put, @org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * An uninstantiable, behaviorless type to represent the field in
         * generics.
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Ldroidlink/protocol/NotificationDataKt$Dsl$ActionsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "app_debug"})
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        public static final class ActionsProxy extends com.google.protobuf.kotlin.DslProxy {
            
            private ActionsProxy() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/NotificationDataKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/NotificationDataKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/NotificationDataKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
        
        /**
         * An uninstantiable, behaviorless type to represent the field in
         * generics.
         */
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Ldroidlink/protocol/NotificationDataKt$Dsl$ExtrasProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "app_debug"})
        @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
        public static final class ExtrasProxy extends com.google.protobuf.kotlin.DslProxy {
            
            private ExtrasProxy() {
                super();
            }
        }
    }
}