package io.dcloud.feature.uniapp.adapter;

import android.net.Uri;
import com.taobao.weex.WXSDKInstance;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public interface AbsURIAdapter {
    public static final String BUNDLE = "bundle";
    public static final String FILE = "file";
    public static final String FONT = "font";
    public static final String IMAGE = "image";
    public static final String LINK = "link";
    public static final String OTHERS = "others";
    public static final String REQUEST = "request";
    public static final String VIDEO = "video";
    public static final String WEB = "web";

    Uri rewrite(WXSDKInstance wXSDKInstance, String str, Uri uri);

    Uri rewrite(String str, String str2, Uri uri);
}
