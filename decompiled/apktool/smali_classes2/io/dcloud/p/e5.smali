.class public abstract Lio/dcloud/p/e5;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/DHInterface/IAppInfo;


# instance fields
.field protected a:Landroid/app/Activity;

.field protected b:Lio/dcloud/common/DHInterface/IWebAppRootView;

.field private c:Lio/dcloud/common/DHInterface/IOnCreateSplashView;

.field public d:I

.field public e:I

.field public f:I

.field public g:I

.field public h:I

.field protected i:Z

.field private j:Z

.field private k:I

.field l:Lio/dcloud/common/adapter/util/ViewRect;

.field m:Lio/dcloud/common/util/AppStatusBarManager;

.field public n:Ljava/lang/String;

.field public o:Ljava/lang/String;

.field protected p:Z

.field protected q:Z

.field private r:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 3
    iput-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    .line 4
    iput-object v0, p0, Lio/dcloud/p/e5;->b:Lio/dcloud/common/DHInterface/IWebAppRootView;

    .line 5
    iput-object v0, p0, Lio/dcloud/p/e5;->c:Lio/dcloud/common/DHInterface/IOnCreateSplashView;

    const/4 v1, 0x0

    .line 7
    iput v1, p0, Lio/dcloud/p/e5;->d:I

    .line 9
    iput v1, p0, Lio/dcloud/p/e5;->e:I

    .line 11
    iput v1, p0, Lio/dcloud/p/e5;->f:I

    .line 13
    iput v1, p0, Lio/dcloud/p/e5;->g:I

    .line 15
    iput v1, p0, Lio/dcloud/p/e5;->h:I

    .line 18
    iput-boolean v1, p0, Lio/dcloud/p/e5;->i:Z

    .line 20
    iput-boolean v1, p0, Lio/dcloud/p/e5;->j:Z

    .line 21
    iput v1, p0, Lio/dcloud/p/e5;->k:I

    .line 23
    new-instance v2, Lio/dcloud/common/adapter/util/ViewRect;

    invoke-direct {v2}, Lio/dcloud/common/adapter/util/ViewRect;-><init>()V

    iput-object v2, p0, Lio/dcloud/p/e5;->l:Lio/dcloud/common/adapter/util/ViewRect;

    .line 25
    const-string v2, "none"

    iput-object v2, p0, Lio/dcloud/p/e5;->n:Ljava/lang/String;

    .line 27
    iput-object v0, p0, Lio/dcloud/p/e5;->o:Ljava/lang/String;

    .line 29
    iput-boolean v1, p0, Lio/dcloud/p/e5;->p:Z

    .line 30
    iput-boolean v1, p0, Lio/dcloud/p/e5;->q:Z

    .line 32
    iput-object v0, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    return-void
.end method


