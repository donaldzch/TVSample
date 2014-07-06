package com.example.android.tv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tv.view.content.GameItemLayoutView;
import com.example.android.tv.model.GameItem;
import java.util.List;


public class GameItemListAdapter extends CommonAdapter<GameItem> {
	private int selectIndex = -1;

    public GameItemListAdapter(Context context, List<GameItem> gameItems) {
        super(context, gameItems);
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        GameItem gameItem = (GameItem)getItem(position);
        GameItemLayoutView itemView;
        if (convertView == null) {
            itemView = new GameItemLayoutView(mContext);
            convertView = itemView.render(gameItem.getImageId(), gameItem.getTitle(), gameItem.getRank());
            convertView.setTag(itemView);
        } else {
            itemView = (GameItemLayoutView)convertView.getTag();
        }

        if (selectIndex == position) {
            itemView.setSelected(true);
        } else {
            itemView.setSelected(false);
        }

		return convertView;
	}

	public void setSelectIndex(int i){
		selectIndex = i;
	}
}