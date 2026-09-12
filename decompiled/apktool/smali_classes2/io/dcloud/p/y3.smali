.class public abstract Lio/dcloud/p/y3;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private a:Z


# direct methods
.method public static synthetic $r8$lambda$7tPXqAyCTWYk-AX-lg3ZvXYl0bA(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;FLjava/lang/String;I)V
    .locals 0

    invoke-static {p0, p1, p2, p3, p4}, Lio/dcloud/p/y3;->a(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;FLjava/lang/String;I)V

    return-void
.end method

.method public static synthetic $r8$lambda$MEHgfzLNWVcP1NbXop67R5l2R24(Lio/dcloud/p/y3;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lio/dcloud/p/y3;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    return-void
.end method

.method public static synthetic $r8$lambda$QLf9gndDzvwkibxOLWq3Vg5uamw(Landroid/content/Context;Lio/dcloud/sdk/core/module/DCBaseAOL;ILjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-static/range {p0 .. p7}, Lio/dcloud/p/y3;->a(Landroid/content/Context;Lio/dcloud/sdk/core/module/DCBaseAOL;ILjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 3
    iput-boolean v0, p0, Lio/dcloud/p/y3;->a:Z

    return-void
.end method

.method private static synthetic a(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;FLjava/lang/String;I)V
    .locals 11

    .line 114
    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAppId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getDCloudId()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAdId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->n()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object v6

    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-static {p2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object p2

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object p2, v1, v7

    const-string p2, "%f"

    invoke-static {v0, p2, v1}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->q()Ljava/lang/String;

    move-result-object v10

    move-object v1, p0

    move-object v8, p3

    move v9, p4

    invoke-static/range {v1 .. v10}, Lio/dcloud/p/c0;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    return-void
.end method

.method private a(Landroid/content/Context;ILio/dcloud/sdk/core/module/DCBaseAOL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 10

    const/16 v0, 0x28

    if-ne p2, v0, :cond_0

    .line 93
    invoke-virtual {p3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getDCloudId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-static {p1, v0, v1}, Lio/dcloud/p/m;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    :cond_0
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 96
    invoke-virtual {p3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->p()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 97
    invoke-virtual {p3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->p()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ext"

    invoke-virtual {v5, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    :cond_1
    invoke-static {}, Lio/dcloud/p/x4;->a()Lio/dcloud/p/x4;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/y3$$ExternalSyntheticLambda2;

    move-object v2, p1

    move v4, p2

    move-object v3, p3

    move-object v6, p4

    move-object v7, p5

    move-object/from16 v8, p6

    move-object/from16 v9, p7

    invoke-direct/range {v1 .. v9}, Lio/dcloud/p/y3$$ExternalSyntheticLambda2;-><init>(Landroid/content/Context;Lio/dcloud/sdk/core/module/DCBaseAOL;ILjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lio/dcloud/p/x4;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method private static synthetic a(Landroid/content/Context;Lio/dcloud/sdk/core/module/DCBaseAOL;ILjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 13

    .line 100
    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->n()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getTid()Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAppId()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAdId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getDCloudId()Ljava/lang/String;

    move-result-object v7

    move-object v0, p0

    move v6, p2

    move-object/from16 v8, p3

    move-object/from16 v9, p4

    move-object/from16 v10, p5

    move-object/from16 v11, p6

    move-object/from16 v12, p7

    invoke-static/range {v0 .. v12}, Lio/dcloud/p/c0;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private synthetic a(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 6

    .line 92
    invoke-virtual {p0}, Lio/dcloud/p/y3;->a()Landroid/app/Activity;

    move-result-object v0

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v1

    invoke-virtual {v1}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v1

    invoke-virtual {v1}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object v2

    invoke-virtual {v2}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object v2

    invoke-virtual {v2}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAdId()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x3c

    move-object v4, p1

    move-object v5, p2

    invoke-static/range {v0 .. v5}, Lio/dcloud/p/c0;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;)V

    return-void
.end method


# virtual methods
.method protected abstract a()Landroid/app/Activity;
.end method

.method protected a(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;J)V
    .locals 2

    if-eqz p5, :cond_8

    .line 1
    invoke-virtual {p5}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_1

    :cond_0
    const/16 v0, 0xe

    if-ne p1, v0, :cond_1

    goto/16 :goto_1

    :cond_1
    const/4 v0, 0x1

    .line 8
    iput-boolean v0, p0, Lio/dcloud/p/y3;->a:Z

    .line 9
    invoke-virtual {p0}, Lio/dcloud/p/y3;->b()Z

    move-result v1

    if-eqz v1, :cond_8

    .line 10
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    if-eq p1, v0, :cond_6

    const/4 v0, 0x7

    if-eq p1, v0, :cond_5

    const/16 v0, 0xf

    if-eq p1, v0, :cond_4

    const/4 v0, 0x4

    if-eq p1, v0, :cond_3

    const/4 v0, 0x5

    if-eq p1, v0, :cond_2

    packed-switch p1, :pswitch_data_0

    .line 11
    const-string p1, ""

    goto :goto_0

    .line 35
    :pswitch_0
    const-string p1, "drama"

    goto :goto_0

    .line 36
    :pswitch_1
    const-string p1, "draw_flow"

    goto :goto_0

    .line 45
    :pswitch_2
    const-string p1, "rewarded"

    goto :goto_0

    .line 54
    :cond_2
    const-string p1, "video_paste"

    goto :goto_0

    .line 55
    :cond_3
    const-string p1, "template"

    goto :goto_0

    .line 64
    :cond_4
    const-string p1, "interstitial"

    goto :goto_0

    .line 65
    :cond_5
    const-string p1, "full_screen_video"

    goto :goto_0

    .line 74
    :cond_6
    const-string p1, "splash"

    .line 83
    :goto_0
    const-string v0, "type"

    invoke-virtual {v1, v0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    const-string p1, "adpid"

    invoke-virtual {v1, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    const-string p1, "ord"

    invoke-virtual {v1, p1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_7

    .line 87
    const-string p1, "ext"

    invoke-virtual {v1, p1, p4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    :cond_7
    const-string p1, "rsp"

    invoke-virtual {v1, p1, p5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/16 p1, 0x3c

    .line 89
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    const-string p3, "tid"

    invoke-virtual {v1, p3, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    invoke-static {p6, p7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object p1

    const-string p3, "lt"

    invoke-virtual {v1, p3, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    invoke-static {}, Lio/dcloud/p/x4;->a()Lio/dcloud/p/x4;

    move-result-object p1

    new-instance p3, Lio/dcloud/p/y3$$ExternalSyntheticLambda1;

    invoke-direct {p3, p0, p2, v1}, Lio/dcloud/p/y3$$ExternalSyntheticLambda1;-><init>(Lio/dcloud/p/y3;Ljava/lang/String;Ljava/util/HashMap;)V

    invoke-virtual {p1, p3}, Lio/dcloud/p/x4;->a(Ljava/lang/Runnable;)V

    :cond_8
    :goto_1
    return-void

    :pswitch_data_0
    .packed-switch 0x9
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method protected a(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;)V
    .locals 8

    .line 101
    const-string v0, "on ad click"

    invoke-static {v0}, Lio/dcloud/p/c3;->a(Ljava/lang/String;)V

    if-nez p2, :cond_0

    return-void

    .line 104
    :cond_0
    invoke-virtual {p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSubAd()Lio/dcloud/sdk/core/module/DCBaseAOL;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 105
    invoke-virtual {p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSubAd()Lio/dcloud/sdk/core/module/DCBaseAOL;

    move-result-object p2

    :cond_1
    move-object v3, p2

    .line 107
    invoke-static {v3}, Lio/dcloud/p/m;->b(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v3}, Lio/dcloud/p/m;->a(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v7

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/16 v2, 0x29

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lio/dcloud/p/y3;->a(Landroid/content/Context;ILio/dcloud/sdk/core/module/DCBaseAOL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected a(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;JLjava/lang/String;I)V
    .locals 6

    if-nez p2, :cond_0

    goto :goto_0

    .line 108
    :cond_0
    invoke-virtual {p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "gg"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :goto_0
    return-void

    :cond_1
    long-to-float p3, p3

    const p4, 0x49742400    # 1000000.0f

    div-float v3, p3, p4

    .line 112
    const-string p3, "on ad paid"

    invoke-static {p3}, Lio/dcloud/p/c3;->a(Ljava/lang/String;)V

    .line 113
    invoke-static {}, Lio/dcloud/p/x4;->a()Lio/dcloud/p/x4;

    move-result-object p3

    new-instance v0, Lio/dcloud/p/y3$$ExternalSyntheticLambda0;

    move-object v1, p1

    move-object v2, p2

    move-object v4, p5

    move v5, p6

    invoke-direct/range {v0 .. v5}, Lio/dcloud/p/y3$$ExternalSyntheticLambda0;-><init>(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;FLjava/lang/String;I)V

    invoke-virtual {p3, v0}, Lio/dcloud/p/x4;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method protected b(Landroid/app/Activity;Lio/dcloud/sdk/core/module/DCBaseAOL;)V
    .locals 8

    .line 1
    const-string v0, "on ad show"

    invoke-static {v0}, Lio/dcloud/p/c3;->a(Ljava/lang/String;)V

    if-nez p2, :cond_0

    return-void

    .line 4
    :cond_0
    invoke-virtual {p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSubAd()Lio/dcloud/sdk/core/module/DCBaseAOL;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 5
    invoke-virtual {p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSubAd()Lio/dcloud/sdk/core/module/DCBaseAOL;

    move-result-object p2

    :cond_1
    move-object v3, p2

    .line 7
    invoke-virtual {v3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->q()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getBiddingECPM()I

    move-result p2

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v3}, Lio/dcloud/p/m;->b(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v3}, Lio/dcloud/p/m;->a(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v7

    const/16 v2, 0x28

    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v7}, Lio/dcloud/p/y3;->a(Landroid/content/Context;ILio/dcloud/sdk/core/module/DCBaseAOL;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected abstract b()Z
.end method
