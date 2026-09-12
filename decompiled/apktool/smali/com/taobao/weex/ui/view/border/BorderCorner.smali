.class abstract Lcom/taobao/weex/ui/view/border/BorderCorner;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# static fields
.field static final SWEEP_ANGLE:F = 45.0f


# instance fields
.field private hasInnerCorner:Z

.field private hasOuterCorner:Z

.field protected mAngleBisector:F

.field private mBorderBox:Landroid/graphics/RectF;

.field private mCornerRadius:F

.field private mOvalBottom:F

.field private mOvalLeft:F

.field private mOvalRight:F

.field private mOvalTop:F

.field private mPostBorderWidth:F

.field private mPreBorderWidth:F

.field private mRoundCornerEndX:F

.field private mRoundCornerEndY:F

.field private mRoundCornerStartX:F

.field private mRoundCornerStartY:F


# direct methods
.method constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    .line 2
    iput v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mCornerRadius:F

    .line 3
    iput v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPreBorderWidth:F

    .line 4
    iput v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPostBorderWidth:F

    const/4 v0, 0x0

    .line 12
    iput-boolean v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasInnerCorner:Z

    .line 17
    iput-boolean v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasOuterCorner:Z

    return-void
.end method


# virtual methods
.method public final drawRoundedCorner(Landroid/graphics/Canvas;Landroid/graphics/Paint;F)V
    .locals 10

    .line 1
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasOuterCorner()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 9
    new-instance v9, Landroid/graphics/Paint;

    invoke-direct {v9, p2}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    .line 10
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalLeft:F

    iget v1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalRight:F

    sub-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v0

    .line 11
    invoke-virtual {p2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    cmpl-float v1, v1, v0

    if-lez v1, :cond_0

    .line 12
    invoke-virtual {v9, v0}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 14
    :cond_0
    sget-object v0, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    invoke-virtual {v9, v0}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    .line 16
    iget v2, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalLeft:F

    iget v3, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalTop:F

    iget v4, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalRight:F

    iget v5, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalBottom:F

    const/high16 v7, 0x42340000    # 45.0f

    const/4 v8, 0x0

    move-object v1, p1

    move v6, p3

    invoke-virtual/range {v1 .. v9}, Landroid/graphics/Canvas;->drawArc(FFFFFFZLandroid/graphics/Paint;)V

    return-void

    .line 24
    :cond_1
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerStartX()F

    move-result v0

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerEndX()F

    move-result v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_3

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerStartY()F

    move-result v0

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerEndY()F

    move-result v1

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_2

    goto :goto_0

    :cond_2
    return-void

    .line 25
    :cond_3
    :goto_0
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerStartX()F

    move-result v1

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerStartY()F

    move-result v2

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerEndX()F

    move-result v3

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getRoundCornerEndY()F

    move-result v4

    move-object v0, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    return-void
.end method

.method protected final getAngleBisectorDegree()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mAngleBisector:F

    return v0
.end method

.method protected final getBorderBox()Landroid/graphics/RectF;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mBorderBox:Landroid/graphics/RectF;

    return-object v0
.end method

.method protected final getOuterCornerRadius()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mCornerRadius:F

    return v0
.end method

.method protected final getPostBorderWidth()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPostBorderWidth:F

    return v0
.end method

.method protected final getPreBorderWidth()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPreBorderWidth:F

    return v0
.end method

.method public final getRoundCornerEndX()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerEndX:F

    return v0
.end method

.method public final getRoundCornerEndY()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerEndY:F

    return v0
.end method

.method public final getRoundCornerStartX()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerStartX:F

    return v0
.end method

.method public final getRoundCornerStartY()F
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerStartY:F

    return v0
.end method

.method hasInnerCorner()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasInnerCorner:Z

    return v0
.end method

.method hasOuterCorner()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasOuterCorner:Z

    return v0
.end method

.method protected abstract prepareOval()V
.end method

.method protected abstract prepareRoundCorner()V
.end method

.method final set(FFFLandroid/graphics/RectF;F)V
    .locals 1

    .line 1
    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mCornerRadius:F

    invoke-static {v0, p1}, Lcom/taobao/weex/base/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPreBorderWidth:F

    .line 2
    invoke-static {v0, p2}, Lcom/taobao/weex/base/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPostBorderWidth:F

    .line 3
    invoke-static {v0, p3}, Lcom/taobao/weex/base/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mAngleBisector:F

    .line 4
    invoke-static {v0, p5}, Lcom/taobao/weex/base/FloatUtil;->floatsEqual(FF)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mBorderBox:Landroid/graphics/RectF;

    if-eqz v0, :cond_0

    .line 5
    invoke-virtual {v0, p4}, Landroid/graphics/RectF;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    return-void

    .line 8
    :cond_1
    :goto_0
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mCornerRadius:F

    .line 9
    iput p2, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPreBorderWidth:F

    .line 10
    iput p3, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mPostBorderWidth:F

    .line 11
    iput-object p4, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mBorderBox:Landroid/graphics/RectF;

    .line 12
    iput p5, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mAngleBisector:F

    const/4 p2, 0x1

    const/4 p3, 0x0

    const/4 p4, 0x0

    cmpl-float p5, p1, p4

    if-lez p5, :cond_2

    .line 14
    invoke-static {p4, p1}, Lcom/taobao/weex/base/FloatUtil;->floatsEqual(FF)Z

    move-result p1

    if-nez p1, :cond_2

    const/4 p1, 0x1

    goto :goto_1

    :cond_2
    const/4 p1, 0x0

    :goto_1
    iput-boolean p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasOuterCorner:Z

    if-eqz p1, :cond_3

    .line 17
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getPreBorderWidth()F

    move-result p1

    cmpl-float p1, p1, p4

    if-ltz p1, :cond_3

    .line 18
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getPostBorderWidth()F

    move-result p1

    cmpl-float p1, p1, p4

    if-ltz p1, :cond_3

    .line 19
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getOuterCornerRadius()F

    move-result p1

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getPreBorderWidth()F

    move-result p4

    cmpl-float p1, p1, p4

    if-lez p1, :cond_3

    .line 20
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getOuterCornerRadius()F

    move-result p1

    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->getPostBorderWidth()F

    move-result p4

    cmpl-float p1, p1, p4

    if-lez p1, :cond_3

    goto :goto_2

    :cond_3
    const/4 p2, 0x0

    .line 21
    :goto_2
    iput-boolean p2, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasInnerCorner:Z

    .line 23
    iget-boolean p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->hasOuterCorner:Z

    if-eqz p1, :cond_4

    .line 24
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->prepareOval()V

    .line 26
    :cond_4
    invoke-virtual {p0}, Lcom/taobao/weex/ui/view/border/BorderCorner;->prepareRoundCorner()V

    return-void
.end method

.method final setOvalBottom(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalBottom:F

    return-void
.end method

.method final setOvalLeft(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalLeft:F

    return-void
.end method

.method final setOvalRight(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalRight:F

    return-void
.end method

.method final setOvalTop(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mOvalTop:F

    return-void
.end method

.method final setRoundCornerEndX(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerEndX:F

    return-void
.end method

.method final setRoundCornerEndY(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerEndY:F

    return-void
.end method

.method final setRoundCornerStartX(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerStartX:F

    return-void
.end method

.method final setRoundCornerStartY(F)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/taobao/weex/ui/view/border/BorderCorner;->mRoundCornerStartY:F

    return-void
.end method
