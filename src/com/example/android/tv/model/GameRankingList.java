package com.example.android.tv.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class GameRankingList implements Serializable {
    private Long mGameId;
    private Map<CharSequence, CharSequence> mRankedUsers;

    public GameRankingList() {
        mRankedUsers = new TreeMap<CharSequence, CharSequence>();
    }

    public void setGameId(Long gameId) {
        mGameId = gameId;
    }

    public Long getGameId() {
        return mGameId;
    }

    public void addRankedUser(CharSequence userName, CharSequence credits) {
        mRankedUsers.put(userName, credits);
    }

    public Map<CharSequence, CharSequence> getRankedUsers() {
        return mRankedUsers;
    }

}
