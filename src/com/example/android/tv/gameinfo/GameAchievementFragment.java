package com.example.android.tv.gameinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.model.GameAchievement;
import com.example.android.tv.model.GameItem;

import java.util.Arrays;

public class GameAchievementFragment extends Fragment {
    private ImageView mGameImage;
    private ListView mGameAchievementDetails;
    private TextView mStarPlayerTitle;
    private ImageView mStarPlayerImage;
    private ListView mStarPlayerList;
    private GameItem mGameItem;
    private GameAchievement mGameAchievement;
    private GameAchievementListAdapter mAchievementAdapter;
    private GameAchievementListAdapter mStarPlayerAdapter;
    private GridView mRecommendedGames;
    private RecommendedGameImageListAdapter mRecommendedGamesAdapter;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameItem = (GameItem)getArguments().getSerializable("game");
        mGameAchievement = (GameAchievement)getArguments().getSerializable("achievement");
        mAchievementAdapter = new GameAchievementListAdapter(getActivity(), mGameAchievement.getAchievements());
        //mStarPlayerAdapter = new GameAchievementListAdapter(getActivity(), mGameItem.getGameRankingList().getRankedUsers());
        mRecommendedGamesAdapter = new RecommendedGameImageListAdapter(getActivity(), Arrays.asList(new Integer[] {R.drawable.game_5, R.drawable.game_4, R.drawable.game_7, R.drawable.game_8}));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_introduction_achievement, container, false);
        mGameImage = (ImageView)view.findViewById(R.id.game_image_achievement);
        mGameAchievementDetails = (ListView)view.findViewById(R.id.game_achievement_details);
        mStarPlayerTitle = (TextView)view.findViewById(R.id.star_player_title);
        mStarPlayerImage = (ImageView)view.findViewById(R.id.star_player_image);
        mStarPlayerList = (ListView)view.findViewById(R.id.star_player_list);
        mRecommendedGames = (GridView)view.findViewById(R.id.recommended_games);


        mGameImage.setImageDrawable(getResources().getDrawable(mGameItem.getImageId()));

        mGameAchievementDetails.setAdapter(mAchievementAdapter);
        mStarPlayerTitle.setText(getResources().getString(R.string.star_player_title));
        mStarPlayerImage.setImageDrawable(getResources().getDrawable(R.drawable.game_8));
        mStarPlayerList.setAdapter(mStarPlayerAdapter);

        mRecommendedGames.setAdapter(mRecommendedGamesAdapter);
        return view;
    }
}
