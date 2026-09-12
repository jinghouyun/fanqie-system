.class public interface abstract Lcom/dcloud/android/downloader/callback/DownloadListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# virtual methods
.method public abstract onDownloadFailed(Lcom/dcloud/android/downloader/domain/DownloadInfo;Lcom/dcloud/android/downloader/exception/DownloadException;)V
.end method

.method public abstract onDownloadSuccess(Lcom/dcloud/android/downloader/domain/DownloadInfo;)V
.end method

.method public abstract onDownloading(JJ)V
.end method

.method public abstract onPaused()V
.end method

.method public abstract onRemoved()V
.end method

.method public abstract onStart()V
.end method

.method public abstract onWaited()V
.end method
