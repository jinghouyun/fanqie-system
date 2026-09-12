.class public Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

.field private final b:Landroid/app/Activity;

.field private c:Landroid/os/CountDownTimer;

.field private d:J

.field private e:Z

.field private final f:Landroid/os/Handler;

.field private g:Ljava/lang/Runnable;

.field private h:Z

.field private i:Landroid/widget/TextView;

.field private j:Landroid/widget/FrameLayout;


# direct methods
.method public static synthetic $r8$lambda$zxbhaOQ6RqYqbjqzoAuIlnb4rvs(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    return-void
.end method

.method public constructor <init>(Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;Landroid/app/Activity;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const-wide/16 v0, 0x1388

    .line 2
    iput-wide v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    const/4 v0, 0x0

    .line 3
    iput-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    .line 8
    iput-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h:Z

    .line 14
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    .line 15
    iput-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    .line 16
    new-instance p1, Landroid/os/Handler;

    invoke-direct {p1}, Landroid/os/Handler;-><init>()V

    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->f:Landroid/os/Handler;

    return-void
.end method

.method static synthetic a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;J)J
    .locals 0

    .line 3
    iput-wide p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    return-wide p1
.end method

.method static synthetic a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/app/Activity;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    return-object p0
.end method

.method static synthetic a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/os/CountDownTimer;)Landroid/os/CountDownTimer;
    .locals 0

    .line 5
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    return-object p1
.end method

.method private a()V
    .locals 2

    .line 26
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    if-eqz v1, :cond_0

    .line 27
    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    const/4 v0, 0x0

    .line 28
    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    const/4 v0, 0x0

    .line 29
    iput-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    :cond_0
    return-void
.end method

