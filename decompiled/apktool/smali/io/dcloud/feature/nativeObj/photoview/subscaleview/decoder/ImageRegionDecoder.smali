.class public interface abstract Lio/dcloud/feature/nativeObj/photoview/subscaleview/decoder/ImageRegionDecoder;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# virtual methods
.method public abstract decodeRegion(Landroid/graphics/Rect;I)Landroid/graphics/Bitmap;
.end method

.method public abstract init(Landroid/content/Context;Landroid/net/Uri;)Landroid/graphics/Point;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method public abstract isReady()Z
.end method

.method public abstract recycle()V
.end method
