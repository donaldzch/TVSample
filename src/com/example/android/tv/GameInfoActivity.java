package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.android.tv.content.CircleIndicatorView;
import com.example.android.tv.gameinfo.GameAchievementFragment;
import com.example.android.tv.gameinfo.GameInfoFragmentAdapter;
import com.example.android.tv.gameinfo.GameIntroductionFragment;
import com.example.android.tv.model.GameItem;
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
        Bundle bundle = new Bundle();

        bundle.putSerializable("game", GameInfoService.getInstance(this).getGameItem(100L));
        GameIntroductionFragment contentFragment = new GameIntroductionFragment();
        contentFragment.setArguments(bundle);
        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("game", GameInfoService.getInstance(this).getGameItem(100L));
        bundle1.putSerializable("achievement", UserInfoService.getInstance(this).getCurrentUser().getGameAchievements().get(100L));
        GameAchievementFragment contentFragment1 = new GameAchievementFragment();

        contentFragment1.setArguments(bundle1);
        ContentFragment contentFragment2 = new ContentFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("key", "you");
        contentFragment2.setArguments(bundle2);
        mAdapter.addFragment(contentFragment1);
        mAdapter.addFragment(contentFragment);
        mAdapter.addFragment(contentFragment2);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CircleIndicatorView)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(0);

        //You can also do: indicator.setViewPager(pager, initialPage);
    }
}
