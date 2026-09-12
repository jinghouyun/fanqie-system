package com.taobao.weex.ui.component;

import android.view.ViewGroup;
import com.taobao.weex.WXSDKInstance;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface NestedContainer {

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface OnNestedInstanceEventListener {
        void onCreated(NestedContainer nestedContainer, WXSDKInstance wXSDKInstance);

        void onException(NestedContainer nestedContainer, String str, String str2);

        boolean onPreCreate(NestedContainer nestedContainer, String str);

        String transformUrl(String str);
    }

    ViewGroup getViewContainer();

    void reload();

    void renderNewURL(String str);

    void setOnNestEventListener(OnNestedInstanceEventListener onNestedInstanceEventListener);
}
