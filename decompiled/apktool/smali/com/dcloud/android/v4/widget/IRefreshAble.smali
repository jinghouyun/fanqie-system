.class public interface abstract Lcom/dcloud/android/v4/widget/IRefreshAble;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/dcloud/android/v4/widget/IRefreshAble$OnRefreshListener;
    }
.end annotation


# virtual methods
.method public abstract beginRefresh()V
.end method

.method public abstract endRefresh()V
.end method

.method public abstract hasRefreshOperator()Z
.end method

.method public abstract isRefreshEnable()Z
.end method

.method public abstract isRefreshing()Z
.end method

.method public abstract onInit(Landroid/view/ViewGroup;Landroid/view/View;Lcom/dcloud/android/v4/widget/IRefreshAble$OnRefreshListener;)V
.end method

.method public abstract onResize(IIF)V
.end method

.method public abstract onSelfDraw(Landroid/graphics/Canvas;)V
.end method

.method public abstract onSelfTouchEvent(Landroid/view/MotionEvent;)Z
.end method

.method public abstract parseData(Lorg/json/JSONObject;IIF)V
.end method

.method public abstract setRefreshEnable(Z)V
.end method
