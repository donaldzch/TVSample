package com.example.android.tv.model;


public class GameItem {
    private CharSequence mTitle;
    private int mRank;
    private int mImageId;

    public GameItem(CharSequence title, int imageId, int rank) {
        mTitle = title;
        mImageId = imageId;
        mRank = rank;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public void setTitle(CharSequence Title) {
        this.mTitle = Title;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }

    public int getRank() {
        return mRank;
    }

    public void setRank(int rank) {
        this.mRank = rank;
    }
}
