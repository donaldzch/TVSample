package com.example.android.tv.view.navigation;

import java.util.HashMap;
import java.util.Map;

public class NavigationItemAdapter {

    private Map<String, NavigationItem> mNavigationItems;
    private NavigationItem mCurrentItem;

    public NavigationItemAdapter() {
        mNavigationItems = new HashMap<String, NavigationItem>();
        mCurrentItem = null;
    }

    public void addNavigationItem(NavigationItem navigationItem) {
        mNavigationItems.put(navigationItem.getTag().toString(), navigationItem);
    }

    public void setCurrentItem(String tag) {
        if (mCurrentItem == null) {
            mCurrentItem = mNavigationItems.get(tag);
        } else {
            mCurrentItem.setSelected(false);
            mCurrentItem = mNavigationItems.get(tag);
        }
        mCurrentItem.setSelected(true);
    }
}
