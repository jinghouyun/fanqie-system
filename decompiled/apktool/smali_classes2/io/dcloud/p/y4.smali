.class public Lio/dcloud/p/y4;
.super Lio/dcloud/p/b5;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/p/w$a;
.implements Lio/dcloud/sdk/core/interfaces/IToggle;


# instance fields
.field private A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

.field private B:Z

.field private x:Lio/dcloud/p/n1;

.field protected y:Z

.field private z:Ljava/util/List;


# direct methods
.method public constructor <init>(Landroid/app/Activity;I)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lio/dcloud/p/b5;-><init>(Landroid/app/Activity;I)V

    const/4 p1, 0x0

    .line 56
    iput-boolean p1, p0, Lio/dcloud/p/y4;->y:Z

    const/4 p2, 0x0

    .line 60
    iput-object p2, p0, Lio/dcloud/p/y4;->z:Ljava/util/List;

    .line 136
    iput-boolean p1, p0, Lio/dcloud/p/y4;->B:Z

    return-void
.end method

.method private a(Lio/dcloud/sdk/core/adapter/IAdAdapter;Lio/dcloud/p/v4;)V
    .locals 2

    const/4 v0, 0x1

    .line 5
    iput-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    .line 6
    invoke-virtual {p0}, Lio/dcloud/p/w;->a()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lio/dcloud/p/i4;->b:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/adapter/IAdAdapter;->getAd(Landroid/app/Activity;Lio/dcloud/sdk/core/entry/DCloudAOLSlot;)Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    move-result-object p1

    .line 7
    invoke-static {}, Lio/dcloud/p/b0;->a()Lio/dcloud/p/b0;

    move-result-object v0

    const-string v1, "gm"

    invoke-virtual {v0, v1}, Lio/dcloud/p/b0;->a(Ljava/lang/String;)Lio/dcloud/p/a0;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 9
    invoke-virtual {v0}, Lio/dcloud/p/a0;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lio/dcloud/p/a0;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 11
    :cond_0
    invoke-virtual {p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->a(Lio/dcloud/p/v4;)V

    .line 12
    invoke-virtual {p1, p0}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->a(Lio/dcloud/p/w$a;)V

    .line 13
    iget-object p2, p0, Lio/dcloud/p/w;->n:Ljava/lang/String;

    invoke-virtual {p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->d(Ljava/lang/String;)V

    .line 14
    iget-object p2, p0, Lio/dcloud/p/i4;->b:Lio/dcloud/sdk/core/entry/DCloudAOLSlot;

    iget-object v0, p0, Lio/dcloud/p/w;->n:Ljava/lang/String;

    invoke-virtual {p2, v0}, Lio/dcloud/sdk/core/entry/DCloudAOLSlot;->setRID(Ljava/lang/String;)V

    .line 15
    new-instance p2, Lio/dcloud/p/y4$a;

    invoke-direct {p2, p0}, Lio/dcloud/p/y4$a;-><init>(Lio/dcloud/p/y4;)V

    invoke-virtual {p1, p2}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->b(Ljava/util/Map;)V

    return-void
.end method

.method private b(Lio/dcloud/p/t0;)Lio/dcloud/p/v4;
    .locals 3

    .line 1
    invoke-virtual {p1}, Lio/dcloud/p/t0;->d()Ljava/util/List;

    move-result-object p1

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    .line 2
    :cond_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lio/dcloud/p/v4;

    .line 4
    invoke-virtual {v0}, Lio/dcloud/p/v4;->l()Ljava/lang/String;

    move-result-object v1

    const-string v2, "gm"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lio/dcloud/p/v4;->u()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 5
    invoke-interface {p1}, Ljava/util/Iterator;->remove()V

    return-object v0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method private c(Lio/dcloud/p/t0;)V
    .locals 3

    .line 1
    invoke-static {}, Lio/dcloud/p/e;->b()Lio/dcloud/p/e;

    move-result-object v0

    const-string v1, "gm"

    invoke-virtual {v0, v1}, Lio/dcloud/p/e;->b(Ljava/lang/String;)Lio/dcloud/sdk/core/adapter/IAdAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2
    invoke-virtual {p1}, Lio/dcloud/p/t0;->b()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3
    invoke-direct {p0, p1}, Lio/dcloud/p/y4;->b(Lio/dcloud/p/t0;)Lio/dcloud/p/v4;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 5
    invoke-direct {p0, v0, p1}, Lio/dcloud/p/y4;->a(Lio/dcloud/sdk/core/adapter/IAdAdapter;Lio/dcloud/p/v4;)V

    :cond_0
    return-void
.end method


# virtual methods
.method protected a(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;J)V
    .locals 1

    .line 38
    iget-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    if-eqz v0, :cond_1

    .line 39
    iget-object v0, p0, Lio/dcloud/p/y4;->x:Lio/dcloud/p/n1;

    if-nez v0, :cond_0

    goto :goto_0

    .line 42
    :cond_0
    invoke-virtual {v0}, Lio/dcloud/p/n1;->g()Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {p5, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 45
    :cond_1
    iget-boolean v0, p0, Lio/dcloud/p/y4;->B:Z

    if-eqz v0, :cond_2

    :goto_0
    return-void

    :cond_2
    const/4 v0, 0x1

    .line 48
    iput-boolean v0, p0, Lio/dcloud/p/y4;->B:Z

    .line 49
    invoke-super/range {p0 .. p7}, Lio/dcloud/p/y3;->a(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;J)V

    return-void
.end method

.method protected a(ILjava/lang/String;Lorg/json/JSONArray;)V
    .locals 1

    .line 31
    iget-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    if-eqz v0, :cond_1

    .line 32
    iget-object p2, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    if-eqz p2, :cond_0

    .line 33
    invoke-virtual {p3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object p3

    invoke-interface {p2, p1, p3}, Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;->onLoadFail(ILjava/lang/String;)V

    :cond_0
    return-void

    :cond_1
    const/4 v0, 0x0

    .line 36
    iput-boolean v0, p0, Lio/dcloud/p/b5;->w:Z

    .line 37
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/p/y4;->d(ILjava/lang/String;Lorg/json/JSONArray;)V

    return-void
.end method

.method protected a(Lio/dcloud/p/t0;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Lio/dcloud/p/w;->a()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/p/m;->f(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lio/dcloud/p/i4;->d:I

    const/16 v1, 0xe

    if-eq v0, v1, :cond_0

    const/4 v1, 0x5

    if-eq v0, v1, :cond_0

    const/4 v1, 0x7

    if-eq v0, v1, :cond_0

    const/16 v1, 0xb

    if-eq v0, v1, :cond_0

    .line 2
    invoke-direct {p0, p1}, Lio/dcloud/p/y4;->c(Lio/dcloud/p/t0;)V

    .line 4
    :cond_0
    invoke-super {p0, p1}, Lio/dcloud/p/w;->a(Lio/dcloud/p/t0;)V

    return-void
.end method

.method public a(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/p/w2;)V
    .locals 0

    .line 50
    invoke-virtual {p0}, Lio/dcloud/p/y4;->h()V

    .line 51
    invoke-super {p0, p1, p2}, Lio/dcloud/p/b5;->a(Lio/dcloud/sdk/core/entry/DCloudAOLSlot;Lio/dcloud/p/w2;)V

    const/4 p1, 0x1

    .line 52
    iput-boolean p1, p0, Lio/dcloud/p/b5;->w:Z

    return-void
.end method

.method public a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;Lio/dcloud/p/n1;)V
    .locals 2

    .line 27
    iget-boolean p1, p0, Lio/dcloud/p/y4;->y:Z

    if-eqz p1, :cond_0

    .line 28
    iput-object p2, p0, Lio/dcloud/p/y4;->x:Lio/dcloud/p/n1;

    const/4 p1, 0x0

    .line 29
    iput-boolean p1, p0, Lio/dcloud/p/b5;->w:Z

    const/16 p1, -0x138d

    .line 30
    invoke-static {p1}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    invoke-virtual {p2}, Lio/dcloud/p/n1;->b()Lorg/json/JSONObject;

    move-result-object p2

    invoke-virtual {v1, p2}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    move-result-object p2

    invoke-virtual {p0, p1, v0, p2}, Lio/dcloud/p/y4;->d(ILjava/lang/String;Lorg/json/JSONArray;)V

    :cond_0
    return-void
.end method

.method public a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;Ljava/util/List;Lio/dcloud/p/n1;)V
    .locals 1

    .line 16
    iget-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    if-eqz v0, :cond_1

    .line 17
    iput-object p3, p0, Lio/dcloud/p/y4;->x:Lio/dcloud/p/n1;

    .line 18
    invoke-virtual {p3}, Lio/dcloud/p/n1;->f()V

    .line 19
    new-instance p3, Ljava/util/ArrayList;

    invoke-direct {p3}, Ljava/util/ArrayList;-><init>()V

    if-nez p2, :cond_0

    .line 21
    invoke-interface {p3, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 23
    :cond_0
    invoke-interface {p3, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    :goto_0
    const/4 p1, 0x0

    .line 25
    iput-boolean p1, p0, Lio/dcloud/p/b5;->w:Z

    .line 26
    invoke-virtual {p0, p3}, Lio/dcloud/p/y4;->e(Ljava/util/List;)V

    :cond_1
    return-void
.end method

.method protected c(Ljava/util/List;)V
    .locals 2

    .line 6
    iget-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    if-eqz v0, :cond_2

    .line 7
    iput-object p1, p0, Lio/dcloud/p/y4;->z:Ljava/util/List;

    .line 8
    iget-object v0, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    if-eqz v0, :cond_1

    if-eqz p1, :cond_0

    .line 9
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result p1

    if-nez p1, :cond_0

    .line 10
    iget-object p1, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    iget-object v0, p0, Lio/dcloud/p/y4;->z:Ljava/util/List;

    invoke-interface {p1, v0}, Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;->onLoadSuccess(Ljava/util/List;)V

    return-void

    .line 12
    :cond_0
    iget-object p1, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    const/16 v0, -0x138d

    invoke-static {v0}, Lio/dcloud/sdk/core/util/AOLErrorUtil;->getErrorMsg(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;->onLoadFail(ILjava/lang/String;)V

    :cond_1
    return-void

    :cond_2
    const/4 v0, 0x0

    .line 16
    iput-boolean v0, p0, Lio/dcloud/p/b5;->w:Z

    .line 17
    invoke-virtual {p0, p1}, Lio/dcloud/p/y4;->e(Ljava/util/List;)V

    return-void
.end method

.method protected d(ILjava/lang/String;Lorg/json/JSONArray;)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2, p3}, Lio/dcloud/p/b5;->a(ILjava/lang/String;Lorg/json/JSONArray;)V

    .line 2
    invoke-virtual {p0}, Lio/dcloud/p/y4;->g()Z

    move-result p1

    if-eqz p1, :cond_0

    .line 4
    invoke-virtual {p0}, Lio/dcloud/p/w;->e()V

    :cond_0
    return-void
.end method

.method protected e(Ljava/util/List;)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Lio/dcloud/p/b5;->c(Ljava/util/List;)V

    .line 2
    invoke-virtual {p0}, Lio/dcloud/p/y4;->g()Z

    move-result p1

    if-eqz p1, :cond_0

    .line 3
    invoke-virtual {p0}, Lio/dcloud/p/w;->e()V

    :cond_0
    return-void
.end method

.method public g()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    return v0
.end method

.method public getSuccessAds()Ljava/util/List;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/y4;->z:Ljava/util/List;

    return-object v0
.end method

.method protected h()V
    .locals 2

    const/4 v0, 0x0

    .line 1
    iput-boolean v0, p0, Lio/dcloud/p/y4;->B:Z

    const/4 v1, 0x0

    .line 2
    iput-object v1, p0, Lio/dcloud/p/y4;->x:Lio/dcloud/p/n1;

    .line 3
    iput-boolean v0, p0, Lio/dcloud/p/y4;->y:Z

    .line 4
    iput-object v1, p0, Lio/dcloud/p/y4;->z:Ljava/util/List;

    .line 5
    iput-object v1, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    return-void
.end method

.method public setCADLoadListener(Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/y4;->A:Lio/dcloud/sdk/core/interfaces/IToggle$CADLoadListener;

    return-void
.end method
