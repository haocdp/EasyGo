package com.unicorn.easygo;

import android.widget.Toast;

import com.unicorn.easygo.db.litepal.Account;
import com.unicorn.easygo.db.litepal.Goods;
import com.unicorn.easygo.db.litepal.OrderAlias;
import com.unicorn.easygo.db.litepal.ShoppingCart;
import com.unicorn.easygo.db.litepal.User;
import com.unicorn.easygo.entity.UserProfile;
import com.unicorn.easygo.utils.DateUtil;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haoc_dp on 2017/6/25.
 */

public class EGOApplication extends LitePalApplication {

    private static EGOApplication egoApplication;

    public static EGOApplication getInstance() {
        return egoApplication;
    }

    /*public EGOApplication() {
        super();
    }*/

    /**
     * 用户信息
     */
    private UserProfile userProfile;
    private boolean hasBundCart;
    private String shoppingCartNo;


    /**
     * 超市信息
     */
    private String marketName = "";

    /**
     * 订单信息
     */
    private String orderNo = "";
    private Map<Integer, Double> goodsIdList = new HashMap<>(); //存放订单里的商品ID和价格



    //建立数据库
//    private goodDBdao gooddbdao;
//    private accountDBdao acdbdao;
//    private scanRecordDBdao scandbdao;
//    private shoppingCartDBdao sCartdbdao;
//    private userDBdao userdbdao;
//    private testDBdao testdbdao;

    @Override
    public void onCreate() {
        super.onCreate();
        egoApplication = this;
        userProfile = new UserProfile();
        hasBundCart = false;
        LitePal.getDatabase();
        initDB();
    }

    /**
     * 初始化数据库
     */
    private void initDB() {
//        gooddbdao = new goodDBdao(getApplicationContext());
//        acdbdao = new accountDBdao(getApplicationContext());
//        scandbdao = new scanRecordDBdao(getApplicationContext());
//        sCartdbdao = new shoppingCartDBdao(getApplicationContext());
//        userdbdao = new userDBdao(getApplicationContext());
//        testdbdao = new testDBdao(getApplicationContext());
//        //添加商品信息
//        gooddbdao.add("Geer vr 头戴眼镜",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("好趣友薯片",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("蒙牛酸酸乳",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("蒙牛真果粒",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("得力笔记本",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("六神花露水",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("丝塔芙洁面乳",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("得力笔记本",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("得力订书机",100,8.5,20170621,11,"357千焦／每100克","15克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("伊利益消复原乳",450,7.8,20170615,21,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("雅漾大喷",100,8.5,201706221,12,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("蒙牛纯牛奶",100,8.5,201706221,10,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("维达抽纸巾",100,8.5,201706221,9,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        gooddbdao.add("乐事薯片",100,8.5,201706221,8,"357千焦／每100克","2.8克／每100克","11克／每100克","3.3克／每100克","70毫克／每100克","images/liulian.png");
//        //添加账户信息
//        acdbdao.add("女","是",238,1);
//        acdbdao.add("男","是",238,2);
//        acdbdao.add("男","是",1738,3);
//        acdbdao.add("女","是",538,4);
//        //扫描信息
//        scandbdao.add(1,1,20170623);
//        scandbdao.add(2,1,20170623);
//        scandbdao.add(3,1,20170623);
//        //购物车信息
//        sCartdbdao.add(1);
//        sCartdbdao.add(2);
//        sCartdbdao.add(3);
//        sCartdbdao.add(4);
//        //用户信息
//        userdbdao.add("zhangsan","123456");
//        userdbdao.add("lisi","123456");
//        userdbdao.add("login","123456");
//        //测试
//        testdbdao.add(1,627834674,20170624,1);//(goodId,orderNumber,dealDate,userId)
//        testdbdao.add(2,761267897,20170423,1);
//        testdbdao.add(3,761267897,20170423,1);
//        testdbdao.add(4,761267897,20170423,1);
//        testdbdao.add(5,761267897,20170423,1);
//        testdbdao.add(6,761267897,20170423,1);
//        testdbdao.add(7,761267897,20170423,1);
//        testdbdao.add(8,761267459,20170417,1);
//        testdbdao.add(9,767853897,20170411,1);
//        testdbdao.add(10,761267013,20170403,1);
//        testdbdao.add(11,745723896,20170401,1);


        Account account1 = new Account("amdin", "123456");
        account1.save();

        User user1 = new User(
                account1.getUsername(),
                1,
                "",
                100);
        user1.save();
        account1.setUser(user1);
        account1.save();

        try {
            Goods goods1 = new Goods(
                    "士力架",
                    "69029875",
                    "50g",
                    4,
                    DateUtil.string2Date("2017-06-21"),
                    DateUtil.string2Date("2018-06-21"),
                    "357千焦",
                    "15克",
                    "11克",
                    "3.3克",
                    "4%",
                    "8%",
                    "10%",
                    "2%",
                    "images/士力架.png");
            goods1.save();

            Goods goods2 = new Goods(
                    "炫迈口香糖",
                    "6954432710720",
                    "20g",
                    9,
                    DateUtil.string2Date("2017-06-21"),
                    DateUtil.string2Date("2018-06-21"),
                    "357千焦",
                    "15克",
                    "11克",
                    "3.3克",
                    "4%",
                    "8%",
                    "10%",
                    "2%",
                    "images/炫迈口香糖.png");
            goods2.save();

            Goods goods3 = new Goods(
                    "维达纸巾",
                    "6901236341292",
                    "150g",
                    24,
                    DateUtil.string2Date("2017-06-21"),
                    DateUtil.string2Date("2018-06-21"),
                    "357千焦",
                    "15克",
                    "11克",
                    "3.3克",
                    "4%",
                    "8%",
                    "10%",
                    "2%",
                    "images/维达纸巾.png");
            goods3.save();

            ShoppingCart shoppingCart = new ShoppingCart(
                    "sc-12434342774",
                    false
            );
            shoppingCart.save();

            OrderAlias orderAlias = new OrderAlias(
                    "201706221530234",
                    new Date(),
                    30
            );
            //orderAlias.save();

            /*Goods goods1 = DataSupport.findAll(Goods.class).get(0);
            Goods goods2 = DataSupport.findAll(Goods.class).get(1);
            Goods goods3 = DataSupport.findAll(Goods.class).get(2);

            OrderAlias orderAlias = DataSupport.where("id = ?", "1").find(OrderAlias.class).get(0);*/

            orderAlias.getGoodsList().add(goods1);
            orderAlias.getGoodsList().add(goods2);
            orderAlias.getGoodsList().add(goods3);
            orderAlias.save();

            /*goods1.getOrderAliasList().add(orderAlias);
            goods1.save();
            goods2.getOrderAliasList().add(orderAlias);
            goods2.save();
            goods3.getOrderAliasList().add(orderAlias);
            goods3.save();*/


            /*OrderGoods orderGoods1 = new OrderGoods(
                    orderAlias,
                    goods1,
                    1
            );
            orderGoods1.save();

            OrderGoods orderGoods2 = new OrderGoods(
                    orderAlias,
                    goods2,
                    1
            );
            orderGoods2.save();

            OrderGoods orderGoods3 = new OrderGoods(
                    orderAlias,
                    goods3,
                    1
            );
            orderGoods3.save();*/

        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Map<Integer, Double> getGoodsIdList() {
        return goodsIdList;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
}
