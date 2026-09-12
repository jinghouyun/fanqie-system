.class public final synthetic Lio/dcloud/uts/component/IUTSComWrap$-CC;
.super Ljava/lang/Object;
.source "IUTSComWrap.kt"


# direct methods
.method public static $default$wrapComponentHostView(Lio/dcloud/uts/component/IUTSComWrap;Landroid/view/View;Lcom/taobao/weex/ui/component/WXComponent;)V
    .locals 1
    .param p0, "_this"    # Lio/dcloud/uts/component/IUTSComWrap;

    .line 0
    const-string v0, "rootView"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string p1, "hostCom"

    invoke-static {p2, p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic access$wrapComponentHostView$jd(Lio/dcloud/uts/component/IUTSComWrap;Landroid/view/View;Lcom/taobao/weex/ui/component/WXComponent;)V
    .locals 0

    .line 9
    invoke-static {p0, p1, p2}, Lio/dcloud/uts/component/IUTSComWrap$-CC;->$default$wrapComponentHostView(Lio/dcloud/uts/component/IUTSComWrap;Landroid/view/View;Lcom/taobao/weex/ui/component/WXComponent;)V

    return-void
.end method
