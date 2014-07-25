package com.example.android.tv.utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.android.tv.model.UserInfo;

public class UserInfoRepository {
    private UserInfoDBHelper mDbHelper;


    public UserInfoRepository(Context context) {
        mDbHelper = new UserInfoDBHelper(context);
    }

    public static abstract class UserInfoEntry implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
        //for demo only
        public static final String COLUMN_NAME_USER_PASSWORD = "user_password";
        public static final String COLUMN_NAME_USER_EMAIL = "user_email";
        public static final String COLUMN_NAME_USER_ICON = "user_icon";
        public static final String COLUMN_NAME_USER_POINTS = "user_points";

    }
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_USER_INFOS =
            "CREATE TABLE " + UserInfoEntry.TABLE_NAME + " (" +
                    UserInfoEntry._ID + " INTEGER PRIMARY KEY," +
                    UserInfoEntry.COLUMN_NAME_USER_ID + INTEGER_TYPE + COMMA_SEP +
                    UserInfoEntry.COLUMN_NAME_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    UserInfoEntry.COLUMN_NAME_USER_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    UserInfoEntry.COLUMN_NAME_USER_EMAIL + TEXT_TYPE + COMMA_SEP +
                    UserInfoEntry.COLUMN_NAME_USER_ICON + TEXT_TYPE + COMMA_SEP +
                    UserInfoEntry.COLUMN_NAME_USER_POINTS + INTEGER_TYPE +
            " )";

    public static final String SQL_DELETE_USER_INFOS =
            "DROP TABLE IF EXISTS " + UserInfoEntry.TABLE_NAME;

    public Long insert(UserInfo userInfo) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserInfoEntry.COLUMN_NAME_USER_ID, userInfo.getUserId());
        values.put(UserInfoEntry.COLUMN_NAME_USER_EMAIL, userInfo.getUserEmail());
        values.put(UserInfoEntry.COLUMN_NAME_USER_ICON, userInfo.getUserIcon());
        values.put(UserInfoEntry.COLUMN_NAME_USER_NAME, userInfo.getUserName());
        values.put(UserInfoEntry.COLUMN_NAME_USER_PASSWORD, userInfo.getUserPassword());
        values.put(UserInfoEntry.COLUMN_NAME_USER_POINTS, userInfo.getUserPoints());

        long newRowId;
        newRowId = db.insert(
                UserInfoEntry.TABLE_NAME, null,
                values);
        return newRowId;
    }

    public UserInfo getUserInfo(Long userId) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                UserInfoEntry._ID,
                UserInfoEntry.COLUMN_NAME_USER_ID,
                UserInfoEntry.COLUMN_NAME_USER_NAME,
                UserInfoEntry.COLUMN_NAME_USER_EMAIL,
                UserInfoEntry.COLUMN_NAME_USER_ICON,
                UserInfoEntry.COLUMN_NAME_USER_POINTS
        };

        String selection = UserInfoEntry.COLUMN_NAME_USER_ID + " = ?";
        String[] selectionArgs = { String.valueOf(userId) };

        Cursor cursor = db.query(
                UserInfoEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        cursor.moveToFirst();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_ID)));
        userInfo.setUserEmail(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_EMAIL)));
        userInfo.setUserIcon(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_ICON)));
        userInfo.setUserPoints(cursor.getLong(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_POINTS)));
        return userInfo;
    }

    public UserInfo getUserInfoByName(String username, String password) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                UserInfoEntry._ID,
                UserInfoEntry.COLUMN_NAME_USER_ID,
                UserInfoEntry.COLUMN_NAME_USER_NAME,
                UserInfoEntry.COLUMN_NAME_USER_EMAIL,
                UserInfoEntry.COLUMN_NAME_USER_ICON,
                UserInfoEntry.COLUMN_NAME_USER_POINTS
        };

        String selection = UserInfoEntry.COLUMN_NAME_USER_NAME + " = ? AND " + UserInfoEntry.COLUMN_NAME_USER_PASSWORD + " = ?";
        String[] selectionArgs = { username, password };

        Cursor cursor = db.query(
                UserInfoEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        cursor.moveToFirst();
        if (cursor.getCount() == 1) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(cursor.getLong(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_ID)));
            userInfo.setUserName(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_ID)));
            userInfo.setUserEmail(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_EMAIL)));
            userInfo.setUserIcon(cursor.getString(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_ICON)));
            userInfo.setUserPoints(cursor.getLong(cursor.getColumnIndexOrThrow(UserInfoEntry.COLUMN_NAME_USER_POINTS)));
            return userInfo;
        }
        return null;
    }
}
