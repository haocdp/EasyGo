package com.unicorn.easygo.db.litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by haoc_dp on 2017/6/28.
 */

/**
 * 订单表
 */
public class OrderAlias extends DataSupport {

    private int id;
    private String orderNo;
    private Date dealTime;
    private double totalPrice;
    private List<Goods> goodsList = new ArrayList<>();

    public OrderAlias() {}

    public OrderAlias(
            String orderNo,
            Date dealTime,
            double totalPrice) {
        this.orderNo = orderNo;
        this.dealTime = dealTime;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }
}
