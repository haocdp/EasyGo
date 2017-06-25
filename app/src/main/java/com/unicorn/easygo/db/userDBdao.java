package com.unicorn.easygo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/19.
 */

public class userDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public userDBdao(Context context) {
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
    /**
     * 添加一条记录
     */
    public void add(String username,String password){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        db.insert("user", null, values);
        db.close();
    }
    /**
     * 删除一条记录
     */
    public void delete(int userid) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("user", "userid=?", new String[] { String.valueOf(userid) });
            db.close();
        }
    }
    /**
     * 数据库的更改操作
     * 根据name更新内容
     */
    public void update(int userid,String username,String password) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("username", username);
            values.put("password", password);
            db.update("user", values, "userid=?", new String[]{String.valueOf(userid)});
            db.close();
        }
    }
    /**
     * 数据库的查询操作
     * 根据ID查询数据
     */
    public List<user> findById(int id) {
        List<user> users = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("user", null, "userid=?",new String[] { String.valueOf(id) }, null, null, null);
            if (cursor.moveToFirst()) {
                users = new ArrayList<user>();//创建列表
                user user = new user();
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                user.setUsername(username);
                user.setPassword(password);
                users.add(user);//插入数据到列表中
            }
            cursor.close();
            db.close();
        }
        return users;
    }
    /**
     * 数据库的查询操作
     * 根据用户名查询
     */
    public List<user> findByName(String username) {
        List<user> users = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("user", null, "username=?",new String[] { username }, null, null, null);
            if (cursor.moveToFirst()) {
                users = new ArrayList<user>();//创建列表
                user user = new user();

                int userid = cursor.getInt(cursor.getColumnIndex("userid"));
                String password = cursor.getString(cursor.getColumnIndex("password"));

                user.setUserid(userid);
                user.setPassword(password);
                users.add(user);//插入数据到列表中
            }
            cursor.close();
            db.close();
        }
        return users;
    }

    /**
     * 数据库的查询操作 判断有无该数据
     * 判断用户是否存在
     */
    public boolean find(String name) {
        boolean result = false;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            Cursor cursor = db.query("user", null, "username=?",
                    new String[] { name }, null, null, null);
            if (cursor.moveToFirst()) {
                result = true;
            }
            cursor.close();
            db.close();
        }
        return result;

    }
    /**
     * 数据库的查询操作 判断有无该数据
     * 判断登录结果
     */
    public boolean findLogin(String name,String pwd) {
        boolean result = false;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        if (db.isOpen()) {
            // select * from user
            Cursor cursor = db.query("user", null, "username=? and password=?",
                    new String[] { name ,pwd}, null, null, null);
            if (cursor.moveToFirst()) {
                result = true;
            }
            cursor.close();
            db.close();
        }
        return result;
    }

}
