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

    public void add(String goodName,double weight, double price,int productionDate,
            int storage_life, String energy, String protein, String fat,String carbohydrate,String na,String imagepath){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodName", goodName);
            values.put("weight", weight);
            values.put("price", price);
            values.put("productionDate", productionDate);
            values.put("storage_life", storage_life);
            values.put("energy", energy);
            values.put("protein", protein);
            values.put("fat", fat);
            values.put("carbohydrate", carbohydrate);
            values.put("na", na);
            values.put("imagepath", imagepath);

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
    public void update(int goodId,String goodName,double weight, double price,int productionDate,
                       int storage_life, String energy, String protein, String fat,String carbohydrate,String na,String imagepath) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodId", goodId);
            values.put("goodName", goodName);
            values.put("weight", weight);
            values.put("price", price);
            values.put("productionDate", productionDate);
            values.put("storage_life", storage_life);
            values.put("energy", energy);
            values.put("protein", protein);
            values.put("fat", fat);
            values.put("carbohydrate", carbohydrate);
            values.put("na", na);
            values.put("imagepath",imagepath);
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
                int productionDate = cursor.getInt(cursor.getColumnIndex("productionDate"));
                int storage_life = cursor.getInt(cursor.getColumnIndex("storage_life"));
                String energy = cursor.getString(cursor.getColumnIndex("energy"));
                String protein = cursor.getString(cursor.getColumnIndex("protein"));
                String fat = cursor.getString(cursor.getColumnIndex("fat"));
                String carbohydrate = cursor.getString(cursor.getColumnIndex("carbohydrate"));
                String na = cursor.getString(cursor.getColumnIndex("na"));
                String imagepath = cursor.getString(cursor.getColumnIndex("imagepath"));

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
                good.setImagepath(imagepath);
                goods.add(good);

            }
            cursor.close();
            db.close();
        }
        return goods;

    }
}
