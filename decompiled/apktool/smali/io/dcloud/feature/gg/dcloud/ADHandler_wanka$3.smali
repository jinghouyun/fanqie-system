.class Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/feature/gg/dcloud/ADHandler_wanka;->click_wanka_url(Landroid/content/Context;Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic val$adData:Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;

.field final synthetic val$clktrackers:Lorg/json/JSONArray;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lorg/json/JSONArray;Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;Landroid/content/Context;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 1
    iput-object p1, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$clktrackers:Lorg/json/JSONArray;

    iput-object p2, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$adData:Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;

    iput-object p3, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    const-string/jumbo v1, "ua"

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$clktrackers:Lorg/json/JSONArray;

    if-eqz v0, :cond_3

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 2
    :goto_0
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$clktrackers:Lorg/json/JSONArray;

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v3, v0, :cond_3

    .line 4
    :try_start_0
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$clktrackers:Lorg/json/JSONArray;

    invoke-virtual {v0, v3}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 5
    const-string/jumbo v4, "template_type"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v4

    .line 6
    iget-object v5, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$adData:Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;

    invoke-virtual {v5}, Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;->full()Lorg/json/JSONObject;

    move-result-object v5

    .line 8
    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    const/4 v7, 0x1

    if-eqz v6, :cond_0

    .line 9
    invoke-virtual {v5, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string/jumbo v8, "webview"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v11, 0x1

    goto :goto_1

    :cond_0
    const/4 v11, 0x0

    .line 13
    :goto_1
    const-string/jumbo v6, "u-a"

    const-string/jumbo v8, "ua-webview"

    invoke-static {v8}, Lio/dcloud/feature/gg/dcloud/ADHandler;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v6, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 14
    const-string/jumbo v6, "url"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v5}, Lio/dcloud/feature/gg/dcloud/ADHandler;->formatUrl(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v5

    .line 15
    const-string v6, "http_method"

    invoke-virtual {v0, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v6

    .line 16
    const-string v8, "content"

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-ne v4, v7, :cond_2

    .line 18
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$adData:Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;

    invoke-virtual {v0}, Lio/dcloud/feature/gg/dcloud/ADHandler$AdData;->isEClick()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 19
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$context:Landroid/content/Context;

    invoke-static {v0, v5}, Lio/dcloud/feature/gg/dcloud/ADSim;->openUrl(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 21
    :cond_1
    iget-object v0, p0, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka$3;->val$context:Landroid/content/Context;

    invoke-static {v0, v5}, Lio/dcloud/common/util/ADUtils;->openUrl(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 24
    :cond_2
    const-string v10, "clktrackers"

    const/4 v7, 0x2

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v4, v5

    move-object v5, v0

    invoke-static/range {v4 .. v11}, Lio/dcloud/feature/gg/dcloud/ADHandler_wanka;->access$100(Ljava/lang/String;Ljava/lang/String;IIZLio/dcloud/common/DHInterface/ICallBack;Ljava/lang/String;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    :catch_0
    move-exception v0

    .line 27
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    :cond_3
    return-void
.end method
