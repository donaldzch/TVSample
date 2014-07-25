package com.example.android.tv.service;

import android.content.Context;

import com.example.android.tv.model.UserInfo;
import com.example.android.tv.utils.UserInfoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInfoService {
    private Context mContext;
    private static final Object mInstanceSync = new Object();
    private static UserInfoService INSTANCE = null;
    private UserInfo mCurrentUser;
    private Map<Long, UserInfo> mUsers = new HashMap<Long, UserInfo>();
    private UserInfoRepository mUserRepo;
    private static Long mUserCount = 0L;

    private UserInfoService(Context context) {
        mContext = context;
        mUserRepo = new UserInfoRepository(context);
    }

    public static UserInfoService getInstance(Context context) {
        synchronized (mInstanceSync) {
            if (INSTANCE == null) {
                INSTANCE = new UserInfoService(context);
            }
        }
        return INSTANCE;
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

    public boolean login(String username, String password) {
        UserInfo loginUser = mUserRepo.getUserInfoByName(username, password);
        if (loginUser == null) {
            return false;
        }
        setCurrentUser(loginUser);
        return true;
    }

    public UserInfo register(UserInfo newUser) {
        newUser.setUserId(++mUserCount);
        mUserRepo.insert(newUser);
        return newUser;
    }
}
