package com.taobao.weex.ui.component;

import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface Scrollable {
    void bindAppearEvent(WXComponent wXComponent);

    void bindDisappearEvent(WXComponent wXComponent);

    void bindStickStyle(WXComponent wXComponent);

    int getOrientation();

    String getRef();

    int getScrollX();

    int getScrollY();

    ViewGroup getView();

    boolean isScrollable();

    void scrollTo(WXComponent wXComponent, Map<String, Object> map);

    void unbindAppearEvent(WXComponent wXComponent);

    void unbindDisappearEvent(WXComponent wXComponent);

    void unbindStickStyle(WXComponent wXComponent);
}
