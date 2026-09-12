.class public interface abstract Landroidtranscoder/MediaTranscoder$Listener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidtranscoder/MediaTranscoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract onTranscodeCanceled()V
.end method

.method public abstract onTranscodeCompleted()V
.end method

.method public abstract onTranscodeFailed(Ljava/lang/Exception;)V
.end method

.method public abstract onTranscodeProgress(D)V
.end method
