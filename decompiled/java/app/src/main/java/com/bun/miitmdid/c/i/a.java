package com.bun.miitmdid.c.i;

import android.content.Context;
import com.bun.supplier.InnerIdSupplier;
import com.bun.supplier.SupplierListener;
import com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: loaded from: classes.dex */
public class a implements InnerIdSupplier {
    private Context a;

    /* JADX INFO: renamed from: com.bun.miitmdid.c.i.a$a, reason: collision with other inner class name */
    class RunnableC0012a implements Runnable {
        final /* synthetic */ SupplierListener a;

        RunnableC0012a(SupplierListener supplierListener) {
            this.a = supplierListener;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    public a(Context context) {
        OpenIDSDK.d(context);
        this.a = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    public native void a(SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    public native boolean a();

    @Override // com.bun.supplier.IdSupplier
    public native String getAAID();

    @Override // com.bun.supplier.IdSupplier
    public native String getOAID();

    @Override // com.bun.supplier.InnerIdSupplier
    public native String getUDID();

    @Override // com.bun.supplier.IdSupplier
    public native String getVAID();

    @Override // com.bun.supplier.IdSupplier
    public native boolean isSupported();

    @Override // com.bun.supplier.InnerIdSupplier
    public native void shutDown();
}
