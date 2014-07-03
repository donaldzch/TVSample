package com.example.android.tv.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;

import java.util.List;

public class NavigationListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<CategoryItem> mCategoryItems;

    public NavigationListViewAdapter(Context context, List<CategoryItem> categoryItems) {
        mContext = context;
        mCategoryItems = categoryItems;
    }

    public void reset(List<CategoryItem> categoryItems) {
        mCategoryItems = categoryItems;
    }

    @Override
    public int getCount() {
        return mCategoryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategoryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCategoryItems.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryItem categoryItem = mCategoryItems.get(position);
        TextView textView;
        if (convertView == null) {
           textView = (TextView)LayoutInflater.from(mContext).inflate(R.layout.custom_text_view, parent, false);
        } else {
            textView = (TextView)convertView;
        }
        textView.setText(categoryItem.getName());
        return textView;
    }
}
