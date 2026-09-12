package io.dcloud.feature.pdr;

import android.content.SharedPreferences;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class CoreCacheFeatureImpl implements IFeature {
    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) {
        if (str.equals("clear")) {
            try {
                DHFile.deleteFile(iWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
                DHFile.delete(iWebview.getContext().getCacheDir());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Deprecated_JSUtil.excCallbackSuccess(iWebview, strArr[0], "");
            return null;
        }
        if (str.equals("calculate")) {
            File file = new File(iWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
            JSUtil.execCallback(iWebview, strArr[0], (file.exists() ? DHFile.getFileSize(file) : 0L) + DHFile.getFileSize(iWebview.getContext().getCacheDir()), JSUtil.OK, false);
            return null;
        }
        if (!str.equals("setMaxSize")) {
            return null;
        }
        long j = Long.parseLong(strArr[0]);
        SharedPreferences.Editor editorEdit = iWebview.getContext().getSharedPreferences(iWebview.obtainFrameView().obtainApp().obtainAppId(), 0).edit();
        editorEdit.putLong("maxSize", j);
        editorEdit.commit();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
    }
}
