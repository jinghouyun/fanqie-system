.class public Lio/dcloud/common/ui/blur/NativeBlurProcess;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/common/ui/blur/NativeBlurProcess$NativeTask;
    }
.end annotation


# instance fields
.field final EXECUTOR:Ljava/util/concurrent/ExecutorService;

.field final EXECUTOR_THREADS:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    iput v0, p0, Lio/dcloud/common/ui/blur/NativeBlurProcess;->EXECUTOR_THREADS:I

    .line 4
    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    iput-object v0, p0, Lio/dcloud/common/ui/blur/NativeBlurProcess;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    return-void
.end method


# virtual methods
.method public blur(Landroid/graphics/Bitmap;FZ)Landroid/graphics/Bitmap;
    .locals 6

    if-eqz p3, :cond_0

    .line 1
    sget-object p3, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    const/4 v0, 0x1

    invoke-virtual {p1, p3, v0}, Landroid/graphics/Bitmap;->copy(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;

    move-result-object p1

    :cond_0
    move-object v1, p1

    .line 6
    iget v3, p0, Lio/dcloud/common/ui/blur/NativeBlurProcess;->EXECUTOR_THREADS:I

    .line 8
    new-instance p1, Ljava/util/ArrayList;

    invoke-direct {p1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 9
    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3, v3}, Ljava/util/ArrayList;-><init>(I)V

    const/4 v0, 0x0

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v3, :cond_1

    .line 11
    new-instance v0, Lio/dcloud/common/ui/blur/NativeBlurProcess$NativeTask;

    float-to-int v2, p2

    const/4 v5, 0x1

    invoke-direct/range {v0 .. v5}, Lio/dcloud/common/ui/blur/NativeBlurProcess$NativeTask;-><init>(Landroid/graphics/Bitmap;IIII)V

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 12
    new-instance v0, Lio/dcloud/common/ui/blur/NativeBlurProcess$NativeTask;

    const/4 v5, 0x2

    invoke-direct/range {v0 .. v5}, Lio/dcloud/common/ui/blur/NativeBlurProcess$NativeTask;-><init>(Landroid/graphics/Bitmap;IIII)V

    invoke-virtual {p3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 16
    :cond_1
    :try_start_0
    iget-object p2, p0, Lio/dcloud/common/ui/blur/NativeBlurProcess;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    invoke-interface {p2, p1}, Ljava/util/concurrent/ExecutorService;->invokeAll(Ljava/util/Collection;)Ljava/util/List;

    .line 22
    iget-object p1, p0, Lio/dcloud/common/ui/blur/NativeBlurProcess;->EXECUTOR:Ljava/util/concurrent/ExecutorService;

    invoke-interface {p1, p3}, Ljava/util/concurrent/ExecutorService;->invokeAll(Ljava/util/Collection;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    return-object v1
.end method
