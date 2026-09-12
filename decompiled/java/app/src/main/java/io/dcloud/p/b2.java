package io.dcloud.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class b2 extends e2 {
    private Context b;

    public b2(Context context, Uri uri) {
        super(uri);
        this.b = context;
    }

    @Override // io.dcloud.p.e2
    public Bitmap a(BitmapFactory.Options options) {
        Uri uriA = a();
        if (uriA == null) {
            return null;
        }
        String path = uriA.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            InputStream inputStreamOpen = this.b.getAssets().open(path.substring(1));
            return options.inJustDecodeBounds ? BitmapFactory.decodeStream(inputStreamOpen, null, options) : z.a(inputStreamOpen, options);
        } catch (IOException unused) {
            return null;
        }
    }
}
