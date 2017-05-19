package com.tigerface.multitype.entity;

import android.support.annotation.NonNull;


public class Category {
    @NonNull public String text;

    public Category(@NonNull
                    final String text) {
        this.text = text;
    }
}
