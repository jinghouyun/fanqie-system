.class public final synthetic Lcom/taobao/weex/WXSDKInstance$$ExternalSyntheticApiModelOutline0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"


# direct methods
.method public static bridge synthetic m(Ljava/util/concurrent/atomic/DoubleAdder;)D
    .locals 2

    .line 0
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/DoubleAdder;->doubleValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public static bridge synthetic m(Landroid/app/AppOpsManager;Ljava/lang/String;ILjava/lang/String;)I
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2, p3}, Landroid/app/AppOpsManager;->unsafeCheckOpNoThrow(Ljava/lang/String;ILjava/lang/String;)I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/content/pm/ApplicationInfo;)I
    .locals 0

    .line 0
    iget p0, p0, Landroid/content/pm/ApplicationInfo;->minSdkVersion:I

    return p0
.end method

.method public static bridge synthetic m(Landroid/content/pm/PermissionInfo;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/content/pm/PermissionInfo;->getProtection()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/graphics/ColorSpace;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/ColorSpace;->hashCode()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/graphics/drawable/AnimatedImageDrawable;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/drawable/AnimatedImageDrawable;->getIntrinsicWidth()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/os/SharedMemory;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/os/SharedMemory;->getSize()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Ljava/util/OptionalInt;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Ljava/util/OptionalInt;->getAsInt()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Ljava/time/Duration;)J
    .locals 2

    .line 0
    invoke-virtual {p0}, Ljava/time/Duration;->toMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public static bridge synthetic m(Ljava/util/OptionalLong;)J
    .locals 2

    .line 0
    invoke-virtual {p0}, Ljava/util/OptionalLong;->getAsLong()J

    move-result-wide v0

    return-wide v0
.end method

.method public static bridge synthetic m(Ljava/util/concurrent/atomic/LongAdder;)J
    .locals 2

    .line 0
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/LongAdder;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public static bridge synthetic m(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;I)Landroid/content/Intent;
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2, p3}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;I)Landroid/content/Intent;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(J)Landroid/content/pm/PackageManager$ResolveInfoFlags;
    .locals 0

    .line 0
    invoke-static {p0, p1}, Landroid/content/pm/PackageManager$ResolveInfoFlags;->of(J)Landroid/content/pm/PackageManager$ResolveInfoFlags;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Landroid/graphics/Bitmap$Config;
    .locals 1

    .line 0
    sget-object v0, Landroid/graphics/Bitmap$Config;->HARDWARE:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method

.method public static bridge synthetic m(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap$Config;
    .locals 0

    .line 0
    iget-object p0, p0, Landroid/graphics/BitmapFactory$Options;->outConfig:Landroid/graphics/Bitmap$Config;

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/content/ContentResolver;Landroid/net/Uri;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2, p3}, Landroid/content/ContentResolver;->loadThumbnail(Landroid/net/Uri;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/media/MediaMetadataRetriever;JIII)Landroid/graphics/Bitmap;
    .locals 0

    .line 0
    invoke-virtual/range {p0 .. p5}, Landroid/media/MediaMetadataRetriever;->getScaledFrameAtTime(JIII)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/io/File;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;
    .locals 0

    .line 0
    invoke-static {p0, p1, p2}, Landroid/media/ThumbnailUtils;->createVideoThumbnail(Ljava/io/File;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Landroid/graphics/ColorSpace$Named;
    .locals 1

    .line 0
    sget-object v0, Landroid/graphics/ColorSpace$Named;->DISPLAY_P3:Landroid/graphics/ColorSpace$Named;

    return-object v0
.end method

.method public static bridge synthetic m(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/ColorSpace;
    .locals 0

    .line 0
    iget-object p0, p0, Landroid/graphics/BitmapFactory$Options;->outColorSpace:Landroid/graphics/ColorSpace;

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder$ImageInfo;)Landroid/graphics/ColorSpace;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/ImageDecoder$ImageInfo;->getColorSpace()Landroid/graphics/ColorSpace;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Landroid/graphics/ImageDecoder$Source;
    .locals 0

    .line 0
    check-cast p0, Landroid/graphics/ImageDecoder$Source;

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/nio/ByteBuffer;)Landroid/graphics/ImageDecoder$Source;
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/graphics/ImageDecoder;->createSource(Ljava/nio/ByteBuffer;)Landroid/graphics/ImageDecoder$Source;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Landroid/graphics/drawable/AnimatedImageDrawable;
    .locals 0

    .line 0
    check-cast p0, Landroid/graphics/drawable/AnimatedImageDrawable;

    return-object p0
.end method

