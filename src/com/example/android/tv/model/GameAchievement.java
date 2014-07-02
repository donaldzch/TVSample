package com.example.android.tv.model;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class GameAchievement implements Serializable {
    private Long mUserId;
    private Long mGameId;
    private Map<CharSequence, CharSequence> mAchievements;

    public GameAchievement(Long userId, Long gameId) {
        mUserId = userId;
        mGameId = gameId;
        mAchievements = new TreeMap<CharSequence, CharSequence>();
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setGameId(Long gameId) {
        mGameId = gameId;
    }

    public Long getGameId() {
        return mGameId;
    }

    public void setAchievements(Map<CharSequence, CharSequence> achievements) {
        mAchievements = achievements;
    }

    public Map<CharSequence, CharSequence> getAchievements() {
        return mAchievements;
    }

    public void addAchievement(CharSequence title, CharSequence value) {
        mAchievements.put(title, value);
    }
}
