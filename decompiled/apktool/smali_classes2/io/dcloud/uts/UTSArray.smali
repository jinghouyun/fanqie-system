.class public Lio/dcloud/uts/UTSArray;
.super Ljava/util/ArrayList;
.source "UTSArray.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/uts/UTSArray$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/ArrayList<",
        "TE;>;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nUTSArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTSArray.kt\nio/dcloud/uts/UTSArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1401:1\n1869#2,2:1402\n*S KotlinDebug\n*F\n+ 1 UTSArray.kt\nio/dcloud/uts/UTSArray\n*L\n749#1:1402,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0004\n\u0002\u0008\r\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u001c\u0008\u0016\u0018\u0000 k*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001kB\u0007\u00a2\u0006\u0004\u0008\u0003\u0010\u0004B\u0017\u0008\u0016\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\u0008\u0003\u0010\u0007B\u001d\u0008\u0016\u0012\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\t\"\u00028\u0000\u00a2\u0006\u0004\u0008\u0003\u0010\nB\u0019\u0008\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0004\u0008\u0003\u0010\u000eJ\u0016\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u000cH\u0086\u0002\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\'\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u001a0\t\"\u00020\u001aH\u0016\u00a2\u0006\u0002\u0010\u001bJ.\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001d\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000cH\u0016J+\u0010 \u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u0010 \u001a\u00020!26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u0010 \u001a\u00020!2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020!0\'H\u0016J3\u0010)\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u000f\u001a\u00028\u00002\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000cH\u0016\u00a2\u0006\u0002\u0010*J1\u0010+\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020!0#H\u0016JF\u0010+\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020!0&H\u0016Ja\u0010+\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020!0\'H\u0016J2\u0010,\u001a\u0004\u0018\u00018\u00002!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020!0#H\u0016\u00a2\u0006\u0002\u0010-JG\u0010,\u001a\u0004\u0018\u00018\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020!0&H\u0016\u00a2\u0006\u0002\u0010.Jb\u0010,\u001a\u0004\u0018\u00018\u00002Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020!0\'H\u0016\u00a2\u0006\u0002\u0010/J+\u00100\u001a\u0002012!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u00100\u001a\u00020126\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u00100\u001a\u0002012Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020!0\'H\u0016J\u0016\u00102\u001a\u0006\u0012\u0002\u0008\u00030\u00002\u0008\u0008\u0002\u00103\u001a\u00020\u000cH\u0016J3\u00104\u001a\u0006\u0012\u0002\u0008\u00030\u00002%\u0010\"\u001a!\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00000#H\u0016JH\u00104\u001a\u0006\u0012\u0002\u0008\u00030\u00002:\u0010\"\u001a6\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00000&H\u0016Jc\u00104\u001a\u0006\u0012\u0002\u0008\u00030\u00002U\u0010\"\u001aQ\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00000\'H\u0016J\u0015\u00105\u001a\u00020!2\u0006\u00106\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u00107J\u001d\u00105\u001a\u00020!2\u0006\u00106\u001a\u00028\u00002\u0006\u00108\u001a\u00020\u000cH\u0016\u00a2\u0006\u0002\u00109J@\u0010:\u001a\u00020;26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020;0&H\u0016J[\u0010:\u001a\u00020;2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020;0\'H\u0016J\u0015\u0010<\u001a\u0002012\u0006\u00106\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010=J\u001f\u0010<\u001a\u0002012\u0006\u00106\u001a\u00028\u00002\u0008\u0008\u0002\u00108\u001a\u00020\u000cH\u0016\u00a2\u0006\u0002\u0010>J\u0012\u0010?\u001a\u00020@2\u0008\u0008\u0002\u0010A\u001a\u00020@H\u0016J\u000e\u0010B\u001a\u0008\u0012\u0004\u0012\u00020\u000c0CH\u0016J\u0015\u0010D\u001a\u0002012\u0006\u00106\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010=J\u001f\u0010D\u001a\u0002012\u0006\u00106\u001a\u00028\u00002\u0008\u0008\u0002\u00108\u001a\u00020\u000cH\u0016\u00a2\u0006\u0002\u0010>J7\u0010E\u001a\u0008\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\u0008\u0001\u0010F2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u0002HF0#H\u0016JL\u0010E\u001a\u0008\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\u0008\u0001\u0010F26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u0002HF0&H\u0016Jg\u0010E\u001a\u0008\u0012\u0004\u0012\u0002HF0\u0000\"\u0004\u0008\u0001\u0010F2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u0002HF0\'H\u0016J\u000f\u0010G\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010HJ!\u0010I\u001a\u0002012\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010JJd\u0010K\u001a\u00028\u0000\"\u0008\u0008\u0001\u0010L*\u00028\u00002K\u0010\"\u001aG\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u0011HL\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0004\u0012\u00028\u00000\'H\u0016\u00a2\u0006\u0002\u0010/J\u007f\u0010K\u001a\u00028\u0000\"\u0008\u0008\u0001\u0010L*\u00028\u00002f\u0010\"\u001ab\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u0011HL\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00028\u00000PH\u0016\u00a2\u0006\u0002\u0010QJS\u0010K\u001a\u0002HR\"\u0004\u0008\u0001\u0010R26\u0010\"\u001a2\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0004\u0012\u0002HR0&2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010TJh\u0010K\u001a\u0002HR\"\u0004\u0008\u0001\u0010R2K\u0010\"\u001aG\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0004\u0012\u0002HR0\'2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010UJ\u0083\u0001\u0010K\u001a\u0002HR\"\u0004\u0008\u0001\u0010R2f\u0010\"\u001ab\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u0002HR0P2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010VJO\u0010W\u001a\u00028\u0000\"\u0008\u0008\u0001\u0010L*\u00028\u000026\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u0011HL\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0004\u0012\u00028\u00000&H\u0016\u00a2\u0006\u0002\u0010.Jd\u0010W\u001a\u00028\u0000\"\u0008\u0008\u0001\u0010L*\u00028\u00002K\u0010\"\u001aG\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u0011HL\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0004\u0012\u00028\u00000\'H\u0016\u00a2\u0006\u0002\u0010/J\u007f\u0010W\u001a\u00028\u0000\"\u0008\u0008\u0001\u0010L*\u00028\u00002f\u0010\"\u001ab\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u0011HL\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00028\u00000PH\u0016\u00a2\u0006\u0002\u0010QJS\u0010W\u001a\u0002HR\"\u0004\u0008\u0001\u0010R26\u0010\"\u001a2\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0004\u0012\u0002HR0&2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010TJh\u0010W\u001a\u0002HR\"\u0004\u0008\u0001\u0010R2K\u0010\"\u001aG\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0004\u0012\u0002HR0\'2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010UJ\u0083\u0001\u0010W\u001a\u0002HR\"\u0004\u0008\u0001\u0010R2f\u0010\"\u001ab\u0012\u0013\u0012\u0011HR\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(M\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(N\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(O\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u0002HR0P2\u0006\u0010S\u001a\u0002HRH\u0016\u00a2\u0006\u0002\u0010VJ\u000e\u0010X\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000f\u0010Y\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010HJ\"\u0010Z\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u000cH\u0016J+\u0010[\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020!0#H\u0016J@\u0010[\u001a\u00020!26\u0010\"\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020!0&H\u0016J[\u0010[\u001a\u00020!2Q\u0010\"\u001aM\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u00110\u000c\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008((\u0012\u0004\u0012\u00020!0\'H\u0016J\u000c\u0010\\\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006JF\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000026\u0010]\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(^\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(_\u0012\u0004\u0012\u00020\u000c0&H\u0016J\u0016\u0010`\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u000cH\u0016J\u001e\u0010`\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u000c2\u0006\u0010a\u001a\u00020\u000cH\u0016J7\u0010`\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u000c2\u0006\u0010a\u001a\u00020\u000c2\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010bJ!\u0010c\u001a\u0002012\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\t\"\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010JJ\u0008\u0010d\u001a\u000201H\u0016J\u0008\u0010e\u001a\u00020@H\u0016J\u001e\u0010f\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u000c2\u0006\u0010g\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020!2\u0008\u0010j\u001a\u0004\u0018\u00010\u001aH\u0096\u0002R$\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u000c8F@FX\u0086\u000e\u00a2\u0006\u000c\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014\u00a8\u0006l"
    }
    d2 = {
        "Lio/dcloud/uts/UTSArray;",
        "E",
        "Ljava/util/ArrayList;",
        "<init>",
        "()V",
        "list",
        "",
        "(Ljava/util/List;)V",
        "items",
        "",
        "([Ljava/lang/Object;)V",
        "initSize",
        "",
        "defaultValue",
        "(Ljava/lang/Number;Ljava/lang/Object;)V",
        "value",
        "length",
        "getLength",
        "()Ljava/lang/Number;",
        "setLength",
        "(Ljava/lang/Number;)V",
        "get",
        "index",
        "(Ljava/lang/Number;)Ljava/lang/Object;",
        "sort",
        "concat",
        "",
        "([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;",
        "copyWithin",
        "target",
        "start",
        "end",
        "every",
        "",
        "callback",
        "Lkotlin/Function1;",
        "Lkotlin/ParameterName;",
        "name",
        "Lkotlin/Function2;",
        "Lkotlin/Function3;",
        "array",
        "fill",
        "(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;",
        "filter",
        "find",
        "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;",
        "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;",
        "(Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;",
        "findIndex",
        "",
        "flat",
        "depth",
        "flatMap",
        "includes",
        "searchElement",
        "(Ljava/lang/Object;)Z",
        "fromIndex",
        "(Ljava/lang/Object;Ljava/lang/Number;)Z",
        "forEach",
        "",
        "indexOf",
        "(Ljava/lang/Object;)I",
        "(Ljava/lang/Object;Ljava/lang/Number;)I",
        "join",
        "",
        "separator",
        "keys",
        "",
        "lastIndexOf",
        "map",
        "R",
        "pop",
        "()Ljava/lang/Object;",
        "push",
        "([Ljava/lang/Object;)I",
        "reduce",
        "T",
        "previousValue",
        "currentValue",
        "currentIndex",
        "Lkotlin/Function4;",
        "(Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;",
        "S",
        "initialValue",
        "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)Ljava/lang/Object;",
        "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;",
        "(Lkotlin/jvm/functions/Function4;Ljava/lang/Object;)Ljava/lang/Object;",
        "reduceRight",
        "reverse",
        "shift",
        "slice",
        "some",
        "toKotlinList",
        "compareFn",
        "a",
        "b",
        "splice",
        "deleteCount",
        "(Ljava/lang/Number;Ljava/lang/Number;[Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;",
        "unshift",
        "hashCode",
        "toString",
        "set",
        "element",
        "(Ljava/lang/Number;Ljava/lang/Object;)Ljava/lang/Object;",
        "equals",
        "other",
        "Companion",
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
.field public static final Companion:Lio/dcloud/uts/UTSArray$Companion;


# direct methods
.method public static synthetic $r8$lambda$H8HmRMsQ_T-Bm_XSEPvp7BP9zgY(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 0

    invoke-static {p0, p1, p2}, Lio/dcloud/uts/UTSArray;->sort$lambda$2(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$Jg_Yogwn0tMjYsbq-S9jfMfSxXs(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 0

    invoke-static {p0, p1}, Lio/dcloud/uts/UTSArray;->sort$lambda$0(Ljava/lang/Object;Ljava/lang/Object;)I

    move-result p0

    return p0
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lio/dcloud/uts/UTSArray$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSArray$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lio/dcloud/uts/UTSArray;->Companion:Lio/dcloud/uts/UTSArray$Companion;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 46
    invoke-direct {p0}, Ljava/util/ArrayList;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/Number;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "TE;)V"
        }
    .end annotation

    const-string v0, "initSize"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 368
    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 369
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, p1, :cond_0

    .line 370
    invoke-virtual {p0, p2}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "+TE;>;)V"
        }
    .end annotation

    const-string v0, "list"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 352
    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 353
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .line 354
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    return-void
.end method

.method public varargs constructor <init>([Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TE;)V"
        }
    .end annotation

    const-string v0, "items"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 358
    invoke-direct {p0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 359
    array-length v0, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    aget-object v2, p1, v1

    .line 360
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public static synthetic copyWithin$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 0

    if-nez p5, :cond_2

    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_0

    const/4 p2, 0x0

    .line 482
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/UTSArray;->copyWithin(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0

    :cond_2
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: copyWithin"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic fill$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 0

    if-nez p5, :cond_2

    and-int/lit8 p5, p4, 0x2

    if-eqz p5, :cond_0

    const/4 p2, 0x0

    .line 581
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    :cond_0
    and-int/lit8 p4, p4, 0x4

    if-eqz p4, :cond_1

    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    check-cast p3, Ljava/lang/Number;

    :cond_1
    invoke-virtual {p0, p1, p2, p3}, Lio/dcloud/uts/UTSArray;->fill(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0

    :cond_2
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: fill"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic flat$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;ILjava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 0

    if-nez p3, :cond_1

    const/4 p3, 0x1

    and-int/2addr p2, p3

    if-eqz p2, :cond_0

    .line 746
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    :cond_0
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->flat(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0

    :cond_1
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: flat"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static final flat$flatDeep(Lio/dcloud/uts/UTSArray;Ljava/util/List;Ljava/lang/Number;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/uts/UTSArray<",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/util/List<",
            "*>;",
            "Ljava/lang/Number;",
            ")V"
        }
    .end annotation

    .line 749
    check-cast p1, Ljava/lang/Iterable;

    .line 1402
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    const/4 v1, 0x0

    .line 750
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {p2, v1}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v1

    if-lez v1, :cond_0

    invoke-static {v0}, Lkotlin/jvm/internal/TypeIntrinsics;->isMutableList(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 751
    check-cast v0, Ljava/util/List;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {p2, v1}, Lio/dcloud/uts/NumberKt;->minus(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lio/dcloud/uts/UTSArray;->flat$flatDeep(Lio/dcloud/uts/UTSArray;Ljava/util/List;Ljava/lang/Number;)V

    goto :goto_0

    .line 753
    :cond_0
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    return-void
.end method

.method public static synthetic indexOf$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Object;Ljava/lang/Number;ILjava/lang/Object;)I
    .locals 0

    if-nez p4, :cond_1

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 844
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray;->indexOf(Ljava/lang/Object;Ljava/lang/Number;)I

    move-result p0

    return p0

    :cond_1
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: indexOf"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic join$default(Lio/dcloud/uts/UTSArray;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
    .locals 0

    if-nez p3, :cond_1

    and-int/lit8 p2, p2, 0x1

    if-eqz p2, :cond_0

    .line 868
    const-string p1, ","

    :cond_0
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->join(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    return-object p0

    :cond_1
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: join"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic lastIndexOf$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Object;Ljava/lang/Number;ILjava/lang/Object;)I
    .locals 0

    if-nez p4, :cond_1

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 920
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    :cond_0
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray;->lastIndexOf(Ljava/lang/Object;Ljava/lang/Number;)I

    move-result p0

    return p0

    :cond_1
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: lastIndexOf"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method public static synthetic slice$default(Lio/dcloud/uts/UTSArray;Ljava/lang/Number;Ljava/lang/Number;ILjava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 0

    if-nez p4, :cond_2

    and-int/lit8 p4, p3, 0x1

    if-eqz p4, :cond_0

    const/4 p1, 0x0

    .line 1208
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    check-cast p1, Ljava/lang/Number;

    :cond_0
    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_1

    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p2

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    check-cast p2, Ljava/lang/Number;

    :cond_1
    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray;->slice(Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p0

    return-object p0

    :cond_2
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    const-string p1, "Super calls with default arguments not supported in this target, function: slice"

    invoke-direct {p0, p1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0
.end method

.method private static final sort$lambda$0(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 8

    .line 408
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p0

    sget-object v0, Lkotlin/text/Charsets;->UTF_16BE:Ljava/nio/charset/Charset;

    invoke-virtual {p0, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p0

    const-string v0, "getBytes(...)"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 409
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    sget-object v1, Lkotlin/text/Charsets;->UTF_16BE:Ljava/nio/charset/Charset;

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object p1

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 416
    array-length v0, p0

    const/4 v1, -0x1

    if-nez v0, :cond_0

    return v1

    .line 418
    :cond_0
    array-length v0, p1

    const/4 v2, 0x1

    if-nez v0, :cond_1

    return v2

    .line 425
    :cond_1
    array-length v0, p0

    .line 426
    array-length v3, p1

    const/4 v4, 0x2

    .line 428
    new-array v4, v4, [Ljava/lang/Number;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, 0x0

    aput-object v5, v4, v6

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v4}, Lio/dcloud/uts/Math;->min([Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v4

    :goto_0
    if-ge v6, v4, :cond_4

    .line 431
    aget-byte v5, p0, v6

    .line 432
    aget-byte v7, p1, v6

    if-ge v5, v7, :cond_2

    return v1

    :cond_2
    if-le v5, v7, :cond_3

    return v2

    :cond_3
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    :cond_4
    sub-int/2addr v0, v3

    return v0
.end method

.method private static final sort$lambda$2(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1

    .line 1277
    invoke-interface {p0, p1, p2}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, Ljava/lang/Number;

    const/4 p1, 0x0

    .line 1278
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p2

    move-object v0, p2

    check-cast v0, Ljava/lang/Number;

    invoke-static {p0, v0}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v0

    if-lez v0, :cond_0

    const/4 p0, 0x1

    return p0

    .line 1280
    :cond_0
    check-cast p2, Ljava/lang/Number;

    invoke-static {p0, p2}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result p0

    if-gez p0, :cond_1

    const/4 p0, -0x1

    return p0

    :cond_1
    return p1
.end method


# virtual methods
.method public varargs concat([Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/Object;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "items"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 462
    new-instance v0, Lio/dcloud/uts/UTSArray;

    move-object v1, p0

    check-cast v1, Ljava/util/List;

    invoke-direct {v0, v1}, Lio/dcloud/uts/UTSArray;-><init>(Ljava/util/List;)V

    .line 464
    array-length v1, p1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_2

    aget-object v3, p1, v2

    .line 465
    instance-of v4, v3, Lio/dcloud/uts/UTSArray;

    if-eqz v4, :cond_0

    .line 466
    check-cast v3, Lio/dcloud/uts/UTSArray;

    invoke-virtual {v3}, Lio/dcloud/uts/UTSArray;->iterator()Ljava/util/Iterator;

    move-result-object v3

    const-string v4, "iterator(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 467
    invoke-virtual {v0, v4}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 471
    :cond_0
    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_2
    return-object v0
.end method

.method public copyWithin(Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "target"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 484
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    .line 485
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result v1

    const/4 v2, 0x0

    .line 486
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    check-cast v3, Ljava/lang/Number;

    invoke-static {p1, v3}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result p1

    if-gez p1, :cond_0

    add-int/2addr v1, v0

    .line 487
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result p1

    goto :goto_0

    .line 489
    :cond_0
    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result p1

    :goto_0
    if-eqz p2, :cond_1

    .line 491
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    goto :goto_1

    :cond_1
    const/4 p2, 0x0

    :goto_1
    if-gez p2, :cond_2

    add-int/2addr p2, v0

    .line 493
    invoke-static {p2, v2}, Ljava/lang/Math;->max(II)I

    move-result p2

    goto :goto_2

    .line 495
    :cond_2
    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result p2

    :goto_2
    if-eqz p3, :cond_3

    .line 497
    invoke-virtual {p3}, Ljava/lang/Number;->intValue()I

    move-result p3

    goto :goto_3

    :cond_3
    move p3, v0

    :goto_3
    if-gez p3, :cond_4

    add-int/2addr p3, v0

    .line 499
    invoke-static {p3, v2}, Ljava/lang/Math;->max(II)I

    move-result p3

    goto :goto_4

    .line 501
    :cond_4
    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result p3

    :goto_4
    sub-int/2addr p3, p2

    sub-int/2addr v0, p1

    .line 504
    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result p3

    if-ge p2, p1, :cond_5

    add-int v0, p2, p3

    if-ge p1, v0, :cond_5

    add-int/lit8 v0, p3, -0x1

    add-int/2addr p2, v0

    add-int/2addr p1, v0

    const/4 v0, -0x1

    goto :goto_5

    :cond_5
    const/4 v0, 0x1

    :goto_5
    if-lez p3, :cond_7

    .line 513
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    if-ge p2, v1, :cond_6

    .line 514
    invoke-virtual {p0, p2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, p1, v1}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_6

    .line 516
    :cond_6
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->remove(I)Ljava/lang/Object;

    :goto_6
    add-int/2addr p2, v0

    add-int/2addr p1, v0

    add-int/lit8 p3, p3, -0x1

    goto :goto_5

    :cond_7
    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 0

    if-ne p0, p1, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    const/4 p1, 0x0

    return p1
.end method

.method public every(Lkotlin/jvm/functions/Function1;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 541
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 543
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p1, v3}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x1

    return p1
.end method

.method public every(Lkotlin/jvm/functions/Function2;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 554
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 556
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x1

    return p1
.end method

.method public every(Lkotlin/jvm/functions/Function3;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 566
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 568
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_0

    return v1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x1

    return p1
.end method

.method public fill(Ljava/lang/Object;Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    .line 582
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    if-eqz p2, :cond_0

    .line 583
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    goto :goto_0

    :cond_0
    const/4 p2, 0x0

    :goto_0
    if-gez p2, :cond_1

    add-int/2addr p2, v0

    .line 586
    invoke-static {p2, v1}, Ljava/lang/Math;->max(II)I

    move-result p2

    goto :goto_1

    .line 588
    :cond_1
    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result p2

    :goto_1
    if-eqz p3, :cond_2

    .line 590
    invoke-virtual {p3}, Ljava/lang/Number;->intValue()I

    move-result p3

    goto :goto_2

    :cond_2
    move p3, v0

    :goto_2
    if-gez p3, :cond_3

    add-int/2addr v0, p3

    .line 592
    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result p3

    goto :goto_3

    .line 594
    :cond_3
    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result p3

    :goto_3
    if-ge p2, p3, :cond_4

    .line 597
    invoke-virtual {p0, p2, p1}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 p2, p2, 0x1

    goto :goto_3

    :cond_4
    return-object p0
.end method

.method public filter(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 609
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 611
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    .line 613
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 614
    invoke-interface {p1, v3}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 615
    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return-object v0
.end method

.method public filter(Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 624
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 626
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    .line 628
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 629
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 630
    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return-object v0
.end method

.method public filter(Lkotlin/jvm/functions/Function3;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 638
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 640
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    .line 642
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 643
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 644
    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return-object v0
.end method

.method public find(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;",
            "Ljava/lang/Boolean;",
            ">;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 658
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 660
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 661
    invoke-interface {p1, v2}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    return-object v2

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public find(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Ljava/lang/Boolean;",
            ">;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 672
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 674
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 675
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    return-object v2

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public find(Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Ljava/lang/Boolean;",
            ">;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 685
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 687
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 688
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v2, v3, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    return-object v2

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, 0x0

    return-object p1
.end method

.method public findIndex(Lkotlin/jvm/functions/Function1;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;",
            "Ljava/lang/Boolean;",
            ">;)I"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 703
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 705
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 706
    invoke-interface {p1, v2}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, -0x1

    return p1
.end method

.method public findIndex(Lkotlin/jvm/functions/Function2;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Ljava/lang/Boolean;",
            ">;)I"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 717
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 719
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 720
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v2, v3}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, -0x1

    return p1
.end method

.method public findIndex(Lkotlin/jvm/functions/Function3;)I
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Ljava/lang/Boolean;",
            ">;)I"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 730
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    .line 732
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 733
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v2, v3, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    return v1

    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    const/4 p1, -0x1

    return p1
.end method

.method public flat(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "depth"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 747
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 757
    move-object v1, p0

    check-cast v1, Ljava/util/List;

    invoke-static {v0, v1, p1}, Lio/dcloud/uts/UTSArray;->flat$flatDeep(Lio/dcloud/uts/UTSArray;Ljava/util/List;Ljava/lang/Number;)V

    return-object v0
.end method

.method public flatMap(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;+",
            "Lio/dcloud/uts/UTSArray<",
            "*>;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 767
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->map(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p1, v0}, Lio/dcloud/uts/UTSArray;->flat(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    return-object p1
.end method

.method public flatMap(Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "+",
            "Lio/dcloud/uts/UTSArray<",
            "*>;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 771
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->map(Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p1, v0}, Lio/dcloud/uts/UTSArray;->flat(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    return-object p1
.end method

.method public flatMap(Lkotlin/jvm/functions/Function3;)Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+",
            "Lio/dcloud/uts/UTSArray<",
            "*>;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "*>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 775
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->map(Lkotlin/jvm/functions/Function3;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p1, v0}, Lio/dcloud/uts/UTSArray;->flat(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    move-result-object p1

    return-object p1
.end method

.method public forEach(Lkotlin/jvm/functions/Function2;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 819
    :goto_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 820
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public forEach(Lkotlin/jvm/functions/Function3;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 827
    :goto_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 828
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, v1, v2, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    return-void
.end method

.method public final get(Ljava/lang/Number;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            ")TE;"
        }
    .end annotation

    const-string v0, "index"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 387
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final getLength()Ljava/lang/Number;
    .locals 1

    .line 379
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public bridge getSize()I
    .locals 1

    .line 46
    invoke-super {p0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .line 1363
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public includes(Ljava/lang/Object;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    const/4 v0, 0x0

    .line 784
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/UTSArray;->includes(Ljava/lang/Object;Ljava/lang/Number;)Z

    move-result p1

    return p1
.end method

.method public includes(Ljava/lang/Object;Ljava/lang/Number;)Z
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Number;",
            ")Z"
        }
    .end annotation

    const-string v0, "fromIndex"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 793
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    .line 794
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    if-ltz p2, :cond_0

    goto :goto_0

    .line 795
    :cond_0
    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result p2

    sub-int p2, v0, p2

    :goto_0
    const/4 v1, 0x0

    invoke-static {p2, v1}, Ljava/lang/Math;->max(II)I

    move-result p2

    :goto_1
    if-ge p2, v0, :cond_3

    .line 797
    invoke-virtual {p0, p2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 798
    instance-of v3, p1, Ljava/lang/Number;

    const/4 v4, 0x1

    if-eqz v3, :cond_1

    instance-of v3, v2, Ljava/lang/Number;

    if-eqz v3, :cond_1

    .line 803
    check-cast v2, Ljava/lang/Number;

    invoke-virtual {v2}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v2

    move-object v5, p1

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v5}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v5

    cmpg-double v7, v2, v5

    if-nez v7, :cond_2

    return v4

    .line 807
    :cond_1
    invoke-static {v2, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    return v4

    :cond_2
    add-int/lit8 p2, p2, 0x1

    goto :goto_1

    :cond_3
    return v1
.end method

.method public indexOf(Ljava/lang/Object;)I
    .locals 1

    const/4 v0, 0x0

    .line 835
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/UTSArray;->indexOf(Ljava/lang/Object;Ljava/lang/Number;)I

    move-result p1

    return p1
.end method

.method public indexOf(Ljava/lang/Object;Ljava/lang/Number;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Number;",
            ")I"
        }
    .end annotation

    const-string v0, "fromIndex"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 845
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, -0x1

    if-nez v0, :cond_0

    return v1

    .line 849
    :cond_0
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    if-lt p2, v0, :cond_1

    return v1

    :cond_1
    if-ltz p2, :cond_2

    goto :goto_0

    .line 853
    :cond_2
    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result p2

    sub-int p2, v0, p2

    :goto_0
    const/4 v2, 0x0

    invoke-static {p2, v2}, Ljava/lang/Math;->max(II)I

    move-result p2

    :goto_1
    if-ge p2, v0, :cond_4

    .line 855
    invoke-virtual {p0, p2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    return p2

    :cond_3
    add-int/lit8 p2, p2, 0x1

    goto :goto_1

    :cond_4
    return v1
.end method

.method public join(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const-string v0, "separator"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 870
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 871
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const-string v2, "iterator(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 872
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 873
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_1

    .line 878
    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 880
    :cond_1
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 885
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 886
    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 890
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "toString(...)"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object p1
.end method

.method public keys()Ljava/util/Iterator;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation

    .line 900
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 901
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    .line 902
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 904
    :cond_0
    invoke-virtual {v0}, Lio/dcloud/uts/UTSArray;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const-string v1, "iterator(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method public lastIndexOf(Ljava/lang/Object;)I
    .locals 2

    .line 909
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ge v0, v1, :cond_0

    const/4 p1, -0x1

    return p1

    .line 912
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    sub-int/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    invoke-virtual {p0, p1, v0}, Lio/dcloud/uts/UTSArray;->lastIndexOf(Ljava/lang/Object;Ljava/lang/Number;)I

    move-result p1

    return p1
.end method

.method public lastIndexOf(Ljava/lang/Object;Ljava/lang/Number;)I
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;",
            "Ljava/lang/Number;",
            ")I"
        }
    .end annotation

    const-string v0, "fromIndex"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 921
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, -0x1

    if-nez v0, :cond_0

    return v1

    .line 925
    :cond_0
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result p2

    if-ltz p2, :cond_1

    add-int/lit8 v0, v0, -0x1

    .line 926
    invoke-static {p2, v0}, Ljava/lang/Math;->min(II)I

    move-result p2

    goto :goto_0

    :cond_1
    invoke-static {p2}, Ljava/lang/Math;->abs(I)I

    move-result p2

    sub-int p2, v0, p2

    :goto_0
    if-ltz p2, :cond_3

    .line 928
    invoke-virtual {p0, p2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    return p2

    :cond_2
    add-int/lit8 p2, p2, -0x1

    goto :goto_0

    :cond_3
    return v1
.end method

.method public map(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;+TR;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "TR;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 944
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    .line 945
    new-instance v1, Lio/dcloud/uts/UTSArray;

    invoke-direct {v1}, Lio/dcloud/uts/UTSArray;-><init>()V

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_0

    .line 947
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p1, v3}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public map(Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "+TR;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "TR;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 956
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    .line 957
    new-instance v1, Lio/dcloud/uts/UTSArray;

    invoke-direct {v1}, Lio/dcloud/uts/UTSArray;-><init>()V

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_0

    .line 959
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public map(Lkotlin/jvm/functions/Function3;)Lio/dcloud/uts/UTSArray;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+TR;>;)",
            "Lio/dcloud/uts/UTSArray<",
            "TR;>;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 967
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    .line 968
    new-instance v1, Lio/dcloud/uts/UTSArray;

    invoke-direct {v1}, Lio/dcloud/uts/UTSArray;-><init>()V

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_0

    .line 970
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public pop()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 982
    move-object v0, p0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->removeLastOrNull(Ljava/util/List;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public varargs push([Ljava/lang/Object;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TE;)I"
        }
    .end annotation

    const-string v0, "items"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 990
    move-object v0, p0

    check-cast v0, Ljava/util/Collection;

    invoke-static {v0, p1}, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 991
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p1

    return p1
.end method

.method public reduce(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function2<",
            "-TS;-TE;+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1036
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    .line 1039
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {p1, p2, v2}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public reduce(Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::TE;>(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-TT;-",
            "Ljava/lang/Number;",
            "+TE;>;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1005
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    .line 1006
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x1

    :goto_0
    if-ge v2, v0, :cond_0

    .line 1008
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v1, v3, v4}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public reduce(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function3<",
            "-TS;-TE;-",
            "Ljava/lang/Number;",
            "+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1051
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    .line 1054
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, p2, v2, v3}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public reduce(Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::TE;>(",
            "Lkotlin/jvm/functions/Function4<",
            "-TE;-TT;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+TE;>;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1020
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    .line 1021
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x1

    :goto_0
    if-ge v2, v0, :cond_0

    .line 1023
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v1, v3, v4, p0}, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method

.method public reduce(Lkotlin/jvm/functions/Function4;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function4<",
            "-TS;-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1066
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    .line 1069
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, p2, v2, v3, p0}, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::TE;>(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-TT;+TE;>;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1086
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v1, v0, -0x1

    if-ltz v1, :cond_1

    add-int/lit8 v0, v0, -0x2

    .line 1091
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    :goto_0
    if-ltz v0, :cond_0

    .line 1093
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-interface {p1, v1, v2}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object v1

    .line 1089
    :cond_1
    new-instance p1, Ljava/lang/Error;

    const-string v0, "Reduce of empty array with no initial value"

    invoke-direct {p1, v0}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function2<",
            "-TS;-TE;+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1144
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    .line 1148
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-interface {p1, p2, v1}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::TE;>(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-TT;-",
            "Ljava/lang/Number;",
            "+TE;>;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1105
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v1, v0, -0x1

    if-ltz v1, :cond_1

    add-int/lit8 v0, v0, -0x2

    .line 1110
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    :goto_0
    if-ltz v0, :cond_0

    .line 1112
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v1, v2, v3}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object v1

    .line 1108
    :cond_1
    new-instance p1, Ljava/lang/Error;

    const-string v0, "Reduce of empty array with no initial value"

    invoke-direct {p1, v0}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function3<",
            "-TS;-TE;-",
            "Ljava/lang/Number;",
            "+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1160
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    .line 1164
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::TE;>(",
            "Lkotlin/jvm/functions/Function4<",
            "-TE;-TT;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+TE;>;)TE;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1125
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v1, v0, -0x1

    if-ltz v1, :cond_1

    add-int/lit8 v0, v0, -0x2

    .line 1130
    invoke-virtual {p0, v1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    :goto_0
    if-ltz v0, :cond_0

    .line 1132
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p1, v1, v2, v3, p0}, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object v1

    .line 1128
    :cond_1
    new-instance p1, Ljava/lang/Error;

    const-string v0, "Reduce of empty array with no initial value"

    invoke-direct {p1, v0}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public reduceRight(Lkotlin/jvm/functions/Function4;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<S:",
            "Ljava/lang/Object;",
            ">(",
            "Lkotlin/jvm/functions/Function4<",
            "-TS;-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;+TS;>;TS;)TS;"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1176
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    .line 1180
    invoke-virtual {p0, v0}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2, p0}, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    :cond_0
    return-object p2
.end method

.method public final bridge remove(I)Ljava/lang/Object;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    .line 46
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->removeAt(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public bridge removeAt(I)Ljava/lang/Object;
    .locals 0

    .line 46
    invoke-super {p0, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public reverse()Lio/dcloud/uts/UTSArray;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    .line 1192
    move-object v0, p0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->reverse(Ljava/util/List;)V

    return-object p0
.end method

.method public final set(Ljava/lang/Number;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "TE;)TE;"
        }
    .end annotation

    const-string v0, "index"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1389
    invoke-virtual {p1}, Ljava/lang/Number;->intValue()I

    move-result p1

    invoke-virtual {p0, p1, p2}, Lio/dcloud/uts/UTSArray;->set(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final setLength(Ljava/lang/Number;)V
    .locals 1

    const-string v0, "value"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 382
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->splice(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;

    return-void
.end method

.method public shift()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    .line 1200
    move-object v0, p0

    check-cast v0, Ljava/util/List;

    invoke-static {v0}, Lkotlin/collections/CollectionsKt;->removeFirstOrNull(Ljava/util/List;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final bridge size()I
    .locals 1

    .line 46
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getSize()I

    move-result v0

    return v0
.end method

.method public slice(Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "start"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "end"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1209
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 1210
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    invoke-static {p1, v1}, Lio/dcloud/uts/utils/IndexKt;->toSliceIndex(Ljava/lang/Number;I)I

    move-result p1

    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    invoke-static {p2, v1}, Lio/dcloud/uts/utils/IndexKt;->toSliceIndex(Ljava/lang/Number;I)I

    move-result p2

    :goto_0
    if-ge p1, p2, :cond_0

    .line 1211
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    :cond_0
    return-object v0
.end method

.method public some(Lkotlin/jvm/functions/Function1;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function1<",
            "-TE;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1223
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 1225
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {p1, v3}, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return v1
.end method

.method public some(Lkotlin/jvm/functions/Function2;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-",
            "Ljava/lang/Number;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1236
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 1238
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4}, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return v1
.end method

.method public some(Lkotlin/jvm/functions/Function3;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function3<",
            "-TE;-",
            "Ljava/lang/Number;",
            "-",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;",
            "Ljava/lang/Boolean;",
            ">;)Z"
        }
    .end annotation

    const-string v0, "callback"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1249
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v0, :cond_1

    .line 1251
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p1, v3, v4, p0}, Lkotlin/jvm/functions/Function3;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 p1, 0x1

    return p1

    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_1
    return v1
.end method

.method public sort()Lio/dcloud/uts/UTSArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    .line 397
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->getLength()Ljava/lang/Number;

    move-result-object v0

    const/4 v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {v0, v1}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v0

    if-gez v0, :cond_0

    return-object p0

    .line 402
    :cond_0
    move-object v0, p0

    check-cast v0, Ljava/util/List;

    new-instance v1, Lio/dcloud/uts/UTSArray$$ExternalSyntheticLambda1;

    invoke-direct {v1}, Lio/dcloud/uts/UTSArray$$ExternalSyntheticLambda1;-><init>()V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    return-object p0
.end method

.method public sort(Lkotlin/jvm/functions/Function2;)Lio/dcloud/uts/UTSArray;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lkotlin/jvm/functions/Function2<",
            "-TE;-TE;+",
            "Ljava/lang/Number;",
            ">;)",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "compareFn"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1275
    move-object v0, p0

    check-cast v0, Ljava/util/List;

    new-instance v1, Lio/dcloud/uts/UTSArray$$ExternalSyntheticLambda0;

    invoke-direct {v1, p1}, Lio/dcloud/uts/UTSArray$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function2;)V

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    return-object p0
.end method

.method public splice(Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "start"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1296
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 1297
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    invoke-static {p1, v1}, Lio/dcloud/uts/utils/IndexKt;->toSliceIndex(Ljava/lang/Number;I)I

    move-result p1

    .line 1298
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    move v2, p1

    :goto_0
    if-ge v2, v1, :cond_0

    .line 1299
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1301
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    if-le v1, p1, :cond_1

    .line 1302
    move-object v1, p0

    check-cast v1, Ljava/util/List;

    invoke-static {v1}, Lkotlin/collections/CollectionsKt;->removeLastOrNull(Ljava/util/List;)Ljava/lang/Object;

    goto :goto_1

    :cond_1
    return-object v0
.end method

.method public splice(Ljava/lang/Number;Ljava/lang/Number;)Lio/dcloud/uts/UTSArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            ")",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "start"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "deleteCount"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1309
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 1310
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    invoke-static {p1, v1}, Lio/dcloud/uts/utils/IndexKt;->toSliceIndex(Ljava/lang/Number;I)I

    move-result p1

    const/4 v1, 0x0

    .line 1311
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    check-cast v2, Ljava/lang/Number;

    invoke-static {p2, v2}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v2

    if-gez v2, :cond_0

    goto :goto_0

    .line 1313
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    sub-int/2addr v1, p1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {p2, v1}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v1

    if-lez v1, :cond_1

    .line 1314
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p2

    sub-int v1, p2, p1

    goto :goto_0

    .line 1316
    :cond_1
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result v1

    :goto_0
    add-int p2, v1, p1

    move v2, p1

    :goto_1
    if-ge v2, p2, :cond_2

    .line 1319
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_2
    :goto_2
    if-lez v1, :cond_3

    .line 1322
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->remove(I)Ljava/lang/Object;

    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    :cond_3
    return-object v0
.end method

.method public varargs splice(Ljava/lang/Number;Ljava/lang/Number;[Ljava/lang/Object;)Lio/dcloud/uts/UTSArray;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Number;",
            "Ljava/lang/Number;",
            "[TE;)",
            "Lio/dcloud/uts/UTSArray<",
            "TE;>;"
        }
    .end annotation

    const-string v0, "start"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "deleteCount"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "items"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1330
    new-instance v0, Lio/dcloud/uts/UTSArray;

    invoke-direct {v0}, Lio/dcloud/uts/UTSArray;-><init>()V

    .line 1331
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    invoke-static {p1, v1}, Lio/dcloud/uts/utils/IndexKt;->toSliceIndex(Ljava/lang/Number;I)I

    move-result p1

    const/4 v1, 0x0

    .line 1332
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    check-cast v2, Ljava/lang/Number;

    invoke-static {p2, v2}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v2

    if-gez v2, :cond_0

    goto :goto_0

    .line 1334
    :cond_0
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result v1

    sub-int/2addr v1, p1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    check-cast v1, Ljava/lang/Number;

    invoke-static {p2, v1}, Lio/dcloud/uts/NumberKt;->compareTo(Ljava/lang/Number;Ljava/lang/Number;)I

    move-result v1

    if-lez v1, :cond_1

    .line 1335
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p2

    sub-int v1, p2, p1

    goto :goto_0

    .line 1337
    :cond_1
    invoke-virtual {p2}, Ljava/lang/Number;->intValue()I

    move-result v1

    :goto_0
    add-int p2, v1, p1

    move v2, p1

    :goto_1
    if-ge v2, p2, :cond_2

    .line 1340
    invoke-virtual {p0, v2}, Lio/dcloud/uts/UTSArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Lio/dcloud/uts/UTSArray;->add(Ljava/lang/Object;)Z

    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_2
    :goto_2
    if-lez v1, :cond_3

    .line 1343
    invoke-virtual {p0, p1}, Lio/dcloud/uts/UTSArray;->remove(I)Ljava/lang/Object;

    add-int/lit8 v1, v1, -0x1

    goto :goto_2

    .line 1346
    :cond_3
    array-length p2, p3

    add-int/lit8 p2, p2, -0x1

    :goto_3
    const/4 v1, -0x1

    if-ge v1, p2, :cond_4

    .line 1347
    aget-object v1, p3, p2

    invoke-virtual {p0, p1, v1}, Lio/dcloud/uts/UTSArray;->add(ILjava/lang/Object;)V

    add-int/lit8 p2, p2, -0x1

    goto :goto_3

    :cond_4
    return-object v0
.end method

.method public final toKotlinList()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "TE;>;"
        }
    .end annotation

    .line 1261
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 1262
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const-string v2, "iterator(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 1263
    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1265
    :cond_0
    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .line 1367
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->iterator()Ljava/util/Iterator;

    move-result-object v0

    const-string v1, "iterator(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1368
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    const-string v2, ""

    if-nez v1, :cond_0

    return-object v2

    .line 1370
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1372
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_1

    .line 1374
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1376
    :cond_1
    instance-of v4, v3, Ljava/lang/Number;

    if-eqz v4, :cond_2

    .line 1377
    check-cast v3, Ljava/lang/Number;

    invoke-static {v3}, Lio/dcloud/uts/NumberKt;->toStringAsJS(Ljava/lang/Number;)Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 1379
    :cond_2
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1381
    :goto_1
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1383
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_3

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "toString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0

    :cond_3
    const/16 v3, 0x2c

    .line 1384
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_0
.end method

.method public varargs unshift([Ljava/lang/Object;)I
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TE;)I"
        }
    .end annotation

    const-string v0, "items"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1358
    invoke-static {p1}, Lkotlin/collections/ArraysKt;->toList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p1

    check-cast p1, Ljava/util/Collection;

    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lio/dcloud/uts/UTSArray;->addAll(ILjava/util/Collection;)Z

    .line 1359
    invoke-virtual {p0}, Lio/dcloud/uts/UTSArray;->size()I

    move-result p1

    return p1
.end method
