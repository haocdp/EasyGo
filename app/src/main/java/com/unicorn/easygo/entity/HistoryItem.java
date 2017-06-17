package com.unicorn.easygo.entity;

import com.unicorn.easygo.zxing.android.Intents;

import java.util.Date;

/**
 * Created by guojishan on 2017/6/15.
 */

public class HistoryItem {
    private int imageId;
    private String name;
    private String classify;
    private String price;
    private String weight;
    private String production_date;
    private String storage_life;
   // private String rmb;//静态
   // private String jhl;//静态
   // private String to;//静态


    public HistoryItem(String name,int imageId,String classify,String price,String weight,
                       String production_date,String storage_life){
        this.name = name;
        this.imageId = imageId;
        this.classify = classify;
        this.price = price;
        this.weight = weight;
        this.production_date =production_date;
        this.storage_life = storage_life;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return  imageId;
    }
    public String getClassify(){return classify;}
    public String getPrice(){return price;}//12.8
    public String getWeight(){return weight;}//108g
    public String getProduction_date(){return production_date;}
    public String getStorage_life(){return storage_life;}
}
