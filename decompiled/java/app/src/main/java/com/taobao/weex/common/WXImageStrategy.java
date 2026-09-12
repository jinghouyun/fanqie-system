package com.taobao.weex.common;

import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class WXImageStrategy {
    public int blurRadius;
    ImageListener imageListener;
    public String instanceId;
    boolean isAutoCompression = true;

    @Deprecated
    public boolean isClipping;
    public boolean isSharpen;
    public String placeHolder;

    /* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
    public interface ImageListener {
        void onImageFinish(String str, ImageView imageView, boolean z, Map map);
    }

    public WXImageStrategy() {
    }

    public ImageListener getImageListener() {
        return this.imageListener;
    }

    public boolean isAutoCompression() {
        return this.isAutoCompression;
    }

    public void setAutoCompression(boolean z) {
        this.isAutoCompression = z;
    }

    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
    }

    public WXImageStrategy(String str) {
        this.instanceId = str;
    }
}
