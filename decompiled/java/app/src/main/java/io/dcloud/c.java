package io.dcloud;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
class c extends BroadcastReceiver {
    io.dcloud.feature.internal.reflect.BroadcastReceiver a;
    IntentFilter b;

    c(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.a = broadcastReceiver;
        this.b = intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IntentFilter intentFilter;
        if (this.a == null || (intentFilter = this.b) == null || !intentFilter.hasAction(intent.getAction())) {
            return;
        }
        this.a.onReceive(context, intent);
    }
}
