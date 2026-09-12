.class public abstract Lio/dcloud/sdk/core/DCloudAOLManager$PrivacyConfig;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/sdk/core/DCloudAOLManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "PrivacyConfig"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isAdult()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetAndroidId()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetBootId()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetIP()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetInstallAppList()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetMacAddress()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetOAID()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanGetRunningApps()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseLocation()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUsePhoneState()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseRecordPermission()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseSensor()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseSimOperator()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseStorage()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isCanUseWifiState()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public isGDTAgreeStrategy()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public userPrivacyConfig()Lorg/json/JSONObject;
    .locals 1

    .line 1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    return-object v0
.end method
