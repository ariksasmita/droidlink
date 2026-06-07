# Add project specific ProGuard rules here.
-keep class com.droidlink.** { *; }
-keepattributes Signature
-keepattributes *Annotation*
-keep class kotlinx.coroutines.** { *; }
-keep interface kotlinx.coroutines.** { *; }
-keep class com.google.protobuf.** { *; }
