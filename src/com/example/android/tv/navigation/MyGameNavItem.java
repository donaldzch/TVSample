package com.example.android.tv.navigation;

import android.content.Context;

import com.example.android.tv.R;

public class MyGameNavItem extends NavigationItem {
    public MyGameNavItem(Context context) {
        super(context);
        mTag = mContext.getText(R.string.my_game_item_tag);
        mText = mContext.getText(R.string.my_game_navigation_item);
        mItemView = new NavItemTextView(context, mText);
    }
}
