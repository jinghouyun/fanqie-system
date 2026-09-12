package com.taobao.weex.ui.component;

import android.text.TextUtils;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXEditText;
import com.taobao.weex.utils.WXUtils;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public class Textarea extends AbstractEditComponent {
    public static final int DEFAULT_ROWS = 2;
    private int mNumberOfLines;

    public Textarea(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mNumberOfLines = 2;
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected void appleStyleAfterCreated(WXEditText wXEditText) {
        int i;
        super.appleStyleAfterCreated(wXEditText);
        String str = (String) getStyles().get(Constants.Name.ROWS);
        try {
            i = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : 2;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        wXEditText.setLines(i);
        wXEditText.setMinLines(i);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected float getMeasureHeight() {
        return getMeasuredLineHeight() * this.mNumberOfLines;
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected int getVerticalGravity() {
        return 48;
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent, com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(String str, Object obj) {
        str.getClass();
        if (!str.equals(Constants.Name.ROWS)) {
            return super.setProperty(str, obj);
        }
        Integer integer = WXUtils.getInteger(obj, null);
        if (integer == null) {
            return true;
        }
        setRows(integer.intValue());
        return true;
    }

    @WXComponentProp(name = Constants.Name.ROWS)
    public void setRows(int i) {
        WXEditText hostView = getHostView();
        if (hostView == null || i <= 0) {
            return;
        }
        hostView.setLines(i);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected void updateStyleAndAttrs() {
        super.updateStyleAndAttrs();
        Object obj = getAttrs().get(Constants.Name.ROWS);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Integer) {
                this.mNumberOfLines = ((Integer) obj).intValue();
                return;
            }
            return;
        }
        try {
            int i = Integer.parseInt((String) obj);
            if (i > 0) {
                this.mNumberOfLines = i;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.AbstractEditComponent, com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(WXEditText wXEditText) {
        wXEditText.setAllowDisableMovement(false);
        super.onHostViewInitialized(wXEditText);
    }
}
