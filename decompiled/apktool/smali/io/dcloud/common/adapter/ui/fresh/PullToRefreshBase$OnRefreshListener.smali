.class public interface abstract Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase$OnRefreshListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "OnRefreshListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<V:",
        "Landroid/view/View;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract onPullDownToRefresh(Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase<",
            "TV;>;)V"
        }
    .end annotation
.end method

.method public abstract onPullUpToRefresh(Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lio/dcloud/common/adapter/ui/fresh/PullToRefreshBase<",
            "TV;>;)V"
        }
    .end annotation
.end method
