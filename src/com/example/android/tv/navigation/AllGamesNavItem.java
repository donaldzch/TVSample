package com.example.android.tv.navigation;

import android.content.Context;

import com.example.android.tv.R;

public class AllGamesNavItem extends NavigationItem {

    public AllGamesNavItem(Context context) {
        super(context);
        mTag = mContext.getText(R.string.all_games_item_tag);
        mText = mContext.getText(R.string.all_games_navigation_item);
        mItemView = new NavItemOneListView(context, mText);
    }
}