.method private synthetic a(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 1

    if-eqz p1, :cond_0

    .line 6
    const-string v0, "\u5173\u95ed"

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 10
    :cond_0
    iget-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->g:Ljava/lang/Runnable;

    if-eqz p1, :cond_1

    .line 11
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->f:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 14
    :cond_1
    new-instance p1, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;

    invoke-direct {p1, p0, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$7;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/FrameLayout;)V

    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->g:Ljava/lang/Runnable;

    const/4 p1, 0x1

    .line 25
    iput-boolean p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h:Z

    return-void
.end method

.method static synthetic a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 0

    .line 4
    invoke-direct {p0, p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    return-void
.end method

.method static synthetic a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z
    .locals 0

    .line 2
    iput-boolean p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    return p1
.end method

.method private b()V
    .locals 5

    .line 15
    iget-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    if-nez v0, :cond_0

    iget-wide v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->j:Landroid/widget/FrameLayout;

    if-eqz v1, :cond_0

    .line 16
    invoke-direct {p0, v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    .line 17
    invoke-direct {p0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c()V

    :cond_0
    return-void
.end method

.method private b(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 10

    .line 4
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_0

    .line 5
    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    const/4 v0, 0x0

    .line 6
    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    .line 10
    :cond_0
    iget-wide v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-gtz v4, :cond_1

    const-wide/16 v0, 0x3e8

    .line 11
    iput-wide v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    .line 14
    :cond_1
    new-instance v2, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;

    iget-wide v4, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    const-wide/16 v6, 0x3e8

    move-object v3, p0

    move-object v8, p1

    move-object v9, p2

    invoke-direct/range {v2 .. v9}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$8;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;JJLandroid/widget/TextView;Landroid/widget/FrameLayout;)V

    iput-object v2, v3, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    return-void
.end method

.method static synthetic b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 0

    .line 3
    invoke-direct {p0, p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    return-void
.end method

.method static synthetic b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    return p0
.end method

.method static synthetic b(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Z)Z
    .locals 0

    .line 2
    iput-boolean p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h:Z

    return p1
.end method

.method private c()V
    .locals 2

    .line 15
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    if-nez v1, :cond_0

    const/4 v1, 0x1

    .line 16
    iput-boolean v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    .line 17
    invoke-virtual {v0}, Landroid/os/CountDownTimer;->start()Landroid/os/CountDownTimer;

    :cond_0
    return-void
.end method

.method private c(Landroid/widget/TextView;Landroid/widget/FrameLayout;)V
    .locals 2

    .line 2
    iget-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h:Z

    if-eqz v0, :cond_0

    return-void

    .line 7
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    if-eqz v0, :cond_1

    .line 8
    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    const/4 v0, 0x0

    .line 9
    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    :cond_1
    const/4 v0, 0x0

    .line 11
    iput-boolean v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->e:Z

    const-wide/16 v0, 0x0

    .line 12
    iput-wide v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    .line 14
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    new-instance v1, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0, p1, p2}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$$ExternalSyntheticLambda0;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    invoke-virtual {v0, v1}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic c(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a()V

    return-void
.end method

.method static synthetic d(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b()V

    return-void
.end method

.method static synthetic e(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Ljava/lang/Runnable;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->g:Ljava/lang/Runnable;

    return-object p0
.end method

.method static synthetic f(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/Handler;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->f:Landroid/os/Handler;

    return-object p0
.end method

.method static synthetic g(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->h:Z

    return p0
.end method

.method static synthetic h(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    return-object p0
.end method

.method static synthetic i(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/os/CountDownTimer;
    .locals 0

    .line 1
    iget-object p0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c:Landroid/os/CountDownTimer;

    return-object p0
.end method

.method static synthetic j(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->c()V

    return-void
.end method


# virtual methods
.method public getFeedAOLView()Landroid/view/View;
    .locals 14

    .line 1
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    const/4 v1, 0x0

    if-eqz v0, :cond_2

    .line 2
    invoke-virtual {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->isExpressAd()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getFeedAOLView(Landroid/app/Activity;)Landroid/view/View;

    move-result-object v0

    return-object v0

    .line 5
    :cond_0
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v2, Lio/dcloud/base/R$layout;->dcloud_ad_custom_feed_ad:I

    invoke-virtual {v0, v2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    move-object v4, v0

    check-cast v4, Landroid/widget/FrameLayout;

    .line 6
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    invoke-virtual {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getMaterialType()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_2

    .line 7
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    invoke-virtual {v0}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getVideoDuration()D

    move-result-wide v5

    const-wide v7, 0x408f400000000000L    # 1000.0

    mul-double v5, v5, v7

    double-to-long v5, v5

    iput-wide v5, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->d:J

    .line 10
    sget v0, Lio/dcloud/base/R$id;->videoContainer:I

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 11
    iget-object v3, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    iget-object v7, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    invoke-virtual {v3, v7}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getVideoView(Landroid/app/Activity;)Landroid/view/View;

    move-result-object v3

    if-eqz v3, :cond_2

    .line 13
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    const/4 v7, -0x1

    invoke-direct {v1, v7, v7}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v3, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 15
    sget v0, Lio/dcloud/base/R$id;->privacyInfo:I

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 16
    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getInteractionType()I

    move-result v1

    const/4 v7, 0x0

    if-ne v1, v2, :cond_1

    .line 17
    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->getAppInfo()Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;

    move-result-object v1

    .line 19
    new-instance v8, Landroid/text/SpannableString;

    sget-object v9, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-interface {v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;->getAppName()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;->getDeveloperName()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v1}, Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;->getAppVersion()Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x3

    new-array v13, v13, [Ljava/lang/Object;

    aput-object v10, v13, v7

    aput-object v11, v13, v2

    const/4 v2, 0x2

    aput-object v12, v13, v2

    const-string v10, "\u5e94\u7528\u540d\u79f0\uff1a%s|\u5f00\u53d1\u8005\uff1a%s|\u5e94\u7528\u7248\u672c\uff1a%s|\u9690\u79c1\u534f\u8bae|\u6743\u9650\u8be6\u60c5|\u7b80\u4ecb"

    invoke-static {v9, v10, v13}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 20
    new-instance v9, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;

    invoke-direct {v9, p0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;)V

    .line 28
    new-instance v10, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$2;

    invoke-direct {v10, p0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$2;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;)V

    .line 37
    new-instance v11, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$3;

    invoke-direct {v11, p0, v1}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$3;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;)V

    .line 46
    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v12, "\u9690\u79c1\u534f\u8bae"

    invoke-virtual {v1, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    add-int/lit8 v12, v12, 0x4

    const/16 v13, 0x21

    invoke-virtual {v8, v9, v1, v12, v13}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 47
    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v9, "\u6743\u9650\u8be6\u60c5"

    invoke-virtual {v1, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v12, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v9

    add-int/lit8 v9, v9, 0x4

    invoke-virtual {v8, v10, v1, v9, v13}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 48
    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v9, "\u7b80\u4ecb"

    invoke-virtual {v1, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v8}, Landroid/text/SpannableString;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v10, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v9

    add-int/2addr v9, v2

    invoke-virtual {v8, v11, v1, v9, v13}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 49
    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 51
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto :goto_0

    :cond_1
    const/16 v1, 0x8

    .line 53
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 56
    :goto_0
    sget v0, Lio/dcloud/base/R$id;->skipView:I

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    long-to-float v1, v5

    const/high16 v2, 0x447a0000    # 1000.0f

    div-float/2addr v1, v2

    .line 58
    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-static {v7, v1}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 59
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "s"

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    iput-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->i:Landroid/widget/TextView;

    .line 61
    iput-object v4, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->j:Landroid/widget/FrameLayout;

    .line 63
    new-instance v1, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;

    invoke-direct {v1, p0, v4}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$4;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/FrameLayout;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    iget-object v1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    new-instance v2, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;

    invoke-direct {v2, p0, v0, v4}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$5;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/widget/TextView;Landroid/widget/FrameLayout;)V

    invoke-virtual {v1, v2}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->setVideoAdListener(Lio/dcloud/sdk/core/interfaces/AOLLoader$VideoAdListener;)V

    .line 140
    iget-object v2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a:Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;

    move-object v0, v3

    iget-object v3, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->b:Landroid/app/Activity;

    new-instance v5, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$6;

    invoke-direct {v5, p0, v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$6;-><init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Landroid/view/View;)V

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Lio/dcloud/sdk/core/v3/fd/DCFeedAOL;->registerViewForInteraction(Landroid/app/Activity;Landroid/widget/FrameLayout;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    return-object v4

    :cond_2
    return-object v1
.end method
