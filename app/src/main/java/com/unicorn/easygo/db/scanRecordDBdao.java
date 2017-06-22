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

public class scanRecordDBdao {
    private Context context;
    MyDBOpenHelper dbOpenHelper;

    public scanRecordDBdao(Context context) {
        this.context = context;
        dbOpenHelper = new MyDBOpenHelper(context);
    }
    /**
     * 添加一条记录
     */
    public void add(int goodId, int userId,int scanDate) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            ContentValues values = new ContentValues();
            values.put("goodId", goodId);
            values.put("userId", userId);
            values.put("scanDate",scanDate);
            db.insert("scanRecord", null, values); // 组拼sql语句完成的添加的操作

            db.close();
        }

    }
    /**
     * 删除一条记录
     */
    public void delete(int scanId) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        if (db.isOpen()) {
            db.delete("scanRecord", "scanId=?", new String[] { String.valueOf(scanId) });
            db.close();
        }
    }
    //应该不需要修改吧，来一个查询所有记录吧,需要按日期查询吗？
    /**
     * 查询所有信息
     */
    public List<scanRecord> findAll() {
        List<scanRecord> scanRecords = null;
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();

        if (db.isOpen()) {
            Cursor cursor = db.query("scanRecord", null, null, null, null, null,
                    null);
            scanRecords = new ArrayList<scanRecord>();//创建列表
            while (cursor.moveToNext()) {
                scanRecord scanRecord = new scanRecord();
                int scanId = cursor.getInt(cursor.getColumnIndex("scanId"));
                int goodId = cursor.getInt(cursor.getColumnIndex("goodId"));
                int userId = cursor.getInt(cursor.getColumnIndex("userId"));
                int scanDate = cursor.getInt(cursor.getColumnIndex("scanDate"));
                scanRecord.setScanId(scanId);
                scanRecord.setGoodId(goodId);
                scanRecord.setUserId(userId);
                scanRecord.setScanDate(scanDate);
                scanRecords.add(scanRecord);//插入数据到列表中
            }
            cursor.close();
            db.close();
        }
        return scanRecords;
    }

}
