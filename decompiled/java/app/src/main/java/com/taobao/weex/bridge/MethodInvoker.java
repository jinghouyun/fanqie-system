package com.taobao.weex.bridge;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class MethodInvoker implements Invoker {
    final Method mMethod;
    Type[] mParam;
    final boolean mRunOnUIThread;

    public MethodInvoker(Method method) {
        this(method, false);
    }

    @Override // com.taobao.weex.bridge.Invoker
    public Type[] getParameterTypes() {
        if (this.mParam == null) {
            this.mParam = this.mMethod.getGenericParameterTypes();
        }
        return this.mParam;
    }

    @Override // com.taobao.weex.bridge.Invoker
    public Object invoke(Object obj, Object... objArr) {
        return this.mMethod.invoke(obj, objArr);
    }

    @Override // com.taobao.weex.bridge.Invoker
    public boolean isRunOnUIThread() {
        return this.mRunOnUIThread;
    }

    public String toString() {
        return this.mMethod.getName();
    }

    public MethodInvoker(Method method, boolean z) {
        this.mMethod = method;
        this.mParam = method.getGenericParameterTypes();
        this.mRunOnUIThread = z;
    }
}
