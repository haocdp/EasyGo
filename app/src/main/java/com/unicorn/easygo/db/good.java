package com.unicorn.easygo.db;

import java.util.Date;

/**
 * Created by guojishan on 2017/6/18.
 */

public class good {
    private int goodId;
    private String goodName;
    private double weight;
    private double price;
//    private Date productionDate;
//    private Date storage_life;
    private String productionDate;
    private String storage_life;
    private String energy;
    private String protein;
    private String fat;
    private String carbohydrate;
    private String na;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEnergy() {
        return energy;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getStorage_life() {
        return storage_life;
    }

    public void setStorage_life(String storage_life) {
        this.storage_life = storage_life;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }
}
