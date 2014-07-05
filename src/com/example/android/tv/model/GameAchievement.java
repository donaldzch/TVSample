package com.example.android.tv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameAchievement implements Serializable {
    private Long mUserId;
    private Long mGameId;
    private List<AchievementDetail> mAchievements;

    public GameAchievement(Long userId, Long gameId) {
        mUserId = userId;
        mGameId = gameId;
        mAchievements = new ArrayList<AchievementDetail>();
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

    public void setAchievements(List<AchievementDetail> achievements) {
        mAchievements = achievements;
    }

    public List<AchievementDetail> getAchievements() {
        return mAchievements;
    }

    public void addAchievement(CharSequence title, CharSequence value) {
        mAchievements.add(new AchievementDetail(title, value));
    }

    public class AchievementDetail implements Serializable {
        private CharSequence mTitle;
        private CharSequence mValue;

        AchievementDetail(CharSequence title, CharSequence value) {
            mTitle = title;
            mValue = value;
        }

        public CharSequence getTitle() {
            return mTitle;
        }

        public CharSequence getValue() {
            return mValue;
        }
    }
}
