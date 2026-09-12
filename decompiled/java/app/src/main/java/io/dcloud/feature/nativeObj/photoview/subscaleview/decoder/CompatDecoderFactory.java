package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory
    public T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public CompatDecoderFactory(Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
