package com.unicorn.easygo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by guojishan on 2017/5/11.
 */

public class MyDBOpenHelper extends SQLiteOpenHelper {

    public MyDBOpenHelper(Context context) {
        super(context, "Photo.db", null, 1);
    }//数据库

    // 数据库第一次被创建的时候 调用
    @Override
    public void onCreate(SQLiteDatabase db) {//数据表
        db.execSQL("CREATE TABLE IF NOT EXISTS photo (id INTEGER primary key autoincrement, name varchar(20) ,phenotype varchar(50) )");
    }

    //修改数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }


}