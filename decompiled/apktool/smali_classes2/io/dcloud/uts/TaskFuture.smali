.class public final Lio/dcloud/uts/TaskFuture;
.super Ljava/lang/Object;
.source "UTSTimer.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0008\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u00a2\u0006\u0004\u0008\u0004\u0010\u0005B\u0019\u0008\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u00a2\u0006\u0004\u0008\u0004\u0010\nJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"
    }
    d2 = {
        "Lio/dcloud/uts/TaskFuture;",
        "",
        "scheduledFuture",
        "Ljava/util/concurrent/ScheduledFuture;",
        "<init>",
        "(Ljava/util/concurrent/ScheduledFuture;)V",
        "handler",
        "Landroid/os/Handler;",
        "taskRun",
        "Lio/dcloud/uts/UTSRunnable;",
        "(Landroid/os/Handler;Lio/dcloud/uts/UTSRunnable;)V",
        "hostHandler",
        "hostRun",
        "scheduler",
        "cancel",
        "",
        "utsplugin_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field private hostHandler:Landroid/os/Handler;

.field private hostRun:Lio/dcloud/uts/UTSRunnable;

.field private scheduler:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture<",
            "*>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/os/Handler;Lio/dcloud/uts/UTSRunnable;)V
    .locals 1

    const-string v0, "handler"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "taskRun"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object p1, p0, Lio/dcloud/uts/TaskFuture;->hostHandler:Landroid/os/Handler;

    .line 40
    iput-object p2, p0, Lio/dcloud/uts/TaskFuture;->hostRun:Lio/dcloud/uts/UTSRunnable;

    return-void
.end method

.method public constructor <init>(Ljava/util/concurrent/ScheduledFuture;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/ScheduledFuture<",
            "*>;)V"
        }
    .end annotation

    const-string v0, "scheduledFuture"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lio/dcloud/uts/TaskFuture;->scheduler:Ljava/util/concurrent/ScheduledFuture;

    return-void
.end method


# virtual methods
.method public final cancel()V
    .locals 3

    .line 47
    iget-object v0, p0, Lio/dcloud/uts/TaskFuture;->hostHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    iget-object v2, p0, Lio/dcloud/uts/TaskFuture;->hostRun:Lio/dcloud/uts/UTSRunnable;

    if-eqz v2, :cond_0

    .line 48
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    iget-object v2, p0, Lio/dcloud/uts/TaskFuture;->hostRun:Lio/dcloud/uts/UTSRunnable;

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    check-cast v2, Ljava/lang/Runnable;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 49
    iget-object v0, p0, Lio/dcloud/uts/TaskFuture;->hostRun:Lio/dcloud/uts/UTSRunnable;

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lio/dcloud/uts/UTSRunnable;->setStop(Z)V

    .line 51
    :cond_0
    iget-object v0, p0, Lio/dcloud/uts/TaskFuture;->scheduler:Ljava/util/concurrent/ScheduledFuture;

    if-eqz v0, :cond_1

    .line 52
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledFuture;->cancel(Z)Z

    :cond_1
    return-void
.end method
