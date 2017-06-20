package com.unicorn.easygo.db;

import android.content.Context;

/**
 * Created by guojishan on 2017/6/20.
 */

public class planDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public planDBdao(Context context){
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
}
