package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.myOrderListAdapter;
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
    //private List<myOrderListItem> item = new ArrayList<>();
    private List<String> list = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorderlist);
        TextView title = (TextView)findViewById(R.id.title_text);
        title.setText("我的订单");
        FontUtil.setFont(title,this.getAssets(),0);
        setData();
        adapter = new myOrderListAdapter(this,list,listTag);
        listView = (ListView)findViewById(R.id.group_list);
        listView.setAdapter(adapter);

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
    public void setData() {
        list.add("昨天");
        listTag.add("昨天");
        list.add("Geer vr 头戴眼镜\n购入时间：2017-02-14 15：32\n总价：¥2457" );

        list.add("一周");
        listTag.add("一周");
        list.add("2017-04-23  订单编号 7612678976\n好趣友薯片、资生堂可悠然沐浴露等11件商品");
        list.add("2017-04-17  订单编号 7612678459\n瓦利亚太阳镜、乐事薯片等3件商品");

        list.add("一个月");
        listTag.add("一个月");
        list.add("2017-04-01  订单编号 7678538976\n六神花露水、丝塔芙洁面乳等6件商品");
        list.add("2017-04-03  订单编号 7612670136\n蒙牛酸酸乳、真果粒等3件商品");
        list.add("2017-04-11  订单编号 7457238976\n潘婷润发喷雾、得力笔记本等7件商品");

    }
}
