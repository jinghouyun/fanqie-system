package com.taobao.weex.appfram.navigator;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IActivityNavBarSetter {
    boolean clearNavBarLeftItem(String str);

    boolean clearNavBarMoreItem(String str);

    boolean clearNavBarRightItem(String str);

    boolean pop(String str);

    boolean push(String str);

    boolean setNavBarLeftItem(String str);

    boolean setNavBarMoreItem(String str);

    boolean setNavBarRightItem(String str);

    boolean setNavBarTitle(String str);
}
