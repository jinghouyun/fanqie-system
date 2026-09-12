package io.dcloud.common.DHInterface;

import android.view.ViewGroup;
import io.dcloud.common.adapter.ui.AdaFrameItem;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IContainerView {
    void addFrameItem(AdaFrameItem adaFrameItem);

    void addFrameItem(AdaFrameItem adaFrameItem, ViewGroup.LayoutParams layoutParams);

    void removeAllFrameItem();

    void removeFrameItem(AdaFrameItem adaFrameItem);
}
