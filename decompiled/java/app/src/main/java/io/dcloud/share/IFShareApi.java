package io.dcloud.share;

import io.dcloud.common.DHInterface.IReflectAble;
import io.dcloud.common.DHInterface.IWebview;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes2.dex */
public interface IFShareApi extends IReflectAble {
    public static final String mLink = "https://ask.dcloud.net.cn/article/287";

    void authorize(IWebview iWebview, String str, String str2);

    void dispose();

    void forbid(IWebview iWebview);

    String getId();

    String getJsonObject(IWebview iWebview);

    void initConfig();

    void send(IWebview iWebview, String str, String str2);
}
