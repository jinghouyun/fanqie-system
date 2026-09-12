package io.dcloud.feature.weex_scroller.helper;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class DCScrollStartEndHelper {
    public static boolean isScrollEvent(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "scroll":
            case "scrollend":
            case "scrolltolower":
            case "scrolltoupper":
            case "scrollstart":
                return true;
            default:
                return false;
        }
    }
}
