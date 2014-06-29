package com.example.android.tv.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.android.tv.R;

/**
 * Created by donaldzhu on 6/27/2014.
 */
public class StarRankView extends LinearLayout {
    public final static int RANK_NUMBER = 5;

    public StarRankView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.star_rank_view, this);
    }

    public void render(int rank) {
        for (int i = 0; i < RANK_NUMBER; i++) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            if ( i >= rank) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.empty_star));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.solid_star));
            }
            addView(imageView);
        }
    }
}
