package com.example.android.tv.gameinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donaldzhu on 6/28/2014.
 */
public class GameInfoAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    public GameInfoAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<Fragment>();
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }
    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
