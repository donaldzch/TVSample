package com.example.android.tv.navigation;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.tv.R;

public class NavItemOneListView extends NavItemListView {
    private ListView mListView;
    private String mChoice;


    public NavItemOneListView(Context context, CharSequence text) {
        super(context, text);
        mResourceId = R.layout.nav_item_with_one_list;
    }


    @Override
    public void expand() {
        adjustLayout(mExpand ? mResources.getDimensionPixelSize(R.dimen.nav_item_expanded_view_height) : mResources.getDimensionPixelSize(R.dimen.nav_item_view_height));
        mListView.setVisibility(mExpand ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void setUpListView() {
        mListView = (ListView)mView.findViewById(R.id.listView);
        mListView.setAdapter(new ArrayAdapter<String>(getContext(),
                R.layout.custom_text_view, mResources.getStringArray(R.array.all_game_nav_item_list_values)));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mChoice = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), mChoice, Toast.LENGTH_SHORT).show();
            }
        });
        mChoice = mListView.getAdapter().getItem(0).toString();
    }
}
