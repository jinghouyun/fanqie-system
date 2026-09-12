package io.dcloud.common.util;

import android.content.Context;
import com.sample.breakpad.BreakpadInit;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class NativeCrashManager {
    public static void initNativeCrash(Context context) {
        try {
            File file = new File(context.getExternalCacheDir(), "dcCrashDump");
            if (!file.exists()) {
                file.mkdirs();
            }
            BreakpadInit.initBreakpad(file.getAbsolutePath());
        } catch (Exception unused) {
        }
    }
}
