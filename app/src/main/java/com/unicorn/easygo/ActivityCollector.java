package com.unicorn.easygo;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoc_dp on 2017/7/1.
 */

public class ActivityCollector {

    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void remove(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }
}
