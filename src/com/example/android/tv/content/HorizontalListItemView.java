package com.example.android.tv.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;

/**
 * Created by donaldzhu on 6/27/2014.
 */
public class HorizontalListItemView  {
    private Context mContext;
    private RelativeLayout mItemView;
    private ImageView mGameImage;
    private TextView mGameTitle;
    private StarRankView mRankView;

    public HorizontalListItemView(Context context) {
        mContext = context;
    }

    public View render(int imageId, CharSequence title, int rank) {
        mItemView = (RelativeLayout)LayoutInflater.from(mContext).inflate(R.layout.horizontal_list_item, null);
        GameItemView gameItemView = (GameItemView)mItemView.findViewById(R.id.game_item);
        mGameImage = (ImageView)gameItemView.findViewById(R.id.game_image);
        mGameTitle = (TextView)gameItemView.findViewById(R.id.game_title);
        mRankView = (StarRankView)gameItemView.findViewById(R.id.game_rank);
        mGameImage.setImageDrawable(gameItemView.getResources().getDrawable(imageId));
        mGameTitle.setText(title);
        mRankView.render(rank);
        return mItemView;
    }

    public void setSelected(boolean selected) {
        mItemView.setSelected(selected);
        if (selected) {
 /*           AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams)mItemView.getLayoutParams();
            layoutParams.height = 500;
            layoutParams.width = 250;
            mItemView.setLayoutParams(layoutParams);*/
            mItemView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim));
        } else {
            mItemView.clearAnimation();
        }
    }
}
