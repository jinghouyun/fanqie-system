.class public final synthetic Luts/sdk/modules/DCloudUniExit/IndexKt$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# instance fields
.field public final synthetic f$0:Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;


# direct methods
.method public synthetic constructor <init>(Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;)V
    .locals 0

    .line 0
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Luts/sdk/modules/DCloudUniExit/IndexKt$$ExternalSyntheticLambda2;->f$0:Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .line 0
    iget-object v0, p0, Luts/sdk/modules/DCloudUniExit/IndexKt$$ExternalSyntheticLambda2;->f$0:Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;

    check-cast p1, Luts/sdk/modules/DCloudUniExit/IExitError;

    invoke-static {v0, p1}, Luts/sdk/modules/DCloudUniExit/IndexKt;->$r8$lambda$ZwOfbIyQfjUSE9NXuiPtUm6X89s(Luts/sdk/modules/DCloudUniExit/ExitOptionsJSONObject;Luts/sdk/modules/DCloudUniExit/IExitError;)Lkotlin/Unit;

    move-result-object p1

    return-object p1
.end method
