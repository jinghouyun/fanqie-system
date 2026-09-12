package com.taobao.weex.ui.component.list;

import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface ListComponentView {
    WXRecyclerView getInnerView();

    RecyclerViewBaseAdapter getRecyclerViewBaseAdapter();

    void notifyStickyRemove(WXCell wXCell);

    void notifyStickyShow(WXCell wXCell);

    void setRecyclerViewBaseAdapter(RecyclerViewBaseAdapter recyclerViewBaseAdapter);

    void updateStickyView(int i);
}
