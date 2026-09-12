.class public Lcom/taobao/weex/ui/view/WXHorizontalScrollView;
.super Landroid/widget/HorizontalScrollView;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Lcom/taobao/weex/ui/view/IWXScroller;
.implements Lcom/taobao/weex/ui/view/gesture/WXGestureObservable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;
    }
.end annotation


# instance fields
.field private mScrollViewListener:Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;

.field private mScrollViewListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;",
            ">;"
        }
    .end annotation
.end field

.field private scrollable:Z

.field private wxGesture:Lcom/taobao/weex/ui/view/gesture/WXGesture;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;)V

    const/4 p1, 0x1

    .line 2
    iput-boolean p1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->scrollable:Z

    .line 6
    invoke-direct {p0}, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->init()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .line 7
    invoke-direct {p0, p1, p2}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    const/4 p1, 0x1

    .line 8
    iput-boolean p1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->scrollable:Z

    .line 22
    invoke-direct {p0}, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->init()V

    return-void
.end method

.method private init()V
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->setWillNotDraw(Z)V

    const/4 v0, 0x2

    .line 2
    invoke-virtual {p0, v0}, Landroid/widget/HorizontalScrollView;->setOverScrollMode(I)V

    return-void
.end method


# virtual methods
.method public addScrollViewListener(Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    if-nez v0, :cond_0

    .line 2
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    .line 4
    :cond_0
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 5
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    return-void
.end method

.method public destroy()V
    .locals 0

    return-void
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2

    .line 1
    invoke-super {p0, p1}, Landroid/widget/HorizontalScrollView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 2
    iget-object v1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->wxGesture:Lcom/taobao/weex/ui/view/gesture/WXGesture;

    if-eqz v1, :cond_0

    .line 3
    invoke-virtual {v1, p0, p1}, Lcom/taobao/weex/ui/view/gesture/WXGesture;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z

    move-result p1

    or-int/2addr p1, v0

    return p1

    :cond_0
    return v0
.end method

.method public getContentFrame()Landroid/graphics/Rect;
    .locals 4

    .line 1
    new-instance v0, Landroid/graphics/Rect;

    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->computeHorizontalScrollRange()I

    move-result v1

    invoke-virtual {p0}, Landroid/widget/HorizontalScrollView;->computeVerticalScrollRange()I

    move-result v2

    const/4 v3, 0x0

    invoke-direct {v0, v3, v3, v1, v2}, Landroid/graphics/Rect;-><init>(IIII)V

    return-object v0
.end method

.method public getGestureListener()Lcom/taobao/weex/ui/view/gesture/WXGesture;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->wxGesture:Lcom/taobao/weex/ui/view/gesture/WXGesture;

    return-object v0
.end method

.method public isScrollable()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->scrollable:Z

    return v0
.end method

.method protected onScrollChanged(IIII)V
    .locals 7

    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/HorizontalScrollView;->onScrollChanged(IIII)V

    .line 2
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListener:Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;

    move-object v1, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    if-eqz v0, :cond_0

    .line 3
    invoke-interface/range {v0 .. v5}, Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;->onScrollChanged(Lcom/taobao/weex/ui/view/WXHorizontalScrollView;IIII)V

    .line 5
    :cond_0
    iget-object p1, v1, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    if-eqz p1, :cond_1

    .line 6
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result p2

    if-eqz p2, :cond_1

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;

    move v6, v5

    move v5, v4

    move v4, v3

    move v3, v2

    move-object v2, v1

    move-object v1, p2

    .line 7
    invoke-interface/range {v1 .. v6}, Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;->onScrollChanged(Lcom/taobao/weex/ui/view/WXHorizontalScrollView;IIII)V

    move v2, v3

    move v3, v4

    move v4, v5

    move-object v1, p0

    move v5, v6

    goto :goto_0

    :cond_1
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->scrollable:Z

    if-nez v0, :cond_0

    const/4 p1, 0x1

    return p1

    .line 4
    :cond_0
    invoke-super {p0, p1}, Landroid/widget/HorizontalScrollView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public registerGestureListener(Lcom/taobao/weex/ui/view/gesture/WXGesture;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->wxGesture:Lcom/taobao/weex/ui/view/gesture/WXGesture;

    return-void
.end method

.method public removeScrollViewListener(Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    return-void
.end method

.method public setScrollViewListener(Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->mScrollViewListener:Lcom/taobao/weex/ui/view/WXHorizontalScrollView$ScrollViewListener;

    return-void
.end method

.method public setScrollable(Z)V
    .locals 0

    .line 1
    iput-boolean p1, p0, Lcom/taobao/weex/ui/view/WXHorizontalScrollView;->scrollable:Z

    return-void
.end method
