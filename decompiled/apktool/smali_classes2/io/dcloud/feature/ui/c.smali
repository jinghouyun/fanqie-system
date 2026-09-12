.class public Lio/dcloud/feature/ui/c;
.super Lio/dcloud/feature/ui/b;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IEventCallback;


# static fields
.field private static final d0:Ljava/util/HashMap;


# instance fields
.field A:I

.field B:Ljava/lang/Object;

.field C:Z

.field D:Z

.field E:I

.field F:Z

.field G:Z

.field H:Z

.field I:Z

.field J:Z

.field K:Z

.field L:Z

.field protected M:Ljava/util/ArrayList;

.field N:Ljava/lang/String;

.field O:Ljava/lang/String;

.field P:Lio/dcloud/common/DHInterface/IWebview;

.field Q:Ljava/lang/String;

.field R:Lio/dcloud/common/DHInterface/IWebview;

.field S:Ljava/lang/String;

.field T:Lio/dcloud/common/DHInterface/IWebview;

.field U:Ljava/lang/String;

.field private V:Z

.field W:Lio/dcloud/feature/ui/c;

.field private X:Ljava/util/ArrayList;

.field private Y:Z

.field private Z:Ljava/lang/String;

.field private a0:I

.field private b0:Z

.field c0:Ljava/lang/Runnable;

.field u:J

.field v:Lorg/json/JSONArray;

.field w:Lio/dcloud/common/DHInterface/IWebview;

.field x:Lorg/json/JSONObject;

.field y:Lio/dcloud/common/DHInterface/IFrameView;

.field z:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lio/dcloud/feature/ui/c;->d0:Ljava/util/HashMap;

    .line 3
    const-string v1, "close"

    const-string v2, "onclose"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    const-string v1, "loading"

    const-string v2, "onloading"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 5
    const-string v1, "failed"

    const-string v2, "onerror"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 6
    const-string v1, "loaded"

    const-string v2, "onloaded"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Lio/dcloud/feature/ui/a;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 3

    .line 2
    const-string v0, "NWindow"

    invoke-direct {p0, v0}, Lio/dcloud/feature/ui/b;-><init>(Ljava/lang/String;)V

    .line 3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lio/dcloud/feature/ui/c;->u:J

    const/4 v0, 0x0

    .line 4
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->v:Lorg/json/JSONArray;

    .line 5
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->w:Lio/dcloud/common/DHInterface/IWebview;

    .line 6
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->x:Lorg/json/JSONObject;

    const/4 v1, -0x1

    .line 17
    iput v1, p0, Lio/dcloud/feature/ui/c;->A:I

    .line 18
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->B:Ljava/lang/Object;

    const/4 v1, 0x0

    .line 20
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->C:Z

    .line 22
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->D:Z

    .line 23
    iput v1, p0, Lio/dcloud/feature/ui/c;->E:I

    .line 26
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->F:Z

    .line 28
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->G:Z

    const/4 v2, 0x1

    .line 30
    iput-boolean v2, p0, Lio/dcloud/feature/ui/c;->H:Z

    .line 32
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->I:Z

    .line 34
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->J:Z

    .line 36
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->K:Z

    .line 38
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->L:Z

    .line 40
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    .line 42
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->N:Ljava/lang/String;

    .line 44
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->O:Ljava/lang/String;

    .line 46
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->P:Lio/dcloud/common/DHInterface/IWebview;

    .line 49
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->Q:Ljava/lang/String;

    .line 51
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->R:Lio/dcloud/common/DHInterface/IWebview;

    .line 54
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->S:Ljava/lang/String;

    .line 56
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->T:Lio/dcloud/common/DHInterface/IWebview;

    .line 58
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->U:Ljava/lang/String;

    .line 60
    iput-boolean v2, p0, Lio/dcloud/feature/ui/c;->V:Z

    .line 62
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    .line 64
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    .line 66
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->Y:Z

    .line 67
    const-string v2, "auto"

    iput-object v2, p0, Lio/dcloud/feature/ui/c;->Z:Ljava/lang/String;

    const/16 v2, 0x96

    .line 68
    iput v2, p0, Lio/dcloud/feature/ui/c;->a0:I

    .line 70
    iput-boolean v1, p0, Lio/dcloud/feature/ui/c;->b0:Z

    .line 2171
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->c0:Ljava/lang/Runnable;

    .line 2172
    iput-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    .line 2173
    iput-object p3, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    .line 2174
    iput-object p5, p0, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    .line 2175
    iput-object p6, p0, Lio/dcloud/feature/ui/b;->h:Lorg/json/JSONObject;

    .line 2176
    invoke-virtual {p0, p2, p4}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)V

    return-void
.end method

