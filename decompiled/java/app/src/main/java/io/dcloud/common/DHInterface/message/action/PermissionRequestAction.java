package io.dcloud.common.DHInterface.message.action;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class PermissionRequestAction implements IAction {
    public static String TYPE_COMPLETE = "complete";
    public static String TYPE_CONFIRM = "confirm";
    public static String TYPE_REQUEST = "request";
    private String[] permissions;
    private final String type;

    private PermissionRequestAction(String str, String[] strArr) {
        this.type = str;
        this.permissions = strArr;
    }

    public static PermissionRequestAction obtain(String str, String[] strArr) {
        return new PermissionRequestAction(str, strArr);
    }

    public String[] getPermissions() {
        return this.permissions;
    }

    public String getType() {
        return this.type;
    }
}
