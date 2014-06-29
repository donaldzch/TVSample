package com.example.android.tv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by donaldzhu on 6/26/2014.
 */
public class FootBar extends RelativeLayout {
    private ImageView mSearchBtn;
    private ImageView mSettingBtn;
    private TextView mPointsView;

    public FootBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.foot_bar, this);
        mSearchBtn = (ImageView)findViewById(R.id.search_btn);
        mSettingBtn = (ImageView)findViewById(R.id.setting_btn);
        mPointsView = (TextView)findViewById(R.id.points_view);
    }
}
