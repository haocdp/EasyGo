package com.unicorn.easygo.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by haoc_dp on 2017/6/8.
 */

public class FontUtil {

    /**
     * 为TextView设置字体
     * @param textView
     * @param activity
     * @param type 0-标题（方正清刻本悦宋）
     *             1-正文（华文细黑）
     */
    public static void setFont(TextView textView, Activity activity, int type){
        Typeface typeface = null;

        if(type == 0)
            typeface = Typeface.createFromAsset(activity.getAssets(),
                    "方正清刻本悦宋简体.TTF");
        else if (type == 1)
            typeface = Typeface.createFromAsset(activity.getAssets(),
                    "华文细黑.ttf");

        textView.setTypeface(typeface);
    }
}
