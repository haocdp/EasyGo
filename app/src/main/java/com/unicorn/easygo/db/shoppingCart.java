package com.unicorn.easygo.db;

import java.io.Serializable;

/**
 * Created by guojishan on 2017/5/11.
 */

public class shoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int cartNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }
}
