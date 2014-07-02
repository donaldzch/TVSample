package com.example.android.tv.gameinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.tv.R;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> mRecommendedGames;

    public ImageAdapter(Context context, List<Integer> recommendedGames) {
        mContext = context;
        mRecommendedGames = recommendedGames;
    }

    public int getCount() {
        return mRecommendedGames.size();
    }

    public Object getItem(int position) {
        return mRecommendedGames.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mContext.getResources().getDimensionPixelSize(R.dimen.recommended_game_image_width),
                    mContext.getResources().getDimensionPixelSize(R.dimen.recommended_game_image_height)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mRecommendedGames.get(position));
        return imageView;
    }
}
