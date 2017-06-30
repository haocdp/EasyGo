package com.unicorn.easygo.db.litepal;

/**
 * Created by haoc_dp on 2017/6/28.
 */

import org.litepal.crud.DataSupport;

/**
 * 订单和商品对应表，
 * number为对应订单上的该商品的数目
 */
public class OrderGoods extends DataSupport{
    private int id;
    private OrderAlias orderAlias;
    private Goods goods;
    private int number;

    public OrderGoods() {}

    public OrderGoods(
            OrderAlias orderAlias,
            Goods goods,
            int number
    ) {
        this.orderAlias = orderAlias;
        this.goods = goods;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderAlias getOrderAlias() {
        return orderAlias;
    }

    public void setOrderAlias(OrderAlias orderAlias) {
        this.orderAlias = orderAlias;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
