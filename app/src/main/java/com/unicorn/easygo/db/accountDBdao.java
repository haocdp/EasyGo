package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by guojishan on 2017/6/20.
 */

public class accountDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public accountDBdao(Context context){
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
    /**
     * 添加一条记录
     */
    public void add(String sex,String vip,double money) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("sex", sex);//性别
            values.put("vip", vip);// 会员
            values.put("money", money);// 金钱
            db.insert("account", null, values); // 组拼sql语句完成的添加的操作
            db.close();
        }
    }
    /**
     * 删除一条记录
     */
    public void delete(String accountid) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("account", "accountid=?", new String[] { accountid });
            db.close();
        }
    }

    /**
     * 数据库的更改操作
     */
    public void update(String accountid,String sex,String vip,double money) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("sex", sex);
            values.put("vip", vip);
            values.put("money", money);
            db.update("account", values, "accountid=?",
                    new String[] { accountid });
            db.close();
        }
    }
    /**
     * 数据库的查询操作 判断有无该数据
     */
    public boolean find(String accountid) {
        boolean result = false;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            // select * from person
            Cursor cursor = db.query("account", null, "accountid=?",
                    new String[] { accountid }, null, null, null);
            if (cursor.moveToFirst()) {
                result = true;
            }
            cursor.close();
            db.close();
        }
        return result;
    }
}
