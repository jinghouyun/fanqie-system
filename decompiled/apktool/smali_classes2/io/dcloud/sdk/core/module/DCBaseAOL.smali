.class public abstract Lio/dcloud/sdk/core/module/DCBaseAOL;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final a:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

.field private final b:Landroid/app/Activity;

.field private c:I

.field protected d:I

.field protected e:I

.field private f:Z

.field protected g:I

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:I

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:I

.field private p:Z

.field private q:Lorg/json/JSONObject;

.field private r:I

.field protected s:Ljava/lang/String;

.field private t:I

.field private u:Z

.field protected v:Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

.field protected w:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

.field private x:Lio/dcloud/sdk/core/module/DCBaseAOL;

.field private y:Ljava/util/Map;


# direct methods
.method public constructor <init>(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Landroid/app/Activity;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    .line 2
    iput v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->c:I

    .line 3
    iput v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->d:I

    .line 4
    iput v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->e:I

    const/4 v0, 0x0

    .line 5
    iput-boolean v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->f:Z

    const/4 v0, 0x1

    .line 21
    iput v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->t:I

    .line 23
    iput-boolean v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->u:Z

    .line 33
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->y:Ljava/util/Map;

    .line 36
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->a:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    .line 37
    iput-object p2, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->b:Landroid/app/Activity;

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 0

    .line 3
    iput p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->r:I

    return-void
.end method

.method public a(Lio/dcloud/sdk/core/interfaces/AOLLoader$GetConvertResultListener;)V
    .locals 2

    if-eqz p1, :cond_0

    .line 4
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "type:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ";code:-1;message:\u6682\u65e0\u7f13\u5b58\u4efb\u52a1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, -0x13ec

    invoke-interface {p1, v1, v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$GetConvertResultListener;->onError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public a(Lio/dcloud/sdk/core/interfaces/AOLLoader$RequestConvertResultListener;)V
    .locals 2

    if-eqz p1, :cond_0

    .line 5
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "type:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ";code:-1;message:\u6682\u65e0\u7f13\u5b58\u4efb\u52a1"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, -0x13ec

    invoke-interface {p1, v1, v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$RequestConvertResultListener;->onError(ILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public a(Lorg/json/JSONObject;)V
    .locals 0

    .line 2
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->q:Lorg/json/JSONObject;

    return-void
.end method

.method public a(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->p:Z

    return-void
.end method

.method public b(I)V
    .locals 0

    .line 3
    iput p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->t:I

    return-void
.end method

.method public final b(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->i:Ljava/lang/String;

    return-void
.end method

.method public b(Z)V
    .locals 0

    .line 2
    iput-boolean p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->f:Z

    return-void
.end method

.method public biddingFail(III)V
    .locals 1

    .line 1
    new-instance p3, Ljava/lang/StringBuilder;

    const-string v0, "bidding fail:"

    invoke-direct {p3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ",Win:"

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ",second:"

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ",slot:"

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, "uniAd"

    invoke-static {p2, p1}, Lio/dcloud/p/c3;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public biddingSuccess(II)V
    .locals 2

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "bidding success:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ",Win:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ",second:"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ",slot:"

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, "uniAd"

    invoke-static {p2, p1}, Lio/dcloud/p/c3;->b(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public c(I)V
    .locals 0

    .line 2
    iput p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->o:I

    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->j:Ljava/lang/String;

    return-void
.end method

.method public d(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->k:Ljava/lang/String;

    return-void
.end method

.method public abstract destroy()V
.end method

.method public e(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->m:Ljava/lang/String;

    return-void
.end method

.method public f(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->n:Ljava/lang/String;

    return-void
.end method

.method public final g(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->h:Ljava/lang/String;

    return-void
.end method

.method public getAcpt()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->r:I

    return v0
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->b:Landroid/app/Activity;

    return-object v0
.end method

.method public getAdStatus()I
    .locals 1

    const/4 v0, -0x1

    return v0
.end method

.method public getAdType()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->g:I

    return v0
.end method

.method public getBiddingECPM()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->c:I

    return v0
.end method

.method public getDCloudId()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->a:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getAdpid()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExpressAdView(Landroid/app/Activity;)Landroid/view/View;
    .locals 0

    const/4 p1, 0x0

    return-object p1
.end method

.method public getExtraData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->y:Ljava/util/Map;

    return-object v0
.end method

.method public getFeedAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->w:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    return-object v0
.end method

.method public getFeedType()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->l:I

    return v0
.end method

.method public getIntersType()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->t:I

    return v0
.end method

.method public getMiniRequestType()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->m:Ljava/lang/String;

    return-object v0
.end method

.method public getMiniType()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->o:I

    return v0
.end method

.method public getNativeAdInfo()Landroid/util/SparseArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroid/util/SparseArray<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    const/4 v0, 0x0

    return-object v0
.end method

.method public getParams()Lorg/json/JSONObject;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->q:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getPath()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->n:Ljava/lang/String;

    return-object v0
.end method

.method public getSlot()Lio/dcloud/sdk/core/entry/DCloudAOLSlot;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->a:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    return-object v0
.end method

.method public getSlotId()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->h:Ljava/lang/String;

    return-object v0
.end method

.method public getSubAd()Lio/dcloud/sdk/core/module/DCBaseAOL;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->x:Lio/dcloud/sdk/core/module/DCBaseAOL;

    return-object v0
.end method

.method public getTid()Ljava/lang/String;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getAdType()I

    move-result v1

    invoke-static {v0, v1}, Lio/dcloud/sdk/core/util/TidUtil;->getTid(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->s:Ljava/lang/String;

    return-object v0
.end method

.method public getVideoAdCallback()Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->v:Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    return-object v0
.end method

.method public isEnd()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->p:Z

    return v0
.end method

.method public isExpressAd()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->u:Z

    return v0
.end method

.method public isSlotSupportBidding()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->f:Z

    return v0
.end method

.method public abstract isValid()Z
.end method

.method public n()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->i:Ljava/lang/String;

    return-object v0
.end method

.method protected o()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->j:Ljava/lang/String;

    return-object v0
.end method

.method public p()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->a:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    invoke-virtual {v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->getEI()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public q()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->k:Ljava/lang/String;

    return-object v0
.end method

.method public r()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->d:I

    return v0
.end method

.method public render()V
    .locals 0

    return-void
.end method

.method public s()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final setBiddingECPM(I)V
    .locals 2

    if-lez p1, :cond_0

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, " current cpm:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/p/c3;->c(Ljava/lang/String;)V

    .line 2
    iput p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->c:I

    :cond_0
    return-void
.end method

.method public setExpressAd(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->u:Z

    return-void
.end method

.method public final setFeedAdCallback(Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->w:Lio/dcloud/sdk/core/interfaces/AOLLoader$FeedAOLInteractionListener;

    return-void
.end method

.method public setFeedType(I)V
    .locals 0

    .line 1
    iput p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->l:I

    return-void
.end method

.method public setSubAd(Lio/dcloud/sdk/core/module/DCBaseAOL;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->x:Lio/dcloud/sdk/core/module/DCBaseAOL;

    return-void
.end method

.method public final setVideoAdCallback(Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOL;->v:Lio/dcloud/sdk/core/interfaces/AOLLoader$VAOLInteractionListener;

    return-void
.end method

.method public startLoadTime()V
    .locals 0

    return-void
.end method
