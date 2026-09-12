package io.dcloud.uts.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes2.dex */
final class PreJava9ReflectionAccessor extends ReflectionAccessor {
    PreJava9ReflectionAccessor() {
    }

    @Override // io.dcloud.uts.gson.internal.reflect.ReflectionAccessor
    public void makeAccessible(AccessibleObject accessibleObject) {
        accessibleObject.setAccessible(true);
    }
}
