package com.unicorn.easygo.db.litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by haoc_dp on 2017/6/28.
 */

/**
 * 商品表
 */
public class Goods extends DataSupport {

    private int id;
    private String goodsName;
    private String goodsNo; //条形码
    private String weight;
    private double price;
    private Date productionDate;
    private Date deadline;
    private String energy;
    private String protein;
    private String fat;
    private String carbohydrate;
    private String energy_per;
    private String protein_per;
    private String fat_per;
    private String carbohydrate_per;
    private String imagepath;
    private OrderAlias orderAlias;

    private List<ScanRecord> scanRecordList = new ArrayList<>();

    public Goods() {}

    public Goods(
            String goodsName,
            String goodsNo,
            String weight,
            double price,
            Date productionDate,
            Date deadline,
            String energy,
            String protein,
            String fat,
            String carbohydrate,
            String energy_per,
            String protein_per,
            String fat_per,
            String carbohydrate_per,
            String imagepath

    ) {
        this.goodsName = goodsName;
        this.goodsNo = goodsNo;
        this.weight = weight;
        this.price = price;
        this.productionDate = productionDate;
        this.deadline = deadline;
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.energy_per = energy_per;
        this.protein_per = protein_per;
        this.fat_per = fat_per;
        this.carbohydrate_per = carbohydrate_per;
        this.imagepath = imagepath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getEnergy() {
        return energy;
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

    public String getEnergy_per() {
        return energy_per;
    }

    public void setEnergy_per(String energy_per) {
        this.energy_per = energy_per;
    }

    public String getProtein_per() {
        return protein_per;
    }

    public void setProtein_per(String protein_per) {
        this.protein_per = protein_per;
    }

    public String getFat_per() {
        return fat_per;
    }

    public void setFat_per(String fat_per) {
        this.fat_per = fat_per;
    }

    public String getCarbohydrate_per() {
        return carbohydrate_per;
    }

    public void setCarbohydrate_per(String carbohydrate_per) {
        this.carbohydrate_per = carbohydrate_per;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public List<ScanRecord> getScanRecordList() {
        return scanRecordList;
    }

    public OrderAlias getOrderAlias() {
        return orderAlias;
    }

    public void setOrderAlias(OrderAlias orderAlias) {
        this.orderAlias = orderAlias;
    }
}
