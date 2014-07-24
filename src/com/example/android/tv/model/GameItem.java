package com.example.android.tv.model;


import java.io.Serializable;

public class GameItem implements Serializable {
    private Long mGameId;
    private CharSequence mTitle;
    private Long mType;
    private String mIcon;
    private String mImage;
    private int mRank;
    private int mImageId;
    private String[] mVendors;
    private CharSequence mDescription;
    private Long mPrice;
    private String[] mScreenShots;

    private boolean mIsInstalled;
    private GameRankingList mGameRankingList;

    public GameItem() {

    }

    public GameItem(CharSequence title, int imageId, int rank) {
        mTitle = title;
        mImageId = imageId;
        mRank = rank;
    }

    public void setGameId(Long gameId) {
        mGameId = gameId;
    }

    public Long getGameId() {
        return mGameId;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public void setTitle(CharSequence Title) {
        this.mTitle = Title;
    }

    public void setType(Long type) {
        mType = type;
    }

    public Long getType() {
        return mType;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getImage() {
        return mImage;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setScreenShots(String[] screenShots) {
        mScreenShots = screenShots;
    }

    public String[] getScreenShots() {
        return mScreenShots;
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

    public String[] getVendors() {
        return mVendors;
    }

    public void setVendors(String[] vendors) {
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

    public void setGameRankingList(GameRankingList gameRankingList) {
        mGameRankingList = gameRankingList;
    }

    public GameRankingList getGameRankingList() {
        return mGameRankingList;
    }
}
