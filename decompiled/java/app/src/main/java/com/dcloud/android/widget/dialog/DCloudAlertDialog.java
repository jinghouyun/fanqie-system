package com.dcloud.android.widget.dialog;

import android.app.AlertDialog;
import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class DCloudAlertDialog extends AlertDialog {
    public static final int DARK_THEME = -999;
    public static final int LIGHT_THEME = -998;
    boolean hasNavigationBar;

    public DCloudAlertDialog(Context context, boolean z) {
        super(context);
        this.hasNavigationBar = z;
    }

    private static int getTheme(Context context, int i) {
        if (i == -998) {
            return 5;
        }
        if (i == -999) {
            return 4;
        }
        return i;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.hasNavigationBar) {
            super.show();
            return;
        }
        getWindow().addFlags(8);
        super.show();
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 4866);
        getWindow().clearFlags(8);
    }

    public DCloudAlertDialog(Context context, int i, boolean z) {
        super(context, getTheme(context, i));
        this.hasNavigationBar = z;
    }
}
