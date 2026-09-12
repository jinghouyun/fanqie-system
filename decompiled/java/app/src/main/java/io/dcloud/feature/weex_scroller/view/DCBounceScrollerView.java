package io.dcloud.feature.weex_scroller.view;

import android.content.Context;
import com.taobao.weex.ui.component.DCWXScroller;
import com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCBounceScrollerView extends BaseBounceView<DCWXScrollView> {
    public DCBounceScrollerView(Context context, int i, DCWXScroller dCWXScroller) {
        super(context, i);
        init(context);
        if (getInnerView() != null) {
            getInnerView().setWAScroller(dCWXScroller);
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public DCWXScrollView setInnerView(Context context) {
        return new DCWXScrollView(context);
    }
}
