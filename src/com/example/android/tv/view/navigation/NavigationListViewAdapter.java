package com.example.android.tv.view.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.adapter.CommonAdapter;
import com.example.android.tv.model.CategoryItem;

import java.util.List;

public class NavigationListViewAdapter extends CommonAdapter<CategoryItem> {
    public NavigationListViewAdapter(Context context, List<CategoryItem> categoryItems) {
        super(context, categoryItems);
    }

    public void reset(List<CategoryItem> categoryItems) {
        mObjects = categoryItems;
    }

    @Override
    public long getItemId(int position) {
        return mObjects.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryItem categoryItem = (CategoryItem)getItem(position);
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
