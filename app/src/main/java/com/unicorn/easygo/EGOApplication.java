package com.unicorn.easygo;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.db.scanRecordDBdao;
import com.unicorn.easygo.db.shoppingCartDBdao;
import com.unicorn.easygo.db.testDBdao;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.entity.UserProfile;

/**
 * Created by haoc_dp on 2017/6/25.
 */

public class EGOApplication extends Application {

    private static EGOApplication egoApplication;

    public static EGOApplication getInstance() {
        return egoApplication;
    }

    /*public EGOApplication() {
        super();
    }*/

    private UserProfile userProfile;
    private boolean hasBundCart;
    private String shoppingCartNo;


    //建立数据库
    private goodDBdao gooddbdao;
    private accountDBdao acdbdao;
    private scanRecordDBdao scandbdao;
    private shoppingCartDBdao sCartdbdao;
    private userDBdao userdbdao;
    private testDBdao testdbdao;

    @Override
    public void onCreate() {
        super.onCreate();
        egoApplication = this;
        userProfile = new UserProfile();
        hasBundCart = false;
        initDB();
    }

    /**
     * 初始化数据库
     */
    private void initDB() {
        gooddbdao = new goodDBdao(getApplicationContext());
        acdbdao = new accountDBdao(getApplicationContext());
        scandbdao = new scanRecordDBdao(getApplicationContext());
        sCartdbdao = new shoppingCartDBdao(getApplicationContext());
        userdbdao = new userDBdao(getApplicationContext());
        testdbdao = new testDBdao(getApplicationContext());
        //添加商品信息
        gooddbdao.add("Geer vr 头戴眼镜",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("好趣友薯片",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("蒙牛酸酸乳",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("蒙牛真果粒",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("得力笔记本",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("六神花露水",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("丝塔芙洁面乳",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("得力笔记本",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("得力订书机",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("伊利益消复原乳",450,7.8,20170615,21,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("雅漾大喷",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("蒙牛纯牛奶",100,8.5,201706221,10,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("维达抽纸巾",100,8.5,201706221,9,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        gooddbdao.add("乐事薯片",100,8.5,201706221,8,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
        //添加账户信息
        acdbdao.add("女","是",238,1);
        acdbdao.add("男","是",238,2);
        acdbdao.add("男","是",1738,3);
        acdbdao.add("女","是",538,4);
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
        //测试
        testdbdao.add(1,627834674,20170624,1);//(goodId,orderNumber,dealDate,userId)
        testdbdao.add(2,761267897,20170423,1);
        testdbdao.add(3,761267897,20170423,1);
        testdbdao.add(4,761267897,20170423,1);
        testdbdao.add(5,761267897,20170423,1);
        testdbdao.add(6,761267897,20170423,1);
        testdbdao.add(7,761267897,20170423,1);
        testdbdao.add(8,761267459,20170417,1);
        testdbdao.add(9,767853897,20170411,1);
        testdbdao.add(10,761267013,20170403,1);
        testdbdao.add(11,745723896,20170401,1);

        Toast.makeText(getApplicationContext(), "数据添加成功 ！",
                Toast.LENGTH_SHORT).show();
    }

    public UserProfile getUserProfile() {

        return userProfile;
    }

    public boolean hasBundCart() {
        return hasBundCart;
    }

    public void setHasBundCart(boolean hasBundCart) {
        this.hasBundCart = hasBundCart;
    }

    public String getShoppingCartNo() {
        return shoppingCartNo;
    }

    public void setShoppingCartNo(String shoppingCartNo) {
        this.shoppingCartNo = shoppingCartNo;
    }
}
