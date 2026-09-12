package io.dcloud.sdk.core.interfaces;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.dcloud.sdk.core.DCloudAOLManager;
import io.dcloud.sdk.core.entry.DCRetryRewardEntry;
import io.dcloud.sdk.core.v3.cp.DCContentPage;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface AOLLoader {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface AdImage {
        int getHeight();

        String getUrl();

        int getWidth();

        boolean isValid();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface AdVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface AppDownloadListener {
        void onDownloadActive(long j, long j2, String str, String str2);

        void onDownloadFailed(long j, long j2, String str, String str2);

        void onDownloadFinished(long j, String str, String str2);

        void onDownloadPaused(long j, long j2, String str, String str2);

        void onIdle();

        void onInstalled(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface AppInfo {
        String getApkSize();

        String getAppDownloadCount();

        String getAppName();

        String getAppPackageName();

        String getAppScore();

        String getAppVersion();

        String getDeveloperName();

        String getFunctionDescUrl();

        String getPermissionInfoUrl();

        String getPrivacyUrl();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface ContentPageVideoListener extends VAOLInteractionListener {
        void onComplete(DCContentPage.ContentPageItem contentPageItem);

        void onError(DCContentPage.ContentPageItem contentPageItem);

        void onPause(DCContentPage.ContentPageItem contentPageItem);

        void onResume(DCContentPage.ContentPageItem contentPageItem);

        void onStart(DCContentPage.ContentPageItem contentPageItem);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface DrawAOLInteractionListener extends FeedAOLInteractionListener {
        void onEnd();

        void onError();

        void onPause();

        void onResume();

        void onStart();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface FeedAOLInteractionListener {
        void onClicked();

        void onClosed(String str);

        void onPaidGet(long j, String str, int i);

        void onRenderFail();

        void onRenderSuccess();

        void onShow();

        void onShowError();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface GetConvertResultListener {
        void onError(int i, String str);

        void onSuccess(DCRetryRewardEntry dCRetryRewardEntry, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface NativeAOLInteractionListener extends NativeAOLListener {
        void destroy();

        Bitmap getAdLogo();

        AppInfo getAppInfo();

        String getButtonText();

        String getDescription();

        String getIconUrl();

        List<AdImage> getImageList();

        int getInteractionType();

        int getMaterialType();

        String getSource();

        String getTitle();

        double getVideoDuration();

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        View getVideoView(Activity activity);

        boolean isExpressAd();

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        void setAppDownloadListener(AppDownloadListener appDownloadListener);

        @Override // io.dcloud.sdk.core.interfaces.AOLLoader.NativeAOLListener
        void setVideoAdListener(VideoAdListener videoAdListener);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface NativeAOLListener {
        void dislike(Activity activity);

        View getVideoView(Activity activity);

        void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3);

        void setAppDownloadListener(AppDownloadListener appDownloadListener);

        void setVideoAdListener(VideoAdListener videoAdListener);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface RequestConvertResultListener {
        void onError(int i, String str);

        void onSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface RewVAOLInteractionListener extends VAOLInteractionListener {
        void onReward(JSONObject jSONObject);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface SplashAOLLoadListener {
        void onError(int i, String str);

        void redBag(View view, FrameLayout.LayoutParams layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface VAOLInteractionListener {
        void onClick();

        void onClose();

        void onPaidGet(long j, String str, int i);

        void onShow();

        void onShowError(int i, String str);

        void onSkip();

        void onVideoPlayEnd();
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdPaused();

        void onVideoAdResume();

        void onVideoAdStartPlay();

        void onVideoError(int i, String str);

        void onVideoLoad();
    }

    boolean getPersonalAOL(Context context);

    void setPersonalAOL(Context context, boolean z);

    void setPrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig);

    void updatePrivacyConfig(Context context, JSONObject jSONObject);
}
