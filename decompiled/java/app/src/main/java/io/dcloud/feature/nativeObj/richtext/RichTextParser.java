package io.dcloud.feature.nativeObj.richtext;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.facebook.common.callercontext.ContextChain;
import com.taobao.weex.el.parse.Operators;
import com.taobao.weex.ui.component.WXBasicComponentType;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.common.util.BaseInfo;
import io.dcloud.common.util.Deprecated_JSUtil;
import io.dcloud.common.util.JSUtil;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.feature.nativeObj.NativeTypefaceFactory;
import io.dcloud.feature.nativeObj.richtext.dom.DomElement;
import io.dcloud.feature.nativeObj.richtext.dom.HrDomElement;
import io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement;
import io.dcloud.feature.nativeObj.richtext.dom.TextDomElement;
import io.dcloud.feature.nativeObj.richtext.span.AHrefSpan;
import io.dcloud.feature.nativeObj.richtext.span.ClickSpanAble;
import io.dcloud.feature.nativeObj.richtext.span.ImgSpan;
import io.dcloud.feature.uniapp.adapter.AbsURIAdapter;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class RichTextParser {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class LinkMovementMethodExt extends LinkMovementMethod {
        ClickSpanAble[] downLinks = null;
        long downTime = 0;
        float downX;
        float downY;
        IAssets mAssets;
        ICallBack mObserver;
        IWebview mWebview;

        LinkMovementMethodExt(IWebview iWebview, ICallBack iCallBack, IAssets iAssets) {
            this.mWebview = iWebview;
            this.mObserver = iCallBack;
            this.mAssets = iAssets;
        }

        /* JADX WARN: Code duplicated, block: B:68:0x0131  */
        /* JADX WARN: Code duplicated, block: B:70:0x0136  */
        /* JADX WARN: Code duplicated, block: B:78:0x014e  */
        /* JADX WARN: Code duplicated, block: B:90:0x0174  */
        /* JADX WARN: Code duplicated, block: B:93:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:94:0x01c5  */
        /* JADX WARN: Code duplicated, block: B:95:0x01cc  */
        /* JADX WARN: Code duplicated, block: B:97:0x01cf A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:98:0x01d0  */
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            ClickSpanAble[] clickSpanAbleArr;
            boolean z;
            String str;
            String href;
            String str2;
            ClickSpanAble clickSpanAble;
            String str3;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = x - textView.getTotalPaddingLeft();
            int totalPaddingTop = y - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
            Rect rect = new Rect((int) layout.getLineLeft(lineForVertical), layout.getLineTop(lineForVertical), (int) layout.getLineRight(lineForVertical), layout.getLineBottom(lineForVertical));
            textView.setTag(AbsoluteConst.FALSE);
            boolean z2 = true;
            if (rect.contains(scrollX, scrollY)) {
                ClickSpanAble[] clickSpanAbleArr2 = (ClickSpanAble[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickSpanAble.class);
                if (clickSpanAbleArr2 != null && clickSpanAbleArr2.length != 0) {
                    if (action == 1) {
                        ClickSpanAble[] clickSpanAbleArr3 = this.downLinks;
                        if (clickSpanAbleArr3 != null && clickSpanAbleArr3.length >= clickSpanAbleArr2.length && !this.mAssets.isClick()) {
                            int i = 0;
                            while (true) {
                                if (i < clickSpanAbleArr2.length) {
                                    ClickSpanAble clickSpanAble2 = clickSpanAbleArr2[i];
                                    if (clickSpanAble2 == this.downLinks[i]) {
                                        int spanFlags = spannable.getSpanFlags(clickSpanAble2);
                                        int spanStart = spannable.getSpanStart(clickSpanAble2);
                                        int spanEnd = spannable.getSpanEnd(clickSpanAble2);
                                        if (spanStart == 0 || spanEnd == spannable.length() || clickSpanAbleArr2.length == 1) {
                                            spanFlags = 18;
                                        }
                                        if ((spanFlags == 17 && offsetForHorizontal >= spanStart && offsetForHorizontal < spanEnd) || ((spanFlags == 18 && offsetForHorizontal >= spanStart && offsetForHorizontal <= spanEnd) || ((spanFlags == 33 && offsetForHorizontal > spanStart && offsetForHorizontal < spanEnd) || (spanFlags == 34 && offsetForHorizontal > spanStart && offsetForHorizontal <= spanEnd)))) {
                                            clickSpanAble2.onClick(textView, this.mWebview);
                                            ICallBack iCallBack = this.mObserver;
                                            if (iCallBack != null) {
                                                iCallBack.onCallBack(0, clickSpanAble2);
                                            }
                                        }
                                    }
                                    i++;
                                }
                            }
                        }
                        this.downLinks = null;
                    } else if (action == 0) {
                        this.downLinks = clickSpanAbleArr2;
                        this.downX = motionEvent.getX();
                        this.downY = motionEvent.getY();
                    } else if (action == 2 && (Math.abs(motionEvent.getX() - this.downX) > 20.0f || Math.abs(motionEvent.getY() - this.downY) > 20.0f)) {
                        this.downLinks = null;
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 < clickSpanAbleArr2.length) {
                            if (clickSpanAbleArr2[i2].hasClickEvent()) {
                                textView.setTag(AbsoluteConst.TRUE);
                                clickSpanAbleArr = clickSpanAbleArr2;
                                z = true;
                            } else {
                                i2++;
                            }
                        }
                        if (this.mAssets.isClick()) {
                            textView.setTag(AbsoluteConst.TRUE);
                            if (action != 0) {
                                this.downTime = System.currentTimeMillis();
                            } else if ((action != 1 || action == 3) && System.currentTimeMillis() - this.downTime < 800) {
                                String src = "";
                                if (clickSpanAbleArr != null || clickSpanAbleArr.length <= 0 || (clickSpanAble = clickSpanAbleArr[0]) == null) {
                                    str = "";
                                    href = str;
                                } else {
                                    href = clickSpanAble.getHref();
                                    if (clickSpanAble instanceof ImgSpan) {
                                        src = ((ImgSpan) clickSpanAble).getSrc();
                                        str3 = WXBasicComponentType.IMG;
                                    } else if (clickSpanAble instanceof AHrefSpan) {
                                        str3 = "a";
                                    } else {
                                        str = "";
                                    }
                                    String str4 = str3;
                                    str = src;
                                    src = str4;
                                }
                                str2 = "{\"tagName\":\"" + src + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                                Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                                if (this.mWebview.getOpener() != null) {
                                    Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                                }
                            }
                        } else {
                            z2 = z;
                        }
                        if (z2) {
                            return z2;
                        }
                        return super.onTouchEvent(textView, spannable, motionEvent);
                    }
                }
                clickSpanAbleArr = clickSpanAbleArr2;
            } else {
                clickSpanAbleArr = null;
            }
            z = false;
            if (this.mAssets.isClick()) {
                textView.setTag(AbsoluteConst.TRUE);
                if (action != 0) {
                    this.downTime = System.currentTimeMillis();
                } else if (action != 1) {
                    String src2 = "";
                    if (clickSpanAbleArr != null) {
                        str = "";
                        href = str;
                    } else {
                        str = "";
                        href = str;
                    }
                    str2 = "{\"tagName\":\"" + src2 + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                    Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                    if (this.mWebview.getOpener() != null) {
                        Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                    }
                } else {
                    String src3 = "";
                    if (clickSpanAbleArr != null) {
                        str = "";
                        href = str;
                    } else {
                        str = "";
                        href = str;
                    }
                    str2 = "{\"tagName\":\"" + src3 + "\",\"href\":\"" + href + "\",\"src\":\"" + str + "\"}";
                    Deprecated_JSUtil.execCallback(this.mWebview, this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                    if (this.mWebview.getOpener() != null) {
                        Deprecated_JSUtil.execCallback(this.mWebview.getOpener(), this.mAssets.getOnClickCallBackId(), str2, JSUtil.OK, true, true);
                    }
                }
            } else {
                z2 = z;
            }
            if (z2) {
                return z2;
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    private static void handleEndTag(IAssets iAssets, TextView textView, SpannableStringBuilder spannableStringBuilder, DomElement domElement) {
        domElement.makeSpan(iAssets, textView, spannableStringBuilder);
    }

    private static DomElement handleStartTag(XmlPullParser xmlPullParser) {
        DomElement textDomElement;
        String name = xmlPullParser.getName();
        if (name.equalsIgnoreCase("script") || name.equalsIgnoreCase(AbsURIAdapter.LINK) || name.equalsIgnoreCase("iframe") || name.equalsIgnoreCase("style") || name.equalsIgnoreCase("meta")) {
            return null;
        }
        if (WXBasicComponentType.IMG.equalsIgnoreCase(name)) {
            textDomElement = new ImgDomElement();
        } else if ("hr".equalsIgnoreCase(name)) {
            textDomElement = new HrDomElement();
        } else if ("br".equalsIgnoreCase(name)) {
            textDomElement = new DomElement();
        } else {
            textDomElement = ("a".equalsIgnoreCase(name) || AbsURIAdapter.FONT.equalsIgnoreCase(name) || ContextChain.TAG_PRODUCT.equalsIgnoreCase(name)) ? new TextDomElement() : new TextDomElement();
        }
        textDomElement.parseDomElement(xmlPullParser);
        return textDomElement;
    }

    static SpannableStringBuilder makeSpannableStringBuilder(IAssets iAssets, TextView textView, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            int eventType = xmlPullParserNewPullParser.getEventType();
            DomElement domElementHandleStartTag = null;
            DomElement domElement = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    try {
                        System.out.print("Start document");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (XmlPullParserException e2) {
                        e2.printStackTrace();
                    }
                } else if (eventType == 2) {
                    System.out.println("start-tag=<" + xmlPullParserNewPullParser.getName() + Operators.G);
                    domElementHandleStartTag = handleStartTag(xmlPullParserNewPullParser);
                    if (domElementHandleStartTag != null) {
                        domElementHandleStartTag.parentDomElement = domElement;
                        domElement = domElementHandleStartTag;
                    }
                } else if (eventType == 3) {
                    System.out.println("end-tag=</" + xmlPullParserNewPullParser.getName() + Operators.G);
                    if (domElementHandleStartTag != null) {
                        if (!(domElementHandleStartTag instanceof TextDomElement) || ((domElementHandleStartTag instanceof TextDomElement) && TextUtils.isEmpty(((TextDomElement) domElementHandleStartTag).text))) {
                            handleEndTag(iAssets, textView, spannableStringBuilder, domElementHandleStartTag);
                        }
                        domElementHandleStartTag = domElementHandleStartTag.parentDomElement;
                        domElement = domElementHandleStartTag;
                    }
                } else if (eventType == 4) {
                    System.out.println("[Text:" + xmlPullParserNewPullParser.getText() + Operators.ARRAY_END_STR);
                    if (domElementHandleStartTag != null && (domElementHandleStartTag instanceof TextDomElement)) {
                        ((TextDomElement) domElementHandleStartTag).text = xmlPullParserNewPullParser.getText();
                        if (!TextUtils.isEmpty(((TextDomElement) domElementHandleStartTag).text)) {
                            handleEndTag(iAssets, textView, spannableStringBuilder, domElementHandleStartTag);
                        }
                    }
                }
                eventType = xmlPullParserNewPullParser.next();
            }
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
        return spannableStringBuilder;
    }

    static void updateFromHTML(IAssets iAssets, IWebview iWebview, TextView textView, String str, JSONObject jSONObject) {
        updateFromHTML(iAssets, iWebview, textView, str, jSONObject, null);
    }

    static void updateFromHTML(IAssets iAssets, IWebview iWebview, TextView textView, String str, JSONObject jSONObject, ICallBack iCallBack) {
        String strConvert2AbsFullPath;
        Typeface typefaceCreate;
        if (jSONObject != null) {
            if (jSONObject.has("family") && (typefaceCreate = Typeface.create(jSONObject.optString("family"), 0)) != null) {
                textView.setTypeface(typefaceCreate);
            }
            if (jSONObject.has("__onClickCallBackId__") && !PdrUtil.isEmpty(jSONObject.optString("__onClickCallBackId__"))) {
                iAssets.setClick(true);
                iAssets.setOnClickCallBackId(jSONObject.optString("__onClickCallBackId__"));
            }
            if (jSONObject.has("fontSrc")) {
                String strOptString = jSONObject.optString("fontSrc", "");
                if (strOptString.contains("__wap2app.ttf")) {
                    strConvert2AbsFullPath = BaseInfo.sBaseWap2AppTemplatePath + "wap2app__template/__wap2app.ttf";
                    if (!new File(strConvert2AbsFullPath).exists()) {
                        strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                    }
                } else {
                    strConvert2AbsFullPath = iWebview.obtainApp().convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                }
                Typeface typeface = NativeTypefaceFactory.getTypeface(iWebview.obtainApp(), strConvert2AbsFullPath);
                if (typeface != null) {
                    textView.setTypeface(typeface);
                }
            }
            if (jSONObject.has(AbsoluteConst.JSON_KEY_ALIGN)) {
                String strOptString2 = jSONObject.optString(AbsoluteConst.JSON_KEY_ALIGN, "");
                if ("center".equalsIgnoreCase(strOptString2)) {
                    textView.setGravity(1);
                } else if ("right".equalsIgnoreCase(strOptString2)) {
                    textView.setGravity(5);
                } else {
                    textView.setGravity(3);
                }
            }
        }
        textView.setText(makeSpannableStringBuilder(iAssets, textView, str.replaceAll("&nbsp", Operators.SPACE_STR)));
        textView.setMovementMethod(new LinkMovementMethodExt(iWebview, iCallBack, iAssets));
    }
}
