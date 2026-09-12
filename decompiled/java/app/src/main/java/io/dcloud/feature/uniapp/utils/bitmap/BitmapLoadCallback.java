package io.dcloud.feature.uniapp.utils.bitmap;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public interface BitmapLoadCallback<T> {
    void onFailure(String str, Throwable th);

    void onSuccess(String str, T t);
}
