package io.dcloud.common.util;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DCFileUriData {
    public String filePath;
    public String fileReplacePath;
    public Uri fileUri;
    public boolean isReplace = false;

    public void clear() {
        if (this.fileUri != null) {
            this.fileUri = null;
        }
        if (!TextUtils.isEmpty(this.filePath)) {
            this.filePath = null;
        }
        if (TextUtils.isEmpty(this.fileReplacePath)) {
            return;
        }
        this.fileReplacePath = null;
    }
}
