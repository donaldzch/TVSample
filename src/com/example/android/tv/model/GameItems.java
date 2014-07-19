package com.example.android.tv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameItems implements Serializable {
    private List<GameItem> mGameItems;

    public GameItems() {
        mGameItems = new ArrayList<GameItem>();
    }

    public void setGameItems(List<GameItem> gameItems) {
        mGameItems = gameItems;
    }

    public List<GameItem> getGameItems() {
        return mGameItems;
    }

    public void addGameItem(GameItem gameItem) {
        mGameItems.add(gameItem);
    }

    public int size() {
        return mGameItems.size();
    }
}
