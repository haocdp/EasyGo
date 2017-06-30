package com.unicorn.easygo.db.litepal;

/**
 * Created by haoc_dp on 2017/6/28.
 */

import org.litepal.crud.DataSupport;

/**
 * 购物车表
 * isAvailable 是否可用
 */
public class ShoppingCart extends DataSupport{

    private int id;
    private String cartNumber;
    private boolean isAvailable;

    public ShoppingCart() {}

    public ShoppingCart(
            String cartNumber,
            boolean isAvailable
    ) {
        this.cartNumber = cartNumber;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
