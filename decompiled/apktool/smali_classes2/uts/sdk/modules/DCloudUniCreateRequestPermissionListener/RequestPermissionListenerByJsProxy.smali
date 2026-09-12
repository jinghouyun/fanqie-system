.class public Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;
.super Ljava/lang/Object;
.source "index.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u0010\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096.\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0005\u00a8\u0006\u0011"
    }
    d2 = {
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;",
        "",
        "ins",
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
        "<init>",
        "(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V",
        "__instance",
        "get__instance",
        "()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
        "set__instance",
        "onRequestByJs",
        "",
        "callback",
        "Lio/dcloud/uts/UTSCallback;",
        "onConfirmByJs",
        "onCompleteByJs",
        "stopByJs",
        "uni-createRequestPermissionListener_release"
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
.field public __instance:Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;


# direct methods
.method public static synthetic $r8$lambda$3GfpVUuiJnyHMOkTHNOBLtHXxuQ(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->onCompleteByJs$lambda$2(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$brX5RjXLPYnvZXdJ4vhzbe39cBc(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->onConfirmByJs$lambda$1(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$hTA6b3iAqzu9DqitmQtYBfKHhpo(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->onRequestByJs$lambda$0(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public constructor <init>(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V
    .locals 1

    const-string v0, "ins"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    invoke-virtual {p0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->set__instance(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V

    return-void
.end method

.method private static final onCompleteByJs$lambda$2(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSCallback;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/String;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 109
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSCallback;->invoke([Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final onConfirmByJs$lambda$1(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSCallback;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/String;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 98
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSCallback;->invoke([Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final onRequestByJs$lambda$0(Lio/dcloud/uts/UTSCallback;Lio/dcloud/uts/UTSArray;)Lkotlin/Unit;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSCallback;",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/String;",
            ">;)",
            "Lkotlin/Unit;"
        }
    .end annotation

    const/4 v0, 0x1

    .line 87
    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSCallback;->invoke([Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method


# virtual methods
.method public get__instance()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;
    .locals 1

    .line 78
    iget-object v0, p0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->__instance:Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    if-eqz v0, :cond_0

    return-object v0

    :cond_0
    const-string v0, "__instance"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public onCompleteByJs(Lio/dcloud/uts/UTSCallback;)V
    .locals 2

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 105
    invoke-virtual {p0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->get__instance()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    move-result-object v0

    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 106
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    goto :goto_0

    .line 108
    :cond_0
    new-instance v1, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda1;

    invoke-direct {v1, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda1;-><init>(Lio/dcloud/uts/UTSCallback;)V

    invoke-virtual {p1, v1}, Lio/dcloud/uts/UTSCallback;->setFnJS(Ljava/lang/Object;)V

    .line 111
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    .line 105
    :goto_0
    const-string v1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/TypeIntrinsics;->beforeCheckcastToFunctionOfArity(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;->onComplete(Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public onConfirmByJs(Lio/dcloud/uts/UTSCallback;)V
    .locals 2

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 94
    invoke-virtual {p0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->get__instance()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    move-result-object v0

    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 95
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    goto :goto_0

    .line 97
    :cond_0
    new-instance v1, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda2;

    invoke-direct {v1, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda2;-><init>(Lio/dcloud/uts/UTSCallback;)V

    invoke-virtual {p1, v1}, Lio/dcloud/uts/UTSCallback;->setFnJS(Ljava/lang/Object;)V

    .line 100
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    .line 94
    :goto_0
    const-string v1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/TypeIntrinsics;->beforeCheckcastToFunctionOfArity(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;->onConfirm(Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public onRequestByJs(Lio/dcloud/uts/UTSCallback;)V
    .locals 2

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 83
    invoke-virtual {p0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->get__instance()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    move-result-object v0

    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 84
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    goto :goto_0

    .line 86
    :cond_0
    new-instance v1, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda0;

    invoke-direct {v1, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/uts/UTSCallback;)V

    invoke-virtual {p1, v1}, Lio/dcloud/uts/UTSCallback;->setFnJS(Ljava/lang/Object;)V

    .line 89
    invoke-virtual {p1}, Lio/dcloud/uts/UTSCallback;->getFnJS()Ljava/lang/Object;

    move-result-object p1

    .line 83
    :goto_0
    const-string v1, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/TypeIntrinsics;->beforeCheckcastToFunctionOfArity(Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lkotlin/jvm/functions/Function1;

    invoke-interface {v0, p1}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;->onRequest(Lkotlin/jvm/functions/Function1;)V

    return-void
.end method

.method public set__instance(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 78
    iput-object p1, p0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->__instance:Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    return-void
.end method

.method public stopByJs()V
    .locals 1

    .line 116
    invoke-virtual {p0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;->get__instance()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    move-result-object v0

    invoke-interface {v0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;->stop()V

    return-void
.end method
