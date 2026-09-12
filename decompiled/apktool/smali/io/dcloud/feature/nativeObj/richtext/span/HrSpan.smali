.class public Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;
.super Landroid/text/style/ReplacementSpan;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field public static final ALIGN_CENTER:I = 0x0

.field public static final ALIGN_LEFT:I = 0x1

.field public static final ALIGN_RIGHT:I = 0x2


# instance fields
.field align:I

.field color:I

.field hrWidth:I

.field size:I

.field width:I


# direct methods
.method public constructor <init>(IIIII)V
    .locals 0

    .line 1
    invoke-direct {p0}, Landroid/text/style/ReplacementSpan;-><init>()V

    .line 2
    iput p1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->align:I

    .line 3
    iput p2, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    .line 4
    iput p3, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->width:I

    .line 5
    iput p4, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->color:I

    .line 6
    iput p5, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->hrWidth:I

    return-void
.end method


# virtual methods
.method public draw(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V
    .locals 6

    move-object v5, p9

    .line 1
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    int-to-float v1, v1

    invoke-virtual {p9, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 2
    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {p9, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 3
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->color:I

    invoke-virtual {p9, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 4
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->align:I

    const/4 v2, 0x2

    if-nez v1, :cond_0

    .line 5
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->hrWidth:I

    iget v3, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->width:I

    sub-int/2addr v1, v3

    div-int/2addr v1, v2

    int-to-float v1, v1

    add-float v2, p5, v1

    int-to-float v4, p7

    int-to-float v3, v3

    add-float/2addr v3, p5

    add-float/2addr v3, v1

    .line 6
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    add-int v0, p7, v1

    int-to-float v0, v0

    move-object p2, p1

    move p6, v0

    move p3, v2

    move p5, v3

    move p4, v4

    move-object p7, v5

    invoke-virtual/range {p2 .. p7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    return-void

    :cond_0
    if-ne v1, v2, :cond_1

    .line 8
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->hrWidth:I

    int-to-float v1, v1

    add-float/2addr v1, p5

    iget v2, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->width:I

    int-to-float v2, v2

    sub-float v2, v1, v2

    int-to-float v3, p7

    iget v4, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    add-int v0, p7, v4

    int-to-float v0, v0

    move-object p2, p1

    move-object p7, p9

    move p6, v0

    move p5, v1

    move p3, v2

    move p4, v3

    invoke-virtual/range {p2 .. p7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    return-void

    :cond_1
    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    int-to-float v2, p7

    .line 10
    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->width:I

    int-to-float v1, v1

    add-float v3, p5, v1

    iget v1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    add-int v0, p7, v1

    int-to-float v4, v0

    move-object v0, p1

    move v1, p5

    move-object v5, p9

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    :cond_2
    return-void
.end method

.method public getSize(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I
    .locals 0

    if-eqz p5, :cond_0

    const/4 p1, 0x0

    .line 1
    iput p1, p5, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    .line 2
    iget p2, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->size:I

    iput p2, p5, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    .line 3
    iput p2, p5, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    .line 4
    iput p1, p5, Landroid/graphics/Paint$FontMetricsInt;->top:I

    .line 6
    :cond_0
    iget p1, p0, Lio/dcloud/feature/nativeObj/richtext/span/HrSpan;->hrWidth:I

    return p1
.end method
