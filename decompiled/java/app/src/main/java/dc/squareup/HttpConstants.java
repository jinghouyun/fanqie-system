package dc.squareup;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class HttpConstants {
    private static String defaultUAConstants = "";

    public static String getDefaultUA() {
        return defaultUAConstants;
    }

    public static void setUA(String str) {
        defaultUAConstants = str;
    }
}
