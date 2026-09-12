package com.dcloud.android.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class StatusBarView extends View {
    private int mStatusBarHeight;

    public StatusBarView(Context context) {
        super(context);
        this.mStatusBarHeight = 0;
    }

    public void setStatusBarHeight(int i) {
        this.mStatusBarHeight = i;
        setMeasuredDimension(-1, i);
        if (getLayoutParams() == null) {
            setLayoutParams(new ViewGroup.MarginLayoutParams(-1, this.mStatusBarHeight));
        }
    }
}
