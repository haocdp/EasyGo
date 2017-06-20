package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by guojishan on 2017/6/18.
 */

public class orderDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public orderDBdao(Context context){
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
    /**
     * 添加一条记录
     */
    public void add(int orderId,int goodId,int orderNumber,int dealDate){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();

            values.put("goodId",goodId);
            values.put("orderNumber",orderNumber);
            values.put("dealDate",dealDate);
            db.insert("order", null, values); // 组拼sql语句完成的添加的操作

            db.close();
        }
    }

    /**
     * 删除一条记录
     */
    public void delete(int orderId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("order", "orderId=?", new String[] { String.valueOf(orderId) });
            db.close();
        }
    }

    /**
     * 数据库的更改操作
     * 根据name更新内容
     */
    public void update(int orderId,int goodId,int orderNumber, int dealDate) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodId", goodId);
            values.put("orderNumber", orderNumber);
            values.put("dealDate", dealDate);
            db.update("order", values, "orderId=?", new String[]{String.valueOf(orderId)});
            db.close();
        }
    }

    /**
     * 数据库的查询操作 判断有无该数据
     * 查询数据库的所有图片
     */
    public List<order> findById(int orderId) {
        List<order> orders = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("order", null, "ordreId=?",new String[] { String.valueOf(orderId) }, null, null, null);
            if (cursor.moveToFirst()) {
                orders = new ArrayList<order>();//创建列表
                order order = new order();
                int goodId = cursor.getInt(cursor.getColumnIndex("goodId"));
                int orderNumber = cursor.getInt(cursor.getColumnIndex("orderNumber"));
                int dealDate = cursor.getInt(cursor.getColumnIndex("dealDate"));
                order.setGoodId(goodId);
                order.setOrderNumber(orderNumber);
                order.setDealDate(dealDate);
                orders.add(order);//插入数据到列表中

            }
            cursor.close();
            db.close();
        }
        return orders;

    }

}
