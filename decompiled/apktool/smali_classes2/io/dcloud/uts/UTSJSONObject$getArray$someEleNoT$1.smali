.class public final Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;
.super Ljava/lang/Object;
.source "UTSJSONObject.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function1;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/dcloud/uts/UTSJSONObject;->getArray_withType(Ljava/lang/String;)Lio/dcloud/uts/UTSArray;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lkotlin/jvm/functions/Function1<",
        "*",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUTSJSONObject.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTSJSONObject.kt\nio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1\n*L\n1#1,924:1\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    k = 0x3
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0xb0
.end annotation


# static fields
.field public static final INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;

    invoke-direct {v0}, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;-><init>()V

    sput-object v0, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;->INSTANCE:Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final invoke(Ljava/lang/Object;)Ljava/lang/Boolean;
    .locals 2

    const/4 v0, 0x3

    .line 654
    const-string v1, "T"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->reifiedOperationMarker(ILjava/lang/String;)V

    instance-of p1, p1, Ljava/lang/Object;

    xor-int/lit8 p1, p1, 0x1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 653
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSJSONObject$getArray$someEleNoT$1;->invoke(Ljava/lang/Object;)Ljava/lang/Boolean;

    move-result-object p1

    return-object p1
.end method
