package com.taobao.weex.ui.view.refresh.wrapper;

import android.content.Context;
import com.taobao.weex.ui.component.WXBaseScroller;
import com.taobao.weex.ui.view.WXScrollView;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class BounceScrollerView extends BaseBounceView<WXScrollView> {
    public BounceScrollerView(Context context, int i, WXBaseScroller wXBaseScroller) {
        super(context, i);
        init(context);
        if (getInnerView() != null) {
            getInnerView().setWAScroller(wXBaseScroller);
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public WXScrollView setInnerView(Context context) {
        return new WXScrollView(context);
    }
}
