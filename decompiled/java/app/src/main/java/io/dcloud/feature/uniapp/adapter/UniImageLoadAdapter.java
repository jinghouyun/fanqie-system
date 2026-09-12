package io.dcloud.feature.uniapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import io.dcloud.feature.uniapp.utils.bitmap.BitmapLoadCallback;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public interface UniImageLoadAdapter {
    void loadImageBitmap(Context context, String str, int i, int i2, BitmapLoadCallback<Bitmap> bitmapLoadCallback);

    void loadImageBitmap(Context context, String str, BitmapLoadCallback<Bitmap> bitmapLoadCallback);
}
