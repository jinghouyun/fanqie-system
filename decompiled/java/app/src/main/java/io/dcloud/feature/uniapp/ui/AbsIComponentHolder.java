package io.dcloud.feature.uniapp.ui;

import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.JavascriptInvokable;
import com.taobao.weex.ui.ComponentCreator;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public interface AbsIComponentHolder extends ComponentCreator, JavascriptInvokable {
    Invoker getPropertyInvoker(String str);

    void loadIfNonLazy();
}
