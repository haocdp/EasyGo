package com.unicorn.easygo.db.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by haoc_dp on 2017/6/28.
 */

/**
 * 账户表，用于登录
 */
public class Account extends DataSupport {
    private int id;
    private String username;
    private String password;
    private User user;

    public Account() {}

    public Account(
            String username,
            String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
