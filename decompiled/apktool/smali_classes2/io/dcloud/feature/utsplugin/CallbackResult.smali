.class public final Lio/dcloud/feature/utsplugin/CallbackResult;
.super Ljava/lang/Object;
.source "CallbackResult.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\tX\u0086D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\u0005X\u0086D\u00a2\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019\u00a8\u0006\u001a"
    }
    d2 = {
        "Lio/dcloud/feature/utsplugin/CallbackResult;",
        "",
        "<init>",
        "()V",
        "type",
        "",
        "getType",
        "()Ljava/lang/String;",
        "id",
        "",
        "getId",
        "()I",
        "name",
        "getName",
        "param",
        "Lcom/alibaba/fastjson/JSONArray;",
        "getParam",
        "()Lcom/alibaba/fastjson/JSONArray;",
        "setParam",
        "(Lcom/alibaba/fastjson/JSONArray;)V",
        "keepAlive",
        "",
        "getKeepAlive",
        "()Z",
        "setKeepAlive",
        "(Z)V",
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
.field private final id:I

.field private keepAlive:Z

.field private final name:Ljava/lang/String;

.field private param:Lcom/alibaba/fastjson/JSONArray;

.field private final type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const-string v0, "params"

    iput-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->type:Ljava/lang/String;

    const/4 v0, -0x1

    .line 12
    iput v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->id:I

    .line 13
    const-string v0, "complete"

    iput-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->name:Ljava/lang/String;

    .line 14
    new-instance v0, Lcom/alibaba/fastjson/JSONArray;

    invoke-direct {v0}, Lcom/alibaba/fastjson/JSONArray;-><init>()V

    iput-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->param:Lcom/alibaba/fastjson/JSONArray;

    return-void
.end method


# virtual methods
.method public final getId()I
    .locals 1

    .line 12
    iget v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->id:I

    return v0
.end method

.method public final getKeepAlive()Z
    .locals 1

    .line 15
    iget-boolean v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->keepAlive:Z

    return v0
.end method

.method public final getName()Ljava/lang/String;
    .locals 1

    .line 13
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->name:Ljava/lang/String;

    return-object v0
.end method

.method public final getParam()Lcom/alibaba/fastjson/JSONArray;
    .locals 1

    .line 14
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->param:Lcom/alibaba/fastjson/JSONArray;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 11
    iget-object v0, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->type:Ljava/lang/String;

    return-object v0
.end method

.method public final setKeepAlive(Z)V
    .locals 0

    .line 15
    iput-boolean p1, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->keepAlive:Z

    return-void
.end method

.method public final setParam(Lcom/alibaba/fastjson/JSONArray;)V
    .locals 1

    const-string v0, "<set-?>"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    iput-object p1, p0, Lio/dcloud/feature/utsplugin/CallbackResult;->param:Lcom/alibaba/fastjson/JSONArray;

    return-void
.end method
