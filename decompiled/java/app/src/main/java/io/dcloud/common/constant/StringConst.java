package io.dcloud.common.constant;

import android.text.TextUtils;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.adapter.util.AndroidResources;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public final class StringConst extends AndroidResources implements AbsoluteConst {
    private static long sChangeTime;

    public static int getIntSF(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if ("barcode".equals(str)) {
            return 2;
        }
        if ("scheme".equals(str)) {
            return 3;
        }
        if (IApp.ConfigProperty.CONFIG_STREAM.equals(str)) {
            return 6;
        }
        if (IApp.ConfigProperty.CONFIG_SHORTCUT.equals(str)) {
            return 5;
        }
        if ("push".equals(str)) {
            return 4;
        }
        if ("myapp".equals(str)) {
            return 7;
        }
        if ("browser".equals(str)) {
            return 8;
        }
        if (str.indexOf("third:") == 0) {
            return 9;
        }
        if ("favorite".equals(str)) {
            return 10;
        }
        if ("engines".equals(str)) {
            return 11;
        }
        if ("apush".equals(str)) {
            return 40;
        }
        return "speech".equals(str) ? 30 : 1;
    }
}
