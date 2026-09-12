package com.taobao.weex.ui.view.listview.adapter;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IOnLoadMoreListener {
    void notifyAppearStateChange(int i, int i2, int i3, int i4);

    void onBeforeScroll(int i, int i2);

    void onLoadMore(int i);
}
