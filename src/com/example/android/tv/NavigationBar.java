package com.example.android.tv;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.example.android.tv.navigation.AllGamesNavItem;
import com.example.android.tv.navigation.MyGameNavItem;
import com.example.android.tv.navigation.NavigationItem;
import com.example.android.tv.navigation.NavigationItemAdapter;
import com.example.android.tv.navigation.NavigationItemClickListener;
import com.example.android.tv.navigation.RankNavItem;
import com.example.android.tv.navigation.RecommendationNavItem;


public class NavigationBar extends ListFragment implements NavigationItemClickListener {
    private Context mContext;
    private NavigationItemAdapter mAdapter;
    private OnNavigationItemSelectedListener mItemSelectedListener;

    public interface OnNavigationItemSelectedListener {
        public void onNavigationItemSelectedListener(NavigationItem item);
    }
    /**
     * Default constructor required by framework.
     */
    public NavigationBar() {
        super();
    }


    @Override
    public void onStart() {
        super.onStart();
        setListAdapter(mAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mItemSelectedListener = (OnNavigationItemSelectedListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnNavigationItemSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mAdapter = new NavigationItemAdapter(getActivity());
        init();
    }

    private void init() {
        mAdapter.add(new RecommendationNavItem(mContext));
        mAdapter.add(new MyGameNavItem(mContext));
        mAdapter.add(new RankNavItem(mContext));
        mAdapter.add(new AllGamesNavItem(mContext));
        mAdapter.setItemClientListener(this);
    }


    @Override
    public void onItemChangeListener(NavigationItem newItem, NavigationItem oldItem) {
        mItemSelectedListener.onNavigationItemSelectedListener(newItem);
    }
}
