.class Lio/dcloud/sdk/core/util/AdUtil$1;
.super Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/util/AdUtil;->getPrivacyConfig(Lorg/json/JSONObject;)Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lorg/json/JSONObject;


# direct methods
.method constructor <init>(Lorg/json/JSONObject;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    invoke-direct {p0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;-><init>()V

    return-void
.end method


# virtual methods
.method public isAdult()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isAdult"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetAndroidId()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetAndroidId"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetBootId()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetBootId"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetIP()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetIP"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetInstallAppList()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetInstallAppList"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetMacAddress()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetMacAddress"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetOAID()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetOAID"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanGetRunningApps()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanGetRunningApps"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseLocation()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseLocation"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUsePhoneState()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUsePhoneState"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseRecordPermission()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseRecordPermission"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseSensor()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseSensor"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseSimOperator()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseSimOperator"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseStorage()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseStorage"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isCanUseWifiState()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isCanUseWifiState"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public isGDTAgreeStrategy()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "isGDTAgreeStrategy"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public userPrivacyConfig()Lorg/json/JSONObject;
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/util/AdUtil$1;->a:Lorg/json/JSONObject;

    const-string v1, "userPrivacyConfig"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    if-nez v0, :cond_0

    .line 3
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :cond_0
    return-object v0
.end method
