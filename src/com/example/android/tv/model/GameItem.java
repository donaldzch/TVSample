package com.example.android.tv.model;


import java.io.Serializable;

public class GameItem implements Serializable {
    private CharSequence mTitle;
    private int mRank;
    private int mImageId;
    private int[] mVendors;
    private CharSequence mDescription;
    private boolean mIsInstalled;

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

    public int[] getVendors() {
        return mVendors;
    }

    public void setVendors(int[] vendors) {
        mVendors = vendors;
    }

    public CharSequence getDescription() {
        return mDescription;
    }

    public void setDescription(CharSequence description) {
        mDescription = description;
    }

    public boolean isInstalled() {
        return mIsInstalled;
    }

    public void setInstalled(boolean installed) {
        mIsInstalled = true;
    }
}
