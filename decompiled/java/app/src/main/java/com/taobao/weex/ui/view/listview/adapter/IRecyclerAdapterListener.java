package com.taobao.weex.ui.view.listview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: compiled from: r8-map-id-b4716a25f9920722ba6f2d7f7c6f40e43a654927e8ebe1c489894a7bc6a88ab4 */
/* JADX INFO: loaded from: classes.dex */
public interface IRecyclerAdapterListener<T extends RecyclerView.ViewHolder> {
    int getItemCount();

    long getItemId(int i);

    int getItemViewType(int i);

    void onBindViewHolder(T t, int i);

    T onCreateViewHolder(ViewGroup viewGroup, int i);

    boolean onFailedToRecycleView(T t);

    void onViewRecycled(T t);
}
