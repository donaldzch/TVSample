package com.example.android.tv.view.navigation;

import java.util.HashMap;
import java.util.Map;

public class NavigationItemAdapter {

    private Map<Long, NavigationItem> mNavigationItems;
    private NavigationItem mCurrentItem;

    public NavigationItemAdapter() {
        mNavigationItems = new HashMap<Long, NavigationItem>();
        mCurrentItem = null;
    }

    public void addNavigationItem(NavigationItem navigationItem) {
        mNavigationItems.put(navigationItem.getCategoryId(), navigationItem);
    }

    public void setCurrentItem(Long categoryId) {
        if (mCurrentItem == null) {
            mCurrentItem = mNavigationItems.get(categoryId);
        } else {
            mCurrentItem.setSelected(false);
            mCurrentItem = mNavigationItems.get(categoryId);
        }
        mCurrentItem.setSelected(true);
    }
}
