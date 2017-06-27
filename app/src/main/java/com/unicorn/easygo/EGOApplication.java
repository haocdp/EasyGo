package com.unicorn.easygo;

import android.app.Application;
import android.content.Intent;

import com.unicorn.easygo.entity.UserProfile;

/**
 * Created by haoc_dp on 2017/6/25.
 */

public class EGOApplication extends Application {

    private static EGOApplication egoApplication;

    public static EGOApplication getInstance() {
        return egoApplication;
    }

    /*public EGOApplication() {
        super();
    }*/

    private UserProfile userProfile;
    private boolean hasBundCart;
    private String shoppingCartNo;

    @Override
    public void onCreate() {
        super.onCreate();
        egoApplication = this;
        userProfile = new UserProfile();
        hasBundCart = false;
    }

    public UserProfile getUserProfile() {

        return userProfile;
    }

    public boolean hasBundCart() {
        return hasBundCart;
    }

    public void setHasBundCart(boolean hasBundCart) {
        this.hasBundCart = hasBundCart;
    }

    public String getShoppingCartNo() {
        return shoppingCartNo;
    }

    public void setShoppingCartNo(String shoppingCartNo) {
        this.shoppingCartNo = shoppingCartNo;
    }
}
