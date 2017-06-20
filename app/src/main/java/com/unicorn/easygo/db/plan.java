package com.unicorn.easygo.db;

/**
 * Created by guojishan on 2017/6/20.
 */

public class plan {
    private int id;
    private int userid;
    private int planDate;
    private String goods;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPlanDate() {
        return planDate;
    }

    public void setPlanDate(int planDate) {
        this.planDate = planDate;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}