# virtual methods
.method public a(I)V
    .locals 2

    .line 5
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x24

    if-lt v0, v1, :cond_2

    sget v0, Lio/dcloud/common/adapter/util/AndroidResources;->sAppTargetSdkVersion:I

    if-lt v0, v1, :cond_2

    .line 7
    :try_start_0
    iget-object v0, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    if-nez v0, :cond_0

    .line 8
    new-instance v0, Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    .line 10
    :cond_0
    iget-object v0, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_1

    .line 11
    invoke-virtual {v0, p1}, Landroid/view/View;->setBackgroundColor(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    :cond_1
    return-void

    .line 16
    :cond_2
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/view/Window;->setNavigationBarColor(I)V

    return-void
.end method

.method a(Landroid/app/Activity;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->m:Lio/dcloud/common/util/AppStatusBarManager;

    if-nez v0, :cond_0

    .line 2
    new-instance v0, Lio/dcloud/common/util/AppStatusBarManager;

    invoke-direct {v0, p1, p0}, Lio/dcloud/common/util/AppStatusBarManager;-><init>(Landroid/app/Activity;Lio/dcloud/p/e5;)V

    iput-object v0, p0, Lio/dcloud/p/e5;->m:Lio/dcloud/common/util/AppStatusBarManager;

    .line 4
    :cond_0
    iput-object p1, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    return-void
.end method

.method public checkSelfPermission(Ljava/lang/String;Ljava/lang/String;)I
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-static {v0, p1, p2}, Lio/dcloud/common/adapter/util/PermissionUtil;->checkSelfPermission(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)I

    move-result p1

    return p1
.end method

.method public clearMaskLayerCount()V
    .locals 1

    const/4 v0, 0x0

    .line 1
    iput v0, p0, Lio/dcloud/p/e5;->k:I

    return-void
.end method

.method public getActivity()Landroid/app/Activity;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    return-object v0
.end method

.method public getAppViewRect()Lio/dcloud/common/adapter/util/ViewRect;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->l:Lio/dcloud/common/adapter/util/ViewRect;

    return-object v0
.end method

.method public getInt(I)I
    .locals 1

    if-eqz p1, :cond_2

    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-eq p1, v0, :cond_0

    const/4 p1, -0x1

    return p1

    .line 1
    :cond_0
    iget p1, p0, Lio/dcloud/p/e5;->e:I

    return p1

    .line 2
    :cond_1
    iget p1, p0, Lio/dcloud/p/e5;->h:I

    return p1

    .line 3
    :cond_2
    iget p1, p0, Lio/dcloud/p/e5;->d:I

    return p1
.end method

.method public getMaskLayerCount()I
    .locals 1

    .line 1
    iget v0, p0, Lio/dcloud/p/e5;->k:I

    return v0
.end method

.method public getOnCreateSplashView()Lio/dcloud/common/DHInterface/IOnCreateSplashView;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->c:Lio/dcloud/common/DHInterface/IOnCreateSplashView;

    return-object v0
.end method

.method public getRequestedOrientation()I
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getRequestedOrientation()I

    move-result v0

    return v0
.end method

.method public isFullScreen()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lio/dcloud/p/e5;->i:Z

    return v0
.end method

.method public isVerticalScreen()Z
    .locals 2

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    return v1

    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public obtainWebAppRootView()Lio/dcloud/common/DHInterface/IWebAppRootView;
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->b:Lio/dcloud/common/DHInterface/IWebAppRootView;

    return-object v0
.end method

.method public requestPermissions([Ljava/lang/String;I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-static {v0, p1, p2}, Lio/dcloud/common/adapter/util/PermissionUtil;->requestPermissions(Landroid/app/Activity;[Ljava/lang/String;I)V

    return-void
.end method

.method public setFullScreen(Z)V
    .locals 2

    .line 1
    sget-boolean v0, Lio/dcloud/common/util/BaseInfo;->sGlobalFullScreen:Z

    if-eq v0, p1, :cond_2

    .line 2
    iput-boolean p1, p0, Lio/dcloud/p/e5;->i:Z

    .line 3
    iget-object v0, p0, Lio/dcloud/p/e5;->m:Lio/dcloud/common/util/AppStatusBarManager;

    if-eqz v0, :cond_0

    .line 4
    invoke-virtual {p0}, Lio/dcloud/p/e5;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Lio/dcloud/common/util/AppStatusBarManager;->setFullScreen(Landroid/app/Activity;Z)V

    .line 6
    :cond_0
    iget-boolean v0, p0, Lio/dcloud/p/e5;->i:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    goto :goto_0

    :cond_1
    const/4 v0, 0x3

    :goto_0
    invoke-virtual {p0, v0}, Lio/dcloud/p/e5;->updateScreenInfo(I)V

    .line 8
    :cond_2
    sput-boolean p1, Lio/dcloud/common/util/BaseInfo;->sGlobalFullScreen:Z

    return-void
.end method

.method public setMaskLayer(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lio/dcloud/p/e5;->j:Z

    if-eqz p1, :cond_0

    .line 3
    iget p1, p0, Lio/dcloud/p/e5;->k:I

    add-int/lit8 p1, p1, 0x1

    iput p1, p0, Lio/dcloud/p/e5;->k:I

    return-void

    .line 5
    :cond_0
    iget p1, p0, Lio/dcloud/p/e5;->k:I

    add-int/lit8 p1, p1, -0x1

    iput p1, p0, Lio/dcloud/p/e5;->k:I

    if-gez p1, :cond_1

    const/4 p1, 0x0

    .line 6
    iput p1, p0, Lio/dcloud/p/e5;->k:I

    :cond_1
    return-void
.end method

.method public setOnCreateSplashView(Lio/dcloud/common/DHInterface/IOnCreateSplashView;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/e5;->c:Lio/dcloud/common/DHInterface/IOnCreateSplashView;

    return-void
.end method

.method public setRequestedOrientation(I)V
    .locals 1

    .line 23
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    return-void
.end method

.method public setRequestedOrientation(Ljava/lang/String;)V
    .locals 3

    .line 1
    :try_start_0
    new-instance v0, Lio/dcloud/p/e5$a;

    invoke-direct {v0, p0, p1}, Lio/dcloud/p/e5$a;-><init>(Lio/dcloud/p/e5;Ljava/lang/String;)V

    const-wide/16 v1, 0x30

    invoke-static {v0, v1, v2, p1}, Lio/dcloud/common/adapter/util/MessageHandler;->sendMessage(Lio/dcloud/common/adapter/util/MessageHandler$IMessages;JLjava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception p1

    .line 22
    invoke-virtual {p1}, Ljava/lang/Throwable;->printStackTrace()V

    return-void
.end method

.method public setWebAppRootView(Lio/dcloud/common/DHInterface/IWebAppRootView;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/e5;->b:Lio/dcloud/common/DHInterface/IWebAppRootView;

    return-void
.end method

.method public updateScreenInfo(I)V
    .locals 9

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const v1, 0x1020002

    const/16 v2, 0x24

    if-lt v0, v2, :cond_4

    sget v0, Lio/dcloud/common/adapter/util/AndroidResources;->sAppTargetSdkVersion:I

    if-lt v0, v2, :cond_4

    .line 3
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 5
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    instance-of v2, v2, Landroid/view/ViewGroup$MarginLayoutParams;

    if-eqz v2, :cond_0

    .line 6
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 7
    iget-object v2, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    invoke-static {v2}, Lio/dcloud/p/g4$$ExternalSyntheticApiModelOutline0;->m(Landroid/view/View;)Landroid/view/WindowInsets;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 9
    invoke-static {}, Landroidx/core/util/HalfKt$$ExternalSyntheticApiModelOutline0;->m$2()I

    move-result v3

    invoke-static {v2, v3}, Landroidx/core/util/HalfKt$$ExternalSyntheticApiModelOutline0;->m$1(Landroid/view/WindowInsets;I)Landroid/graphics/Insets;

    move-result-object v2

    .line 10
    invoke-static {v2}, Landroidx/appcompat/widget/SearchView$$ExternalSyntheticApiModelOutline0;->m(Landroid/graphics/Insets;)I

    move-result v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 11
    invoke-static {v2}, Landroidx/appcompat/widget/SearchView$$ExternalSyntheticApiModelOutline0;->m$1(Landroid/graphics/Insets;)I

    move-result v3

    iput v3, v0, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    .line 13
    invoke-static {v2}, Landroidx/appcompat/widget/SearchView$$ExternalSyntheticApiModelOutline0;->m$3(Landroid/graphics/Insets;)I

    move-result v2

    iput v2, v0, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    .line 17
    :cond_0
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    const v2, 0x1020030

    invoke-virtual {v0, v2}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_4

    .line 19
    iget-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    if-nez v2, :cond_1

    .line 20
    new-instance v2, Landroid/widget/RelativeLayout;

    iget-object v3, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-direct {v2, v3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    .line 21
    :cond_1
    iget-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v2}, Landroid/view/View;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    if-nez v2, :cond_2

    .line 22
    iget-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/view/View;->setBackgroundColor(I)V

    .line 23
    :cond_2
    iget-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    if-nez v2, :cond_3

    .line 24
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iget-object v3, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 26
    :cond_3
    iget-object v2, p0, Lio/dcloud/p/e5;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 29
    :cond_4
    :goto_0
    iget-boolean v0, p0, Lio/dcloud/p/e5;->i:Z

    if-nez v0, :cond_5

    .line 30
    iget v0, p0, Lio/dcloud/p/e5;->f:I

    if-nez v0, :cond_5

    .line 31
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 32
    iget-object v2, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 33
    iget v0, v0, Landroid/graphics/Rect;->top:I

    iput v0, p0, Lio/dcloud/p/e5;->f:I

    if-lez v0, :cond_5

    .line 35
    invoke-virtual {p0}, Lio/dcloud/p/e5;->getActivity()Landroid/app/Activity;

    move-result-object v0

    sget-object v2, Lio/dcloud/common/util/BaseInfo;->PDR:Ljava/lang/String;

    iget v3, p0, Lio/dcloud/p/e5;->f:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    const-string v4, "StatusBarHeight"

    invoke-static {v0, v2, v4, v3}, Lio/dcloud/common/adapter/util/SP;->setBundleData(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    :cond_5
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 40
    iget v2, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 41
    iget v3, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    const/4 v4, 0x0

    const/4 v5, 0x1

    if-ge v2, v3, :cond_6

    const/4 v6, 0x1

    goto :goto_1

    :cond_6
    const/4 v6, 0x0

    .line 45
    :goto_1
    iget-object v7, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-static {v7}, Lio/dcloud/common/util/PdrUtil;->isAllScreenDevice(Landroid/app/Activity;)Z

    move-result v7

    if-eqz v7, :cond_c

    .line 48
    iget-object v8, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v8}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v8

    invoke-interface {v8}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v8

    invoke-virtual {v8, v0}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    .line 49
    iget v8, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    if-le v8, v0, :cond_7

    if-eqz v6, :cond_7

    goto :goto_4

    .line 54
    :cond_7
    iget-object v2, p0, Lio/dcloud/p/e5;->m:Lio/dcloud/common/util/AppStatusBarManager;

    if-eqz v2, :cond_8

    invoke-virtual {v2}, Lio/dcloud/common/util/AppStatusBarManager;->isFullScreenOrImmersive()Z

    move-result v2

    if-nez v2, :cond_8

    .line 55
    iget v2, p0, Lio/dcloud/p/e5;->f:I

    sub-int/2addr v0, v2

    :cond_8
    move v3, v0

    .line 57
    iget-object v0, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-static {v0}, Lio/dcloud/common/util/PdrUtil;->isNavigationBarExist(Landroid/app/Activity;)Z

    move-result v0

    if-eqz v0, :cond_9

    iget-boolean v0, p0, Lio/dcloud/p/e5;->p:Z

    if-nez v0, :cond_9

    const/4 v0, 0x1

    goto :goto_2

    :cond_9
    const/4 v0, 0x0

    .line 59
    :goto_2
    iget-object v2, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-static {v2}, Lio/dcloud/common/util/PdrUtil;->getNavigationBarHeight(Landroid/content/Context;)I

    move-result v2

    .line 60
    iget-object v6, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v6

    iget v6, v6, Landroid/content/res/Configuration;->orientation:I

    if-ne v6, v5, :cond_a

    if-eqz v0, :cond_b

    sub-int/2addr v3, v2

    goto :goto_3

    :cond_a
    if-eqz v0, :cond_b

    sub-int v2, v8, v2

    goto :goto_4

    :cond_b
    :goto_3
    move v2, v8

    .line 73
    :cond_c
    :goto_4
    iput v3, p0, Lio/dcloud/p/e5;->e:I

    const/4 v0, 0x2

    if-ne p1, v0, :cond_e

    .line 75
    iget-boolean p1, p0, Lio/dcloud/p/e5;->q:Z

    if-eqz p1, :cond_d

    .line 77
    iget-object p1, p0, Lio/dcloud/p/e5;->a:Landroid/app/Activity;

    invoke-virtual {p1, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    .line 78
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    iput v0, p0, Lio/dcloud/p/e5;->d:I

    .line 79
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result p1

    iput p1, p0, Lio/dcloud/p/e5;->h:I

    goto :goto_6

    .line 81
    :cond_d
    iput v2, p0, Lio/dcloud/p/e5;->d:I

    .line 82
    iput v3, p0, Lio/dcloud/p/e5;->h:I

    goto :goto_6

    :cond_e
    if-ne p1, v5, :cond_11

    .line 85
    iput v2, p0, Lio/dcloud/p/e5;->d:I

    if-eqz v7, :cond_f

    .line 88
    iput v3, p0, Lio/dcloud/p/e5;->h:I

    goto :goto_6

    .line 90
    :cond_f
    iget-object p1, p0, Lio/dcloud/p/e5;->m:Lio/dcloud/common/util/AppStatusBarManager;

    invoke-virtual {p1}, Lio/dcloud/common/util/AppStatusBarManager;->isFullScreenOrImmersive()Z

    move-result p1

    if-eqz p1, :cond_10

    goto :goto_5

    :cond_10
    iget v4, p0, Lio/dcloud/p/e5;->f:I

    :goto_5
    sub-int/2addr v3, v4

    iput v3, p0, Lio/dcloud/p/e5;->h:I

    goto :goto_6

    .line 92
    :cond_11
    iget-object p1, p0, Lio/dcloud/p/e5;->b:Lio/dcloud/common/DHInterface/IWebAppRootView;

    if-eqz p1, :cond_12

    .line 93
    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebAppRootView;->obtainMainView()Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result p1

    iput p1, p0, Lio/dcloud/p/e5;->d:I

    .line 94
    iget-object p1, p0, Lio/dcloud/p/e5;->b:Lio/dcloud/common/DHInterface/IWebAppRootView;

    invoke-interface {p1}, Lio/dcloud/common/DHInterface/IWebAppRootView;->obtainMainView()Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result p1

    iput p1, p0, Lio/dcloud/p/e5;->h:I

    goto :goto_6

    .line 96
    :cond_12
    iput v2, p0, Lio/dcloud/p/e5;->d:I

    .line 97
    iput v3, p0, Lio/dcloud/p/e5;->h:I

    .line 100
    :goto_6
    iget p1, p0, Lio/dcloud/p/e5;->e:I

    iget v0, p0, Lio/dcloud/p/e5;->h:I

    if-ge p1, v0, :cond_13

    .line 101
    iput v0, p0, Lio/dcloud/p/e5;->e:I

    .line 104
    :cond_13
    iget-object p1, p0, Lio/dcloud/p/e5;->l:Lio/dcloud/common/adapter/util/ViewRect;

    iget v1, p0, Lio/dcloud/p/e5;->d:I

    invoke-virtual {p1, v1, v0}, Lio/dcloud/common/adapter/util/ViewRect;->onScreenChanged(II)V

    return-void
.end method
