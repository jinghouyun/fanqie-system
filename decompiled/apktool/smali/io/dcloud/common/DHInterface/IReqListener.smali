.class public interface abstract Lio/dcloud/common/DHInterface/IReqListener;
.super Ljava/lang/Object;
.source "r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/dcloud/common/DHInterface/IReqListener$NetState;
    }
.end annotation


# virtual methods
.method public abstract onNetStateChanged(Lio/dcloud/common/DHInterface/IReqListener$NetState;Z)V
.end method

.method public abstract onReceiving(Ljava/io/InputStream;)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation
.end method

.method public abstract onResponsing(Ljava/io/InputStream;)V
.end method
