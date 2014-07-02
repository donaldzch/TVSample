package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.model.GameAchievement;
import com.example.android.tv.model.UserInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoService {
    private Context mContext;
    private static final Object mInstanceSync = new Object();
    private static UserInfoService INSTANCE = null;
    private UserInfo mCurrentUser;
    private Map<Long, UserInfo> mUsers = new HashMap<Long, UserInfo>();

    private UserInfoService(Context context) {
        mContext = context;
        makeUsers();
    }

    public static UserInfoService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new UserInfoService(context);
            }
        }
        return INSTANCE;
    }

    private void makeUsers() {
        for (int i = 1; i <= 3; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(Long.valueOf(i));
            userInfo.setUserName("user " + i);
            Long[] gameList = {100L, 101L, 102L};
            userInfo.setOwnedGames(Arrays.asList(gameList));
            mUsers.put(userInfo.getUserId(), userInfo);
        }
        mCurrentUser = mUsers.get(Long.valueOf(1));
        GameAchievement gameAchievement = new GameAchievement(mCurrentUser.getUserId(), mCurrentUser.getOwnedGames().get(0));
        gameAchievement.addAchievement("爆头率", "21%");
        gameAchievement.addAchievement("已杀僵尸", "350014");
        gameAchievement.addAchievement("失败数", "155");
        gameAchievement.addAchievement("已玩时间", "302小时");
        gameAchievement.addAchievement("本周总分", "15963586215");
        mCurrentUser.addAchievement(gameAchievement);
    }

    public void setCurrentUser(UserInfo user) {
        mCurrentUser = user;
    }

    public UserInfo getCurrentUser() {
        return mCurrentUser;
    }

    public void addUser(UserInfo user) {
        mUsers.put(user.getUserId(), user);
    }

    public List<UserInfo> getAllUsers() {
        return new ArrayList<UserInfo>(mUsers.values());
    }
}
