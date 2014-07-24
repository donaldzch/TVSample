package com.example.android.tv.model;

import com.example.android.tv.utils.ListXmlParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfo implements Serializable {
    private Long mUserId;
    private CharSequence mUserName;
    private String mUserIcon;
    private Long mUserPoints;
    private List<Long> mOwnedGames;
    private Map<Long, GameAchievement> mAchievements;

    public UserInfo() {
        mOwnedGames = new ArrayList<Long>();
        mAchievements = new HashMap<Long, GameAchievement>();
    }

    public void setUserIcon(String userIcon) {
        mUserIcon = userIcon;
    }

    public String getUserIcon() {
        return mUserIcon;
    }

    public void setUserPoints(Long userPoints) {
        mUserPoints = userPoints;
    }

    public Long getUserPoints() {
        return mUserPoints;
    }

    public void setUserId(Long userId) {
        mUserId = userId;
    }

    public Long getUserId() {
        return mUserId;
    }

    public void setUserName(CharSequence userName) {
        mUserName = userName;
    }

    public CharSequence getUserName() {
        return mUserName;
    }

    public void setOwnedGames(List<Long> ownedGames) {
        mOwnedGames = ownedGames;
    }

    public List<Long> getOwnedGames() {
        return mOwnedGames;
    }

    public void addAchievement(GameAchievement achievement) {
        mAchievements.put(achievement.getGameId(), achievement);
    }

    public Map<Long, GameAchievement> getGameAchievements() {
        return mAchievements;
    }
}
