package io.dcloud.feature.uniapp;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes2.dex */
public class UniSDKInstance extends WXSDKInstance {
    private boolean isCompilerWithUniapp;

    public UniSDKInstance(Context context) {
        super(context);
        this.isCompilerWithUniapp = true;
    }

    @Override // com.taobao.weex.WXSDKInstance, io.dcloud.feature.uniapp.AbsSDKInstance
    public boolean isCompilerWithUniapp() {
        return this.isCompilerWithUniapp;
    }

    public void setCompilerWithUniapp(boolean z) {
        this.isCompilerWithUniapp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.WXSDKInstance
    public UniSDKInstance newNestedInstance() {
        return new UniSDKInstance(this.mContext);
    }

    public UniSDKInstance(Context context, Context context2) {
        super(context, context2);
        this.isCompilerWithUniapp = true;
    }

    public UniSDKInstance() {
        this.isCompilerWithUniapp = true;
    }

    public UniSDKInstance(Context context, String str) {
        super(context, str);
        this.isCompilerWithUniapp = true;
    }
}
