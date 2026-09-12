.class Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;
.super Landroid/graphics/drawable/shapes/OvalShape;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OvalShadow"
.end annotation


# instance fields
.field private mCircleDiameter:I

.field private mRadialGradient:Landroid/graphics/RadialGradient;

.field private mShadowPaint:Landroid/graphics/Paint;

.field private mShadowRadius:I

.field final synthetic this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;


# direct methods
.method public constructor <init>(Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;II)V
    .locals 7

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;

    .line 2
    invoke-direct {p0}, Landroid/graphics/drawable/shapes/OvalShape;-><init>()V

    .line 3
    new-instance p1, Landroid/graphics/Paint;

    invoke-direct {p1}, Landroid/graphics/Paint;-><init>()V

    iput-object p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowPaint:Landroid/graphics/Paint;

    .line 4
    iput p2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowRadius:I

    .line 5
    iput p3, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mCircleDiameter:I

    .line 6
    new-instance v0, Landroid/graphics/RadialGradient;

    iget p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mCircleDiameter:I

    div-int/lit8 p1, p1, 0x2

    int-to-float v1, p1

    iget p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowRadius:I

    int-to-float v3, p1

    const/high16 p1, 0x3d000000    # 0.03125f

    const/4 p2, 0x0

    filled-new-array {p1, p2}, [I

    move-result-object v4

    sget-object v6, Landroid/graphics/Shader$TileMode;->CLAMP:Landroid/graphics/Shader$TileMode;

    const/4 v5, 0x0

    move v2, v1

    invoke-direct/range {v0 .. v6}, Landroid/graphics/RadialGradient;-><init>(FFF[I[FLandroid/graphics/Shader$TileMode;)V

    iput-object v0, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mRadialGradient:Landroid/graphics/RadialGradient;

    .line 10
    iget-object p1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Landroid/graphics/Paint;)V
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;

    invoke-virtual {v0}, Landroid/view/View;->getWidth()I

    move-result v0

    .line 2
    iget-object v1, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->this$0:Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar;

    invoke-virtual {v1}, Landroid/view/View;->getHeight()I

    move-result v1

    .line 3
    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    iget v2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mCircleDiameter:I

    div-int/lit8 v2, v2, 0x2

    iget v3, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowRadius:I

    add-int/2addr v2, v3

    int-to-float v2, v2

    iget-object v3, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mShadowPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 5
    iget v2, p0, Lcom/taobao/weex/ui/view/refresh/circlebar/CircleProgressBar$OvalShadow;->mCircleDiameter:I

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    invoke-virtual {p1, v0, v1, v2, p2}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    return-void
.end method
