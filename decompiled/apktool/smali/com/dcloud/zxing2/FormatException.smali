.class public final Lcom/dcloud/zxing2/FormatException;
.super Lcom/dcloud/zxing2/ReaderException;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# static fields
.field private static final INSTANCE:Lcom/dcloud/zxing2/FormatException;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lcom/dcloud/zxing2/FormatException;

    invoke-direct {v0}, Lcom/dcloud/zxing2/FormatException;-><init>()V

    sput-object v0, Lcom/dcloud/zxing2/FormatException;->INSTANCE:Lcom/dcloud/zxing2/FormatException;

    .line 3
    sget-object v1, Lcom/dcloud/zxing2/ReaderException;->NO_TRACE:[Ljava/lang/StackTraceElement;

    invoke-virtual {v0, v1}, Ljava/lang/Throwable;->setStackTrace([Ljava/lang/StackTraceElement;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcom/dcloud/zxing2/ReaderException;-><init>()V

    return-void
.end method

.method private constructor <init>(Ljava/lang/Throwable;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lcom/dcloud/zxing2/ReaderException;-><init>(Ljava/lang/Throwable;)V

    return-void
.end method

.method public static getFormatInstance()Lcom/dcloud/zxing2/FormatException;
    .locals 1

    .line 1
    sget-boolean v0, Lcom/dcloud/zxing2/ReaderException;->isStackTrace:Z

    if-eqz v0, :cond_0

    new-instance v0, Lcom/dcloud/zxing2/FormatException;

    invoke-direct {v0}, Lcom/dcloud/zxing2/FormatException;-><init>()V

    return-object v0

    :cond_0
    sget-object v0, Lcom/dcloud/zxing2/FormatException;->INSTANCE:Lcom/dcloud/zxing2/FormatException;

    return-object v0
.end method

.method public static getFormatInstance(Ljava/lang/Throwable;)Lcom/dcloud/zxing2/FormatException;
    .locals 1

    .line 2
    sget-boolean v0, Lcom/dcloud/zxing2/ReaderException;->isStackTrace:Z

    if-eqz v0, :cond_0

    new-instance v0, Lcom/dcloud/zxing2/FormatException;

    invoke-direct {v0, p0}, Lcom/dcloud/zxing2/FormatException;-><init>(Ljava/lang/Throwable;)V

    return-object v0

    :cond_0
    sget-object p0, Lcom/dcloud/zxing2/FormatException;->INSTANCE:Lcom/dcloud/zxing2/FormatException;

    return-object p0
.end method
