package com.taobao.weex;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.media.ExifInterface;
import java.io.FileDescriptor;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WXSDKInstance$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source m(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AnimatedImageDrawable m387m(Object obj) {
        return (AnimatedImageDrawable) obj;
    }

    public static /* synthetic */ ExifInterface m(FileDescriptor fileDescriptor) {
        return new ExifInterface(fileDescriptor);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m390m() {
        return OptionalLong.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Optional m393m(Object obj) {
        return (Optional) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ OptionalInt m396m(Object obj) {
        return (OptionalInt) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ OptionalLong m399m(Object obj) {
        return (OptionalLong) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ DoubleAdder m400m(Object obj) {
        return (DoubleAdder) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ LongAdder m401m(Object obj) {
        return (LongAdder) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m407m(Object obj) {
        return obj instanceof OptionalInt;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m411m$1() {
        return OptionalDouble.class;
    }

    public static /* bridge */ /* synthetic */ boolean m$1(Object obj) {
        return obj instanceof Optional;
    }

    public static /* bridge */ /* synthetic */ boolean m$2(Object obj) {
        return obj instanceof OptionalLong;
    }

    public static /* bridge */ /* synthetic */ boolean m$3(Object obj) {
        return obj instanceof LongAdder;
    }

    public static /* bridge */ /* synthetic */ boolean m$4(Object obj) {
        return obj instanceof DoubleAdder;
    }

    public static /* bridge */ /* synthetic */ boolean m$5(Object obj) {
        return obj instanceof AnimatedImageDrawable;
    }
}
