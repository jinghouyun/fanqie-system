.class public interface abstract Lcom/taobao/weex/appfram/storage/IWXStorageAdapter;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;
    }
.end annotation


# virtual methods
.method public abstract close()V
.end method

.method public abstract getAllKeys(Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method

.method public abstract getItem(Ljava/lang/String;Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method

.method public abstract length(Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method

.method public abstract removeItem(Ljava/lang/String;Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method

.method public abstract setItem(Ljava/lang/String;Ljava/lang/String;Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method

.method public abstract setItemPersistent(Ljava/lang/String;Ljava/lang/String;Lcom/taobao/weex/appfram/storage/IWXStorageAdapter$OnResultReceivedListener;)V
.end method
