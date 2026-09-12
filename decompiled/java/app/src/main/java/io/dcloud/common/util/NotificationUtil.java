package io.dcloud.common.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.taobao.weex.common.Constants;
import io.dcloud.PdrR;
import io.dcloud.base.R;
import io.dcloud.common.adapter.util.Logger;
import io.dcloud.common.adapter.util.MobilePhoneModel;
import io.dcloud.common.constant.AbsoluteConst;
import io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class NotificationUtil {
    private static boolean isNotificationChannel = false;
    static String sChannelId = "DC_LOCAL_NEWS";
    static String sGroupId = "DC_LOCAL_GROUP";

    public static void cancelNotification(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00f2  */
    public static void createCustomNotification(Context context, String str, Bitmap bitmap, String str2, String str3, int i, PendingIntent pendingIntent) {
        Notification.Builder builder;
        String string;
        createNotificationChannel(context);
        Context applicationContext = context.getApplicationContext();
        Logger.i("createCustomNotification content=" + str3);
        int i2 = PdrR.DRAWABLE_ICON;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 26) {
            g4$$ExternalSyntheticApiModelOutline0.m$2();
            builder = g4$$ExternalSyntheticApiModelOutline0.m(applicationContext, sChannelId);
        } else {
            builder = new Notification.Builder(applicationContext);
        }
        builder.setWhen(jCurrentTimeMillis);
        builder.setSmallIcon(i2);
        builder.setTicker(str);
        builder.setLargeIcon(bitmap);
        int i3 = PdrR.LAYOUT_CUSTION_NOTIFICATION_DCLOUD;
        if (Build.BRAND.equalsIgnoreCase(MobilePhoneModel.MEIZU)) {
            i3 = PdrR.getInt(applicationContext, Constants.Name.LAYOUT, "dcloud_custom_notification_transparent");
        } else if (isMiuiRom(applicationContext)) {
            i3 = PdrR.getInt(applicationContext, Constants.Name.LAYOUT, "dcloud_custom_notification_mi");
        }
        RemoteViews remoteViews = new RemoteViews(applicationContext.getPackageName(), i3);
        remoteViews.setImageViewBitmap(PdrR.ID_IMAGE_NOTIFICATION_DCLOUD, bitmap);
        remoteViews.setTextViewText(PdrR.ID_TITLE_NOTIFICATION_DCLOUD, str2);
        remoteViews.setTextViewText(PdrR.ID_TEXT_NOTIFICATION, str3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str4 = simpleDateFormat.format(new Date());
        if (isMiuiRom(applicationContext)) {
            int i4 = simpleDateFormat.getCalendar().get(11);
            if (i4 >= 0 && i4 < 1) {
                string = applicationContext.getString(R.string.dcloud_nf_midnight);
            } else if (i4 >= 1 && i4 < 6) {
                string = applicationContext.getString(R.string.dcloud_nf_morning);
            } else if (i4 >= 6 && i4 < 12) {
                string = applicationContext.getString(R.string.dcloud_nf_forenoon);
            } else if (i4 >= 12 && i4 < 13) {
                string = applicationContext.getString(R.string.dcloud_nf_noon);
            } else if (i4 >= 13 && i4 < 18) {
                string = applicationContext.getString(R.string.dcloud_nf_afternoon);
            } else if (i4 >= 18 && i4 < 19) {
                string = applicationContext.getString(R.string.dcloud_nf_evening);
            } else if (i4 < 19 || i4 >= 24) {
                string = "";
            } else {
                string = applicationContext.getString(R.string.dcloud_nf_night);
            }
        } else {
            string = "";
        }
        remoteViews.setTextViewText(PdrR.ID_TIME_NOTIFICATION_DCLOUD, string + str4.substring(str4.length() - 8, str4.length() - 3));
        builder.setContent(remoteViews);
        builder.setContentIntent(pendingIntent);
        Notification notificationBuild = builder.build();
        notificationBuild.flags |= 16;
        ((NotificationManager) applicationContext.getSystemService("notification")).notify(i, notificationBuild);
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT < 26 || isNotificationChannel) {
            return;
        }
        isNotificationChannel = true;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        g4$$ExternalSyntheticApiModelOutline0.m462m();
        notificationManager.createNotificationChannelGroup(g4$$ExternalSyntheticApiModelOutline0.m(sGroupId, "local_badge"));
        g4$$ExternalSyntheticApiModelOutline0.m471m$1();
        NotificationChannel notificationChannelM = g4$$ExternalSyntheticApiModelOutline0.m(sChannelId, "Information notice", 3);
        notificationChannelM.enableLights(true);
        notificationChannelM.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannelM);
    }

    private static boolean isMiuiRom(Context context) {
        String property = System.getProperty("http.agent");
        return !TextUtils.isEmpty(property) && property.toLowerCase(Locale.ENGLISH).contains("miui");
    }

    public static void showNotification(Context context, String str, String str2, PendingIntent pendingIntent, Bitmap bitmap, int i) {
        Notification.Builder builder;
        createNotificationChannel(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            g4$$ExternalSyntheticApiModelOutline0.m$2();
            builder = g4$$ExternalSyntheticApiModelOutline0.m(context, sChannelId);
        } else {
            builder = new Notification.Builder(context);
        }
        try {
            builder.setSmallIcon(context.createPackageContext(context.getPackageName(), 2).getResources().getIdentifier(AbsoluteConst.JSON_KEY_ICON, android.R.drawable.class.getSimpleName(), context.getPackageName()));
        } catch (Exception unused) {
        }
        builder.setLargeIcon(bitmap);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setDefaults(1);
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        try {
            notificationManager.notify(i, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showNotification(Context context, String str, String str2, Intent intent, int i, int i2, int i3, boolean z) {
        PendingIntent broadcast;
        Notification.Builder builder;
        createNotificationChannel(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int i4 = Build.VERSION.SDK_INT;
        int i5 = i4 >= 23 ? 1140850688 : 1073741824;
        if (z) {
            broadcast = PendingIntent.getActivity(context, i3, intent, i5);
        } else {
            broadcast = PendingIntent.getBroadcast(context, i3, intent, i5);
        }
        if (i4 >= 26) {
            g4$$ExternalSyntheticApiModelOutline0.m$2();
            builder = g4$$ExternalSyntheticApiModelOutline0.m(context, sChannelId);
        } else {
            builder = new Notification.Builder(context);
        }
        if (-1 != i) {
            builder.setSmallIcon(i);
        } else {
            builder.setSmallIcon(context.getApplicationInfo().icon);
        }
        if (-1 != i2) {
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), i2));
        } else {
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setDefaults(1);
        builder.setAutoCancel(true);
        builder.setContentIntent(broadcast);
        try {
            notificationManager.notify(i3, builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
