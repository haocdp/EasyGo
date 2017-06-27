package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/24.
 */

public class testDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public testDBdao(Context context) {
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }

    /**
     * 添加一条记录
     */
    public void add(int goodId, int orderNumber, int dealDate, int userId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("goodId", goodId);
        values.put("orderNumber", orderNumber);
        values.put("dealDate", dealDate);
        values.put("userId", userId);
        db.insert("test", null, values);
        db.close();
    }

    /**
     * 删除一条记录
     */
    public void delete(int orderId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("test", "orderId=?", new String[]{String.valueOf(orderId)});
            db.close();
        }
    }

    /**
     * 数据库的更改操作
     */
    public void update(int orderId, int goodId, int orderNumber, int dealDate, int userId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodId", goodId);
            values.put("orderNumber", orderNumber);
            values.put("dealDate", dealDate);
            values.put("userId", userId);
            db.update("test", values, "orderId=?", new String[]{String.valueOf(orderId)});
            db.close();
        }
    }

    /**
     * 数据库的查询操作
     * 根据userid或者orderid查询数据
     */
    public List<test> findByorderId(int orderId) {
        List<test> orders = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("test", null, "ordreId=?", new String[]{String.valueOf(orderId)}, null, null, null);
            if (cursor.moveToFirst()) {
                orders = new ArrayList<test>();//创建列表
                test order = new test();
                int goodId = cursor.getInt(cursor.getColumnIndex("goodId"));
                int orderNumber = cursor.getInt(cursor.getColumnIndex("orderNumber"));
                int dealDate = cursor.getInt(cursor.getColumnIndex("dealDate"));
                int userId = cursor.getInt(cursor.getColumnIndex("userId"));
                order.setGoodId(goodId);
                order.setOrderNumber(orderNumber);
                order.setDealDate(dealDate);
                order.setUserId(userId);
                orders.add(order);//插入数据到列表中

            }
            cursor.close();
            db.close();
        }
        return orders;
    }

    public List<test> findByuserId(int userId) {
        List<test> orders = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("test", null, "userId=?", new String[]{String.valueOf(userId)}, null, null, null);
            if (cursor.moveToFirst()) {
                orders = new ArrayList<test>();//创建列表
                test order = new test();
                int goodId = cursor.getInt(cursor.getColumnIndex("goodId"));
                int orderNumber = cursor.getInt(cursor.getColumnIndex("orderNumber"));
                int dealDate = cursor.getInt(cursor.getColumnIndex("dealDate"));
                int orderId = cursor.getInt(cursor.getColumnIndex("orderId"));
                order.setGoodId(goodId);
                order.setOrderNumber(orderNumber);
                order.setDealDate(dealDate);
                order.setOrderId(orderId);
                orders.add(order);//插入数据到列表中

            }
            cursor.close();
            db.close();
        }
        return orders;
    }
}
