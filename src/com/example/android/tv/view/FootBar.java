package com.example.android.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;

public class FootBar extends RelativeLayout {
    private ImageView mSearchBtn;
    private ImageView mSettingBtn;
    private TextView mPointsView;

    public FootBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.foot_bar, this);
        mSearchBtn = (ImageView)findViewById(R.id.search_btn);
        mSettingBtn = (ImageView)findViewById(R.id.setting_btn);
        mPointsView = (TextView)findViewById(R.id.user_points);
    }

    public void setUserPoints(Long userPoints) {
        mPointsView.setText(String.format(getContext().getString(R.string.user_points_text), userPoints));
    }
}
