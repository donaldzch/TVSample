package com.example.android.tv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.android.tv.model.GameItem;
import com.example.android.tv.view.gameinfo.CircleIndicatorView;
import com.example.android.tv.view.gameinfo.GameAchievementFragment;
import com.example.android.tv.adapter.GameInfoFragmentAdapter;
import com.example.android.tv.view.gameinfo.GameIntroductionFragment;
import com.example.android.tv.service.GameInfoService;
import com.example.android.tv.service.UserInfoService;

public class GameInfoActivity extends FragmentActivity {
    private ViewPager mPager;
    private GameInfoFragmentAdapter mAdapter;
    private CircleIndicatorView mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_info);

        mAdapter = new GameInfoFragmentAdapter(getSupportFragmentManager());

        Intent intent = getIntent();

        GameItem gameItem = (GameItem)intent.getSerializableExtra(Constants.GAME_ITEM_KEY);
        Bundle bundle = new Bundle();

        bundle.putSerializable(Constants.GAME_ITEM_KEY, gameItem);
        GameIntroductionFragment introductionFragment = new GameIntroductionFragment();
        introductionFragment.setArguments(bundle);
        Bundle bundle1 = new Bundle();


        bundle1.putSerializable(Constants.GAME_ITEM_KEY, gameItem);
        bundle1.putSerializable("achievement", UserInfoService.getInstance(this).getCurrentUser().getGameAchievements().get(100L));
        GameAchievementFragment achieveFragment = new GameAchievementFragment();

        achieveFragment.setArguments(bundle1);
        mAdapter.addFragment(introductionFragment);
        mAdapter.addFragment(achieveFragment);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CircleIndicatorView)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(0);

        //You can also do: indicator.setViewPager(pager, initialPage);
    }
}
