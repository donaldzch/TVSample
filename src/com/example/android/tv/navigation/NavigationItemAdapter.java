package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.android.tv.model.CategoryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
