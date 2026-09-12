.class Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/sdk/core/module/DCBaseAOLLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private final a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

.field private final b:I

.field private final c:I

.field private final d:Ljava/lang/String;

.field private final e:Ljava/util/List;


# direct methods
.method public constructor <init>(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;Ljava/util/List;IILjava/lang/String;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    .line 3
    iput p3, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->b:I

    .line 4
    iput p4, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->c:I

    .line 5
    iput-object p5, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->d:Ljava/lang/String;

    .line 6
    iput-object p2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->e:Ljava/util/List;

    if-eqz p2, :cond_0

    .line 8
    new-instance p1, Ljava/lang/StringBuilder;

    const-string p3, "sub slot ads:"

    invoke-direct {p1, p3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result p2

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {p1}, Lio/dcloud/p/c3;->d(Ljava/lang/String;)V

    :cond_0
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    new-instance v0, Lio/dcloud/p/n1;

    invoke-direct {v0}, Lio/dcloud/p/n1;-><init>()V

    .line 2
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->n()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/dcloud/p/n1;->c(Ljava/lang/String;)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getSlotId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/dcloud/p/n1;->e(Ljava/lang/String;)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    iget v2, v2, Lio/dcloud/sdk/core/module/DCBaseAOL;->e:I

    invoke-virtual {v1, v2}, Lio/dcloud/p/n1;->b(I)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/dcloud/p/n1;->d(Ljava/lang/String;)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v2}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getTid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/dcloud/p/n1;->f(Ljava/lang/String;)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v2}, Lio/dcloud/sdk/core/module/a;->t()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lio/dcloud/p/n1;->a(J)Lio/dcloud/p/n1;

    .line 3
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->s()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 4
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-static {v1}, Lio/dcloud/p/m;->a(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/dcloud/p/n1;->a(Ljava/lang/String;)Lio/dcloud/p/n1;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-static {v2}, Lio/dcloud/p/m;->b(Lio/dcloud/sdk/core/module/DCBaseAOL;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lio/dcloud/p/n1;->b(Ljava/lang/String;)Lio/dcloud/p/n1;

    .line 5
    :cond_0
    iget v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->b:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_2

    .line 6
    invoke-virtual {v0, v1}, Lio/dcloud/p/n1;->c(I)Lio/dcloud/p/n1;

    .line 7
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->isSlotSupportBidding()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 8
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-virtual {v1}, Lio/dcloud/sdk/core/module/DCBaseAOL;->getBiddingECPM()I

    move-result v1

    invoke-virtual {v0, v1}, Lio/dcloud/p/n1;->a(I)Lio/dcloud/p/n1;

    .line 9
    :cond_1
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-static {v1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;)Lio/dcloud/p/w$a;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    iget-object v3, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->e:Ljava/util/List;

    invoke-interface {v1, v2, v3, v0}, Lio/dcloud/p/w$a;->a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;Ljava/util/List;Lio/dcloud/p/n1;)V

    return-void

    :cond_2
    if-nez v1, :cond_3

    .line 11
    invoke-virtual {v0, v1}, Lio/dcloud/p/n1;->c(I)Lio/dcloud/p/n1;

    .line 12
    iget v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->c:I

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lio/dcloud/p/n1;->a(ILjava/lang/String;)Lio/dcloud/p/n1;

    .line 13
    iget-object v1, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-static {v1}, Lio/dcloud/sdk/core/module/DCBaseAOLLoader;->a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;)Lio/dcloud/p/w$a;

    move-result-object v1

    iget-object v2, p0, Lio/dcloud/sdk/core/module/DCBaseAOLLoader$a;->a:Lio/dcloud/sdk/core/module/DCBaseAOLLoader;

    invoke-interface {v1, v2, v0}, Lio/dcloud/p/w$a;->a(Lio/dcloud/sdk/core/module/DCBaseAOLLoader;Lio/dcloud/p/n1;)V

    :cond_3
    return-void
.end method
