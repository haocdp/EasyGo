package com.unicorn.easygo.activity;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.RecyclerViewAdapter;
import com.unicorn.easygo.db.good;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.entity.HistoryItem;
import com.unicorn.easygo.utils.FontUtil;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/8.
 */

public class HistoryActivity extends AppCompatActivity {

    private List<HistoryItem> mList = new ArrayList<>();
    private String test;
    private goodDBdao gooddbdao;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        TextView title = (TextView)findViewById(R.id.title_text);
        title.setText("我的足迹");
        FontUtil.setFont(title,this.getAssets(),0);

        initItem();//初始化数据
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mList);
        recyclerView.setAdapter(adapter);
    }
    private void initItem(){
        /*gooddbdao = new goodDBdao(getApplicationContext());
        List<good> goods = gooddbdao.findById(1);
        good demo = goods.get(0);
        test = demo.getImagepath();
        Bitmap bm;
        try{
            BufferedInputStream bis = new BufferedInputStream(getAssets().open("kaixinguo.png"));
             bm = BitmapFactory.decodeStream(bis);
        }catch (Exception e){
            e.printStackTrace();
        }*/




        HistoryItem apple = new HistoryItem("口口福开心果",R.drawable.goods,"坚果特产干果休闲食品","29.90","180g","2017-02-14","2018-02-14");
        mList.add(apple);
        HistoryItem banana = new HistoryItem("banana",R.drawable.banana_pic,"水果","5","500g","2017-06-16","2017-07-17");
        mList.add(banana);
        HistoryItem cherry = new HistoryItem("cherry",R.drawable.cherry_pic,"水果","25","500g","2017-06-16","2017-07-17");
        mList.add(cherry);
        HistoryItem mango = new HistoryItem("mango",R.drawable.mango_pic,"水果","15","500g","2017-06-16","2017-07-17");
        mList.add(mango);
    }
}
