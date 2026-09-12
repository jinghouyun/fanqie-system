.class Lio/dcloud/common/util/net/NetWorkLoop$LoopComparator;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/util/net/NetWorkLoop;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LoopComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator<",
        "Lio/dcloud/common/util/net/NetWork;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lio/dcloud/common/util/net/NetWorkLoop;


# direct methods
.method constructor <init>(Lio/dcloud/common/util/net/NetWorkLoop;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/common/util/net/NetWorkLoop$LoopComparator;->this$0:Lio/dcloud/common/util/net/NetWorkLoop;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lio/dcloud/common/util/net/NetWork;Lio/dcloud/common/util/net/NetWork;)I
    .locals 0

    .line 2
    iget p1, p1, Lio/dcloud/common/util/net/NetWork;->mPriority:I

    iget p2, p2, Lio/dcloud/common/util/net/NetWork;->mPriority:I

    sub-int/2addr p1, p2

    return p1
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 0

    .line 1
    check-cast p1, Lio/dcloud/common/util/net/NetWork;

    check-cast p2, Lio/dcloud/common/util/net/NetWork;

    invoke-virtual {p0, p1, p2}, Lio/dcloud/common/util/net/NetWorkLoop$LoopComparator;->compare(Lio/dcloud/common/util/net/NetWork;Lio/dcloud/common/util/net/NetWork;)I

    move-result p1

    return p1
.end method
