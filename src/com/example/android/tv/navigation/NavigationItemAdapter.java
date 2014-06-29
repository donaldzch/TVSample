package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class NavigationItemAdapter extends ArrayAdapter<NavigationItem> {

    private final Map<NavigationItem, View> mCachedViews;

    private NavigationItem mSelectedItem;

    private boolean mIsSelectionActive;

    private NavigationItem mSavedSelection;

    private NavigationItemClickListener mItemClickListener;

    public NavigationItemAdapter(Context context) {
        super(context, 0);
        mCachedViews = new HashMap<NavigationItem, View>();
        mSelectedItem = null;
        mSavedSelection = null;
        mIsSelectionActive = true;
    }

    public void setItemClientListener(NavigationItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void setSelectionActive(boolean active) {
        if (active == mIsSelectionActive) {
            return;
        }
        if (active) {
            // Restore the saved selection.
            mIsSelectionActive = true;
            setSelected(mSavedSelection);
            mSavedSelection = null;
        } else {
            // Save the selection and deselect the actual tab.
            mSavedSelection = mSelectedItem;
            setSelected(null);
            mIsSelectionActive = false;
        }
    }

    public void setSelected(NavigationItem item) {
        Toast.makeText(getContext(), item.getText(), Toast.LENGTH_SHORT).show();
        if (!mIsSelectionActive) {
            // In this case, simply storing the selected tab.
            mSavedSelection = item;
            return;
        }
        NavigationItem oldSelection = mSelectedItem;
        mSelectedItem = item;
        if (oldSelection != mSelectedItem) {
            setSelectionState(oldSelection, false);
            setSelectionState(mSelectedItem, true);
        }
        mItemClickListener.onItemChangeListener(mSelectedItem, oldSelection);
        //onSelectionChanged(oldSelection, mSelectedItem);
    }

    public NavigationItem getSelected() {
        return mIsSelectionActive ? mSelectedItem : mSavedSelection;
    }

    private boolean isSelected(NavigationItem item) {
        return item != null && item == getSelected();
    }

    private void setSelectionState(NavigationItem item, boolean selected) {
        if (item != null && mCachedViews.containsKey(item)) {
            mCachedViews.get(item).setSelected(selected);
            item.setSelected(selected);
        }
    }

    @Override
    public int getItemViewType(int position) {
        // This ensures views are not recycled.
        return IGNORE_ITEM_VIEW_TYPE;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final NavigationItem item = getItem(position);
        if (!mCachedViews.containsKey(item)) {
            View itemView = item.renderView(parent);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelected(item);
                }
            });
            mCachedViews.put(item, itemView);
        }
        setSelectionState(item, isSelected(item));
        return mCachedViews.get(item);
    }
}
