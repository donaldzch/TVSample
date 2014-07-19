package com.example.android.tv.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.tv.R;
import com.example.android.tv.view.navigation.NavItemOneListView;
import com.example.android.tv.view.navigation.NavItemTextView;
import com.example.android.tv.view.navigation.NavItemTwoListView;
import com.example.android.tv.view.navigation.NavigationItem;
import com.example.android.tv.view.navigation.NavigationItemAdapter;
import com.example.android.tv.view.navigation.NavigationItemClickListener;
import com.example.android.tv.service.NavigationService;


public class NavigationBar extends Fragment implements NavigationItemClickListener {
    private Context mContext;
    private NavigationItemAdapter mAdapter;
    private OnNavigationItemSelectedListener mItemSelectedListener;
    private NavigationService mService;

    public interface OnNavigationItemSelectedListener {
        public void onNavigationItemSelectedListener(Long tag, Long mainCategory, Long subCategory);
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
        mAdapter = new NavigationItemAdapter();
        mService = NavigationService.getInstance(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_bar, container, false);

        NavItemTwoListView recommendationNav = (NavItemTwoListView)view.findViewById(R.id.recommendation_nav_item);
        recommendationNav.setUpListView(mService.getCategory(recommendationNav.getTag().toString()));
        mAdapter.addNavigationItem(new NavigationItem(recommendationNav, this));

        NavItemTextView myGameNav = (NavItemTextView)view.findViewById(R.id.my_game_nav_item);
        myGameNav.setUpListView(mService.getCategory(myGameNav.getTag().toString()));
        mAdapter.addNavigationItem(new NavigationItem(myGameNav, this));

        NavItemTwoListView rankingListNav = (NavItemTwoListView)view.findViewById(R.id.ranking_list_nav_item);
        rankingListNav.setUpListView(mService.getCategory(rankingListNav.getTag().toString()));
        mAdapter.addNavigationItem(new NavigationItem(rankingListNav, this));

        NavItemOneListView allGameNav = (NavItemOneListView)view.findViewById(R.id.all_game_nav_item);
        allGameNav.setUpListView(mService.getCategory(allGameNav.getTag().toString()));
        mAdapter.addNavigationItem(new NavigationItem(allGameNav, this));

        mAdapter.setCurrentItem(recommendationNav.getCategoryId());
        return view;
    }


    @Override
    public void onItemClick(Long tag, Long mainCategory, Long subCategory) {
        mAdapter.setCurrentItem(tag);
        Toast.makeText(getActivity(), "tag: " + tag + " main: " + mainCategory + " sub: " + subCategory, Toast.LENGTH_SHORT).show();
        mItemSelectedListener.onNavigationItemSelectedListener(tag, mainCategory, subCategory);
    }

}
