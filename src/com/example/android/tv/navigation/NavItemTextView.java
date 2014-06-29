package com.example.android.tv.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.tv.R;

public class NavItemTextView extends NavigationItemView {
    private LinearLayout mView;
    private TextView mItemTextView;
    public NavItemTextView(Context context, CharSequence text) {
        super(context, text);
    }

    @Override
    public View render(ViewGroup parent) {
        mView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.nav_item_with_text, parent, false);
        mItemTextView = (TextView)mView.findViewById(R.id.item_title);
        mItemTextView.setText(getItemText());
        return mView;
    }
}
