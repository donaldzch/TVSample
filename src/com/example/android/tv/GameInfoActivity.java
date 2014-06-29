package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.android.tv.content.CircleIndicatorView;
import com.example.android.tv.gameinfo.GameInfoAdapter;

/**
 * Created by donaldzhu on 6/28/2014.
 */
public class GameInfoActivity extends FragmentActivity {
    private ViewPager mPager;
    private GameInfoAdapter mAdapter;
    private CircleIndicatorView mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_info);

        mAdapter = new GameInfoAdapter(getSupportFragmentManager());
        Bundle bundle = new Bundle();
        bundle.putCharSequence("key", "hello");
        ContentFragment contentFragment = new ContentFragment();
        contentFragment.setArguments(bundle);
        Bundle bundle1 = new Bundle();
        bundle1.putCharSequence("key", "world");
        ContentFragment contentFragment1 = new ContentFragment();

        contentFragment1.setArguments(bundle1);
        ContentFragment contentFragment2 = new ContentFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("key", "you");
        contentFragment2.setArguments(bundle2);
        mAdapter.addFragment(contentFragment);
        mAdapter.addFragment(contentFragment1);
        mAdapter.addFragment(contentFragment2);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CircleIndicatorView)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        mIndicator.setCurrentItem(0);

        //You can also do: indicator.setViewPager(pager, initialPage);
    }
}
