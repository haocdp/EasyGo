package com.unicorn.easygo.db;

/**
 * Created by guojishan on 2017/6/24.
 */

public class test {
    private static final long serialVersionUID = 1L;
    private int orderId;
    private int goodId;//商品条码
    private int orderNumber;//订单编号
    private int userId;//账户
    private int dealDate;//成交时间

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getDealDate() {
        return dealDate;
    }

    public void setDealDate(int dealDate) {
        this.dealDate = dealDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
