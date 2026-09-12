package io.dcloud.feature.pdr;

import com.taobao.weex.common.WXConfig;
import io.dcloud.common.DHInterface.AbsMgr;
import io.dcloud.common.DHInterface.IFeature;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.io.DHFile;
import io.dcloud.p.z2;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class LoggerFeatureImpl implements IFeature {
    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public String execute(IWebview iWebview, String str, String[] strArr) throws Throwable {
        if (!str.equals(WXConfig.logLevel)) {
            if (!str.equals("clear")) {
                return null;
            }
            try {
                DHFile.deleteFile(iWebview.obtainFrameView().obtainApp().obtainAppLog());
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        z2.a(iWebview.obtainFrameView().obtainApp().obtainAppLog());
        if (strArr[0].equals("LOG")) {
            z2.d("LOG", strArr[1]);
            return null;
        }
        if (strArr[0].equals("ERROR")) {
            z2.e("ERROR", strArr[1]);
            return null;
        }
        if (strArr[0].equals("WARN")) {
            z2.a("WARN", strArr[1]);
            return null;
        }
        if (strArr[0].equals("INFO")) {
            z2.i("INFO", strArr[1]);
            return null;
        }
        strArr[0].equals("ASSERT");
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(AbsMgr absMgr, String str) {
    }
}
