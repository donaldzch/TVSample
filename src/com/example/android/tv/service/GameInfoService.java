package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.R;
import com.example.android.tv.model.CategoryItem;
import com.example.android.tv.model.GameItem;
import com.example.android.tv.model.GameItems;
import com.example.android.tv.model.GameRankingList;
import com.example.android.tv.utils.GameItemXmlParser;
import com.example.android.tv.utils.ListXmlParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInfoService {
    private Context mContext;
    private static final Object mInstanceSync = new Object();
    private static GameInfoService INSTANCE = null;
    private Map<Long, GameItem> mGameItems = new HashMap<Long, GameItem>();
    private GameItemXmlParser mGameItemParser;

    private Map<String, Integer> gameListParserMapping;

    private GameInfoService(Context context) {
        mContext = context;
        initialize();
    }

    private void initialize() {
        mGameItemParser = new GameItemXmlParser();
        gameListParserMapping = new HashMap<String, Integer>();
        gameListParserMapping.put(mContext.getString(R.string.recommendation_item_tag), R.xml.recommended_games);
        gameListParserMapping.put(mContext.getString(R.string.all_games_item_tag), R.xml.all_game_list);
        gameListParserMapping.put(mContext.getString(R.string.rank_item_tag), R.xml.game_ranking_list);
    }

     public static GameInfoService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new GameInfoService(context);
            }
        }
        return INSTANCE;
    }


    public GameItems getGameItemsByCategory(CategoryItem categoryItem) {
        GameItems gameItems = new GameItems();
        String tag = categoryItem.getName().toString();
        Long mainCategoryId = -1L;
        Long subCategoryId = -1L;
        if (categoryItem.getChildrenItems() != null) {
            CategoryItem mainCategory = categoryItem.getChildrenItems().get(0);
            mainCategoryId = mainCategory.getId();
            if (mainCategory.getChildrenItems() != null) {
                subCategoryId = mainCategory.getChildrenItems().get(0).getId();
            }
        }
        return getGameItemsByTagAndCategory(tag, mainCategoryId, subCategoryId);
    }

    public GameItems getGameItemsByTagAndCategory(String tag, Long mainCategory, Long subCategory) {
        GameItems gameItems = new GameItems();
        int resId = gameListParserMapping.get(tag);
        ListXmlParser parser = new ListXmlParser();
        try {
            List<Long> gameIds = parser.parse(mContext.getResources().openRawResource(resId));
            for (Long gameId : gameIds) {
                gameItems.addGameItem(getGameItemByParser(gameId));
            }
        } catch (Exception e) {

        }
        GameItems filtered = new GameItems();
        for (GameItem gameItem : gameItems.getGameItems()) {
            if (mainCategory == 0) {
                if (gameItem.getPrice() == 0 && gameItem.getType().equals(subCategory)) {
                    filtered.addGameItem(gameItem);
                }
            } else if (mainCategory == 1) {
                if (gameItem.getPrice() > 0 && gameItem.getType().equals(subCategory)) {
                    filtered.addGameItem(gameItem);
                }
            } else if (mainCategory == 2) {

            }
        }
        return gameItems;
    }

    public GameItem getGameItemByParser(Long gameId) throws Exception {
        int resId = mContext.getResources().getIdentifier("game_" + gameId, "xml", mContext.getPackageName());
        return mGameItemParser.parse(mContext.getResources().openRawResource(resId));
    }
}
