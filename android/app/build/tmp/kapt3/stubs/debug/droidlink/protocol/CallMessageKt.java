package droidlink.protocol;

/**
 * ```
 * Call handling messages
 * ```
 *
 * Protobuf type `droidlink.protocol.CallMessage`
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Ldroidlink/protocol/CallMessageKt;", "", "()V", "Dsl", "app_debug"})
public final class CallMessageKt {
    @org.jetbrains.annotations.NotNull()
    public static final droidlink.protocol.CallMessageKt INSTANCE = null;
    
    private CallMessageKt() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010)\u001a\u00020\u0003H\u0001\u00a2\u0006\u0002\u0010\u0018J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00108G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u0004R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001a8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR$\u0010$\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020#8G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u00062"}, d2 = {"Ldroidlink/protocol/CallMessageKt$Dsl;", "", "_builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)V", "Lerror/NonExistentClass;", "value", "", "callId", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "contactName", "getContactName", "setContactName", "Lcom/google/protobuf/ByteString;", "contactPhoto", "getContactPhoto", "()Lcom/google/protobuf/ByteString;", "setContactPhoto", "(Lcom/google/protobuf/ByteString;)V", "event", "getEvent", "()Lerror/NonExistentClass;", "setEvent", "", "eventValue", "getEventValue", "()I", "setEventValue", "(I)V", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "_build", "clearCallId", "", "clearContactName", "clearContactPhoto", "clearEvent", "clearPhoneNumber", "clearTimestamp", "Companion", "app_debug"})
    @kotlin.OptIn(markerClass = {com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode.class})
    @com.google.protobuf.kotlin.ProtoDslMarker()
    public static final class Dsl {
        @org.jetbrains.annotations.NotNull()
        private final droidlink.protocol.Call.CallMessage.Builder _builder = null;
        @org.jetbrains.annotations.NotNull()
        public static final droidlink.protocol.CallMessageKt.Dsl.Companion Companion = null;
        
        private Dsl(droidlink.protocol.Call.CallMessage.Builder _builder) {
            super();
        }
        
        @kotlin.jvm.JvmName(name = "getEvent")
        @org.jetbrains.annotations.NotNull()
        public final droidlink.protocol.Call.CallMessage.CallEventType getEvent() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setEvent")
        public final void setEvent(@org.jetbrains.annotations.NotNull()
        droidlink.protocol.Call.CallMessage.CallEventType value) {
        }
        
        @kotlin.jvm.JvmName(name = "getEventValue")
        public final int getEventValue() {
            return 0;
        }
        
        @kotlin.jvm.JvmName(name = "setEventValue")
        public final void setEventValue(int value) {
        }
        
        /**
         * `.droidlink.protocol.CallMessage.CallEventType event = 1;`
         */
        public final void clearEvent() {
        }
        
        @kotlin.jvm.JvmName(name = "getPhoneNumber")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhoneNumber() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setPhoneNumber")
        public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * For RINGING, ANSWERED, MISSED
         * ```
         *
         * `string phone_number = 2;`
         */
        public final void clearPhoneNumber() {
        }
        
        @kotlin.jvm.JvmName(name = "getContactName")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContactName() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setContactName")
        public final void setContactName(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * `string contact_name = 3;`
         */
        public final void clearContactName() {
        }
        
        @kotlin.jvm.JvmName(name = "getContactPhoto")
        @org.jetbrains.annotations.NotNull()
        public final com.google.protobuf.ByteString getContactPhoto() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setContactPhoto")
        public final void setContactPhoto(@org.jetbrains.annotations.NotNull()
        com.google.protobuf.ByteString value) {
        }
        
        /**
         * ```
         * Contact photo (PNG)
         * ```
         *
         * `bytes contact_photo = 4;`
         */
        public final void clearContactPhoto() {
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
        
        @kotlin.jvm.JvmName(name = "getCallId")
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCallId() {
            return null;
        }
        
        @kotlin.jvm.JvmName(name = "setCallId")
        public final void setCallId(@org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        /**
         * ```
         * Unique call ID
         * ```
         *
         * `string call_id = 6;`
         */
        public final void clearCallId() {
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Ldroidlink/protocol/CallMessageKt$Dsl$Companion;", "", "()V", "_create", "Ldroidlink/protocol/CallMessageKt$Dsl;", "builder", "error/NonExistentClass", "(Lerror/NonExistentClass;)Ldroidlink/protocol/CallMessageKt$Dsl;", "app_debug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
}