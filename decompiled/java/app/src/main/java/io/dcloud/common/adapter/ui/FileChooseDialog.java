package io.dcloud.common.adapter.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.hjq.permissions.Permission;
import io.dcloud.base.R;
import io.dcloud.common.adapter.util.DeviceInfo;
import io.dcloud.common.adapter.util.PermissionUtil;
import io.dcloud.common.util.PdrUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class FileChooseDialog extends Dialog {
    private Activity activity;
    private int onedp;
    private int onesp;
    public List<File> uris;

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class GridAdapter extends BaseAdapter {
        private Context context;
        private List<Item> items;

        /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
        private class ViewHolder {
            ImageView iv;
            TextView tv;

            private ViewHolder() {
            }
        }

        GridAdapter(Context context, List<Item> list) {
            this.context = context;
            this.items = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.items.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.items.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = FileChooseDialog.this.createView(this.context, this.items.get(i));
                viewHolder = new ViewHolder();
                ViewGroup viewGroup2 = (ViewGroup) view;
                viewHolder.iv = (ImageView) viewGroup2.getChildAt(0);
                viewHolder.tv = (TextView) viewGroup2.getChildAt(1);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.iv.setImageDrawable(this.items.get(i).icon);
            viewHolder.tv.setText(this.items.get(i).name);
            return view;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
    private class Item {
        Intent i;
        Drawable icon;
        String name;

        Item(String str, Drawable drawable, Intent intent) {
            this.name = str;
            this.icon = drawable;
            this.i = intent;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x01d9 A[LOOP:1: B:21:0x01d3->B:23:0x01d9, LOOP_END] */
    public FileChooseDialog(Context context, Activity activity, Intent intent) {
        Intent intent2;
        String str;
        PackageManager packageManager;
        GridView gridView;
        PackageManager packageManager2;
        super(context);
        requestWindowFeature(1);
        this.activity = activity;
        this.uris = new ArrayList();
        this.onedp = PdrUtil.pxFromDp(1.0f, getContext().getApplicationContext().getResources().getDisplayMetrics());
        this.onesp = PdrUtil.pxFromSp(1.0f, getContext().getApplicationContext().getResources().getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(R.string.dcloud_choose_an_action);
        textView.setTextSize(this.onesp * 5);
        textView.setTextColor(-16777216);
        textView.getPaint().setFakeBoldText(true);
        textView.setGravity(17);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        GridView gridView2 = new GridView(context);
        gridView2.setHorizontalSpacing(this.onedp * 10);
        gridView2.setVerticalSpacing(this.onedp * 10);
        gridView2.setNumColumns(4);
        int i = this.onedp * 20;
        gridView2.setPadding(0, i, 0, i);
        linearLayout.addView(gridView2, new LinearLayout.LayoutParams(-1, -2));
        View view = new View(context);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new ViewGroup.LayoutParams(-1, this.onedp));
        Button button = new Button(context);
        button.setPadding(button.getPaddingLeft(), this.onedp * 15, button.getPaddingRight(), this.onedp * 15);
        button.setBackground(null);
        button.setText(android.R.string.cancel);
        button.setOnClickListener(new View.OnClickListener() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FileChooseDialog.this.cancel();
            }
        });
        button.setGravity(17);
        linearLayout.addView(button, new LinearLayout.LayoutParams(-1, -2));
        setContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
        if (intent.getType().startsWith("video/")) {
            intent2 = new Intent("android.media.action.VIDEO_CAPTURE");
            str = ".mp4";
        } else {
            intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            str = ".jpg";
        }
        PackageManager packageManager3 = activity.getPackageManager();
        ArrayList arrayList = new ArrayList();
        try {
            for (ResolveInfo resolveInfo : packageManager3.queryIntentActivities(intent2, 0)) {
                String string = resolveInfo.loadLabel(packageManager3).toString();
                Drawable applicationIcon = packageManager3.getApplicationIcon(resolveInfo.activityInfo.applicationInfo);
                Intent intent3 = new Intent(intent2);
                String str2 = DeviceInfo.sDeviceRootDir + "/DCIM/captured_image/";
                StringBuilder sb = new StringBuilder();
                packageManager = packageManager3;
                gridView = gridView2;
                try {
                    sb.append(System.currentTimeMillis());
                    sb.append(str);
                    File file = new File(str2, sb.toString());
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    Uri uriForFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".dc.fileprovider", file);
                    this.uris.add(file);
                    intent3.putExtra("output", uriForFile);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    intent3.setClassName(activityInfo.packageName, activityInfo.name);
                    arrayList.add(new Item(string, applicationIcon, intent3));
                    packageManager3 = packageManager;
                    gridView2 = gridView;
                } catch (Exception unused) {
                    packageManager2 = packageManager;
                    for (ResolveInfo resolveInfo2 : packageManager2.queryIntentActivities(intent, 0)) {
                        String string2 = resolveInfo2.loadLabel(packageManager2).toString();
                        Drawable applicationIcon2 = packageManager2.getApplicationIcon(resolveInfo2.activityInfo.applicationInfo);
                        Intent intent4 = new Intent(intent);
                        ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                        intent4.setClassName(activityInfo2.packageName, activityInfo2.name);
                        arrayList.add(new Item(string2, applicationIcon2, intent4));
                    }
                    gridView.setAdapter((ListAdapter) new GridAdapter(activity, arrayList));
                }
            }
            gridView = gridView2;
            packageManager2 = packageManager3;
        } catch (Exception unused2) {
            packageManager = packageManager3;
            gridView = gridView2;
        }
        while (r4.hasNext()) {
            String string3 = resolveInfo2.loadLabel(packageManager2).toString();
            Drawable applicationIcon3 = packageManager2.getApplicationIcon(resolveInfo2.activityInfo.applicationInfo);
            Intent intent5 = new Intent(intent);
            ActivityInfo activityInfo3 = resolveInfo2.activityInfo;
            intent5.setClassName(activityInfo3.packageName, activityInfo3.name);
            arrayList.add(new Item(string3, applicationIcon3, intent5));
        }
        gridView.setAdapter((ListAdapter) new GridAdapter(activity, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View createView(Context context, final Item item) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(item.icon);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int i = this.onedp * 50;
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i));
        TextView textView = new TextView(context);
        textView.setText(item.name);
        textView.setTextSize(this.onesp * 4);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.onedp * 10;
        linearLayout.addView(textView, layoutParams);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (item.i.getAction() == null || !(item.i.getAction().equals("android.media.action.IMAGE_CAPTURE") || item.i.getAction().equals("android.media.action.VIDEO_CAPTURE"))) {
                    FileChooseDialog.this.activity.startActivityForResult(item.i, 1);
                } else {
                    PermissionUtil.requestSystemPermissions(FileChooseDialog.this.activity, new String[]{Permission.CAMERA}, PermissionUtil.getRequestCode(), new PermissionUtil.Request() { // from class: io.dcloud.common.adapter.ui.FileChooseDialog.2.1
                        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                        public void onDenied(String str) {
                        }

                        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                        public void onGranted(String str) {
                            FileChooseDialog.this.activity.startActivityForResult(item.i, 2);
                        }
                    });
                }
            }
        });
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        View decorView = getWindow().getDecorView();
        int i = this.onedp;
        decorView.setPadding(0, i * 20, 0, i * 10);
        getWindow().getDecorView().setBackgroundColor(-1);
        getWindow().setAttributes(attributes);
    }
}
