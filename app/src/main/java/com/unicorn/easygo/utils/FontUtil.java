package com.unicorn.easygo.utils;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by haoc_dp on 2017/6/8.
 */

public class FontUtil {

    /**
     * 为TextView设置字体
     * @param textView
     * @param assetManager
     * @param type 0-标题（方正清刻本悦宋）
     *             1-正文（华文细黑）
     */
    public static void setFont(TextView textView, AssetManager assetManager, int type){
        Typeface typeface = null;

        if(type == 0)
            typeface = Typeface.createFromAsset(assetManager,
                    "fonts/方正清刻本悦宋简体.TTF");
        else if (type == 1)
            typeface = Typeface.createFromAsset(assetManager,
                    "fonts/华文细黑.ttf");

        textView.setTypeface(typeface);
    }

    /**
     * 为EditText设置字体
     * @param editText
     * @param assetManager
     * @param type
     */
    public static void setFont(EditText editText, AssetManager assetManager, int type){
        Typeface typeface = null;

        if(type == 0)
            typeface = Typeface.createFromAsset(assetManager,
                    "fonts/方正清刻本悦宋简体.TTF");
        else if (type == 1)
            typeface = Typeface.createFromAsset(assetManager,
                    "fonts/华文细黑.ttf");

        editText.setTypeface(typeface);
    }
}
