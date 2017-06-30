package com.unicorn.easygo.db.litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoc_dp on 2017/6/28.
 */

/**
 * 用户信息表，存放用户信息，与账户信息一一对应
 */
public class User extends DataSupport {

    private int id;
    private String nickname;
    private int gender;
    private String vip;
    private double money;
    //private Account account;
    private List<ScanRecord> scanRecordList = new ArrayList<>();

    public User() {}

    public User(
            String nickname,
            int gender,
            String vip,
            double money
    ) {
        this.nickname = nickname;
        this.gender = gender;
        this.vip = vip;
        this.money = money;
        //this.account = account;
    }

    public List<ScanRecord> getScanRecordList() {
        return scanRecordList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
