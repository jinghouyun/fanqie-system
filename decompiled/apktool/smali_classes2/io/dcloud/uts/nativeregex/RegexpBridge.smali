.class public final Lio/dcloud/uts/nativeregex/RegexpBridge;
.super Ljava/lang/Object;
.source "RegexpBridge.kt"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0086 J#\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0086 J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0086 J+\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0086 J\u0013\u0010\u001c\u001a\u00020\u00102\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086 J\u0011\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010H\u0086 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"
    }
    d2 = {
        "Lio/dcloud/uts/nativeregex/RegexpBridge;",
        "",
        "<init>",
        "()V",
        "FLAG_GLOBAL",
        "",
        "FLAG_IGNORECASE",
        "FLAG_MULTILINE",
        "FLAG_DOTALL",
        "FLAG_UNICODE",
        "FLAG_STICKY",
        "FLAG_INDICES",
        "FLAG_UNICODE_SETS",
        "compileRegexp",
        "",
        "pattern",
        "",
        "flags",
        "execRegexp",
        "Lio/dcloud/uts/RegExpExecArray;",
        "bytecode",
        "input",
        "startIndex",
        "getFlags",
        "replace",
        "replacement",
        "global",
        "",
        "getSource",
        "escape",
        "str",
        "utsplugin_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x2,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final FLAG_DOTALL:I = 0x8

.field public static final FLAG_GLOBAL:I = 0x1

.field public static final FLAG_IGNORECASE:I = 0x2

.field public static final FLAG_INDICES:I = 0x40

.field public static final FLAG_MULTILINE:I = 0x4

.field public static final FLAG_STICKY:I = 0x20

.field public static final FLAG_UNICODE:I = 0x10

.field public static final FLAG_UNICODE_SETS:I = 0x80

.field public static final INSTANCE:Lio/dcloud/uts/nativeregex/RegexpBridge;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lio/dcloud/uts/nativeregex/RegexpBridge;

    invoke-direct {v0}, Lio/dcloud/uts/nativeregex/RegexpBridge;-><init>()V

    sput-object v0, Lio/dcloud/uts/nativeregex/RegexpBridge;->INSTANCE:Lio/dcloud/uts/nativeregex/RegexpBridge;

    .line 8
    const-string v0, "uts-runtime"

    invoke-static {v0}, Ljava/lang/System;->loadLibrary(Ljava/lang/String;)V

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final native compileRegexp(Ljava/lang/String;I)[B
.end method

.method public final native escape(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public final native execRegexp([BLjava/lang/String;I)Lio/dcloud/uts/RegExpExecArray;
.end method

.method public final native getFlags([B)I
.end method

.method public final native getSource(Ljava/lang/String;)Ljava/lang/String;
.end method

.method public final native replace([BLjava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
.end method
