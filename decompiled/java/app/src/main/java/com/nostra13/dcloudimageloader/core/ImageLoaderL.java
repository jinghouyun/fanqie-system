package com.nostra13.dcloudimageloader.core;

import com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener;
import com.nostra13.dcloudimageloader.core.assist.SimpleImageLoadingListener;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class ImageLoaderL extends ImageLoader {
    private static volatile ImageLoaderL instance;
    private ImageLoaderConfiguration configuration;
    private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;

    protected ImageLoaderL() {
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
    }

    public static ImageLoaderL getInstance() {
        if (instance == null) {
            synchronized (ImageLoaderL.class) {
                if (instance == null) {
                    instance = new ImageLoaderL();
                }
            }
        }
        return instance;
    }
}
