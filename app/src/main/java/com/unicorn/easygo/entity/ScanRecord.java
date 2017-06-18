package com.unicorn.easygo.entity;

/**
 * Created by haoc_dp on 2017/6/14.
 */

public class ScanRecord {
    private String description; //商品描述
    private String imageUrl; //商品图片
    private double price;  //价格

    public ScanRecord() {

    }

    public ScanRecord(
            String description,
            String imageUrl,
            double price
    ) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
