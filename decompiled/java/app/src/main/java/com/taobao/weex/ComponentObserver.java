package com.taobao.weex;

import android.view.View;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface ComponentObserver {
    void onCreate(WXComponent wXComponent);

    void onPreDestory(WXComponent wXComponent);

    void onViewCreated(WXComponent wXComponent, View view);
}