.method public static synthetic m(Ljava/io/FileDescriptor;)Landroid/media/ExifInterface;
    .locals 1

    .line 0
    new-instance v0, Landroid/media/ExifInterface;

    invoke-direct {v0, p0}, Landroid/media/ExifInterface;-><init>(Ljava/io/FileDescriptor;)V

    return-object v0
.end method

.method public static bridge synthetic m(Landroid/net/ConnectivityManager;)Landroid/net/Network;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/net/Uri;)Landroid/net/Uri;
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/provider/MediaStore;->setRequireOriginal(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Landroid/os/LocaleList;
    .locals 1

    .line 0
    invoke-static {}, Landroid/os/LocaleList;->getDefault()Landroid/os/LocaleList;

    move-result-object v0

    return-object v0
.end method

.method public static bridge synthetic m(Landroid/content/res/Configuration;)Landroid/os/LocaleList;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/content/res/Configuration;->getLocales()Landroid/os/LocaleList;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/String;I)Landroid/os/SharedMemory;
    .locals 0

    .line 0
    invoke-static {p0, p1}, Landroid/os/SharedMemory;->create(Ljava/lang/String;I)Landroid/os/SharedMemory;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/os/StrictMode$ThreadPolicy$Builder;)Landroid/os/StrictMode$ThreadPolicy$Builder;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/os/StrictMode$ThreadPolicy$Builder;->permitUnbufferedIo()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/text/StaticLayout$Builder;I)Landroid/text/StaticLayout$Builder;
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/text/StaticLayout$Builder;->setEllipsizedWidth(I)Landroid/text/StaticLayout$Builder;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/text/StaticLayout$Builder;Landroid/text/TextUtils$TruncateAt;)Landroid/text/StaticLayout$Builder;
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/text/StaticLayout$Builder;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)Landroid/text/StaticLayout$Builder;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder$ImageInfo;)Landroid/util/Size;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/ImageDecoder$ImageInfo;->getSize()Landroid/util/Size;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/app/Activity;)Landroid/view/Display;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/app/Activity;->getDisplay()Landroid/view/Display;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Ljava/lang/Class;
    .locals 1

    .line 0
    const-class v0, Ljava/util/OptionalLong;

    return-object v0
.end method

.method public static bridge synthetic m(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    .locals 0

    .line 0
    invoke-virtual {p0}, Ljavax/net/ssl/SSLSocket;->getApplicationProtocol()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/os/SharedMemory;)Ljava/nio/ByteBuffer;
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/os/SharedMemory;->mapReadWrite()Ljava/nio/ByteBuffer;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/content/pm/PackageManager;Landroid/content/Intent;Landroid/content/pm/PackageManager$ResolveInfoFlags;)Ljava/util/List;
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;Landroid/content/pm/PackageManager$ResolveInfoFlags;)Ljava/util/List;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Ljava/util/Optional;
    .locals 1

    .line 0
    invoke-static {}, Ljava/util/Optional;->empty()Ljava/util/Optional;

    move-result-object v0

    return-object v0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Ljava/util/Optional;
    .locals 0

    .line 0
    check-cast p0, Ljava/util/Optional;

    return-object p0
.end method

.method public static bridge synthetic m()Ljava/util/OptionalDouble;
    .locals 1

    .line 0
    invoke-static {}, Ljava/util/OptionalDouble;->empty()Ljava/util/OptionalDouble;

    move-result-object v0

    return-object v0
.end method

.method public static bridge synthetic m(D)Ljava/util/OptionalDouble;
    .locals 0

    .line 0
    invoke-static {p0, p1}, Ljava/util/OptionalDouble;->of(D)Ljava/util/OptionalDouble;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m()Ljava/util/OptionalInt;
    .locals 1

    .line 0
    invoke-static {}, Ljava/util/OptionalInt;->empty()Ljava/util/OptionalInt;

    move-result-object v0

    return-object v0
.end method

.method public static bridge synthetic m(I)Ljava/util/OptionalInt;
    .locals 0

    .line 0
    invoke-static {p0}, Ljava/util/OptionalInt;->of(I)Ljava/util/OptionalInt;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Ljava/util/OptionalInt;
    .locals 0

    .line 0
    check-cast p0, Ljava/util/OptionalInt;

    return-object p0
.end method

.method public static bridge synthetic m()Ljava/util/OptionalLong;
    .locals 1

    .line 0
    invoke-static {}, Ljava/util/OptionalLong;->empty()Ljava/util/OptionalLong;

    move-result-object v0

    return-object v0
.end method

