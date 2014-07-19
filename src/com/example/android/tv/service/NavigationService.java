package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationService {
    private static final Object mInstanceSync = new Object();
    private static NavigationService INSTANCE = null;
    private Context mContext;
    private Map<CharSequence, CategoryItem> mCategoryItems;
    private Map<Long, CategoryItem> mCategoryItemsById;
    private NavigationService(Context context) {
        mContext = context;
        mCategoryItems = new HashMap<CharSequence, CategoryItem>();
        mCategoryItemsById = new HashMap<Long, CategoryItem>();
        makeNavigationCategories();
    }

    public static NavigationService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new NavigationService(context);
            }
        }
        return INSTANCE;
    }

    private void makeNavigationCategories() {
        long i = 1;
        //recommendation nav
        CategoryItem recommendedNav = new CategoryItem(i++, mContext.getResources().getString(R.string.recommendation_item_tag));
        List<CategoryItem> categoryItems = new ArrayList<CategoryItem>();
        for (String name : mContext.getResources().getStringArray(R.array.recommendation_sub_nav_item)) {
            CategoryItem item = new CategoryItem(i++, name);
            categoryItems.add(item);
            List<CategoryItem> subItems = new ArrayList<CategoryItem>();
            for (String subName : mContext.getResources().getStringArray(R.array.recommendation_sub_nav_item_free_values)) {
                CategoryItem item1 = new CategoryItem(i++, subName);
                subItems.add(item1);
            }
            item.setChildrenItems(subItems);
        }
        recommendedNav.setChildrenItems(categoryItems);

        CategoryItem myGameNav = new CategoryItem(i++, mContext.getResources().getString(R.string.my_game_item_tag));

        CategoryItem rankingListNav = new CategoryItem(i++, mContext.getResources().getString(R.string.rank_item_tag));
        List<CategoryItem> categoryItems1 = new ArrayList<CategoryItem>();
        for (String name : mContext.getResources().getStringArray(R.array.recommendation_sub_nav_item)) {
            CategoryItem item = new CategoryItem(i++, name);
            categoryItems1.add(item);
            List<CategoryItem> subItems1 = new ArrayList<CategoryItem>();
            for (String subName : mContext.getResources().getStringArray(R.array.recommendation_sub_nav_item_free_values)) {
                CategoryItem item1 = new CategoryItem(i++, subName);
                subItems1.add(item1);
            }
            item.setChildrenItems(subItems1);
        }
        rankingListNav.setChildrenItems(categoryItems1);

        CategoryItem allGameNav = new CategoryItem(i++, mContext.getResources().getString(R.string.all_games_item_tag));
        List<CategoryItem> categoryItems2 = new ArrayList<CategoryItem>();
        for (String name: mContext.getResources().getStringArray(R.array.all_game_nav_item_list_values)) {
            categoryItems2.add(new CategoryItem(i++, name));
        }
        allGameNav.setChildrenItems(categoryItems2);

        mCategoryItems.put(recommendedNav.getName(), recommendedNav);
        mCategoryItems.put(myGameNav.getName(), myGameNav);
        mCategoryItems.put(rankingListNav.getName(), rankingListNav);
        mCategoryItems.put(allGameNav.getName(), rankingListNav);

        mCategoryItemsById.put(recommendedNav.getId(), recommendedNav);
        mCategoryItemsById.put(myGameNav.getId(), myGameNav);
        mCategoryItemsById.put(rankingListNav.getId(), rankingListNav);
        mCategoryItemsById.put(allGameNav.getId(), allGameNav);
    }

    public CategoryItem getCategory(CharSequence name) {
        return mCategoryItems.get(name);
    }

    public CategoryItem getCategory(Long categoryId) {
        return mCategoryItemsById.get(categoryId);
    }
}
