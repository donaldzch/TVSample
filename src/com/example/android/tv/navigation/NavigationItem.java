package com.example.android.tv.navigation;

public class NavigationItem {
    protected CharSequence mTag;
    protected NavigationItemView mItemView;

    public Long getCategoryId() {
        return mItemView.getCategoryId();
    }

    public NavigationItem(NavigationItemView itemView, NavigationItemClickListener listener) {
        mTag = itemView.getTag().toString();
        mItemView = itemView;
        mItemView.setItemClickListener(listener);
    }

    public CharSequence getTag() {
        return mTag;
    }

    public void setSelected(boolean selected) {
        mItemView.setSelected(selected);
    }
}
