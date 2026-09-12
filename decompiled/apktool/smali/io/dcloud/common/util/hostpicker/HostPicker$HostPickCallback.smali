.class public interface abstract Lio/dcloud/common/util/hostpicker/HostPicker$HostPickCallback;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/dcloud/common/util/hostpicker/HostPicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "HostPickCallback"
.end annotation


# virtual methods
.method public abstract doRequest(Lio/dcloud/common/util/hostpicker/HostPicker$Host;)Z
.end method

.method public abstract onNoOnePicked()V
.end method

.method public abstract onOneSelected(Lio/dcloud/common/util/hostpicker/HostPicker$Host;)V
.end method
