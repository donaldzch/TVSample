package com.example.android.tv;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.android.tv.navigation.NavigationItem;

/**
 * Created by donaldzhu on 6/23/2014.
 */
public class TVActivity  extends FragmentActivity
        implements NavigationBar.OnNavigationItemSelectedListener {
    private TopBar mTopBar;
    private FootBar mFootBar;
    private NavigationBar mNavigationBar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mNavigationBar = (NavigationBar)getSupportFragmentManager().findFragmentById(R.id.nav_bar);
        RecommendationFragment recommendationFragment = new RecommendationFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.content, recommendationFragment).commit();
    }

    @Override
    public void onNavigationItemSelectedListener(NavigationItem item) {
        Toast.makeText(this, item.getTag(), Toast.LENGTH_SHORT).show();
        ContentFragment contentFragment = (ContentFragment)getSupportFragmentManager().findFragmentById(R.id.content);
        contentFragment.display("hello");
    }
}