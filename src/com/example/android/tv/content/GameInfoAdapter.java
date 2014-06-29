package com.example.android.tv.content;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.android.tv.model.GameItem;
import java.util.List;


public class GameInfoAdapter extends BaseAdapter{
	private List<GameItem> mGameItems;
	private Context mContext;
	private int selectIndex = -1;

    public GameInfoAdapter(Context context, List<GameItem> gameItems) {
        mContext = context;
        mGameItems = gameItems;
    }

	@Override
	public int getCount() {
		return mGameItems.size();
	}
	@Override
	public Object getItem(int position) {
		return mGameItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        GameItem gameItem = (GameItem)getItem(position);
        HorizontalListItemView itemView;
        if (convertView == null) {
            itemView = new HorizontalListItemView(mContext);
            convertView = itemView.render(gameItem.getImageId(), gameItem.getTitle(), gameItem.getRank());
            convertView.setTag(itemView);
        } else {
            itemView = (HorizontalListItemView)convertView.getTag();
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