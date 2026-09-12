package io.dcloud.p;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s0 {
    private static boolean a = false;

    public static w4 a(v2.c cVar, Context context, String str, String str2, String str3, String str4) {
        a(context);
        return new w4(cVar, context, str, str2, str3, str4);
    }

    private static void a(Context context) {
        File[] fileArrListFiles;
        if (a) {
            return;
        }
        a = true;
        if (context != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
                File file = new File(context.getCacheDir().getAbsolutePath() + "/dcloud_ad/img/");
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.lastModified() < jCurrentTimeMillis) {
                        file2.delete();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
