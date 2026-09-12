package com.taobao.weex.ui.module;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.el.parse.Operators;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXLocaleModule extends WXModule {
    private String getLanguageImpl() {
        Locale locale = Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault();
        return locale.getLanguage() + Operators.SUB + locale.getCountry();
    }

    private String getLanguageTags() {
        Resources resources;
        Configuration configuration;
        Application application = WXEnvironment.getApplication();
        if (application == null || (resources = application.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return configuration.getLocales().toLanguageTags();
        }
        Locale locale = configuration.locale;
        return locale != null ? toLanguageTag(locale) : "";
    }

    @JSMethod(uiThread = false)
    public void getLanguage(JSCallback jSCallback) {
        jSCallback.invoke(getLanguageImpl());
    }

    @JSMethod(uiThread = false)
    public String getLanguageSync() {
        return getLanguageImpl();
    }

    @JSMethod(uiThread = false)
    public List<String> getLanguages() {
        return Arrays.asList(getLanguageTags().split(","));
    }

    private String toLanguageTag(Locale locale) {
        return locale.toLanguageTag();
    }

    @JSMethod(uiThread = false)
    public void getLanguages(JSCallback jSCallback) {
        jSCallback.invoke(getLanguageTags().split(","));
    }
}
