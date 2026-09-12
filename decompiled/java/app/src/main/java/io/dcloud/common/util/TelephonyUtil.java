package io.dcloud.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hjq.permissions.Permission;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.p.e1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class TelephonyUtil {
    private static String AIDKEY = "aid";
    private static String AId = "";
    private static String IMEI1_KEY = "II1";
    private static String IMEI2_KEY = "II2";
    private static String[] MultiIMEITemp = null;
    private static String MultiIMEI_KEY = "mmikey";
    private static final String OLD_UUID_FILE_NAME = ".imei.txt";
    public static final String TAG = "TelephonyUtil";
    private static final String UUID_FILE_NAME = ".DC4278477faeb9.txt";
    private static boolean isGetAId = false;
    private static boolean isGetMultiIMEI = false;
    private static String randomId = null;
    private static String sImei = "";
    private static String sOriginalImeiAndBakInfo;
    private static Boolean isGetRdId = Boolean.FALSE;
    private static String sIMSI = null;
    private static boolean isGetIMSI = false;
    private static String IMSI_KEY = "isi";
    private static String sMac = null;
    private static boolean isGetMac = false;
    private static String MAC_KEY = "mc";
    private static String mImei = "";

    private static boolean checkPseudoData(String str) {
        if (PdrUtil.isEmpty(str) || str.contains("000000")) {
            return true;
        }
        str.hashCode();
        switch (str) {
            case "020000000000":
            case "9F89C84A559F573636A47FF8DAED0D33":
            case "E3F5536A141811DB40EFD6400F1D0A4E":
            case "00000000-0000-0000-0000-000000000000":
                return true;
            default:
                return false;
        }
    }

    private static String createRandomBSFile(Context context, File file, File file2, String str) throws IOException {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        String strReplaceAll = UUID.randomUUID().toString().replaceAll(Operators.SUB, "").replaceAll("\n", "");
        byte[] bytes = strReplaceAll.getBytes();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.close();
            if (!FileUtil.needMediaStoreOpenFile(context) && file2 != null) {
                DHFile.copyFile(file.getPath(), file2.getPath());
                return strReplaceAll;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return strReplaceAll;
    }

    public static String getAId(Context context) {
        if (!isGetAId) {
            if (ContextCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) != 0) {
                return AId;
            }
            SharedPreferences orCreateBundle = SP.getOrCreateBundle(context, SP.N_DEVICE_INFO);
            if (orCreateBundle.contains(AIDKEY)) {
                String string = orCreateBundle.getString(AIDKEY, null);
                if (!PdrUtil.isEmpty(string)) {
                    AId = Base64.decodeString(string, true, 10);
                }
            } else {
                String string2 = Settings.Secure.getString(context.getContentResolver(), e1.a("aWZsemdhbFdhbA=="));
                AId = string2;
                SP.setBundleData(orCreateBundle, AIDKEY, PdrUtil.isEmpty(string2) ? AId : Base64.encodeString(AId, true, 10));
            }
            isGetAId = true;
        }
        return AId;
    }

    private static String getAPSubId(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        if (!AppRuntime.hasPrivacyForNotShown(context)) {
            return "";
        }
        try {
            Object objInvokeMethod = ReflectUtils.invokeMethod(context.getSystemService("phone"), e1.a("b218W31qe2t6YWptekFs"), new Class[0], new Object[0]);
            if (objInvokeMethod != null) {
                return (String) objInvokeMethod;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002d  */
    public static String getDCloudDeviceID(Context context) {
        String strJoin;
        String bundleData = SP.getBundleData(context, BaseInfo.PDR, "android_device_dcloud_id");
        if (!checkPseudoData(bundleData)) {
            return bundleData;
        }
        if (Build.VERSION.SDK_INT <= 28 || PdrUtil.isEmpty(DeviceInfo.oaids)) {
            strJoin = "";
        } else {
            String[] strArrSplit = DeviceInfo.oaids.split("\\|");
            if (strArrSplit.length > 0) {
                strJoin = strArrSplit[0];
            } else {
                strJoin = "";
            }
        }
        if (checkPseudoData(strJoin)) {
            String[] strArr = MultiIMEITemp;
            strJoin = strArr != null ? TextUtils.join(",", strArr) : "";
            if (checkPseudoData(strJoin)) {
                strJoin = getRandomId(context);
                if (checkPseudoData(strJoin)) {
                    strJoin = "";
                }
            }
        }
        if (PdrUtil.isEmpty(strJoin)) {
            return "";
        }
        String strMd5LowerCase32Bit = Md5Utils.md5LowerCase32Bit(strJoin);
        SP.setBundleData(context, BaseInfo.PDR, "android_device_dcloud_id", strMd5LowerCase32Bit);
        return strMd5LowerCase32Bit;
    }

    public static String getIMEI(Context context) {
        return getIMEI(context, true);
    }

    public static String[] getMultiIMEI(Context context) {
        String strOptString;
        String strOptString2;
        if (ContextCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) != 0) {
            return null;
        }
        if (AppRuntime.hasPrivacyForNotShown(context)) {
            return MultiIMEITemp;
        }
        if (isGetMultiIMEI) {
            return MultiIMEITemp;
        }
        SharedPreferences orCreateBundle = SP.getOrCreateBundle(context, SP.N_DEVICE_INFO);
        if (orCreateBundle.contains(MultiIMEI_KEY)) {
            String string = orCreateBundle.getString(MultiIMEI_KEY, null);
            if (PdrUtil.isEmpty(string)) {
                strOptString = null;
                strOptString2 = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(Base64.decodeString(string, true, 10));
                    strOptString = jSONObject.optString(IMEI1_KEY);
                    try {
                        strOptString2 = jSONObject.optString(IMEI2_KEY);
                    } catch (JSONException unused) {
                        strOptString2 = null;
                    }
                } catch (JSONException unused2) {
                    strOptString = null;
                }
            }
            isGetMultiIMEI = true;
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            try {
                strOptString = (String) PlatformUtil.invokeMethod(telephonyManager.getClass().getName(), "getDeviceId", telephonyManager);
                if (isUnValid(strOptString)) {
                    strOptString = null;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IMEI1_KEY, strOptString);
                    jSONObject2.put(IMEI2_KEY, (Object) null);
                    SP.setBundleData(orCreateBundle, MultiIMEI_KEY, Base64.encodeString(jSONObject2.toString(), true, 10));
                } catch (Exception unused3) {
                }
            } catch (Exception unused4) {
                strOptString = null;
            }
            strOptString2 = null;
        }
        if (!isUnValid(strOptString) && !isUnValid(strOptString2)) {
            MultiIMEITemp = new String[]{strOptString, strOptString2};
        } else if (!isUnValid(strOptString)) {
            MultiIMEITemp = new String[]{strOptString};
        } else if (isUnValid(strOptString2)) {
            MultiIMEITemp = null;
        } else {
            MultiIMEITemp = new String[]{strOptString2};
        }
        isGetMultiIMEI = true;
        return MultiIMEITemp;
    }

    private static Object getPhoneInfo(int i, Context context) {
        try {
            Object systemService = context.getSystemService("phone");
            String strA = e1.a("b218W31qe2t6YWptekFs");
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 21) {
                return ReflectUtils.invokeMethod(systemService, strA, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
            }
            if (i2 == 21) {
                return ReflectUtils.invokeMethod(systemService, strA, new Class[]{Long.TYPE}, new Object[]{Integer.valueOf(i)});
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00cb A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00da A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00e8 A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00f2 A[Catch: Exception -> 0x010e, all -> 0x011f, TryCatch #0 {Exception -> 0x010e, blocks: (B:30:0x00c4, B:36:0x00e2, B:38:0x00e8, B:40:0x00f2, B:41:0x00fc, B:33:0x00cb, B:35:0x00da), top: B:54:0x00c4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0114 A[Catch: all -> 0x011f, Exception -> 0x0121, TryCatch #1 {Exception -> 0x0121, blocks: (B:7:0x000e, B:10:0x0037, B:11:0x0052, B:14:0x0060, B:16:0x0068, B:18:0x0089, B:20:0x00a7, B:22:0x00ad, B:24:0x00b2, B:26:0x00b8, B:42:0x010e, B:44:0x0114, B:45:0x0119), top: B:56:0x000e }] */
    public static String getRandomId(Context context) {
        String str;
        File file;
        String strSavePublicFile;
        if (isGetRdId.booleanValue()) {
            return randomId;
        }
        String string = null;
        try {
            boolean zNeedMediaStoreOpenFile = FileUtil.needMediaStoreOpenFile(context);
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(OLD_UUID_FILE_NAME);
            String string2 = sb.toString();
            File file2 = new File(string2);
            if (!file2.exists()) {
                string2 = context.getFilesDir() + str2 + UUID_FILE_NAME;
                file2 = new File(string2);
            }
            if ("mounted".equalsIgnoreCase(Environment.getExternalStorageState()) && !zNeedMediaStoreOpenFile && ContextCompat.checkSelfPermission(context, Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                str = Environment.getExternalStorageDirectory() + str2 + OLD_UUID_FILE_NAME;
                file = new File(str);
                if (!file.exists()) {
                    str = Environment.getExternalStorageDirectory() + str2 + UUID_FILE_NAME;
                    file = new File(str);
                }
            } else {
                str = null;
                file = null;
            }
            if (file2.isDirectory()) {
                file2.delete();
            }
            if (file != null && file.exists() && file.length() > 0) {
                if (zNeedMediaStoreOpenFile) {
                    try {
                        if (Build.VERSION.SDK_INT < 29) {
                            string = IOUtil.toString(new FileInputStream(file));
                            if (!PdrUtil.isEmpty(string)) {
                                string = string.replace("\n", "");
                            }
                        }
                        if (!TextUtils.isEmpty(string)) {
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                                file2.createNewFile();
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            fileOutputStream.write(string.getBytes());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    } catch (Exception unused) {
                    }
                    if (TextUtils.isEmpty(string)) {
                        strSavePublicFile = savePublicFile(file2, file, string2, str, context);
                    }
                } else {
                    string = IOUtil.toString(new FileInputStream(file));
                    if (!PdrUtil.isEmpty(string)) {
                        string = string.replace("\n", "");
                    }
                    if (!TextUtils.isEmpty(string)) {
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                            file2.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        fileOutputStream2.write(string.getBytes());
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    }
                    if (TextUtils.isEmpty(string)) {
                        strSavePublicFile = savePublicFile(file2, file, string2, str, context);
                    }
                }
                randomId = string;
                isGetRdId = Boolean.TRUE;
                return string;
            }
            strSavePublicFile = savePublicFile(file2, file, string2, str, context);
            string = strSavePublicFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        randomId = string;
        isGetRdId = Boolean.TRUE;
        return string;
    }

    public static String getSBBS(Context context, boolean z, boolean z2) {
        return getSBBS(context, z, z2, true);
    }

    private static int getSubId(int i, Context context) {
        Uri uri = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, new String[]{"_id", "sim_id"}, "sim_id = ?", new String[]{String.valueOf(i)}, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return i2;
            }
            if (cursorQuery == null) {
                return -1;
            }
        } catch (Exception unused) {
            if (cursorQuery == null) {
                return -1;
            }
        } catch (Throwable th) {
            if (cursorQuery == null) {
                throw th;
            }
            cursorQuery.close();
            throw th;
        }
        cursorQuery.close();
        return -1;
    }

    @Deprecated
    public static String getWifiData(Context context) {
        Object objInvokeMethod;
        String strReplace = null;
        if (AppRuntime.hasPrivacyForNotShown(context)) {
            return null;
        }
        if (isGetMac) {
            return sMac;
        }
        SharedPreferences orCreateBundle = SP.getOrCreateBundle(context, SP.N_DEVICE_INFO);
        if (orCreateBundle.contains(MAC_KEY)) {
            String string = orCreateBundle.getString(MAC_KEY, null);
            if (!PdrUtil.isEmpty(string)) {
                sMac = Base64.decodeString(string, true, 10);
            }
        } else {
            Object systemService = context.getSystemService(e1.a("f2FuYQ=="));
            if (systemService != null && (objInvokeMethod = ReflectUtils.invokeMethod(systemService, e1.a("b218S2dmZm1rfGFnZkFmbmc"), new Class[0], new Object[0])) != null) {
                Object objInvokeMethod2 = ReflectUtils.invokeMethod(objInvokeMethod, e1.a("b218RWlrSWxsem17ew"), new Class[0], new Object[0]);
                String str = objInvokeMethod2 != null ? (String) objInvokeMethod2 : null;
                if (!TextUtils.isEmpty(str)) {
                    strReplace = str.replace(":", "");
                }
            }
            sMac = strReplace;
            SP.setBundleData(orCreateBundle, MAC_KEY, PdrUtil.isEmpty(strReplace) ? sMac : Base64.encodeString(sMac, true, 10));
        }
        isGetMac = true;
        return sMac;
    }

    private static boolean isUnValid(String str) {
        return TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }

    private static String savePublicFile(File file, File file2, String str, String str2, Context context) throws IOException {
        String string;
        if (!file.exists() || file.length() <= 0) {
            return createRandomBSFile(context, file, file2, UUID_FILE_NAME);
        }
        try {
            string = IOUtil.toString(new FileInputStream(file));
            try {
                if (!PdrUtil.isEmpty(string)) {
                    string = string.replaceAll("\n", "");
                }
                if (file2 != null && !FileUtil.needMediaStoreOpenFile(context)) {
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                        file2.createNewFile();
                    }
                    DHFile.copyFile(str, str2);
                    return string;
                }
                return string;
            } catch (Exception unused) {
                return string == null ? createRandomBSFile(context, file, file2, UUID_FILE_NAME) : string;
            }
        } catch (Exception unused2) {
            string = null;
        }
    }

    public static String updateIMEI(Context context) {
        if (!PdrUtil.isEmpty(mImei)) {
            return mImei;
        }
        String[] multiIMEI = getMultiIMEI(context);
        if (multiIMEI == null) {
            mImei = "";
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : multiIMEI) {
            sb.append(str);
            sb.append(",");
        }
        if (sb.lastIndexOf(",") >= sb.length() - 1) {
            String string = sb.deleteCharAt(sb.length() - 1).toString();
            mImei = string;
            return string;
        }
        String string2 = sb.toString();
        mImei = string2;
        return string2;
    }

    public static String getIMEI(Context context, boolean z) {
        return getIMEI(context, z, false);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x012e A[PHI: r4
  0x012e: PHI (r4v14 java.lang.String) = (r4v13 java.lang.String), (r4v15 java.lang.String) binds: [B:108:0x012b, B:100:0x011c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:113:0x013b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0142  */
    /* JADX WARN: Code duplicated, block: B:130:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0097 A[PHI: r5
  0x0097: PHI (r5v4 java.lang.String) = (r5v3 java.lang.String), (r5v7 java.lang.String) binds: [B:49:0x0095, B:38:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:97:0x0114 A[Catch: all -> 0x011f, Exception -> 0x0121, TRY_LEAVE, TryCatch #8 {Exception -> 0x0121, blocks: (B:95:0x010e, B:97:0x0114), top: B:130:0x010e, outer: #9 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0118  */
    public static String getSBBS(Context context, boolean z, boolean z2, boolean z3) throws Throwable {
        String str;
        boolean zIsUnValid;
        String aId;
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append("|");
        }
        String strReplace = "";
        if (context == null) {
            return z ? "|||||" : "";
        }
        if (AppRuntime.hasPrivacyForNotShown(context)) {
            z3 = false;
        }
        if (z && !TextUtils.isEmpty(sOriginalImeiAndBakInfo)) {
            return sOriginalImeiAndBakInfo;
        }
        if (!isUnValid(sImei) && !z) {
            return sImei;
        }
        if (isUnValid(sImei) || z) {
            if (z3) {
                try {
                    String[] multiIMEI = getMultiIMEI(context);
                    if (multiIMEI == null || multiIMEI.length <= 0) {
                        str = "";
                    } else {
                        str = multiIMEI[0];
                        try {
                            try {
                                if (multiIMEI.length > 1) {
                                    str = str + "," + multiIMEI[1];
                                }
                            } catch (Exception e) {
                                e = e;
                                Logger.e(TAG, "getsbbs exception==" + e.getMessage());
                                if (z) {
                                    stringBuffer.append(str).append("|");
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            strReplace = str;
                            if (z) {
                                stringBuffer.append(strReplace).append("|");
                            }
                            throw th;
                        }
                    }
                    sImei = str;
                    if (z) {
                        stringBuffer.append(str).append("|");
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = "";
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        stringBuffer.append(strReplace).append("|");
                    }
                    throw th;
                }
            } else if (z) {
                stringBuffer.append("|");
            }
        }
        if (z) {
            stringBuffer.append("|");
        }
        boolean zIsUnValid2 = isUnValid(sImei);
        String randomId2 = null;
        if (z) {
            if (z3) {
                try {
                    aId = getAId(context);
                    if (zIsUnValid2) {
                        try {
                            try {
                                sImei = aId;
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (z) {
                                    if (TextUtils.isEmpty(aId)) {
                                        aId = "";
                                    }
                                }
                                zIsUnValid = isUnValid(sImei);
                                if (zIsUnValid) {
                                    randomId2 = getRandomId(context);
                                    if (zIsUnValid) {
                                        sImei = randomId2;
                                    }
                                    if (z) {
                                        if (!TextUtils.isEmpty(randomId2)) {
                                            strReplace = randomId2.replace("\n", "");
                                        }
                                        stringBuffer.append(strReplace).append("|");
                                    }
                                } else {
                                    try {
                                        try {
                                            randomId2 = getRandomId(context);
                                            if (zIsUnValid) {
                                                sImei = randomId2;
                                            }
                                            if (z) {
                                                if (!TextUtils.isEmpty(randomId2)) {
                                                    strReplace = randomId2.replace("\n", "");
                                                }
                                                stringBuffer.append(strReplace).append("|");
                                            }
                                        } catch (Exception e4) {
                                            e4.printStackTrace();
                                            if (z) {
                                                if (!TextUtils.isEmpty(randomId2)) {
                                                    strReplace = randomId2.replace("\n", "");
                                                }
                                                stringBuffer.append(strReplace).append("|");
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        if (z) {
                                            stringBuffer.append(TextUtils.isEmpty(randomId2) ? "" : randomId2.replace("\n", "")).append("|");
                                        }
                                        throw th3;
                                    }
                                }
                                if (z) {
                                    return sImei;
                                }
                                String string = stringBuffer.toString();
                                sOriginalImeiAndBakInfo = string;
                                return string;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            randomId2 = aId;
                            if (z) {
                                stringBuffer.append(TextUtils.isEmpty(randomId2) ? "" : randomId2).append("|");
                            }
                            throw th;
                        }
                    }
                    if (z) {
                        if (TextUtils.isEmpty(aId)) {
                            aId = "";
                        }
                        stringBuffer.append(aId).append("|");
                    }
                } catch (Exception e5) {
                    e = e5;
                    aId = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (z) {
                        stringBuffer.append(TextUtils.isEmpty(randomId2) ? "" : randomId2).append("|");
                    }
                    throw th;
                }
            } else if (z) {
                stringBuffer.append("|");
            }
        }
        zIsUnValid = isUnValid(sImei);
        if (zIsUnValid || z) {
            randomId2 = getRandomId(context);
            if (zIsUnValid) {
                sImei = randomId2;
            }
            if (z) {
                if (!TextUtils.isEmpty(randomId2)) {
                    strReplace = randomId2.replace("\n", "");
                }
                stringBuffer.append(strReplace).append("|");
            }
        }
        if (z) {
            return sImei;
        }
        String string2 = stringBuffer.toString();
        sOriginalImeiAndBakInfo = string2;
        return string2;
    }

    public static String getSimOperator(Context context) {
        if (AppRuntime.hasPrivacyForNotShown(context)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager.getSimState() == 5 ? telephonyManager.getSimOperator() : "";
    }

    public static String getIMEI(Context context, boolean z, boolean z2) {
        return getSBBS(context, z, z2);
    }

    public static String getIMEIS(Context context) {
        try {
            String[] multiIMEI = getMultiIMEI(context);
            return multiIMEI != null ? TextUtils.join(",", multiIMEI) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMSI(Context context) {
        if (context == null) {
            return "";
        }
        try {
            if (ContextCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) != 0) {
                return "";
            }
            boolean zHasPrivacyForNotShown = AppRuntime.hasPrivacyForNotShown(context);
            if (!isGetIMSI && !zHasPrivacyForNotShown) {
                String str = sIMSI;
                if (str != null) {
                    return str;
                }
                SharedPreferences orCreateBundle = SP.getOrCreateBundle(context, SP.N_DEVICE_INFO);
                if (orCreateBundle.contains(IMSI_KEY)) {
                    String string = orCreateBundle.getString(IMSI_KEY, null);
                    if (!PdrUtil.isEmpty(string)) {
                        sIMSI = Base64.decodeString(string, true, 10);
                    }
                } else {
                    int subId = getSubId(0, context);
                    int subId2 = getSubId(1, context);
                    if (subId == -1 && subId2 == -1) {
                        sIMSI = getAPSubId(context);
                    } else {
                        String str2 = (String) getPhoneInfo(subId, context);
                        String str3 = (String) getPhoneInfo(subId2, context);
                        if (!PdrUtil.isEmpty(str2)) {
                            sIMSI = str2;
                            if (!PdrUtil.isEmpty(str3) && !str2.equals(str3)) {
                                sIMSI += "," + str3;
                            }
                        } else if (!PdrUtil.isEmpty(str3)) {
                            sIMSI = str3;
                        } else {
                            sIMSI = getAPSubId(context);
                        }
                    }
                    SP.setBundleData(orCreateBundle, IMSI_KEY, PdrUtil.isEmpty(sIMSI) ? sIMSI : Base64.encodeString(sIMSI, true, 10));
                }
                isGetIMSI = true;
                return sIMSI;
            }
            return sIMSI;
        } catch (Exception unused) {
        }
    }
}
