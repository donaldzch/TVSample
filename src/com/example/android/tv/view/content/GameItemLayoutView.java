package com.example.android.tv.view.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.model.GameItem;

public class GameItemLayoutView {
    private Context mContext;
    private RelativeLayout mItemView;
    private ImageView mGameImage;
    private TextView mGameTitle;
    private StarRankView mRankView;
    private TextView mGamePrice;

    public GameItemLayoutView(Context context) {
        mContext = context;
    }

    public View render(GameItem gameItem) {
        mItemView = (RelativeLayout)LayoutInflater.from(mContext).inflate(R.layout.game_item_view, null);
        GameItemView gameItemView = (GameItemView)mItemView.findViewById(R.id.game_item);
        mGameImage = (ImageView)gameItemView.findViewById(R.id.game_image);
        mGameTitle = (TextView)gameItemView.findViewById(R.id.game_title);
        mRankView = (StarRankView)gameItemView.findViewById(R.id.game_rank);
        mGamePrice = (TextView)gameItemView.findViewById(R.id.game_price);

        int imageId = mContext.getResources().getIdentifier(gameItem.getImage(), "drawable", mContext.getPackageName());
        mGameImage.setImageDrawable(gameItemView.getResources().getDrawable(imageId));
        mGameTitle.setText(gameItem.getTitle());
        mRankView.render(gameItem.getRank());

        if (gameItem.getPrice().equals(0L)) {
            mGamePrice.setVisibility(View.INVISIBLE);
        } else {
            mGamePrice.setText(String.format(mContext.getResources().getString(R.string.game_price_text), gameItem.getPrice()));
        }
        return mItemView;
    }

    public void setSelected(boolean selected) {
        mItemView.setSelected(selected);
        if (selected) {
            mItemView.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.anim));
        } else {
            mItemView.clearAnimation();
        }
    }
}
