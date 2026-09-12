package com.taobao.weex.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ImgURIUtil {
    public static Drawable getDrawableFromLoaclSrc(Context context, Uri uri) {
        Resources resources = context.getResources();
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 1) {
            WXLogUtils.e("Local src format is invalid.");
            return null;
        }
        int identifier = resources.getIdentifier(pathSegments.get(0), "drawable", context.getPackageName());
        if (identifier == 0) {
            return null;
        }
        return ResourcesCompat.getDrawable(resources, identifier, null);
    }
}
