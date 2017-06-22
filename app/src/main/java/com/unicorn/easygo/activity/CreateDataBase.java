package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.db.orderDBdao;
import com.unicorn.easygo.db.scanRecordDBdao;
import com.unicorn.easygo.db.shoppingCartDBdao;


/**
 * Created by guojishan on 2017/6/22.
 */

public class CreateDataBase extends BaseActivity{

    private goodDBdao gooddbdao;
    private accountDBdao acdbdao;
    private orderDBdao orderdbdao;
    private scanRecordDBdao scandbdao;
    private shoppingCartDBdao sCartdbdao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gooddbdao = new goodDBdao(getApplicationContext());
        acdbdao = new accountDBdao(getApplicationContext());
        orderdbdao = new orderDBdao(getApplicationContext());
        scandbdao = new scanRecordDBdao(getApplicationContext());
        sCartdbdao = new shoppingCartDBdao(getApplicationContext());
        //添加商品信息
        gooddbdao.add("乐事薯片",100,8.5,20170621,12,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        gooddbdao.add("伊利益消复原乳",450,7.8,20170615,21,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        gooddbdao.add("乐事薯片",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克");
        //添加账户信息
        acdbdao.add("女","是",238);
        //订单信息

        //扫描信息
        //scandbdao
        //购物车信息




        Toast.makeText(getApplicationContext(), "数据添加成 功 ！",
                Toast.LENGTH_SHORT).show();

    }

}
