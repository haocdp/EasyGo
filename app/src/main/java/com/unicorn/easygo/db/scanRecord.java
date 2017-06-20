package com.unicorn.easygo.db;

/**
 * Created by guojishan on 2017/6/18.
 */

public class scanRecord {
    private int scanId;
    private int goodId;
    private int userId;
    private int scanDate;

    public int getScanId() {
        return scanId;
    }

    public void setScanId(int scanId) {
        this.scanId = scanId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScanDate() {
        return scanDate;
    }

    public void setScanDate(int scanDate) {
        this.scanDate = scanDate;
    }
}
