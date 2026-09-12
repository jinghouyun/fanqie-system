.class Lio/dcloud/p/i4$a;
.super Lio/dcloud/p/b0$a;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/p/i4;->d()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic b:Lio/dcloud/p/i4;


# direct methods
.method constructor <init>(Lio/dcloud/p/i4;Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/dcloud/p/i4$a;->b:Lio/dcloud/p/i4;

    invoke-direct {p0, p2}, Lio/dcloud/p/b0$a;-><init>(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public a(ILjava/lang/String;)V
    .locals 1

    .line 2
    iget-object v0, p0, Lio/dcloud/p/i4$a;->b:Lio/dcloud/p/i4;

    invoke-virtual {v0, p1, p2}, Lio/dcloud/p/i4;->b(ILjava/lang/String;)V

    return-void
.end method

.method public a(Lorg/json/JSONObject;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lio/dcloud/p/i4$a;->b:Lio/dcloud/p/i4;

    invoke-virtual {v0, p1}, Lio/dcloud/p/i4;->a(Lorg/json/JSONObject;)V

    return-void
.end method
