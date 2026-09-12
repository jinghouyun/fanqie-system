.class public Lio/dcloud/js/geolocation/system/LocalGeoManager;
.super Lio/dcloud/js/geolocation/GeoManagerBase;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field public static final TAG:Ljava/lang/String; = "LocalGeoManager"


# instance fields
.field private a:Lio/dcloud/js/geolocation/system/a;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/js/geolocation/GeoManagerBase;-><init>(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic a(Lio/dcloud/js/geolocation/system/LocalGeoManager;)Lio/dcloud/js/geolocation/system/a;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    return-object p0
.end method


# virtual methods
.method a()Lio/dcloud/js/geolocation/system/a;
    .locals 3

    .line 2
    iget-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    if-nez v0, :cond_0

    .line 3
    new-instance v0, Lio/dcloud/js/geolocation/system/a;

    iget-object v1, p0, Lio/dcloud/js/geolocation/GeoManagerBase;->mContext:Landroid/content/Context;

    const-string v2, ""

    invoke-direct {v0, v1, v2}, Lio/dcloud/js/geolocation/system/a;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    .line 5
    :cond_0
    iget-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    return-object v0
.end method

.method public execute(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    .locals 21

    move-object/from16 v0, p2

    move-object/from16 v1, p3

    .line 1
    const-string v7, ""

    .line 3
    :try_start_0
    const-string v2, "getCurrentPosition"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    const-string v3, "only support wgs84"

    const/16 v4, 0x11

    const-string v5, "{code:%d,message:\'%s\'}"

    const-string v6, "wgs84"

    const/4 v8, 0x6

    const/4 v9, 0x7

    const/4 v10, 0x3

    const/4 v11, 0x2

    const-string v12, "null"

    const/4 v13, 0x1

    const/4 v14, 0x0

    if-eqz v2, :cond_4

    .line 5
    :try_start_1
    aget-object v0, v1, v13

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 6
    aget-object v2, v1, v11

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 14
    array-length v15, v1

    if-le v15, v9, :cond_0

    aget-object v8, v1, v8

    goto :goto_0

    :cond_0
    move-object v8, v12

    .line 16
    :goto_0
    invoke-virtual {v12, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 17
    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    goto :goto_1

    :cond_1
    const/16 v8, 0x7530

    .line 19
    :goto_1
    aget-object v9, v1, v10

    invoke-static {v9, v6}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    aget-object v6, v1, v10

    invoke-static {v6}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    goto :goto_2

    .line 23
    :cond_2
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-array v2, v11, [Ljava/lang/Object;

    aput-object v0, v2, v14

    aput-object v3, v2, v13

    invoke-static {v5, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .line 24
    aget-object v16, v1, v14

    sget v18, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/16 v19, 0x1

    const/16 v20, 0x0

    move-object/from16 v15, p1

    invoke-static/range {v15 .. v20}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v7

    :cond_3
    :goto_2
    move v4, v2

    .line 25
    aget-object v2, v1, v14
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    move-object/from16 v1, p1

    move v3, v0

    move v5, v8

    move-object/from16 v0, p0

    :try_start_2
    invoke-virtual/range {v0 .. v5}, Lio/dcloud/js/geolocation/system/LocalGeoManager;->getCurrentLocation(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;ZII)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    move-object v2, v0

    return-object v7

    :catch_0
    move-object v6, v0

    goto/16 :goto_9

    :cond_4
    move-object/from16 v2, p0

    .line 31
    :try_start_3
    const-string v15, "watchPosition"

    invoke-virtual {v0, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-eqz v15, :cond_d

    .line 32
    aget-object v0, v1, v11

    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 33
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v15

    const/16 v16, 0x11

    new-instance v4, Lio/dcloud/js/geolocation/system/LocalGeoManager$a;

    invoke-direct {v4, v2}, Lio/dcloud/js/geolocation/system/LocalGeoManager$a;-><init>(Lio/dcloud/js/geolocation/system/LocalGeoManager;)V

    invoke-interface {v15, v4}, Lio/dcloud/common/DHInterface/IFrameViewStatus;->addFrameViewListener(Lio/dcloud/common/DHInterface/IEventCallback;)V

    .line 43
    aget-object v4, v1, v10

    invoke-static {v4, v6}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_6

    aget-object v4, v1, v10

    invoke-static {v4}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    goto :goto_3

    :cond_5
    const/4 v4, 0x0

    goto :goto_4

    :cond_6
    :goto_3
    const/4 v4, 0x1

    .line 44
    :goto_4
    array-length v6, v1

    if-le v6, v9, :cond_7

    aget-object v6, v1, v8

    goto :goto_5

    :cond_7
    move-object v6, v12

    .line 47
    :goto_5
    invoke-virtual {v12, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_8

    .line 48
    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    goto :goto_6

    :cond_8
    const v6, 0x7fffffff

    .line 50
    :goto_6
    array-length v8, v1

    const/16 v10, 0x8

    if-le v8, v10, :cond_9

    aget-object v8, v1, v9

    goto :goto_7

    .line 51
    :cond_9
    const-string v8, "5000"

    .line 53
    :goto_7
    invoke-virtual {v8, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_a

    .line 54
    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_8

    :cond_a
    const/16 v8, 0x1388

    :goto_8
    const/16 v9, 0x3e8

    if-ge v8, v9, :cond_b

    const/16 v8, 0x3e8

    :cond_b
    if-eqz v4, :cond_c

    .line 60
    :try_start_4
    aget-object v2, v1, v14

    aget-object v3, v1, v13
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    move-object/from16 v1, p1

    move v4, v0

    move v5, v6

    move v6, v8

    move-object/from16 v0, p0

    :try_start_5
    invoke-virtual/range {v0 .. v6}, Lio/dcloud/js/geolocation/system/LocalGeoManager;->start(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ZII)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    move-object v6, v0

    return-object v7

    :cond_c
    move-object v6, v2

    .line 62
    :try_start_6
    invoke-static/range {v16 .. v16}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    new-array v2, v11, [Ljava/lang/Object;

    aput-object v0, v2, v14

    aput-object v3, v2, v13

    invoke-static {v5, v2}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 63
    aget-object v1, v1, v14

    sget v3, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v4, 0x1

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-static/range {v0 .. v5}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v7

    :cond_d
    move-object v6, v2

    .line 66
    const-string v2, "clearWatch"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 67
    aget-object v0, v1, v14

    invoke-virtual {v6, v0}, Lio/dcloud/js/geolocation/system/LocalGeoManager;->stop(Ljava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    return-object v7

    :catch_1
    move-object v6, v2

    goto :goto_9

    :catch_2
    move-object/from16 v6, p0

    :catch_3
    :cond_e
    :goto_9
    return-object v7
.end method

.method public getCurrentLocation(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;ZII)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a()Lio/dcloud/js/geolocation/system/a;

    move-result-object p3

    invoke-virtual {p3, p1, p4, p2, p5}, Lio/dcloud/js/geolocation/system/a;->a(Lio/dcloud/common/DHInterface/IWebview;ILjava/lang/String;I)V

    return-void
.end method

.method public onDestroy()V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {v0}, Lio/dcloud/js/geolocation/system/a;->a()V

    :cond_0
    const/4 v0, 0x0

    .line 4
    iput-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    return-void
.end method

.method public start(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;ZII)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a()Lio/dcloud/js/geolocation/system/a;

    move-result-object p4

    invoke-virtual {p4, p1, p6, p2, p5}, Lio/dcloud/js/geolocation/system/a;->b(Lio/dcloud/common/DHInterface/IWebview;ILjava/lang/String;I)Z

    move-result p1

    if-eqz p1, :cond_0

    .line 2
    iget-object p1, p0, Lio/dcloud/js/geolocation/GeoManagerBase;->keySet:Ljava/util/ArrayList;

    invoke-virtual {p1, p3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_0
    return-void
.end method

.method public stop(Ljava/lang/String;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/dcloud/js/geolocation/GeoManagerBase;->keySet:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/js/geolocation/GeoManagerBase;->keySet:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 3
    iget-object p1, p0, Lio/dcloud/js/geolocation/system/LocalGeoManager;->a:Lio/dcloud/js/geolocation/system/a;

    sget v0, Lio/dcloud/js/geolocation/system/a;->u:I

    invoke-virtual {p1, v0}, Lio/dcloud/js/geolocation/system/a;->c(I)V

    :cond_0
    return-void
.end method
