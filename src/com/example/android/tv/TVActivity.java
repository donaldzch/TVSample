package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.android.tv.model.CategoryItem;
import com.example.android.tv.service.GameInfoService;
import com.example.android.tv.service.NavigationService;
import com.example.android.tv.view.content.GameItemListFragment;
import com.example.android.tv.view.navigation.NavigationItem;
import com.example.android.tv.view.FootBar;
import com.example.android.tv.view.NavigationBar;
import com.example.android.tv.view.TopBar;

public class TVActivity  extends FragmentActivity
        implements NavigationBar.OnNavigationItemSelectedListener {
    private TopBar mTopBar;
    private FootBar mFootBar;
    private NavigationBar mNavigationBar;
    private Long mCurrentFragment;
    private String mCurrentFragmentTag;
    private GameInfoService mGameInfoService;
    private NavigationService mNavigationService;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mNavigationBar = (NavigationBar)getSupportFragmentManager().findFragmentById(R.id.nav_bar);
        mGameInfoService = GameInfoService.getInstance(this);
        startFragmentTransition(Constants.RECOMMENDATION_FRAGMENT);
    }

    @Override
    public void onNavigationItemSelectedListener(Long tag, Long mainCategory, Long subCategory) {
        if (mCurrentFragment.equals(tag)) {
            getCurrentFragment().refresh();
        } else {
            startFragmentTransition(tag);
        }
    }

    private GameItemListFragment getCurrentFragment() {
        return (GameItemListFragment)getSupportFragmentManager().findFragmentByTag(mCurrentFragmentTag);
    }

    private void startFragmentTransition(String tag) {
        CategoryItem categoryItem = mNavigationService.getCategory(tag);
        startFragmentTransition(categoryItem.getId());
    }

    private void startFragmentTransition(Long tag) {
        CategoryItem categoryItem = mNavigationService.getCategory(tag);
        mCurrentFragment = categoryItem.getId();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.GAME_ITEMS_KEY, mGameInfoService.getGameItemsByTag(categoryItem.getName().toString()));
        GameItemListFragment recommendationFragment = new GameItemListFragment();
        recommendationFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.content, recommendationFragment, categoryItem.getName().toString()).commit();
    }
}