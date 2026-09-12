package io.dcloud.sdk.core.v3.cp;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface DCContentPageVideoListener {
    void onComplete(DCContentPage.ContentPageItem contentPageItem);

    void onError(DCContentPage.ContentPageItem contentPageItem);

    void onPause(DCContentPage.ContentPageItem contentPageItem);

    void onResume(DCContentPage.ContentPageItem contentPageItem);

    void onStart(DCContentPage.ContentPageItem contentPageItem);
}
