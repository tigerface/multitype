package com.tigerface.multitype.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.tigerface.multitype.ViewHolderPool;
import com.tigerface.multitype.viewholder.DumpViewHolder;
import com.tigerface.multitype.viewholder.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TODO recyclerview不支持header和footer
 */

public class FSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private ViewHolderPool typePool = new ViewHolderPool();
    private List<?> items = new ArrayList<>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemViewHolder viewHolder = typePool.getViewHolder(viewType);
        assert viewHolder != null;
        if (viewHolder == null) {
            return new DumpViewHolder(new View(parent.getContext(), null));
        }
        viewHolder.adapter = this;
        return viewHolder.onCreateViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);
        ItemViewHolder viewHolder = typePool.getViewHolder(item);
        assert viewHolder != null;
        if (viewHolder != null) {
            viewHolder.onBindViewHolder(holder, position, item);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Object item = items.get(position);
        return typePool.getItemViewType(item);
    }

    public void register(ItemViewHolder holder) {
        typePool.register(holder);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void destroy() {
        if (items != null) {
            items.clear();
        }
        if (typePool != null) {
            typePool.destroy();
        }
    }

    public void add(List list) {
        items.addAll(list);
        notifyDataSetChanged();
    }

    public void set(List list) {
        items.clear();
        items.addAll(list);
        notifyDataSetChanged();
    }
}
