package com.example.android.tv.navigation;

import android.content.Context;

import com.example.android.tv.R;

public class RecommendationNavItem extends NavigationItem {
    public RecommendationNavItem(Context context) {
        super(context);
        mTag = mContext.getText(R.string.recommendation_item_tag);
        mText = mContext.getText(R.string.recommendation_navigation_item);
        mItemView = new NavItemTwoListView(mContext, mText);
    }
}
