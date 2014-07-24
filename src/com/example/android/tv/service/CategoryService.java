package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;
import com.example.android.tv.utils.CategoryItemXmlParser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CategoryService {
    private static final Object mInstanceSync = new Object();
    private static CategoryService INSTANCE = null;
    private Context mContext;
    private Map<CharSequence, CategoryItem> mCategoryItems;
    private Map<Long, CategoryItem> mCategoryItemsById;

    private final Map<Integer, String> categoryParserMapping = new HashMap<Integer, String>() {{
        put(R.xml.recommended_category, "RecommendedCategory");
        put(R.xml.ranking_list_category, "RankingListCategory");
        put(R.xml.all_game_category, "AllGameCategory");
    }};

    private CategoryService(Context context) {
        mContext = context;
        mCategoryItems = new HashMap<CharSequence, CategoryItem>();
        mCategoryItemsById = new HashMap<Long, CategoryItem>();

        initialize();
    }

    private void initialize() {

        try {
            for (Integer categoryFile : categoryParserMapping.keySet()) {
                InputStream inputStream = mContext.getResources().openRawResource(categoryFile);
                CategoryItem categoryItem = new CategoryItemXmlParser(categoryParserMapping.get(categoryFile)).parse(inputStream);
                mCategoryItems.put(categoryItem.getName(), categoryItem);
                mCategoryItemsById.put(categoryItem.getId(), categoryItem);
            }
        } catch (Exception e) {

        }
    }

    public static CategoryService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new CategoryService(context);
            }
        }
        return INSTANCE;
    }



    public CategoryItem getCategory(CharSequence name) {
        return mCategoryItems.get(name);
    }

    public CategoryItem getCategory(Long categoryId) {
        return mCategoryItemsById.get(categoryId);
    }
}
