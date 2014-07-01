package com.example.android.tv.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.tv.R;

public class StarRankView extends LinearLayout {
    public final static int RANK_NUMBER = 5;
    private Drawable mGoodReputation;
    private Drawable mBadReputation;

    public StarRankView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.star_rank_view, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.StarRankView);
        mGoodReputation = typedArray.getDrawable(R.styleable.StarRankView_good_reputation_image);
        mBadReputation = typedArray.getDrawable(R.styleable.StarRankView_bad_reputation_image);
        typedArray.recycle();
    }

    public void render(int rank) {
        for (int i = 0; i < RANK_NUMBER; i++) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            if ( i >= rank) {
                imageView.setImageDrawable(mBadReputation);
            } else {
                imageView.setImageDrawable(mGoodReputation);
            }
            addView(imageView);
        }
    }
}
