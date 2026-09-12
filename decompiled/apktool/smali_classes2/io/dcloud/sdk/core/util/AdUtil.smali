.class public Lio/dcloud/sdk/core/util/AdUtil;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field private static a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCustomPrivacyConfig()Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
    .locals 1

    .line 2
    sget-object v0, Lio/dcloud/sdk/core/util/AdUtil;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    return-object v0
.end method

.method public static getCustomPrivacyConfig(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .line 1
    const-string v0, "dcloud-ads"

    const-string v1, "CustomPrivacyConfig"

    invoke-static {p0, v0, v1}, Lio/dcloud/p/e4;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method public static getDCloudPrivacyConfig(Landroid/content/Context;)Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
    .locals 1

    .line 1
    invoke-static {p0}, Lio/dcloud/sdk/core/util/AdUtil;->getCustomPrivacyConfig(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p0

    .line 2
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 4
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 5
    invoke-static {v0}, Lio/dcloud/sdk/core/util/AdUtil;->getPrivacyConfig(Lorg/json/JSONObject;)Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object p0

    :catch_0
    :cond_0
    const/4 p0, 0x0

    return-object p0
.end method

.method public static getOrDefault(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "TT;>;",
            "Ljava/lang/Object;",
            "TT;)TT;"
        }
    .end annotation

    if-nez p0, :cond_0

    goto :goto_0

    .line 1
    :cond_0
    invoke-interface {p0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_2

    invoke-interface {p0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_1

    goto :goto_1

    :cond_1
    :goto_0
    return-object p2

    :cond_2
    :goto_1
    return-object v0
.end method

.method public static getPersonalAd(Landroid/content/Context;)Z
    .locals 2

    .line 1
    const-string v0, "dcloud-ads"

    const-string v1, "PersonalizedAdEnable"

    invoke-static {p0, v0, v1}, Lio/dcloud/p/e4;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    .line 2
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3
    const-string p0, "true"

    .line 5
    :cond_0
    invoke-static {p0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result p0

    return p0
.end method

.method public static getPrivacyConfig(Lorg/json/JSONObject;)Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
    .locals 1

    .line 1
    new-instance v0, Lio/dcloud/sdk/core/util/AdUtil$1;

    invoke-direct {v0, p0}, Lio/dcloud/sdk/core/util/AdUtil$1;-><init>(Lorg/json/JSONObject;)V

    return-object v0
.end method

.method public static setCustomPrivacyConfig(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    .line 1
    const-string v0, "dcloud-ads"

    const-string v1, "CustomPrivacyConfig"

    invoke-static {p0, v0, v1, p1}, Lio/dcloud/p/e4;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static setCustomPrivacyConfig(Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;)V
    .locals 0

    .line 2
    sput-object p0, Lio/dcloud/sdk/core/util/AdUtil;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    return-void
.end method

.method public static setPersonalAd(Landroid/content/Context;Z)V
    .locals 2

    .line 1
    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object p1

    const-string v0, "dcloud-ads"

    const-string v1, "PersonalizedAdEnable"

    invoke-static {p0, v0, v1, p1}, Lio/dcloud/p/e4;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
