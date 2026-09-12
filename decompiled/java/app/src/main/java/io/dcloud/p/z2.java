package io.dcloud.p;

import android.util.Log;
import io.dcloud.common.adapter.util.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z2 extends Logger {
    private static String a;
    private static File b;
    private static Boolean c = Boolean.TRUE;

    private static void WriteLogToSDcard(String str, String str2, String str3) throws Throwable {
        FileOutputStream fileOutputStream;
        String strGenerateLog = Logger.generateLog(str, str2, str3);
        if (b == null || strGenerateLog == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(b, true);
                    try {
                        fileOutputStream.write(strGenerateLog.getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public static void a(String str) {
        if (c.booleanValue()) {
            a = str;
            storeLogToSDcard();
            c = Boolean.FALSE;
        }
    }

    public static void d(String str, String str2) throws Throwable {
        Log.d(str, str2);
        WriteLogToSDcard(Logger.D, str, str2);
    }

    public static void e(String str, String str2) throws Throwable {
        Log.e(str, str2);
        WriteLogToSDcard(Logger.E, str, str2);
    }

    public static void i(String str, String str2) throws Throwable {
        Log.i(str, str2);
        WriteLogToSDcard(Logger.I, str, str2);
    }

    public static void storeLogToSDcard() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a).append(File.separatorChar).append(Logger.generateTimeStamp(Boolean.FALSE)).append(".log");
        File file = new File(a);
        b = new File(stringBuffer.toString());
        if (file.exists()) {
            Logger.deleteOldLog(file);
        } else {
            file.mkdirs();
        }
        if (b.exists()) {
            return;
        }
        try {
            b.createNewFile();
        } catch (IOException e) {
            b = null;
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) throws Throwable {
        Log.i(str, str2);
        WriteLogToSDcard(Logger.W, str, str2);
    }
}
