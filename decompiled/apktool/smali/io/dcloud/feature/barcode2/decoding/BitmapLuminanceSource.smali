.class public Lio/dcloud/feature/barcode2/decoding/BitmapLuminanceSource;
.super Lcom/dcloud/zxing2/LuminanceSource;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private bitmapPixels:[B


# direct methods
.method protected constructor <init>(Landroid/graphics/Bitmap;)V
    .locals 9

    .line 1
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/dcloud/zxing2/LuminanceSource;-><init>(II)V

    .line 4
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    mul-int v0, v0, v1

    new-array v2, v0, [I

    .line 5
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    mul-int v1, v1, v3

    new-array v1, v1, [B

    iput-object v1, p0, Lio/dcloud/feature/barcode2/decoding/BitmapLuminanceSource;->bitmapPixels:[B

    .line 6
    invoke-virtual {p0}, Lcom/dcloud/zxing2/LuminanceSource;->getWidth()I

    move-result v4

    invoke-virtual {p0}, Lcom/dcloud/zxing2/LuminanceSource;->getWidth()I

    move-result v7

    invoke-virtual {p0}, Lcom/dcloud/zxing2/LuminanceSource;->getHeight()I

    move-result v8

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v3, 0x0

    move-object v1, p1

    invoke-virtual/range {v1 .. v8}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    const/4 p1, 0x0

    :goto_0
    if-ge p1, v0, :cond_0

    .line 10
    iget-object v1, p0, Lio/dcloud/feature/barcode2/decoding/BitmapLuminanceSource;->bitmapPixels:[B

    aget v3, v2, p1

    int-to-byte v3, v3

    aput-byte v3, v1, p1

    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method public getMatrix()[B
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/decoding/BitmapLuminanceSource;->bitmapPixels:[B

    return-object v0
.end method

.method public getRow(I[B)[B
    .locals 3

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/decoding/BitmapLuminanceSource;->bitmapPixels:[B

    invoke-virtual {p0}, Lcom/dcloud/zxing2/LuminanceSource;->getWidth()I

    move-result v1

    mul-int p1, p1, v1

    invoke-virtual {p0}, Lcom/dcloud/zxing2/LuminanceSource;->getWidth()I

    move-result v1

    const/4 v2, 0x0

    invoke-static {v0, p1, p2, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object p2
.end method
