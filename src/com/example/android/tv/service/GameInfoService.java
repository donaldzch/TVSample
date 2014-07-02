package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.R;
import com.example.android.tv.gameinfo.GameIntroductionFragment;
import com.example.android.tv.model.GameAchievement;
import com.example.android.tv.model.GameItem;
import com.example.android.tv.model.GameRankingList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInfoService {
    private Context mContext;
    private static final Object mInstanceSync = new Object();
    private static GameInfoService INSTANCE = null;
    private Map<Long, GameItem> mGameItems = new HashMap<Long, GameItem>();


    private GameInfoService(Context context) {
        mContext = context;
        makeGameItems();
    }

    private void makeGameItems() {
        final int[] ids = {R.drawable.game_1, R.drawable.game_2,
                R.drawable.game_3, R.drawable.game_4,
                R.drawable.game_5, R.drawable.game_6,
                R.drawable.game_7, R.drawable.game_8,
        };
        for(int i = 0; i < ids.length; i++) {
            GameItem gameItem = new GameItem(String.valueOf(i + 1), ids[i], 4);
            gameItem.setGameId(Long.valueOf((i + 100)));
            gameItem.setDescription("hello world hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello worldhello world" +
                    "hello worldhello worldhello worldhello worldhello worldhello world");
            gameItem.setInstalled(true);
            gameItem.setVendors(new int[]{R.drawable.game_4, R.drawable.game_5});
            mGameItems.put(gameItem.getGameId(), gameItem);
        }
        GameItem gameItem = mGameItems.get(Long.valueOf(100));
        GameRankingList gameRankingList = new GameRankingList();
        gameRankingList.addRankedUser("1. helloworld", "13234542354365436");
        gameRankingList.addRankedUser("2. helloworld", "123232423423");
        gameRankingList.addRankedUser("3. helloworld", "123232423423");
        gameItem.setGameRankingList(gameRankingList);
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
        return new ArrayList<GameItem>(mGameItems.values());
    }

    public GameItem getGameItem(Long gameId) {
        return mGameItems.get(gameId);
    }
}
