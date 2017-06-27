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
    public static final String CREATE_ACCOUNT="create table if not exists account (id INTEGER primary key autoincrement, sex text ,vip text,money real,userId Integer)";
    public static final String CREATE_GOOD="create table if not exists good (goodId INTEGER primary key autoincrement, goodName text ,weight real,price real," +
            "productionDate text,storage_life text,energy text,protein text,fat text,carbohydrate text,na text,imagepath text)";
    public static final String CREATE_SCAN_RECORD="create table if not exists scanRecord (scanId INTEGER primary key autoincrement,goodId INTEGER,userId INTEGER, scanDate INTEGER)";
    public static final String CREATE_SHOPPINGCART="create table if not exists shoppingCart (id INTEGER primary key autoincrement,cartNumber INTEGER)";
    //public static final String CREATE_ORDER="create table if not exists order (orderId INTEGER primary key autoincrement,goodId INTEGER,orderNumber INTEGER,dealDate INTEGER)";
    public static final String CREATE_TEST="create table if not exists test (orderId INTEGER primary key autoincrement, goodId INTEGER ,orderNumber INTEGER,dealDate INTEGER,userId INTEGER)";
    public MyDBOpenHelper(Context context) {
        super(context, "Easygo.db", null, 1);
        mContext = context;
    }//数据库


    // 数据库第一次被创建的时候调用
    @Override
    public void onCreate(SQLiteDatabase db) {//数据表
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_ACCOUNT);
        db.execSQL(CREATE_GOOD);
        //db.execSQL(CREATE_ORDER);
        db.execSQL(CREATE_SCAN_RECORD);
        db.execSQL(CREATE_SHOPPINGCART);
        db.execSQL(CREATE_TEST);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_LONG).show();
    }
    //修改数据库
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }


}