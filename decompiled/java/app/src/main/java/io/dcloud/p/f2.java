package io.dcloud.p;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public class f2 extends e2 {
    public f2(Uri uri) {
        super(uri);
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
        File file = new File(path);
        if (file.exists()) {
            return options.inJustDecodeBounds ? BitmapFactory.decodeFile(path, options) : z.a(file, options);
        }
        return null;
    }
}
