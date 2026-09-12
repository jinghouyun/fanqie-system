package com.taobao.weex.common;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface WXModuleAnno {
    @Deprecated
    boolean moduleMethod() default true;

    boolean runOnUIThread() default true;
}
