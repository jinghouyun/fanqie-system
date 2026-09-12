.class Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;
.super Landroid/view/animation/Animation;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->setupAnimators()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

.field final synthetic val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;


# direct methods
.method constructor <init>(Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

    iput-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-direct {p0}, Landroid/view/animation/Animation;-><init>()V

    return-void
.end method


# virtual methods
.method public applyTransformation(FLandroid/view/animation/Transformation;)V
    .locals 8

    .line 1
    iget-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

    iget-boolean v0, p2, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->mFinishing:Z

    if-eqz v0, :cond_0

    .line 2
    iget-object v0, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-static {p2, p1, v0}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$000(Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;FLcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;)V

    return-void

    .line 6
    :cond_0
    iget-object v0, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-static {p2, v0}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$100(Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;)F

    move-result p2

    .line 7
    iget-object v0, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {v0}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->getStartingEndTrim()F

    move-result v0

    .line 8
    iget-object v1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {v1}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->getStartingStartTrim()F

    move-result v1

    .line 9
    iget-object v2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {v2}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->getStartingRotation()F

    move-result v2

    .line 11
    iget-object v3, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

    iget-object v4, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-static {v3, p1, v4}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$200(Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;FLcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;)V

    const v3, 0x3f4ccccd    # 0.8f

    const/high16 v4, 0x3f000000    # 0.5f

    cmpg-float v5, p1, v4

    if-gtz v5, :cond_1

    div-float v5, p1, v4

    sub-float v6, v3, p2

    .line 22
    invoke-static {}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$300()Landroid/view/animation/Interpolator;

    move-result-object v7

    .line 23
    invoke-interface {v7, v5}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v5

    mul-float v6, v6, v5

    add-float/2addr v1, v6

    .line 24
    iget-object v5, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {v5, v1}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->setStartTrim(F)V

    :cond_1
    cmpl-float v1, p1, v4

    if-lez v1, :cond_2

    sub-float/2addr v3, p2

    sub-float p2, p1, v4

    div-float/2addr p2, v4

    .line 37
    invoke-static {}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$300()Landroid/view/animation/Interpolator;

    move-result-object v1

    invoke-interface {v1, p2}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result p2

    mul-float v3, v3, p2

    add-float/2addr v0, v3

    .line 38
    iget-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {p2, v0}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->setEndTrim(F)V

    :cond_2
    const/high16 p2, 0x3e800000    # 0.25f

    mul-float p2, p2, p1

    add-float/2addr v2, p2

    .line 42
    iget-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->val$ring:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;

    invoke-virtual {p2, v2}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$Ring;->setRotation(F)V

    const/high16 p2, 0x43580000    # 216.0f

    mul-float p1, p1, p2

    .line 44
    iget-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

    .line 45
    invoke-static {p2}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->access$400(Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;)F

    move-result p2

    const/high16 v0, 0x40a00000    # 5.0f

    div-float/2addr p2, v0

    const/high16 v0, 0x44870000    # 1080.0f

    mul-float p2, p2, v0

    add-float/2addr p1, p2

    .line 46
    iget-object p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable$1;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;

    invoke-virtual {p2, p1}, Lcom/taobao/weex/ui/view/refresh/circlebar/MaterialProgressDrawable;->setRotation(F)V

    return-void
.end method
