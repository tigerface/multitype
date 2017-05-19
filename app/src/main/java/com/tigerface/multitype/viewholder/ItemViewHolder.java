package com.tigerface.multitype.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tigerface.multitype.adapter.FSAdapter;


public abstract class ItemViewHolder<T, VH extends RecyclerView.ViewHolder> {
    public FSAdapter adapter;
    public Object extra;

    public abstract VH onCreateViewHolder(LayoutInflater inflater, ViewGroup parent);

    public abstract void onBindViewHolder(VH holder, int position, T item);

}