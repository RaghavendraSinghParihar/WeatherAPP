# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:


-dontpreverify
-repackageclasses ''
-allowaccessmodification
-optimizations !code/simplification/arithmetic
-keepattributes *Annotation*
-dontwarn javax.annotation.**



#-keepattributes ​*Annotation*​
-keepattributes JavascriptInterface
-keepattributes EnclosingMethod
##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature



-keep class com.squareup.** {*;}
-keep interface com.squareup.** {*;}
-dontwarn com.squareup.**
-ignorewarnings

-keep class * {
    public private *;
}
-ignorewarnings
## rules for retrofit
-dontwarn com.squareup.okhttp.**
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *;}
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn okio.**
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

#add these to remove warning
-dontwarn org.apache.**
-dontwarn org.junit.**
-dontwarn com.opencsv.**
-dontwarn com.squareup.**
-dontwarn okhttp3.**
-dontwarn retrofit2.**

-dontwarn java.nio.file.Files
-dontwarn java.nio.file.Path
-dontwarn java.nio.file.OpenOption
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
#end of retrofit rules

-dontwarn org.**
-dontwarn com.**
-dontwarn java.**
-dontwarn javax.**
-dontwarn sun.**
-keep class android.** { *; }
-keep class org.** { *; }
-keep class java.** { *; }
-keep class javax.** { *; }
-keep class sun.** { *; }
-keep class de.mindpipe.** { *; }
-keep class com.j256.** { *; }
-keep class android.** { *; }
-dontwarn com.viewpagerindicator.**
-dontwarn net.simonvt.numberpicker.Scroller

-keep class * {
    public private *;
}
# Prevent obfuscation of types
# is used to reflectively look up the generated ViewBinding.
-keep class butterknife.*

