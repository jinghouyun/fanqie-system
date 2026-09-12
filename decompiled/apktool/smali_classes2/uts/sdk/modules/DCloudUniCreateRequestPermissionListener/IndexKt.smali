.class public final Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;
.super Ljava/lang/Object;
.source "index.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\u001a\u0006\u0010\u0011\u001a\u00020\u0012\"\u001b\u0010\r\u001a\u000c\u0012\u0004\u0012\u00020\u000c0\u000bj\u0002`\u000e\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010*L\u0010\u0000\"#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u00012#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u0001*L\u0010\u0008\"#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u00012#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u0001*L\u0010\t\"#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u00012#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u0001*\u0016\u0010\n\"\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u00a8\u0006\u0013"
    }
    d2 = {
        "RequestPermissionListenerRequestCallback",
        "Lkotlin/Function1;",
        "Lio/dcloud/uts/UTSArray;",
        "",
        "Lkotlin/ParameterName;",
        "name",
        "permissions",
        "",
        "RequestPermissionListenerConfirmCallback",
        "RequestPermissionListenerCompleteCallback",
        "CreateRequestPermissionListener",
        "Lkotlin/Function0;",
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
        "createRequestPermissionListener",
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/CreateRequestPermissionListener;",
        "getCreateRequestPermissionListener",
        "()Lkotlin/jvm/functions/Function0;",
        "createRequestPermissionListenerByJs",
        "",
        "uni-createRequestPermissionListener_release"
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
.field private static final createRequestPermissionListener:Lkotlin/jvm/functions/Function0;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lkotlin/jvm/functions/Function0<",
            "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public static synthetic $r8$lambda$6MGOpWN5O8BZ72GVjZTZTR3pPnw()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;
    .locals 1

    invoke-static {}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;->createRequestPermissionListener$lambda$0()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 24
    new-instance v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;->createRequestPermissionListener:Lkotlin/jvm/functions/Function0;

    return-void
.end method

.method private static final createRequestPermissionListener$lambda$0()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;
    .locals 1

    .line 25
    new-instance v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/AndroidPermissionRequestManager;

    invoke-direct {v0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/AndroidPermissionRequestManager;-><init>()V

    check-cast v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    return-object v0
.end method

.method public static final createRequestPermissionListenerByJs()I
    .locals 3

    .line 74
    sget-object v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;->createRequestPermissionListener:Lkotlin/jvm/functions/Function0;

    invoke-interface {v0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;

    .line 75
    sget-object v1, Lio/dcloud/uts/UTSBridge;->INSTANCE:Lio/dcloud/uts/UTSBridge;

    new-instance v2, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;

    invoke-direct {v2, v0}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;-><init>(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V

    invoke-virtual {v1, v2}, Lio/dcloud/uts/UTSBridge;->registerJavaScriptClassInstance(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public static final getCreateRequestPermissionListener()Lkotlin/jvm/functions/Function0;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lkotlin/jvm/functions/Function0<",
            "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
            ">;"
        }
    .end annotation

    .line 24
    sget-object v0, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;->createRequestPermissionListener:Lkotlin/jvm/functions/Function0;

    return-object v0
.end method
