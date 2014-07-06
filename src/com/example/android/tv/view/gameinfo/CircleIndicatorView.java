package com.example.android.tv.view.gameinfo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.tv.R;


public class CircleIndicatorView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private int mCurrentPosition;
    private ImageView[] mImageViews;

    public CircleIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.circle_indicator, this);
        mImageViews = new ImageView[3];
        for (int i = 0; i < mImageViews.length; i++) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.circle_indicator_spacing);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.grey_circle_indicator));
            addView(imageView);
            mImageViews[i] = imageView;
        }
    }

    public void setViewPager(ViewPager view) {
        mViewPager = view;
        mViewPager.setOnPageChangeListener(this);

    }

    public void setCurrentItem(int position) {
        mViewPager.setCurrentItem(position, true);
        mCurrentPosition = position;
        mImageViews[position].setImageDrawable(getResources().getDrawable(R.drawable.black_circle_indicator));
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        mImageViews[mCurrentPosition].setImageDrawable(getResources().getDrawable(R.drawable.grey_circle_indicator));
        mCurrentPosition = i;
        mImageViews[mCurrentPosition].setImageDrawable(getResources().getDrawable(R.drawable.black_circle_indicator));
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
