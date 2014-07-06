package com.example.android.tv.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavItemTwoListView extends NavigationItemView {
    private ListView mMainList;
    private ListView mSubList;
    private Long mMainCategoryId;
    private Long mSubCategoryId;
    private List<CategoryItem> mCategories;
    private Map<Long, List<CategoryItem>> mSubCategories;
    private NavigationListViewAdapter mSubListAdapter;

    public NavItemTwoListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void expand() {
        adjustLayout(mExpand ? mExpandHeight : mNormalHeight);
        mMainList.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
        mSubList.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
        if (!mExpand) {
            mMainCategoryId = ((CategoryItem)mMainList.getAdapter().getItem(0)).getId();
            mSubListAdapter.reset(mSubCategories.get(mMainCategoryId));
            mSubListAdapter.notifyDataSetChanged();
            mSubCategoryId = mSubCategories.get(mMainCategoryId).get(0).getId();
        }
    }

    @Override
    public void setUpListView(CategoryItem categoryItem) {
        mCategoryId = categoryItem.getId();
        mCategories = categoryItem.getChildrenItems();
        mSubCategories = new HashMap<Long, List<CategoryItem>>();
        for (CategoryItem item : mCategories) {
            mSubCategories.put(item.getId(), item.getChildrenItems());
        }
        mMainList = (ListView)findViewById(R.id.category_list);
        mMainList.setAdapter(new NavigationListViewAdapter(getContext(), mCategories));
        mMainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Long mainCategory = l;
                if (!mainCategory.equals(mMainCategoryId)) {
                    mMainCategoryId = mainCategory;
                    mSubListAdapter.reset(mSubCategories.get(mainCategory));
                    mSubListAdapter.notifyDataSetChanged();
                    mSubCategoryId = mSubCategories.get(mMainCategoryId).get(0).getId();
                    mItemClickListener.onItemClick(mCategoryId, mMainCategoryId, mSubCategoryId);
                }
            }
        });
        mMainCategoryId = ((CategoryItem)mMainList.getAdapter().getItem(0)).getId();
        mSubList = (ListView)findViewById(R.id.sub_category_list);
        mSubListAdapter = new NavigationListViewAdapter(getContext(), mSubCategories.get(mMainCategoryId));
        mSubList.setAdapter(mSubListAdapter);
        mSubList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Long subCategory = l;
                if (!mSubCategoryId.equals(subCategory)) {
                    mSubCategoryId = subCategory;
                    mItemClickListener.onItemClick(mCategoryId, mMainCategoryId, mSubCategoryId);
                }
            }
        });
        mSubCategoryId = ((CategoryItem)mSubList.getAdapter().getItem(0)).getId();
    }

    @Override
    public View.OnClickListener getViewClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpand = !mExpand;
                expand();
                if (mExpand) {
                    mItemClickListener.onItemClick(mCategoryId, mMainCategoryId, mSubCategoryId);
                }
            }
        };
    }
}
