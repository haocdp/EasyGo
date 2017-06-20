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

public class goodDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public goodDBdao(Context context){
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
    /**
     * 添加一条记录
     */

    public void add(String goodName,double weight, double price,Date productionDate,
            Date storage_life, String energy, String protein, String fat,String carbohydrate,String na){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodName", goodName);
            values.put("weight", weight);
            values.put("price", price);
            values.put("productionDate", String.valueOf(productionDate));
            values.put("storage_life", String.valueOf(storage_life));
            values.put("energy", energy);
            values.put("protein", protein);
            values.put("fat", fat);
            values.put("carbohydrate", carbohydrate);
            values.put("na", na);

            db.insert("good", null, values); // 组拼sql语句完成的添加的操作

            db.close();
        }
    }

    /**
     * 删除一条记录
     */
    public void delete(int goodId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("good", "goodId=?", new String[] { String.valueOf(goodId) });
            db.close();
        }
    }

    /**
     * 数据库的更改操作
     * 根据商品编号修改
     */
    public void update(int goodId,String goodName,double weight, double price,Date productionDate,
                       Date storage_life, String energy, String protein, String fat,String carbohydrate,String na) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodId", goodId);
            values.put("goodName", goodName);
            values.put("weight", weight);
            values.put("price", price);
            values.put("productionDate", String.valueOf(productionDate));
            values.put("storage_life", String.valueOf(storage_life));
            values.put("energy", energy);
            values.put("protein", protein);
            values.put("fat", fat);
            values.put("carbohydrate", carbohydrate);
            values.put("na", na);
            db.update("good", values, "goodId=?", new String[] { String.valueOf(goodId) });
            db.close();
        }
    }

    /**
     * 数据库的查询操作 判断有无该数据
     * 查询数据库的所有图片
     */
    public List<good> findById(int goodId) {
        List<good> goods = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        if (db.isOpen()) {
            Cursor cursor = db.query("good", null, "goodId=?",new String[] { String.valueOf(goodId) }, null, null, null);
            if (cursor.moveToFirst()) {
                goods = new ArrayList<good>();
                good good = new good();
                String goodName = cursor.getString(cursor.getColumnIndex("goodName"));
                double weight = cursor.getDouble(cursor.getColumnIndex("weight"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String productionDate = cursor.getString(cursor.getColumnIndex("productionDate"));
                String storage_life = cursor.getString(cursor.getColumnIndex("storage_life"));
                String energy = cursor.getString(cursor.getColumnIndex("energy"));
                String protein = cursor.getString(cursor.getColumnIndex("protein"));
                String fat = cursor.getString(cursor.getColumnIndex("fat"));
                String carbohydrate = cursor.getString(cursor.getColumnIndex("carbohydrate"));
                String na = cursor.getString(cursor.getColumnIndex("na"));

                good.setGoodName(goodName);
                good.setWeight(weight);
                good.setPrice(price);
                good.setProductionDate(productionDate);
                good.setStorage_life(storage_life);
                good.setEnergy(energy);
                good.setProtein(protein);
                good.setFat(fat);
                good.setCarbohydrate(carbohydrate);
                good.setNa(na);


            }
            cursor.close();
            db.close();
        }
        return goods;

    }
}
