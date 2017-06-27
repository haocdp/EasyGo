package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.myOrderListAdapter;
import com.unicorn.easygo.db.good;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.db.test;
import com.unicorn.easygo.db.testDBdao;
import com.unicorn.easygo.db.user;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.entity.Type;
import com.unicorn.easygo.entity.myOrderListItem;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.TopMenuHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/8.
 */

public class OrderActivity extends AppCompatActivity {
    private myOrderListAdapter adapter = null;
    private ListView listView = null;
    private List<String> listTag = new ArrayList<String>();
    private List<myOrderListItem> item = null;
    //private List<String> list = new ArrayList<String>();
    private testDBdao orderdbdao;
    private userDBdao userdao;
    private goodDBdao gooddbdao;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorderlist);
        TextView title = (TextView)findViewById(R.id.title_text);
        title.setText("我的订单");
        FontUtil.setFont(title,this.getAssets(),0);
        listView = (ListView) findViewById(R.id.group_list);
//        adapter = new myOrderListAdapter(this,list,listTag);
//        listView = (ListView)findViewById(R.id.group_list);
//        listView.setAdapter(adapter);
        setData();

    }

//    public void setData(){
//        myOrderListItem test1 = new myOrderListItem("ABC");
//        item.add(test1);
//        listTag.add("A");
//        myOrderListItem test2= new myOrderListItem("ABCde");
//        item.add(test2);
//        listTag.add("B");
//
//    }

    public void setData(){
        List<Type> list = new ArrayList<>();

        Type type = new Type("昨天" );
        myOrderListItem data = new myOrderListItem("Geer vr 头戴眼镜\n购入时间：2017-06-24 15：32\n总价：¥2457", R.drawable.glasses);
        type.addItem(data);
        list.add(type);

        Type type1 = new Type("一周" );
        myOrderListItem data1 = new myOrderListItem("2017-04-23  订单编号 7612678976\n好趣友薯片、资生堂可悠然沐浴露等11件商品", 0);
        myOrderListItem data2 = new myOrderListItem("2017-04-17  订单编号 7612678459\n瓦利亚太阳镜、乐事薯片等3件商品",0);
        type1.addItem(data1);
        type1.addItem(data2);
        list.add(type1);

        Type type2 = new Type("一个月" );
        myOrderListItem data3 = new myOrderListItem("2017-04-11  订单编号 7678538976\n六神花露水、丝塔芙洁面乳等6件商品", 0);
        myOrderListItem data4 = new myOrderListItem("2017-04-03  订单编号 7612670136\n蒙牛酸酸乳、真果粒等3件商品",0);
        myOrderListItem data5 = new myOrderListItem("2017-04-01  订单编号 7457238976\n潘婷润发喷雾、得力笔记本等7件商品",0);
        type2.addItem(data3);
        type2.addItem(data4);
        type2.addItem(data5);
        list.add(type2);

        myOrderListAdapter adapter = new myOrderListAdapter(this, list);
        listView.setAdapter(adapter);

        //根据登陆用户名获取相关订单信息
        orderdbdao = new testDBdao(getApplicationContext());
        userdao = new userDBdao(getApplicationContext());
        gooddbdao = new goodDBdao(getApplicationContext());
        String name = EGOApplication.getInstance().getUserProfile().getUsername();
        List<user> users = userdao.findByName(name);
        user demo = users.get(0);
        int userid = demo.getUserid();
        List<test> orders = orderdbdao.findByuserId(userid);//一个用户对应一个或者多个订单
        for(int i = 0;i<orders.size();i++){
            test order = orders.get(i);//一个订单对应一个或者多个商品
            int goodId = order.getGoodId();
            List<good> goods = gooddbdao.findById(goodId);
            String goodname = goods.get(0).getGoodName();
            Log.i("商品信息：",goodname);
        }

    }
//    public void setData() {
//        list.add("昨天");
//        listTag.add("昨天");
//        list.add("Geer vr 头戴眼镜\n购入时间：2017-02-14 15：32\n总价：¥2457" );
//
//        list.add("一周");
//        listTag.add("一周");
//        list.add("2017-04-23  订单编号 7612678976\n好趣友薯片、资生堂可悠然沐浴露等11件商品");
//        list.add("2017-04-17  订单编号 7612678459\n瓦利亚太阳镜、乐事薯片等3件商品");
//
//        list.add("一个月");
//        listTag.add("一个月");
//        list.add("2017-04-01  订单编号 7678538976\n六神花露水、丝塔芙洁面乳等6件商品");
//        list.add("2017-04-03  订单编号 7612670136\n蒙牛酸酸乳、真果粒等3件商品");
//        list.add("2017-04-11  订单编号 7457238976\n潘婷润发喷雾、得力笔记本等7件商品");
//
//        //根据登陆用户名获取相关订单信息
//        orderdbdao = new testDBdao(getApplicationContext());
//        userdao = new userDBdao(getApplicationContext());
//        String name = EGOApplication.getInstance().getUserProfile().getUsername();
//        List<user> users = userdao.findByName(name);
//        user demo = users.get(0);
//        int userid = demo.getUserid();
//        List<test> orders = orderdbdao.findByuserId(userid);
//        for(int i = 0;i<orders.size();i++){
//            orders.get(i);
//        }
//
//    }
}
