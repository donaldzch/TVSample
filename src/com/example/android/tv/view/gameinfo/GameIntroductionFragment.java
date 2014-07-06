package com.example.android.tv.view.gameinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tv.R;
import com.example.android.tv.view.content.GameVendorListView;
import com.example.android.tv.view.content.StarRankView;
import com.example.android.tv.model.GameItem;

public class GameIntroductionFragment extends Fragment {
    private GameVendorListView mGameVendorView;
    private ImageView mGameImage;
    private TextView mGameTitle;
    private TextView mGameDescription;
    private StarRankView mGameRank;
    private ImageView mActionBtn;
    private TextView mActionText;
    private GameItem mGameItem;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameItem = (GameItem)getArguments().getSerializable("game");
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_introduction, container, false);
        mGameImage = (ImageView)view.findViewById(R.id.game_introduction_image);
        mGameVendorView = (GameVendorListView)view.findViewById(R.id.game_vendor_image);
        mGameTitle = (TextView)view.findViewById(R.id.game_title);
        mGameDescription = (TextView)view.findViewById(R.id.game_description);
        mGameRank = (StarRankView)view.findViewById(R.id.game_rank);
        mActionBtn = (ImageView)view.findViewById(R.id.action_btn);
        mActionText = (TextView)view.findViewById(R.id.action_text);
        mGameImage.setImageDrawable(getResources().getDrawable(mGameItem.getImageId()));
        mGameVendorView.render(mGameItem.getVendors());
        mGameTitle.setText(mGameItem.getTitle());
        mGameRank.render(mGameItem.getRank());
        mGameDescription.setText(mGameItem.getDescription());
        if (mGameItem.isInstalled()) {
            mActionBtn.setImageDrawable(getResources().getDrawable(R.drawable.launch_action));
            mActionText.setText(getResources().getText(R.string.download_game_text));
        } else {
            mActionBtn.setImageDrawable(getResources().getDrawable(R.drawable.download_action));
            mActionText.setText(getResources().getText(R.string.start_game_text));
        }
        return view;
    }
}