.method public static bridge synthetic m(J)Ljava/util/OptionalLong;
    .locals 0

    .line 0
    invoke-static {p0, p1}, Ljava/util/OptionalLong;->of(J)Ljava/util/OptionalLong;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Ljava/util/OptionalLong;
    .locals 0

    .line 0
    check-cast p0, Ljava/util/OptionalLong;

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Ljava/util/concurrent/atomic/DoubleAdder;
    .locals 0

    .line 0
    check-cast p0, Ljava/util/concurrent/atomic/DoubleAdder;

    return-object p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Ljava/util/concurrent/atomic/LongAdder;
    .locals 0

    .line 0
    check-cast p0, Ljava/util/concurrent/atomic/LongAdder;

    return-object p0
.end method

.method public static bridge synthetic m(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/content/Context;->revokeSelfPermissionOnKill(Ljava/lang/String;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/content/Context;Ljava/util/Collection;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/content/Context;->revokeSelfPermissionsOnKill(Ljava/util/Collection;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Bitmap$Config;)V
    .locals 0

    .line 0
    iput-object p1, p0, Landroid/graphics/BitmapFactory$Options;->outConfig:Landroid/graphics/Bitmap$Config;

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/ColorSpace;)V
    .locals 0

    .line 0
    iput-object p1, p0, Landroid/graphics/BitmapFactory$Options;->inPreferredColorSpace:Landroid/graphics/ColorSpace;

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder;I)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/graphics/ImageDecoder;->setAllocator(I)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder;II)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2}, Landroid/graphics/ImageDecoder;->setTargetSize(II)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder;Landroid/graphics/ColorSpace;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/graphics/ImageDecoder;->setTargetColorSpace(Landroid/graphics/ColorSpace;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/ImageDecoder;Landroid/graphics/ImageDecoder$OnPartialImageListener;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/graphics/ImageDecoder;->setOnPartialImageListener(Landroid/graphics/ImageDecoder$OnPartialImageListener;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/graphics/drawable/AnimatedImageDrawable;)V
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/drawable/AnimatedImageDrawable;->stop()V

    return-void
.end method

.method public static bridge synthetic m(Landroid/media/MediaExtractor;Landroid/media/MediaDataSource;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/media/MediaExtractor;->setDataSource(Landroid/media/MediaDataSource;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/media/MediaMetadataRetriever;Landroid/media/MediaDataSource;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/media/MediaMetadataRetriever;->setDataSource(Landroid/media/MediaDataSource;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/net/ConnectivityManager;Landroid/net/ConnectivityManager$NetworkCallback;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/net/ConnectivityManager;->registerDefaultNetworkCallback(Landroid/net/ConnectivityManager$NetworkCallback;)V

    return-void
.end method

.method public static bridge synthetic m(Landroid/os/SharedMemory;)V
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/os/SharedMemory;->close()V

    return-void
.end method

.method public static bridge synthetic m(Landroid/view/Window;Z)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/view/Window;->setNavigationBarContrastEnforced(Z)V

    return-void
.end method

.method public static bridge synthetic m(Lcom/hjq/permissions/PermissionFragment;[Ljava/lang/String;I)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1, p2}, Lcom/hjq/permissions/PermissionFragment;->requestPermissions([Ljava/lang/String;I)V

    return-void
.end method

.method public static bridge synthetic m(Lio/dcloud/common/core/ui/keyboard/DCEditText;Landroid/view/ActionMode$Callback;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Lio/dcloud/common/core/ui/keyboard/DCEditText;->setCustomInsertionActionModeCallback(Landroid/view/ActionMode$Callback;)V

    return-void
.end method

.method public static bridge synthetic m(Ljava/nio/ByteBuffer;)V
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/os/SharedMemory;->unmap(Ljava/nio/ByteBuffer;)V

    return-void
.end method

.method public static bridge synthetic m(Ljavax/net/ssl/SSLParameters;[Ljava/lang/String;)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Ljavax/net/ssl/SSLParameters;->setApplicationProtocols([Ljava/lang/String;)V

    return-void
.end method

.method public static bridge synthetic m(Ljavax/net/ssl/SSLSocket;Z)V
    .locals 0

    .line 0
    invoke-static {p0, p1}, Landroid/net/ssl/SSLSockets;->setUseSessionTickets(Ljavax/net/ssl/SSLSocket;Z)V

    return-void
.end method

.method public static bridge synthetic m()Z
    .locals 1

    .line 0
    invoke-static {}, Landroid/os/Environment;->isExternalStorageLegacy()Z

    move-result v0

    return v0
.end method

.method public static bridge synthetic m(Landroid/app/Activity;Ljava/lang/String;)Z
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/app/Activity;->shouldShowRequestPermissionRationale(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/app/AlarmManager;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/app/AlarmManager;->canScheduleExactAlarms()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/app/NotificationManager;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/app/NotificationManager;->areNotificationsEnabled()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/content/Context;)Z
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/provider/Settings$System;->canWrite(Landroid/content/Context;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/content/pm/PackageManager;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/content/pm/PackageManager;->canRequestPackageInstalls()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/graphics/ColorSpace;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/ColorSpace;->isWideGamut()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Landroid/os/PowerManager;Ljava/lang/String;)Z
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/os/PowerManager;->isIgnoringBatteryOptimizations(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Ljava/util/OptionalInt;

    return p0
.end method

.method public static bridge synthetic m(Ljava/util/OptionalInt;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Ljava/util/OptionalInt;->isPresent()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Ljava/util/OptionalLong;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Ljava/util/OptionalLong;->isPresent()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m(Ljavax/net/ssl/SSLSocket;)Z
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/net/ssl/SSLSockets;->isSupportedSocket(Ljavax/net/ssl/SSLSocket;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m$1(Landroid/graphics/drawable/AnimatedImageDrawable;)I
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/drawable/AnimatedImageDrawable;->getIntrinsicHeight()I

    move-result p0

    return p0
.end method

.method public static bridge synthetic m$1()Landroid/graphics/Bitmap$Config;
    .locals 1

    .line 0
    sget-object v0, Landroid/graphics/Bitmap$Config;->RGBA_F16:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method

.method public static bridge synthetic m$1(Ljava/io/File;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;
    .locals 0

    .line 0
    invoke-static {p0, p1, p2}, Landroid/media/ThumbnailUtils;->createImageThumbnail(Ljava/io/File;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;

    move-result-object p0

    return-object p0
.end method

.method public static bridge synthetic m$1()Ljava/lang/Class;
    .locals 1

    .line 0
    const-class v0, Ljava/util/OptionalDouble;

    return-object v0
.end method

.method public static bridge synthetic m$1(Landroid/graphics/BitmapFactory$Options;Landroid/graphics/ColorSpace;)V
    .locals 0

    .line 0
    iput-object p1, p0, Landroid/graphics/BitmapFactory$Options;->outColorSpace:Landroid/graphics/ColorSpace;

    return-void
.end method

.method public static bridge synthetic m$1(Landroid/graphics/ImageDecoder;I)V
    .locals 0

    .line 0
    invoke-virtual {p0, p1}, Landroid/graphics/ImageDecoder;->setMemorySizePolicy(I)V

    return-void
.end method

.method public static bridge synthetic m$1(Landroid/graphics/drawable/AnimatedImageDrawable;)V
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/graphics/drawable/AnimatedImageDrawable;->clearAnimationCallbacks()V

    return-void
.end method

.method public static bridge synthetic m$1()Z
    .locals 1

    .line 0
    invoke-static {}, Landroid/os/Process;->is64Bit()Z

    move-result v0

    return v0
.end method

.method public static bridge synthetic m$1(Landroid/app/NotificationManager;)Z
    .locals 0

    .line 0
    invoke-virtual {p0}, Landroid/app/NotificationManager;->isNotificationPolicyAccessGranted()Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m$1(Landroid/content/Context;)Z
    .locals 0

    .line 0
    invoke-static {p0}, Landroid/provider/Settings;->canDrawOverlays(Landroid/content/Context;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic m$1(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Ljava/util/Optional;

    return p0
.end method

.method public static bridge synthetic m$2()Landroid/graphics/Bitmap$Config;
    .locals 1

    .line 0
    sget-object v0, Landroid/graphics/Bitmap$Config;->RGBA_1010102:Landroid/graphics/Bitmap$Config;

    return-object v0
.end method

.method public static bridge synthetic m$2()Z
    .locals 1

    .line 0
    invoke-static {}, Landroid/os/Environment;->isExternalStorageManager()Z

    move-result v0

    return v0
.end method

.method public static bridge synthetic m$2(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Ljava/util/OptionalLong;

    return p0
.end method

.method public static bridge synthetic m$3(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Ljava/util/concurrent/atomic/LongAdder;

    return p0
.end method

.method public static bridge synthetic m$4(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Ljava/util/concurrent/atomic/DoubleAdder;

    return p0
.end method

.method public static bridge synthetic m$5(Ljava/lang/Object;)Z
    .locals 0

    .line 0
    instance-of p0, p0, Landroid/graphics/drawable/AnimatedImageDrawable;

    return p0
.end method
