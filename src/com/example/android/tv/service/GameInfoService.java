package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.R;
import com.example.android.tv.model.GameItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donaldzhu on 6/27/2014.
 */
public class GameInfoService {
    private Context mContext;
    private static final Object mInstanceSync = new Object();
    private static GameInfoService INSTANCE = null;

    private GameInfoService(Context context) {
        mContext = context;
    }

    public static GameInfoService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new GameInfoService(context);
            }
        }
        return INSTANCE;
    }

    public List<GameItem> getGameItems() {
        List<GameItem> gameItems = new ArrayList<GameItem>();
        final int[] ids = {R.drawable.game_1, R.drawable.game_2,
                R.drawable.game_3, R.drawable.game_4,
                R.drawable.game_5, R.drawable.game_6,
                R.drawable.game_7, R.drawable.game_8,
                };
        for(int i = 0; i < ids.length; i++) {
            gameItems.add(new GameItem(String.valueOf(i + 1), ids[i], 4));
        }
        return gameItems;
    }
}
