package io.dcloud.p;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import com.taobao.weex.WXEnvironment;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p4 {
    public static int a(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            }
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", WXEnvironment.OS);
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
