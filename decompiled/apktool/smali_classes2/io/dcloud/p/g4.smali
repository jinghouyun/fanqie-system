.class public abstract Lio/dcloud/p/g4;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/p/g4$o;
    }
.end annotation


# static fields
.field private static a:Ljava/lang/ref/WeakReference; = null

.field private static b:Ljava/io/File; = null

.field private static final c:Landroid/os/HandlerThread;

.field private static final d:Landroid/os/Handler;

.field private static final e:Landroid/os/Handler;

.field private static f:Z = false


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "ScreenshotWorker"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    sput-object v0, Lio/dcloud/p/g4;->c:Landroid/os/HandlerThread;

    .line 2
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 3
    new-instance v1, Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {v1, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v1, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    .line 4
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lio/dcloud/p/g4;->e:Landroid/os/Handler;

    return-void
.end method

.method private static a(Landroid/view/View;)Landroid/view/Window;
    .locals 1

    .line 168
    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p0

    .line 170
    :goto_0
    instance-of v0, p0, Landroid/content/ContextWrapper;

    if-eqz v0, :cond_1

    .line 171
    instance-of v0, p0, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 172
    check-cast p0, Landroid/app/Activity;

    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    return-object p0

    .line 174
    :cond_0
    check-cast p0, Landroid/content/ContextWrapper;

    invoke-virtual {p0}, Landroid/content/ContextWrapper;->getBaseContext()Landroid/content/Context;

    move-result-object p0

    goto :goto_0

    :cond_1
    const/4 p0, 0x0

    return-object p0
.end method

.method private static a(Landroid/graphics/Bitmap;Ljava/io/File;)Ljava/io/File;
    .locals 3

    .line 234
    :try_start_0
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, p1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 235
    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v2, 0x64

    invoke-virtual {p0, v1, v2, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 236
    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V

    .line 237
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p1

    :catch_0
    move-exception p0

    .line 240
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    const/4 p0, 0x0

    return-object p0
.end method

.method static synthetic a()Ljava/lang/ref/WeakReference;
    .locals 1

    .line 3
    sget-object v0, Lio/dcloud/p/g4;->a:Ljava/lang/ref/WeakReference;

    return-object v0
.end method

.method static synthetic a(Ljava/lang/ref/WeakReference;)Ljava/lang/ref/WeakReference;
    .locals 0

    .line 4
    sput-object p0, Lio/dcloud/p/g4;->a:Ljava/lang/ref/WeakReference;

    return-object p0
.end method

.method private static a(Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V
    .locals 5

    .line 23
    sget-object v0, Lio/dcloud/p/g4;->a:Ljava/lang/ref/WeakReference;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    if-eqz v0, :cond_1

    move-object p0, v0

    .line 26
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    if-eqz p1, :cond_2

    if-eqz p0, :cond_3

    .line 30
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 33
    :cond_2
    invoke-static {}, Lio/dcloud/p/g4;->b()Ljava/util/List;

    move-result-object p1

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 35
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result p1

    if-eqz p1, :cond_3

    if-eqz p0, :cond_3

    .line 36
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p0

    invoke-virtual {p0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object p0

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 40
    :cond_3
    :goto_1
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result p0

    if-eqz p0, :cond_4

    .line 41
    invoke-interface {p2, v1, v1}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void

    :cond_4
    const/4 p0, 0x0

    .line 46
    invoke-interface {v0, p0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroid/view/View;

    .line 47
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    .line 48
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "window"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    if-eqz v3, :cond_5

    .line 50
    invoke-interface {v3}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    goto :goto_2

    .line 52
    :cond_5
    invoke-virtual {p1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    .line 55
    :goto_2
    iget v3, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 56
    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    if-lez v3, :cond_6

    if-gtz v2, :cond_7

    .line 59
    :cond_6
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v3

    .line 60
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v2

    :cond_7
    if-lez v3, :cond_9

    if-gtz v2, :cond_8

    goto :goto_3

    .line 68
    :cond_8
    sget-object p1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v2, p1}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 70
    invoke-static {v0, p0, p1, p2}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V

    return-void

    .line 71
    :cond_9
    :goto_3
    invoke-interface {p2, v1, v1}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public static a(Landroid/app/Activity;ZLjava/lang/String;)V
    .locals 1

    .line 10
    new-instance v0, Lio/dcloud/p/g4$g;

    invoke-direct {v0, p0, p2}, Lio/dcloud/p/g4$g;-><init>(Landroid/app/Activity;Ljava/lang/String;)V

    const/4 p2, 0x0

    invoke-static {p2, p0, p1, v0}, Lio/dcloud/p/g4;->b(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    return-void
.end method

.method public static a(Landroid/app/Application;)V
    .locals 1

    .line 11
    sget-boolean v0, Lio/dcloud/p/g4;->f:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x1

    .line 13
    sput-boolean v0, Lio/dcloud/p/g4;->f:Z

    .line 16
    const-string v0, "feedback"

    invoke-virtual {p0, v0}, Landroid/app/Application;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 18
    sput-object v0, Lio/dcloud/p/g4;->b:Ljava/io/File;

    .line 19
    invoke-static {v0}, Lio/dcloud/p/g4;->b(Ljava/io/File;)V

    .line 22
    :cond_1
    new-instance v0, Lio/dcloud/p/g4$i;

    invoke-direct {v0}, Lio/dcloud/p/g4$i;-><init>()V

    invoke-virtual {p0, v0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    return-void
.end method

.method private static a(Landroid/graphics/Canvas;Landroid/view/View;Landroid/view/View;)V
    .locals 4

    .line 175
    instance-of v0, p2, Landroid/view/ViewGroup;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 176
    check-cast p2, Landroid/view/ViewGroup;

    .line 192
    invoke-virtual {p2}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    sub-int/2addr v0, v1

    :goto_0
    if-ltz v0, :cond_1

    .line 193
    invoke-virtual {p2, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-static {p0, p1, v1}, Lio/dcloud/p/g4;->a(Landroid/graphics/Canvas;Landroid/view/View;Landroid/view/View;)V

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 195
    :cond_0
    instance-of v0, p2, Landroid/view/TextureView;

    if-eqz v0, :cond_1

    .line 196
    invoke-virtual {p2}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_1

    .line 197
    move-object v0, p2

    check-cast v0, Landroid/view/TextureView;

    .line 198
    invoke-virtual {v0}, Landroid/view/TextureView;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v2, 0x2

    .line 200
    new-array v3, v2, [I

    .line 201
    invoke-virtual {p1, v3}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 202
    new-array p1, v2, [I

    .line 203
    invoke-virtual {p2, p1}, Landroid/view/View;->getLocationOnScreen([I)V

    const/4 p2, 0x0

    .line 205
    aget v2, p1, p2

    aget p2, v3, p2

    sub-int/2addr v2, p2

    int-to-float p2, v2

    .line 206
    aget p1, p1, v1

    aget v1, v3, v1

    sub-int/2addr p1, v1

    int-to-float p1, p1

    .line 210
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 211
    new-instance v2, Landroid/graphics/PorterDuffXfermode;

    sget-object v3, Landroid/graphics/PorterDuff$Mode;->DST_OVER:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v2, v3}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 212
    invoke-virtual {p0, v0, p2, p1, v1}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    :cond_1
    return-void
.end method

.method public static a(Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 1

    .line 9
    new-instance v0, Lio/dcloud/p/g4$f;

    invoke-direct {v0, p0, p1, p2}, Lio/dcloud/p/g4$f;-><init>(Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V

    const/4 p2, 0x0

    invoke-static {p0, p1, p2, v0}, Lio/dcloud/p/g4;->b(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    return-void
.end method

.method static synthetic a(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V
    .locals 0

    .line 2
    invoke-static {p0, p1, p2, p3}, Lio/dcloud/p/g4;->b(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static a(Landroid/view/View;Landroid/view/Window;Lio/dcloud/p/g4$o;)V
    .locals 7

    .line 72
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    if-lez v0, :cond_6

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v0

    if-gtz v0, :cond_0

    goto/16 :goto_1

    .line 83
    :cond_0
    instance-of v0, p0, Landroid/view/TextureView;

    if-eqz v0, :cond_1

    .line 84
    check-cast p0, Landroid/view/TextureView;

    invoke-virtual {p0}, Landroid/view/TextureView;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object p0

    .line 86
    sget-object p1, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance v0, Lio/dcloud/p/g4$l;

    invoke-direct {v0, p2, p0}, Lio/dcloud/p/g4$l;-><init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;)V

    invoke-virtual {p1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void

    .line 96
    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x18

    if-lt v0, v1, :cond_2

    instance-of v0, p0, Landroid/view/SurfaceView;

    if-eqz v0, :cond_2

    .line 97
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v1

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 99
    :try_start_0
    move-object v1, p0

    check-cast v1, Landroid/view/SurfaceView;

    new-instance v2, Lio/dcloud/p/g4$m;

    invoke-direct {v2, p2, v0, p0}, Lio/dcloud/p/g4$m;-><init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;Landroid/view/View;)V

    sget-object v3, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    invoke-static {v1, v0, v2, v3}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroid/view/PixelCopy$OnPixelCopyFinishedListener;Landroid/os/Handler;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    .line 111
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 117
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-lt v0, v1, :cond_5

    if-eqz p1, :cond_3

    goto :goto_0

    .line 118
    :cond_3
    invoke-static {p0}, Lio/dcloud/p/g4;->a(Landroid/view/View;)Landroid/view/Window;

    move-result-object p1

    :goto_0
    if-eqz p1, :cond_4

    .line 126
    invoke-virtual {p1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 127
    invoke-virtual {p0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    if-eq v1, v0, :cond_4

    const/4 p1, 0x0

    :cond_4
    if-eqz p1, :cond_5

    .line 134
    invoke-virtual {p1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 136
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v1

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    const/4 v1, 0x2

    .line 141
    new-array v1, v1, [I

    .line 142
    invoke-virtual {p0, v1}, Landroid/view/View;->getLocationInWindow([I)V

    .line 143
    new-instance v2, Landroid/graphics/Rect;

    const/4 v3, 0x0

    aget v3, v1, v3

    const/4 v4, 0x1

    aget v5, v1, v4

    .line 144
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v6

    add-int/2addr v6, v3

    aget v1, v1, v4

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v4

    add-int/2addr v1, v4

    invoke-direct {v2, v3, v5, v6, v1}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 147
    :try_start_1
    new-instance v1, Lio/dcloud/p/g4$n;

    invoke-direct {v1, p2, v0, p0}, Lio/dcloud/p/g4$n;-><init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;Landroid/view/View;)V

    sget-object v3, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    invoke-static {p1, v2, v0, v1, v3}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m(Landroid/view/Window;Landroid/graphics/Rect;Landroid/graphics/Bitmap;Landroid/view/PixelCopy$OnPixelCopyFinishedListener;Landroid/os/Handler;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    return-void

    :catch_1
    move-exception p1

    .line 159
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 166
    :cond_5
    invoke-static {p0, p2}, Lio/dcloud/p/g4;->b(Landroid/view/View;Lio/dcloud/p/g4$o;)V

    return-void

    .line 167
    :cond_6
    :goto_1
    sget-object p0, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance p1, Lio/dcloud/p/g4$k;

    invoke-direct {p1, p2}, Lio/dcloud/p/g4$k;-><init>(Lio/dcloud/p/g4$o;)V

    invoke-virtual {p0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method static synthetic a(Landroid/view/View;Lio/dcloud/p/g4$o;)V
    .locals 0

    .line 6
    invoke-static {p0, p1}, Lio/dcloud/p/g4;->b(Landroid/view/View;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static a(Landroid/view/View;Ljava/util/List;)V
    .locals 2

    .line 227
    instance-of v0, p0, Landroid/view/SurfaceView;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 228
    move-object v0, p0

    check-cast v0, Landroid/view/SurfaceView;

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 230
    :cond_0
    instance-of v0, p0, Landroid/view/ViewGroup;

    if-eqz v0, :cond_1

    .line 231
    check-cast p0, Landroid/view/ViewGroup;

    const/4 v0, 0x0

    .line 232
    :goto_0
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 233
    invoke-virtual {p0, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-static {v1, p1}, Lio/dcloud/p/g4;->a(Landroid/view/View;Ljava/util/List;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-void
.end method

.method static synthetic a(Ljava/io/File;)V
    .locals 0

    .line 8
    invoke-static {p0}, Lio/dcloud/p/g4;->c(Ljava/io/File;)V

    return-void
.end method

.method static synthetic a(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0

    .line 1
    invoke-static/range {p0 .. p5}, Lio/dcloud/p/g4;->b(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V
    .locals 0

    .line 5
    invoke-static {p0, p1, p2, p3}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method static synthetic a(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V
    .locals 0

    .line 7
    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static a(Ljava/util/List;Landroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V
    .locals 2

    .line 213
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 214
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :goto_0
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 215
    invoke-static {v1, v0}, Lio/dcloud/p/g4;->a(Landroid/view/View;Ljava/util/List;)V

    goto :goto_0

    .line 218
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result p0

    if-eqz p0, :cond_1

    const/4 p0, 0x0

    .line 219
    invoke-interface {p2, p0, p1}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void

    .line 224
    :cond_1
    new-instance p0, Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, 0x0

    .line 226
    invoke-static {v0, v1, p1, p0, p2}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static b()Ljava/util/List;
    .locals 7

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 34
    :try_start_0
    const-string v1, "android.view.WindowManagerGlobal"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 35
    const-string v2, "getInstance"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    invoke-virtual {v2, v3, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 37
    const-string v3, "mViews"

    invoke-virtual {v1, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    const/4 v4, 0x1

    .line 38
    invoke-virtual {v3, v4}, Ljava/lang/reflect/AccessibleObject;->setAccessible(Z)V

    .line 39
    invoke-virtual {v3, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    .line 41
    const-string v5, "mParams"

    invoke-virtual {v1, v5}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v1

    .line 42
    invoke-virtual {v1, v4}, Ljava/lang/reflect/AccessibleObject;->setAccessible(Z)V

    .line 44
    invoke-virtual {v1, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    if-eqz v3, :cond_3

    const/4 v2, 0x0

    .line 47
    :goto_0
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    if-ge v2, v4, :cond_3

    .line 48
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/View;

    .line 49
    invoke-virtual {v4}, Landroid/view/View;->getVisibility()I

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {v4}, Landroid/view/View;->isShown()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v5

    if-lez v5, :cond_2

    .line 50
    invoke-virtual {v4}, Landroid/view/View;->getHeight()I

    move-result v5

    if-gtz v5, :cond_0

    goto :goto_1

    :cond_0
    if-eqz v1, :cond_1

    .line 53
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v2, v5, :cond_1

    .line 54
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/WindowManager$LayoutParams;

    .line 55
    iget v5, v5, Landroid/view/WindowManager$LayoutParams;->type:I

    const/16 v6, 0x7d5

    if-ne v5, v6, :cond_1

    goto :goto_1

    .line 59
    :cond_1
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_3
    return-object v0

    :catch_0
    move-exception v1

    .line 63
    invoke-virtual {v1}, Ljava/lang/Throwable;->printStackTrace()V

    return-object v0
.end method

.method private static b(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V
    .locals 2

    .line 1
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 2
    sget-object v0, Lio/dcloud/p/g4;->e:Landroid/os/Handler;

    new-instance v1, Lio/dcloud/p/g4$h;

    invoke-direct {v1, p0, p1, p2, p3}, Lio/dcloud/p/g4$h;-><init>(Landroid/view/View;Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void

    :cond_0
    if-eqz p1, :cond_1

    if-eqz p0, :cond_1

    .line 12
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object p1

    invoke-static {p0, p1, p3}, Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/view/Window;Lio/dcloud/p/g4$o;)V

    return-void

    :cond_1
    if-eqz p0, :cond_2

    const/4 p1, 0x0

    .line 17
    invoke-static {p0, p1, p3}, Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/view/Window;Lio/dcloud/p/g4$o;)V

    return-void

    .line 21
    :cond_2
    invoke-static {p1, p2, p3}, Lio/dcloud/p/g4;->a(Landroid/app/Activity;ZLio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static b(Landroid/view/View;Lio/dcloud/p/g4$o;)V
    .locals 3

    .line 64
    :try_start_0
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    if-lez v0, :cond_2

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v0

    if-gtz v0, :cond_0

    goto :goto_0

    .line 75
    :cond_0
    invoke-virtual {p0}, Landroid/view/View;->getWidth()I

    move-result v0

    invoke-virtual {p0}, Landroid/view/View;->getHeight()I

    move-result v1

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v1, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 76
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 78
    invoke-virtual {p0}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 80
    invoke-virtual {v2, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 82
    :cond_1
    invoke-virtual {p0, v1}, Landroid/view/View;->draw(Landroid/graphics/Canvas;)V

    .line 85
    invoke-static {v1, p0, p0}, Lio/dcloud/p/g4;->a(Landroid/graphics/Canvas;Landroid/view/View;Landroid/view/View;)V

    .line 88
    sget-object p0, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance v1, Lio/dcloud/p/g4$b;

    invoke-direct {v1, p1, v0}, Lio/dcloud/p/g4$b;-><init>(Lio/dcloud/p/g4$o;Landroid/graphics/Bitmap;)V

    invoke-virtual {p0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void

    .line 89
    :cond_2
    :goto_0
    sget-object p0, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance v0, Lio/dcloud/p/g4$a;

    invoke-direct {v0, p1}, Lio/dcloud/p/g4$a;-><init>(Lio/dcloud/p/g4$o;)V

    invoke-virtual {p0, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p0

    .line 119
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 120
    sget-object p0, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance v0, Lio/dcloud/p/g4$c;

    invoke-direct {v0, p1}, Lio/dcloud/p/g4$c;-><init>(Lio/dcloud/p/g4$o;)V

    invoke-virtual {p0, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method private static b(Ljava/io/File;)V
    .locals 2

    .line 268
    sget-object v0, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    new-instance v1, Lio/dcloud/p/g4$e;

    invoke-direct {v1, p0}, Lio/dcloud/p/g4$e;-><init>(Ljava/io/File;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method private static b(Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/view/View;Landroid/app/Activity;Ljava/lang/String;)V
    .locals 3

    const-string v0, "ScreenshotHelper"

    if-nez p1, :cond_0

    if-nez p2, :cond_0

    .line 211
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, ": capture failed"

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_0
    if-nez p4, :cond_1

    .line 216
    sget-object v1, Lio/dcloud/p/g4;->a:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_1

    .line 217
    invoke-virtual {v1}, Ljava/lang/ref/Reference;->get()Ljava/lang/Object;

    move-result-object p4

    check-cast p4, Landroid/content/Context;

    :cond_1
    if-nez p4, :cond_2

    if-eqz p3, :cond_2

    .line 220
    invoke-virtual {p3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p4

    :cond_2
    if-nez p4, :cond_3

    .line 224
    sget-object p3, Lio/dcloud/p/g4;->b:Ljava/io/File;

    if-nez p3, :cond_3

    .line 225
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, ": no context available to save"

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    .line 230
    :cond_3
    :try_start_0
    sget-object p3, Lio/dcloud/p/g4;->b:Ljava/io/File;

    if-nez p3, :cond_4

    if-eqz p4, :cond_4

    .line 232
    const-string p3, "feedback"

    invoke-virtual {p4, p3}, Landroid/content/Context;->getExternalFilesDir(Ljava/lang/String;)Ljava/io/File;

    move-result-object p3

    :cond_4
    if-nez p3, :cond_5

    goto/16 :goto_1

    .line 237
    :cond_5
    invoke-virtual {p3}, Ljava/io/File;->exists()Z

    move-result p4

    if-nez p4, :cond_6

    .line 238
    invoke-virtual {p3}, Ljava/io/File;->mkdirs()Z

    .line 241
    :cond_6
    new-instance p4, Ljava/text/SimpleDateFormat;

    const-string v1, "yyyy-MM-dd_HH-mm-ss-SSS"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-direct {p4, v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 242
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {p4, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object p4

    if-eqz p5, :cond_7

    .line 243
    invoke-virtual {p5}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    goto :goto_0

    :cond_7
    const-string p5, "screenshot"

    .line 244
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p4, "_"

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p4

    .line 246
    new-instance p5, Ljava/io/File;

    invoke-direct {p5, p3, p4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 247
    invoke-virtual {p5}, Ljava/io/File;->exists()Z

    move-result p3

    if-nez p3, :cond_8

    .line 248
    invoke-virtual {p5}, Ljava/io/File;->mkdirs()Z

    :cond_8
    if-eqz p1, :cond_9

    .line 252
    new-instance p3, Ljava/io/File;

    const-string p4, "appended.png"

    invoke-direct {p3, p5, p4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {p1, p3}, Lio/dcloud/p/g4;->a(Landroid/graphics/Bitmap;Ljava/io/File;)Ljava/io/File;

    move-result-object p1

    if-eqz p1, :cond_9

    .line 254
    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p4, ": appended saved at "

    invoke-virtual {p3, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_9
    if-eqz p2, :cond_a

    .line 259
    new-instance p1, Ljava/io/File;

    const-string p3, "layered.png"

    invoke-direct {p1, p5, p3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-static {p2, p1}, Lio/dcloud/p/g4;->a(Landroid/graphics/Bitmap;Ljava/io/File;)Ljava/io/File;

    move-result-object p1

    if-eqz p1, :cond_a

    .line 261
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p3, ": layered saved at "

    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v0, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_a
    :goto_1
    return-void

    :catch_0
    move-exception p1

    .line 266
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    .line 267
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p0, ": save failed "

    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    invoke-static {v0, p0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void
.end method

.method private static b(Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V
    .locals 7

    .line 22
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    if-lt p1, v0, :cond_0

    .line 24
    invoke-static {p0, p2, p3}, Lio/dcloud/p/g4;->a(Ljava/util/List;Landroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V

    return-void

    .line 28
    :cond_0
    invoke-interface {p0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Landroid/view/View;

    .line 31
    invoke-static {v3}, Lio/dcloud/p/g4;->a(Landroid/view/View;)Landroid/view/Window;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/g4$j;

    move-object v4, p0

    move v5, p1

    move-object v2, p2

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lio/dcloud/p/g4$j;-><init>(Landroid/graphics/Bitmap;Landroid/view/View;Ljava/util/List;ILio/dcloud/p/g4$o;)V

    invoke-static {v3, v0, v1}, Lio/dcloud/p/g4;->a(Landroid/view/View;Landroid/view/Window;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V
    .locals 10

    .line 121
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v7, 0x1

    if-lt p1, v0, :cond_6

    .line 124
    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result p1

    const/4 v0, 0x0

    if-nez p1, :cond_2

    .line 125
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result p1

    .line 126
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    .line 127
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Bitmap;

    .line 128
    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v5

    add-int/2addr p1, v5

    .line 129
    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    if-le v5, v2, :cond_0

    .line 130
    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    goto :goto_0

    .line 135
    :cond_1
    :try_start_0
    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v2, p1, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object p1

    .line 136
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, p1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    const/high16 v3, -0x1000000

    .line 137
    invoke-virtual {v2, v3}, Landroid/graphics/Canvas;->drawColor(I)V

    const/4 v3, 0x0

    .line 140
    invoke-virtual {v2, p2, v3, v3, v0}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 143
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    .line 144
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/graphics/Bitmap;

    int-to-float v9, v4

    .line 145
    invoke-virtual {v2, v8, v3, v9, v0}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 146
    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    add-int/2addr v4, v8

    goto :goto_1

    :catch_0
    move-exception v0

    move-object p1, v0

    .line 149
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    move-object p1, p2

    goto :goto_2

    :cond_2
    move-object p1, v0

    .line 156
    :cond_3
    :goto_2
    invoke-interface {p3}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 159
    :try_start_1
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-virtual {p2, v0, v7}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 160
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 161
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 162
    new-instance v4, Landroid/graphics/PorterDuffXfermode;

    sget-object v5, Landroid/graphics/PorterDuff$Mode;->DST_OVER:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v4, v5}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    .line 165
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v4

    sub-int/2addr v4, v7

    :goto_3
    if-ltz v4, :cond_4

    .line 166
    invoke-interface {p0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/view/SurfaceView;

    .line 167
    invoke-interface {p3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/graphics/Bitmap;

    const/4 v9, 0x2

    .line 169
    new-array v9, v9, [I

    .line 170
    invoke-virtual {v5, v9}, Landroid/view/View;->getLocationOnScreen([I)V

    const/4 v5, 0x0

    .line 173
    aget v5, v9, v5

    int-to-float v5, v5

    aget v9, v9, v7

    int-to-float v9, v9

    invoke-virtual {v2, v8, v5, v9, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    add-int/lit8 v4, v4, -0x1

    goto :goto_3

    :cond_4
    move-object p2, v0

    goto :goto_4

    :catch_1
    move-exception v0

    move-object p0, v0

    .line 176
    invoke-virtual {p0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 181
    :cond_5
    :goto_4
    invoke-interface {p4, p1, p2}, Lio/dcloud/p/g4$o;->a(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    return-void

    .line 185
    :cond_6
    invoke-interface/range {p0 .. p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v8, v0

    check-cast v8, Landroid/view/SurfaceView;

    .line 186
    invoke-virtual {v8}, Landroid/view/View;->getWidth()I

    move-result v0

    if-lez v0, :cond_8

    invoke-virtual {v8}, Landroid/view/View;->getHeight()I

    move-result v0

    if-gtz v0, :cond_7

    goto :goto_5

    .line 191
    :cond_7
    invoke-virtual {v8}, Landroid/view/View;->getWidth()I

    move-result v0

    invoke-virtual {v8}, Landroid/view/View;->getHeight()I

    move-result v2

    sget-object v3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v0, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v2

    .line 193
    :try_start_2
    new-instance v0, Lio/dcloud/p/g4$d;

    move-object v3, p0

    move v4, p1

    move-object v5, p2

    move-object v1, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v6}, Lio/dcloud/p/g4$d;-><init>(Ljava/util/List;Landroid/graphics/Bitmap;Ljava/util/List;ILandroid/graphics/Bitmap;Lio/dcloud/p/g4$o;)V

    sget-object v4, Lio/dcloud/p/g4;->d:Landroid/os/Handler;

    invoke-static {v8, v2, v0, v4}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m(Landroid/view/SurfaceView;Landroid/graphics/Bitmap;Landroid/view/PixelCopy$OnPixelCopyFinishedListener;Landroid/os/Handler;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    return-void

    :catch_2
    move-exception v0

    .line 206
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 208
    sget-object v0, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v7, v7, v0}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    invoke-interface {p3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/2addr p1, v7

    .line 209
    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V

    return-void

    :cond_8
    :goto_5
    add-int/2addr p1, v7

    .line 210
    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/p/g4;->b(Ljava/util/List;ILandroid/graphics/Bitmap;Ljava/util/List;Lio/dcloud/p/g4$o;)V

    return-void
.end method

.method private static c(Ljava/io/File;)V
    .locals 4

    .line 1
    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 4
    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 5
    invoke-static {v3}, Lio/dcloud/p/g4;->c(Ljava/io/File;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 9
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    return-void
.end method
