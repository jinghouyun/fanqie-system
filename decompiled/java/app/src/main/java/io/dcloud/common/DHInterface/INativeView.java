package io.dcloud.common.DHInterface;

import android.view.View;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface INativeView {
    void attachToViewGroup(IFrameView iFrameView);

    int getInnerHeight();

    String getStyleBackgroundColor();

    int getStyleLeft();

    int getStyleWidth();

    String getViewId();

    String getViewType();

    String getViewUUId();

    boolean isAnimate();

    boolean isDock();

    boolean isDockTop();

    boolean isStatusBar();

    View obtanMainView();

    void setNativeShowType(boolean z);

    void setStyleBackgroundColor(int i);

    void setStyleBackgroundColor(String str);

    void setStyleLeft(int i);

    void setWebAnimationRuning(boolean z);

    JSONObject toJSON();
}
