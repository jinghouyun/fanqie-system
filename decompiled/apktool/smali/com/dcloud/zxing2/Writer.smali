.class public interface abstract Lcom/dcloud/zxing2/Writer;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# virtual methods
.method public abstract encode(Ljava/lang/String;Lcom/dcloud/zxing2/BarcodeFormat;II)Lcom/dcloud/zxing2/common/BitMatrix;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dcloud/zxing2/WriterException;
        }
    .end annotation
.end method

.method public abstract encode(Ljava/lang/String;Lcom/dcloud/zxing2/BarcodeFormat;IILjava/util/Map;)Lcom/dcloud/zxing2/common/BitMatrix;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/dcloud/zxing2/BarcodeFormat;",
            "II",
            "Ljava/util/Map<",
            "Lcom/dcloud/zxing2/EncodeHintType;",
            "*>;)",
            "Lcom/dcloud/zxing2/common/BitMatrix;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dcloud/zxing2/WriterException;
        }
    .end annotation
.end method
