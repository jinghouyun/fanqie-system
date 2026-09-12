.class final Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedChar;
.super Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedObject;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field static final FNC1:C = '$'


# instance fields
.field private final value:C


# direct methods
.method constructor <init>(IC)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedObject;-><init>(I)V

    .line 2
    iput-char p2, p0, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedChar;->value:C

    return-void
.end method


# virtual methods
.method getValue()C
    .locals 1

    .line 1
    iget-char v0, p0, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedChar;->value:C

    return v0
.end method

.method isFNC1()Z
    .locals 2

    .line 1
    iget-char v0, p0, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedChar;->value:C

    const/16 v1, 0x24

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    return v0

    :cond_0
    const/4 v0, 0x0

    return v0
.end method
