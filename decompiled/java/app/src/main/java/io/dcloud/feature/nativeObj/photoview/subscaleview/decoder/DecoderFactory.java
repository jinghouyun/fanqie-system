package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
}
