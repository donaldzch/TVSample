package com.example.android.tv.view.navigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.example.android.tv.model.CategoryItem;

public class NavItemTextView extends NavItemOneListView {

    public NavItemTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void expand() {

    }

    @Override
    public void setUpListView(CategoryItem categoryItem) {
        mCategoryId = categoryItem.getId();
    }

    @Override
    public View.OnClickListener getViewClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListener.onItemClick(mCategoryId, null, null);
            }
        };
    }
}
