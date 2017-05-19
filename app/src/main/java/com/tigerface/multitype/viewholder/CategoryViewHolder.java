package com.tigerface.multitype.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.tigerface.multitype.R;
import com.tigerface.multitype.entity.Category;

/**
 * Created by lihu on 2017/5/11.
 */

public class CategoryViewHolder extends ItemViewHolder<Category, CategoryViewHolder.InnerViewHolder> {

    @Override
    public InnerViewHolder onCreateViewHolder(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        InnerViewHolder holder = new InnerViewHolder(view);
        holder.category = (TextView) view.findViewById(R.id.category);
        //RadioView radioView = new RadioView(); radioView.setOnClickListener(xx);
        return holder;
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position, Category item) {
        //RadioView radioView.setRadioData(item);
        holder.category.setText(item.text);
//        holder.itemView
    }


    class InnerViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public InnerViewHolder(View itemView) {
            super(itemView);
        }
    }
}
