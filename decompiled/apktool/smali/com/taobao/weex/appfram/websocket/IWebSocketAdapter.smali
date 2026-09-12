.class public interface abstract Lcom/taobao/weex/appfram/websocket/IWebSocketAdapter;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/taobao/weex/appfram/websocket/IWebSocketAdapter$EventListener;
    }
.end annotation


# static fields
.field public static final HEADER_SEC_WEBSOCKET_PROTOCOL:Ljava/lang/String; = "Sec-WebSocket-Protocol"


# virtual methods
.method public abstract close(ILjava/lang/String;)V
.end method

.method public abstract connect(Ljava/lang/String;Ljava/lang/String;Lcom/taobao/weex/appfram/websocket/IWebSocketAdapter$EventListener;)V
.end method

.method public abstract connect(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/taobao/weex/appfram/websocket/IWebSocketAdapter$EventListener;)V
.end method

.method public abstract destroy()V
.end method

.method public abstract send(Ljava/lang/String;)V
.end method
