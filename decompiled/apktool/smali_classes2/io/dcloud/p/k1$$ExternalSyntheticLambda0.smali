.class public final synthetic Lio/dcloud/p/k1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic f$0:Lio/dcloud/p/k1;

.field public final synthetic f$1:I

.field public final synthetic f$2:Ljava/lang/String;

.field public final synthetic f$3:Lorg/json/JSONArray;


# direct methods
.method public synthetic constructor <init>(Lio/dcloud/p/k1;ILjava/lang/String;Lorg/json/JSONArray;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$0:Lio/dcloud/p/k1;

    iput p2, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$1:I

    iput-object p3, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$2:Ljava/lang/String;

    iput-object p4, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$3:Lorg/json/JSONArray;

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .line 0
    iget-object v0, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$0:Lio/dcloud/p/k1;

    iget v1, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$1:I

    iget-object v2, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$2:Ljava/lang/String;

    iget-object v3, p0, Lio/dcloud/p/k1$$ExternalSyntheticLambda0;->f$3:Lorg/json/JSONArray;

    invoke-static {v0, v1, v2, v3}, Lio/dcloud/p/k1;->$r8$lambda$zSJrweJTx63P9q43um-XFTzr4a4(Lio/dcloud/p/k1;ILjava/lang/String;Lorg/json/JSONArray;)V

    return-void
.end method
