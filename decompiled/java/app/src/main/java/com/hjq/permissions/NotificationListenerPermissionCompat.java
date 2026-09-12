package com.hjq.permissions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class NotificationListenerPermissionCompat {
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    NotificationListenerPermissionCompat() {
    }

    static boolean isGrantedPermission(Context context) {
        if (!AndroidVersion.isAndroid4_3()) {
            return true;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        for (String str : string.split(":")) {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null && TextUtils.equals(componentNameUnflattenFromString.getPackageName(), context.getPackageName())) {
                try {
                    Class.forName(componentNameUnflattenFromString.getClassName());
                    return true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    static Intent getPermissionIntent(Context context) {
        Intent intent;
        AndroidManifestInfo.ServiceInfo serviceInfo;
        Intent intent2 = null;
        if (AndroidVersion.isAndroid11()) {
            AndroidManifestInfo androidManifestInfo = PermissionUtils.getAndroidManifestInfo(context);
            if (androidManifestInfo == null) {
                serviceInfo = null;
                break;
            }
            serviceInfo = null;
            for (AndroidManifestInfo.ServiceInfo serviceInfo2 : androidManifestInfo.serviceInfoList) {
                if (TextUtils.equals(serviceInfo2.permission, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
                    if (serviceInfo != null) {
                        serviceInfo = null;
                        break;
                    }
                    serviceInfo = serviceInfo2;
                }
            }
            if (serviceInfo != null) {
                Intent intent3 = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
                intent3.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", new ComponentName(context, serviceInfo.name).flattenToString());
                if (PermissionUtils.areActivityIntent(context, intent3)) {
                    intent2 = intent3;
                }
            }
        }
        if (intent2 == null) {
            if (AndroidVersion.isAndroid5_1()) {
                intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            } else {
                intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            }
            intent2 = intent;
        }
        return !PermissionUtils.areActivityIntent(context, intent2) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intent2;
    }
}
