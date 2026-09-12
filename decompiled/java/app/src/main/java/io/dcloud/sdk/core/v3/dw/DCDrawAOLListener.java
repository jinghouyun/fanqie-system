package io.dcloud.sdk.core.v3.dw;

import io.dcloud.sdk.core.v3.fd.DCFeedAOLListener;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface DCDrawAOLListener extends DCFeedAOLListener {
    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onClick();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onClosed(String str);

    void onEnd();

    void onPause();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onRenderFail();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onRenderSuccess();

    void onResume();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onShow();

    @Override // io.dcloud.sdk.core.v3.fd.DCFeedAOLListener
    void onShowError();

    void onStart();
}
