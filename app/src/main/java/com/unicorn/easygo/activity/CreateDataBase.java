package com.unicorn.easygo.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.model.Text;
import com.unicorn.easygo.R;

import com.unicorn.easygo.db.MyDBOpenHelper;
import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.good;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.db.scanRecordDBdao;
import com.unicorn.easygo.db.shoppingCartDBdao;
import com.unicorn.easygo.db.userDBdao;

import java.util.List;


/**
 * Created by guojishan on 2017/6/22.
 */

public class CreateDataBase extends BaseActivity implements View.OnClickListener{

    private goodDBdao gooddbdao;
    private accountDBdao acdbdao;
    private scanRecordDBdao scandbdao;
    private shoppingCartDBdao sCartdbdao;
    private userDBdao  userdbdao;
    private Button add_data;
    private Button query_data;
    private TextView test;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_data);
        add_data = (Button)findViewById(R.id.add_data);
        query_data = (Button)findViewById(R.id.query_data);
        test = (TextView)findViewById(R.id.test);
        add_data.setOnClickListener(this);
        query_data.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_data:

                gooddbdao = new goodDBdao(getApplicationContext());
                acdbdao = new accountDBdao(getApplicationContext());
                //orderdbdao = new orderDBdao(getApplicationContext());
                scandbdao = new scanRecordDBdao(getApplicationContext());
                sCartdbdao = new shoppingCartDBdao(getApplicationContext());
                userdbdao = new userDBdao(getApplicationContext());
                //添加商品信息
//                gooddbdao.add("乐事薯片",100,8.5,20170621,12,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
//                gooddbdao.add("伊利益消复原乳",450,7.8,20170615,21,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
//                gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
//                gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
//                gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
//                gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
                //添加账户信息
                acdbdao.add("女","是",238,1);
                acdbdao.add("男","是",238,2);
                acdbdao.add("男","是",1738,3);
                acdbdao.add("女","是",538,4);
                //订单信息
//                orderdbdao.add(1,12,20170613);
//                orderdbdao.add(1,13,20170613);
//                orderdbdao.add(1,14,20170614);
                //扫描信息
                scandbdao.add(1,1,20170623);
                scandbdao.add(2,1,20170623);
                scandbdao.add(3,1,20170623);
                //购物车信息
                sCartdbdao.add(1);
                sCartdbdao.add(2);
                sCartdbdao.add(3);
                sCartdbdao.add(4);
                //用户信息
                userdbdao.add("zhangsan","123456");
                userdbdao.add("lisi","123456");
                userdbdao.add("login","123456");
                //order
//                ordertest.add(1,1,20170623);
//                ordertest.add(2,1,20170623);
//                ordertest.add(3,1,20170623);

                Toast.makeText(getApplicationContext(), "数据添加成 功 ！",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.query_data:
                gooddbdao = new goodDBdao(getApplicationContext());
                List<good> goods = gooddbdao.findById(1);
                good demo = goods.get(0);
                test.setText(demo.getGoodName());
                break;
        }
    }

}
