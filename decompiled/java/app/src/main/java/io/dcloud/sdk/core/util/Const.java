package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class Const {
    public static final int AD_CLICK = 41;
    public static final int AD_DL_COMPLETE = 30;
    public static final int AD_DL_FAILED = 32;
    public static final int AD_DL_START = 29;
    public static final int AD_INSTALL = 31;
    public static final int AD_REQUEST_FAIL = 0;
    public static final int AD_REQUEST_ING = -1;
    public static final int AD_REQUEST_SUCCESS = 1;
    public static final int AD_SHOW = 40;
    public static final String DC_ADN = "dc_adn";
    public static final String DC_FEED_ADN = "dc_feed_adn";
    public static final String DC_VIDEO_ADN = "dc_video_adn";
    public static final String PROVIDER_TYPE_CHINA = "china";
    public static final String PROVIDER_TYPE_GLOBAL = "global";
    public static final int PULL_TYPE_B2F_SPLASH = 3;
    public static final int PULL_TYPE_OTHERS = 2;
    public static final int PULL_TYPE_SPLASH = 1;
    public static final String TYPE_BD = "bd";
    public static final String TYPE_CSJ = "csj";
    public static final String TYPE_GDT = "gdt";
    public static final String TYPE_GG = "gg";
    public static final String TYPE_GM = "gm";
    public static final String TYPE_HW = "hw";
    public static final String TYPE_KS = "ks";
    public static final String TYPE_PG = "pg";
    public static final String TYPE_SGM = "sgm";
    public static final String TYPE_WM = "wm";

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class AdType {
        public static final int TYPE_CONTENT = 14;
        public static final int TYPE_DRAMA = 11;
        public static final int TYPE_DRAW = 10;
        public static final int TYPE_FLOW = 4;
        public static final int TYPE_FULLSCREEN = 7;
        public static final int TYPE_INTERSTITIAL = 15;
        public static final int TYPE_NATIVE = 4;
        public static final int TYPE_NONE = -1;
        public static final int TYPE_PRE_VIDEO = 5;
        public static final int TYPE_REWARD = 9;
        public static final int TYPE_SPLASH = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class BidType {
        public static final int BID_CLIENT = 1;
        public static final int BID_NONE = 0;
        public static final int BID_SERVER = 2;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public @interface CustomAdType {
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public @interface CustomBidType {
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class FeedAdType {
        public static final int FEED_LARGE_TOP_ICON = 2;
        public static final int FEED_SMALL_RIGHT_ICON = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class InteractionType {
        public static final int INTERACTION_BROWSER = 2;
        public static final int INTERACTION_DOWNLOAD = 1;
        public static final int INTERACTION_UNKNOW = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class MaterialType {
        public static final int MATERIAL_GROUP_IMAGES = 3;
        public static final int MATERIAL_SINGLE_IMAGE = 2;
        public static final int MATERIAL_UNKNOW = 0;
        public static final int MATERIAL_VIDEO = 1;
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class PrivacyType {
        public static final String IS_ADULT = "is_adult";
        public static final String IS_CAN_GET_ANDROID_ID = "is_can_get_android_id";
        public static final String IS_CAN_GET_INSTALL_APP_LIST = "is_can_get_install_app_list";
        public static final String IS_CAN_GET_MAC = "is_can_get_mac";
        public static final String IS_CAN_GET_RUNNING_APPS = "is_can_get_running_apps";
        public static final String IS_CAN_USE_LOCATION = "is_can_use_location";
        public static final String IS_CAN_USE_PHONE_STATE = "is_can_use_phone_state";
        public static final String IS_CAN_USE_STORAGE = "is_can_use_storage";
        public static final String IS_CAN_USE_WIFI_STATE = "is_can_use_wifi_state";
    }
}
