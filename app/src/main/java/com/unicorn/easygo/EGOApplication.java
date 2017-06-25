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

    private EGOApplication() {
        super();
    }

    private UserProfile userProfile;

    @Override
    public void onCreate() {
        super.onCreate();
        egoApplication = this;
        userProfile = new UserProfile();

    }

    public UserProfile getUserProfile() {

        return userProfile;
    }
}
