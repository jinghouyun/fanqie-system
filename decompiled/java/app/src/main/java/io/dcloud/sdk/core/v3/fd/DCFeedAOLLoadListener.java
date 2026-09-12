package io.dcloud.sdk.core.v3.fd;

import io.dcloud.sdk.core.v3.base.DCBaseAOLLoadListener;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface DCFeedAOLLoadListener extends DCBaseAOLLoadListener {
    void onFeedAOLLoad(List<DCFeedAOL> list);
}
