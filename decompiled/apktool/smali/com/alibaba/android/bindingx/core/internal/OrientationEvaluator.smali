.class Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;
.super Ljava/lang/Object;
.source "OrientationEvaluator.java"


# instance fields
.field private final EULER:Lcom/alibaba/android/bindingx/core/internal/Euler;

.field private final Q0:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

.field private final Q1:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

.field private final ZEE:Lcom/alibaba/android/bindingx/core/internal/Vector3;

.field private constraintAlpha:Ljava/lang/Double;

.field private constraintAlphaOffset:D

.field private constraintBeta:Ljava/lang/Double;

.field private constraintBetaOffset:D

.field private constraintGamma:Ljava/lang/Double;

.field private constraintGammaOffset:D

.field private quaternion:Lcom/alibaba/android/bindingx/core/internal/Quaternion;


# direct methods
.method constructor <init>(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V
    .locals 10

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    new-instance v0, Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    const-wide/16 v5, 0x0

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    const-wide/16 v1, 0x0

    const-wide/16 v3, 0x0

    invoke-direct/range {v0 .. v8}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;-><init>(DDDD)V

    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->quaternion:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    const/4 v0, 0x0

    .line 32
    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintAlpha:Ljava/lang/Double;

    .line 33
    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintBeta:Ljava/lang/Double;

    .line 34
    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintGamma:Ljava/lang/Double;

    const-wide/16 v0, 0x0

    .line 36
    iput-wide v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintAlphaOffset:D

    .line 37
    iput-wide v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintBetaOffset:D

    .line 38
    iput-wide v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintGammaOffset:D

    .line 57
    new-instance v2, Lcom/alibaba/android/bindingx/core/internal/Vector3;

    invoke-direct/range {v2 .. v8}, Lcom/alibaba/android/bindingx/core/internal/Vector3;-><init>(DDD)V

    iput-object v2, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->ZEE:Lcom/alibaba/android/bindingx/core/internal/Vector3;

    .line 58
    new-instance v0, Lcom/alibaba/android/bindingx/core/internal/Euler;

    invoke-direct {v0}, Lcom/alibaba/android/bindingx/core/internal/Euler;-><init>()V

    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->EULER:Lcom/alibaba/android/bindingx/core/internal/Euler;

    .line 59
    new-instance v0, Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    invoke-direct {v0}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;-><init>()V

    iput-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->Q0:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    .line 60
    new-instance v1, Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    const-wide/high16 v2, 0x3fe0000000000000L    # 0.5

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v4

    neg-double v4, v4

    const-wide/16 v6, 0x0

    invoke-static {v2, v3}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v8

    move-wide v2, v4

    const-wide/16 v4, 0x0

    invoke-direct/range {v1 .. v9}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;-><init>(DDDD)V

    iput-object v1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->Q1:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    .line 42
    iput-object p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintAlpha:Ljava/lang/Double;

    .line 43
    iput-object p2, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintBeta:Ljava/lang/Double;

    .line 44
    iput-object p3, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintGamma:Ljava/lang/Double;

    return-void
.end method

.method private setObjectQuaternion(Lcom/alibaba/android/bindingx/core/internal/Quaternion;DDDD)V
    .locals 8

    .line 63
    iget-object v0, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->EULER:Lcom/alibaba/android/bindingx/core/internal/Euler;

    neg-double v5, p6

    const-string v7, "YXZ"

    move-wide v3, p2

    move-wide v1, p4

    invoke-virtual/range {v0 .. v7}, Lcom/alibaba/android/bindingx/core/internal/Euler;->setValue(DDDLjava/lang/String;)V

    .line 64
    iget-object p2, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->EULER:Lcom/alibaba/android/bindingx/core/internal/Euler;

    invoke-virtual {p1, p2}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;->setFromEuler(Lcom/alibaba/android/bindingx/core/internal/Euler;)Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    .line 65
    iget-object p2, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->Q1:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    invoke-virtual {p1, p2}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;->multiply(Lcom/alibaba/android/bindingx/core/internal/Quaternion;)Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    .line 66
    iget-object p2, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->Q0:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    iget-object p3, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->ZEE:Lcom/alibaba/android/bindingx/core/internal/Vector3;

    move-wide/from16 p4, p8

    neg-double p4, p4

    invoke-virtual {p2, p3, p4, p5}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;->setFromAxisAngle(Lcom/alibaba/android/bindingx/core/internal/Vector3;D)Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    move-result-object p2

    invoke-virtual {p1, p2}, Lcom/alibaba/android/bindingx/core/internal/Quaternion;->multiply(Lcom/alibaba/android/bindingx/core/internal/Quaternion;)Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    return-void
.end method


# virtual methods
.method calculate(DDDD)Lcom/alibaba/android/bindingx/core/internal/Quaternion;
    .locals 10

    .line 48
    iget-object p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintAlpha:Ljava/lang/Double;

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p1

    goto :goto_0

    :cond_0
    iget-wide p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintAlphaOffset:D

    add-double p1, p7, p1

    :goto_0
    invoke-static {p1, p2}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v2

    .line 49
    iget-object p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintBeta:Ljava/lang/Double;

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p1

    goto :goto_1

    :cond_1
    iget-wide p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintBetaOffset:D

    add-double/2addr p1, p3

    :goto_1
    invoke-static {p1, p2}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v4

    .line 50
    iget-object p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintGamma:Ljava/lang/Double;

    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Double;->doubleValue()D

    move-result-wide p1

    goto :goto_2

    :cond_2
    iget-wide p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->constraintGammaOffset:D

    add-double/2addr p1, p5

    :goto_2
    invoke-static {p1, p2}, Ljava/lang/Math;->toRadians(D)D

    move-result-wide v6

    .line 52
    iget-object v1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->quaternion:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    const-wide/16 v8, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v9}, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->setObjectQuaternion(Lcom/alibaba/android/bindingx/core/internal/Quaternion;DDDD)V

    .line 53
    iget-object p1, p0, Lcom/alibaba/android/bindingx/core/internal/OrientationEvaluator;->quaternion:Lcom/alibaba/android/bindingx/core/internal/Quaternion;

    return-object p1
.end method
