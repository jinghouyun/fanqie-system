.class final Lcom/dcloud/zxing2/datamatrix/encoder/DataMatrixSymbolInfo144;
.super Lcom/dcloud/zxing2/datamatrix/encoder/SymbolInfo;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# direct methods
.method constructor <init>()V
    .locals 9

    const/4 v7, -0x1

    const/16 v8, 0x3e

    const/4 v1, 0x0

    const/16 v2, 0x616

    const/16 v3, 0x26c

    const/16 v4, 0x16

    const/16 v5, 0x16

    const/16 v6, 0x24

    move-object v0, p0

    .line 1
    invoke-direct/range {v0 .. v8}, Lcom/dcloud/zxing2/datamatrix/encoder/SymbolInfo;-><init>(ZIIIIIII)V

    return-void
.end method


# virtual methods
.method public getDataLengthForInterleavedBlock(I)I
    .locals 1

    const/16 v0, 0x8

    if-gt p1, v0, :cond_0

    const/16 p1, 0x9c

    return p1

    :cond_0
    const/16 p1, 0x9b

    return p1
.end method

.method public getInterleavedBlockCount()I
    .locals 1

    const/16 v0, 0xa

    return v0
.end method
