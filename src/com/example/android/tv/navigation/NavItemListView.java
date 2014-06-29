package com.example.android.tv.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.tv.R;

public abstract class NavItemListView extends NavigationItemView {

    protected Resources mResources;
    protected RelativeLayout mView;
    protected TextView mItemTextView;
    protected boolean mExpand;
    protected int mResourceId;

    public NavItemListView(Context context, CharSequence text) {
        super(context, text);
        mResources = context.getResources();
    }

    protected void adjustLayout(int height) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams)mView.getLayoutParams();
        layoutParams.height = height;
        mView.setLayoutParams(layoutParams);
    }

    abstract public void expand();
    abstract public void setUpListView();

    @Override
    public View render(ViewGroup parent) {
        mView = (RelativeLayout) LayoutInflater.from(getContext()).inflate(mResourceId, parent, false);
        adjustLayout(mResources.getDimensionPixelSize(R.dimen.nav_item_view_height));
        mItemTextView = (TextView)mView.findViewById(R.id.navItemText);
        mItemTextView.setText(getItemText());
        mItemTextView.setOnClickListener(getViewClickListener());
        setUpListView();
        return mView;
    }

    public View.OnClickListener getViewClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExpand = !mExpand;
                expand();
            }
        };
    }

    @Override
    public void expand(boolean expand) {
        mExpand = expand;
        expand();
    }
}
