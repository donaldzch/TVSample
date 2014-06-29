package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


public abstract class NavigationItem {
    protected final Context mContext;
    protected CharSequence mTag;
    protected CharSequence mText;
    protected NavigationItemView mItemView;

    public View renderView(ViewGroup parent) {
        return mItemView.render(parent);
    }

    public NavigationItemView getItemView() {
        return mItemView;
    }

    public NavigationItem(Context context) {
        mContext = context;
    }

    public CharSequence getText() {
        return mText;
    }

    public NavigationItem setText(CharSequence charSequence) {
        mText = charSequence;
        return this;
    }

    public NavigationItem setTag(CharSequence tag) {
        mTag = tag;
        return this;
    }

    public CharSequence getTag() {
        return mTag;
    }

    public void setSelected(boolean selected) {
        mItemView.setSelected(selected);
    }
}
