package io.dcloud.feature.nativeObj.richtext.span;

import android.view.View;
import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface ClickSpanAble {
    String getHref();

    String getOnClickEvent();

    boolean hasClickEvent();

    void onClick(View view, IWebview iWebview);
}
