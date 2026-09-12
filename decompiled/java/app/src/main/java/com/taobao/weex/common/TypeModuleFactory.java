package com.taobao.weex.common;

import com.taobao.weex.WXEnvironment;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;
import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.common.UniModuleAnno;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class TypeModuleFactory<T extends WXModule> implements ModuleFactory<T> {
    public static final String TAG = "TypeModuleFactory";
    Class<T> mClazz;
    Map<String, Invoker> mMethodMap;

    public TypeModuleFactory(Class<T> cls) {
        this.mClazz = cls;
    }

    private void generateMethodMap() {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("TypeModuleFactory", "extractMethodNames:" + this.mClazz.getSimpleName());
        }
        HashMap map = new HashMap();
        try {
            for (Method method : this.mClazz.getMethods()) {
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation != null) {
                        if (!(annotation instanceof JSMethod)) {
                            if (!(annotation instanceof WXModuleAnno)) {
                                if (!(annotation instanceof UniJSMethod)) {
                                    if (annotation instanceof UniModuleAnno) {
                                        map.put(method.getName(), new MethodInvoker(method, ((UniModuleAnno) annotation).runOnUIThread()));
                                        break;
                                    }
                                } else {
                                    UniJSMethod uniJSMethod = (UniJSMethod) annotation;
                                    map.put("_".equals(uniJSMethod.alias()) ? method.getName() : uniJSMethod.alias(), new MethodInvoker(method, uniJSMethod.uiThread()));
                                    break;
                                }
                            } else {
                                map.put(method.getName(), new MethodInvoker(method, ((WXModuleAnno) annotation).runOnUIThread()));
                                break;
                            }
                        } else {
                            JSMethod jSMethod = (JSMethod) annotation;
                            map.put("_".equals(jSMethod.alias()) ? method.getName() : jSMethod.alias(), new MethodInvoker(method, jSMethod.uiThread()));
                            break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = map;
    }

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() {
        return this.mClazz.newInstance();
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public Invoker getMethodInvoker(String str) {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        return this.mMethodMap.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public String[] getMethods() {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        Set<String> setKeySet = this.mMethodMap.keySet();
        return (String[]) setKeySet.toArray(new String[setKeySet.size()]);
    }
}
