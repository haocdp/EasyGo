package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
    public void add(String sex,String vip,double money,int userId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("sex", sex);//性别
            values.put("vip", vip);// 会员
            values.put("money", money);// 金钱
            values.put("userId", userId);// 金钱
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
    public void update(String accountid,String sex,String vip,double money,int userId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("sex", sex);
            values.put("vip", vip);
            values.put("money", money);
            values.put("money", money);
            values.put("userId", userId);
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

    /**
     * 数据库的查询操作
     * 根据ID查询数据
     */
    public List<account> findByuserId(int userId) {
        List<account> accounts = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("account", null, "userId=?",new String[] { String.valueOf(userId) }, null, null, null);
            if (cursor.moveToFirst()) {
                accounts = new ArrayList<account>();//创建列表
                account account = new account();
                String sex = cursor.getString(cursor.getColumnIndex("sex"));
                String vip = cursor.getString(cursor.getColumnIndex("vip"));
                double money= cursor.getDouble(cursor.getColumnIndex("money"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));

                account.setMoney(money);
                account.setSex(sex);
                account.setId(id);
                account.setVip(vip);

                accounts.add(account);//插入数据到列表中
            }
            cursor.close();
            db.close();
        }
        return accounts;
    }
}
