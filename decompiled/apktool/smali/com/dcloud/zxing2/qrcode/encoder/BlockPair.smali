.class final Lcom/dcloud/zxing2/qrcode/encoder/BlockPair;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final dataBytes:[B

.field private final errorCorrectionBytes:[B


# direct methods
.method constructor <init>([B[B)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lcom/dcloud/zxing2/qrcode/encoder/BlockPair;->dataBytes:[B

    .line 3
    iput-object p2, p0, Lcom/dcloud/zxing2/qrcode/encoder/BlockPair;->errorCorrectionBytes:[B

    return-void
.end method


# virtual methods
.method public getDataBytes()[B
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/dcloud/zxing2/qrcode/encoder/BlockPair;->dataBytes:[B

    return-object v0
.end method

.method public getErrorCorrectionBytes()[B
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/dcloud/zxing2/qrcode/encoder/BlockPair;->errorCorrectionBytes:[B

    return-object v0
.end method
