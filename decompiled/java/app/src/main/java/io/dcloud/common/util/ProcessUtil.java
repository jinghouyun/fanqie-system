package io.dcloud.common.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ProcessUtil {
    private static String currentProcessName;

    public static String getCurrentProcessName(Context context) {
        if (!TextUtils.isEmpty(currentProcessName)) {
            return currentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        currentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return currentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        currentProcessName = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return currentProcessName;
        }
        String currentProcessNameByCmdline = getCurrentProcessNameByCmdline();
        currentProcessName = currentProcessNameByCmdline;
        if (!TextUtils.isEmpty(currentProcessNameByCmdline)) {
            return currentProcessName;
        }
        String packageName = context.getPackageName();
        currentProcessName = packageName;
        return packageName;
    }

    public static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String getCurrentProcessNameByCmdline() {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i = 0;
                    while (true) {
                        int i2 = fileInputStream.read();
                        if (i2 <= 0 || i >= 256) {
                            break;
                        }
                        bArr[i] = (byte) i2;
                        i++;
                    }
                    if (i > 0) {
                        String str = new String(bArr, 0, i, "UTF-8");
                        try {
                            fileInputStream.close();
                            return str;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return str;
                        }
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return null;
    }
}