.method constructor <init>(Lio/dcloud/feature/ui/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    .locals 7

    const/4 v2, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    .line 1
    invoke-direct/range {v0 .. v6}, Lio/dcloud/feature/ui/c;-><init>(Lio/dcloud/feature/ui/a;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V

    return-void
.end method

.method static synthetic a(Lio/dcloud/feature/ui/c;)Ljava/lang/String;
    .locals 0

    .line 2
    iget-object p0, p0, Lio/dcloud/feature/ui/c;->Z:Ljava/lang/String;

    return-object p0
.end method

.method private static a(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 6

    .line 29785
    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    if-eqz p0, :cond_2

    .line 29787
    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_2

    .line 29789
    invoke-virtual {p0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lio/dcloud/feature/ui/b;

    .line 29790
    instance-of v4, v3, Lio/dcloud/feature/ui/c;

    if-eqz v4, :cond_0

    .line 29791
    check-cast v3, Lio/dcloud/feature/ui/c;

    invoke-virtual {v3}, Lio/dcloud/feature/ui/c;->h()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 29793
    :cond_0
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, v3, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :goto_1
    add-int/lit8 v3, v1, -0x1

    if-eq v2, v3, :cond_1

    .line 29796
    const-string v3, ","

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 29800
    :cond_2
    const-string p0, "]"

    invoke-virtual {v0, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 29801
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private static a(Lio/dcloud/common/DHInterface/IContainerView;Lio/dcloud/common/adapter/ui/AdaFrameItem;Landroid/view/ViewGroup$LayoutParams;IIII)V
    .locals 2

    .line 200
    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p2

    .line 201
    iput p3, p2, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    .line 202
    iput p4, p2, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    .line 203
    iput p5, p2, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    .line 204
    iput p6, p2, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    .line 205
    invoke-virtual {p2}, Lio/dcloud/common/adapter/util/ViewRect;->commitUpdate2JSONObject()V

    .line 206
    move-object p2, p1

    check-cast p2, Lio/dcloud/common/adapter/ui/AdaFrameView;

    const/4 v0, 0x1

    iput-boolean v0, p2, Lio/dcloud/common/adapter/ui/AdaFrameView;->isChildOfFrameView:Z

    .line 207
    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v0

    .line 209
    invoke-virtual {p2}, Lio/dcloud/common/adapter/ui/AdaFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p2

    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->isUniWebView()Z

    move-result p2

    const/4 v1, 0x0

    if-eqz p2, :cond_0

    .line 211
    invoke-virtual {v0, v1, v1, p5, p6}, Landroid/view/View;->layout(IIII)V

    goto :goto_0

    .line 213
    :cond_0
    invoke-virtual {v0, v1}, Landroid/view/View;->setTop(I)V

    .line 214
    invoke-virtual {v0, v1}, Landroid/view/View;->setLeft(I)V

    :goto_0
    const/4 p2, 0x0

    .line 217
    invoke-static {v0, p2}, Lio/dcloud/nineoldandroids/view/ViewHelper;->setX(Landroid/view/View;F)V

    .line 218
    invoke-static {v0, p2}, Lio/dcloud/nineoldandroids/view/ViewHelper;->setY(Landroid/view/View;F)V

    .line 219
    invoke-static {p3, p4, p5, p6}, Lio/dcloud/common/adapter/ui/AdaFrameItem$LayoutParamsUtil;->createLayoutParams(IIII)Landroid/view/ViewGroup$LayoutParams;

    move-result-object p2

    .line 220
    invoke-interface {p0, p1, p2}, Lio/dcloud/common/DHInterface/IContainerView;->addFrameItem(Lio/dcloud/common/adapter/ui/AdaFrameItem;Landroid/view/ViewGroup$LayoutParams;)V

    .line 221
    new-instance p0, Ljava/lang/StringBuilder;

    const-string p1, "appendNWindow Y="

    invoke-direct {p0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lio/dcloud/nineoldandroids/view/ViewHelper;->getY(Landroid/view/View;)F

    move-result p1

    invoke-virtual {p0, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    const-string p1, "View_Visible_Path"

    invoke-static {p1, p0}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/feature/ui/c;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    .locals 47

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v3, p4

    const-string v4, "titletext"

    const-string v5, "titleText"

    const/4 v6, 0x3

    const/4 v7, 0x2

    const/4 v8, 0x0

    const/4 v9, 0x1

    if-nez p3, :cond_0

    .line 29802
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    .line 29803
    invoke-virtual {v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    .line 29804
    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v5}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v5

    .line 29805
    iget-object v10, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v10, v10, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v11, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    new-array v6, v6, [Ljava/lang/Object;

    aput-object v2, v6, v8

    aput-object v3, v6, v9

    aput-object v5, v6, v7

    const/16 v5, 0x48

    invoke-interface {v10, v11, v5, v6}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 29808
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v5

    invoke-virtual {v4, v3, v5}, Lio/dcloud/common/adapter/util/ViewOptions;->setTitleNView(Lorg/json/JSONObject;Lio/dcloud/common/DHInterface/IWebview;)V

    .line 29809
    iget-object v3, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    .line 29810
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v2, v5, v8

    aput-object v4, v5, v9

    const/16 v2, 0x49

    .line 29811
    invoke-interface {v3, v11, v2, v5}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 29814
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->isUniWebView()Z

    move-result v2

    if-eqz v2, :cond_27

    .line 29815
    iget-object v1, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v1

    check-cast v1, Lio/dcloud/common/adapter/ui/AdaUniWebView;

    invoke-virtual {v1}, Lio/dcloud/common/adapter/ui/AdaUniWebView;->titleNViewRefresh()V

    return-void

    :cond_0
    if-nez v3, :cond_1

    goto/16 :goto_a

    .line 29824
    :cond_1
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->paddingIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v10

    .line 29826
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->backgroundIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v11

    .line 29828
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->backgroundImageIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v12

    .line 29830
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->titleAlignIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v13

    .line 29832
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->redDotChange(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v14

    .line 29834
    invoke-static/range {p3 .. p3}, Lio/dcloud/common/util/TitleNViewUtil;->titleNViewStyleNoTitle(Lorg/json/JSONObject;)Z

    .line 29836
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->titleIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v15

    .line 29838
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->titleColorIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v16

    .line 29840
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->titleSizeIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v17

    .line 29842
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->titleOverflowIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v18

    .line 29845
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->splitLineIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v19

    .line 29847
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->backButtonIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v20

    .line 29849
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->progressIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v21

    const/16 v22, 0x3

    .line 29851
    const-string v6, "homeButton"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v6

    .line 29853
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->isButtonsIsChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v23

    .line 29855
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->isSearchInputChange(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v24

    .line 29857
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->subTitleIconChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v25

    .line 29858
    invoke-static/range {p3 .. p4}, Lio/dcloud/common/util/TitleNViewUtil;->isShadowChanged(Lorg/json/JSONObject;Lorg/json/JSONObject;)Z

    move-result v26

    const/16 v27, 0x2

    .line 29860
    iget-object v7, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v7}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v7

    .line 29863
    invoke-virtual/range {p3 .. p3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v28

    const/16 v29, 0x0

    invoke-static/range {v28 .. v28}, Lio/dcloud/common/util/JSONUtil;->createJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v8

    .line 29865
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v28

    const/16 v30, 0x1

    invoke-static/range {v28 .. v28}, Lio/dcloud/common/util/JSONUtil;->createJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 29866
    invoke-static {v8, v9}, Lio/dcloud/common/util/JSONUtil;->combinJSONObject(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move/from16 p1, v6

    .line 29867
    iget-object v6, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v6, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v6}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v6

    iget v6, v6, Lio/dcloud/common/adapter/util/ViewOptions;->coverage:I

    move/from16 v28, v10

    if-eqz v8, :cond_2

    .line 29868
    const-string v10, "coverage"

    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v31

    if-eqz v31, :cond_2

    move/from16 v31, v11

    .line 29869
    iget-object v11, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v11, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v11}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v11

    .line 29870
    invoke-virtual {v8, v10}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->a()Landroid/content/Context;

    move-result-object v32

    move/from16 v33, v12

    invoke-static/range {v32 .. v32}, Lio/dcloud/common/adapter/util/PlatformUtil;->SCREEN_WIDTH(Landroid/content/Context;)I

    move-result v12

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v32

    move/from16 v34, v13

    invoke-interface/range {v32 .. v32}, Lio/dcloud/common/DHInterface/IWebview;->getScale()F

    move-result v13

    invoke-static {v10, v12, v6, v13}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v6

    iput v6, v11, Lio/dcloud/common/adapter/util/ViewOptions;->coverage:I

    goto :goto_0

    :cond_2
    move/from16 v31, v11

    move/from16 v33, v12

    move/from16 v34, v13

    :goto_0
    if-eqz v8, :cond_27

    .line 29876
    :try_start_0
    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 29877
    invoke-virtual {v8, v5}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 29878
    instance-of v5, v4, Ljava/lang/String;

    if-eqz v5, :cond_4

    .line 29879
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 29881
    :cond_3
    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 29882
    invoke-virtual {v8, v4}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 29883
    instance-of v5, v4, Ljava/lang/String;

    if-eqz v5, :cond_4

    .line 29884
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    nop

    :cond_4
    const/4 v4, 0x0

    .line 29890
    :goto_1
    const-string v5, "titleColor"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    const-string v11, "titlecolor"

    if-eqz v10, :cond_5

    .line 29891
    invoke-virtual {v8, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    goto :goto_2

    .line 29892
    :cond_5
    invoke-virtual {v3, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 29893
    invoke-virtual {v8, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    goto :goto_2

    :cond_6
    const/4 v10, 0x0

    .line 29895
    :goto_2
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_7

    .line 29896
    invoke-virtual {v8, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 29897
    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 29898
    invoke-virtual {v8, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 29902
    :cond_7
    const-string v5, "type"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    const-string v12, "transparent"

    invoke-virtual {v12, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    const/4 v13, 0x0

    if-eqz v11, :cond_8

    invoke-static {v10}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_8

    .line 29903
    invoke-static {v10, v13}, Lio/dcloud/common/util/TitleNViewUtil;->changeColorAlpha(Ljava/lang/String;F)Ljava/lang/String;

    move-result-object v10

    .line 29907
    :cond_8
    const-string v11, "titleSize"

    invoke-virtual {v3, v11}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v32

    const-string v6, "titlesize"

    if-eqz v32, :cond_9

    .line 29908
    invoke-virtual {v8, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    goto :goto_3

    .line 29909
    :cond_9
    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v32

    if-eqz v32, :cond_a

    .line 29910
    invoke-virtual {v8, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    goto :goto_3

    :cond_a
    const/16 v32, 0x0

    .line 29912
    :goto_3
    invoke-static/range {v32 .. v32}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v36

    if-eqz v36, :cond_b

    .line 29913
    invoke-virtual {v8, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    .line 29914
    invoke-static/range {v32 .. v32}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_b

    .line 29915
    invoke-virtual {v8, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v32

    :cond_b
    move-object/from16 v6, v32

    .line 29918
    const-string v11, "titleOverflow"

    invoke-virtual {v8, v11}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 29921
    const-string v13, "backgroundColor"

    invoke-virtual {v3, v13}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    move/from16 v37, v14

    const-string v14, "backgroundcolor"

    if-eqz v36, :cond_c

    .line 29922
    invoke-virtual {v8, v13}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    goto :goto_4

    .line 29923
    :cond_c
    invoke-virtual {v3, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_d

    .line 29924
    invoke-virtual {v8, v14}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    goto :goto_4

    :cond_d
    const/16 v36, 0x0

    .line 29926
    :goto_4
    invoke-static/range {v36 .. v36}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v38

    if-eqz v38, :cond_e

    .line 29927
    invoke-virtual {v8, v13}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    .line 29928
    invoke-static/range {v36 .. v36}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v13

    if-eqz v13, :cond_e

    .line 29929
    invoke-virtual {v8, v14}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    :cond_e
    move-object/from16 v13, v36

    .line 29934
    const-string v14, "backgroundImage"

    invoke-virtual {v3, v14}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_f

    .line 29935
    invoke-virtual {v8, v14}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    goto :goto_5

    :cond_f
    const/4 v14, 0x0

    :goto_5
    const-string v35, "nativeobj"

    move/from16 v36, v15

    const-string v15, "\',\'"

    move-object/from16 v39, v14

    const-string v14, "[\'"

    if-eqz v31, :cond_13

    .line 29939
    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v31

    if-nez v31, :cond_13

    .line 29942
    invoke-virtual {v8, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v12, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10

    const/4 v3, 0x0

    .line 29943
    invoke-static {v13, v3}, Lio/dcloud/common/util/TitleNViewUtil;->changeColorAlpha(Ljava/lang/String;F)Ljava/lang/String;

    move-result-object v3

    goto :goto_6

    .line 29944
    :cond_10
    invoke-virtual {v8, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v12, "float"

    invoke-virtual {v12, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_11

    move-object v3, v13

    goto :goto_6

    :cond_11
    const/high16 v3, 0x3f800000    # 1.0f

    .line 29946
    invoke-static {v13, v3}, Lio/dcloud/common/util/TitleNViewUtil;->changeColorAlpha(Ljava/lang/String;F)Ljava/lang/String;

    move-result-object v3

    .line 29949
    :goto_6
    iget-object v12, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v12, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v12}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v12

    iget-boolean v12, v12, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-nez v12, :cond_12

    iget-object v12, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v12}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v12

    invoke-interface {v12}, Lio/dcloud/common/DHInterface/IApp;->obtainStatusBarMgr()Lio/dcloud/common/util/AppStatusBarManager;

    move-result-object v12

    iget-boolean v12, v12, Lio/dcloud/common/util/AppStatusBarManager;->isImmersive:Z

    if-eqz v12, :cond_12

    .line 29950
    new-instance v12, Ljava/lang/StringBuilder;

    move-object/from16 v31, v5

    const-string v5, ",\'statusbar\':{\'background\':\'"

    invoke-direct {v12, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, "\',\'backgroundnoalpha\':\'"

    invoke-virtual {v12, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v5, "\'}"

    invoke-virtual {v12, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_7

    :cond_12
    move-object/from16 v31, v5

    .line 29952
    const-string v5, ""

    :goto_7
    iget-object v12, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v12, v12, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v13, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    .line 29953
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v32

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v40, v8

    const-string v8, "\',{\'backgroundColor\':\'"

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string/jumbo v3, "}]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    const/4 v3, 0x4

    new-array v5, v3, [Ljava/lang/Object;

    aput-object v32, v5, v29

    aput-object v35, v5, v30

    const-string v3, "setStyle"

    aput-object v3, v5, v27

    aput-object v2, v5, v22

    const/4 v2, 0x1

    .line 29954
    invoke-interface {v12, v13, v2, v5}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_8

    :cond_13
    move-object/from16 v31, v5

    move-object/from16 v40, v8

    .line 29958
    :goto_8
    const-string v2, "tags"

    invoke-virtual {v9, v2}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    if-eqz v2, :cond_14

    .line 29960
    iget-object v3, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v5, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    .line 29961
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v12, "\',"

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "]"

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    const/4 v9, 0x4

    new-array v12, v9, [Ljava/lang/Object;

    aput-object v8, v12, v29

    const/4 v8, 0x1

    aput-object v35, v12, v8

    const-string/jumbo v9, "view_draw"

    aput-object v9, v12, v27

    aput-object v2, v12, v22

    .line 29962
    invoke-interface {v3, v5, v8, v12}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 29966
    :cond_14
    iget-object v2, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v2, v2, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v2, v3, v5, v7}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 29967
    instance-of v3, v2, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_26

    .line 29968
    check-cast v2, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v36, :cond_15

    .line 29971
    invoke-interface {v2, v4}, Lio/dcloud/common/DHInterface/ITitleNView;->setTitleText(Ljava/lang/String;)V

    :cond_15
    if-eqz v16, :cond_16

    .line 29975
    invoke-interface {v2, v10}, Lio/dcloud/common/DHInterface/ITitleNView;->setTitleColor(Ljava/lang/String;)V

    :cond_16
    if-eqz v17, :cond_17

    .line 29979
    invoke-interface {v2, v6}, Lio/dcloud/common/DHInterface/ITitleNView;->setTitleSize(Ljava/lang/String;)V

    :cond_17
    if-eqz v18, :cond_18

    .line 29983
    invoke-interface {v2, v11}, Lio/dcloud/common/DHInterface/ITitleNView;->setTitleOverflow(Ljava/lang/String;)V

    :cond_18
    if-eqz v28, :cond_19

    .line 29987
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    move-object/from16 v4, v40

    invoke-static {v2, v3, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setTitleNViewPadding(Lio/dcloud/common/DHInterface/ITitleNView;Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;)V

    goto :goto_9

    :cond_19
    move-object/from16 v4, v40

    :goto_9
    if-eqz v19, :cond_1a

    .line 29991
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v42

    const-string v3, "splitLine"

    move-object/from16 v5, p3

    invoke-virtual {v5, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v43

    const-string v3, "splitLine"

    move-object/from16 v5, p4

    invoke-virtual {v5, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v44

    move-object/from16 v3, v31

    invoke-virtual {v4, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v46

    const/16 v45, 0x0

    move-object/from16 v41, v2

    invoke-static/range {v41 .. v46}, Lio/dcloud/common/util/TitleNViewUtil;->setSplitLine(Lio/dcloud/common/DHInterface/ITitleNView;Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;Lorg/json/JSONObject;ZLjava/lang/String;)V

    :cond_1a
    if-eqz v20, :cond_1b

    .line 29995
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->getFrameType()I

    move-result v3

    invoke-static {v2, v4, v3}, Lio/dcloud/common/util/TitleNViewUtil;->setBackButton(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;I)V

    :cond_1b
    if-eqz v21, :cond_1c

    .line 29999
    invoke-static {v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setProgress(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;)V

    :cond_1c
    if-eqz v24, :cond_1d

    .line 30004
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    invoke-static {v2, v4, v3}, Lio/dcloud/common/util/TitleNViewUtil;->setSearchInput(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Lio/dcloud/common/DHInterface/IWebview;)V

    :cond_1d
    if-eqz v23, :cond_1e

    .line 30008
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/ITitleNView;->clearButtons()V

    .line 30009
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    invoke-static {v2, v4, v3}, Lio/dcloud/common/util/TitleNViewUtil;->setButtons(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Lio/dcloud/common/DHInterface/IWebview;)V

    .line 30010
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->getFrameType()I

    move-result v3

    invoke-static {v2, v4, v3}, Lio/dcloud/common/util/TitleNViewUtil;->setBackButton(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;I)V

    :cond_1e
    if-nez p1, :cond_1f

    if-eqz v23, :cond_20

    .line 30015
    :cond_1f
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->getFrameType()I

    move-result v3

    invoke-static {v2, v4, v3}, Lio/dcloud/common/util/TitleNViewUtil;->setHomeButton(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;I)V

    :cond_20
    if-eqz v37, :cond_21

    .line 30019
    invoke-static {v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setRedDotColor(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;)V

    :cond_21
    if-eqz v34, :cond_22

    .line 30023
    invoke-static {v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setTitleAlign(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;)V

    :cond_22
    if-eqz v33, :cond_23

    if-eqz v39, :cond_23

    .line 30027
    iget-object v3, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v5, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    .line 30028
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v6

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, "\',{\'backgroundImage\':\'"

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-object/from16 v14, v39

    invoke-virtual {v8, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v7, "\'}]"

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    const/4 v9, 0x4

    new-array v8, v9, [Ljava/lang/Object;

    aput-object v6, v8, v29

    const/4 v6, 0x1

    aput-object v35, v8, v6

    const-string v9, "setStyle"

    aput-object v9, v8, v27

    aput-object v7, v8, v22

    .line 30029
    invoke-interface {v3, v5, v6, v8}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 30033
    :cond_23
    const-string v3, "backgroundRepeat"

    invoke-virtual {v4, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_24

    .line 30034
    const-string v3, "backgroundRepeat"

    invoke-virtual {v4, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lio/dcloud/common/DHInterface/ITitleNView;->setBackgroundRepeat(Ljava/lang/String;)V

    :cond_24
    if-eqz v25, :cond_25

    .line 30037
    invoke-static {v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setSubTitleIcon(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;)V

    :cond_25
    if-eqz v26, :cond_26

    .line 30040
    invoke-static {v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setShadow(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;)V

    .line 30043
    :cond_26
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->isUniWebView()Z

    move-result v2

    if-eqz v2, :cond_27

    .line 30044
    iget-object v1, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v1

    check-cast v1, Lio/dcloud/common/adapter/ui/AdaUniWebView;

    invoke-virtual {v1}, Lio/dcloud/common/adapter/ui/AdaUniWebView;->titleNViewRefresh()V

    :cond_27
    :goto_a
    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;)V
    .locals 9

    const-string/jumbo v0, "{\"code\":-100,\"message\":\""

    const/4 v1, 0x0

    .line 29582
    invoke-static {p2, v1}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    .line 29583
    invoke-static {p2, v2}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v4

    .line 29584
    iget-object v2, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v1, v3}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 29587
    :try_start_0
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    move-object v3, p1

    goto :goto_2

    .line 29588
    :cond_1
    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v3, Lio/dcloud/base/R$string;->dcloud_ui_webview_not_finished:I

    invoke-virtual {v0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\"}"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    sget v6, Lio/dcloud/common/util/JSUtil;->ERROR:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v7, 0x1

    const/4 v8, 0x0

    move-object v3, p1

    :try_start_1
    invoke-static/range {v3 .. v8}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    return-void

    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    move-object v3, p1

    .line 29592
    :goto_1
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    .line 29593
    sget v6, Lio/dcloud/common/util/JSUtil;->ERROR:I

    const/4 v7, 0x1

    const/4 v8, 0x0

    const-string/jumbo v5, "{\"code\":-100,\"message\":\"\"+sWeb.getContext().getString(R.string.dcloud_ui_webview_not_finished)+\"\"}"

    invoke-static/range {v3 .. v8}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    .line 29595
    :goto_2
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v5

    const/4 p1, 0x2

    .line 29596
    invoke-static {p2, p1}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object p1

    .line 29597
    const-string p2, "auto"

    if-eqz p1, :cond_2

    .line 29598
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 29599
    invoke-virtual {p1, v0, p2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    :cond_2
    move-object v6, p2

    .line 29602
    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->obtainWindowView()Landroid/view/ViewGroup;

    move-result-object p1

    if-eqz p1, :cond_3

    move-object v7, v3

    .line 29604
    new-instance v3, Lio/dcloud/feature/ui/c$e;

    move-object v8, v4

    move-object v4, p0

    invoke-direct/range {v3 .. v8}, Lio/dcloud/feature/ui/c$e;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-virtual {p1, v3}, Landroid/view/View;->post(Ljava/lang/Runnable;)Z

    :cond_3
    return-void
.end method

.method private a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V
    .locals 20

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    const-string v3, "auto"

    if-eqz v1, :cond_9

    .line 29705
    const-string v5, "acceleration"

    invoke-virtual {v1, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 29706
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_0

    goto :goto_0

    :cond_0
    move-object v3, v5

    .line 29708
    :goto_0
    const-string v5, "action"

    const-string v6, "none"

    invoke-virtual {v1, v5, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 29710
    iget-object v7, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v7, v3}, Lio/dcloud/common/DHInterface/IFrameView;->setAccelerationType(Ljava/lang/String;)V

    .line 29712
    const-string v7, "capture"

    invoke-virtual {v1, v7}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v8

    const-string v11, "getNativeView"

    const-string v12, "nativeobj"

    const-string v14, "nativeView"

    const-string v15, "__id__"

    const/16 v16, 0x1

    const/16 v17, 0x0

    const/16 p4, 0x3

    const/4 v10, 0x2

    const-string v4, "type"

    if-eqz v8, :cond_4

    .line 29713
    invoke-virtual {v1, v7}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    if-nez v7, :cond_1

    goto/16 :goto_4

    .line 29717
    :cond_1
    invoke-virtual {v7, v15}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 29718
    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_2

    invoke-virtual {v7, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 29719
    iget-object v7, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v7, v7, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v9, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v13, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    move-object/from16 v19, v11

    new-array v11, v10, [Ljava/lang/Object;

    aput-object v13, v11, v17

    aput-object v8, v11, v16

    const/4 v8, 0x4

    new-array v13, v8, [Ljava/lang/Object;

    aput-object p1, v13, v17

    aput-object v12, v13, v16

    aput-object v19, v13, v10

    aput-object v11, v13, p4

    const/16 v8, 0xa

    invoke-interface {v7, v9, v8, v13}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    if-eqz v7, :cond_5

    .line 29720
    instance-of v8, v7, Lio/dcloud/common/DHInterface/INativeView;

    if-eqz v8, :cond_5

    .line 29721
    iget-object v8, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v7, Lio/dcloud/common/DHInterface/INativeView;

    invoke-interface {v8, v7, v5}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshotView(Lio/dcloud/common/DHInterface/INativeView;Ljava/lang/String;)V

    .line 29722
    iget-object v7, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v8, 0x0

    invoke-interface {v7, v8}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    goto :goto_2

    :cond_2
    move-object/from16 v19, v11

    .line 29725
    iget-object v7, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v7

    invoke-direct {v0, v7, v8}, Lio/dcloud/feature/ui/c;->g(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/common/DHInterface/INativeBitmap;

    move-result-object v7

    .line 29726
    iget-object v8, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    if-eqz v7, :cond_3

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/INativeBitmap;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v7

    goto :goto_1

    :cond_3
    const/4 v7, 0x0

    :goto_1
    invoke-interface {v8, v7}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    .line 29727
    iget-object v7, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v8, 0x0

    invoke-interface {v7, v8, v6}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshotView(Lio/dcloud/common/DHInterface/INativeView;Ljava/lang/String;)V

    goto :goto_2

    :cond_4
    move-object/from16 v19, v11

    .line 29731
    :cond_5
    :goto_2
    iget-object v2, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->findPageB()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v2

    if-eqz v2, :cond_a

    .line 29734
    invoke-interface {v2, v3}, Lio/dcloud/common/DHInterface/IFrameView;->setAccelerationType(Ljava/lang/String;)V

    .line 29736
    const-string v3, "otherCapture"

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 29737
    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    if-nez v1, :cond_6

    goto :goto_4

    .line 29741
    :cond_6
    invoke-virtual {v1, v15}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 29742
    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    invoke-virtual {v1, v4}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 29743
    iget-object v1, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v1, v1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v4, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    new-array v6, v10, [Ljava/lang/Object;

    aput-object v2, v6, v17

    aput-object v3, v6, v16

    const/4 v8, 0x4

    new-array v3, v8, [Ljava/lang/Object;

    aput-object p1, v3, v17

    aput-object v12, v3, v16

    aput-object v19, v3, v10

    aput-object v6, v3, p4

    const/16 v8, 0xa

    invoke-interface {v1, v4, v8, v3}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_a

    .line 29744
    instance-of v3, v1, Lio/dcloud/common/DHInterface/INativeView;

    if-eqz v3, :cond_a

    .line 29745
    check-cast v1, Lio/dcloud/common/DHInterface/INativeView;

    invoke-interface {v2, v1, v5}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshotView(Lio/dcloud/common/DHInterface/INativeView;Ljava/lang/String;)V

    const/4 v8, 0x0

    .line 29746
    invoke-interface {v2, v8}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    return-void

    .line 29749
    :cond_7
    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v1

    invoke-direct {v0, v1, v3}, Lio/dcloud/feature/ui/c;->g(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/common/DHInterface/INativeBitmap;

    move-result-object v1

    if-eqz v1, :cond_8

    .line 29751
    invoke-interface {v1}, Lio/dcloud/common/DHInterface/INativeBitmap;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v8

    goto :goto_3

    :cond_8
    const/4 v8, 0x0

    :goto_3
    invoke-interface {v2, v8}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    const/4 v8, 0x0

    .line 29752
    invoke-interface {v2, v8, v6}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshotView(Lio/dcloud/common/DHInterface/INativeView;Ljava/lang/String;)V

    return-void

    :cond_9
    const/4 v8, 0x0

    .line 29758
    iget-object v1, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v1, v8}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    .line 29759
    iget-object v1, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v1, v3}, Lio/dcloud/common/DHInterface/IFrameView;->setAccelerationType(Ljava/lang/String;)V

    .line 29760
    iget-object v1, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IFrameView;->findPageB()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v1

    if-eqz v1, :cond_a

    .line 29762
    invoke-interface {v1, v8}, Lio/dcloud/common/DHInterface/IFrameView;->setSnapshot(Landroid/graphics/Bitmap;)V

    .line 29763
    invoke-interface {v1, v3}, Lio/dcloud/common/DHInterface/IFrameView;->setAccelerationType(Ljava/lang/String;)V

    :cond_a
    :goto_4
    return-void
.end method

.method private a(Lio/dcloud/feature/ui/b;Lio/dcloud/feature/ui/c;)V
    .locals 2

    .line 172
    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->a()Landroid/content/Context;

    move-result-object p1

    invoke-static {p1}, Lio/dcloud/common/util/BaseInfo;->isBase(Landroid/content/Context;)Z

    move-result p1

    if-eqz p1, :cond_1

    .line 173
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    const-string v0, "http://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_1

    iget-object p1, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    .line 174
    const-string v1, "https://"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_1

    iget-object p1, p2, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    .line 175
    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-nez p1, :cond_1

    iget-object p1, p2, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    .line 176
    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_0

    goto :goto_0

    .line 181
    :cond_0
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_1

    iget-object p1, p2, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    .line 182
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_1

    .line 184
    invoke-virtual {p2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    .line 185
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object p1

    .line 187
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainUrl()Ljava/lang/String;

    move-result-object v0

    .line 188
    invoke-interface {p1, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 192
    invoke-static {p1}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getHBuilderPrintUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lio/dcloud/feature/ui/e;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 196
    invoke-virtual {p2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p2

    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->obtainUrl()Ljava/lang/String;

    move-result-object p2

    .line 197
    invoke-static {p2}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getHBuilderPrintUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lio/dcloud/feature/ui/e;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 p1, 0x1

    aput-object p2, v0, p1

    .line 198
    const-string/jumbo p1, "{\"filiation\": {\"parent\":\"%s\",\"child\":\"%s\"}}"

    invoke-static {p1, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    .line 199
    const-string p2, ".stream_json"

    invoke-static {p2, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    :goto_0
    return-void
.end method

.method private a(Lio/dcloud/feature/ui/b;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V
    .locals 4

    .line 29605
    check-cast p1, Lio/dcloud/feature/ui/c;

    .line 29606
    iget-boolean v0, p1, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v0, :cond_0

    .line 29607
    iget-wide v0, p1, Lio/dcloud/feature/ui/c;->u:J

    const-wide/16 v2, 0x1

    sub-long/2addr v0, v2

    iput-wide v0, p2, Lio/dcloud/feature/ui/c;->u:J

    const/4 v0, 0x1

    .line 29608
    iput-boolean v0, p2, Lio/dcloud/feature/ui/c;->F:Z

    .line 29609
    iput-boolean v0, p2, Lio/dcloud/feature/ui/c;->I:Z

    const/4 v1, 0x0

    .line 29610
    iput-boolean v1, p2, Lio/dcloud/feature/ui/c;->G:Z

    .line 29612
    iget-object v2, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v2, p0}, Lio/dcloud/feature/ui/a;->c(Lio/dcloud/feature/ui/c;)I

    move-result v2

    .line 29615
    iget-object v3, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v3, p3, p2, v2}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Lio/dcloud/feature/ui/c;I)V

    .line 29616
    iget-object p3, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p3, p3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object p2, p2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    iget-object p1, p1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v1

    aput-object p1, v3, v0

    const/16 p1, 0x2d

    invoke-interface {p3, v2, p1, v3}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method

.method private a(Lio/dcloud/feature/ui/c;Ljava/lang/String;)V
    .locals 3

    if-eqz p1, :cond_4

    .line 29617
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_1

    .line 29620
    :cond_0
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    if-nez v0, :cond_1

    goto :goto_1

    .line 29625
    :cond_1
    iget-object v1, p1, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    if-nez v1, :cond_2

    goto :goto_0

    .line 29630
    :cond_2
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p2

    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->obtainUrl()Ljava/lang/String;

    move-result-object p2

    .line 29632
    :goto_0
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v1

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IWebview;->obtainUrl()Ljava/lang/String;

    move-result-object v1

    .line 29633
    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->a()Landroid/content/Context;

    move-result-object p1

    invoke-static {p1}, Lio/dcloud/common/util/BaseInfo;->isBase(Landroid/content/Context;)Z

    move-result p1

    if-eqz p1, :cond_4

    .line 29634
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_4

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result p1

    if-nez p1, :cond_4

    .line 29635
    const-string p1, "http://"

    invoke-virtual {p2, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    invoke-virtual {v1, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_3

    goto :goto_1

    .line 29640
    :cond_3
    invoke-static {p2}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getOriginalUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 29641
    invoke-static {v1}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getOriginalUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 29644
    invoke-interface {v0, p1}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 29645
    invoke-static {p1}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getHBuilderPrintUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 29646
    invoke-interface {v0, p2}, Lio/dcloud/common/DHInterface/IApp;->convert2RelPath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lio/dcloud/common/adapter/ui/webview/WebResUtil;->getHBuilderPrintUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    const/4 p1, 0x1

    aput-object p2, v0, p1

    .line 29647
    const-string/jumbo p1, "{\"open\": {\"opener\":\"%s\",\"opened\":\"%s\"}}"

    invoke-static {p1, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    const-string p2, ".stream_json"

    invoke-static {p2, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    :cond_4
    :goto_1
    return-void
.end method

.method private a(Lio/dcloud/feature/ui/c;Lorg/json/JSONObject;)V
    .locals 7

    if-nez p2, :cond_0

    return-void

    .line 30045
    :cond_0
    iget-object v0, p1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/BaseInfo;->getUniNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 30046
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v1

    iget-object v2, p1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v2

    const/4 v3, 0x4

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v1, 0x1

    aput-object v2, v4, v1

    const/4 v2, 0x2

    aput-object p2, v4, v2

    const/4 p2, 0x3

    aput-object v0, v4, p2

    .line 30047
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v6, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    .line 30048
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object p1

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v5

    const-string/jumbo p1, "weex,io.dcloud.feature.weex.WeexFeature"

    aput-object p1, v3, v1

    const-string/jumbo p1, "weexViewUpdate"

    aput-object p1, v3, v2

    aput-object v4, v3, p2

    const/16 p1, 0xa

    .line 30049
    invoke-interface {v0, v6, p1, v3}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public static declared-synchronized a(Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Lio/dcloud/feature/ui/c;)V
    .locals 5

    const-class v0, Lio/dcloud/feature/ui/c;

    monitor-enter v0

    .line 222
    :try_start_0
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/dcloud/feature/ui/c;

    .line 223
    invoke-virtual {v2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    iget-object v3, p3, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lio/dcloud/common/util/JSONUtil;->toJSONableString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, p0, v4}, Lio/dcloud/common/util/JSUtil;->broadcastWebviewEvent(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 225
    :cond_0
    invoke-interface {p2, p3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_1

    .line 226
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p2

    iget-object p3, p3, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lio/dcloud/common/util/JSONUtil;->toJSONableString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-static {p2, p3, p0, p1}, Lio/dcloud/common/util/JSUtil;->broadcastWebviewEvent(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-void

    :cond_1
    monitor-exit v0

    return-void

    :catchall_0
    move-exception p0

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw p0
.end method

.method private c(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V
    .locals 18

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    const/4 v3, 0x0

    .line 27
    invoke-static {v2, v3}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    .line 28
    invoke-static {v2, v5}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v5

    .line 30
    iget-object v6, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    const/4 v7, 0x0

    invoke-virtual {v6, v5, v5, v7}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v5

    invoke-virtual {v5}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v5

    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v9

    const/4 v5, 0x2

    .line 31
    invoke-static {v2, v5}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x3

    .line 37
    invoke-static {v2, v6}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v6, "RGB565"

    if-eqz v2, :cond_1

    .line 39
    const-string v8, "check"

    invoke-virtual {v2, v8, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v8

    .line 40
    const-string v10, "checkKeyboard"

    invoke-virtual {v2, v10, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v10

    .line 41
    const-string/jumbo v11, "wholeContent"

    invoke-virtual {v2, v11}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v11

    .line 42
    const-string v12, "bit"

    invoke-virtual {v2, v12, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 43
    const-string v12, "clip"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 45
    invoke-virtual {v9}, Landroid/view/View;->getWidth()I

    move-result v12

    .line 46
    invoke-virtual {v9}, Landroid/view/View;->getHeight()I

    move-result v13

    .line 47
    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IWebview;->getScale()F

    move-result v14

    .line 48
    const-string v15, "left"

    invoke-virtual {v2, v15}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15, v12, v3, v14}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v15

    .line 49
    const-string v7, "top"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v13, v3, v14}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v3

    .line 50
    const-string/jumbo v7, "width"

    invoke-virtual {v2, v7}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v12, v12, v14}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v7

    .line 51
    const-string v12, "height"

    invoke-virtual {v2, v12}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v13, v13, v14}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v2

    .line 52
    new-instance v12, Landroid/graphics/Rect;

    invoke-direct {v12, v15, v3, v7, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    move-object v15, v6

    move v13, v11

    move-object v14, v12

    move v11, v8

    move v12, v10

    goto :goto_0

    :cond_0
    move-object v15, v6

    move v12, v10

    move v13, v11

    const/4 v14, 0x0

    move v11, v8

    goto :goto_0

    :cond_1
    move-object v15, v6

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    .line 55
    :goto_0
    invoke-interface {v1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v8

    invoke-direct {v0, v1, v4}, Lio/dcloud/feature/ui/c;->g(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/common/DHInterface/INativeBitmap;

    move-result-object v10

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    const/16 v16, 0x0

    goto :goto_1

    :cond_2
    new-instance v2, Lio/dcloud/feature/ui/c$h;

    invoke-direct {v2, v0, v1, v5}, Lio/dcloud/feature/ui/c$h;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    move-object/from16 v16, v2

    .line 61
    :goto_1
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    const/16 v17, 0x0

    goto :goto_2

    :cond_3
    new-instance v7, Lio/dcloud/feature/ui/c$i;

    invoke-direct {v7, v0, v1, v5}, Lio/dcloud/feature/ui/c$i;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    move-object/from16 v17, v7

    .line 62
    :goto_2
    invoke-interface/range {v8 .. v17}, Lio/dcloud/common/DHInterface/IFrameView;->draw(Landroid/view/View;Lio/dcloud/common/DHInterface/INativeBitmap;ZZZLandroid/graphics/Rect;Ljava/lang/String;Lio/dcloud/common/DHInterface/ICallBack;Lio/dcloud/common/DHInterface/ICallBack;)V

    return-void
.end method

.method private d(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V
    .locals 6

    const/4 v0, 0x0

    .line 3
    invoke-static {p2, v0}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    .line 4
    invoke-static {p2, v2}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v3

    .line 5
    iget-object v4, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v4, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v4}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v4

    .line 6
    invoke-static {v3}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 7
    iget v5, v4, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    invoke-static {v3, v5}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v3

    iput v3, v4, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    goto :goto_0

    .line 9
    :cond_0
    iget v3, v4, Lio/dcloud/common/adapter/util/AnimOptions;->duration_show:I

    iput v3, v4, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    .line 13
    :goto_0
    invoke-virtual {v4, v1}, Lio/dcloud/common/adapter/util/AnimOptions;->setCloseAnimType(Ljava/lang/String;)V

    const/4 v3, 0x3

    .line 14
    iput-byte v3, v4, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    .line 15
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "NWindow.hide view="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "View_Visible_Path"

    invoke-static {v4, v3}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    iget-boolean v3, p3, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v3, :cond_2

    .line 18
    invoke-direct {p3}, Lio/dcloud/feature/ui/c;->k()Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x2

    .line 21
    invoke-static {p2, v3}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object p2

    .line 22
    invoke-direct {p0, p1, p2, p3, v1}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    .line 23
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p1, p1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object p2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v1, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/16 v3, 0x17

    invoke-interface {p1, p2, v3, v1}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 25
    :cond_1
    const-string p1, "hide"

    const/4 p2, 0x0

    invoke-virtual {p0, p1, p2}, Lio/dcloud/feature/ui/c;->onCallBack(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    iget-object p1, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1, v0, v2}, Lio/dcloud/common/DHInterface/IFrameView;->setVisible(ZZ)V

    .line 28
    :goto_1
    iput-boolean v0, p3, Lio/dcloud/feature/ui/c;->F:Z

    goto :goto_2

    .line 31
    :cond_2
    iget-object p1, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1, v0, v2}, Lio/dcloud/common/DHInterface/IFrameView;->setVisible(ZZ)V

    .line 33
    :goto_2
    iput-boolean v2, p3, Lio/dcloud/feature/ui/c;->G:Z

    return-void
.end method

.method private e(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V
    .locals 20

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p3

    const-string v4, "isUniH5"

    const-string v5, "debugRefresh"

    const-string v6, "animationAlphaBGColor"

    .line 2
    iget-boolean v0, v3, Lio/dcloud/feature/ui/c;->J:Z

    if-nez v0, :cond_22

    .line 4
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    move-object v7, v0

    check-cast v7, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    .line 5
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v8

    const/4 v9, 0x0

    move-object/from16 v0, p2

    .line 6
    invoke-static {v0, v9}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v10

    .line 9
    iget-object v0, v8, Lio/dcloud/common/adapter/util/ViewOptions;->isTabItem:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    const-string v11, "background"

    const/4 v12, 0x1

    if-eqz v0, :cond_0

    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 11
    :try_start_0
    invoke-static {v10, v11}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 12
    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 13
    const-string v13, "tabBGColor"

    invoke-virtual {v10, v13, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v13, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    .line 16
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_0
    const/4 v13, 0x0

    .line 20
    :goto_0
    invoke-virtual {v1, v10, v12}, Lio/dcloud/feature/ui/c;->a(Lorg/json/JSONObject;Z)Z

    move-result v14

    .line 21
    invoke-virtual {v10, v11}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v15

    if-nez v15, :cond_1

    .line 24
    invoke-static {v10, v11}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v12, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v0, v12}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 25
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_1

    const-string v12, "transparent"

    invoke-virtual {v0, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_1

    :cond_1
    const/4 v0, 0x0

    .line 29
    :goto_1
    const-string/jumbo v12, "webviewBGTransparent"

    invoke-virtual {v10, v12}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v16

    if-nez v16, :cond_2

    .line 30
    invoke-static {v10, v12}, Lio/dcloud/common/util/JSONUtil;->getBoolean(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 31
    iget-object v12, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v12}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v12

    check-cast v12, Lio/dcloud/common/adapter/ui/AdaWebview;

    invoke-virtual {v12, v9}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setBgcolor(I)V

    .line 34
    :cond_2
    iget-boolean v12, v3, Lio/dcloud/feature/ui/c;->K:Z

    const/16 v16, 0x0

    if-nez v12, :cond_4

    if-nez v15, :cond_3

    if-nez v0, :cond_3

    goto :goto_2

    :cond_3
    const/16 v17, 0x0

    goto/16 :goto_7

    :cond_4
    :goto_2
    if-nez v15, :cond_8

    .line 37
    :try_start_1
    invoke-static {v10, v11}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 38
    invoke-virtual {v10, v6}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_5

    .line 39
    iget-object v12, v8, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    const/16 v17, 0x0

    :try_start_2
    invoke-static {v10, v6}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v12, v6, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_3

    :cond_5
    const/16 v17, 0x0

    .line 41
    :goto_3
    iget-object v6, v8, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;

    invoke-virtual {v6, v11, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 42
    invoke-virtual {v10, v5}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 43
    iget-object v0, v8, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;

    invoke-static {v10, v5}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 45
    :cond_6
    invoke-virtual {v10, v4}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 46
    iget-object v0, v8, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;

    invoke-static {v10, v4}, Lio/dcloud/common/util/JSONUtil;->getBoolean(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v5

    invoke-virtual {v0, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 48
    :cond_7
    iget-object v0, v8, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;

    invoke-virtual {v8, v0}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lorg/json/JSONObject;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_5

    :catch_1
    move-exception v0

    goto :goto_4

    :catch_2
    move-exception v0

    const/16 v17, 0x0

    .line 50
    :goto_4
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    goto :goto_5

    :cond_8
    const/16 v17, 0x0

    .line 54
    :goto_5
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget-object v0, v0, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    if-eqz v0, :cond_9

    .line 55
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget-object v0, v0, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    goto :goto_6

    :cond_9
    move-object/from16 v0, v16

    .line 57
    :goto_6
    iget-object v4, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v4}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v7

    if-eqz v0, :cond_a

    .line 58
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    iget-object v4, v4, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    if-nez v4, :cond_a

    .line 59
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    iput-object v0, v4, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    .line 61
    :cond_a
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/util/ViewRect;->getParentViewRect()Lio/dcloud/common/adapter/util/ViewRect;

    move-result-object v0

    if-nez v0, :cond_b

    .line 62
    iget-object v0, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v4, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v5, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v6, 0x1

    new-array v9, v6, [Ljava/lang/Object;

    aput-object v5, v9, v17

    const/16 v5, 0x4a

    invoke-interface {v0, v4, v5, v9}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 65
    :cond_b
    :goto_7
    invoke-virtual {v8}, Lio/dcloud/common/adapter/util/ViewOptions;->hasBackground()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 66
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v7

    .line 68
    :cond_c
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    const/4 v6, 0x1

    iput-boolean v6, v0, Lio/dcloud/common/adapter/util/ViewRect;->allowUpdate:Z

    .line 71
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    .line 72
    iget v5, v4, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    .line 75
    :try_start_3
    iget-object v0, v4, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    if-eqz v0, :cond_d

    .line 76
    new-instance v0, Lorg/json/JSONObject;

    iget-object v6, v4, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    invoke-virtual {v6}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_8

    :catch_3
    move-exception v0

    .line 79
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    :cond_d
    move-object/from16 v0, v16

    .line 82
    :goto_8
    invoke-virtual {v4}, Lio/dcloud/common/adapter/util/ViewRect;->getParentViewRect()Lio/dcloud/common/adapter/util/ViewRect;

    move-result-object v6

    invoke-static {v4, v6}, Lio/dcloud/common/adapter/util/ViewOptions;->createViewOptionsData(Lio/dcloud/common/adapter/util/ViewOptions;Lio/dcloud/common/adapter/util/ViewRect;)Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v6

    .line 83
    iget-object v8, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v8}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v8

    .line 84
    const-string v9, "shareable"

    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v8, v9, v11}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string/jumbo v9, "videoFullscreen"

    invoke-static {v10, v9}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_e

    .line 87
    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v8, v9, v11}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 90
    :cond_e
    const-string v9, "pullToRefresh"

    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_f

    .line 91
    invoke-static {v10, v9}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    .line 92
    iget-object v11, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v11}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v11

    iget-object v12, v4, Lio/dcloud/common/adapter/util/ViewOptions;->mPullToRefresh:Lorg/json/JSONObject;

    invoke-static {v12, v9}, Lio/dcloud/common/util/JSONUtil;->combinJSONObject(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;

    move-result-object v9

    const-string v12, "pull_down_refresh"

    invoke-interface {v11, v12, v9}, Lio/dcloud/common/DHInterface/IWebview;->setWebViewEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 96
    :cond_f
    const-string v9, "bounce"

    invoke-static {v10, v9}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_10

    .line 97
    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-interface {v8, v9, v11}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    :cond_10
    iget-object v9, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mCacheMode:Ljava/lang/String;

    invoke-interface {v2, v9}, Lio/dcloud/common/DHInterface/IWebview;->setWebViewCacheMode(Ljava/lang/String;)V

    .line 102
    iget-object v9, v1, Lio/dcloud/feature/ui/b;->h:Lorg/json/JSONObject;

    invoke-static {v9, v10}, Lio/dcloud/common/util/JSONUtil;->combinJSONObject(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;

    .line 104
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->f()V

    .line 106
    const-string v9, "titleNView"

    invoke-static {v10, v9}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_11

    .line 107
    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    invoke-direct {v1, v2, v3, v0, v9}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/feature/ui/c;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    goto :goto_9

    .line 109
    :cond_11
    const-string v9, "navigationbar"

    invoke-static {v10, v9}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_12

    .line 110
    invoke-virtual {v10, v9}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v9

    invoke-direct {v1, v2, v3, v0, v9}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/feature/ui/c;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    .line 113
    :cond_12
    :goto_9
    const-string/jumbo v0, "uniNView"

    invoke-static {v10, v0}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_13

    .line 114
    invoke-virtual {v10, v0}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-direct {v1, v3, v0}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/c;Lorg/json/JSONObject;)V

    .line 116
    :cond_13
    iget-boolean v0, v3, Lio/dcloud/feature/ui/c;->I:Z

    const-string v2, "geolocation"

    const-string v9, "plusrequire"

    const-string v11, "injection"

    const-string v12, "scalable"

    if-eqz v0, :cond_1f

    .line 117
    iget v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->background:I

    move/from16 v16, v0

    .line 119
    iget v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->opacity:F

    .line 120
    invoke-virtual {v6, v10}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lorg/json/JSONObject;)Z

    move-result v18

    move/from16 p1, v0

    .line 121
    invoke-static/range {v16 .. v16}, Lio/dcloud/common/util/PdrUtil;->checkAlphaTransparent(I)Z

    move-result v0

    move/from16 v16, v13

    iget v13, v6, Lio/dcloud/common/adapter/util/ViewOptions;->background:I

    invoke-static {v13}, Lio/dcloud/common/util/PdrUtil;->checkAlphaTransparent(I)Z

    move-result v13

    if-eq v0, v13, :cond_14

    const/4 v0, 0x1

    goto :goto_a

    :cond_14
    const/4 v0, 0x0

    .line 122
    :goto_a
    iget v13, v6, Lio/dcloud/common/adapter/util/ViewOptions;->opacity:F

    cmpl-float v13, p1, v13

    if-eqz v13, :cond_15

    const/4 v13, 0x1

    goto :goto_b

    :cond_15
    const/4 v13, 0x0

    :goto_b
    or-int/2addr v0, v13

    .line 124
    const-string v13, "render"

    invoke-virtual {v10, v13}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v19

    move/from16 p1, v0

    if-eqz v19, :cond_16

    .line 125
    const-string v0, "onscreen"

    invoke-virtual {v10, v13, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 126
    const-string v13, "always"

    invoke-static {v0, v13}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    .line 127
    iget-object v13, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v13, v0}, Lio/dcloud/common/DHInterface/IFrameView;->setNeedRender(Z)V

    .line 131
    :cond_16
    invoke-virtual {v6}, Lio/dcloud/common/adapter/util/ViewOptions;->hasBackground()Z

    move-result v0

    iput-boolean v0, v3, Lio/dcloud/feature/ui/c;->K:Z

    .line 133
    const-string v0, "scrollIndicator"

    invoke-static {v10, v0}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_17

    .line 134
    invoke-virtual {v6}, Lio/dcloud/common/adapter/util/ViewOptions;->getScrollIndicator()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v0}, Lio/dcloud/common/DHInterface/IWebview;->setScrollIndicator(Ljava/lang/String;)V

    .line 137
    :cond_17
    invoke-static {v10, v12}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_18

    .line 138
    iget-boolean v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->scalable:Z

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v12, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    :cond_18
    iget-object v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mInjection:Ljava/lang/String;

    invoke-interface {v8, v11, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    iget-object v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mPlusrequire:Ljava/lang/String;

    invoke-interface {v8, v9, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    iget-object v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mGeoInject:Ljava/lang/String;

    invoke-interface {v8, v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v0

    .line 147
    const-string v2, "transition"

    invoke-static {v10, v2}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_19

    .line 148
    iget-object v2, v6, Lio/dcloud/common/adapter/util/ViewOptions;->transition:Lorg/json/JSONObject;

    invoke-virtual {v0, v2}, Lio/dcloud/common/adapter/util/AnimOptions;->parseTransition(Lorg/json/JSONObject;)V

    .line 149
    iget-object v2, v6, Lio/dcloud/common/adapter/util/ViewOptions;->transition:Lorg/json/JSONObject;

    const-string v8, "duration"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1a

    const/4 v2, 0x0

    .line 150
    iput v2, v0, Lio/dcloud/common/adapter/util/AnimOptions;->duration:I

    goto :goto_c

    :cond_19
    const/4 v2, 0x0

    .line 153
    iput v2, v0, Lio/dcloud/common/adapter/util/AnimOptions;->duration:I

    .line 155
    :cond_1a
    :goto_c
    const-string v2, "transform"

    invoke-static {v10, v2}, Lio/dcloud/common/util/JSONUtil;->isNull(Lorg/json/JSONObject;Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1b

    .line 156
    iget-object v2, v6, Lio/dcloud/common/adapter/util/ViewOptions;->transform:Lorg/json/JSONObject;

    invoke-virtual {v0, v2}, Lio/dcloud/common/adapter/util/AnimOptions;->parseTransform(Lorg/json/JSONObject;)V

    :cond_1b
    if-nez v18, :cond_1d

    if-nez v14, :cond_1d

    if-eqz p1, :cond_1c

    goto :goto_d

    .line 169
    :cond_1c
    invoke-virtual {v4, v10}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lorg/json/JSONObject;)Z

    .line 170
    iget v0, v6, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    if-eq v5, v0, :cond_20

    .line 171
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget v2, v6, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    iput v2, v0, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    .line 172
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget v2, v6, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    iput v2, v0, Lio/dcloud/common/adapter/util/ViewOptions;->maskColor:I

    .line 173
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->invalidate()V

    goto/16 :goto_e

    .line 174
    :cond_1d
    :goto_d
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0, v6}, Lio/dcloud/common/DHInterface/IFrameView;->setFrameOptions_Animate(Lio/dcloud/common/adapter/util/ViewOptions;)V

    .line 176
    invoke-virtual {v7, v6}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setFrameOptions_Animate(Lio/dcloud/common/adapter/util/ViewOptions;)V

    .line 178
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v0

    const/4 v2, 0x2

    iput-byte v2, v0, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    .line 179
    iget-object v0, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    if-eqz v18, :cond_1e

    const/4 v14, 0x0

    :cond_1e
    invoke-static {v14}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static/range {p1 .. p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/16 v17, 0x0

    aput-object v0, v7, v17

    const/4 v8, 0x1

    aput-object v4, v7, v8

    aput-object v5, v7, v2

    const/4 v0, 0x3

    aput-object v6, v7, v0

    .line 180
    iget-object v0, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    const/4 v4, 0x7

    invoke-interface {v0, v2, v4, v7}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_e

    :cond_1f
    move/from16 v16, v13

    .line 191
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    invoke-virtual {v0, v10}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lorg/json/JSONObject;)Z

    move-result v0

    .line 192
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions_Birth()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    invoke-virtual {v4, v10}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lorg/json/JSONObject;)Z

    .line 194
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v4

    .line 195
    invoke-virtual {v4}, Lio/dcloud/common/adapter/util/ViewOptions;->getScrollIndicator()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v8, v5}, Lio/dcloud/common/DHInterface/IWebview;->setScrollIndicator(Ljava/lang/String;)V

    .line 197
    iget-boolean v4, v4, Lio/dcloud/common/adapter/util/ViewOptions;->scalable:Z

    invoke-static {v4}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v8, v12, v4}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 199
    iget-object v4, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mInjection:Ljava/lang/String;

    invoke-interface {v8, v11, v4}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    iget-object v4, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mPlusrequire:Ljava/lang/String;

    invoke-interface {v8, v9, v4}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    iget-object v4, v6, Lio/dcloud/common/adapter/util/ViewOptions;->mGeoInject:Ljava/lang/String;

    invoke-interface {v8, v2, v4}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v0, :cond_20

    .line 205
    invoke-virtual {v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    .line 206
    iget v2, v0, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    .line 213
    iget-object v2, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v2

    .line 216
    iget v4, v0, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    iget v5, v0, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    iget v6, v0, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    iget v0, v0, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    invoke-static {v2, v4, v5, v6, v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem$LayoutParamsUtil;->setViewLayoutParams(Landroid/view/View;IIII)V

    :cond_20
    :goto_e
    if-eqz v15, :cond_21

    if-eqz v16, :cond_22

    .line 220
    :cond_21
    iget-object v0, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v3, v3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v6, 0x1

    new-array v4, v6, [Ljava/lang/Object;

    const/16 v17, 0x0

    aput-object v3, v4, v17

    const/16 v3, 0x4b

    invoke-interface {v0, v2, v3, v4}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    :cond_22
    return-void
.end method

.method private g(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)Lio/dcloud/common/DHInterface/INativeBitmap;
    .locals 4

    .line 1
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v0

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    .line 2
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IApp;->obtainAppId()Ljava/lang/String;

    move-result-object v2

    filled-new-array {v2, p2}, [Ljava/lang/String;

    move-result-object p2

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    const-string p1, "nativeobj"

    const/4 v3, 0x1

    aput-object p1, v2, v3

    const-string p1, "getNativeBitmap"

    const/4 v3, 0x2

    aput-object p1, v2, v3

    const/4 p1, 0x3

    aput-object p2, v2, p1

    const/16 p1, 0xa

    .line 3
    invoke-interface {v0, v1, p1, v2}, Lio/dcloud/common/DHInterface/IApp;->obtainMgrData(Lio/dcloud/common/DHInterface/IMgr$MgrType;I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lio/dcloud/common/DHInterface/INativeBitmap;

    return-object p1
.end method

.method private i()V
    .locals 4

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->getFrameType()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_0

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->f:Lio/dcloud/common/DHInterface/IApp;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IApp;->obtainAppId()Ljava/lang/String;

    move-result-object v0

    .line 3
    iget-object v1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v1, v1, Lio/dcloud/feature/ui/a;->f:Lio/dcloud/common/DHInterface/IApp;

    const-string v2, "adid"

    invoke-interface {v1, v2}, Lio/dcloud/common/DHInterface/IApp;->obtainConfigProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 4
    invoke-static {}, Lio/dcloud/common/util/ThreadPool;->self()Lio/dcloud/common/util/ThreadPool;

    move-result-object v2

    new-instance v3, Lio/dcloud/feature/ui/c$j;

    invoke-direct {v3, p0, v0, v1}, Lio/dcloud/feature/ui/c$j;-><init>(Lio/dcloud/feature/ui/c;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lio/dcloud/common/util/ThreadPool;->addThreadTask(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method private j()V
    .locals 4

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v0

    .line 2
    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_1

    .line 3
    check-cast v0, Landroid/view/ViewGroup;

    const/4 v1, 0x0

    .line 4
    :goto_0
    invoke-virtual {v0}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 5
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 6
    instance-of v3, v2, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_0

    .line 7
    invoke-virtual {v2}, Landroid/view/View;->bringToFront()V

    return-void

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    return-void
.end method

.method private k()Z
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    .line 2
    iget-boolean v2, v0, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v2, :cond_0

    invoke-direct {v0}, Lio/dcloud/feature/ui/c;->k()Z

    move-result v0

    if-eqz v0, :cond_0

    return v1

    :cond_0
    const/4 v0, 0x0

    return v0

    :cond_1
    return v1
.end method

.method private s()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v0, p0}, Lio/dcloud/feature/ui/a;->b(Lio/dcloud/feature/ui/c;)V

    .line 2
    iget-boolean v0, p0, Lio/dcloud/feature/ui/c;->I:Z

    if-eqz v0, :cond_2

    .line 3
    iget-boolean v0, p0, Lio/dcloud/feature/ui/c;->J:Z

    if-nez v0, :cond_3

    .line 4
    iget-boolean v0, p0, Lio/dcloud/feature/ui/c;->L:Z

    if-eqz v0, :cond_1

    .line 5
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    if-eqz v0, :cond_0

    .line 6
    invoke-virtual {v0, p0}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/feature/ui/b;)V

    .line 9
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->onDispose()Z

    .line 10
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->dispose()V

    goto :goto_0

    .line 12
    :cond_1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v0

    const/4 v1, 0x1

    .line 13
    iput-byte v1, v0, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    goto :goto_0

    .line 17
    :cond_2
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->onDispose()Z

    .line 18
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->dispose()V

    .line 21
    :cond_3
    :goto_0
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->e()V

    return-void
.end method

.method private t()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v0

    const/4 v1, 0x3

    .line 2
    iput-byte v1, v0, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    const/4 v0, 0x0

    .line 3
    iput-boolean v0, p0, Lio/dcloud/feature/ui/c;->F:Z

    const/4 v0, 0x1

    .line 4
    iput-boolean v0, p0, Lio/dcloud/feature/ui/c;->G:Z

    return-void
.end method


# virtual methods
.method public a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Lorg/json/JSONArray;)Ljava/lang/String;
    .locals 27

    move-object/from16 v1, p0

    move-object/from16 v0, p2

    move-object/from16 v2, p3

    const-string v3, "titleUpdate"

    const-string v4, "needTouchEvent"

    const-string v5, "getFavoriteOptions"

    const-string v6, "setShareOptions"

    const-string v7, "getShareOptions"

    const-string v8, "setFavoriteOptions"

    const-string v9, "tabBGColor"

    const-string v10, "NWindow.load "

    const-string v11, "refreshLoadingViewsSize setPullToRefresh args="

    .line 227
    :try_start_0
    invoke-interface/range {p1 .. p1}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v13

    invoke-interface {v13}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v13

    .line 228
    invoke-interface {v13}, Lio/dcloud/common/DHInterface/IApp;->obtainAppId()Ljava/lang/String;

    move-result-object v14

    .line 229
    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v15
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    const-string v16, "nativeobj"

    const/16 v17, 0x0

    const-string v12, ""

    move/from16 v18, v15

    const-string v19, "undefined"

    const-string v15, "pull_down_refresh"

    move-object/from16 v20, v8

    const-string/jumbo v8, "{\'uuid\':%s,\'id\':%s}"

    move-object/from16 v21, v8

    const-string v8, "bounce_register"

    move-object/from16 v22, v3

    const-string v3, "overrideUrlLoading"

    move-object/from16 v23, v13

    const/4 v13, 0x0

    sparse-switch v18, :sswitch_data_0

    :cond_0
    const/16 v17, 0x0

    goto/16 :goto_c

    :sswitch_0
    :try_start_1
    const-string v2, "isPause"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 912
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_19

    .line 914
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->isPause()Z

    move-result v0

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 915
    :sswitch_1
    const-string v3, "getMetrics"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 969
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v3

    .line 970
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->n()Ljava/lang/String;

    move-result-object v4

    .line 971
    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object/from16 v2, p1

    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v17

    .line 972
    :sswitch_2
    const-string v2, "getTitle"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 1355
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainPageTitle()Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x1

    invoke-static {v0, v2}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_3
    move-object/from16 v3, p1

    .line 1356
    const-string/jumbo v4, "webview_animate"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 1952
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 1953
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    .line 1954
    iget-object v4, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v4, v3, v0, v2}, Lio/dcloud/common/DHInterface/IFrameView;->animate(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;)V

    return-object v17

    .line 1955
    :sswitch_4
    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 2523
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 2524
    const-string v2, "true"

    invoke-interface {v0, v4, v2}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 2648
    const-string v0, "false"

    return-object v0

    .line 2649
    :sswitch_5
    const-string v3, "loadData"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 3071
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 3072
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v2

    .line 3073
    const-string v3, "text/html"

    .line 3074
    const-string/jumbo v4, "utf-8"

    if-eqz v2, :cond_1

    .line 3077
    const-string v5, "encoding"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v4}, Lio/dcloud/common/util/PdrUtil;->getNonString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 3078
    const-string v5, "mimeType"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v3}, Lio/dcloud/common/util/PdrUtil;->getNonString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 3079
    const-string v5, "baseURL"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v12}, Lio/dcloud/common/util/PdrUtil;->getNonString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 3081
    :cond_1
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v12, v0, v3, v4}, Lio/dcloud/common/DHInterface/IWebview;->loadContentData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v17

    .line 3082
    :sswitch_6
    const-string v3, "setTitleNViewSearchInputText"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 3395
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 3396
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 3397
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_19

    .line 3398
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/common/util/TitleNViewUtil;->setTitleNViewSearchInputText(Lio/dcloud/common/DHInterface/ITitleNView;Ljava/lang/String;)V

    return-object v17

    .line 3399
    :sswitch_7
    const-string v2, "children"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 3817
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-static {v0}, Lio/dcloud/feature/ui/c;->a(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 3818
    :sswitch_8
    const-string v3, "setPullToRefresh"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 3820
    const-string v0, "View_Visible_Path"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 3821
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v0

    const/4 v4, 0x1

    .line 3822
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    .line 3823
    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 3824
    iput-object v2, v1, Lio/dcloud/feature/ui/c;->U:Ljava/lang/String;

    .line 3826
    :cond_2
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v15, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebViewEvent(Ljava/lang/String;Ljava/lang/Object;)V

    return-object v17

    .line 3827
    :sswitch_9
    const-string v3, "removeTitleNViewButtonBadge"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 4108
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 4109
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 4110
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_19

    .line 4111
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    invoke-static {v0, v2, v13}, Lio/dcloud/common/util/TitleNViewUtil;->titleNViewButtonBadge(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Z)V

    return-object v17

    :sswitch_a
    move-object/from16 v3, p1

    .line 4112
    const-string v4, "appendNativeView"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    const/4 v4, 0x1

    .line 4577
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 4578
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    .line 4579
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v4

    sparse-switch v4, :sswitch_data_1

    goto :goto_0

    :sswitch_b
    const-string v4, "Maps"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 4581
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->d(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 4582
    invoke-direct {v1}, Lio/dcloud/feature/ui/c;->j()V

    return-object v17

    .line 4583
    :sswitch_c
    const-string v4, "Ad"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 4601
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 4602
    invoke-direct {v1}, Lio/dcloud/feature/ui/c;->j()V

    return-object v17

    .line 4603
    :sswitch_d
    const-string v4, "barcode"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 4609
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 4610
    invoke-direct {v1}, Lio/dcloud/feature/ui/c;->j()V

    return-object v17

    .line 4611
    :sswitch_e
    const-string v4, "LivePusher"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 4625
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 4626
    invoke-direct {v1}, Lio/dcloud/feature/ui/c;->j()V

    return-object v17

    .line 4627
    :sswitch_f
    const-string v4, "VideoPlayer"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 4637
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->f(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 4638
    invoke-direct {v1}, Lio/dcloud/feature/ui/c;->j()V

    return-object v17

    .line 4649
    :cond_3
    :goto_0
    invoke-virtual {v1, v3, v0}, Lio/dcloud/feature/ui/c;->e(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    return-object v17

    :sswitch_10
    move-object/from16 v3, p1

    .line 4650
    const-string v4, "setStyle"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    move-object v4, v3

    goto/16 :goto_1

    .line 4651
    :sswitch_11
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 5295
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v5}, Lio/dcloud/common/DHInterface/IWebview;->getWebviewProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 5296
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_19

    .line 5297
    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 5298
    :sswitch_12
    const-string v3, "showTitleNViewButtonRedDot"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 5587
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 5588
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 5589
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_19

    .line 5590
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const/4 v4, 0x1

    invoke-static {v0, v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->titleNViewButtonRedDot(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Z)V

    return-object v17

    .line 5591
    :sswitch_13
    const-string v3, "findViewById"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 5969
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 5970
    invoke-virtual {v1, v0}, Lio/dcloud/feature/ui/c;->c(Ljava/lang/String;)Lio/dcloud/feature/ui/b;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/feature/ui/b;->h()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 5971
    :sswitch_14
    const-string v3, "setFixBottom"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 6492
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 6493
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getInt(I)I

    move-result v2

    int-to-float v2, v2

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->getScale()F

    move-result v3

    mul-float v2, v2, v3

    float-to-int v2, v2

    invoke-interface {v0, v2}, Lio/dcloud/common/DHInterface/IWebview;->setFixBottom(I)V

    return-object v17

    .line 6494
    :sswitch_15
    const-string v3, "setVolumeButtonEnabled"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 6760
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 6761
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_19

    .line 6762
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    sput-boolean v0, Lio/dcloud/common/adapter/util/DeviceInfo;->isVolumeButtonEnabled:Z

    return-object v17

    .line 6763
    :sswitch_16
    const-string v3, "setBlockNetworkImage"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 6792
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 6793
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    const-string v3, "blockNetworkImage"

    invoke-interface {v2, v3, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-object v17

    .line 6794
    :sswitch_17
    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 7445
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 7446
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v6, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    return-object v17

    .line 7447
    :sswitch_18
    const-string v3, "overrideResourceRequest"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 7534
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONArray(I)Lorg/json/JSONArray;

    move-result-object v0

    .line 7535
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->setOverrideResourceRequest(Lorg/json/JSONArray;)V

    return-object v17

    .line 7536
    :sswitch_19
    const-string v2, "getOption"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 7570
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    .line 7571
    invoke-virtual {v0}, Lio/dcloud/common/adapter/util/ViewOptions;->hasBackground()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 7572
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    .line 7574
    :cond_4
    new-instance v2, Lorg/json/JSONObject;

    iget-object v0, v0, Lio/dcloud/common/adapter/util/ViewRect;->mJsonViewOption:Lorg/json/JSONObject;

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 7576
    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 7577
    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 7578
    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->remove(Ljava/lang/String;)Ljava/lang/Object;

    .line 7579
    const-string v3, "background"

    invoke-virtual {v2, v3, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 7581
    :cond_5
    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 7582
    :sswitch_1a
    const-string/jumbo v3, "updateSubNViews"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 8215
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    instance-of v3, v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    if-eqz v3, :cond_19

    .line 8216
    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/common/util/SubNViewsUtil;->updateSubNViews(Lio/dcloud/common/adapter/ui/AdaFrameView;Lorg/json/JSONArray;)V

    return-object v17

    :sswitch_1b
    move-object/from16 v3, p1

    .line 8217
    const-string v4, "canBack"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 8412
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v3

    .line 8413
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 8414
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->canGoBack()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object/from16 v2, p1

    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    return-object v17

    .line 8415
    :sswitch_1c
    const-string v2, "getTitleNViewSearchInputText"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 8736
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 8737
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v2, v2, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    iget-object v4, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v2, v3, v4, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 8738
    instance-of v2, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v2, :cond_19

    .line 8739
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewSearchInputText(Lio/dcloud/common/DHInterface/ITitleNView;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_1d
    move-object/from16 v4, p1

    .line 8740
    const-string v3, "setOption"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 8790
    :goto_1
    invoke-direct {v1, v4, v2, v1}, Lio/dcloud/feature/ui/c;->e(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    return-object v17

    .line 8791
    :sswitch_1e
    const-string v2, "endPullToRefresh"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 8807
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v15}, Lio/dcloud/common/DHInterface/IWebview;->endWebViewEvent(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    return-object v17

    :catch_0
    move-exception v0

    goto/16 :goto_d

    .line 8808
    :sswitch_1f
    :try_start_2
    const-string v3, "showBehind"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v4, 0x1

    .line 9389
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 9390
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v2, v0}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;)Lio/dcloud/feature/ui/b;

    move-result-object v2

    if-nez v2, :cond_0

    .line 9392
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    move-object/from16 v3, v17

    invoke-virtual {v2, v0, v0, v3}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v0

    .line 9394
    invoke-direct {v1, v0, v1, v14}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/b;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    return-object v3

    .line 9395
    :sswitch_20
    const-string v2, "pause"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10064
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 10066
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->pause()V

    const/16 v17, 0x0

    return-object v17

    .line 10067
    :sswitch_21
    const-string v3, "setBounce"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10087
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v0

    .line 10088
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v8, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebViewEvent(Ljava/lang/String;Ljava/lang/Object;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_22
    move-object/from16 v4, p1

    .line 10089
    const-string v3, "close"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10196
    invoke-virtual {v1, v4, v2, v1}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    const/16 v17, 0x0

    return-object v17

    .line 10197
    :sswitch_23
    const-string v2, "clear"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10404
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 10405
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->clearHistory()V

    const/16 v17, 0x0

    return-object v17

    :sswitch_24
    move-object/from16 v4, p1

    .line 10406
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10498
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const/4 v3, 0x1

    .line 10499
    invoke-virtual {v2, v3}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lio/dcloud/feature/ui/c;->Q:Ljava/lang/String;

    .line 10500
    iput-object v4, v1, Lio/dcloud/feature/ui/c;->R:Lio/dcloud/common/DHInterface/IWebview;

    .line 10501
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->setOverrideUrlLoadingData(Lorg/json/JSONObject;)V

    const/16 v17, 0x0

    return-object v17

    .line 10502
    :sswitch_25
    const-string v2, "stop"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10747
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->stopLoading()V

    const/16 v17, 0x0

    return-object v17

    :sswitch_26
    move-object/from16 v4, p1

    .line 10748
    const-string v3, "show"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 10851
    invoke-virtual {v1, v4, v2, v1, v14}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 10852
    :sswitch_27
    const-string v4, "load"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 11064
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 11066
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainUrl()Ljava/lang/String;

    move-result-object v4

    .line 11067
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x2

    .line 11068
    invoke-static {v2, v6}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v2

    .line 11069
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameView()Lio/dcloud/common/DHInterface/IFrameView;

    move-result-object v6

    invoke-interface {v6}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v6

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7, v5}, Lio/dcloud/common/DHInterface/IApp;->convert2WebviewFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 11070
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;)V

    if-eqz v2, :cond_6

    .line 11072
    invoke-virtual {v2}, Lorg/json/JSONObject;->length()I

    move-result v7

    if-lez v7, :cond_6

    .line 11073
    new-instance v7, Ljava/util/HashMap;

    invoke-virtual {v2}, Lorg/json/JSONObject;->length()I

    move-result v8

    invoke-direct {v7, v8}, Ljava/util/HashMap;-><init>(I)V

    .line 11074
    invoke-virtual {v2}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v8

    .line 11075
    :goto_2
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_7

    .line 11076
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 11077
    invoke-virtual {v2, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v9, v10}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    :cond_6
    const/4 v7, 0x0

    .line 11081
    :cond_7
    instance-of v2, v0, Lio/dcloud/common/adapter/ui/AdaWebview;

    if-eqz v2, :cond_8

    .line 11082
    move-object v2, v0

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaWebview;

    invoke-virtual {v2, v6}, Lio/dcloud/common/adapter/ui/AdaWebview;->checkOverrideUrl(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 11083
    check-cast v0, Lio/dcloud/common/adapter/ui/AdaWebview;

    iget-object v0, v0, Lio/dcloud/common/adapter/ui/AdaWebview;->mFrameView:Lio/dcloud/common/adapter/ui/AdaFrameView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "{url:\'"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "\'}"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v3, v2}, Lio/dcloud/common/adapter/ui/AdaFrameView;->dispatchFrameViewEvents(Ljava/lang/String;Ljava/lang/Object;)V

    const/16 v17, 0x0

    return-object v17

    .line 11088
    :cond_8
    invoke-interface {v0, v5, v7}, Lio/dcloud/common/DHInterface/IWebview;->setLoadURLHeads(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 11089
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v5}, Lio/dcloud/common/DHInterface/IWebview;->setOriginalUrl(Ljava/lang/String;)V

    .line 11090
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v6}, Lio/dcloud/common/DHInterface/IWebview;->reload(Ljava/lang/String;)V

    .line 11092
    invoke-direct {v1, v1, v4}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_28
    move-object/from16 v4, p1

    .line 11093
    const-string v3, "hide"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 11192
    invoke-direct {v1, v4, v2, v1}, Lio/dcloud/feature/ui/c;->d(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_29
    move-object/from16 v4, p1

    .line 11193
    const-string v3, "draw"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 11697
    invoke-direct {v1, v4, v2, v1}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_2a
    move-object/from16 v4, p1

    .line 11698
    const-string v3, "drag"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 12238
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v3

    move-object v5, v4

    const/4 v0, 0x1

    .line 12239
    invoke-static {v2, v0}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v4

    const/4 v6, 0x2

    .line 12240
    invoke-static {v2, v6}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v6, 0x3

    .line 12241
    invoke-static {v2, v6}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    if-eqz v3, :cond_0

    .line 12244
    const-string v6, "direction"

    invoke-static {v3, v6}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    const-string v6, "moveMode"

    invoke-static {v3, v6}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 12245
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v6

    invoke-virtual {v6}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v6

    .line 12247
    const-string/jumbo v7, "view"

    invoke-static {v4, v7}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 12248
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_9

    .line 12249
    iget-object v8, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v8, v12, v7, v7}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v8

    goto :goto_3

    :cond_9
    const/4 v8, 0x0

    :goto_3
    if-nez v8, :cond_a

    .line 12253
    iget-object v9, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v9, v9, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v10, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v11, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v12, 0x2

    new-array v14, v12, [Ljava/lang/Object;

    aput-object v11, v14, v13

    const/16 v26, 0x1

    aput-object v7, v14, v26

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v5, v7, v13

    aput-object v16, v7, v26

    const-string v5, "getNativeView"

    const/16 v25, 0x2

    aput-object v5, v7, v25

    const/16 v24, 0x3

    aput-object v14, v7, v24

    const/16 v5, 0xa

    invoke-interface {v9, v10, v5, v7}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_a

    .line 12254
    instance-of v7, v5, Landroid/view/View;

    if-eqz v7, :cond_a

    .line 12255
    check-cast v5, Landroid/view/View;

    goto :goto_4

    :cond_a
    const/4 v5, 0x0

    .line 12258
    :goto_4
    iget-object v7, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v7, v0, v0, v0}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v0

    if-nez v8, :cond_b

    const/4 v7, 0x0

    goto :goto_5

    .line 12259
    :cond_b
    iget-object v7, v8, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    :goto_5
    if-nez v0, :cond_c

    const/4 v0, 0x0

    goto :goto_6

    .line 12260
    :cond_c
    iget-object v0, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    :goto_6
    move-object v8, v5

    move-object v5, v7

    if-eqz v2, :cond_d

    move-object v7, v2

    goto :goto_7

    :cond_d
    const/4 v7, 0x0

    :goto_7
    move-object v2, v6

    move-object v6, v0

    .line 12261
    invoke-virtual/range {v2 .. v8}, Lio/dcloud/common/adapter/util/ViewOptions;->setDragData(Lorg/json/JSONObject;Lorg/json/JSONObject;Lio/dcloud/common/DHInterface/IFrameView;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;Landroid/view/View;)V

    const/16 v17, 0x0

    return-object v17

    .line 12262
    :sswitch_2b
    const-string v2, "back"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 12445
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 12446
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->stopLoading()V

    const/4 v2, -0x1

    .line 12447
    invoke-interface {v0, v2}, Lio/dcloud/common/DHInterface/IWebview;->goBackOrForward(I)V

    const/16 v17, 0x0

    return-object v17

    .line 12448
    :sswitch_2c
    const-string v2, "beginPullToRefresh"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 12460
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    const-string v2, "pull_down_refresh_begin"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Lio/dcloud/common/DHInterface/IWebview;->setWebViewEvent(Ljava/lang/String;Ljava/lang/Object;)V

    return-object v3

    .line 12461
    :sswitch_2d
    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 13117
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v7}, Lio/dcloud/common/DHInterface/IWebview;->getWebviewProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 13118
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 13119
    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 13120
    :sswitch_2e
    const-string v2, "isVisible"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 13481
    iget-boolean v0, v1, Lio/dcloud/feature/ui/c;->F:Z

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_2f
    move-object/from16 v5, p1

    .line 13482
    const-string v3, "removeNativeView"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v4, 0x1

    .line 13918
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 13919
    invoke-virtual {v1, v5, v0}, Lio/dcloud/feature/ui/c;->h(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 13920
    :sswitch_30
    const-string v3, "setCssText"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 14494
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 14495
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 14496
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v3, v0}, Lio/dcloud/common/DHInterface/IWebview;->setCssFile(Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    :sswitch_31
    move-object/from16 v5, p1

    .line 14497
    const-string v3, "setCssFile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 15010
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 15011
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 15012
    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v3, v23

    invoke-interface {v3, v2, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2LocalFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 15013
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, v0, v3}, Lio/dcloud/common/DHInterface/IWebview;->setCssFile(Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    .line 15014
    :sswitch_32
    const-string v3, "evalJSSync"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 15159
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v3

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v5

    cmp-long v0, v3, v5

    if-nez v0, :cond_e

    const/16 v26, 0x1

    goto :goto_8

    :cond_e
    const/16 v26, 0x0

    .line 15160
    :goto_8
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 15161
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    if-eqz v26, :cond_f

    .line 15163
    new-instance v3, Lio/dcloud/feature/ui/c$c;

    invoke-direct {v3, v1, v2, v0}, Lio/dcloud/feature/ui/c$c;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v3}, Lio/dcloud/common/adapter/util/MessageHandler;->post(Ljava/lang/Runnable;)V

    const/16 v17, 0x0

    return-object v17

    .line 15172
    :cond_f
    new-instance v3, Lio/dcloud/feature/ui/c$d;

    invoke-direct {v3, v1, v2, v0}, Lio/dcloud/feature/ui/c$d;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v3}, Lio/dcloud/common/adapter/util/MessageHandler;->postAndWait(Lio/dcloud/common/adapter/util/MessageHandler$UncheckedCallable;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 15192
    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 15193
    :sswitch_33
    const-string/jumbo v2, "webview_restore"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 15795
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->restore()V

    const/16 v17, 0x0

    return-object v17

    .line 15796
    :sswitch_34
    const-string v3, "setContentVisible"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 16167
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v0

    .line 16168
    iput-boolean v0, v1, Lio/dcloud/feature/ui/c;->H:Z

    .line 16169
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    if-eqz v0, :cond_10

    sget v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;->VISIBLE:I

    goto :goto_9

    .line 16170
    :cond_10
    sget v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;->GONE:I

    :goto_9
    invoke-virtual {v2, v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setVisibility(I)V

    .line 16171
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v0

    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setBgcolor(I)V

    const/16 v17, 0x0

    return-object v17

    .line 16172
    :sswitch_35
    const-string v3, "clearSnapshot"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 16671
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 16672
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IFrameView;->clearSnapshot(Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 16673
    :sswitch_36
    const-string v2, "hideSoftKeybord"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 16927
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/adapter/util/DeviceInfo;->hideIME(Landroid/view/View;)V

    const/16 v17, 0x0

    return-object v17

    .line 16928
    :sswitch_37
    const-string v3, "removeEventListener"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 17283
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 17284
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 17285
    invoke-virtual {v1, v2, v0}, Lio/dcloud/feature/ui/b;->b(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 17286
    :sswitch_38
    const-string v2, "getSubNViews"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 17903
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    instance-of v2, v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    if-eqz v2, :cond_0

    .line 17904
    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    .line 17905
    iget-object v2, v0, Lio/dcloud/common/adapter/ui/AdaContainerFrameItem;->mChildNativeViewList:Ljava/util/ArrayList;

    if-eqz v2, :cond_12

    .line 17907
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 17908
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v4, 0x0

    :goto_a
    if-ge v4, v3, :cond_11

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    add-int/lit8 v4, v4, 0x1

    check-cast v5, Lio/dcloud/common/DHInterface/INativeView;

    .line 17909
    invoke-interface {v5}, Lio/dcloud/common/DHInterface/INativeView;->toJSON()Lorg/json/JSONObject;

    move-result-object v5

    invoke-virtual {v0, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_a

    .line 17911
    :cond_11
    invoke-virtual {v0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 17912
    :cond_12
    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v2

    iget-object v2, v2, Lio/dcloud/common/adapter/util/ViewOptions;->mSubNViews:Lorg/json/JSONArray;

    if-eqz v2, :cond_0

    .line 17913
    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    iget-object v0, v0, Lio/dcloud/common/adapter/util/ViewOptions;->mSubNViews:Lorg/json/JSONArray;

    invoke-virtual {v0}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_39
    move-object/from16 v5, p1

    .line 17914
    const-string v3, "addEventListener"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 18259
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 18260
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 18261
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->b:Ljava/util/HashMap;

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->getWebviewANID()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v1, v2, v0, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 18262
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IWebview;->unReceiveTitle()Z

    move-result v2

    if-nez v2, :cond_0

    move-object/from16 v2, v22

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 18263
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lio/dcloud/feature/ui/c;->onCallBack(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    const/16 v17, 0x0

    return-object v17

    .line 18264
    :sswitch_3a
    const-string v2, "forward"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 18453
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 18454
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->stopLoading()V

    const/4 v4, 0x1

    .line 18455
    invoke-interface {v0, v4}, Lio/dcloud/common/DHInterface/IWebview;->goBackOrForward(I)V

    const/16 v17, 0x0

    return-object v17

    .line 18456
    :sswitch_3b
    const-string v3, "setVisible"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 18821
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v0

    .line 18822
    iput-boolean v0, v1, Lio/dcloud/feature/ui/c;->F:Z

    .line 18823
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v4, 0x1

    invoke-interface {v2, v0, v4}, Lio/dcloud/common/DHInterface/IFrameView;->setVisible(ZZ)V

    const/16 v17, 0x0

    return-object v17

    .line 18824
    :sswitch_3c
    const-string v2, "isHardwareAccelerated"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 19332
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    .line 19333
    iget-boolean v0, v0, Lio/dcloud/common/adapter/util/ViewOptions;->mUseHardwave:Z

    invoke-static {v0}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 19334
    :sswitch_3d
    const-string v2, "resume"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 20010
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 20012
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->resume()V

    const/16 v17, 0x0

    return-object v17

    .line 20013
    :sswitch_3e
    const-string v3, "remove"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 20454
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 20455
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v2, v0}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;)Lio/dcloud/feature/ui/b;

    move-result-object v2

    if-nez v2, :cond_13

    .line 20457
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v0, v3}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v2

    .line 20459
    :cond_13
    invoke-virtual {v1, v2}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/feature/ui/b;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 20460
    invoke-virtual {v1, v2}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/feature/ui/b;)V

    const/16 v17, 0x0

    return-object v17

    .line 20461
    :sswitch_3f
    const-string v3, "reload"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 20710
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    invoke-static {v0, v4, v13}, Lio/dcloud/common/util/PdrUtil;->parseBoolean(Ljava/lang/String;ZZ)Z

    move-result v0

    .line 20711
    invoke-virtual {v1, v1, v0}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/c;Z)V

    const/16 v17, 0x0

    return-object v17

    .line 20712
    :sswitch_40
    const-string v2, "parent"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21122
    iget-object v0, v1, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    if-eqz v0, :cond_14

    .line 21123
    invoke-virtual {v0}, Lio/dcloud/feature/ui/c;->h()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_14
    const/4 v6, 0x2

    .line 21125
    new-array v0, v6, [Ljava/lang/Object;

    aput-object v19, v0, v13

    const/16 v26, 0x1

    aput-object v19, v0, v26

    move-object/from16 v2, v21

    invoke-static {v2, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_41
    move-object/from16 v2, v21

    .line 21126
    const-string v3, "opener"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21514
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    if-eqz v0, :cond_15

    .line 21515
    invoke-virtual {v0}, Lio/dcloud/feature/ui/c;->h()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_15
    const/4 v6, 0x2

    .line 21517
    new-array v0, v6, [Ljava/lang/Object;

    aput-object v19, v0, v13

    const/16 v26, 0x1

    aput-object v19, v0, v26

    invoke-static {v2, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 21518
    :sswitch_42
    const-string v2, "opened"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 21915
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    invoke-static {v0}, Lio/dcloud/feature/ui/c;->a(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :sswitch_43
    move-object/from16 v5, p1

    .line 21916
    const-string v3, "checkRenderedContent"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 22508
    invoke-direct {v1, v5, v2}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;)V

    const/16 v17, 0x0

    return-object v17

    .line 22509
    :sswitch_44
    const-string v3, "interceptTouchEvent"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23121
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 23122
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IFrameView;->interceptTouchEvent(Z)V

    const/16 v17, 0x0

    return-object v17

    .line 23123
    :sswitch_45
    const-string v3, "setTitleNViewButtonStyle"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23452
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 23453
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 23454
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_0

    .line 23455
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    iget-object v4, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0, v3, v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->setTitleNViewButtonStyle(Lio/dcloud/common/DHInterface/ITitleNView;Ljava/lang/String;Lorg/json/JSONObject;Lio/dcloud/common/DHInterface/IFrameView;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_46
    move-object/from16 v5, p1

    .line 23456
    const-string v3, "setPreloadJsFile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23521
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 23522
    invoke-virtual {v2, v4, v13}, Lorg/json/JSONArray;->optBoolean(IZ)Z

    move-result v2

    .line 23523
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 23524
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v3

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 23525
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    invoke-interface {v3, v0, v2}, Lio/dcloud/common/DHInterface/IWebview;->setPreloadJsFile(Ljava/lang/String;Z)V

    const/16 v17, 0x0

    return-object v17

    .line 23526
    :sswitch_47
    const-string v3, "setTitleNViewButtonBadge"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 23799
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 23800
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 23801
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_0

    .line 23802
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const/4 v4, 0x1

    invoke-static {v0, v2, v4}, Lio/dcloud/common/util/TitleNViewUtil;->titleNViewButtonBadge(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Z)V

    const/16 v17, 0x0

    return-object v17

    .line 23803
    :sswitch_48
    const-string v2, "removeFromParent"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24204
    iget-object v0, v1, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    if-eqz v0, :cond_0

    .line 24206
    invoke-virtual {v0, v1}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/feature/ui/b;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 24207
    invoke-virtual {v0, v1}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/feature/ui/b;)V

    const/16 v17, 0x0

    return-object v17

    .line 24208
    :sswitch_49
    const-string v2, "getUrl"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24268
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v0

    const/4 v4, 0x1

    .line 24269
    invoke-static {v0, v4}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 24270
    :sswitch_4a
    const-string v2, "resetBounce"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24295
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0, v8}, Lio/dcloud/common/DHInterface/IWebview;->endWebViewEvent(Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 24296
    :sswitch_4b
    const-string v3, "hideTitleNViewButtonRedDot"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24593
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 24594
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 24595
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_0

    .line 24596
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    invoke-static {v0, v2, v13}, Lio/dcloud/common/util/TitleNViewUtil;->titleNViewButtonRedDot(Lio/dcloud/common/DHInterface/ITitleNView;Lorg/json/JSONObject;Z)V

    const/16 v17, 0x0

    return-object v17

    .line 24597
    :sswitch_4c
    const-string v3, "setAssistantType"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 24935
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 24937
    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->setAssistantType(Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_4d
    move-object/from16 v5, p1

    .line 24938
    const-string v3, "evalJS"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 25049
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 25050
    iget-object v3, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    const/4 v4, 0x1

    .line 25052
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    .line 25053
    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_16

    .line 25054
    new-instance v4, Lio/dcloud/feature/ui/c$b;

    invoke-direct {v4, v1, v5, v2}, Lio/dcloud/feature/ui/c$b;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    invoke-static {v0, v4}, Lio/dcloud/common/adapter/ui/ReceiveJSValue;->registerCallback(Ljava/lang/String;Lio/dcloud/common/adapter/ui/ReceiveJSValue$ReceiveJSValueCallback;)Ljava/lang/String;

    move-result-object v0

    .line 25078
    :cond_16
    invoke-interface {v3, v0}, Lio/dcloud/common/DHInterface/IWebview;->evalJS(Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 25079
    :sswitch_4e
    const-string v3, "setSoftinputTemporary"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 25742
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 25743
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 25744
    invoke-static {}, Lio/dcloud/common/core/ui/DCKeyboardManager;->getInstance()Lio/dcloud/common/core/ui/DCKeyboardManager;

    move-result-object v3

    invoke-virtual {v3, v0, v2}, Lio/dcloud/common/core/ui/DCKeyboardManager;->setHTMLInputRect(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 25745
    :sswitch_4f
    const-string v2, "getNavigationbar"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_b

    .line 25746
    :sswitch_50
    const-string v3, "append"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v4, 0x1

    .line 26198
    invoke-static {v2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 26199
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v2, v0}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;)Lio/dcloud/feature/ui/b;

    move-result-object v2

    if-nez v2, :cond_17

    .line 26201
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v0, v3}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/dcloud/feature/ui/c;

    move-result-object v2

    .line 26203
    :cond_17
    invoke-virtual {v1, v2}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/feature/ui/b;)Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz v2, :cond_0

    .line 26205
    invoke-virtual {v1, v2}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/b;)V

    const/16 v17, 0x0

    return-object v17

    .line 26206
    :sswitch_51
    const-string v3, "setRenderedEventOptions"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 26812
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object v0

    .line 26813
    const-string v2, "type"

    iget-object v3, v1, Lio/dcloud/feature/ui/c;->Z:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lio/dcloud/feature/ui/c;->Z:Ljava/lang/String;

    .line 26814
    const-string v2, "interval"

    iget v3, v1, Lio/dcloud/feature/ui/c;->a0:I

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, v1, Lio/dcloud/feature/ui/c;->a0:I

    const/16 v17, 0x0

    return-object v17

    .line 26815
    :sswitch_52
    const-string v2, "showSoftKeybord"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27073
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    if-eqz v0, :cond_18

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->isUniService()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 27074
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/adapter/util/DeviceInfo;->showIME(Landroid/view/View;)V

    const/16 v17, 0x0

    return-object v17

    .line 27076
    :cond_18
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainMainView()Landroid/view/View;

    move-result-object v0

    const/4 v4, 0x1

    invoke-static {v0, v4}, Lio/dcloud/common/adapter/util/DeviceInfo;->showIME(Landroid/view/View;Z)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_53
    move-object/from16 v5, p1

    .line 27077
    const-string v3, "appendPreloadJsFile"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27151
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 27152
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->obtainFullUrl()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Lio/dcloud/common/DHInterface/IApp;->convert2AbsFullPath(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 27153
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->appendPreloadJsFile(Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    .line 27154
    :sswitch_54
    const-string v3, "setTitleNViewSearchInputFocus"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27459
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 27460
    iget-object v3, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v3, v3, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    invoke-virtual {v1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v3, v4, v5, v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 27461
    instance-of v3, v0, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v3, :cond_0

    .line 27462
    check-cast v0, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lio/dcloud/common/util/TitleNViewUtil;->setTitleNViewSearchInputFocus(Lio/dcloud/common/DHInterface/ITitleNView;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_55
    move-object/from16 v5, p1

    .line 27463
    const-string v3, "captureSnapshot"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27958
    invoke-virtual {v1, v5, v2, v1}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_56
    move-object/from16 v3, v20

    .line 27959
    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 28598
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 28599
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v3, v0}, Lio/dcloud/common/DHInterface/IWebview;->setWebviewProperty(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_57
    move-object/from16 v5, p1

    .line 28600
    const-string v3, "listenResourceLoading"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 28680
    invoke-virtual {v2, v13}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    const/4 v4, 0x1

    .line 28681
    invoke-virtual {v2, v4}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lio/dcloud/feature/ui/c;->S:Ljava/lang/String;

    .line 28682
    iput-object v5, v1, Lio/dcloud/feature/ui/c;->T:Lio/dcloud/common/DHInterface/IWebview;

    .line 28683
    iget-object v2, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v0}, Lio/dcloud/common/DHInterface/IWebview;->setListenResourceLoading(Lorg/json/JSONObject;)V

    const/16 v17, 0x0

    return-object v17

    :sswitch_58
    move-object/from16 v5, p1

    .line 28684
    const-string v3, "canForward"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 28885
    invoke-static {v2, v13}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v3

    .line 28886
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 28887
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->canGoForward()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    sget v5, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-object/from16 v2, p1

    invoke-static/range {v2 .. v7}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    const/16 v17, 0x0

    return-object v17

    .line 28888
    :sswitch_59
    const-string v2, "getTitleNView"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 29415
    :goto_b
    iget-object v0, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v0}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v0

    .line 29416
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v2, v2, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v3, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v4, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    .line 29417
    invoke-interface {v4}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v4

    iget-object v5, v1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v6, 0x2

    new-array v7, v6, [Ljava/lang/Object;

    aput-object v5, v7, v13

    const/16 v26, 0x1

    aput-object v0, v7, v26

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    aput-object v4, v0, v13

    aput-object v16, v0, v26

    const-string v4, "getNativeView"

    const/16 v25, 0x2

    aput-object v4, v0, v25

    const/16 v24, 0x3

    aput-object v7, v0, v24

    const/16 v5, 0xa

    .line 29418
    invoke-interface {v2, v3, v5, v0}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 29421
    instance-of v2, v0, Lio/dcloud/common/DHInterface/INativeView;

    if-eqz v2, :cond_0

    .line 29422
    check-cast v0, Lio/dcloud/common/DHInterface/INativeView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/INativeView;->toJSON()Lorg/json/JSONObject;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 29424
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v13}, Lio/dcloud/common/util/JSUtil;->wrapJsVar(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    return-object v0

    :cond_19
    :goto_c
    return-object v17

    :catch_1
    move-exception v0

    const/16 v17, 0x0

    .line 29581
    :goto_d
    invoke-virtual {v0}, Ljava/lang/Throwable;->printStackTrace()V

    return-object v17

    nop

    :sswitch_data_0
    .sparse-switch
        -0x7c6fdb4f -> :sswitch_59
        -0x7c0dbf2b -> :sswitch_58
        -0x7a44d379 -> :sswitch_57
        -0x78570760 -> :sswitch_56
        -0x6c3ba4d6 -> :sswitch_55
        -0x6416b82d -> :sswitch_54
        -0x5ae82b2c -> :sswitch_53
        -0x5802f0a9 -> :sswitch_52
        -0x55277c85 -> :sswitch_51
        -0x541b30e6 -> :sswitch_50
        -0x52cffa37 -> :sswitch_4f
        -0x4d314fad -> :sswitch_4e
        -0x4cf9fd1b -> :sswitch_4d
        -0x4c39060a -> :sswitch_4c
        -0x4b568ef9 -> :sswitch_4b
        -0x4b547749 -> :sswitch_4a
        -0x4a7789c7 -> :sswitch_49
        -0x47d6db68 -> :sswitch_48
        -0x477ebf6c -> :sswitch_47
        -0x477b4374 -> :sswitch_46
        -0x46863d5e -> :sswitch_45
        -0x41313b03 -> :sswitch_44
        -0x3fad9824 -> :sswitch_43
        -0x3c3c3797 -> :sswitch_42
        -0x3c3c3789 -> :sswitch_41
        -0x3b54f756 -> :sswitch_40
        -0x37b57e67 -> :sswitch_3f
        -0x37b5077c -> :sswitch_3e
        -0x37b237d3 -> :sswitch_3d
        -0x3592d76b -> :sswitch_3c
        -0x32ef8650 -> :sswitch_3b
        -0x285c6d3b -> :sswitch_3a
        -0x254d19b3 -> :sswitch_39
        -0x21c155b6 -> :sswitch_38
        -0x204670b6 -> :sswitch_37
        -0x1cb1a00e -> :sswitch_36
        -0x1b05accf -> :sswitch_35
        -0x1872c145 -> :sswitch_34
        -0x17e553b8 -> :sswitch_33
        -0x170868e0 -> :sswitch_32
        -0xf0544a3 -> :sswitch_31
        -0xefef4f2 -> :sswitch_30
        -0x945e500 -> :sswitch_2f
        -0x6bcc818 -> :sswitch_2e
        -0x27467cb -> :sswitch_2d
        -0x18b930e -> :sswitch_2c
        0x2e04e7 -> :sswitch_2b
        0x2f2d34 -> :sswitch_2a
        0x2f2d44 -> :sswitch_29
        0x30dd42 -> :sswitch_28
        0x32c4e6 -> :sswitch_27
        0x35dafd -> :sswitch_26
        0x360802 -> :sswitch_25
        0x11431b9 -> :sswitch_24
        0x5a5b64d -> :sswitch_23
        0x5a5ddf8 -> :sswitch_22
        0x5da4d8a -> :sswitch_21
        0x65825f6 -> :sswitch_20
        0x10d2e697 -> :sswitch_1f
        0x1712be00 -> :sswitch_1e
        0x1c16df77 -> :sswitch_1d
        0x1e5a2e5e -> :sswitch_1c
        0x20bc90d7 -> :sswitch_1b
        0x26abf237 -> :sswitch_1a
        0x28e1ab6b -> :sswitch_19
        0x2de6c535 -> :sswitch_18
        0x33d49341 -> :sswitch_17
        0x406fccb8 -> :sswitch_16
        0x47159ef3 -> :sswitch_15
        0x4d3f205e -> :sswitch_14
        0x4ff8c0f0 -> :sswitch_13
        0x505da082 -> :sswitch_12
        0x50d25f2c -> :sswitch_11
        0x53b6de6f -> :sswitch_10
        0x5a812e16 -> :sswitch_a
        0x5d584db2 -> :sswitch_9
        0x6232bdd9 -> :sswitch_8
        0x62ea5dff -> :sswitch_7
        0x682686d2 -> :sswitch_6
        0x6dfa45b0 -> :sswitch_5
        0x6f9d73d1 -> :sswitch_4
        0x739c0c9b -> :sswitch_3
        0x7531c8a2 -> :sswitch_2
        0x76c5fc8d -> :sswitch_1
        0x7b40d2ec -> :sswitch_0
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        -0x640344e4 -> :sswitch_f
        -0x5a568a8d -> :sswitch_e
        -0x13e21780 -> :sswitch_d
        0x843 -> :sswitch_c
        0x247ab7 -> :sswitch_b
    .end sparse-switch
.end method

.method public a(IIIIII)V
    .locals 0

    return-void
.end method

.method public a(Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)V
    .locals 1

    if-eqz p1, :cond_0

    .line 4
    iput-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    .line 5
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 7
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-interface {p1, v0}, Lio/dcloud/common/DHInterface/IWebview;->initWebviewUUID(Ljava/lang/String;)V

    .line 8
    invoke-interface {p1, p2}, Lio/dcloud/common/DHInterface/IWebview;->setFrameId(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method protected a(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 9
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "ad"

    aput-object p1, p2, v2

    const-string p1, "addNativeView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V
    .locals 4

    const/4 v0, 0x0

    .line 29764
    invoke-static {p2, v0}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    .line 29765
    invoke-static {p2, v1}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object p2

    .line 29766
    iget-object p3, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    move-object v1, v2

    goto :goto_0

    :cond_0
    new-instance v1, Lio/dcloud/feature/ui/c$f;

    invoke-direct {v1, p0, p1, p2}, Lio/dcloud/feature/ui/c$f;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 29772
    :goto_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    goto :goto_1

    :cond_1
    new-instance v2, Lio/dcloud/feature/ui/c$g;

    invoke-direct {v2, p0, p1, p2}, Lio/dcloud/feature/ui/c$g;-><init>(Lio/dcloud/feature/ui/c;Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V

    .line 29773
    :goto_1
    invoke-interface {p3, v0, v1, v2}, Lio/dcloud/common/DHInterface/IFrameView;->captureSnapshot(Ljava/lang/String;Lio/dcloud/common/DHInterface/ICallBack;Lio/dcloud/common/DHInterface/ICallBack;)V

    return-void
.end method

.method a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V
    .locals 9

    .line 29648
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v0, p3}, Lio/dcloud/feature/ui/a;->a(Lio/dcloud/feature/ui/c;)Z

    move-result v0

    const/4 v1, 0x2

    const/4 v2, 0x3

    const/4 v3, 0x4

    const/4 v4, 0x0

    const/4 v5, 0x1

    if-eqz v0, :cond_0

    .line 29649
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v6, "showWebview url="

    invoke-direct {v0, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p3, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v6, "stream_manager"

    invoke-static {v6, v0}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 29650
    iput v5, p3, Lio/dcloud/feature/ui/c;->A:I

    .line 29651
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v0, p3}, Lio/dcloud/feature/ui/a;->f(Lio/dcloud/feature/ui/c;)V

    .line 29652
    new-array v0, v3, [Ljava/lang/Object;

    aput-object p1, v0, v4

    aput-object p2, v0, v5

    aput-object p3, v0, v1

    aput-object p4, v0, v2

    iput-object v0, p3, Lio/dcloud/feature/ui/c;->B:Ljava/lang/Object;

    return-void

    .line 29655
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v6, p3, Lio/dcloud/feature/ui/c;->u:J

    .line 29657
    iput-boolean v5, p3, Lio/dcloud/feature/ui/c;->F:Z

    .line 29658
    invoke-static {p2, v4}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    .line 29660
    invoke-static {p2, v5}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v6

    .line 29661
    invoke-static {p2, v2}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lio/dcloud/feature/ui/c;->O:Ljava/lang/String;

    .line 29662
    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 29663
    iput-object p1, p0, Lio/dcloud/feature/ui/c;->P:Lio/dcloud/common/DHInterface/IWebview;

    .line 29665
    :cond_1
    iget-object v2, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v2

    .line 29668
    const-string v7, "auto"

    invoke-static {v7, v0}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    const-string v8, "none"

    if-eqz v7, :cond_2

    .line 29669
    iget-object v7, v2, Lio/dcloud/common/adapter/util/AnimOptions;->mAnimType:Ljava/lang/String;

    goto :goto_0

    :cond_2
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    move-object v7, v8

    goto :goto_0

    :cond_3
    move-object v7, v0

    :goto_0
    iput-object v7, v2, Lio/dcloud/common/adapter/util/AnimOptions;->mAnimType:Ljava/lang/String;

    .line 29670
    invoke-static {v8, v7}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v7

    xor-int/2addr v7, v5

    .line 29671
    invoke-static {v6}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 29672
    iget-object v6, v2, Lio/dcloud/common/adapter/util/AnimOptions;->mAnimType:Ljava/lang/String;

    const-string v8, "pop-in"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    const/16 v6, 0x12c

    .line 29673
    iput v6, v2, Lio/dcloud/common/adapter/util/AnimOptions;->duration_show:I

    goto :goto_1

    .line 29676
    :cond_4
    iget v8, v2, Lio/dcloud/common/adapter/util/AnimOptions;->duration_show:I

    invoke-static {v6, v8}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v6

    iput v6, v2, Lio/dcloud/common/adapter/util/AnimOptions;->duration_show:I

    .line 29679
    :cond_5
    :goto_1
    iget-boolean v6, p3, Lio/dcloud/feature/ui/c;->G:Z

    if-nez v6, :cond_6

    iget-boolean v6, p3, Lio/dcloud/feature/ui/c;->I:Z

    if-eqz v6, :cond_6

    const/4 v7, 0x0

    .line 29682
    :cond_6
    iget-object v6, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v6, p0}, Lio/dcloud/feature/ui/a;->c(Lio/dcloud/feature/ui/c;)I

    move-result v6

    .line 29686
    iget-object v8, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v8, p4, p3, v6}, Lio/dcloud/feature/ui/a;->a(Ljava/lang/String;Lio/dcloud/feature/ui/c;I)V

    .line 29690
    invoke-static {p2, v3}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object p2

    .line 29692
    invoke-direct {p0, p1, p2, p3, v0}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    .line 29694
    iget-boolean p1, p3, Lio/dcloud/feature/ui/c;->G:Z

    if-eqz p1, :cond_7

    .line 29695
    iput-byte v3, v2, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    .line 29696
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p1, p1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object p2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object p4, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/16 v0, 0x18

    invoke-interface {p1, p2, v0, p4}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 29698
    :cond_7
    iput-byte v4, v2, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    .line 29699
    iput-boolean v5, p3, Lio/dcloud/feature/ui/c;->I:Z

    .line 29701
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p1, p1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object p2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object p4, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p4, v1, v4

    aput-object v0, v1, v5

    invoke-interface {p1, p2, v5, v1}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    .line 29703
    :goto_2
    iput-boolean v4, p3, Lio/dcloud/feature/ui/c;->G:Z

    .line 29704
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p2, "show "

    invoke-direct {p1, p2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object p2, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string p2, ";webview_name="

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p2

    invoke-interface {p2}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameId()Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, "View_Visible_Path"

    invoke-static {p2, p1}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected a(Lio/dcloud/feature/ui/b;)V
    .locals 18

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    .line 10
    iget-object v2, v0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    if-nez v2, :cond_0

    .line 11
    new-instance v2, Ljava/util/ArrayList;

    const/4 v3, 0x2

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v2, v0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    .line 14
    :cond_0
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v8

    .line 15
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->c()B

    move-result v11

    .line 16
    sget-byte v2, Lio/dcloud/common/adapter/util/ViewRect;->POSITION_DOCK:B

    if-ne v11, v2, :cond_1

    .line 17
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->b()B

    move-result v2

    invoke-virtual {v8, v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setPosition(I)V

    goto :goto_0

    .line 19
    :cond_1
    invoke-virtual {v8, v11}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setPosition(I)V

    .line 21
    :goto_0
    iget-object v2, v0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto/16 :goto_9

    .line 23
    :cond_2
    instance-of v2, v1, Lio/dcloud/feature/ui/c;

    const/4 v3, 0x0

    const-string v9, "View_Visible_Path"

    const/4 v12, 0x0

    const/4 v4, 0x1

    if-eqz v2, :cond_6

    .line 24
    move-object v2, v1

    check-cast v2, Lio/dcloud/feature/ui/c;

    .line 27
    invoke-direct {v0, v1, v2}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/feature/ui/b;Lio/dcloud/feature/ui/c;)V

    .line 29
    iget-object v5, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v5, v2}, Lio/dcloud/feature/ui/a;->a(Lio/dcloud/feature/ui/c;)Z

    move-result v5

    if-eqz v5, :cond_3

    iget-boolean v5, v0, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v5, :cond_3

    const/4 v5, 0x4

    .line 30
    iput v5, v2, Lio/dcloud/feature/ui/c;->A:I

    .line 31
    iget-object v5, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v5, v2}, Lio/dcloud/feature/ui/a;->f(Lio/dcloud/feature/ui/c;)V

    .line 35
    :cond_3
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v5

    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v5

    if-eqz v5, :cond_5

    iget-boolean v5, v2, Lio/dcloud/feature/ui/c;->G:Z

    if-nez v5, :cond_5

    .line 36
    iput-boolean v4, v2, Lio/dcloud/feature/ui/c;->F:Z

    .line 37
    iget-object v5, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v5, v4, v4}, Lio/dcloud/common/DHInterface/IFrameView;->setVisible(ZZ)V

    .line 38
    iget-object v5, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    instance-of v6, v5, Lio/dcloud/common/adapter/ui/AdaFrameView;

    if-eqz v6, :cond_4

    .line 39
    check-cast v5, Lio/dcloud/common/adapter/ui/AdaFrameView;

    const-string v6, "child_initialize_show"

    invoke-virtual {v5, v6, v3}, Lio/dcloud/common/adapter/ui/AdaFrameView;->dispatchFrameViewEvents(Ljava/lang/String;Ljava/lang/Object;)V

    .line 41
    :cond_4
    const-string v5, "NWindow.appendView childView set visible true"

    invoke-static {v9, v5}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    :cond_5
    iget-object v5, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v6, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-virtual {v5, v6}, Lio/dcloud/feature/ui/a;->c(Lio/dcloud/common/DHInterface/IFrameView;)V

    .line 45
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "append "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, v2, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v9, v5}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    iput-boolean v4, v2, Lio/dcloud/feature/ui/c;->L:Z

    .line 49
    iput-boolean v4, v2, Lio/dcloud/feature/ui/c;->I:Z

    .line 50
    invoke-virtual {v2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v5

    if-eqz v5, :cond_7

    invoke-virtual {v2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v5

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IWebview;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v5

    invoke-static {v5}, Lio/dcloud/common/util/BaseInfo;->isUniAppAppid(Lio/dcloud/common/DHInterface/IApp;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 51
    invoke-virtual {v2}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v2

    invoke-interface {v2, v4}, Lio/dcloud/common/DHInterface/IWebview;->setIWebViewFocusable(Z)V

    goto :goto_1

    .line 53
    :cond_6
    instance-of v2, v1, Lio/dcloud/feature/ui/d;

    if-eqz v2, :cond_8

    .line 54
    move-object v2, v1

    check-cast v2, Lio/dcloud/feature/ui/d;

    .line 55
    invoke-virtual {v2}, Lio/dcloud/feature/ui/d;->i()V

    .line 56
    invoke-virtual {v2, v4}, Lio/dcloud/feature/ui/d;->a(Z)V

    :cond_7
    :goto_1
    const/4 v10, 0x1

    goto :goto_2

    :cond_8
    const/4 v10, 0x0

    .line 59
    :goto_2
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->h:Lorg/json/JSONObject;

    .line 60
    iget-object v5, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v5, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v13

    .line 61
    iget-object v5, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v5}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v5

    .line 62
    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v14

    .line 64
    invoke-virtual {v8}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v15

    .line 66
    sget-byte v6, Lio/dcloud/feature/ui/b;->p:B

    if-ne v11, v6, :cond_9

    .line 67
    iget-object v3, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    .line 68
    invoke-virtual {v13}, Lio/dcloud/common/adapter/util/ViewRect;->getParentViewRect()Lio/dcloud/common/adapter/util/ViewRect;

    move-result-object v6

    invoke-virtual {v14, v6}, Lio/dcloud/common/adapter/util/ViewRect;->setParentViewRect(Lio/dcloud/common/adapter/util/ViewRect;)V

    .line 69
    invoke-virtual {v14, v13}, Lio/dcloud/common/adapter/util/ViewOptions;->updateViewData(Lio/dcloud/common/adapter/util/ViewRect;)V

    :goto_3
    move-object/from16 v16, v3

    goto :goto_5

    .line 71
    :cond_9
    sget-byte v6, Lio/dcloud/feature/ui/b;->o:B

    if-ne v11, v6, :cond_a

    .line 72
    iget-object v3, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    goto :goto_4

    .line 73
    :cond_a
    sget-byte v6, Lio/dcloud/feature/ui/b;->n:B

    if-ne v11, v6, :cond_b

    .line 74
    iget-object v3, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    .line 79
    :cond_b
    :goto_4
    iget-object v6, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v6, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v6}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v6

    .line 80
    invoke-virtual {v15, v6}, Lio/dcloud/common/adapter/util/ViewRect;->setParentViewRect(Lio/dcloud/common/adapter/util/ViewRect;)V

    goto :goto_3

    .line 82
    :goto_5
    invoke-virtual {v13}, Lio/dcloud/common/adapter/util/ViewOptions;->hasBackground()Z

    move-result v3

    if-eqz v3, :cond_c

    .line 83
    iget v3, v14, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    iget v6, v14, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    iget v7, v14, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    invoke-virtual {v15, v2, v3, v6, v7}, Lio/dcloud/common/adapter/util/ViewRect;->updateViewData(Lorg/json/JSONObject;IIF)Z

    .line 84
    invoke-virtual {v15}, Lio/dcloud/common/adapter/util/ViewOptions;->hasBackground()Z

    move-result v2

    if-eqz v2, :cond_d

    .line 85
    iput v12, v15, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    .line 86
    iput v12, v15, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    .line 87
    iput v12, v15, Lio/dcloud/common/adapter/util/ViewRect;->anim_top:I

    .line 88
    iput v12, v15, Lio/dcloud/common/adapter/util/ViewRect;->anim_left:I

    goto :goto_6

    .line 91
    :cond_c
    iget v3, v13, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    iget v6, v13, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    iget v7, v13, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    invoke-virtual {v15, v2, v3, v6, v7}, Lio/dcloud/common/adapter/util/ViewRect;->updateViewData(Lorg/json/JSONObject;IIF)Z

    .line 94
    :cond_d
    :goto_6
    sget-byte v2, Lio/dcloud/feature/ui/b;->p:B

    if-ne v11, v2, :cond_10

    .line 95
    move-object/from16 v2, v16

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v2

    invoke-virtual {v15, v2}, Lio/dcloud/common/adapter/util/ViewRect;->setParentViewRect(Lio/dcloud/common/adapter/util/ViewRect;)V

    .line 96
    invoke-static {v14, v15}, Lio/dcloud/common/adapter/util/ViewRect;->layoutDockViewRect(Lio/dcloud/common/adapter/util/ViewRect;Lio/dcloud/common/adapter/util/ViewRect;)V

    .line 98
    iput-boolean v4, v5, Lio/dcloud/common/adapter/ui/AdaFrameItem;->mNeedOrientationUpdate:Z

    .line 102
    invoke-virtual {v14, v15}, Lio/dcloud/common/adapter/util/ViewRect;->putRelViewRect(Lio/dcloud/common/adapter/util/ViewRect;)V

    .line 104
    iget v2, v14, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    .line 105
    iget v3, v14, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    .line 106
    iget v4, v14, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    .line 107
    iget v6, v14, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    .line 108
    sget-boolean v7, Lio/dcloud/common/util/BaseInfo;->isImmersive:Z

    if-eqz v7, :cond_f

    iget-boolean v7, v14, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-eqz v7, :cond_f

    .line 109
    invoke-virtual {v13}, Lio/dcloud/common/adapter/util/ViewRect;->isHeightAbsolute()Z

    move-result v7

    if-nez v7, :cond_e

    .line 110
    sget v7, Lio/dcloud/common/adapter/util/DeviceInfo;->sStatusBarHeight:I

    add-int/2addr v6, v7

    .line 112
    :cond_e
    sget v7, Lio/dcloud/common/adapter/util/DeviceInfo;->sStatusBarHeight:I

    add-int/2addr v3, v7

    .line 114
    :cond_f
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v12, "NWindow.appendView ---> _webview left="

    invoke-direct {v7, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v12, ";top="

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v12, ";width="

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v12, ";height="

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v9, v7}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v2, v3, v4, v6}, Lio/dcloud/common/adapter/ui/AdaFrameItem$LayoutParamsUtil;->setViewLayoutParams(Landroid/view/View;IIII)V

    .line 118
    :cond_10
    iget v6, v15, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    .line 119
    iget v7, v15, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    .line 120
    iget v12, v15, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    .line 121
    iget v2, v15, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    move v3, v2

    .line 123
    iget v2, v14, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    move v4, v3

    iget v3, v14, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    move v5, v4

    iget v4, v14, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    move/from16 v17, v5

    iget v5, v14, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    invoke-virtual/range {v1 .. v7}, Lio/dcloud/feature/ui/b;->a(IIIIII)V

    .line 124
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "NWindow.appendView childView="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v9, v2}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    move-object/from16 v2, v16

    check-cast v2, Lio/dcloud/common/adapter/ui/AdaContainerFrameItem;

    invoke-virtual {v8, v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->setParentFrameItem(Lio/dcloud/common/adapter/ui/AdaContainerFrameItem;)V

    if-eqz v10, :cond_16

    .line 129
    sget-byte v3, Lio/dcloud/feature/ui/b;->n:B

    if-ne v11, v3, :cond_11

    invoke-virtual {v15}, Lio/dcloud/common/adapter/util/ViewRect;->hasHeightAbsolutevalue()Z

    move-result v3

    if-nez v3, :cond_11

    .line 130
    iget v3, v14, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    if-lez v3, :cond_11

    move v10, v3

    goto :goto_7

    :cond_11
    move v10, v7

    .line 134
    :goto_7
    invoke-virtual {v8}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    move v9, v6

    move-object v5, v8

    move v7, v12

    move-object/from16 v4, v16

    move/from16 v8, v17

    move-object v6, v3

    invoke-static/range {v4 .. v10}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IContainerView;Lio/dcloud/common/adapter/ui/AdaFrameItem;Landroid/view/ViewGroup$LayoutParams;IIII)V

    move v4, v7

    move v3, v8

    move v6, v9

    .line 135
    sget-byte v7, Lio/dcloud/feature/ui/b;->p:B

    if-ne v11, v7, :cond_12

    .line 136
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->b()B

    move-result v7

    sget-byte v8, Lio/dcloud/feature/ui/b;->s:B

    if-ne v7, v8, :cond_12

    .line 137
    iget-object v7, v13, Lio/dcloud/common/adapter/util/ViewOptions;->titleNView:Lorg/json/JSONObject;

    if-eqz v7, :cond_12

    invoke-static {v7}, Lio/dcloud/common/util/TitleNViewUtil;->isTitleTypeForDef(Lorg/json/JSONObject;)Z

    move-result v7

    if-eqz v7, :cond_12

    .line 138
    iget-object v7, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v7

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->getScale()F

    move-result v7

    const-string v8, "44px"

    const/4 v9, 0x0

    invoke-static {v8, v9, v9, v7}, Lio/dcloud/common/util/PdrUtil;->convertToScreenInt(Ljava/lang/String;IIF)I

    move-result v7

    add-int/2addr v3, v7

    .line 142
    :cond_12
    iget-boolean v7, v15, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-nez v7, :cond_13

    iget-boolean v7, v13, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-eqz v7, :cond_13

    .line 143
    sget v7, Lio/dcloud/common/adapter/util/DeviceInfo;->sStatusBarHeight:I

    add-int/2addr v3, v7

    .line 144
    invoke-virtual {v15}, Lio/dcloud/common/adapter/util/ViewRect;->isBottomAbsolute()Z

    move-result v7

    if-eqz v7, :cond_13

    .line 145
    sget v7, Lio/dcloud/common/adapter/util/DeviceInfo;->sStatusBarHeight:I

    sub-int/2addr v10, v7

    .line 148
    :cond_13
    iget-boolean v7, v15, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-eqz v7, :cond_14

    .line 149
    invoke-virtual {v15}, Lio/dcloud/common/adapter/util/ViewRect;->isBottomAbsolute()Z

    move-result v7

    if-nez v7, :cond_14

    .line 150
    sget v7, Lio/dcloud/common/adapter/util/DeviceInfo;->sStatusBarHeight:I

    add-int/2addr v10, v7

    :cond_14
    const/4 v7, -0x1

    if-ge v10, v7, :cond_15

    const/4 v10, -0x1

    .line 156
    :cond_15
    invoke-virtual {v5}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainMainView()Landroid/view/View;

    move-result-object v5

    invoke-static {v5, v4, v3, v6, v10}, Lio/dcloud/common/adapter/ui/AdaFrameItem$LayoutParamsUtil;->setViewLayoutParams(Landroid/view/View;IIII)V

    goto :goto_8

    :cond_16
    move v4, v12

    move-object/from16 v5, v16

    move/from16 v3, v17

    .line 158
    invoke-static {v4, v3, v6, v7}, Lio/dcloud/common/adapter/ui/AdaFrameItem$LayoutParamsUtil;->createLayoutParams(IIII)Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .line 159
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v4

    invoke-interface {v5, v4, v3}, Lio/dcloud/common/DHInterface/IContainerView;->addFrameItem(Lio/dcloud/common/adapter/ui/AdaFrameItem;Landroid/view/ViewGroup$LayoutParams;)V

    .line 161
    :goto_8
    iget-object v3, v0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 162
    iput-object v0, v1, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    .line 163
    iget-object v3, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v3, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {v3}, Lio/dcloud/common/adapter/ui/AdaContainerFrameItem;->sortNativeViewBringToFront()V

    .line 164
    invoke-virtual {v2}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v2

    iget-boolean v2, v2, Lio/dcloud/common/adapter/util/ViewRect;->isStatusbar:Z

    if-eqz v2, :cond_17

    .line 165
    invoke-virtual {v1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v1

    invoke-virtual {v1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->resize()V

    .line 167
    :cond_17
    iget-object v1, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v1}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNViewId(Lio/dcloud/common/DHInterface/IFrameView;)Ljava/lang/String;

    move-result-object v1

    .line 168
    invoke-static {v1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_18

    .line 169
    iget-object v2, v0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v2, v2, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    iget-object v3, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v3

    iget-object v4, v0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-static {v2, v3, v4, v1}, Lio/dcloud/common/util/TitleNViewUtil;->getTitleNView(Lio/dcloud/common/DHInterface/AbsMgr;Lio/dcloud/common/DHInterface/IWebview;Lio/dcloud/common/DHInterface/IFrameView;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_18

    .line 170
    instance-of v2, v1, Lio/dcloud/common/DHInterface/ITitleNView;

    if-eqz v2, :cond_18

    .line 171
    check-cast v1, Lio/dcloud/common/DHInterface/ITitleNView;

    invoke-interface {v1}, Lio/dcloud/common/DHInterface/ITitleNView;->reMeasure()V

    :cond_18
    :goto_9
    return-void
.end method

.method a(Lio/dcloud/feature/ui/c;Z)V
    .locals 0

    .line 29774
    iget-object p1, p1, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-interface {p1, p2}, Lio/dcloud/common/DHInterface/IWebview;->reload(Z)V

    return-void
.end method

.method public a(Z)V
    .locals 0

    .line 3
    iput-boolean p1, p0, Lio/dcloud/feature/ui/c;->b0:Z

    return-void
.end method

.method a(Lorg/json/JSONObject;Z)Z
    .locals 3

    .line 29775
    const-string/jumbo v0, "zindex"

    invoke-virtual {p1, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    const/4 v2, 0x0

    if-nez v1, :cond_0

    .line 29776
    invoke-static {p1, v0}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 29778
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    .line 29779
    iget v0, p0, Lio/dcloud/feature/ui/c;->E:I

    if-eq p1, v0, :cond_0

    const/4 v2, 0x1

    .line 29781
    iput p1, p0, Lio/dcloud/feature/ui/c;->E:I

    .line 29782
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameView;

    iput p1, v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;->mZIndex:I

    if-eqz p2, :cond_0

    .line 29784
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {p1, p0}, Lio/dcloud/feature/ui/a;->g(Lio/dcloud/feature/ui/c;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    :cond_0
    return v2
.end method

.method protected b(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 11
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "barcode"

    aput-object p1, p2, v2

    const-string p1, "appendToFrameView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method b(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V
    .locals 5

    .line 12
    iget-boolean v0, p3, Lio/dcloud/feature/ui/c;->I:Z

    if-eqz v0, :cond_5

    .line 13
    iget-boolean v0, p3, Lio/dcloud/feature/ui/c;->J:Z

    if-nez v0, :cond_6

    .line 15
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v0, p3}, Lio/dcloud/feature/ui/a;->b(Lio/dcloud/feature/ui/c;)V

    .line 16
    iget-boolean v0, p3, Lio/dcloud/feature/ui/c;->L:Z

    if-eqz v0, :cond_1

    .line 17
    iget-object p1, p3, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    if-eqz p1, :cond_0

    .line 18
    invoke-virtual {p1, p3}, Lio/dcloud/feature/ui/c;->c(Lio/dcloud/feature/ui/b;)V

    .line 21
    :cond_0
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->onDispose()Z

    .line 22
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->dispose()V

    goto :goto_1

    :cond_1
    const/4 v0, 0x0

    .line 24
    invoke-static {p2, v0}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    .line 26
    invoke-static {p2, v1}, Lio/dcloud/common/util/JSONUtil;->getString(Lorg/json/JSONArray;I)Ljava/lang/String;

    move-result-object v2

    .line 27
    iget-object v3, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v3, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v3}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->getAnimOptions()Lio/dcloud/common/adapter/util/AnimOptions;

    move-result-object v3

    .line 28
    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    const-string v0, "auto"

    .line 29
    :cond_2
    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 30
    iget v4, v3, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    invoke-static {v2, v4}, Lio/dcloud/common/util/PdrUtil;->parseInt(Ljava/lang/String;I)I

    move-result v2

    iput v2, v3, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    goto :goto_0

    .line 32
    :cond_3
    const-string v2, "pop-out"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    const/16 v2, 0x168

    .line 33
    iput v2, v3, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    goto :goto_0

    .line 35
    :cond_4
    iget v2, v3, Lio/dcloud/common/adapter/util/AnimOptions;->duration_show:I

    iput v2, v3, Lio/dcloud/common/adapter/util/AnimOptions;->duration_close:I

    .line 41
    :goto_0
    invoke-virtual {v3, v0}, Lio/dcloud/common/adapter/util/AnimOptions;->setCloseAnimType(Ljava/lang/String;)V

    .line 42
    iput-byte v1, v3, Lio/dcloud/common/adapter/util/AnimOptions;->mOption:B

    const/4 v1, 0x2

    .line 44
    invoke-static {p2, v1}, Lio/dcloud/common/util/JSONUtil;->getJSONObject(Lorg/json/JSONArray;I)Lorg/json/JSONObject;

    move-result-object p2

    .line 46
    invoke-direct {p0, p1, p2, p3, v0}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONObject;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    .line 47
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p1, p1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object p2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v0, p3, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1, p2, v1, v0}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 52
    :cond_5
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {p1, p3}, Lio/dcloud/feature/ui/a;->b(Lio/dcloud/feature/ui/c;)V

    .line 53
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->onDispose()Z

    .line 54
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->dispose()V

    .line 57
    :cond_6
    :goto_1
    invoke-virtual {p3}, Lio/dcloud/feature/ui/c;->e()V

    return-void
.end method

.method protected b(Lio/dcloud/feature/ui/c;)V
    .locals 1

    .line 6
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    .line 7
    :cond_0
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 8
    iput-object p0, p1, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    .line 9
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 10
    invoke-virtual {p1}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {p1, v0}, Lio/dcloud/common/DHInterface/IWebview;->setOpener(Lio/dcloud/common/DHInterface/IWebview;)V

    :cond_1
    return-void
.end method

.method public b(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lio/dcloud/feature/ui/c;->Y:Z

    return-void
.end method

.method public b(Lio/dcloud/feature/ui/b;)Z
    .locals 1

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    return p1

    .line 5
    :cond_0
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method b(Ljava/lang/String;)Z
    .locals 4

    .line 70
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 71
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    :goto_0
    if-ltz v0, :cond_1

    .line 73
    iget-object v2, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/dcloud/feature/ui/b;

    .line 74
    instance-of v3, v2, Lio/dcloud/feature/ui/c;

    if-eqz v3, :cond_0

    .line 75
    check-cast v2, Lio/dcloud/feature/ui/c;

    invoke-virtual {v2, p1}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 81
    :cond_1
    invoke-virtual {p0, p1}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;)Z

    move-result p1

    return p1
.end method

.method b(Ljava/lang/String;Ljava/lang/String;Z)Z
    .locals 4

    .line 58
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    .line 59
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    sub-int/2addr v0, v1

    :goto_0
    if-ltz v0, :cond_1

    .line 61
    iget-object v2, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/dcloud/feature/ui/b;

    .line 62
    instance-of v3, v2, Lio/dcloud/feature/ui/c;

    if-eqz v3, :cond_0

    check-cast v2, Lio/dcloud/feature/ui/c;

    iget-boolean v3, v2, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v3, :cond_0

    .line 63
    invoke-virtual {v2, p1, p2, p3}, Lio/dcloud/feature/ui/c;->b(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 69
    :cond_1
    invoke-virtual {p0, p1}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result p1

    if-eqz p1, :cond_2

    return v1

    :cond_2
    const/4 p1, 0x0

    return p1
.end method

.method protected c(Ljava/lang/String;)Lio/dcloud/feature/ui/b;
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_1

    .line 4
    iget-object v1, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lio/dcloud/feature/ui/b;

    .line 5
    iget-object v2, v1, Lio/dcloud/feature/ui/b;->f:Ljava/lang/String;

    invoke-static {p1, v2}, Lio/dcloud/common/util/PdrUtil;->isEquals(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    return-object v1

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_1
    return-object v1
.end method

.method protected c(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 26
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "livepusher"

    aput-object p1, p2, v2

    const-string p1, "appendToFrameView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method protected c(Lio/dcloud/feature/ui/b;)V
    .locals 3

    .line 6
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 9
    :cond_0
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    const/4 v0, 0x0

    .line 10
    iput-object v0, p1, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    .line 11
    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->c()B

    move-result v0

    .line 13
    instance-of v1, p1, Lio/dcloud/feature/ui/c;

    .line 15
    sget-byte v2, Lio/dcloud/feature/ui/b;->n:B

    if-ne v0, v2, :cond_1

    .line 16
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    .line 17
    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-interface {v0, p1}, Lio/dcloud/common/DHInterface/IContainerView;->removeFrameItem(Lio/dcloud/common/adapter/ui/AdaFrameItem;)V

    return-void

    .line 18
    :cond_1
    sget-byte v2, Lio/dcloud/feature/ui/b;->o:B

    if-ne v0, v2, :cond_2

    .line 19
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v0

    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/dcloud/common/adapter/ui/AdaContainerFrameItem;->removeFrameItem(Lio/dcloud/common/adapter/ui/AdaFrameItem;)V

    return-void

    .line 20
    :cond_2
    sget-byte v2, Lio/dcloud/feature/ui/b;->p:B

    if-ne v0, v2, :cond_4

    .line 21
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object v2

    invoke-interface {v0, v2}, Lio/dcloud/common/DHInterface/IContainerView;->removeFrameItem(Lio/dcloud/common/adapter/ui/AdaFrameItem;)V

    if-eqz v1, :cond_3

    .line 23
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebviewParent()Lio/dcloud/common/adapter/ui/AdaWebViewParent;

    move-result-object v0

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    invoke-virtual {p1}, Lio/dcloud/feature/ui/b;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p1

    invoke-virtual {v0, p1}, Lio/dcloud/common/adapter/util/ViewRect;->delRelViewRect(Lio/dcloud/common/adapter/util/ViewRect;)V

    .line 25
    :cond_3
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->resize()V

    :cond_4
    :goto_0
    return-void
.end method

.method c(Ljava/lang/String;Ljava/lang/String;Z)Z
    .locals 4

    .line 63
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    .line 64
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    sub-int/2addr v0, v1

    :goto_0
    if-ltz v0, :cond_1

    .line 66
    iget-object v2, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lio/dcloud/feature/ui/b;

    .line 67
    instance-of v3, v2, Lio/dcloud/feature/ui/c;

    if-eqz v3, :cond_0

    check-cast v2, Lio/dcloud/feature/ui/c;

    iget-boolean v3, v2, Lio/dcloud/feature/ui/c;->F:Z

    if-eqz v3, :cond_0

    .line 68
    invoke-virtual {v2, p1, p2, p3}, Lio/dcloud/feature/ui/c;->c(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 74
    :cond_1
    invoke-virtual {p0, p1}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 75
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result p1

    return p1

    .line 77
    :cond_2
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    instance-of p2, p1, Lio/dcloud/common/adapter/ui/AdaFrameView;

    if-eqz p2, :cond_4

    .line 78
    check-cast p1, Lio/dcloud/common/adapter/ui/AdaFrameView;

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p1

    iget-object p1, p1, Lio/dcloud/common/adapter/util/ViewOptions;->historyBack:Ljava/lang/String;

    .line 79
    const-string p2, "backButton"

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_3

    const-string p2, "all"

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_4

    .line 80
    :cond_3
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    if-eqz p1, :cond_4

    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebview;->canGoBack()Z

    move-result p1

    if-eqz p1, :cond_4

    .line 81
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    const/4 p2, -0x1

    invoke-interface {p1, p2}, Lio/dcloud/common/DHInterface/IWebview;->goBackOrForward(I)V

    return v1

    .line 86
    :cond_4
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p1

    iget-object p1, p1, Lio/dcloud/common/adapter/util/ViewOptions;->backButtonAutoControl:Ljava/lang/String;

    const-string p2, "hide"

    invoke-virtual {p2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    const-string p2, "[\'auto\',null]"

    if-eqz p1, :cond_5

    .line 87
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-static {p2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p2

    invoke-direct {p0, p1, p2, p0}, Lio/dcloud/feature/ui/c;->d(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    return v1

    .line 89
    :cond_5
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p1

    iget-object p1, p1, Lio/dcloud/common/adapter/util/ViewOptions;->backButtonAutoControl:Ljava/lang/String;

    const-string p3, "quit"

    invoke-virtual {p3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_6

    .line 90
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object p1, p1, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object p2, Lio/dcloud/common/DHInterface/IMgr$MgrType;->WindowMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object p3, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p3}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object p3

    const/16 v0, 0x14

    invoke-interface {p1, p2, v0, p3}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 91
    :cond_6
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->d()Lio/dcloud/common/adapter/ui/AdaFrameItem;

    move-result-object p1

    invoke-virtual {p1}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object p1

    iget-object p1, p1, Lio/dcloud/common/adapter/util/ViewOptions;->backButtonAutoControl:Ljava/lang/String;

    const-string p3, "close"

    invoke-virtual {p3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_7

    .line 92
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object p1

    invoke-static {p2}, Lio/dcloud/common/util/JSONUtil;->createJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object p2

    invoke-virtual {p0, p1, p2, p0}, Lio/dcloud/feature/ui/c;->b(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;)V

    return v1

    :cond_7
    :goto_1
    const/4 p1, 0x0

    return p1
.end method

.method public d()Lio/dcloud/common/adapter/ui/AdaFrameItem;
    .locals 1

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    return-object v0
.end method

.method protected d(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "maps"

    aput-object p1, p2, v2

    const-string p1, "appendToFrameView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method protected e()V
    .locals 5

    .line 221
    invoke-direct {p0}, Lio/dcloud/feature/ui/c;->i()V

    .line 222
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lio/dcloud/feature/ui/c;->X:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 223
    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    :cond_0
    const/4 v0, 0x0

    .line 225
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->W:Lio/dcloud/feature/ui/c;

    .line 226
    iput-object v0, p0, Lio/dcloud/feature/ui/b;->a:Lio/dcloud/feature/ui/c;

    .line 227
    iget-object v1, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    if-eqz v1, :cond_2

    .line 228
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v2, :cond_1

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    add-int/lit8 v3, v3, 0x1

    check-cast v4, Lio/dcloud/feature/ui/b;

    .line 229
    invoke-virtual {v4}, Lio/dcloud/feature/ui/b;->e()V

    goto :goto_0

    .line 231
    :cond_1
    iget-object v1, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 232
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->M:Ljava/util/ArrayList;

    .line 234
    :cond_2
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->P:Lio/dcloud/common/DHInterface/IWebview;

    .line 235
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->O:Ljava/lang/String;

    .line 236
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->Q:Ljava/lang/String;

    .line 237
    iput-object v0, p0, Lio/dcloud/feature/ui/c;->R:Lio/dcloud/common/DHInterface/IWebview;

    const/16 v1, 0x96

    .line 238
    iput v1, p0, Lio/dcloud/feature/ui/c;->a0:I

    .line 239
    iput-object v0, p0, Lio/dcloud/feature/ui/b;->i:Lio/dcloud/common/DHInterface/IWebview;

    .line 240
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->b:Ljava/util/HashMap;

    if-eqz v0, :cond_3

    .line 241
    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_3
    return-void
.end method

.method protected e(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "nativeobj"

    aput-object p1, p2, v2

    const-string p1, "addNativeView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method protected f(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string/jumbo p1, "videoplayer"

    aput-object p1, p2, v2

    const-string p1, "appendToFrameView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public h()Ljava/lang/String;
    .locals 10

    .line 2
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x3

    const/4 v2, 0x2

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x4

    const-string/jumbo v6, "{}"

    if-eqz v0, :cond_1

    .line 3
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    iget-object v7, p0, Lio/dcloud/feature/ui/b;->d:Ljava/lang/String;

    iget-object v8, p0, Lio/dcloud/feature/ui/c;->x:Lorg/json/JSONObject;

    if-nez v8, :cond_0

    goto :goto_0

    :cond_0
    invoke-virtual {v8}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_0
    new-array v5, v5, [Ljava/lang/Object;

    aput-object v0, v5, v4

    const-string v0, "undefined"

    aput-object v0, v5, v3

    aput-object v7, v5, v2

    aput-object v6, v5, v1

    const-string v0, "(function(){return {\'uuid\':\'%s\',\'id\':%s,\'identity\':\'%s\',\'extras\':%s}})()"

    invoke-static {v0, v5}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 5
    :cond_1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->r()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v7

    invoke-interface {v7}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameId()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lio/dcloud/feature/ui/b;->d:Ljava/lang/String;

    iget-object v9, p0, Lio/dcloud/feature/ui/c;->x:Lorg/json/JSONObject;

    if-nez v9, :cond_2

    goto :goto_1

    :cond_2
    invoke-virtual {v9}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v6

    :goto_1
    new-array v5, v5, [Ljava/lang/Object;

    aput-object v0, v5, v4

    aput-object v7, v5, v3

    aput-object v8, v5, v2

    aput-object v6, v5, v1

    const-string v0, "(function(){return {\'uuid\':\'%s\',\'id\':\'%s\',\'identity\':\'%s\',\'extras\':%s}})()"

    invoke-static {v0, v5}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected h(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;)V
    .locals 6

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v0, v0, Lio/dcloud/feature/ui/a;->d:Lio/dcloud/common/DHInterface/AbsMgr;

    sget-object v1, Lio/dcloud/common/DHInterface/IMgr$MgrType;->FeatureMgr:Lio/dcloud/common/DHInterface/IMgr$MgrType;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    const/4 v3, 0x2

    new-array v4, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v2, 0x1

    aput-object p2, v4, v2

    const/4 p2, 0x4

    new-array p2, p2, [Ljava/lang/Object;

    aput-object p1, p2, v5

    const-string p1, "nativeobj"

    aput-object p1, p2, v2

    const-string p1, "removeNativeView"

    aput-object p1, p2, v3

    const/4 p1, 0x3

    aput-object v4, p2, p1

    const/16 p1, 0xa

    invoke-interface {v0, v1, p1, p2}, Lio/dcloud/common/DHInterface/IMgr;->processEvent(Lio/dcloud/common/DHInterface/IMgr$MgrType;ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method

.method public l()V
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->m:Ljava/util/HashMap;

    if-eqz v0, :cond_1

    const-string v1, "rendered"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->c0:Ljava/lang/Runnable;

    if-eqz v0, :cond_0

    .line 3
    invoke-static {v0}, Lio/dcloud/common/adapter/util/MessageHandler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 5
    :cond_0
    new-instance v0, Lio/dcloud/feature/ui/c$a;

    invoke-direct {v0, p0}, Lio/dcloud/feature/ui/c$a;-><init>(Lio/dcloud/feature/ui/c;)V

    iput-object v0, p0, Lio/dcloud/feature/ui/c;->c0:Ljava/lang/Runnable;

    .line 17
    iget v1, p0, Lio/dcloud/feature/ui/c;->a0:I

    int-to-long v1, v1

    invoke-static {v0, v1, v2}, Lio/dcloud/common/adapter/util/MessageHandler;->postDelayed(Ljava/lang/Runnable;J)V

    :cond_1
    return-void
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 3
    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IWebview;->obtainFrameId()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method protected n()Ljava/lang/String;
    .locals 6

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    check-cast v0, Lio/dcloud/common/adapter/ui/AdaFrameItem;

    invoke-virtual {v0}, Lio/dcloud/common/adapter/ui/AdaFrameItem;->obtainFrameOptions()Lio/dcloud/common/adapter/util/ViewOptions;

    move-result-object v0

    .line 3
    iget v1, v0, Lio/dcloud/common/adapter/util/ViewRect;->top:I

    int-to-float v1, v1

    iget v2, v0, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    div-float/2addr v1, v2

    float-to-int v1, v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget v2, v0, Lio/dcloud/common/adapter/util/ViewRect;->left:I

    int-to-float v2, v2

    iget v3, v0, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    div-float/2addr v2, v3

    float-to-int v2, v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, v0, Lio/dcloud/common/adapter/util/ViewRect;->width:I

    int-to-float v3, v3

    iget v4, v0, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    div-float/2addr v3, v4

    float-to-int v3, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iget v4, v0, Lio/dcloud/common/adapter/util/ViewRect;->height:I

    int-to-float v4, v4

    iget v0, v0, Lio/dcloud/common/adapter/util/ViewRect;->mWebviewScale:F

    div-float/2addr v4, v0

    float-to-int v0, v4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    const/4 v1, 0x1

    aput-object v2, v4, v1

    const/4 v1, 0x2

    aput-object v3, v4, v1

    const/4 v1, 0x3

    aput-object v0, v4, v1

    const-string/jumbo v0, "{top:%d,left:%d,width:%d,height:%d}"

    invoke-static {v0, v4}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public o()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->isWebviewCovered()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method public onCallBack(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 13

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "NWindow.onCallBack pEventType="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x2

    new-array v2, v1, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    const/4 v0, 0x1

    aput-object p2, v2, v0

    const-string/jumbo v4, "yl"

    invoke-static {v4, v2}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 2
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v2

    const/16 v4, 0x8

    const/4 v5, 0x7

    const/4 v6, 0x6

    const-string v7, "touchstart"

    const/4 v8, 0x5

    const/4 v9, 0x4

    const/4 v10, 0x3

    const/4 v11, -0x1

    sparse-switch v2, :sswitch_data_0

    :goto_0
    const/4 v2, -0x1

    goto/16 :goto_1

    :sswitch_0
    const-string v2, "show_loading"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    goto :goto_0

    :cond_0
    const/16 v2, 0x12

    goto/16 :goto_1

    :sswitch_1
    const-string v2, "titleNViewSearchInputClicked"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    goto :goto_0

    :cond_1
    const/16 v2, 0x11

    goto/16 :goto_1

    :sswitch_2
    const-string v2, "titleNViewSearchInputChanged"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    goto :goto_0

    :cond_2
    const/16 v2, 0x10

    goto/16 :goto_1

    :sswitch_3
    const-string v2, "slide_webview_close"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    goto :goto_0

    :cond_3
    const/16 v2, 0xf

    goto/16 :goto_1

    :sswitch_4
    const-string v2, "titleNViewSearchInputConfirmed"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    goto :goto_0

    :cond_4
    const/16 v2, 0xe

    goto/16 :goto_1

    :sswitch_5
    const-string v2, "titleUpdate"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    goto :goto_0

    :cond_5
    const/16 v2, 0xd

    goto/16 :goto_1

    :sswitch_6
    const-string v2, "slide_webview_hide"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_6

    goto :goto_0

    :cond_6
    const/16 v2, 0xc

    goto/16 :goto_1

    :sswitch_7
    const-string v2, "overrideUrlLoading"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_7

    goto :goto_0

    :cond_7
    const/16 v2, 0xb

    goto/16 :goto_1

    :sswitch_8
    const-string v2, "popGesture"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_8

    goto :goto_0

    :cond_8
    const/16 v2, 0xa

    goto/16 :goto_1

    :sswitch_9
    const-string v2, "show_animation_end"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_9

    goto/16 :goto_0

    :cond_9
    const/16 v2, 0x9

    goto/16 :goto_1

    :sswitch_a
    const-string v2, "progressChanged"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_a

    goto/16 :goto_0

    :cond_a
    const/16 v2, 0x8

    goto :goto_1

    :sswitch_b
    const-string v2, "resize"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_b

    goto/16 :goto_0

    :cond_b
    const/4 v2, 0x7

    goto :goto_1

    :sswitch_c
    const-string v2, "hide_loading"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_c

    goto/16 :goto_0

    :cond_c
    const/4 v2, 0x6

    goto :goto_1

    :sswitch_d
    const-string v2, "titleNViewSearchInputFocusChanged"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_d

    goto/16 :goto_0

    :cond_d
    const/4 v2, 0x5

    goto :goto_1

    :sswitch_e
    const-string v2, "slideBounce"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_e

    goto/16 :goto_0

    :cond_e
    const/4 v2, 0x4

    goto :goto_1

    :sswitch_f
    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_f

    goto/16 :goto_0

    :cond_f
    const/4 v2, 0x3

    goto :goto_1

    :sswitch_10
    const-string v2, "dragBounce"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_10

    goto/16 :goto_0

    :cond_10
    const/4 v2, 0x2

    goto :goto_1

    :sswitch_11
    const-string v2, "onresize"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_11

    goto/16 :goto_0

    :cond_11
    const/4 v2, 0x1

    goto :goto_1

    :sswitch_12
    const-string v2, "listenResourceLoading"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_12

    goto/16 :goto_0

    :cond_12
    const/4 v2, 0x0

    :goto_1
    const/4 v12, 0x0

    packed-switch v2, :pswitch_data_0

    .line 83
    sget-object v2, Lio/dcloud/feature/ui/c;->d0:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 84
    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_13

    .line 85
    iget-object v7, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    iget-object v7, v7, Lio/dcloud/feature/ui/a;->c:Ljava/util/List;

    invoke-static {v2, p2, v7, p0}, Lio/dcloud/feature/ui/c;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Lio/dcloud/feature/ui/c;)V

    .line 87
    :cond_13
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v2

    sparse-switch v2, :sswitch_data_1

    :goto_2
    const/4 v1, -0x1

    goto/16 :goto_3

    :sswitch_13
    const-string v0, "rendering"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_14

    goto :goto_2

    :cond_14
    const/16 v1, 0x8

    goto :goto_3

    :sswitch_14
    const-string v0, "loading"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_15

    goto :goto_2

    :cond_15
    const/4 v1, 0x7

    goto :goto_3

    :sswitch_15
    const-string v0, "pullToRefresh"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16

    goto :goto_2

    :cond_16
    const/4 v1, 0x6

    goto :goto_3

    :sswitch_16
    const-string v0, "close"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_17

    goto :goto_2

    :cond_17
    const/4 v1, 0x5

    goto :goto_3

    :sswitch_17
    const-string v0, "hide"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_18

    goto :goto_2

    :cond_18
    const/4 v1, 0x4

    goto :goto_3

    :sswitch_18
    const-string/jumbo v0, "webPause"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_19

    goto :goto_2

    :cond_19
    const/4 v1, 0x3

    goto :goto_3

    :sswitch_19
    const-string/jumbo v0, "window_close"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c

    goto :goto_2

    :sswitch_1a
    const-string v1, "loaded"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1a

    goto :goto_2

    :cond_1a
    const/4 v1, 0x1

    goto :goto_3

    :sswitch_1b
    const-string/jumbo v0, "webResume"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1b

    goto :goto_2

    :cond_1b
    const/4 v1, 0x0

    .line 118
    :cond_1c
    :goto_3
    const-string/jumbo v0, "{}"

    packed-switch v1, :pswitch_data_1

    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    move-object p2, v12

    goto :goto_4

    :cond_1d
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    :goto_4
    invoke-virtual {p0, p1, p2}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;)Z

    goto/16 :goto_b

    .line 119
    :pswitch_0
    iget-object p2, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {p2, p0}, Lio/dcloud/feature/ui/a;->b(Lio/dcloud/feature/ui/c;)V

    .line 120
    invoke-virtual {p0, p1, v0, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto/16 :goto_b

    .line 121
    :pswitch_1
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1e

    move-object p2, v12

    goto :goto_5

    :cond_1e
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    :goto_5
    invoke-virtual {p0, p1, p2}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;)Z

    .line 122
    invoke-virtual {p0}, Lio/dcloud/feature/ui/b;->g()V

    goto/16 :goto_b

    .line 123
    :pswitch_2
    iput v11, p0, Lio/dcloud/feature/ui/c;->A:I

    .line 124
    iget-object p2, p0, Lio/dcloud/feature/ui/c;->v:Lorg/json/JSONArray;

    if-eqz p2, :cond_1f

    .line 125
    iget-object v1, p0, Lio/dcloud/feature/ui/c;->w:Lio/dcloud/common/DHInterface/IWebview;

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IFrameView;->obtainApp()Lio/dcloud/common/DHInterface/IApp;

    move-result-object v2

    invoke-interface {v2}, Lio/dcloud/common/DHInterface/IApp;->obtainAppId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, p2, p0, v2}, Lio/dcloud/feature/ui/c;->a(Lio/dcloud/common/DHInterface/IWebview;Lorg/json/JSONArray;Lio/dcloud/feature/ui/c;Ljava/lang/String;)V

    .line 127
    :cond_1f
    sget-object p2, Lio/dcloud/common/util/TestUtil;->CREATE_WEBVIEW:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " \u4ece\u52a0\u8f7d\u5b8c\u6210\u5206\u53d1loaded\u4e8b\u4ef6\u5230\u5f00\u59cb\u5206\u53d1\u4e8b\u4ef6 "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {p2, v1}, Lio/dcloud/common/util/TestUtil;->print(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    new-instance p2, Ljava/lang/StringBuilder;

    const-string v1, "EVENTS_LOADED mUrl="

    invoke-direct {p2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lio/dcloud/feature/ui/c;->z:Ljava/lang/String;

    invoke-virtual {p2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    const-string v1, "Main_Path"

    invoke-static {v1, p2}, Lio/dcloud/common/adapter/util/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    invoke-virtual {p0, p1, v0, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto/16 :goto_b

    .line 148
    :pswitch_3
    invoke-virtual {p0, p1, v0, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto/16 :goto_b

    .line 149
    :pswitch_4
    iget-boolean p1, p0, Lio/dcloud/feature/ui/c;->I:Z

    if-eqz p1, :cond_26

    .line 150
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {p1, p0}, Lio/dcloud/feature/ui/a;->f(Lio/dcloud/feature/ui/c;)V

    goto/16 :goto_b

    .line 187
    :pswitch_5
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_20

    move-object p2, v12

    goto :goto_6

    :cond_20
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    :goto_6
    invoke-virtual {p0, p1, p2}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;)Z

    goto/16 :goto_b

    .line 188
    :pswitch_6
    invoke-direct {p0}, Lio/dcloud/feature/ui/c;->s()V

    goto/16 :goto_b

    :pswitch_7
    if-nez p2, :cond_21

    .line 189
    const-string p2, "\'\'"

    goto :goto_7

    :cond_21
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-static {p2}, Lorg/json/JSONObject;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    :goto_7
    new-array v0, v0, [Ljava/lang/Object;

    aput-object p2, v0, v3

    const-string/jumbo p2, "{title:%s}"

    invoke-static {p2, v0}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p0, p1, p2, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    .line 190
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->l()V

    goto/16 :goto_b

    .line 222
    :pswitch_8
    invoke-direct {p0}, Lio/dcloud/feature/ui/c;->t()V

    goto/16 :goto_b

    .line 223
    :pswitch_9
    iget-object v4, p0, Lio/dcloud/feature/ui/c;->R:Lio/dcloud/common/DHInterface/IWebview;

    iget-object v5, p0, Lio/dcloud/feature/ui/c;->Q:Ljava/lang/String;

    move-object v6, p2

    check-cast v6, Ljava/lang/String;

    sget v7, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v8, 0x1

    const/4 v9, 0x1

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    goto/16 :goto_b

    .line 257
    :pswitch_a
    check-cast p2, [Ljava/lang/Object;

    .line 258
    aget-object v2, p2, v3

    check-cast v2, Ljava/lang/String;

    .line 259
    aget-object v4, p2, v0

    .line 260
    aget-object p2, p2, v1

    check-cast p2, Lio/dcloud/common/DHInterface/IFrameView;

    .line 261
    iget-object v5, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {v5, p2}, Lio/dcloud/feature/ui/a;->a(Lio/dcloud/common/DHInterface/IFrameView;)Lio/dcloud/feature/ui/c;

    move-result-object p2

    .line 263
    iget-object v5, p2, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    iget-object v6, p2, Lio/dcloud/feature/ui/b;->f:Ljava/lang/String;

    iget-object p2, p2, Lio/dcloud/feature/ui/c;->x:Lorg/json/JSONObject;

    new-array v7, v8, [Ljava/lang/Object;

    aput-object v2, v7, v3

    aput-object v4, v7, v0

    aput-object v5, v7, v1

    aput-object v6, v7, v10

    aput-object p2, v7, v9

    const-string/jumbo p2, "{type:\'%s\', result:%s, private_args:{uuid:\'%s\',id:\'%s\',extras:\'%s\'}}"

    invoke-static {p2, v7}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p0, p1, p2, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto/16 :goto_b

    .line 264
    :pswitch_b
    iget-object p1, p0, Lio/dcloud/feature/ui/c;->O:Ljava/lang/String;

    invoke-static {p1}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result p1

    if-nez p1, :cond_22

    iget-object v0, p0, Lio/dcloud/feature/ui/c;->P:Lio/dcloud/common/DHInterface/IWebview;

    if-eqz v0, :cond_22

    .line 265
    iget-object v1, p0, Lio/dcloud/feature/ui/c;->O:Ljava/lang/String;

    sget v3, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v2, ""

    invoke-static/range {v0 .. v5}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    .line 267
    :cond_22
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_23

    move-object p1, v12

    goto :goto_8

    :cond_23
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    :goto_8
    const-string p2, "show"

    invoke-virtual {p0, p2, p1}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;)Z

    goto/16 :goto_b

    .line 288
    :pswitch_c
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v4, "plus.webview._find__Window_By_UUID__(\'"

    invoke-direct {v2, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lio/dcloud/feature/ui/b;->f:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "\',\'"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v4, p0, Lio/dcloud/feature/ui/b;->e:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "\')"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p2, v1, v3

    aput-object v2, v1, v0

    const-string/jumbo p2, "{progress:%s,target:%s}"

    invoke-static {p2, v1}, Lio/dcloud/common/util/StringUtil;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p0, p1, p2, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto :goto_b

    .line 289
    :pswitch_d
    iget-object p1, p0, Lio/dcloud/feature/ui/b;->c:Lio/dcloud/feature/ui/a;

    invoke-virtual {p1, p0}, Lio/dcloud/feature/ui/a;->d(Lio/dcloud/feature/ui/c;)V

    goto :goto_b

    .line 329
    :pswitch_e
    iget-object v0, p0, Lio/dcloud/feature/ui/b;->m:Ljava/util/HashMap;

    if-eqz v0, :cond_26

    invoke-virtual {v0, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_26

    .line 330
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_24

    move-object p2, v12

    goto :goto_9

    :cond_24
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    :goto_9
    invoke-virtual {p0, p1, p2}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_b

    .line 331
    :pswitch_f
    invoke-static {p2}, Lio/dcloud/common/util/PdrUtil;->isEmpty(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_25

    move-object p2, v12

    goto :goto_a

    :cond_25
    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p2

    :goto_a
    invoke-virtual {p0, p1, p2, v3}, Lio/dcloud/feature/ui/b;->a(Ljava/lang/String;Ljava/lang/String;Z)Z

    goto :goto_b

    .line 370
    :pswitch_10
    invoke-virtual {p0}, Lio/dcloud/feature/ui/c;->q()V

    goto :goto_b

    .line 371
    :pswitch_11
    iget-object v4, p0, Lio/dcloud/feature/ui/c;->T:Lio/dcloud/common/DHInterface/IWebview;

    iget-object v5, p0, Lio/dcloud/feature/ui/c;->S:Ljava/lang/String;

    move-object v6, p2

    check-cast v6, Ljava/lang/String;

    sget v7, Lio/dcloud/common/util/JSUtil;->OK:I

    const/4 v8, 0x1

    const/4 v9, 0x1

    invoke-static/range {v4 .. v9}, Lio/dcloud/common/util/JSUtil;->execCallback(Lio/dcloud/common/DHInterface/IWebview;Ljava/lang/String;Ljava/lang/String;IZZ)V

    :cond_26
    :goto_b
    return-object v12

    nop

    :sswitch_data_0
    .sparse-switch
        -0x7a44d379 -> :sswitch_12
        -0x722278ad -> :sswitch_11
        -0x70efa724 -> :sswitch_10
        -0x5e176b7d -> :sswitch_f
        -0x5478a867 -> :sswitch_e
        -0x4612885d -> :sswitch_d
        -0x41b6fcc1 -> :sswitch_c
        -0x37b2634c -> :sswitch_b
        -0x14fa2439 -> :sswitch_a
        -0xfd36022 -> :sswitch_9
        -0x4efca48 -> :sswitch_8
        0x11431b9 -> :sswitch_7
        0xaffa196 -> :sswitch_6
        0x21fc2541 -> :sswitch_5
        0x3bda4fd8 -> :sswitch_4
        0x54afa424 -> :sswitch_3
        0x552e396d -> :sswitch_2
        0x5c6d66e0 -> :sswitch_1
        0x69fe15fa -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_f
        :pswitch_f
        :pswitch_d
        :pswitch_f
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_f
        :pswitch_6
        :pswitch_f
        :pswitch_5
        :pswitch_4
    .end packed-switch

    :sswitch_data_1
    .sparse-switch
        -0x46844f5f -> :sswitch_1b
        -0x416acffb -> :sswitch_1a
        -0x2eea9717 -> :sswitch_19
        -0x2baea0fe -> :sswitch_18
        0x30dd42 -> :sswitch_17
        0x5a5ddf8 -> :sswitch_16
        0x11fc9b1b -> :sswitch_15
        0x1410e13c -> :sswitch_14
        0x6da6e68c -> :sswitch_13
    .end sparse-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_3
        :pswitch_0
        :pswitch_3
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method public p()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/feature/ui/c;->b0:Z

    return v0
.end method

.method protected q()V
    .locals 0

    return-void
.end method

.method public r()Lio/dcloud/common/DHInterface/IWebview;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/ui/c;->y:Lio/dcloud/common/DHInterface/IFrameView;

    invoke-interface {v0}, Lio/dcloud/common/DHInterface/IFrameView;->obtainWebView()Lio/dcloud/common/DHInterface/IWebview;

    move-result-object v0

    return-object v0
.end method
