.class Lio/dcloud/p/d5$c$a;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"

# interfaces
.implements Lio/dcloud/common/adapter/util/MessageHandler$IMessages;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/d5$c;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lio/dcloud/p/d5$c;


# direct methods
.method constructor <init>(Lio/dcloud/p/d5$c;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/d5$c$a;->a:Lio/dcloud/p/d5$c;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Object;)V
    .locals 2

    .line 1
    iget-object p1, p0, Lio/dcloud/p/d5$c$a;->a:Lio/dcloud/p/d5$c;

    iget-object p1, p1, Lio/dcloud/p/d5$c;->a:Lio/dcloud/common/DHInterface/ICallBack;

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-interface {p1, v0, v1}, Lio/dcloud/common/DHInterface/ICallBack;->onCallBack(ILjava/lang/Object;)Ljava/lang/Object;

    return-void
.end method
