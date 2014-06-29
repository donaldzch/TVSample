package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.tv.R;

public class NavItemTwoListView extends NavItemListView {
    private ListView mMainList;
    private ListView mSubList;
    private String mMainChoice;
    private String mSubChoice;

    public NavItemTwoListView(Context context, CharSequence text) {
        super(context, text);
        mResourceId = R.layout.nav_item_with_two_list;
    }

    @Override
    public void expand() {
        adjustLayout(mExpand ? mResources.getDimensionPixelSize(R.dimen.nav_item_expanded_view_height) : mResources.getDimensionPixelSize(R.dimen.nav_item_view_height));
        mMainList.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
        mSubList.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void setUpListView() {
        mMainList = (ListView)mView.findViewById(R.id.listView);
        mMainList.setAdapter(new ArrayAdapter<String>(getContext(),
                R.layout.custom_text_view, mResources.getStringArray(R.array.recommendation_sub_nav_item)));
        mMainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mMainChoice = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), mMainChoice + ":" + mSubChoice, Toast.LENGTH_SHORT).show();
            }
        });
        mMainChoice = mMainList.getAdapter().getItem(0).toString();
        mSubList = (ListView)mView.findViewById(R.id.subListView);
        mSubList.setAdapter(new ArrayAdapter<String>(getContext(), R.layout.custom_text_view, mResources.getStringArray(R.array.recommendation_sub_nav_item_free_values)));
        mSubList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mSubChoice = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), mMainChoice + ":" + mSubChoice, Toast.LENGTH_SHORT).show();
            }
        });
        mSubChoice = mSubList.getAdapter().getItem(0).toString();
    }
}
