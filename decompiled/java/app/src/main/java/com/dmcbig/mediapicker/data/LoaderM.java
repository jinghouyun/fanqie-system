package com.dmcbig.mediapicker.data;

import com.dmcbig.mediapicker.entity.Folder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605b2a5c8742184084f62a640225086eefcd9237ae25847375566b7136421843 */
/* JADX INFO: loaded from: classes.dex */
public class LoaderM {
    public String getParent(String str) {
        String[] strArrSplit = str.split("/");
        return strArrSplit[strArrSplit.length - 2];
    }

    public int hasDir(ArrayList<Folder> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).name.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
