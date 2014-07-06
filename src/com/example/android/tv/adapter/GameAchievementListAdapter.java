package com.example.android.tv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.adapter.CommonAdapter;
import com.example.android.tv.model.GameAchievement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameAchievementListAdapter extends CommonAdapter<GameAchievement.AchievementDetail> {

    private class DetailView {
        TextView mDetailTitle;
        TextView mDetailValue;
    }

    public GameAchievementListAdapter(Context context, List<GameAchievement.AchievementDetail> gameAchievements) {
        super(context, gameAchievements);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GameAchievement.AchievementDetail detail = (GameAchievement.AchievementDetail)getItem(position);
        DetailView detailView;
        if (convertView == null) {
            detailView = new DetailView();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.achievement_list_item, parent, false);
            detailView.mDetailTitle = (TextView)convertView.findViewById(R.id.achievement_title);
            detailView.mDetailValue = (TextView)convertView.findViewById(R.id.achievement_value);
            convertView.setTag(detailView);
        } else {
            detailView = (DetailView)convertView.getTag();
        }

        detailView.mDetailTitle.setText(detail.getTitle());
        detailView.mDetailValue.setText(detail.getValue());

        return convertView;
    }
}
