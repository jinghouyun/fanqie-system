.class public interface abstract Lio/dcloud/sdk/core/interfaces/AOLLoader$VideoAdListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/sdk/core/interfaces/AOLLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "VideoAdListener"
.end annotation


# virtual methods
.method public abstract onProgressUpdate(JJ)V
.end method

.method public abstract onVideoAdComplete()V
.end method

.method public abstract onVideoAdPaused()V
.end method

.method public abstract onVideoAdResume()V
.end method

.method public abstract onVideoAdStartPlay()V
.end method

.method public abstract onVideoError(ILjava/lang/String;)V
.end method

.method public abstract onVideoLoad()V
.end method
