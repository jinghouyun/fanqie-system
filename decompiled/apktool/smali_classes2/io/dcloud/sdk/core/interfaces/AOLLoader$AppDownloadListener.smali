.class public interface abstract Lio/dcloud/sdk/core/interfaces/AOLLoader$AppDownloadListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/sdk/core/interfaces/AOLLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AppDownloadListener"
.end annotation


# virtual methods
.method public abstract onDownloadActive(JJLjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onDownloadFailed(JJLjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onDownloadFinished(JLjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onDownloadPaused(JJLjava/lang/String;Ljava/lang/String;)V
.end method

.method public abstract onIdle()V
.end method

.method public abstract onInstalled(Ljava/lang/String;Ljava/lang/String;)V
.end method
