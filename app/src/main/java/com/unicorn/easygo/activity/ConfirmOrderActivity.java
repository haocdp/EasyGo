package com.unicorn.easygo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.unicorn.easygo.ActivityCollector;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.ConfirmOrderRecyclerAdapter;
import com.unicorn.easygo.db.litepal.Goods;
import com.unicorn.easygo.utils.FontUtil;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfirmOrderActivity extends AppCompatActivity {

    private List<Goods> goodsList = new ArrayList<>();
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        /**
         * 获取组件
         */
        TextView title = (TextView) findViewById(R.id.title_text);
        TextView tv_totalPrice = (TextView) findViewById(R.id.tv_totalPrice_num);
        TextView tv_confirmOrder = (TextView) findViewById(R.id.tv_confirm_order);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_goods_list);


        /**
         * 设置标题
         */
        title.setText("确认订单");
        FontUtil.setFont(title, getAssets(), 0);


        /**
         * 计算商品总价
         */
        Map<Integer, Double> goodsIdPrice =
                EGOApplication.getInstance().getGoodsIdList();
        totalPrice = 0;
        for (Integer i : goodsIdPrice.keySet()){
            totalPrice += goodsIdPrice.get(i);
        }
        tv_totalPrice.setText(String.valueOf(totalPrice));


        /**
         * 设置确认订单字体
         */
        FontUtil.setFont(tv_confirmOrder, getAssets(), 0);
        tv_confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PayActivity.class);
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });


        /**
         * 设置recyclerview
         */
        Map<Integer, Double> map = EGOApplication.getInstance().getGoodsIdList();
        for (Integer i : map.keySet()){
            List<Goods> goodses = DataSupport.where("id = ?", String.valueOf(i)).find(Goods.class);
            goodsList.add(goodses.get(0));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new ConfirmOrderRecyclerAdapter(this, goodsList));

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }
}
