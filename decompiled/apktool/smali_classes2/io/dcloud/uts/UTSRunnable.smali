.class public abstract Lio/dcloud/uts/UTSRunnable;
.super Ljava/lang/Object;
.source "UTSTimer.kt"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\u000bH&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\t\u00a8\u0006\r"
    }
    d2 = {
        "Lio/dcloud/uts/UTSRunnable;",
        "Ljava/lang/Runnable;",
        "<init>",
        "()V",
        "stop",
        "",
        "getStop",
        "()Z",
        "setStop",
        "(Z)V",
        "run",
        "",
        "doSth",
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
.field private stop:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract doSth()V
.end method

.method public getStop()Z
    .locals 1

    .line 63
    iget-boolean v0, p0, Lio/dcloud/uts/UTSRunnable;->stop:Z

    return v0
.end method

.method public run()V
    .locals 1

    .line 67
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRunnable;->getStop()Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    invoke-virtual {p0}, Lio/dcloud/uts/UTSRunnable;->doSth()V

    :cond_0
    return-void
.end method

.method public setStop(Z)V
    .locals 0

    .line 63
    iput-boolean p1, p0, Lio/dcloud/uts/UTSRunnable;->stop:Z

    return-void
.end method
