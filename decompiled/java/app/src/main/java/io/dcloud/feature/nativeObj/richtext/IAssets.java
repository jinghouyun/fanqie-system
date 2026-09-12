package io.dcloud.feature.nativeObj.richtext;

import io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public interface IAssets {
    InputStream convert2InputStream(String str);

    float convertHeight(String str, float f);

    float convertWidth(String str, float f);

    int getDefaultColor(boolean z);

    String getOnClickCallBackId();

    float getScale();

    boolean isClick();

    void loadResource(ImgDomElement.AsycLoader asycLoader);

    void setClick(boolean z);

    void setOnClickCallBackId(String str);

    int stringToColor(String str);
}
