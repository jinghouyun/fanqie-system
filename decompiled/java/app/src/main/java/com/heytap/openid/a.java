package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.heytap.openid.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0015a extends Binder implements a {

        /* JADX INFO: renamed from: com.heytap.openid.a$a$a, reason: collision with other inner class name */
        private static class C0016a implements a {
            public IBinder a;

            public C0016a(IBinder iBinder) {
                this.a = iBinder;
            }

            public native String a(String str, String str2, String str3);

            @Override // android.os.IInterface
            public native IBinder asBinder();
        }

        public static native a a(IBinder iBinder);
    }
}
