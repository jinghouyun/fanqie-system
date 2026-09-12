.class public final Lio/dcloud/uniapp/extapi/UniCreateRequestPermissionListenerKt;
.super Ljava/lang/Object;
.source "uniCreateRequestPermissionListener.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u001b\u0010\u0002\u001a\u000c\u0012\u0004\u0012\u00020\u00010\u0003j\u0002`\u0004\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u00a8\u0006\u0007"
    }
    d2 = {
        "RequestPermissionListener",
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;",
        "createRequestPermissionListener",
        "Lkotlin/Function0;",
        "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/CreateRequestPermissionListener;",
        "getCreateRequestPermissionListener",
        "()Lkotlin/jvm/functions/Function0;",
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
.method static constructor <clinit>()V
    .locals 1

    .line 7
    invoke-static {}, Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/IndexKt;->getCreateRequestPermissionListener()Lkotlin/jvm/functions/Function0;

    move-result-object v0

    sput-object v0, Lio/dcloud/uniapp/extapi/UniCreateRequestPermissionListenerKt;->createRequestPermissionListener:Lkotlin/jvm/functions/Function0;

    return-void
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

    .line 7
    sget-object v0, Lio/dcloud/uniapp/extapi/UniCreateRequestPermissionListenerKt;->createRequestPermissionListener:Lkotlin/jvm/functions/Function0;

    return-object v0
.end method
