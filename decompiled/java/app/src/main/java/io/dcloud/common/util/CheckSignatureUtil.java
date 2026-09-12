package io.dcloud.common.util;

import android.text.TextUtils;
import io.dcloud.application.DCLoudApplicationImpl;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class CheckSignatureUtil {
    public static boolean check(String str) {
        String signature = getSignature(str);
        if (TextUtils.isEmpty(signature)) {
            return true;
        }
        String appSignatureMd5 = LoadAppUtils.getAppSignatureMd5(DCLoudApplicationImpl.self().getContext().getApplicationContext(), DCLoudApplicationImpl.self().getContext().getPackageName());
        return TextUtils.isEmpty(appSignatureMd5) || appSignatureMd5.equalsIgnoreCase(signature);
    }

    public static String getSignature(String str) {
        String[] apkFileSignatureAndPackageName = LoadAppUtils.getApkFileSignatureAndPackageName(DCLoudApplicationImpl.self().getContext().getApplicationContext(), str);
        return (apkFileSignatureAndPackageName == null || apkFileSignatureAndPackageName.length <= 0) ? "" : apkFileSignatureAndPackageName[0];
    }
}
