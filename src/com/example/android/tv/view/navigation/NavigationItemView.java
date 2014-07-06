package com.example.android.tv.view.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;

public abstract class NavigationItemView extends RelativeLayout {
    protected Long mCategoryId;
    protected Resources mResources;
    protected TextView mItemTextView;
    protected boolean mExpand;
    protected int mResourceId;
    protected int mExpandHeight;
    protected int mNormalHeight;
    protected NavigationItemClickListener mItemClickListener;

    public NavigationItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mResources = getResources();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationItemView);
        mResourceId = typedArray.getResourceId(R.styleable.NavigationItemView_layout, -1);
        LayoutInflater.from(context).inflate(mResourceId, this);
        mExpand = typedArray.getBoolean(R.styleable.NavigationItemView_expand, false);
        mExpandHeight = typedArray.getDimensionPixelSize(R.styleable.NavigationItemView_expanded_height, -1);
        mNormalHeight = typedArray.getDimensionPixelSize(R.styleable.NavigationItemView_normal_height, -1);

        mItemTextView = (TextView)findViewById(R.id.nav_item_text);
        mItemTextView.setText(typedArray.getString(R.styleable.NavigationItemView_item_name));
        mItemTextView.setOnClickListener(getViewClickListener());
        typedArray.recycle();
    }


    protected void adjustLayout(int height) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        } else {
            layoutParams.height = height;
        }
        setLayoutParams(layoutParams);
    }

    abstract public void expand();
    abstract public void setUpListView(CategoryItem categoryItem);

    abstract public View.OnClickListener getViewClickListener();

    public void setItemClickListener(NavigationItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        mExpand = !mExpand;
        expand();
    }
}
