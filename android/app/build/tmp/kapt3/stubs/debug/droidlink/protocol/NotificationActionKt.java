package droidlink.protocol;

/**
 * ```
 * Notification action button
 * ```
 *
 * Protobuf type `droidlink.protocol.NotificationAction`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/NotificationActionKt;", "", "()V", "Dsl", "app_debug"})
public final class NotificationActionKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.NotificationActionKt INSTANCE = null;
    
    private NotificationActionKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Ldroidlink/protocol/NotificationActionKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "label", "getLabel", "setLabel", "type", "getType", "()Lerror/NonExistentClass;", "setType", "", "typeValue", "getTypeValue", "()I", "setTypeValue", "(I)V", "_build", "clearId", "", "clearLabel", "clearType", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Notification.NotificationAction.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.NotificationActionKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Notification.NotificationAction.Builder _builder) {
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
         * `string id = 1;`
         */
        public final void clearId() {
        }
        
        @kotlin.jvm.JvmName(name = "getLabel")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setLabel")
        public final void setLabel(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * e.g., "Reply", "Dismiss"
         * ```
         *
         * `string label = 2;`
         */
        public final void clearLabel() {
        }
        
        @kotlin.jvm.JvmName(name = "getType")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Notification.ActionType getType() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setType")
        public final void setType(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Notification.ActionType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getTypeValue")
        public final int getTypeValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setTypeValue")
        public final void setTypeValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.ActionType type = 3;`
         */
        public final void clearType() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/NotificationActionKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/NotificationActionKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/NotificationActionKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}