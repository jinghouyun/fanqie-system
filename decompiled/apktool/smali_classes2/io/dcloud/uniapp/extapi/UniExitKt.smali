.class public final Lio/dcloud/uniapp/extapi/UniExitKt;
.super Ljava/lang/Object;
.source "uniExit.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"2\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u000cj\u0002`\u0011\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003*\n\u0010\u0004\"\u00020\u00052\u00020\u0005*\u000e\u0010\u0006\"\u0002`\u00072\u00060\u0008j\u0002`\u0007*\u000e\u0010\t\"\u0002`\n2\u00060\u0005j\u0002`\n\u00a8\u0006\u0014"
    }
    d2 = {
        "ExitSuccess",
        "Luts/sdk/modules/DCloudUniExit/ExitSuccess;",
        "ExitOptions",
        "Luts/sdk/modules/DCloudUniExit/ExitOptions;",
        "IExitError",
        "Luts/sdk/modules/DCloudUniExit/IExitError;",
        "ExitErrorCode",
        "Luts/sdk/modules/DCloudUniExit/ExitErrorCode;",
        "",
        "ExitFail",
        "Luts/sdk/modules/DCloudUniExit/ExitFail;",
        "exit",
        "Lkotlin/Function1;",
        "Lkotlin/ParameterName;",
        "name",
        "options",
        "",
        "Luts/sdk/modules/DCloudUniExit/Exit;",
        "getExit",
        "()Lkotlin/jvm/functions/Function1;",
        "uni-exit_release"
    }
    k = 0x2
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final exit:Lkotlin/jvm/functions/Function1;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function1<",
            "Luts/sdk/modules/DCloudUniExit/ExitOptions;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 15
    invoke-static {}, Luts/sdk/modules/DCloudUniExit/IndexKt;->getExit()Lkotlin/jvm/functions/Function1;

    move-result-object v0

    sput-object v0, Lio/dcloud/uniapp/extapi/UniExitKt;->exit:Lkotlin/jvm/functions/Function1;

    return-void
.end method

.method public static final getExit()Lkotlin/jvm/functions/Function1;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/jvm/functions/Function1<",
            "Luts/sdk/modules/DCloudUniExit/ExitOptions;",
            "Lkotlin/Unit;",
            ">;"
        }
    .end annotation

    .line 15
    sget-object v0, Lio/dcloud/uniapp/extapi/UniExitKt;->exit:Lkotlin/jvm/functions/Function1;

    return-object v0
.end method
