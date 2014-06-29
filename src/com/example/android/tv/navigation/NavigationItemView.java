package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class NavigationItemView {
    private Context mContext;
    private CharSequence mItemText;

    public NavigationItemView(Context context, CharSequence text) {
        mContext = context;
        mItemText = text;
    }

    public Context getContext() {
        return mContext;
    }

    public CharSequence getItemText() {
        return mItemText;
    }

    public abstract View render(ViewGroup parent);

    public void expand(boolean expand) {

    }

    public void setSelected(boolean selected) {
        expand(selected);
    }
}
