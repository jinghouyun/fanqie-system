.class public Lio/dcloud/api/custom/base/UniAdPrivacyConfig;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;


# direct methods
.method public constructor <init>(Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    return-void
.end method


# virtual methods
.method public isAdult()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isAdult()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetAndroidId()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetAndroidId()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetBootId()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetBootId()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetIP()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetIP()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetInstallAppList()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetInstallAppList()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetMacAddress()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetMacAddress()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetOAID()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetOAID()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetRunningApps()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanGetRunningApps()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseLocation()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseLocation()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUsePhoneState()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUsePhoneState()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseRecordPermission()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseRecordPermission()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseSensor()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseSensor()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseSimOperator()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseSimOperator()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseStorage()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseStorage()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseWifiState()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isCanUseWifiState()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public isGDTAgreeStrategy()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->isGDTAgreeStrategy()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    :goto_0
    const/4 v0, 0x1

    return v0
.end method

.method public userPrivacyConfig()Lorg/json/JSONObject;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/api/custom/base/UniAdPrivacyConfig;->a:Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;->userPrivacyConfig()Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_1

    .line 4
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :cond_1
    return-object v0
.end method
