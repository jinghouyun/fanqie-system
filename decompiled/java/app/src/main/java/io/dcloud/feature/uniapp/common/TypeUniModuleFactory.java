package io.dcloud.feature.uniapp.common;

import com.taobao.weex.WXEnvironment;
import com.taobao.weex.bridge.Invoker;
import com.taobao.weex.bridge.MethodInvoker;
import com.taobao.weex.utils.WXLogUtils;
import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniModuleFactory;
import io.dcloud.feature.uniapp.common.UniModule;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class TypeUniModuleFactory<T extends UniModule> implements UniModuleFactory<T> {
    public static final String TAG = "TypeModuleFactory";
    Class<T> mClazz;
    Map<String, Invoker> mMethodMap;

    public TypeUniModuleFactory(Class<T> cls) {
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
                    }
                }
            }
        } catch (Throwable th) {
            WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = map;
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

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() {
        return this.mClazz.newInstance();
    }
}
