.class Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets$1;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lcom/nostra13/dcloudimageloader/core/assist/ImageLoadingListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;->loadResource(Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;

.field final synthetic val$loader:Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;


# direct methods
.method constructor <init>(Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .line 1
    iput-object p1, p0, Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets$1;->this$0:Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets;

    iput-object p2, p0, Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets$1;->val$loader:Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadingCancelled(Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    return-void
.end method

.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 0

    .line 1
    iget-object p1, p0, Lio/dcloud/feature/nativeObj/richtext/RichTextLayout$DefaultAssets$1;->val$loader:Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;

    invoke-virtual {p1, p3}, Lio/dcloud/feature/nativeObj/richtext/dom/ImgDomElement$AsycLoader;->onComplete(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/dcloudimageloader/core/assist/FailReason;)V
    .locals 0

    return-void
.end method

.method public onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    return-void
.end method
