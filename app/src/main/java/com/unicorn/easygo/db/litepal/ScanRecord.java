package com.unicorn.easygo.db.litepal;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by haoc_dp on 2017/6/28.
 */

/**
 * 扫描信息表
 */
public class ScanRecord extends DataSupport {

    private int id;
    private User user;
    private Goods goods;
    private Date scanDate;

    public ScanRecord() {}

    public ScanRecord(
            User user,
            Goods goods,
            Date scanDate
    ) {
        this.user = user;
        this.goods = goods;
        this.scanDate = scanDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }
}
