package com.dcloud.android.v4.widget;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IRefreshAble {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface OnRefreshListener {
        public static final int STATE_REFRESHING = 3;

        void onRefresh(int i);
    }

    void beginRefresh();

    void endRefresh();

    boolean hasRefreshOperator();

    boolean isRefreshEnable();

    boolean isRefreshing();

    void onInit(ViewGroup viewGroup, View view, OnRefreshListener onRefreshListener);

    void onResize(int i, int i2, float f);

    void onSelfDraw(Canvas canvas);

    boolean onSelfTouchEvent(MotionEvent motionEvent);

    void parseData(JSONObject jSONObject, int i, int i2, float f);

    void setRefreshEnable(boolean z);
}
