.class public Lio/dcloud/p/u0;
.super Lio/dcloud/sdk/core/module/DCBaseAOLLoader;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/p/v2$c;


# instance fields
.field private K:Lio/dcloud/p/w4;

.field private L:Lio/dcloud/sdk/poly/api/Platform;

.field private M:Ljava/lang/String;

.field private N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

.field private O:Landroid/os/Handler;

.field private P:I


# direct methods
.method public static synthetic $r8$lambda$2z64XyoHODWLFMG1dSxnuPoDAno(Lio/dcloud/p/u0;Landroid/view/ViewGroup;)V
    .locals 0

    invoke-direct {p0, p1}, Lio/dcloud/p/u0;->a(Landroid/view/ViewGroup;)V

    return-void
.end method

.method public static synthetic $r8$lambda$TmdwBdGVywYiZQ1-qnv7MZK8Ikg(Lio/dcloud/p/u0;)V
    .locals 0

    invoke-direct {p0}, Lio/dcloud/p/u0;->z()V

    return-void
.end method

.method public static synthetic $r8$lambda$acbI7txrv_rf6FFLHxpagbVnY7w(Lio/dcloud/p/u0;Landroid/view/ViewGroup;)V
    .locals 0

    invoke-direct {p0, p1}, Lio/dcloud/p/u0;->b(Landroid/view/ViewGroup;)V

    return-void
.end method

.method public constructor <init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;-><init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V

    .line 2
    const-string p1, ""

    iput-object p1, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    .line 4
    new-instance p1, Lio/dcloud/p/u0$a;

    .line 5
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object p2

    invoke-direct {p1, p0, p2}, Lio/dcloud/p/u0$a;-><init>(Lio/dcloud/p/u0;Landroid/os/Looper;)V

    iput-object p1, p0, Lio/dcloud/p/u0;->O:Landroid/os/Handler;

    const/16 p1, 0x1388

    .line 12
    iput p1, p0, Lio/dcloud/p/u0;->P:I

    return-void
.end method

.method static synthetic a(Lio/dcloud/p/u0;)Lio/dcloud/sdk/base/dcloud/ADHandler$e;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    return-object p0
.end method

.method static synthetic a(Lio/dcloud/p/u0;Lio/dcloud/sdk/base/dcloud/ADHandler$e;)Lio/dcloud/sdk/base/dcloud/ADHandler$e;
    .locals 0

    .line 2
    iput-object p1, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    return-object p1
.end method

.method private synthetic a(Landroid/view/ViewGroup;)V
    .locals 0

    .line 3
    invoke-direct {p0, p1}, Lio/dcloud/p/u0;->c(Landroid/view/ViewGroup;)V

    return-void
.end method

