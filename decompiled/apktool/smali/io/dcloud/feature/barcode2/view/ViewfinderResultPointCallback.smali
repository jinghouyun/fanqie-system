.class public final Lio/dcloud/feature/barcode2/view/ViewfinderResultPointCallback;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lcom/dcloud/zxing2/ResultPointCallback;


# instance fields
.field private final viewfinderView:Lio/dcloud/feature/barcode2/view/ViewfinderView;


# direct methods
.method public constructor <init>(Lio/dcloud/feature/barcode2/view/ViewfinderView;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/feature/barcode2/view/ViewfinderResultPointCallback;->viewfinderView:Lio/dcloud/feature/barcode2/view/ViewfinderView;

    return-void
.end method


# virtual methods
.method public foundPossibleResultPoint(Lcom/dcloud/zxing2/ResultPoint;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/feature/barcode2/view/ViewfinderResultPointCallback;->viewfinderView:Lio/dcloud/feature/barcode2/view/ViewfinderView;

    invoke-virtual {v0, p1}, Lio/dcloud/feature/barcode2/view/ViewfinderView;->addPossibleResultPoint(Lcom/dcloud/zxing2/ResultPoint;)V

    return-void
.end method
