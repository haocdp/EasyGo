package com.unicorn.easygo.entity;

/**
 * Created by guojishan on 2017/6/25.
 */

public class MessageItem {
    private int warn_image;
    private int red_point;
    private String warn;
    private String warn_detail;

    public MessageItem(int warn_image,int red_point,String warn,String warn_detail){
        this.red_point = red_point;
        this.warn_image = warn_image;
        this.warn = warn;
        this.warn_detail = warn_detail;
    }

    public int getWarn_image() {
        return warn_image;
    }

    public void setWarn_image(int warn_image) {
        this.warn_image = warn_image;
    }

    public int getRed_point() {
        return red_point;
    }

    public void setRed_point(int red_point) {
        this.red_point = red_point;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }

    public String getWarn_detail() {
        return warn_detail;
    }

    public void setWarn_detail(String warn_detail) {
        this.warn_detail = warn_detail;
    }
}
