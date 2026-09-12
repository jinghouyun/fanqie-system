.class abstract Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedObject;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# instance fields
.field private final newPosition:I


# direct methods
.method constructor <init>(I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput p1, p0, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedObject;->newPosition:I

    return-void
.end method


# virtual methods
.method final getNewPosition()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/dcloud/zxing2/oned/rss/expanded/decoders/DecodedObject;->newPosition:I

    return v0
.end method
