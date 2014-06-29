package com.example.android.tv.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.android.tv.R;

public class GameItemView extends LinearLayout {

    public GameItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.horizontal_list_sub_item, this);
    }
}
