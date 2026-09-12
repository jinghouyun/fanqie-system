.class Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;
.super Landroid/text/style/ClickableSpan;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->getFeedAOLView()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;

.field final synthetic b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;


# direct methods
.method constructor <init>(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    iput-object p2, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;->a:Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;

    invoke-direct {p0}, Landroid/text/style/ClickableSpan;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .line 1
    new-instance p1, Landroid/content/Intent;

    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/app/Activity;

    move-result-object v0

    const-class v1, Lio/dcloud/sdk/activity/WebViewActivity;

    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;->a:Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;

    invoke-interface {v0}, Lio/dcloud/sdk/core/interfaces/AOLLoader$AppInfo;->getPrivacyUrl()Ljava/lang/String;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {p1, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3
    iget-object v0, p0, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL$1;->b:Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;

    invoke-static {v0}, Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;->a(Lio/dcloud/sdk/core/v3/fd/DCCustomFeedAOL;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    return-void
.end method
