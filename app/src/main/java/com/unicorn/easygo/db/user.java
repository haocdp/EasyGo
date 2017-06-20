package com.unicorn.easygo.db;

import java.io.Serializable;

/**
 * Created by guojishan on 2017/5/11.
 */

public class user implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userid;
    private String username;
    private String password;
    private String sex;
    private String vip;
    private double money;



    public String getUsername() {
        return username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
