package com.unicorn.easygo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by guojishan on 2017/5/11.
 */

public class MyDBOpenHelper extends SQLiteOpenHelper {

    private Context mContext;
    public static final String CREATE_USER="create table if not exists user(userid INTEGER primary key autoincrement, username varchar(20) ,password varchar(50))";
    public static final String CREATE_ACCOUNT=null;
    public static final String CREATE_GOOD=null;
    public static final String CREATE_ORDER=null;
    public static final String CREATE_SCAN_RECORD=null;
    public static final String CREATE_SHOPPINGCART=null;

    public MyDBOpenHelper(Context context) {
        super(context, "Easygo.db", null, 1);
        mContext = context;
    }//数据库


    // 数据库第一次被创建的时候调用
    @Override
    public void onCreate(SQLiteDatabase db) {//数据表
        db.execSQL(CREATE_USER);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_LONG).show();
    }

    //修改数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }


}