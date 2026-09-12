package io.dcloud.feature.nativeObj.richtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.dcloudimageloader.core.ImageLoaderL;
import com.nostra13.dcloudimageloader.core.assist.FailReason;
import com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener;
import io.dcloud.common.DHInterface.ICallBack;
import io.dcloud.common.DHInterface.IFrameView;
import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.util.PdrUtil;
import io.dcloud.feature.nativeObj.INativeViewChildView;
import io.dcloud.feature.nativeObj.NativeView;
import io.dcloud.feature.nativeObj.richtext.dom.ImgDomElement;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class RichTextLayout {

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    static class DefaultAssets implements IAssets {
        boolean isClick;
        String mCallBackId;
        NativeView mNativeView;
        IWebview mWebview;

        DefaultAssets(IWebview iWebview) {
            this(iWebview, null);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public InputStream convert2InputStream(String str) {
            return this.mWebview.obtainApp().obtainResInStream(this.mWebview.obtainFullUrl(), str);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertHeight(String str, float f) {
            NativeView nativeView = this.mNativeView;
            return nativeView != null ? PdrUtil.parseFloat(str, nativeView.mInnerHeight, f, getScale()) : PdrUtil.parseFloat(str, this.mWebview.obtainApp().getInt(1), f, getScale());
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertWidth(String str, float f) {
            NativeView nativeView = this.mNativeView;
            return nativeView != null ? PdrUtil.parseFloat(str, nativeView.mInnerWidth, f, getScale()) : PdrUtil.parseFloat(str, this.mWebview.obtainApp().getInt(0), f, getScale());
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int getDefaultColor(boolean z) {
            return z ? -16776961 : -16777216;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public String getOnClickCallBackId() {
            return this.mCallBackId;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float getScale() {
            NativeView nativeView = this.mNativeView;
            return nativeView != null ? nativeView.mCreateScale : this.mWebview.getScale();
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public boolean isClick() {
            return this.isClick;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void loadResource(final ImgDomElement.AsycLoader asycLoader) {
            ImageLoaderL.getInstance().loadImage(asycLoader.url, new ImageLoadingListener() { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets.1
                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingCancelled(String str, View view) {
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                    asycLoader.onComplete(bitmap);
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingFailed(String str, View view, FailReason failReason) {
                }

                @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
                public void onLoadingStarted(String str, View view) {
                }
            });
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setClick(boolean z) {
            this.isClick = z;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setOnClickCallBackId(String str) {
            this.mCallBackId = str;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int stringToColor(String str) {
            return PdrUtil.stringToColor(str);
        }

        DefaultAssets(IWebview iWebview, NativeView nativeView) {
            this.isClick = false;
            this.mCallBackId = null;
            this.mWebview = iWebview;
            this.mNativeView = nativeView;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    public static class RichTextLayoutHolder extends LinearLayout implements IAssets, INativeViewChildView {
        public boolean isClick;
        String mCallBackId;
        DefaultAssets mDefaultAssets;
        String mItemId;
        public TextView mMainView;
        NativeView mNativeView;
        int mNativeViewHeight;
        IWebview mWebView;

        public RichTextLayoutHolder(Context context, IWebview iWebview, NativeView nativeView, String str) {
            super(context);
            this.mMainView = null;
            this.mNativeViewHeight = -2;
            this.mDefaultAssets = null;
            this.isClick = false;
            this.mCallBackId = null;
            this.mWebView = iWebview;
            this.mNativeView = nativeView;
            this.mItemId = str;
            TextView textView = new TextView(context) { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.RichTextLayoutHolder.1
                @Override // android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
                    Object tag = getTag();
                    if ((tag instanceof String) && Boolean.parseBoolean((String) tag)) {
                        return zOnTouchEvent;
                    }
                    return false;
                }
            };
            this.mMainView = textView;
            addView(textView);
            this.mDefaultAssets = new DefaultAssets(iWebview, nativeView);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public InputStream convert2InputStream(String str) {
            return this.mDefaultAssets.convert2InputStream(str);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertHeight(String str, float f) {
            return this.mDefaultAssets.convertHeight(str, f);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float convertWidth(String str, float f) {
            return this.mDefaultAssets.convertWidth(str, f);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int getDefaultColor(boolean z) {
            return this.mDefaultAssets.getDefaultColor(z);
        }

        IWebview getIWebview() {
            return this.mWebView;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public String getOnClickCallBackId() {
            return this.mCallBackId;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public float getScale() {
            return this.mNativeView.mCreateScale;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public boolean isClick() {
            return this.isClick;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void loadResource(ImgDomElement.AsycLoader asycLoader) {
            this.mDefaultAssets.loadResource(asycLoader);
        }

        @Override // io.dcloud.feature.nativeObj.INativeViewChildView
        public View obtainMainView() {
            return this.mMainView;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            int i3 = layoutParams.width;
            if (i3 != -2 && i3 != -1) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mNativeView.mInnerWidth, i3), View.MeasureSpec.getMode(i));
            }
            int i4 = layoutParams.height;
            if (i4 != -2 && i4 != -1) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mNativeViewHeight, i4), View.MeasureSpec.getMode(i2));
            }
            super.onMeasure(i, i2);
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setClick(boolean z) {
            this.isClick = z;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public void setOnClickCallBackId(String str) {
            this.mCallBackId = str;
        }

        @Override // io.dcloud.feature.nativeObj.richtext.IAssets
        public int stringToColor(String str) {
            return this.mDefaultAssets.stringToColor(str);
        }

        @Override // io.dcloud.feature.nativeObj.INativeViewChildView
        public void updateLayout() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.mNativeView.mInnerWidth, this.mNativeViewHeight);
            }
            NativeView nativeView = this.mNativeView;
            layoutParams.topMargin = nativeView.mInnerTop + (nativeView.isStatusBar() ? DeviceInfo.sStatusBarHeight : 0);
            NativeView nativeView2 = this.mNativeView;
            layoutParams.leftMargin = nativeView2.mInnerLeft;
            layoutParams.width = nativeView2.mInnerWidth;
            int i = nativeView2.mInnerHeight;
            this.mNativeViewHeight = i;
            if (i == 0 && TextUtils.equals("wrap_content", nativeView2.mStyle.optString("height"))) {
                this.mNativeViewHeight = -2;
            }
            layoutParams.height = this.mNativeViewHeight;
            setLayoutParams(layoutParams);
        }
    }

    public static RichTextLayoutHolder makeRichText(Context context, IWebview iWebview, NativeView nativeView, String str, JSONObject jSONObject, JSONObject jSONObject2, String str2) {
        return makeRichText(new RichTextLayoutHolder(context, iWebview, nativeView, str2), str, jSONObject, jSONObject2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0089  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:53:0x0102 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0104 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:56:0x010a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x010c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:59:0x0112  */
    public static RichTextLayoutHolder makeRichText(RichTextLayoutHolder richTextLayoutHolder, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        int iMin;
        int iConvertWidth;
        int iConvertWidth2;
        int iConvertHeight;
        int i;
        RichTextParser.updateFromHTML(richTextLayoutHolder, richTextLayoutHolder.mWebView, richTextLayoutHolder.mMainView, str, jSONObject2);
        richTextLayoutHolder.updateLayout();
        NativeView nativeView = richTextLayoutHolder.mNativeView;
        int i2 = nativeView.mInnerWidth;
        int i3 = nativeView.mInnerHeight;
        boolean zIsNull = jSONObject.isNull("left");
        boolean zIsNull2 = jSONObject.isNull("right");
        boolean zIsNull3 = jSONObject.isNull("top");
        boolean zIsNull4 = jSONObject.isNull("width");
        boolean zIsNull5 = jSONObject.isNull("height");
        boolean z = !zIsNull5;
        boolean zIsNull6 = jSONObject.isNull("bottom");
        int iConvertWidth3 = nativeView.mInnerLeft;
        int iConvertHeight2 = nativeView.mInnerTop;
        if (zIsNull5) {
            iMin = i3;
        } else {
            String strOptString = jSONObject.optString("height");
            if (!TextUtils.isEmpty(strOptString)) {
                if ("wrap_content".equals(strOptString)) {
                    iMin = -2;
                    z = false;
                } else {
                    iMin = (int) Math.min(richTextLayoutHolder.mNativeViewHeight, richTextLayoutHolder.convertHeight(strOptString, i3));
                }
            } else {
                iMin = nativeView.mInnerHeight;
            }
        }
        if (zIsNull4) {
            iConvertWidth = i2;
        } else {
            String strOptString2 = jSONObject.optString("width");
            if (TextUtils.isEmpty(strOptString2)) {
                iConvertWidth = i2;
            } else {
                iConvertWidth = (int) richTextLayoutHolder.convertWidth(strOptString2, i2);
            }
        }
        if (!zIsNull3) {
            String strOptString3 = jSONObject.optString("top");
            if (!TextUtils.isEmpty(strOptString3)) {
                iConvertHeight2 = (int) richTextLayoutHolder.convertHeight(strOptString3, i3);
            }
        }
        if (!zIsNull) {
            String strOptString4 = jSONObject.optString("left");
            if (!TextUtils.isEmpty(strOptString4)) {
                iConvertWidth3 = (int) richTextLayoutHolder.convertWidth(strOptString4, i2);
            }
        }
        if (zIsNull2) {
            iConvertWidth2 = 0;
        } else {
            String strOptString5 = jSONObject.optString("right");
            if (TextUtils.isEmpty(strOptString5)) {
                iConvertWidth2 = 0;
            } else {
                iConvertWidth2 = (int) richTextLayoutHolder.convertWidth(strOptString5, i2);
            }
        }
        if (zIsNull6) {
            iConvertHeight = 0;
        } else {
            String strOptString6 = jSONObject.optString("bottom");
            if (TextUtils.isEmpty(strOptString6)) {
                iConvertHeight = 0;
            } else {
                iConvertHeight = (int) richTextLayoutHolder.convertHeight(strOptString6, i3);
            }
        }
        if (zIsNull) {
            if (zIsNull4 && !zIsNull2) {
                i = -iConvertWidth2;
            } else if (!zIsNull4 && zIsNull2) {
                iConvertWidth3 = (i2 - iConvertWidth) / 2;
            } else if (!zIsNull4 && !zIsNull2) {
                iConvertWidth3 = (i2 - iConvertWidth) - iConvertWidth2;
            }
            if (zIsNull3) {
                if (z && !zIsNull6) {
                    iConvertHeight2 = -iConvertHeight;
                } else if (!z && zIsNull6) {
                    iConvertHeight2 = (i3 - iMin) / 2;
                } else if (z && !zIsNull6) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (!z && !zIsNull6) {
                iMin = (i3 - iConvertHeight2) - iConvertHeight;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iConvertWidth, iMin);
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = iConvertWidth2;
            layoutParams.bottomMargin = iConvertHeight;
            layoutParams.topMargin = iConvertHeight2;
            richTextLayoutHolder.mMainView.setLayoutParams(layoutParams);
            return richTextLayoutHolder;
        }
        if (zIsNull4 && !zIsNull2) {
            iConvertWidth = (i2 - iConvertWidth3) - iConvertWidth2;
        }
        i = iConvertWidth3;
        if (zIsNull3) {
            if (z) {
                if (!z) {
                    if (z) {
                        iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                    }
                } else if (z) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (!z) {
                if (z) {
                    iConvertHeight2 = (i3 - iMin) - iConvertHeight;
                }
            } else if (z) {
                iConvertHeight2 = (i3 - iMin) - iConvertHeight;
            }
        } else if (!z) {
            iMin = (i3 - iConvertHeight2) - iConvertHeight;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iConvertWidth, iMin);
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = iConvertWidth2;
        layoutParams2.bottomMargin = iConvertHeight;
        layoutParams2.topMargin = iConvertHeight2;
        richTextLayoutHolder.mMainView.setLayoutParams(layoutParams2);
        return richTextLayoutHolder;
    }

    public static TextView makeRichText(Object[] objArr) {
        IWebview iWebviewObtainWebView = ((IFrameView) objArr[0]).obtainWebView();
        String str = (String) objArr[1];
        JSONObject jSONObject = (JSONObject) objArr[2];
        TextView textView = new TextView(iWebviewObtainWebView.getContext());
        RichTextParser.updateFromHTML(new DefaultAssets(iWebviewObtainWebView) { // from class: io.dcloud.feature.nativeObj.richtext.RichTextLayout.1
            @Override // io.dcloud.feature.nativeObj.richtext.RichTextLayout.DefaultAssets, io.dcloud.feature.nativeObj.richtext.IAssets
            public int getDefaultColor(boolean z) {
                return z ? -16776961 : -1;
            }
        }, iWebviewObtainWebView, textView, str, jSONObject, (ICallBack) objArr[3]);
        return textView;
    }
}
