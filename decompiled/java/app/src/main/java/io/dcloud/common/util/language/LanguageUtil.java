package io.dcloud.common.util.language;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.el.parse.Operators;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class LanguageUtil {
    public static final String LanguageBroadCastIntent = "language_uni_broad_cast_intent";
    public static final String LanguageConfigKey = "language_uni_current_key";
    public static final String LanguageConfigSPFile = "language_uni_sp_file";
    private static String deviceDefCountry = "";
    private static String deviceDefLocalLanguage = "";
    private static String sCurrentLocalLanguage = "";

    public static Locale getCurrentLocal(Context context, boolean z) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            if (!z) {
                return context.getResources().getConfiguration().locale;
            }
            context.getResources();
            return Resources.getSystem().getConfiguration().locale;
        }
        LocaleList locales = context.getResources().getConfiguration().getLocales();
        if (z) {
            context.getResources();
            locales = Resources.getSystem().getConfiguration().getLocales();
        }
        return (locales == null || locales.size() <= 0) ? context.getResources().getConfiguration().locale : locales.get(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    public static String getCurrentLocaleLanguage(Context context) {
        if (!TextUtils.isEmpty(sCurrentLocalLanguage)) {
            return sCurrentLocalLanguage;
        }
        byte b = 1;
        Locale currentLocal = getCurrentLocal(context, true);
        if (currentLocal == null) {
            return deviceDefLocalLanguage;
        }
        String languageTag = currentLocal.getLanguage() + Operators.SUB + currentLocal.getCountry();
        if (Build.VERSION.SDK_INT > 21) {
            languageTag = currentLocal.toLanguageTag();
        }
        String language = currentLocal.getLanguage();
        language.getClass();
        language.hashCode();
        switch (language.hashCode()) {
            case 3241:
                if (!language.equals("en")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 3246:
                if (!language.equals("es")) {
                    b = -1;
                }
                break;
            case 3276:
                if (!language.equals("fr")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 3886:
                if (!language.equals("zh")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return "en";
            case 1:
                return "es";
            case 2:
                return "fr";
            case 3:
                if (languageTag.equalsIgnoreCase("zh-CN")) {
                    return "zh-Hans";
                }
                if (languageTag.equalsIgnoreCase("zh-HK")) {
                    return "zh-Hant-HK";
                }
                if (languageTag.equalsIgnoreCase("zh-TW")) {
                    return "zh-Hant-TW";
                }
            default:
                return languageTag;
        }
    }

    public static String getDeviceDefCountry() {
        return deviceDefCountry;
    }

    public static String getDeviceDefLocalLanguage() {
        return deviceDefLocalLanguage;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ae  */
    public static String getString(JSONObject jSONObject, String str) {
        String string;
        if (jSONObject != null) {
            String currentLocaleLanguage = getCurrentLocaleLanguage(DeviceInfo.sApplicationContext);
            if (TextUtils.isEmpty(currentLocaleLanguage)) {
                string = str;
            } else {
                string = getString(currentLocaleLanguage, jSONObject);
                if (TextUtils.isEmpty(string)) {
                    if (currentLocaleLanguage.equalsIgnoreCase("zh-CN")) {
                        string = getString("zh-Hans", jSONObject);
                    } else if (currentLocaleLanguage.equalsIgnoreCase("zh-HK")) {
                        string = getString("zh-Hant-HK", jSONObject);
                    } else if (currentLocaleLanguage.equalsIgnoreCase("zh-TW")) {
                        string = getString("zh-Hant-TW", jSONObject);
                    }
                    if (TextUtils.isEmpty(string)) {
                        String[] strArrSplit = currentLocaleLanguage.split(Operators.SUB);
                        int length = strArrSplit.length;
                        if (length == 2) {
                            string = getString(strArrSplit[0], jSONObject);
                        } else if (length == 3) {
                            string = getString(strArrSplit[0] + Operators.SUB + strArrSplit[2], jSONObject);
                            if (TextUtils.isEmpty(string)) {
                                string = getString(strArrSplit[0] + Operators.SUB + strArrSplit[1], jSONObject);
                            }
                            if (TextUtils.isEmpty(string)) {
                                string = getString(strArrSplit[0], jSONObject);
                            }
                        }
                    }
                }
            }
        } else {
            string = str;
        }
        return PdrUtil.isEmpty(string) ? str : string;
    }

    public static void initAppLanguageForAppBeforeO(Context context) {
        updateAppBootLanguage(context);
        updateSystemLanguage(context);
    }

    private static void updateAppBootLanguage(Context context) {
        String string;
        String string2 = context.getSharedPreferences(LanguageConfigSPFile, 0).getString(LanguageConfigKey, "");
        try {
            string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("DCLOUD_APP_DEFAULT_LANGUAGE");
        } catch (Exception e) {
            e.printStackTrace();
            string = "";
        }
        if (TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            string2 = string;
        }
        sCurrentLocalLanguage = "auto".equalsIgnoreCase(string2) ? "" : string2;
        updateDeviceDefLocalLanguage(context);
    }

    public static Context updateContextLanguageAfterO(Context context, boolean z) {
        return updateContextLanguageAfterO(context, z, true);
    }

    public static void updateDeviceDefLocalLanguage(Locale locale) {
        if (locale != null) {
            deviceDefLocalLanguage = locale.getLanguage() + Operators.SUB + locale.getCountry();
            deviceDefCountry = locale.getCountry();
            DeviceInfo.sLanguage = deviceDefLocalLanguage;
        }
    }

    public static void updateLanguage(Context context, String str) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(LanguageConfigSPFile, 0).edit();
        editorEdit.putString(LanguageConfigKey, str);
        editorEdit.commit();
        sCurrentLocalLanguage = str;
        updateSystemLanguage(context);
    }

    public static void updateSystemLanguage(Context context) {
        if (context == null) {
            return;
        }
        String str = sCurrentLocalLanguage;
        if ("zh-Hant-TW".equals(str) || "zh-Hant".equals(str)) {
            str = "zh-TW";
        } else if ("zh-Hant-HK".equals(str)) {
            str = "zh-HK";
        }
        if (Build.VERSION.SDK_INT < 24) {
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(str)) {
                str = deviceDefLocalLanguage;
            }
            Locale localeForLanguageTag = Locale.forLanguageTag(str);
            Locale.setDefault(localeForLanguageTag);
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(localeForLanguageTag);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return;
        }
        Resources resources2 = context.getResources();
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        Configuration configuration2 = resources2.getConfiguration();
        if (TextUtils.isEmpty(str)) {
            str = deviceDefLocalLanguage;
        }
        g4$$ExternalSyntheticApiModelOutline0.m$3();
        LocaleList localeListM = g4$$ExternalSyntheticApiModelOutline0.m(new Locale[]{Locale.forLanguageTag(str)});
        LocaleList.setDefault(localeListM);
        configuration2.setLocales(localeListM);
        resources2.updateConfiguration(configuration2, displayMetrics);
    }

    public static Context wrapContextConfigurationAfterO(Context context, String str) {
        return wrapContextConfigurationAfterO(context, str, true);
    }

    public static Context updateContextLanguageAfterO(Context context, boolean z, boolean z2) {
        if (z) {
            updateAppBootLanguage(context);
        }
        return TextUtils.isEmpty(sCurrentLocalLanguage) ? context : wrapContextConfigurationAfterO(context, sCurrentLocalLanguage, z2);
    }

    public static Context wrapContextConfigurationAfterO(Context context, String str, boolean z) {
        if (Build.VERSION.SDK_INT < 24) {
            return context;
        }
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        g4$$ExternalSyntheticApiModelOutline0.m$3();
        LocaleList localeListM = g4$$ExternalSyntheticApiModelOutline0.m(new Locale[]{Locale.forLanguageTag(str)});
        LocaleList.setDefault(localeListM);
        configuration.setLocales(localeListM);
        resources.updateConfiguration(configuration, displayMetrics);
        return z ? context.createConfigurationContext(configuration) : context;
    }

    public static void updateDeviceDefLocalLanguage(Context context) {
        updateDeviceDefLocalLanguage(getCurrentLocal(context, true));
    }

    private static String getString(String str, JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.containsKey(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }
}
