package io.dcloud.common.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.performance.WXInstanceApm;
import io.dcloud.PdrR;
import io.dcloud.base.R;
import io.dcloud.common.adapter.util.AndroidResources;
import io.dcloud.common.adapter.util.SP;
import io.dcloud.common.ui.Info.AndroidPrivacyResponse;
import io.dcloud.common.util.AppRuntime;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.common.util.TitleNViewUtil;
import io.dcloud.common.util.language.LanguageUtil;
import io.dcloud.feature.internal.sdk.SDK;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class PrivacyManager {
    private static PrivacyManager f;
    private List a = new ArrayList();
    private AndroidPrivacyResponse b = new AndroidPrivacyResponse();
    private boolean c = false;
    public boolean d = false;
    private io.dcloud.common.ui.a e;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    @FunctionalInterface
    public interface PrivacyAgreeCallback {
        void call(Boolean bool);
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public interface b {
        void a();

        void a(AndroidPrivacyResponse androidPrivacyResponse);

        void a(String str);

        void b(AndroidPrivacyResponse androidPrivacyResponse);
    }

    private PrivacyManager() {
    }

    public static PrivacyManager getInstance() {
        if (f == null) {
            f = new PrivacyManager();
        }
        return f;
    }

    public static boolean isDebugMode() {
        Class<?> cls;
        try {
            cls = Class.forName("io.dcloud.common.util.net.http.LocalServer2");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        return cls != null;
    }

    public boolean getIsAppAsset() {
        return this.d;
    }

    public void init(Context context) {
        init(context, null);
    }

    public boolean isAgreePrivacy(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("privacy_config_uni_sp_file", 0);
        return "1".equals(SP.getBundleData(context, "pdr", "scok")) && sharedPreferences.getString("privacy_config_version_uni_current_key", "emptyPrivacyVersion").equals(this.b.version) && sharedPreferences.getInt("privacy_config_choose_disagree_uni_current_key", 0) == 0;
    }

    public boolean isNotPrivacyAllRight(Context context) {
        if (!this.c) {
            init(context);
        }
        String str = this.b.prompt;
        String bundleData = SP.getBundleData(context, "pdr", "scok");
        return (PdrUtil.isEmpty(bundleData) || !bundleData.equals("1")) && !PdrUtil.isEmpty(str) && str.equalsIgnoreCase("template");
    }

    public boolean isPrivacyVersionChange(Context context) {
        this.c = false;
        init(context);
        return (SDK.isUniMPSDK() || !"template".equals(this.b.prompt) || context.getSharedPreferences("privacy_config_uni_sp_file", 0).getString("privacy_config_version_uni_current_key", "").equals(this.b.version)) ? false : true;
    }

    public void reInit(Context context, JSONObject jSONObject) throws Throwable {
        if (jSONObject != null) {
            this.c = false;
            init(context, jSONObject);
        } else {
            this.c = false;
            init(context, null);
        }
    }

    public void registerPrivacyAgreeListener(String str, PrivacyAgreeCallback privacyAgreeCallback) {
        this.a.add(new Pair(str, privacyAgreeCallback));
    }

    public void resetPrivacyLocalConfig(Context context) {
        context.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putString("privacy_config_version_uni_current_key", "").putInt("privacy_config_choose_disagree_uni_current_key", 0).apply();
        SP.setBundleData(context, "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        this.a.forEach(new Consumer() { // from class: io.dcloud.common.ui.PrivacyManager$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrivacyManager.a((Pair) obj);
            }
        });
    }

    public void restartPrivacyDialogIfNeed(Activity activity) {
        io.dcloud.common.ui.a aVar = this.e;
        if (aVar == null || !aVar.d()) {
            return;
        }
        b bVarB = this.e.b();
        boolean zC = this.e.c();
        this.e.a();
        this.e = null;
        showPrivacyDialog(activity, bVarB, zC, true);
    }

    public void setAgreePrivacy(Context context, final boolean z) {
        SP.setBundleData(context, "pdr", "scok", z ? "1" : WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        context.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putInt("privacy_config_choose_disagree_uni_current_key", !z ? 1 : 0).putString("privacy_config_version_uni_current_key", this.b.version).apply();
        this.a.forEach(new Consumer() { // from class: io.dcloud.common.ui.PrivacyManager$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                PrivacyManager.a(z, (Pair) obj);
            }
        });
    }

    public void showPrivacyDialog(Activity activity, b bVar, boolean z, boolean z2) {
        if (!a(activity)) {
            bVar.a(this.b.prompt);
            return;
        }
        a aVar = new a(activity, bVar);
        io.dcloud.common.ui.a aVar2 = this.e;
        if (aVar2 != null) {
            aVar2.a();
            this.e = null;
        }
        if (z) {
            io.dcloud.common.ui.a aVar3 = new io.dcloud.common.ui.a(activity);
            this.e = aVar3;
            aVar3.a(bVar);
            this.e.a(true);
            this.e.a(this.b, true, (io.dcloud.common.ui.a.d) aVar);
            this.e.a(R.layout.dcloud_custom_privacy_second_dialog_layout);
            this.e.e();
            return;
        }
        io.dcloud.common.ui.a aVar4 = new io.dcloud.common.ui.a(activity);
        this.e = aVar4;
        aVar4.a(bVar);
        this.e.a(false);
        this.e.a(R.layout.dcloud_custom_privacy_dialog_layout);
        this.e.a(this.b, false, (io.dcloud.common.ui.a.d) aVar);
        this.e.e();
    }

    public void unRegisterPrivacyAgreeAllListener() {
        this.a.clear();
    }

    public void unRegisterPrivacyAgreeListener(String str) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (((Pair) it.next()).first.equals(str)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Pair pair) {
        ((PrivacyAgreeCallback) pair.second).call(Boolean.FALSE);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0100  */
    public void init(Context context, JSONObject jSONObject) throws Throwable {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if (this.c) {
            return;
        }
        this.d = AppRuntime.isAppResourcesInAssetsPath(context, "");
        String str = BaseInfo.sCacheFsAppsPath;
        String str2 = BaseInfo.sDefaultBootApp + "/www/androidPrivacy.json";
        if (jSONObject == null) {
            Object obj = null;
            if (this.d) {
                String strA = a(context, "apps/" + str2);
                if (TextUtils.isEmpty(strA)) {
                    jSONObject = null;
                } else {
                    try {
                        Object object = JSONObject.parseObject(strA, (Class<Object>) AndroidPrivacyResponse.class);
                        jSONObject = JSONObject.parseObject(strA);
                        obj = object;
                    } catch (Exception unused) {
                        Log.e("uniapp", "privacy json format error");
                        jSONObject = null;
                    }
                    if (obj instanceof AndroidPrivacyResponse) {
                        this.b = (AndroidPrivacyResponse) obj;
                    } else {
                        this.b = new AndroidPrivacyResponse();
                    }
                }
            } else {
                File file = new File(str + str2);
                if (file.exists()) {
                    String strA2 = a(file.getPath());
                    try {
                        Object object2 = JSONObject.parseObject(strA2, (Class<Object>) AndroidPrivacyResponse.class);
                        jSONObject = JSONObject.parseObject(strA2);
                        obj = object2;
                    } catch (Exception unused2) {
                        Log.e("uniapp", "privacy json format error");
                        jSONObject = null;
                    }
                    if (obj instanceof AndroidPrivacyResponse) {
                        this.b = (AndroidPrivacyResponse) obj;
                    } else {
                        this.b = new AndroidPrivacyResponse();
                    }
                } else {
                    if (new File(str + BaseInfo.sDefaultBootApp).exists()) {
                        jSONObject = null;
                    } else {
                        String strA3 = a(context, "apps/" + str2);
                        if (TextUtils.isEmpty(strA3)) {
                            jSONObject = null;
                        } else {
                            try {
                                Object object3 = JSONObject.parseObject(strA3, (Class<Object>) AndroidPrivacyResponse.class);
                                jSONObject = JSONObject.parseObject(strA3);
                                obj = object3;
                            } catch (Exception unused3) {
                                jSONObject = null;
                            }
                            if (obj instanceof AndroidPrivacyResponse) {
                                this.b = (AndroidPrivacyResponse) obj;
                            } else {
                                this.b = new AndroidPrivacyResponse();
                            }
                        }
                    }
                }
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (this.b == null) {
            this.b = new AndroidPrivacyResponse();
        }
        AndroidPrivacyResponse androidPrivacyResponse = this.b;
        if (androidPrivacyResponse.second == null) {
            androidPrivacyResponse.second = new AndroidPrivacyResponse.SecondDTO();
        }
        AndroidPrivacyResponse androidPrivacyResponse2 = this.b;
        if (androidPrivacyResponse2.styles == null) {
            androidPrivacyResponse2.styles = new AndroidPrivacyResponse.StylesDTO();
        }
        AndroidPrivacyResponse.StylesDTO stylesDTO = this.b.styles;
        if (stylesDTO.title == null) {
            stylesDTO.title = new AndroidPrivacyResponse.StylesDTO.TitleDTO();
        }
        AndroidPrivacyResponse.StylesDTO stylesDTO2 = this.b.styles;
        if (stylesDTO2.buttonRefuse == null) {
            stylesDTO2.buttonRefuse = new AndroidPrivacyResponse.StylesDTO.ButtonRefuseDTO();
        }
        AndroidPrivacyResponse.StylesDTO stylesDTO3 = this.b.styles;
        if (stylesDTO3.buttonAccept == null) {
            stylesDTO3.buttonAccept = new AndroidPrivacyResponse.StylesDTO.ButtonAcceptDTO();
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("titleLocales");
        if (jSONObject2 != null) {
            AndroidPrivacyResponse androidPrivacyResponse3 = this.b;
            androidPrivacyResponse3.title = LanguageUtil.getString(jSONObject2, androidPrivacyResponse3.title);
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("messageLocales");
        if (jSONObject3 != null) {
            AndroidPrivacyResponse androidPrivacyResponse4 = this.b;
            androidPrivacyResponse4.message = LanguageUtil.getString(jSONObject3, androidPrivacyResponse4.message);
        }
        JSONObject jSONObject4 = jSONObject.getJSONObject("buttonAcceptLocales");
        if (jSONObject4 != null) {
            AndroidPrivacyResponse androidPrivacyResponse5 = this.b;
            androidPrivacyResponse5.buttonAccept = LanguageUtil.getString(jSONObject4, androidPrivacyResponse5.buttonAccept);
        }
        JSONObject jSONObject5 = jSONObject.getJSONObject("buttonRefuseLocales");
        if (jSONObject5 != null) {
            AndroidPrivacyResponse androidPrivacyResponse6 = this.b;
            androidPrivacyResponse6.buttonRefuse = LanguageUtil.getString(jSONObject5, androidPrivacyResponse6.buttonRefuse);
        }
        JSONObject jSONObject6 = jSONObject.getJSONObject("second");
        if (jSONObject6 != null) {
            JSONObject jSONObject7 = jSONObject6.getJSONObject("titleLocales");
            if (jSONObject7 != null) {
                AndroidPrivacyResponse.SecondDTO secondDTO = this.b.second;
                secondDTO.title = LanguageUtil.getString(jSONObject7, secondDTO.title);
            }
            JSONObject jSONObject8 = jSONObject6.getJSONObject("messageLocales");
            if (jSONObject8 != null) {
                AndroidPrivacyResponse.SecondDTO secondDTO2 = this.b.second;
                secondDTO2.message = LanguageUtil.getString(jSONObject8, secondDTO2.message);
            }
            JSONObject jSONObject9 = jSONObject6.getJSONObject("buttonAcceptLocales");
            if (jSONObject9 != null) {
                AndroidPrivacyResponse.SecondDTO secondDTO3 = this.b.second;
                secondDTO3.buttonAccept = LanguageUtil.getString(jSONObject9, secondDTO3.buttonAccept);
            }
            JSONObject jSONObject10 = jSONObject6.getJSONObject("buttonRefuseLocales");
            if (jSONObject10 != null) {
                AndroidPrivacyResponse.SecondDTO secondDTO4 = this.b.second;
                secondDTO4.buttonRefuse = LanguageUtil.getString(jSONObject10, secondDTO4.buttonRefuse);
            }
        }
        if (TextUtils.isEmpty(this.b.version)) {
            this.b.version = "emptyPrivacyVersion";
        }
        if (TextUtils.isEmpty(this.b.prompt)) {
            String metaValue = AndroidResources.getMetaValue("DCLOUD_PRIVACY_PROMPT");
            if (metaValue == null) {
                metaValue = "";
            }
            this.b.prompt = metaValue;
        }
        if (TextUtils.isEmpty(this.b.title) && (i8 = PdrR.getInt(context, "string", "dcloud_privacy_prompt_title")) != 0) {
            String string = context.getString(i8);
            if (string == null) {
                string = "";
            }
            this.b.title = string;
        }
        if (TextUtils.isEmpty(this.b.message) && (i7 = PdrR.getInt(context, "string", "dcloud_privacy_prompt_message")) != 0) {
            String string2 = context.getString(i7);
            if (string2 == null) {
                string2 = "";
            }
            this.b.message = string2;
        }
        if (TextUtils.isEmpty(this.b.buttonAccept) && (i6 = PdrR.getInt(context, "string", "dcloud_privacy_prompt_accept_button_text")) != 0) {
            String string3 = context.getString(i6);
            if (string3 == null) {
                string3 = "";
            }
            this.b.buttonAccept = string3;
        }
        if (TextUtils.isEmpty(this.b.buttonRefuse) && (i5 = PdrR.getInt(context, "string", "dcloud_privacy_prompt_refuse_button_text")) != 0) {
            String string4 = context.getString(i5);
            if (string4 == null) {
                string4 = "";
            }
            this.b.buttonRefuse = string4;
        }
        if (TextUtils.isEmpty(this.b.second.message) && (i4 = PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_message")) != 0) {
            String string5 = context.getString(i4);
            if (string5 == null) {
                string5 = "";
            }
            this.b.second.message = string5;
        }
        if (TextUtils.isEmpty(this.b.second.title) && (i3 = PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_title")) != 0) {
            String string6 = context.getString(i3);
            if (string6 == null) {
                string6 = "";
            }
            this.b.second.title = string6;
        }
        if (TextUtils.isEmpty(this.b.second.buttonAccept) && (i2 = PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_accept_button_text")) != 0) {
            String string7 = context.getString(i2);
            if (string7 == null) {
                string7 = "";
            }
            this.b.second.buttonAccept = string7;
        }
        if (TextUtils.isEmpty(this.b.second.buttonRefuse) && (i = PdrR.getInt(context, "string", "dcloud_second_privacy_prompt_refuse_button_text")) != 0) {
            String string8 = context.getString(i);
            this.b.second.buttonRefuse = string8 != null ? string8 : "";
        }
        if (TextUtils.isEmpty(this.b.styles.backgroundColor)) {
            this.b.styles.backgroundColor = TitleNViewUtil.TRANSPARENT_BUTTON_TEXT_COLOR;
        }
        if (TextUtils.isEmpty(this.b.styles.borderRadius)) {
            this.b.styles.borderRadius = "10px";
        }
        if (TextUtils.isEmpty(this.b.styles.title.color)) {
            this.b.styles.title.color = "#000000";
        }
        if (TextUtils.isEmpty(this.b.styles.buttonAccept.color)) {
            this.b.styles.buttonAccept.color = "#000000";
        }
        if (TextUtils.isEmpty(this.b.styles.buttonRefuse.color)) {
            this.b.styles.buttonRefuse.color = "#000000";
        }
        if (TextUtils.isEmpty(this.b.buttonAccept)) {
            this.b.styles.buttonAccept.color = "#000000";
        }
        if (TextUtils.isEmpty(this.b.styles.buttonRefuse.color)) {
            this.b.styles.buttonRefuse.color = "#000000";
        }
        this.c = true;
    }

    private static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        File file = new File(str);
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            stringBuffer.append(line);
                        } else {
                            bufferedReader.close();
                            String string = stringBuffer.toString();
                            try {
                                bufferedReader.close();
                                return string;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return string;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        e.printStackTrace();
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return stringBuffer.toString();
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    class a implements io.dcloud.common.ui.a.d {
        final /* synthetic */ Activity a;
        final /* synthetic */ b b;

        a(Activity activity, b bVar) {
            this.a = activity;
            this.b = bVar;
        }

        @Override // io.dcloud.common.ui.a.d
        public void a(String str) {
            this.a.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putString("privacy_config_version_uni_current_key", str).apply();
            SP.setBundleData(this.a, "pdr", "scok", "1");
            this.b.a();
        }

        @Override // io.dcloud.common.ui.a.d
        public void onCancel() {
            SP.setBundleData(this.a, "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            this.b.a(PrivacyManager.this.b);
            this.a.getSharedPreferences("privacy_config_uni_sp_file", 0).edit().putInt("privacy_config_choose_disagree_uni_current_key", 1).apply();
        }

        @Override // io.dcloud.common.ui.a.d
        public void a() {
            SP.setBundleData(this.a, "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            this.b.b(PrivacyManager.this.b);
        }
    }

    private static String a(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            return new String(bArr);
        } catch (Exception unused) {
            return "";
        }
    }

    private boolean a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("privacy_config_uni_sp_file", 0);
        String string = sharedPreferences.getString("privacy_config_version_uni_current_key", "emptyPrivacyVersion");
        int i = sharedPreferences.getInt("privacy_config_choose_disagree_uni_current_key", 0);
        if (!string.equals(this.b.version) && !"emptyPrivacyVersion".equals(string)) {
            sharedPreferences.edit().putInt("privacy_config_choose_disagree_uni_current_key", 0).apply();
            SP.setBundleData(context, "pdr", "scok", "");
            if (!this.b.prompt.equals("template")) {
                return false;
            }
            SP.setBundleData(context, "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            return true;
        }
        if (this.b.prompt.equals("template")) {
            AndroidPrivacyResponse.disagreeModeDTO disagreemodedto = this.b.disagreeMode;
            if (((!disagreemodedto.support && !disagreemodedto.visitorEntry) || disagreemodedto.showAlways || i != 1) && !"1".equals(SP.getBundleData(context, "pdr", "scok"))) {
                SP.setBundleData(context, "pdr", "scok", WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, Pair pair) {
        ((PrivacyAgreeCallback) pair.second).call(Boolean.valueOf(z));
    }
}
