package io.dcloud.p;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.util.TelephonyUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u4 {
    private static String a = "";
    private static String b;
    private static String c;

    private static boolean a(String str) {
        return TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }

    private static StringBuilder b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                inputStream.close();
                return sb;
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0115 A[PHI: r1
  0x0115: PHI (r1v3 java.lang.String) = (r1v1 java.lang.String), (r1v4 java.lang.String) binds: [B:84:0x0112, B:76:0x0103] A[DONT_GENERATE, DONT_INLINE]] */
    public static String a(Context context, boolean z, boolean z2) {
        String strA = null;
        try {
            String str = TelephonyUtil.TAG;
            Class cls = Boolean.TYPE;
            Method method = TelephonyUtil.class.getMethod("getSBBS", Context.class, cls, cls, cls);
            Boolean boolValueOf = Boolean.valueOf(b0.a().a(context));
            Boolean bool = Boolean.TRUE;
            return (String) method.invoke(null, context, bool, bool, boolValueOf);
        } catch (Exception e) {
            if (w0.a) {
                e.printStackTrace();
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (z) {
                stringBuffer.append("|");
            }
            String strReplace = "";
            if (context == null) {
                return z ? "|||||" : "";
            }
            if (z2) {
                if (z && !TextUtils.isEmpty(c)) {
                    return c;
                }
                if (!a(a) && !z) {
                    return a;
                }
            } else {
                if (z && !TextUtils.isEmpty(b)) {
                    return b;
                }
                if (!a(a) && !z) {
                    return a;
                }
            }
            String[] strArrE = y1.e(context);
            if (!a(a) && !z) {
                return a;
            }
            if (strArrE != null) {
                a = TextUtils.join(",", strArrE);
            } else {
                a = "";
            }
            if (z) {
                stringBuffer.append(a).append("|");
            }
            if (z) {
                stringBuffer.append("|");
            }
            boolean zA = a(a);
            if (!zA && !z) {
                return a;
            }
            String strA2 = y1.a(context);
            if (zA) {
                a = strA2;
            }
            if (z) {
                if (TextUtils.isEmpty(strA2)) {
                    strA2 = "";
                }
                stringBuffer.append(strA2).append("|");
            }
            boolean zA2 = a(a);
            if (!zA2 && !z) {
                return a;
            }
            try {
                try {
                    strA = a(context);
                    if (zA2) {
                        a = strA;
                    }
                    if (z) {
                        if (!TextUtils.isEmpty(strA)) {
                            strReplace = strA.replace("\n", "");
                        }
                        stringBuffer.append(strReplace).append("|");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (z) {
                        if (!TextUtils.isEmpty(strA)) {
                            strReplace = strA.replace("\n", "");
                        }
                        stringBuffer.append(strReplace).append("|");
                    }
                }
                b = URLEncoder.encode(Base64.encodeToString(d.b(stringBuffer.toString().getBytes(), f1.b(), f1.a()), 2)) + "&ie=1";
                String string = stringBuffer.toString();
                c = string;
                return z2 ? string : b;
            } catch (Throwable th) {
                if (z) {
                    stringBuffer.append(TextUtils.isEmpty(strA) ? "" : strA.replace("\n", "")).append("|");
                }
                throw th;
            }
        }
    }

    public static String a(Context context) {
        try {
            l1.a(context);
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append(".imei.txt");
            String string = sb.toString();
            File file = new File(string);
            if (!file.exists()) {
                string = context.getFilesDir() + str + ".DC4278477faeb9.txt";
                file = new File(string);
            }
            if (file.isDirectory()) {
                file.delete();
            }
            return a(file, null, string, null, context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(File file, File file2, String str, String str2, Context context) {
        if (file.exists() && file.length() > 0) {
            try {
                return a(new FileInputStream(file));
            } catch (Exception unused) {
                return a(context, file, file2, ".DC4278477faeb9.txt");
            }
        }
        return a(context, file, file2, ".DC4278477faeb9.txt");
    }

    private static String a(Context context, File file, File file2, String str) throws IOException {
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        String strReplace = UUID.randomUUID().toString().replaceAll(Operators.SUB, "").replace("\n", "");
        byte[] bytes = strReplace.getBytes();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            return strReplace;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return strReplace;
        } catch (IOException e2) {
            e2.printStackTrace();
            return strReplace;
        }
    }

    public static String a(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        return b(inputStream).toString();
    }
}
