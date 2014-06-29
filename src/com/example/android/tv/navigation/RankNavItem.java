package com.example.android.tv.navigation;

import android.content.Context;

import com.example.android.tv.R;

/**
 * Created by donaldzhu on 6/24/2014.
 */
public class RankNavItem extends NavigationItem {

    public RankNavItem(Context context) {
        super(context);
        mTag = mContext.getText(R.string.rank_item_tag);
        mText = mContext.getText(R.string.rank_navigation_item);
        mItemView = new NavItemTwoListView(mContext, mText);
    }
}