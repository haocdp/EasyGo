package com.unicorn.easygo.activity;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.amap.api.maps.model.Text;
import com.unicorn.easygo.ActivityCollector;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.ConfirmOrderRecyclerAdapter;
import com.unicorn.easygo.db.litepal.Goods;
import com.unicorn.easygo.utils.DateUtil;
import com.unicorn.easygo.utils.FontUtil;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDetailActivity extends AppCompatActivity {

    private ImageView iv_photo;
    private TextView tv_orderNo;
    private TextView tv_totalPrice;
    private TextView tv_dealTime;
    private TextView title;
    private RecyclerView recyclerView;

    private double totalPrice;

    private List<Goods> goodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        title = (TextView) findViewById(R.id.title_text);
        iv_photo = (ImageView) findViewById(R.id.imageView4);
        tv_orderNo = (TextView) findViewById(R.id.tv_order_num);
        tv_totalPrice = (TextView) findViewById(R.id.tv_pay_num);
        tv_dealTime = (TextView) findViewById(R.id.tv_dealDate);

        recyclerView = (RecyclerView) findViewById(R.id.rv_goods_list);

        /**
         * 设置标题
         */
        title.setText("订单详情");
        FontUtil.setFont(title, getAssets(), 0);

        totalPrice = getIntent().getDoubleExtra("totalPrice",0);
        tv_totalPrice.setText(String.valueOf(totalPrice));

        tv_orderNo.setText(EGOApplication.getInstance().getOrderNo());


        Map<Integer, Double> map = EGOApplication.getInstance().getGoodsIdList();
        try {

            iv_photo.setImageBitmap(BitmapFactory.decodeStream(
                    getApplicationContext().getAssets().open(
                            DataSupport.where("id = ?", String.valueOf(
                                    map.keySet().toArray()[0])).find(Goods.class)
                            .get(0).getImagepath()
            )));

            tv_dealTime.setText(DateUtil.date2String(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * 设置recyclerview
         */

        for (Integer i : map.keySet()){
            List<Goods> goodses = DataSupport.where("id = ?", String.valueOf(i)).find(Goods.class);
            goodsList.add(goodses.get(0));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new ConfirmOrderRecyclerAdapter(this, goodsList));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 将内存中的订单信息清空
         */
        EGOApplication.getInstance().setOrderNo("");
        EGOApplication.getInstance().getGoodsIdList().clear();

        ActivityCollector.finishAll();
    }
}
