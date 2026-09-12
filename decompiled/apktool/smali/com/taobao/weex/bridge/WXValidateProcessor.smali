.class public interface abstract Lcom/taobao/weex/bridge/WXValidateProcessor;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/taobao/weex/bridge/WXValidateProcessor$WXModuleValidateResult;,
        Lcom/taobao/weex/bridge/WXValidateProcessor$WXComponentValidateResult;
    }
.end annotation


# virtual methods
.method public abstract needValidate(Ljava/lang/String;)Z
.end method

.method public abstract onComponentValidate(Lcom/taobao/weex/WXSDKInstance;Ljava/lang/String;Lcom/taobao/weex/ui/component/WXComponent;)Lcom/taobao/weex/bridge/WXValidateProcessor$WXComponentValidateResult;
.end method

.method public abstract onModuleValidate(Lcom/taobao/weex/WXSDKInstance;Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONArray;Lcom/alibaba/fastjson/JSONObject;)Lcom/taobao/weex/bridge/WXValidateProcessor$WXModuleValidateResult;
.end method
