package io.dcloud.p;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e2 {
    private Uri a;

    public e2(Uri uri) {
        this.a = uri;
    }

    public abstract Bitmap a(BitmapFactory.Options options);

    public Uri a() {
        return this.a;
    }
}
