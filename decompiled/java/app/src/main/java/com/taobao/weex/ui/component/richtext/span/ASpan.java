package com.taobao.weex.ui.component.richtext.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.taobao.weex.utils.ATagUtil;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class ASpan extends ClickableSpan {
    private String mInstanceId;
    private String mURL;

    public ASpan(String str, String str2) {
        this.mInstanceId = str;
        this.mURL = str2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        ATagUtil.onClick(view, this.mInstanceId, this.mURL);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }
}
