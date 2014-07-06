package com.example.android.tv.view.content;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.android.tv.R;
import com.example.android.tv.adapter.GameItemListAdapter;
import com.example.android.tv.model.GameItem;
import com.example.android.tv.service.GameInfoService;

import java.util.List;

public class RecommendationFragment extends Fragment {
    private GridView mGridView;
    private GameItemListAdapter mAdapter;
    private GameInfoService mGameInfoService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameInfoService = GameInfoService.getInstance(getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<GameItem> gameItems = mGameInfoService.getGameItems();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gameItems.size() * getResources().getDimensionPixelSize(R.dimen.game_item_one_row_width), ViewGroup.LayoutParams.WRAP_CONTENT);
        mGridView.setLayoutParams(params);
        mGridView.setColumnWidth(getResources().getDimensionPixelSize(R.dimen.game_image_width));
        mGridView.setHorizontalSpacing(getResources().getDimensionPixelSize(R.dimen.game_item_horizontal_spacing));
        mGridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        mGridView.setNumColumns(gameItems.size());
        mAdapter = new GameItemListAdapter(getActivity(), gameItems);

        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAdapter.setSelectIndex(position);
                mAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.recomendation_fragment, container, false);
        mGridView = (GridView)view.findViewById(R.id.grid_view);
        return view;
    }
}
