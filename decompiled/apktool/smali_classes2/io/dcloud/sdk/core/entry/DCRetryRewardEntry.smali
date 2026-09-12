.class public Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final a:Ljava/lang/String;

.field private final b:Ljava/lang/String;

.field private final c:Ljava/lang/String;

.field private final d:Ljava/lang/String;

.field private final e:I

.field private final f:Ljava/lang/String;

.field private final g:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->a:Ljava/lang/String;

    .line 3
    iput-object p2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->b:Ljava/lang/String;

    .line 4
    iput-object p3, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->c:Ljava/lang/String;

    .line 5
    iput-object p4, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->d:Ljava/lang/String;

    .line 6
    iput p5, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->e:I

    .line 7
    iput-object p6, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->f:Ljava/lang/String;

    .line 8
    iput p7, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->g:I

    return-void
.end method


# virtual methods
.method public getAdSource()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->b:Ljava/lang/String;

    return-object v0
.end method

.method public getAppIconUrl()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->c:Ljava/lang/String;

    return-object v0
.end method

.method public getAppName()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->d:Ljava/lang/String;

    return-object v0
.end method

.method public getConvertType()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->e:I

    return v0
.end method

.method public getProductName()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->a:Ljava/lang/String;

    return-object v0
.end method

.method public toJson()Lorg/json/JSONObject;
    .locals 3

    .line 1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 3
    :try_start_0
    const-string v1, "productName"

    iget-object v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->a:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 5
    const-string v1, "appIconUrl"

    iget-object v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 6
    const-string v1, "appName"

    iget-object v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 7
    const-string v1, "convertType"

    iget v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->e:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 8
    const-string v1, "adDescription"

    iget-object v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->f:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 9
    const-string v1, "interactionType"

    iget v2, p0, Lio/dcloud/sdk/core/entry/DCRetryRewardEntry;->g:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    return-object v0
.end method
