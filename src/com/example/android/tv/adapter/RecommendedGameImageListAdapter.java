package com.example.android.tv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.tv.R;
import com.example.android.tv.adapter.CommonAdapter;

import java.util.List;

public class RecommendedGameImageListAdapter extends CommonAdapter<Integer> {
    public RecommendedGameImageListAdapter(Context context, List<Integer> recommendedGames) {
        super(context, recommendedGames);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(mContext.getResources().getDimensionPixelSize(R.dimen.recommended_game_image_width),
                    mContext.getResources().getDimensionPixelSize(R.dimen.recommended_game_image_height)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource((Integer)getItem(position));
        return imageView;
    }
}
