package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by guojishan on 2017/6/19.
 */

public class shoppingCartDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public shoppingCartDBdao(Context context) {
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }

    /**
     * 添加一条记录
     */
    public void add(int cartNumber) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("cartNumber", cartNumber);
            db.insert("shoppingCart", null, values); // 组拼sql语句完成的添加的操作

            db.close();
        }
    }

    /**
     * 删除一条记录
     */
    public void delete(int id) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("shoppingCart", "id=?", new String[] { String.valueOf(id) });
            db.close();
        }
    }

    /**
     * 数据库的更改操作
     * 根据name更新内容
     */
    public void update(int id,int cartNumber) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("cartNumber", cartNumber);
            db.update("shoppingCart", values, "id=?", new String[]{String.valueOf(id)});
            db.close();
        }
    }
}
