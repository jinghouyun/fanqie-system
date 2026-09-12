.class public Lio/dcloud/p/p1;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field a:Lio/dcloud/common/DHInterface/AbsMgr;

.field b:Lio/dcloud/js/geolocation/GeoManagerBase;

.field c:Lio/dcloud/js/geolocation/GeoManagerBase;

.field d:Lio/dcloud/js/geolocation/GeoManagerBase;

.field e:Z


# direct methods
.method public constructor <init>(Lio/dcloud/common/DHInterface/AbsMgr;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 2
    iput-object v0, p0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    .line 3
    iput-object v0, p0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    .line 4
    iput-object v0, p0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lio/dcloud/p/p1;->e:Z

    .line 7
    iput-object p1, p0, Lio/dcloud/p/p1;->a:Lio/dcloud/common/DHInterface/AbsMgr;

    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    .line 29
    invoke-static/range {p3 .. p3}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    const-string v3, "wgs84"

    if-eqz v2, :cond_0

    move-object v2, v3

    goto :goto_0

    :cond_0
    move-object/from16 v2, p3

    .line 32
    :goto_0
    invoke-static {v1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    const-string v5, "io.dcloud.js.geolocation.amap.AMapGeoManager"

    const-string v6, "io.dcloud.js.geolocation.system.LocalGeoManager"

    const-string v7, "io.dcloud.js.geolocation.baidu.BaiduGeoManager"

    if-eqz v4, :cond_b

    .line 33
    invoke-static {v2, v3}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 34
    iget-object v1, v0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_1

    invoke-direct {v0, v6}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_1
    iput-object v1, v0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_2

    .line 35
    :cond_2
    const-string v1, "gcj02"

    invoke-static {v2, v1}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 36
    iget-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_3

    invoke-direct {v0, v5}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_3
    iput-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_9

    if-nez v1, :cond_4

    .line 38
    invoke-direct {v0, v7}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_4
    iput-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_2

    .line 40
    :cond_5
    const-string v3, "bd09"

    invoke-static {v2, v3}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_7

    const-string v3, "bd09ll"

    invoke-static {v2, v3}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_7

    invoke-static {v2, v1}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    goto :goto_1

    :cond_6
    const/4 v1, 0x0

    goto :goto_2

    .line 41
    :cond_7
    :goto_1
    iget-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_8

    invoke-direct {v0, v7}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_8
    iput-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    :cond_9
    :goto_2
    if-nez v1, :cond_a

    .line 44
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "not support "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x12

    invoke-static {v3, v2}, Lio/dcloud/common/constant/DOMException;->toJSON(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 45
    sget v7, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v8, 0x1

    const/4 v9, 0x0

    move-object/from16 v4, p1

    move-object/from16 v5, p4

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    :cond_a
    return-object v1

    .line 48
    :cond_b
    const-string v2, "baidu"

    invoke-static {v2, v1}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 49
    iget-object v1, v0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_c

    invoke-direct {v0, v7}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_c
    iput-object v1, v0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_3

    .line 50
    :cond_d
    const-string v2, "amap"

    invoke-static {v2, v1}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 51
    iget-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_e

    invoke-direct {v0, v5}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_e
    iput-object v1, v0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_3

    .line 53
    :cond_f
    iget-object v1, v0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-nez v1, :cond_10

    invoke-direct {v0, v6}, Lio/dcloud/p/p1;->a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v1

    :cond_10
    iput-object v1, v0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    :goto_3
    if-nez v1, :cond_11

    .line 56
    sget-object v2, Lio/dcloud/common/constant/DOMException;->MSG_GEOLOCATION_PROVIDER_ERROR:Ljava/lang/String;

    const/16 v3, 0x11

    invoke-static {v3, v2}, Lio/dcloud/common/constant/DOMException;->toJSON(ILjava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 57
    sget v13, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v14, 0x1

    const/4 v15, 0x0

    move-object/from16 v10, p1

    move-object/from16 v11, p4

    invoke-static/range {v10 .. v15}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    :cond_11
    return-object v1
.end method

.method private a(Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;
    .locals 7

    const/4 v0, 0x0

    .line 1
    :try_start_0
    const-string v1, "io.dcloud.js.geolocation.amap.AMapGeoManager"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-eqz v1, :cond_0

    .line 2
    const-string v1, "getInstance"

    new-array v4, v3, [Ljava/lang/Class;

    const-class v5, Landroid/content/Context;

    aput-object v5, v4, v2

    iget-object v5, p0, Lio/dcloud/p/p1;->a:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v5}, Lio/dcloud/common/DHInterface/AbsMgr;->getContext()Landroid/content/Context;

    move-result-object v5

    new-array v6, v3, [Ljava/lang/Object;

    aput-object v5, v6, v2

    invoke-static {p1, v1, v0, v4, v6}, Lio/dcloud/common/adapter/util/PlatformUtil;->invokeMethod(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v1, :cond_0

    return-object v1

    .line 7
    :cond_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 8
    new-array v4, v3, [Ljava/lang/Class;

    const-class v5, Landroid/content/Context;

    aput-object v5, v4, v2

    invoke-virtual {v1, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 9
    iget-object v4, p0, Lio/dcloud/p/p1;->a:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v4}, Lio/dcloud/common/DHInterface/AbsMgr;->getContext()Landroid/content/Context;

    move-result-object v4

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v4, v3, v2

    invoke-virtual {v1, v3}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/dcloud/js/geolocation/GeoManagerBase;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 12
    :catch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string p1, " exception"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v1, "geoLoaction"

    invoke-static {v1, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-object v0
.end method


# virtual methods
.method public a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .line 13
    const-string v0, "clearWatch"

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    if-eqz v0, :cond_3

    .line 15
    iget-object v0, p0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_0

    aget-object v3, p3, v1

    invoke-virtual {v0, v3}, Lio/dcloud/js/geolocation/GeoManagerBase;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 16
    iget-object v0, p0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_0

    .line 17
    :cond_0
    iget-object v0, p0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_1

    aget-object v3, p3, v1

    invoke-virtual {v0, v3}, Lio/dcloud/js/geolocation/GeoManagerBase;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 18
    iget-object v0, p0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_0

    .line 19
    :cond_1
    iget-object v0, p0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_2

    aget-object v1, p3, v1

    invoke-virtual {v0, v1}, Lio/dcloud/js/geolocation/GeoManagerBase;->hasKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 20
    iget-object v0, p0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    goto :goto_0

    :cond_2
    move-object v0, v2

    goto :goto_0

    :cond_3
    const/4 v0, 0x3

    .line 23
    aget-object v0, p3, v0

    const/4 v3, 0x4

    .line 24
    aget-object v3, p3, v3

    .line 25
    aget-object v1, p3, v1

    invoke-direct {p0, p1, v3, v0, v1}, Lio/dcloud/p/p1;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/js/geolocation/GeoManagerBase;

    move-result-object v0

    :goto_0
    if-eqz v0, :cond_4

    .line 28
    invoke-virtual {v0, p1, p2, p3}, Lio/dcloud/js/geolocation/GeoManagerBase;->execute(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    :cond_4
    return-object v2
.end method

.method public a()V
    .locals 1

    .line 58
    iget-object v0, p0, Lio/dcloud/p/p1;->b:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_0

    .line 59
    invoke-virtual {v0}, Lio/dcloud/js/geolocation/GeoManagerBase;->onDestroy()V

    .line 61
    :cond_0
    iget-object v0, p0, Lio/dcloud/p/p1;->d:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_1

    .line 62
    invoke-virtual {v0}, Lio/dcloud/js/geolocation/GeoManagerBase;->onDestroy()V

    .line 64
    :cond_1
    iget-object v0, p0, Lio/dcloud/p/p1;->c:Lio/dcloud/js/geolocation/GeoManagerBase;

    if-eqz v0, :cond_2

    .line 65
    invoke-virtual {v0}, Lio/dcloud/js/geolocation/GeoManagerBase;->onDestroy()V

    :cond_2
    return-void
.end method
