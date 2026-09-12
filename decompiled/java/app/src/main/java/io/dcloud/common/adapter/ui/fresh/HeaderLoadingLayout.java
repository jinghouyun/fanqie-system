package io.dcloud.common.adapter.ui.fresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    private static final int ROTATE_ANIM_DURATION = 150;

    public HeaderLoadingLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected View createLoadingView(Context context, AttributeSet attributeSet) {
        return new TextView(context);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout, io.dcloud.common.adapter.ui.fresh.ILoadingLayout
    public int getContentSize() {
        return (int) (getResources().getDisplayMetrics().density * 100.0f);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onPullToRefresh() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onRefreshing() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onReleaseToRefresh() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onReset() {
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    protected void onStateChanged(ILoadingLayout.State state, ILoadingLayout.State state2) {
        super.onStateChanged(state, state2);
    }

    @Override // io.dcloud.common.adapter.ui.fresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }
}
