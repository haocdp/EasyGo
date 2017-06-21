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

}
