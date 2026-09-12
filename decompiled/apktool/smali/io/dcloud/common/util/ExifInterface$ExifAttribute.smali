.class Lio/dcloud/common/util/ExifInterface$ExifAttribute;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/util/ExifInterface;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ExifAttribute"
.end annotation


# static fields
.field public static final BYTES_OFFSET_UNKNOWN:J = -0x1L


# instance fields
.field public final bytes:[B

.field public final bytesOffset:J

.field public final format:I

.field public final numberOfComponents:I


# direct methods
.method constructor <init>(IIJ[B)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->format:I

    .line 4
    iput p2, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    .line 5
    iput-wide p3, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytesOffset:J

    .line 6
    iput-object p5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    return-void
.end method

.method constructor <init>(II[B)V
    .locals 6

    const-wide/16 v3, -0x1

    move-object v0, p0

    move v1, p1

    move v2, p2

    move-object v5, p3

    .line 1
    invoke-direct/range {v0 .. v5}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(IIJ[B)V

    return-void
.end method

.method public static createByte(Ljava/lang/String;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 5

    .line 1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x30

    if-lt v2, v3, :cond_0

    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v4, 0x31

    if-gt v2, v4, :cond_0

    .line 2
    invoke-virtual {p0, v0}, Ljava/lang/String;->charAt(I)C

    move-result p0

    sub-int/2addr p0, v3

    int-to-byte p0, p0

    new-array v2, v1, [B

    aput-byte p0, v2, v0

    .line 3
    new-instance p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    invoke-direct {p0, v1, v1, v2}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p0

    .line 5
    :cond_0
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->ASCII:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    .line 6
    new-instance v0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length v2, p0

    invoke-direct {v0, v1, v2, p0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object v0
.end method

.method public static createDouble(DLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 2

    const/4 v0, 0x1

    .line 8
    new-array v0, v0, [D

    const/4 v1, 0x0

    aput-wide p0, v0, v1

    invoke-static {v0, p2}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createDouble([DLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createDouble([DLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 5

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/16 v1, 0xc

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget-wide v3, p0, v2

    .line 5
    invoke-virtual {v0, v3, v4}, Ljava/nio/ByteBuffer;->putDouble(D)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 7
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method

.method public static createSLong(ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 0

    .line 8
    filled-new-array {p0}, [I

    move-result-object p0

    invoke-static {p0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createSLong([ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createSLong([ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 4

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/16 v1, 0x9

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget v3, p0, v2

    .line 5
    invoke-virtual {v0, v3}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 7
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method

.method public static createSRational(Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 2

    const/4 v0, 0x1

    .line 9
    new-array v0, v0, [Lio/dcloud/common/util/ExifInterface$Rational;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    invoke-static {v0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createSRational([Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createSRational([Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 6

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/16 v1, 0xa

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget-object v3, p0, v2

    .line 5
    iget-wide v4, v3, Lio/dcloud/common/util/ExifInterface$Rational;->numerator:J

    long-to-int v5, v4

    invoke-virtual {v0, v5}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 6
    iget-wide v3, v3, Lio/dcloud/common/util/ExifInterface$Rational;->denominator:J

    long-to-int v4, v3

    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 8
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method

.method public static createString(Ljava/lang/String;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 p0, 0x0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    sget-object v0, Lio/dcloud/common/util/ExifInterface;->ASCII:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    .line 2
    new-instance v0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length v1, p0

    const/4 v2, 0x2

    invoke-direct {v0, v2, v1, p0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object v0
.end method

.method public static createULong(JLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 2

    const/4 v0, 0x1

    .line 8
    new-array v0, v0, [J

    const/4 v1, 0x0

    aput-wide p0, v0, v1

    invoke-static {v0, p2}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createULong([JLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createULong([JLjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 5

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/4 v1, 0x4

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget-wide v3, p0, v2

    long-to-int v4, v3

    .line 5
    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 7
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method

.method public static createURational(Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 2

    const/4 v0, 0x1

    .line 9
    new-array v0, v0, [Lio/dcloud/common/util/ExifInterface$Rational;

    const/4 v1, 0x0

    aput-object p0, v0, v1

    invoke-static {v0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createURational([Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createURational([Lio/dcloud/common/util/ExifInterface$Rational;Ljava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 6

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/4 v1, 0x5

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget-object v3, p0, v2

    .line 5
    iget-wide v4, v3, Lio/dcloud/common/util/ExifInterface$Rational;->numerator:J

    long-to-int v5, v4

    invoke-virtual {v0, v5}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 6
    iget-wide v3, v3, Lio/dcloud/common/util/ExifInterface$Rational;->denominator:J

    long-to-int v4, v3

    invoke-virtual {v0, v4}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 8
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method

.method public static createUShort(ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 0

    .line 8
    filled-new-array {p0}, [I

    move-result-object p0

    invoke-static {p0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->createUShort([ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    move-result-object p0

    return-object p0
.end method

.method public static createUShort([ILjava/nio/ByteOrder;)Lio/dcloud/common/util/ExifInterface$ExifAttribute;
    .locals 4

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    const/4 v1, 0x3

    aget v0, v0, v1

    array-length v2, p0

    mul-int v0, v0, v2

    new-array v0, v0, [B

    invoke-static {v0}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    .line 3
    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    .line 4
    array-length p1, p0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, p1, :cond_0

    aget v3, p0, v2

    int-to-short v3, v3

    .line 5
    invoke-virtual {v0, v3}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 7
    :cond_0
    new-instance p1, Lio/dcloud/common/util/ExifInterface$ExifAttribute;

    array-length p0, p0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v0

    invoke-direct {p1, v1, p0, v0}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;-><init>(II[B)V

    return-object p1
.end method


# virtual methods
.method public getDoubleValue(Ljava/nio/ByteOrder;)D
    .locals 4

    .line 1
    invoke-virtual {p0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->getValue(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_9

    .line 5
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 6
    check-cast p1, Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0

    .line 8
    :cond_0
    instance-of v0, p1, [J

    const/4 v1, 0x0

    const-string v2, "There are more than one component"

    const/4 v3, 0x1

    if-eqz v0, :cond_2

    .line 9
    check-cast p1, [J

    .line 10
    array-length v0, p1

    if-ne v0, v3, :cond_1

    .line 11
    aget-wide v0, p1, v1

    long-to-double v0, v0

    return-wide v0

    .line 13
    :cond_1
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 15
    :cond_2
    instance-of v0, p1, [I

    if-eqz v0, :cond_4

    .line 16
    check-cast p1, [I

    .line 17
    array-length v0, p1

    if-ne v0, v3, :cond_3

    .line 18
    aget p1, p1, v1

    int-to-double v0, p1

    return-wide v0

    .line 20
    :cond_3
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 22
    :cond_4
    instance-of v0, p1, [D

    if-eqz v0, :cond_6

    .line 23
    check-cast p1, [D

    .line 24
    array-length v0, p1

    if-ne v0, v3, :cond_5

    .line 25
    aget-wide v0, p1, v1

    return-wide v0

    .line 27
    :cond_5
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 29
    :cond_6
    instance-of v0, p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    if-eqz v0, :cond_8

    .line 30
    check-cast p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    .line 31
    array-length v0, p1

    if-ne v0, v3, :cond_7

    .line 32
    aget-object p1, p1, v1

    invoke-virtual {p1}, Lio/dcloud/common/util/ExifInterface$Rational;->calculate()D

    move-result-wide v0

    return-wide v0

    .line 34
    :cond_7
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 36
    :cond_8
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "Couldn\'t find a double value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 37
    :cond_9
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "NULL can\'t be converted to a double value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public getIntValue(Ljava/nio/ByteOrder;)I
    .locals 4

    .line 1
    invoke-virtual {p0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->getValue(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    if-eqz p1, :cond_5

    .line 5
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 6
    check-cast p1, Ljava/lang/String;

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result p1

    return p1

    .line 8
    :cond_0
    instance-of v0, p1, [J

    const/4 v1, 0x0

    const-string v2, "There are more than one component"

    const/4 v3, 0x1

    if-eqz v0, :cond_2

    .line 9
    check-cast p1, [J

    .line 10
    array-length v0, p1

    if-ne v0, v3, :cond_1

    .line 11
    aget-wide v0, p1, v1

    long-to-int p1, v0

    return p1

    .line 13
    :cond_1
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 15
    :cond_2
    instance-of v0, p1, [I

    if-eqz v0, :cond_4

    .line 16
    check-cast p1, [I

    .line 17
    array-length v0, p1

    if-ne v0, v3, :cond_3

    .line 18
    aget p1, p1, v1

    return p1

    .line 20
    :cond_3
    new-instance p1, Ljava/lang/NumberFormatException;

    invoke-direct {p1, v2}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 22
    :cond_4
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "Couldn\'t find a integer value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1

    .line 23
    :cond_5
    new-instance p1, Ljava/lang/NumberFormatException;

    const-string v0, "NULL can\'t be converted to a integer value"

    invoke-direct {p1, v0}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public getStringValue(Ljava/nio/ByteOrder;)Ljava/lang/String;
    .locals 7

    .line 1
    invoke-virtual {p0, p1}, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->getValue(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    const/4 v0, 0x0

    if-nez p1, :cond_0

    return-object v0

    .line 5
    :cond_0
    instance-of v1, p1, Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 6
    check-cast p1, Ljava/lang/String;

    return-object p1

    .line 9
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 10
    instance-of v2, p1, [J

    const-string v3, ","

    const/4 v4, 0x0

    if-eqz v2, :cond_4

    .line 11
    check-cast p1, [J

    .line 12
    :cond_2
    :goto_0
    array-length v0, p1

    if-ge v4, v0, :cond_3

    .line 13
    aget-wide v5, p1, v4

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    .line 14
    array-length v0, p1

    if-eq v4, v0, :cond_2

    .line 15
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 18
    :cond_3
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 20
    :cond_4
    instance-of v2, p1, [I

    if-eqz v2, :cond_7

    .line 21
    check-cast p1, [I

    .line 22
    :cond_5
    :goto_1
    array-length v0, p1

    if-ge v4, v0, :cond_6

    .line 23
    aget v0, p1, v4

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    .line 24
    array-length v0, p1

    if-eq v4, v0, :cond_5

    .line 25
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 28
    :cond_6
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 30
    :cond_7
    instance-of v2, p1, [D

    if-eqz v2, :cond_a

    .line 31
    check-cast p1, [D

    .line 32
    :cond_8
    :goto_2
    array-length v0, p1

    if-ge v4, v0, :cond_9

    .line 33
    aget-wide v5, p1, v4

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    .line 34
    array-length v0, p1

    if-eq v4, v0, :cond_8

    .line 35
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 38
    :cond_9
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    .line 40
    :cond_a
    instance-of v2, p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    if-eqz v2, :cond_d

    .line 41
    check-cast p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    .line 42
    :cond_b
    :goto_3
    array-length v0, p1

    if-ge v4, v0, :cond_c

    .line 43
    aget-object v0, p1, v4

    iget-wide v5, v0, Lio/dcloud/common/util/ExifInterface$Rational;->numerator:J

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const/16 v0, 0x2f

    .line 44
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 45
    aget-object v0, p1, v4

    iget-wide v5, v0, Lio/dcloud/common/util/ExifInterface$Rational;->denominator:J

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    add-int/lit8 v4, v4, 0x1

    .line 46
    array-length v0, p1

    if-eq v4, v0, :cond_b

    .line 47
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    .line 50
    :cond_c
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_d
    return-object v0
.end method

.method getValue(Ljava/nio/ByteOrder;)Ljava/lang/Object;
    .locals 11

    const-string v0, "IOException occurred while closing InputStream"

    const-string v1, "ExifInterface"

    const/4 v2, 0x0

    .line 1
    :try_start_0
    new-instance v3, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;

    iget-object v4, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    invoke-direct {v3, v4}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 2
    :try_start_1
    invoke-virtual {v3, p1}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->setByteOrder(Ljava/nio/ByteOrder;)V

    .line 3
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->format:I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    const/4 v4, 0x0

    packed-switch p1, :pswitch_data_0

    .line 112
    :try_start_2
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    return-object v2

    .line 115
    :pswitch_0
    :try_start_3
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [D

    .line 116
    :goto_0
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 117
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readDouble()D

    move-result-wide v5

    aput-wide v5, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 133
    :pswitch_1
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [D

    .line 134
    :goto_1
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 135
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readFloat()F

    move-result v5

    float-to-double v5, v5

    aput-wide v5, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 136
    :pswitch_2
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    .line 137
    :goto_2
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 138
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readInt()I

    move-result v5

    int-to-long v5, v5

    .line 139
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readInt()I

    move-result v7

    int-to-long v7, v7

    .line 140
    new-instance v9, Lio/dcloud/common/util/ExifInterface$Rational;

    invoke-direct {v9, v5, v6, v7, v8}, Lio/dcloud/common/util/ExifInterface$Rational;-><init>(JJ)V

    aput-object v9, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 141
    :pswitch_3
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [I

    .line 142
    :goto_3
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 143
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readInt()I

    move-result v5

    aput v5, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 144
    :pswitch_4
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [I

    .line 145
    :goto_4
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 146
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readShort()S

    move-result v5

    aput v5, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_4

    .line 147
    :pswitch_5
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [Lio/dcloud/common/util/ExifInterface$Rational;

    .line 148
    :goto_5
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 149
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readUnsignedInt()J

    move-result-wide v5

    .line 150
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readUnsignedInt()J

    move-result-wide v7

    .line 151
    new-instance v9, Lio/dcloud/common/util/ExifInterface$Rational;

    invoke-direct {v9, v5, v6, v7, v8}, Lio/dcloud/common/util/ExifInterface$Rational;-><init>(JJ)V

    aput-object v9, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_5

    .line 152
    :pswitch_6
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [J

    .line 153
    :goto_6
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 154
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readUnsignedInt()J

    move-result-wide v5

    aput-wide v5, p1, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_6

    .line 155
    :pswitch_7
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    new-array p1, p1, [I

    .line 156
    :goto_7
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_0

    .line 157
    invoke-virtual {v3}, Lio/dcloud/common/util/ExifInterface$ByteOrderedDataInputStream;->readUnsignedShort()I

    move-result v5

    aput v5, p1, v4
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    add-int/lit8 v4, v4, 0x1

    goto :goto_7

    .line 130
    :cond_0
    :try_start_4
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    return-object p1

    :catch_0
    move-exception v2

    goto/16 :goto_f

    .line 158
    :pswitch_8
    :try_start_5
    iget p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    sget-object v5, Lio/dcloud/common/util/ExifInterface;->EXIF_ASCII_PREFIX:[B

    array-length v5, v5

    if-lt p1, v5, :cond_3

    const/4 p1, 0x0

    .line 160
    :goto_8
    sget-object v5, Lio/dcloud/common/util/ExifInterface;->EXIF_ASCII_PREFIX:[B

    array-length v6, v5

    if-ge p1, v6, :cond_2

    .line 161
    iget-object v6, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    aget-byte v6, v6, p1

    aget-byte v5, v5, p1

    if-eq v6, v5, :cond_1

    goto :goto_9

    :cond_1
    add-int/lit8 p1, p1, 0x1

    goto :goto_8

    .line 167
    :cond_2
    array-length v4, v5

    .line 171
    :cond_3
    :goto_9
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    .line 172
    :goto_a
    iget v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    if-ge v4, v5, :cond_6

    .line 173
    iget-object v5, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    aget-byte v5, v5, v4

    if-nez v5, :cond_4

    goto :goto_c

    :cond_4
    const/16 v6, 0x20

    if-lt v5, v6, :cond_5

    int-to-char v5, v5

    .line 178
    invoke-virtual {p1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_b

    :cond_5
    const/16 v5, 0x3f

    .line 180
    invoke-virtual {p1, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    :goto_b
    add-int/lit8 v4, v4, 0x1

    goto :goto_a

    .line 184
    :cond_6
    :goto_c
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :goto_d
    move-object v2, p1

    goto :goto_e

    .line 256
    :pswitch_9
    iget-object p1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    array-length v5, p1

    const/4 v6, 0x1

    if-ne v5, v6, :cond_7

    aget-byte v5, p1, v4

    if-ltz v5, :cond_7

    if-gt v5, v6, :cond_7

    .line 257
    new-instance p1, Ljava/lang/String;

    add-int/lit8 v5, v5, 0x30

    int-to-char v5, v5

    new-array v6, v6, [C

    aput-char v5, v6, v4

    invoke-direct {p1, v6}, Ljava/lang/String;-><init>([C)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_d

    .line 255
    :goto_e
    :try_start_6
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    return-object v2

    :catchall_0
    move-exception p1

    goto :goto_13

    :catch_1
    move-exception p1

    goto :goto_10

    .line 259
    :cond_7
    :try_start_7
    new-instance v4, Ljava/lang/String;

    sget-object v5, Lio/dcloud/common/util/ExifInterface;->ASCII:Ljava/nio/charset/Charset;

    invoke-direct {v4, p1, v5}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 361
    :try_start_8
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2

    return-object v4

    :catch_2
    move-exception v2

    move-object p1, v4

    goto :goto_f

    :catch_3
    move-exception p1

    move-object v10, v2

    move-object v2, p1

    move-object p1, v10

    .line 114
    :goto_f
    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    return-object p1

    :catchall_1
    move-exception p1

    goto :goto_12

    :catch_4
    move-exception p1

    move-object v3, v2

    .line 362
    :goto_10
    :try_start_9
    const-string v4, "IOException occurred during reading a value"

    invoke-static {v1, v4, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    if-eqz v3, :cond_8

    .line 367
    :try_start_a
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_5

    goto :goto_11

    :catch_5
    move-exception p1

    .line 369
    invoke-static {v1, v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_8
    :goto_11
    return-object v2

    :catchall_2
    move-exception p1

    move-object v2, v3

    :goto_12
    move-object v3, v2

    :goto_13
    if-eqz v3, :cond_9

    .line 370
    :try_start_b
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_b
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_6

    goto :goto_14

    :catch_6
    move-exception v2

    .line 372
    invoke-static {v1, v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 375
    :cond_9
    :goto_14
    throw p1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_9
        :pswitch_8
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public size()I
    .locals 2

    .line 1
    sget-object v0, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_BYTES_PER_FORMAT:[I

    iget v1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->format:I

    aget v0, v0, v1

    iget v1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->numberOfComponents:I

    mul-int v0, v0, v1

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "("

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lio/dcloud/common/util/ExifInterface;->IFD_FORMAT_NAMES:[Ljava/lang/String;

    iget v2, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->format:I

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", data length:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lio/dcloud/common/util/ExifInterface$ExifAttribute;->bytes:[B

    array-length v1, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
