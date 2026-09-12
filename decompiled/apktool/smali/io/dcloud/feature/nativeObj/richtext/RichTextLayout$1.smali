.class Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$1;
.super Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/feature/nativeObj/richtext/RichTextLayout;->makeRichText([Ljava/lang/Object;)Landroid/widget/TextView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>(Lio/dcloud/common/DHInterface/IWebview;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;-><init>(Lio/dcloud/common/DHInterface/IWebview;)V

    return-void
.end method


# virtual methods
.method public getDefaultColor(Z)I
    .locals 0

    if-eqz p1, :cond_0

    const p1, -0xffff01

    return p1

    :cond_0
    const/4 p1, -0x1

    return p1
.end method
