package io.dcloud.nineoldandroids.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IntProperty<T> extends Property<T, Integer> {
    public abstract void setValue(T t, int i);

    public IntProperty(String str) {
        super(Integer.class, str);
    }

    @Override // io.dcloud.nineoldandroids.util.Property
    public final void set(T t, Integer num) {
        num.intValue();
        set((Object) t, num);
    }
}
