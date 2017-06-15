package com.unicorn.easygo.entity;

import com.unicorn.easygo.zxing.android.Intents;

/**
 * Created by guojishan on 2017/6/15.
 */

public class HistoryItem {
    private String name;
    private int imageId;
    public HistoryItem(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return  imageId;
    }
}
