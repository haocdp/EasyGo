package com.unicorn.easygo.entity;

/**
 * Created by haoc_dp on 2017/6/25.
 */

public class UserProfile {

    private int id;
    private String username;
    private String sex;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public UserProfile setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfile setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public UserProfile setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserProfile setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