.method private synthetic b(Landroid/view/ViewGroup;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/u0;->K:Lio/dcloud/p/w4;

    invoke-virtual {v0, p1}, Lio/dcloud/p/v2;->a(Landroid/view/ViewGroup;)V

    return-void
.end method

.method private c(Landroid/view/ViewGroup;)V
    .locals 4

    .line 1
    new-instance v0, Lio/dcloud/sdk/base/dcloud/g;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    new-instance v3, Lio/dcloud/p/u0$b;

    invoke-direct {v3, p0}, Lio/dcloud/p/u0$b;-><init>(Lio/dcloud/p/u0;)V

    invoke-direct {v0, v1, v2, p1, v3}, Lio/dcloud/sdk/base/dcloud/g;-><init>(Landroid/content/Context;Lio/dcloud/sdk/base/dcloud/ADHandler$e;Landroid/view/ViewGroup;Lio/dcloud/p/n;)V

    .line 27
    invoke-virtual {v0}, Lio/dcloud/sdk/base/dcloud/g;->b()V

    return-void
.end method

.method private synthetic z()V
    .locals 6

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getSplash()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getEr()Ljava/lang/String;

    move-result-object v4

    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getEc()Ljava/lang/String;

    move-result-object v5

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lio/dcloud/p/s0;->a(Lio/dcloud/p/v2$c;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/p/w4;

    move-result-object v1

    iput-object v1, v0, Lio/dcloud/p/u0;->K:Lio/dcloud/p/w4;

    .line 2
    invoke-virtual {v1}, Lio/dcloud/p/w4;->c()V

    return-void
.end method


# virtual methods
.method public a(ILjava/lang/String;)V
    .locals 3

    .line 4
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 5
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "code"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ";message:"

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const/16 p2, -0x13ec

    invoke-interface {v0, p2, p1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public a(Lorg/json/JSONArray;Z)V
    .locals 8

    .line 6
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "::::::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "uniAd-finish"

    invoke-static {v1, v0}, Lio/dcloud/p/c3;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 7
    iget-object v0, p0, Lio/dcloud/p/u0;->O:Landroid/os/Handler;

    iget v1, p0, Lio/dcloud/p/u0;->P:I

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 8
    iget-object v0, p0, Lio/dcloud/p/u0;->O:Landroid/os/Handler;

    iget v1, p0, Lio/dcloud/p/u0;->P:I

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    const-string v0, ""

    const/16 v1, -0x270f

    if-eqz p2, :cond_5

    if-eqz p1, :cond_3

    .line 12
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result p2

    if-nez p2, :cond_0

    goto :goto_1

    .line 22
    :cond_0
    new-instance p2, Lio/dcloud/p/u0$c;

    invoke-direct {p2, p0}, Lio/dcloud/p/u0$c;-><init>(Lio/dcloud/p/u0;)V

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 55
    :goto_0
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v5

    if-ge v4, v5, :cond_2

    .line 56
    invoke-virtual {p1, v4}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 58
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v3, v5, v6, v7, p2}, Lio/dcloud/sdk/base/dcloud/ADHandler;->a(Landroid/content/Context;Lorg/json/JSONObject;JLio/dcloud/sdk/base/dcloud/ADHandler$g;)V

    const/4 v3, 0x0

    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_2
    if-eqz v3, :cond_6

    .line 64
    invoke-virtual {p0, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 65
    :cond_3
    :goto_1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getActivity()Landroid/app/Activity;

    move-result-object p1

    invoke-static {}, Lio/dcloud/p/r0;->d()Lio/dcloud/p/r0;

    move-result-object p2

    invoke-virtual {p2}, Lio/dcloud/p/r0;->b()Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;

    move-result-object p2

    invoke-virtual {p2}, Lio/dcloud/sdk/core/DCloudAOLManager$InitConfig;->getAppId()Ljava/lang/String;

    move-result-object p2

    invoke-static {p1, p2}, Lio/dcloud/sdk/base/dcloud/ADHandler;->b(Landroid/content/Context;Ljava/lang/String;)Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    move-result-object p1

    .line 66
    invoke-virtual {p1}, Lio/dcloud/sdk/base/dcloud/ADHandler$e;->a()Z

    move-result p2

    if-eqz p2, :cond_4

    .line 67
    iput-object p1, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    .line 68
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getDCloudId()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Lio/dcloud/sdk/base/dcloud/ADHandler$e;->a(Ljava/lang/String;)V

    .line 69
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadSuccess()V

    return-void

    .line 71
    :cond_4
    invoke-virtual {p0, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 120
    :cond_5
    invoke-virtual {p0, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    :cond_6
    return-void
.end method

.method public destroy()V
    .locals 0

    return-void
.end method

.method public getTid()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    if-nez v0, :cond_1

    iget-object v0, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lio/dcloud/sdk/base/dcloud/ADHandler$e;->l:Ljava/lang/String;

    return-object v0

    :cond_0
    const-string v0, ""

    return-object v0

    :cond_1
    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getTid()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    if-nez v0, :cond_0

    iget-object v0, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    return-object v0

    :cond_0
    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getType()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public init(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public isValid()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method public k()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onClose()V

    :cond_0
    return-void
.end method

.method public l()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onSkip()V

    :cond_0
    return-void
.end method

.method public load(Ljava/util/Map;)V
    .locals 3

    .line 1
    iget-object p1, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    const-string v0, ""

    const/16 v1, -0x270f

    if-eqz p1, :cond_0

    .line 2
    invoke-virtual {p0, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 5
    :cond_0
    iget-object p1, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    const-string v2, "dcloud"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 6
    const-string p1, "uniAd"

    const-string v0, "load base"

    invoke-static {p1, v0}, Lio/dcloud/p/c3;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 7
    iget-object p1, p0, Lio/dcloud/p/u0;->O:Landroid/os/Handler;

    iget v0, p0, Lio/dcloud/p/u0;->P:I

    const-wide/16 v1, 0x1388

    invoke-virtual {p1, v0, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    return-void

    .line 9
    :cond_1
    iget-object p1, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    if-nez p1, :cond_2

    .line 10
    invoke-virtual {p0, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void

    .line 14
    :cond_2
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object p1

    new-instance v0, Lio/dcloud/p/u0$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Lio/dcloud/p/u0$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/p/u0;)V

    invoke-virtual {p1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public m()V
    .locals 0

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadSuccess()V

    return-void
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    if-nez v0, :cond_0

    const-string v0, ""

    return-object v0

    :cond_0
    invoke-virtual {v0}, Lio/dcloud/sdk/poly/api/Platform;->getAppid()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public onAdClicked()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onClick()V

    :cond_0
    return-void
.end method

.method public onAdShow()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShow()V

    :cond_0
    return-void
.end method

.method public onError(ILjava/lang/String;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->loadFail(ILjava/lang/String;)V

    return-void
.end method

.method public runOnMain()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public setPlatform(Lio/dcloud/sdk/poly/api/Platform;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/u0;->L:Lio/dcloud/sdk/poly/api/Platform;

    .line 2
    iput-object p2, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    return-void
.end method

.method public showIn(Landroid/view/ViewGroup;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/u0;->K:Lio/dcloud/p/w4;

    if-nez v0, :cond_0

    iget-object v0, p0, Lio/dcloud/p/u0;->N:Lio/dcloud/sdk/base/dcloud/ADHandler$e;

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2
    :cond_1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    if-eqz p1, :cond_3

    .line 3
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    const/16 v0, -0x1390

    invoke-static {v0}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    return-void

    :cond_2
    if-nez p1, :cond_4

    .line 7
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    if-eqz p1, :cond_3

    .line 8
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    move-result-object p1

    const/16 v0, -0x1396

    invoke-static {v0}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;->onShowError(ILjava/lang/String;)V

    :cond_3
    return-void

    .line 11
    :cond_4
    iget-object v0, p0, Lio/dcloud/p/u0;->M:Ljava/lang/String;

    const-string v1, "dcloud"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 12
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_5

    .line 13
    invoke-direct {p0, p1}, Lio/dcloud/p/u0;->c(Landroid/view/ViewGroup;)V

    return-void

    .line 15
    :cond_5
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/u0$$ExternalSyntheticLambda1;

    invoke-direct {v1, p0, p1}, Lio/dcloud/p/u0$$ExternalSyntheticLambda1;-><init>(Lio/dcloud/p/u0;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void

    .line 19
    :cond_6
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_7

    .line 20
    iget-object v0, p0, Lio/dcloud/p/u0;->K:Lio/dcloud/p/w4;

    invoke-virtual {v0, p1}, Lio/dcloud/p/v2;->a(Landroid/view/ViewGroup;)V

    return-void

    .line 22
    :cond_7
    invoke-static {}, Lio/dcloud/sdk/core/util/MainHandlerUtil;->getMainHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lio/dcloud/p/u0$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0, p1}, Lio/dcloud/p/u0$$ExternalSyntheticLambda2;-><init>(Lio/dcloud/p/u0;Landroid/view/ViewGroup;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
