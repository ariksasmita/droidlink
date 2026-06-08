package droidlink.protocol;

/**
 * ```
 * Notification mirroring messages
 * ```
 *
 * Protobuf type `droidlink.protocol.NotificationMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/NotificationMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class NotificationMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.NotificationMessageKt INSTANCE = null;
    
    private NotificationMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010#\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010\'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020+R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0004R$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u0015\u0010 \u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006-"}, d2 = {"Ldroidlink/protocol/NotificationMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "actionId", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "actionReplyText", "getActionReplyText", "setActionReplyText", "event", "getEvent", "()Lerror/NonExistentClass;", "setEvent", "", "eventValue", "getEventValue", "()I", "setEventValue", "(I)V", "notification", "getNotification", "setNotification", "notificationId", "getNotificationId", "setNotificationId", "notificationOrNull", "getNotificationOrNull", "(Ldroidlink/protocol/NotificationMessageKt$Dsl;)Lerror/NonExistentClass;", "_build", "clearActionId", "", "clearActionReplyText", "clearEvent", "clearNotification", "clearNotificationId", "hasNotification", "", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Notification.NotificationMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.NotificationMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Notification.NotificationMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getEvent")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Notification.NotificationMessage.NotificationEventType getEvent() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setEvent")
        public final void setEvent(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Notification.NotificationMessage.NotificationEventType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getEventValue")
        public final int getEventValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setEventValue")
        public final void setEventValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.NotificationMessage.NotificationEventType event = 1;`
         */
        public final void clearEvent() {
        }
        
        @kotlin.jvm.JvmName(name = "getNotification")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Notification.NotificationData getNotification() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setNotification")
        public final void setNotification(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Notification.NotificationData value) {
        }
        
        /**
         * ```
         * For POSTED, UPDATED
         * ```
         *
         * `.droidlink.protocol.NotificationData notification = 2;`
         */
        public final void clearNotification() {
        }
        
        /**
         * ```
         * For POSTED, UPDATED
         * ```
         *
         * `.droidlink.protocol.NotificationData notification = 2;`
         * @return Whether the notification field is set.
         */
        public final boolean hasNotification() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final droidlink.protocol.Notification.NotificationData getNotificationOrNull(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.NotificationMessageKt.Dsl $this$notificationOrNull) {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "getNotificationId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNotificationId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setNotificationId")
        public final void setNotificationId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For REMOVED
         * ```
         *
         * `string notification_id = 3;`
         */
        public final void clearNotificationId() {
        }
        
        @kotlin.jvm.JvmName(name = "getActionId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getActionId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setActionId")
        public final void setActionId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For ACTION_CLICKED
         * ```
         *
         * `string action_id = 4;`
         */
        public final void clearActionId() {
        }
        
        @kotlin.jvm.JvmName(name = "getActionReplyText")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getActionReplyText() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setActionReplyText")
        public final void setActionReplyText(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For reply actions
         * ```
         *
         * `string action_reply_text = 5;`
         */
        public final void clearActionReplyText() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/NotificationMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/NotificationMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/NotificationMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}