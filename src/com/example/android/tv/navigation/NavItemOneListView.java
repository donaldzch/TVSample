package com.example.android.tv.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;

import java.util.List;
import java.util.Map;

public class NavItemOneListView extends NavigationItemView {
    private ListView mListView;
    private Long mChoice;

    public NavItemOneListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void expand() {
        adjustLayout(mExpand ? mExpandHeight : mNormalHeight);
        mListView.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
        if (!mExpand) {
            mChoice = ((CategoryItem) mListView.getAdapter().getItem(0)).getId();
        }
    }

    @Override
    public void setUpListView(CategoryItem categoryItem) {
        mCategoryId = categoryItem.getId();
        mListView = (ListView)findViewById(R.id.listView);
        mListView.setAdapter(new NavigationListViewAdapter(getContext(), categoryItem.getChildrenItems()));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Long mainCategory = l;
                if (!mainCategory.equals(mChoice)) {
                    mChoice = mainCategory;
                    mItemClickListener.onItemClick(mCategoryId, mChoice, null);
                }
            }
        });
        mChoice = ((CategoryItem)mListView.getAdapter().getItem(0)).getId();
    }

    @Override
    public View.OnClickListener getViewClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpand = !mExpand;
                expand();
                mItemClickListener.onItemClick(mCategoryId, mChoice, null);
            }
        };
    }
}
