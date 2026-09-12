package io.dcloud.common.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dcloud.android.widget.toast.ToastCompat;
import com.nostra13.dcloudimageloader.core.download.ImageDownloader;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.base.R;
import io.dcloud.common.DHInterface.IApp;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MobilePhoneModel;
import io.dcloud.common.adapter.util.PlatformUtil;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.language.LanguageUtil;
import io.dcloud.p.e1;
import io.dcloud.p.i0;
import io.dcloud.sdk.core.util.Const;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class PdrUtil {
    public static final String FILE_PATH_ENTRY_BACK = "..";
    public static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String NAVIGATION = "navigationBarBackground";
    private static volatile boolean mHasCheckAllScreen;
    private static volatile boolean mIsAllScreenDevice;

    public static void alert(Activity activity, String str, Bitmap bitmap) {
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(activity).create();
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        TextView textView = new TextView(activity);
        textView.setText(str);
        linearLayout.addView(textView);
        ImageView imageView = new ImageView(activity);
        imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        linearLayout.addView(imageView, new ViewGroup.LayoutParams(-2, -2));
        alertDialogCreate.setView(linearLayout);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setButton(activity.getString(R.string.dcloud_common_ok), new DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.PdrUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogCreate.dismiss();
            }
        });
        alertDialogCreate.show();
    }

    public static String appendByDeviceRootDir(String str) {
        if (str == null || str.startsWith(DeviceInfo.sDeviceRootDir)) {
            return str;
        }
        if (str.startsWith(DeviceInfo.FILE_PROTOCOL)) {
            str = str.substring(7);
        }
        if (str.indexOf("sdcard/") > -1) {
            str = str.substring(str.indexOf("sdcard/") + 7);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return DeviceInfo.sDeviceRootDir + "/" + str;
    }

    public static boolean checkAlphaTransparent(int i) {
        return (i == -1 || (i >>> 24) == 255) ? false : true;
    }

    public static boolean checkIntl() {
        return PlatformUtil.checkClass("io.dcloud.common.DHInterface.IntlCallback");
    }

    public static boolean checkStatusbarColor(int i) {
        String str = Build.BRAND;
        if (str.equals(MobilePhoneModel.GOOGLE)) {
            str = Build.MANUFACTURER;
        }
        if ((Build.VERSION.SDK_INT >= 23 || str.equalsIgnoreCase(MobilePhoneModel.XIAOMI) || str.equalsIgnoreCase(MobilePhoneModel.MEIZU)) && !str.equalsIgnoreCase(MobilePhoneModel.DUOWEI)) {
            return true;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        if (i2 >= 30 || i3 >= 30 || i4 >= 30) {
            return i2 <= 235 || i3 <= 235 || i4 <= 235;
        }
        return false;
    }

    public static void closeAndroidPDialog() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            PlatformUtil.invokeSetFieldValue(PlatformUtil.invokeMethod(Base64.decode2String("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ="), "currentActivityThread"), "mHiddenApiWarningShown", Boolean.TRUE);
        } catch (Exception e) {
            Logger.e("PdrUtil", "closeAndroidPDialog--" + e.getMessage());
        }
    }

    public static String convertAppPath(IWebview iWebview, String str) {
        IApp iAppObtainApp = iWebview.obtainApp();
        if (isNetPath(str) || str.startsWith("file:") || str.contains("/storage") || iAppObtainApp.obtainRunningAppMode() != 1) {
            return iAppObtainApp.convert2WebviewFullPath(iWebview.obtainFullUrl(), str);
        }
        String strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), str);
        if (strConvert2AbsFullPath.startsWith("/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.substring(1, strConvert2AbsFullPath.length());
        }
        if (strConvert2AbsFullPath.contains("android_asset/")) {
            strConvert2AbsFullPath = strConvert2AbsFullPath.replace("android_asset/", "");
        }
        return ImageDownloader.Scheme.ASSETS.wrap(strConvert2AbsFullPath);
    }

    public static int convertToScreenInt(String str, int i, int i2, float f) {
        return convertToScreenInt(str, i, i2, f, false);
    }

    public static String dealString(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 8);
        }
        return new String(bytes, "GBK");
    }

    public static float dpiFromPx(int i, DisplayMetrics displayMetrics) {
        return i / (displayMetrics.densityDpi / 160.0f);
    }

    public static String encodeURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            Logger.e("URLEncode error str=" + str);
            return URLEncoder.encode(str);
        }
    }

    public static boolean getAdEnv(Context context) {
        return !LanguageUtil.getDeviceDefCountry().equalsIgnoreCase(i0.c().decryptStr("GJ", (byte) 4));
    }

    public static JSONObject getConfigData(Context context, String str, String str2, boolean z) {
        try {
            InputStream resInputStream = z ? PlatformUtil.getResInputStream(str2) : DHFile.getInputStream(DHFile.createFileHandler(str2));
            if (resInputStream == null) {
                return null;
            }
            byte[] bytes = IOUtil.getBytes(resInputStream);
            String strA = e1.a(context, bytes);
            if (TextUtils.isEmpty(strA)) {
                strA = new String(bytes);
            }
            return new JSONObject(strA);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getConfigOrientation(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has("screenOrientation")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("screenOrientation");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String string = jSONArrayOptJSONArray.getString(i);
                string.getClass();
                string.hashCode();
                switch (string) {
                    case "portrait-primary":
                        z3 = true;
                        break;
                    case "landscape-secondary":
                        z2 = true;
                        break;
                    case "landscape-primary":
                        z = true;
                        break;
                    case "portrait-secondary":
                        z4 = true;
                        break;
                }
            }
            if ((!z && !z2) || (!z3 && !z4)) {
                if (z && z2) {
                    return 6;
                }
                if (z3 && z4) {
                    return 7;
                }
                if (z) {
                    return 0;
                }
                if (z2) {
                    return 8;
                }
                if (z3) {
                    return 1;
                }
                if (z4) {
                    return 9;
                }
            }
        }
        return 2;
    }

    public static String getDefaultPrivateDocPath(String str, String str2) {
        if (isEmpty(str)) {
            str = AbsoluteConst.MINI_SERVER_APP_DOC + System.currentTimeMillis();
        } else if (str.endsWith("/")) {
            str = str + System.currentTimeMillis();
        }
        if (str.endsWith(Operators.DOT_STR + str2)) {
            return str;
        }
        return str + Operators.DOT_STR + str2;
    }

    public static String getDownloadFilename(String str, String str2, String str3) {
        String[] strArrStringSplit;
        String[] strArrStringSplit2;
        String strValueOf = null;
        try {
            str3 = URLDecoder.decode(str3, "utf-8");
            Uri uri = Uri.parse(str3);
            if (uri != null) {
                String path = uri.getPath();
                if (!isEmpty(path)) {
                    str3 = path;
                }
            }
            if (!isEmpty(str) && (strArrStringSplit = stringSplit(str, ";")) != null) {
                for (int i = 0; i < strArrStringSplit.length; i++) {
                    String str4 = strArrStringSplit[i];
                    if (str4 != null && str4.contains(AbsoluteConst.JSON_KEY_FILENAME) && (strArrStringSplit2 = stringSplit(strArrStringSplit[i].trim(), "=")) != null) {
                        String strReplace = strArrStringSplit2[0].replace(JSUtil.QUOTE, "");
                        String strReplace2 = strArrStringSplit2[1].replace(JSUtil.QUOTE, "");
                        if (!isEmpty(strArrStringSplit2[1]) && isEquals(AbsoluteConst.JSON_KEY_FILENAME, strReplace) && !isEmpty(strReplace2)) {
                            strValueOf = strReplace2;
                            break;
                        }
                    }
                }
            }
        } catch (Exception unused) {
            Logger.d("PdrUtil.getDownloadFilename " + str + " not found filename");
        }
        if (isEmpty(strValueOf)) {
            int iLastIndexOf = str3.lastIndexOf(47);
            if (iLastIndexOf == -1 || iLastIndexOf >= str3.length() - 1) {
                strValueOf = String.valueOf(System.currentTimeMillis());
            } else {
                strValueOf = str3.substring(iLastIndexOf + 1);
                int iIndexOf = strValueOf.indexOf(Operators.CONDITION_IF_STRING);
                if (iIndexOf != -1) {
                    strValueOf = iIndexOf < strValueOf.length() - 1 ? strValueOf.substring(0, iIndexOf) : String.valueOf(System.currentTimeMillis());
                }
            }
        }
        if (!strValueOf.contains(Operators.DOT_STR)) {
            String extensionFromMimeType = getExtensionFromMimeType(str2);
            if (!isEmpty(extensionFromMimeType)) {
                strValueOf = strValueOf + Operators.DOT_STR + extensionFromMimeType;
            }
        }
        try {
            String strReplaceAll = URLDecoder.decode(strValueOf, "UTF-8").replaceAll(File.separator, "");
            if (strReplaceAll.contains(Operators.CONDITION_IF_STRING)) {
                strReplaceAll = strReplaceAll.replaceAll("\\?", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            if (strReplaceAll.length() <= 80) {
                return strReplaceAll;
            }
            return strReplaceAll.substring(0, 80) + System.currentTimeMillis();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return strValueOf;
        }
    }

    public static String getExtensionFromMimeType(String str) {
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    public static String getFileNameByUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            Matcher matcher = Pattern.compile("[\\w\\.]+[\\.](avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|pdf|rar|zip|docx|doc)").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            if (TextUtils.isEmpty(str3)) {
                return String.valueOf(System.currentTimeMillis()) + ".dat";
            }
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (lastPathSegment != null && lastPathSegment.contains(str2)) {
                return lastPathSegment;
            }
            if (TextUtils.isEmpty(str3)) {
                return String.valueOf(System.currentTimeMillis()) + str2;
            }
        }
        return str3;
    }

    public static Object getKeyByIndex(HashMap map, int i) {
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (Object obj : map.keySet()) {
            if (i == i2) {
                return obj;
            }
            i2++;
        }
        return null;
    }

    public static Object getKeyByValue(HashMap map, Object obj, boolean z) {
        if (z && !map.containsValue(obj)) {
            return null;
        }
        for (Object obj2 : map.keySet()) {
            Object obj3 = map.get(obj2);
            if (obj3 != null && obj3.equals(obj)) {
                return obj2;
            }
        }
        return null;
    }

    public static String getMimeType(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (isEmpty(fileExtensionFromUrl) && str.lastIndexOf(Operators.DOT_STR) >= 0) {
            fileExtensionFromUrl = str.substring(str.lastIndexOf(Operators.DOT_STR) + 1);
        }
        String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
        if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
            return mimeTypeFromExtension;
        }
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return "*/*";
        }
        return "application/" + fileExtensionFromUrl;
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", WXEnvironment.OS)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static String getNonString(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static Object getObject(Object[] objArr, int i) {
        try {
            return objArr[i];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x021a A[LOOP:1: B:17:0x0076->B:101:0x021a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x017d A[Catch: Exception -> 0x023d, TRY_ENTER, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0022, B:4:0x0033, B:6:0x0039, B:9:0x0048, B:12:0x0056, B:14:0x005c, B:17:0x0076, B:19:0x007c, B:21:0x0086, B:63:0x0175, B:66:0x017d, B:69:0x0188, B:70:0x018d, B:99:0x0216, B:67:0x0182, B:22:0x008e, B:24:0x0092, B:25:0x009d, B:27:0x00a3, B:29:0x00b1, B:57:0x0164, B:31:0x00bd, B:33:0x00c3, B:34:0x00cc, B:36:0x00d2, B:38:0x00f6, B:40:0x00fe, B:41:0x0121, B:43:0x0127, B:44:0x0130, B:46:0x0136, B:47:0x013f, B:49:0x0145, B:51:0x0150, B:53:0x0156, B:15:0x0067, B:11:0x0051, B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:106:0x0022, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0182 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0022, B:4:0x0033, B:6:0x0039, B:9:0x0048, B:12:0x0056, B:14:0x005c, B:17:0x0076, B:19:0x007c, B:21:0x0086, B:63:0x0175, B:66:0x017d, B:69:0x0188, B:70:0x018d, B:99:0x0216, B:67:0x0182, B:22:0x008e, B:24:0x0092, B:25:0x009d, B:27:0x00a3, B:29:0x00b1, B:57:0x0164, B:31:0x00bd, B:33:0x00c3, B:34:0x00cc, B:36:0x00d2, B:38:0x00f6, B:40:0x00fe, B:41:0x0121, B:43:0x0127, B:44:0x0130, B:46:0x0136, B:47:0x013f, B:49:0x0145, B:51:0x0150, B:53:0x0156, B:15:0x0067, B:11:0x0051, B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:106:0x0022, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0188 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:3:0x0022, B:4:0x0033, B:6:0x0039, B:9:0x0048, B:12:0x0056, B:14:0x005c, B:17:0x0076, B:19:0x007c, B:21:0x0086, B:63:0x0175, B:66:0x017d, B:69:0x0188, B:70:0x018d, B:99:0x0216, B:67:0x0182, B:22:0x008e, B:24:0x0092, B:25:0x009d, B:27:0x00a3, B:29:0x00b1, B:57:0x0164, B:31:0x00bd, B:33:0x00c3, B:34:0x00cc, B:36:0x00d2, B:38:0x00f6, B:40:0x00fe, B:41:0x0121, B:43:0x0127, B:44:0x0130, B:46:0x0136, B:47:0x013f, B:49:0x0145, B:51:0x0150, B:53:0x0156, B:15:0x0067, B:11:0x0051, B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:106:0x0022, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b8 A[Catch: Exception -> 0x0215, TryCatch #1 {Exception -> 0x0215, blocks: (B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:107:0x01a3, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01bd A[Catch: Exception -> 0x0215, TryCatch #1 {Exception -> 0x0215, blocks: (B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:107:0x01a3, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01c3 A[Catch: Exception -> 0x0215, TryCatch #1 {Exception -> 0x0215, blocks: (B:72:0x01a3, B:75:0x01ac, B:77:0x01b2, B:79:0x01b8, B:82:0x01c3, B:83:0x01d0, B:85:0x01d6, B:87:0x01dc, B:89:0x01e2, B:80:0x01bd, B:90:0x01f2, B:92:0x01f8, B:94:0x01fe, B:96:0x0204), top: B:107:0x01a3, outer: #0 }] */
    public static JSONObject getSitemapParameters(JSONObject jSONObject, String str, String str2) {
        String str3;
        JSONArray jSONArrayOptJSONArray;
        String str4;
        String ref;
        JSONArray jSONArrayOptJSONArray2;
        String string;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectCombinSitemapHtmlJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        String str5 = "port";
        String str6 = "matchUrls";
        String str7 = "webviewId";
        try {
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("pages");
            String strOptString = jSONObject.optString(IApp.ConfigProperty.CONFIG_LAUNCH_PATH);
            int i = 0;
            while (i < jSONArrayOptJSONArray3.length()) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray3.optJSONObject(i);
                int i2 = i;
                String str8 = str7;
                String strOptString2 = jSONObjectOptJSONObject4.has(str7) ? jSONObjectOptJSONObject4.optString(str7) : jSONObjectOptJSONObject4.optString("webviewid");
                JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject4.has(str6) ? jSONObjectOptJSONObject4.optJSONArray(str6) : jSONObjectOptJSONObject4.optJSONArray("matchurls");
                JSONArray jSONArray = jSONArrayOptJSONArray3;
                int i3 = 0;
                boolean zMatchArray = false;
                while (i3 < jSONArrayOptJSONArray4.length()) {
                    Object objOpt = jSONArrayOptJSONArray4.opt(i3);
                    JSONArray jSONArray2 = jSONArrayOptJSONArray4;
                    if (objOpt instanceof String) {
                        zMatchArray = match((String) objOpt, str2);
                    } else {
                        if (objOpt instanceof JSONObject) {
                            JSONObject jSONObject2 = (JSONObject) objOpt;
                            URL url = new URL(str2);
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (true) {
                                if (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    if (!"protocol".equals(next)) {
                                        if ("hostname".equals(next)) {
                                            jSONArrayOptJSONArray = jSONObject2.optJSONArray("hostname");
                                            ref = url.getHost();
                                        } else {
                                            if (str5.equals(next)) {
                                                jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(str5);
                                                StringBuilder sb = new StringBuilder();
                                                str3 = str5;
                                                sb.append("");
                                                sb.append(url.getPort());
                                                string = sb.toString();
                                            } else {
                                                str3 = str5;
                                                if ("host".equals(next)) {
                                                    JSONArray jSONArrayOptJSONArray5 = jSONObject2.optJSONArray("host");
                                                    StringBuilder sb2 = new StringBuilder();
                                                    jSONArrayOptJSONArray2 = jSONArrayOptJSONArray5;
                                                    sb2.append(url.getHost());
                                                    sb2.append(":");
                                                    sb2.append(url.getPort());
                                                    string = sb2.toString();
                                                } else {
                                                    if ("pathname".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("pathname");
                                                        ref = url.getPath();
                                                    } else if ("search".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("search");
                                                        ref = url.getQuery();
                                                    } else if ("hash".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("hash");
                                                        ref = url.getRef();
                                                    } else if ("href".equals(next)) {
                                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("href");
                                                        str4 = str2;
                                                    } else {
                                                        jSONArrayOptJSONArray = null;
                                                        str4 = null;
                                                    }
                                                    str4 = ref;
                                                }
                                            }
                                            JSONArray jSONArray3 = jSONArrayOptJSONArray2;
                                            ref = string;
                                            jSONArrayOptJSONArray = jSONArray3;
                                            str4 = ref;
                                        }
                                        if (jSONArrayOptJSONArray == null && str4 != null && !(zMatchArray = matchArray(jSONArrayOptJSONArray, str4))) {
                                            break;
                                        }
                                        str5 = str3;
                                    } else {
                                        jSONArrayOptJSONArray = jSONObject2.optJSONArray("protocol");
                                        ref = url.getProtocol();
                                    }
                                    str3 = str5;
                                    str4 = ref;
                                    if (jSONArrayOptJSONArray == null) {
                                    }
                                    str5 = str3;
                                }
                            }
                        }
                        if (zMatchArray) {
                            if (jSONObjectOptJSONObject4.has("webviewParameter")) {
                                jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("webviewParameter");
                            } else {
                                jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("__html5plusWebviewParameter ");
                            }
                            if (jSONObjectOptJSONObject == null) {
                                jSONObjectOptJSONObject = new JSONObject();
                            }
                            jSONObjectCombinSitemapHtmlJSONObject = jSONObjectOptJSONObject;
                            jSONObjectCombinSitemapHtmlJSONObject.put(IApp.ConfigProperty.CONFIG_LAUNCH_PATH, strOptString);
                            jSONObjectCombinSitemapHtmlJSONObject.put("webviewid", strOptString2);
                            jSONObjectCombinSitemapHtmlJSONObject.put("appid", str);
                            try {
                                if (jSONObject.has(Const.PROVIDER_TYPE_GLOBAL) && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(Const.PROVIDER_TYPE_GLOBAL)) != null) {
                                    if (jSONObjectOptJSONObject2.has("webviewParameter")) {
                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("webviewParameter");
                                    } else {
                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("__html5plusWebviewParameter ");
                                    }
                                    if (jSONObjectOptJSONObject3 != null) {
                                        jSONObjectCombinSitemapHtmlJSONObject = JSONUtil.combinSitemapHtmlJSONObject(new JSONObject(jSONObjectOptJSONObject3.toString()), jSONObjectCombinSitemapHtmlJSONObject);
                                    }
                                    if (!jSONObjectCombinSitemapHtmlJSONObject.has(AbsoluteConst.JSONKEY_STATUSBAR) && jSONObjectOptJSONObject2.has(AbsoluteConst.JSONKEY_STATUSBAR) && !jSONObjectOptJSONObject2.isNull(AbsoluteConst.JSONKEY_STATUSBAR)) {
                                        jSONObjectCombinSitemapHtmlJSONObject.put(AbsoluteConst.JSONKEY_STATUSBAR, new JSONObject(jSONObjectOptJSONObject2.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                                    }
                                }
                                if (!jSONObjectCombinSitemapHtmlJSONObject.has(AbsoluteConst.JSONKEY_STATUSBAR) && jSONObject.has(AbsoluteConst.JSONKEY_STATUSBAR) && !jSONObject.isNull(AbsoluteConst.JSONKEY_STATUSBAR)) {
                                    jSONObjectCombinSitemapHtmlJSONObject.put(AbsoluteConst.JSONKEY_STATUSBAR, new JSONObject(jSONObject.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                                }
                                return jSONObjectCombinSitemapHtmlJSONObject;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return jSONObjectCombinSitemapHtmlJSONObject;
                            }
                        }
                        i3++;
                        str2 = str2;
                        jSONArrayOptJSONArray4 = jSONArray2;
                        str5 = str3;
                    }
                    str3 = str5;
                    if (zMatchArray) {
                        if (jSONObjectOptJSONObject4.has("webviewParameter")) {
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("webviewParameter");
                        } else {
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("__html5plusWebviewParameter ");
                        }
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        jSONObjectCombinSitemapHtmlJSONObject = jSONObjectOptJSONObject;
                        jSONObjectCombinSitemapHtmlJSONObject.put(IApp.ConfigProperty.CONFIG_LAUNCH_PATH, strOptString);
                        jSONObjectCombinSitemapHtmlJSONObject.put("webviewid", strOptString2);
                        jSONObjectCombinSitemapHtmlJSONObject.put("appid", str);
                        if (jSONObject.has(Const.PROVIDER_TYPE_GLOBAL)) {
                            if (jSONObjectOptJSONObject2.has("webviewParameter")) {
                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("webviewParameter");
                            } else {
                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("__html5plusWebviewParameter ");
                            }
                            if (jSONObjectOptJSONObject3 != null) {
                                jSONObjectCombinSitemapHtmlJSONObject = JSONUtil.combinSitemapHtmlJSONObject(new JSONObject(jSONObjectOptJSONObject3.toString()), jSONObjectCombinSitemapHtmlJSONObject);
                            }
                            if (!jSONObjectCombinSitemapHtmlJSONObject.has(AbsoluteConst.JSONKEY_STATUSBAR)) {
                                jSONObjectCombinSitemapHtmlJSONObject.put(AbsoluteConst.JSONKEY_STATUSBAR, new JSONObject(jSONObjectOptJSONObject2.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                            }
                        }
                        if (!jSONObjectCombinSitemapHtmlJSONObject.has(AbsoluteConst.JSONKEY_STATUSBAR)) {
                            jSONObjectCombinSitemapHtmlJSONObject.put(AbsoluteConst.JSONKEY_STATUSBAR, new JSONObject(jSONObject.optJSONObject(AbsoluteConst.JSONKEY_STATUSBAR).toString()));
                        }
                        return jSONObjectCombinSitemapHtmlJSONObject;
                    }
                    i3++;
                    str2 = str2;
                    jSONArrayOptJSONArray4 = jSONArray2;
                    str5 = str3;
                }
                i = i2 + 1;
                str6 = str6;
                str7 = str8;
                jSONArrayOptJSONArray3 = jSONArray;
            }
        } catch (Exception e2) {
            Logger.e("PdrUtil", "getSitemapParameters e==" + e2.getMessage());
        }
        return null;
    }

    public static String getUrlPathName(String str) {
        return str != null ? URLUtil.stripAnchor(stripQuery(str)) : str;
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", WXEnvironment.OS);
        if (identifier == 0) {
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        boolean z = resources.getBoolean(identifier);
        String navBarOverride = getNavBarOverride();
        if ("1".equals(navBarOverride)) {
            return false;
        }
        if (WXInstanceApm.VALUE_ERROR_CODE_DEFAULT.equals(navBarOverride)) {
            return true;
        }
        return z;
    }

    public static String int2DecimalStr(int i, int i2) {
        return String.valueOf(BigDecimal.valueOf(i).divide(BigDecimal.valueOf(i2)));
    }

    public static boolean isAllScreenDevice(Activity activity) {
        float f;
        float f2;
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        if (Build.VERSION.SDK_INT >= 28 && activity.getWindow().getDecorView().getRootWindowInsets() != null && activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout() != null) {
            mIsAllScreenDevice = true;
            return mIsAllScreenDevice;
        }
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i = point.x;
            int i2 = point.y;
            if (i < i2) {
                f2 = i;
                f = i2;
            } else {
                float f3 = i2;
                f = i;
                f2 = f3;
            }
            if (f / f2 >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

    public static boolean isBase64ImagePath(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("data:image");
    }

    public static boolean isContains(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return false;
        }
        return str.contains(str2);
    }

    public static boolean isDeviceRootDir(String str) {
        try {
            return str.startsWith(DeviceInfo.sDeviceRootDir) || str.startsWith(DeviceInfo.sCacheRootDir) || str.startsWith("/sdcard/") || str.startsWith(DeviceInfo.sDeviceRootDir.substring(1)) || str.startsWith("sdcard/");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.equals("")) {
            return true;
        }
        return obj.toString().length() == 4 && obj.toString().toLowerCase(Locale.ENGLISH).equals("null");
    }

    public static boolean isEquals(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean isFilePath(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("file:/");
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024;
    }

    public static boolean isLightColor(int i) {
        return ((int) (((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d))) >= 192;
    }

    public static boolean isNavigationBarExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                viewGroup.getChildAt(i).getContext().getPackageName();
                try {
                    if (viewGroup.getChildAt(i).getId() != -1 && NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId())) && viewGroup.getChildAt(i).getVisibility() == 0) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    public static boolean isNavigationBarShowing(Context context) {
        if (hasNavBar(context)) {
            String str = Build.BRAND;
            String str2 = "navigationbar_is_min";
            if (!str.equalsIgnoreCase("HUAWEI")) {
                if (str.equalsIgnoreCase("XIAOMI")) {
                    str2 = "force_fsg_nav_bar";
                } else if (str.equalsIgnoreCase("VIVO") || str.equalsIgnoreCase("OPPO")) {
                    str2 = "navigation_gesture_on";
                }
            }
            if (Settings.Global.getInt(context.getContentResolver(), str2, 0) == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNetPath(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(DeviceInfo.HTTP_PROTOCOL) && !str.startsWith("http://localhost")) {
            return true;
        }
        if (str.startsWith(DeviceInfo.HTTPS_PROTOCOL) && !str.startsWith("https://localhost")) {
            return true;
        }
        if (!str.startsWith("rtmp://") || str.startsWith("rtmp://localhost")) {
            return str.startsWith("rtsp://") && !str.startsWith("rtsp://localhost");
        }
        return true;
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains("%")) ? false : true;
    }

    public static boolean isSameDay(long j, long j2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2) && gregorianCalendar.get(5) == gregorianCalendar2.get(5);
    }

    public static boolean isSupportOaid() {
        String str = Build.BRAND;
        int i = Build.VERSION.SDK_INT;
        if ((str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("huawei")) && i >= 23) {
            return true;
        }
        if (!str.equalsIgnoreCase("vivo") || i < 28) {
            return (str.equalsIgnoreCase("xiaomi") && i >= 28) || i >= 29;
        }
        return true;
    }

    public static boolean isUniMPHostForUniApp() {
        return PlatformUtil.checkClass("io.dcloud.feature.sdk.Interface.DCUniAppHost");
    }

    private static void loadProperties2HashMap(HashMap<String, String> map, String str) {
        InputStream resInputStream = PlatformUtil.getResInputStream(str);
        Properties properties = new Properties();
        try {
            try {
                properties.load(resInputStream);
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                if (enumerationPropertyNames != null) {
                    while (enumerationPropertyNames.hasMoreElements()) {
                        String str2 = (String) enumerationPropertyNames.nextElement();
                        map.put(str2.toLowerCase(Locale.ENGLISH), (String) properties.get(str2));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            IOUtil.close(resInputStream);
        }
    }

    public static String makeQueryStringAllRegExp(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("\\", "\\\\").replace("*", "\\*").replace(Operators.PLUS, "\\+").replace("|", "\\|").replace(Operators.BLOCK_START_STR, "\\{").replace(Operators.BLOCK_END_STR, "\\}").replace(Operators.BRACKET_START_STR, "\\(").replace(Operators.BRACKET_END_STR, "\\)").replace("^", "\\^").replace(Operators.DOLLAR_STR, "\\$").replace(Operators.ARRAY_START_STR, "\\[").replace(Operators.ARRAY_END_STR, "\\]").replace(Operators.CONDITION_IF_STRING, "\\?").replace(",", "\\,").replace(Operators.DOT_STR, "\\.").replace("&", "\\&").replace("'", "\\'");
    }

    private static boolean match(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    private static boolean matchArray(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                if (match(jSONArray.optString(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean navigationGestureEnabled(Context context) {
        int i;
        if (DeviceInfo.sBrand.toLowerCase(Locale.ENGLISH).equals("xiaomi")) {
            i = Build.VERSION.SDK_INT >= 26 ? Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) : 0;
        } else {
            i = Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0);
        }
        return i != 0;
    }

    public static boolean parseBoolean(String str, boolean z, boolean z2) {
        if (!isEmpty(str)) {
            if (str.equalsIgnoreCase(AbsoluteConst.TRUE)) {
                return !z2;
            }
            if (str.equalsIgnoreCase(AbsoluteConst.FALSE)) {
                return z2;
            }
        }
        return z;
    }

    public static float parseFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f;
        }
    }

    public static int parseInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i;
        }
    }

    public static long parseLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public static int pxFromDp(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(1, f, displayMetrics));
    }

    public static int pxFromSp(float f, DisplayMetrics displayMetrics) {
        return Math.round(TypedValue.applyDimension(2, f, displayMetrics));
    }

    public static Bitmap renderCroppedGreyscaleBitmap(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = new int[i5 * i6];
        int i7 = (i4 * i) + i3;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = i8 * i5;
            for (int i10 = 0; i10 < i5; i10++) {
                iArr[i9 + i10] = ((bArr[i7 + i10] & 255) * 65793) | (-16777216);
            }
            i7 += i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, i5, 0, 0, i5, i6);
        return bitmapCreateBitmap;
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String standardizedURL(String str, String str2) {
        String strStripQuery = stripQuery(stripAnchor(str));
        if (str2.startsWith("./")) {
            str2 = str2.substring(2);
            int iLastIndexOf = strStripQuery.lastIndexOf(47);
            if (iLastIndexOf >= 0) {
                return strStripQuery.substring(0, iLastIndexOf + 1) + str2;
            }
        }
        int iIndexOf = str2.indexOf("../");
        int iLastIndexOf2 = strStripQuery.lastIndexOf(47);
        if (iLastIndexOf2 <= -1) {
            return str2;
        }
        String strSubstring = strStripQuery.substring(0, iLastIndexOf2);
        while (iIndexOf > -1) {
            str2 = str2.substring(3);
            strSubstring = strSubstring.substring(0, strSubstring.lastIndexOf(47));
            iIndexOf = str2.indexOf("../");
        }
        return strSubstring + '/' + str2;
    }

    public static String[] stringSplit(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2, false);
        String[] strArr = new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreElements()) {
            strArr[i] = stringTokenizer.nextToken().trim();
            i++;
        }
        return strArr;
    }

    /* JADX INFO: Removed unreachable split cross block B:67:0x00a6 */
    public static int stringToColor(String str) {
        String[] strArrStringSplit;
        int i;
        int i2;
        try {
            if (!isEmpty(str)) {
                str = str.trim();
            }
            int length = str.length();
            int i3 = 0;
            if (length != 4 && length != 7 && length != 3 && length != 6) {
                if (str.startsWith("#") && length > 1 && length < 10) {
                    return Color.parseColor(str);
                }
                if (str.startsWith("rgba")) {
                    strArrStringSplit = stringSplit(str.substring(5, str.length() - 1), ",");
                    i = 1;
                } else {
                    strArrStringSplit = str.startsWith("rgb") ? stringSplit(str.substring(4, str.length() - 1), ",") : null;
                    i = 0;
                }
                int i4 = 255;
                if (strArrStringSplit != null) {
                    try {
                        try {
                            try {
                                if (i == 0) {
                                    i = Integer.parseInt(strArrStringSplit[0]);
                                    i3 = Integer.parseInt(strArrStringSplit[1]);
                                    i2 = Integer.parseInt(strArrStringSplit[2]);
                                } else {
                                    i = Integer.parseInt(strArrStringSplit[0]);
                                    i3 = Integer.parseInt(strArrStringSplit[1]);
                                    i2 = Integer.parseInt(strArrStringSplit[2]);
                                    try {
                                        i4 = (int) (255 * Float.parseFloat(strArrStringSplit[3]));
                                    } catch (Exception unused) {
                                    }
                                }
                            } catch (Exception unused2) {
                                i = 255;
                                i2 = 255;
                                i3 = 255;
                            }
                        } catch (Exception unused3) {
                            i2 = 255;
                        }
                    } catch (Exception unused4) {
                        i2 = 255;
                        i3 = 255;
                    }
                } else {
                    i = 255;
                    i2 = 255;
                    i3 = 255;
                }
                return (i4 << 24) + (i << 16) + (i3 << 8) + i2;
            }
            if (length == 4 || length == 7) {
                str = str.substring(1);
            }
            if (str.length() == 3) {
                StringBuffer stringBuffer = new StringBuffer();
                while (i3 < 3) {
                    stringBuffer.append(str.charAt(i3)).append(str.charAt(i3));
                    i3++;
                }
                str = stringBuffer.toString();
            }
            return Integer.parseInt(str, 16) - 16777216;
        } catch (Exception unused5) {
            return -1;
        }
    }

    public static String stripAnchor(String str) {
        return URLUtil.stripAnchor(str);
    }

    public static String stripQuery(String str) {
        int iIndexOf = str.indexOf(63);
        return iIndexOf != -1 ? str.substring(0, iIndexOf) : str;
    }

    public static String toHexFromColor(int i) {
        StringBuilder sb = new StringBuilder("#");
        String hexString = Integer.toHexString(Color.red(i));
        String hexString2 = Integer.toHexString(Color.green(i));
        String hexString3 = Integer.toHexString(Color.blue(i));
        if (hexString.length() == 1) {
            hexString = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + hexString3;
        }
        String upperCase = hexString.toUpperCase();
        String upperCase2 = hexString2.toUpperCase();
        String upperCase3 = hexString3.toUpperCase();
        sb.append(upperCase);
        sb.append(upperCase2);
        sb.append(upperCase3);
        return sb.toString();
    }

    public static void toast(Context context, String str, Bitmap bitmap) {
        ToastCompat toastCompatMakeText = ToastCompat.makeText(context, (CharSequence) str, 1);
        if (bitmap != null) {
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            View view = toastCompatMakeText.getView();
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(bitmap);
            ((ViewGroup) view).addView(imageView, 0);
            toastCompatMakeText.setText(str + " w=" + width + ";h=" + height);
        }
        toastCompatMakeText.setDuration(1);
        toastCompatMakeText.show();
    }

    public static int convertToScreenInt(String str, int i, int i2, float f, boolean z) {
        if (str != null) {
            try {
                if (str.endsWith("px")) {
                    String strSubstring = str.substring(0, str.length() - 2);
                    float f2 = ((strSubstring == null || !strSubstring.contains(Operators.DOT_STR)) ? Integer.parseInt(strSubstring) : Float.parseFloat(strSubstring)) * f;
                    return z ? Math.round(f2) : (int) f2;
                }
                if (!str.endsWith("%")) {
                    double d = Double.parseDouble(str) * ((double) f);
                    return z ? (int) Math.round(d) : (int) d;
                }
                String strSubstring2 = str.substring(0, str.length() - 1);
                if (!strSubstring2.contains(Operators.DOT_STR)) {
                    return (i * Integer.parseInt(strSubstring2)) / 100;
                }
                float f3 = (i * Float.parseFloat(strSubstring2)) / 100.0f;
                return z ? Math.round(f3) : (int) f3;
            } catch (NumberFormatException | Exception unused) {
            }
        }
        return i2;
    }

    public static boolean isNavigationBarShow(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return point2.y != point.y;
    }

    public static float parseFloat(String str, float f, float f2) {
        return parseFloat(str, f, f2, 1.0f);
    }

    public static int parseInt(String str, int i, int i2) {
        if (str != null) {
            try {
                String lowerCase = str.toLowerCase(Locale.ENGLISH);
                if (lowerCase.endsWith("px")) {
                    return Integer.parseInt(lowerCase.substring(0, lowerCase.length() - 2));
                }
                if (lowerCase.endsWith("%")) {
                    String strSubstring = lowerCase.substring(0, lowerCase.length() - 1);
                    return strSubstring.contains(Operators.DOT_STR) ? (int) ((i * Float.parseFloat(strSubstring)) / 100.0f) : (i * Integer.parseInt(strSubstring)) / 100;
                }
                if (lowerCase.startsWith("#")) {
                    lowerCase = "0x" + lowerCase.substring(1);
                }
                return lowerCase.startsWith("0x") ? Integer.valueOf(lowerCase.substring(2), 16).intValue() : Integer.parseInt(lowerCase);
            } catch (NumberFormatException | Exception unused) {
            }
        }
        return i2;
    }

    private static String getNavBarOverride() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static float parseFloat(String str, float f, float f2, float f3) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (lowerCase.endsWith("px")) {
                lowerCase = lowerCase.substring(0, lowerCase.length() - 2);
            }
            try {
                return Float.parseFloat(lowerCase) * f3;
            } catch (NumberFormatException unused) {
                if (lowerCase.endsWith("%")) {
                    try {
                        return (f * Float.parseFloat(lowerCase.substring(0, lowerCase.length() - 1))) / 100.0f;
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        return f2;
    }

    public static boolean parseBoolean(String str, boolean z) {
        return isEmpty(str) ? z : str.equalsIgnoreCase(AbsoluteConst.TRUE);
    }

    public static Object getKeyByValue(HashMap map, Object obj) {
        return getKeyByValue(map, obj, false);
    }

    public static void loadProperties2HashMap(HashMap<String, String> map, HashMap<String, String> map2, HashMap<String, HashMap<String, String>> map3, String str) {
        XmlUtil.DHNode dHNodeXML_Parser;
        InputStream resInputStream = PlatformUtil.getResInputStream(str);
        if (resInputStream == null || (dHNodeXML_Parser = XmlUtil.XML_Parser(resInputStream)) == null) {
            return;
        }
        ArrayList<XmlUtil.DHNode> elements = XmlUtil.getElements(XmlUtil.getElement(dHNodeXML_Parser, IApp.ConfigProperty.CONFIG_FEATURES), IApp.ConfigProperty.CONFIG_FEATURE);
        int i = 0;
        if (elements != null && !elements.isEmpty()) {
            int size = elements.size();
            int i2 = 0;
            while (i2 < size) {
                XmlUtil.DHNode dHNode = elements.get(i2);
                i2++;
                XmlUtil.DHNode dHNode2 = dHNode;
                String lowerCase = XmlUtil.getAttributeValue(dHNode2, "name").toLowerCase(Locale.ENGLISH);
                String attributeValue = XmlUtil.getAttributeValue(dHNode2, "value");
                if (AbsoluteConst.F_UI.equals(lowerCase)) {
                    map2.put("webview", attributeValue);
                }
                map2.put(lowerCase, attributeValue);
                ArrayList<XmlUtil.DHNode> elements2 = XmlUtil.getElements(dHNode2, "module");
                if (elements2 != null && !elements2.isEmpty()) {
                    HashMap<String, String> linkedHashMap = map3.get(lowerCase);
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap<>(2);
                        map3.put(lowerCase, linkedHashMap);
                    }
                    int size2 = elements2.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        XmlUtil.DHNode dHNode3 = elements2.get(i3);
                        i3++;
                        XmlUtil.DHNode dHNode4 = dHNode3;
                        linkedHashMap.put(XmlUtil.getAttributeValue(dHNode4, "name").toLowerCase(Locale.ENGLISH), XmlUtil.getAttributeValue(dHNode4, "value"));
                    }
                }
            }
        }
        ArrayList<XmlUtil.DHNode> elements3 = XmlUtil.getElements(XmlUtil.getElement(dHNodeXML_Parser, IApp.ConfigProperty.CONFIG_SERVICES), "service");
        if (elements3 == null || elements3.isEmpty()) {
            return;
        }
        int size3 = elements3.size();
        while (i < size3) {
            XmlUtil.DHNode dHNode5 = elements3.get(i);
            i++;
            XmlUtil.DHNode dHNode6 = dHNode5;
            map.put(XmlUtil.getAttributeValue(dHNode6, "name").toLowerCase(Locale.ENGLISH), XmlUtil.getAttributeValue(dHNode6, "value"));
        }
    }
}
