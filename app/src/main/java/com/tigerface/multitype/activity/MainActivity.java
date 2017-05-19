package com.tigerface.multitype.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


import com.tigerface.multitype.R;
import com.tigerface.multitype.adapter.FSAdapter;
import com.tigerface.multitype.entity.Category;
import com.tigerface.multitype.viewholder.CategoryViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        //1、data
        List list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add("13");
        list.add(new Category("c1"));
        list.add(new Category("c2"));
        list.add(new Category("c3"));

        //2、初始化adapter

        FSAdapter adapter = new FSAdapter();
        //设置只支持Category类型的viewholder，别的不支持
        CategoryViewHolder holder = new CategoryViewHolder();
        adapter.register(holder);
        adapter.add(list);
        recyclerView.setAdapter(adapter);
    }
}
