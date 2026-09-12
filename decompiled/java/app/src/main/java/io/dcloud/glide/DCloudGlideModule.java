package io.dcloud.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DCloudGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(Context context, Glide glide, Registry registry) {
        Iterator<ImageHeaderParser> it = registry.getImageHeaderParsers().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof ExifInterfaceImageHeaderParser) {
                it.remove();
            }
        }
        registry.register(new PrivacyAwareExifInterfaceImageHeaderParser());
    }
}
