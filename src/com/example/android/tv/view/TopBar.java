package com.example.android.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;

public class TopBar extends RelativeLayout {
    private ImageView mBackBtn;
    private ImageView mUserIcon;
    private TextView mUserName;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_bar, this);
        mBackBtn = (ImageView)findViewById(R.id.back_btn);
        mUserIcon = (ImageView)findViewById(R.id.user_icon);
        mUserName = (TextView)findViewById(R.id.user_name);
    }
}
