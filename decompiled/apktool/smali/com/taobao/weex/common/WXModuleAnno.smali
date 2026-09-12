.class public interface abstract annotation Lcom/taobao/weex/common/WXModuleAnno;
.super Ljava/lang/Object;
.source "r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4"

# interfaces
.implements Ljava/lang/annotation/Annotation;


# annotations
.annotation system Ldalvik/annotation/AnnotationDefault;
    value = .subannotation Lcom/taobao/weex/common/WXModuleAnno;
        moduleMethod = true
        runOnUIThread = true
    .end subannotation
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation

.annotation runtime Ljava/lang/annotation/Inherited;
.end annotation

.annotation runtime Ljava/lang/annotation/Retention;
    value = .enum Ljava/lang/annotation/RetentionPolicy;->RUNTIME:Ljava/lang/annotation/RetentionPolicy;
.end annotation


# virtual methods
.method public abstract moduleMethod()Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract runOnUIThread()Z
.end method
