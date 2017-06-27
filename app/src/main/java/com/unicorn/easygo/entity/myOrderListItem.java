package com.unicorn.easygo.entity;

/**
 * Created by guojishan on 2017/6/16.
 */

public class myOrderListItem {
    private String tv;
    private int ResourceId;
    public myOrderListItem(String tv,int ResourceId){

        this.tv = tv;
        this.ResourceId = ResourceId;
    }

    public String getTv() {
        return tv;
    }

    public int getResourceId() {
        return ResourceId;
    }
}
