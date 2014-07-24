package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.android.tv.model.CategoryItem;
import com.example.android.tv.service.CategoryService;
import com.example.android.tv.service.GameInfoService;
import com.example.android.tv.view.content.GameItemListFragment;
import com.example.android.tv.view.FootBar;
import com.example.android.tv.view.NavigationBar;
import com.example.android.tv.view.TopBar;

public class TVActivity  extends FragmentActivity
        implements NavigationBar.OnNavigationItemSelectedListener {
    private TopBar mTopBar;
    private FootBar mFootBar;
    private NavigationBar mNavigationBar;
    private String mCurrentFragmentTag;
    private GameInfoService mGameInfoService;
    private CategoryService mCategoryService;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mNavigationBar = (NavigationBar)getSupportFragmentManager().findFragmentById(R.id.nav_bar);
        mGameInfoService = GameInfoService.getInstance(this);
        mCategoryService = CategoryService.getInstance(this);
        startFragmentTransition(Constants.RECOMMENDATION_FRAGMENT);
    }

    @Override
    public void onNavigationItemSelectedListener(String tag, Long mainCategory, Long subCategory) {
        if (mCurrentFragmentTag.equals(tag)) {
            getCurrentFragment().refresh(mGameInfoService.getGameItemsByTagAndCategory(tag, mainCategory, subCategory));
        } else {
            startFragmentTransition(tag);
        }
    }

    private GameItemListFragment getCurrentFragment() {
        return (GameItemListFragment)getSupportFragmentManager().findFragmentByTag(mCurrentFragmentTag);
    }

    private void startFragmentTransition(String tag) {
        CategoryItem categoryItem = mCategoryService.getCategory(tag);
        mCurrentFragmentTag = tag;
        Bundle bundle = new Bundle();

        bundle.putSerializable(Constants.GAME_ITEMS_KEY, mGameInfoService.getGameItemsByCategory(categoryItem));
        GameItemListFragment contentFragment = new GameItemListFragment();
        contentFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.content, contentFragment, tag).commit();
    }
}