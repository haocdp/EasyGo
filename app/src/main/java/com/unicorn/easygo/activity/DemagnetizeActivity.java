package com.unicorn.easygo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.util.TimeUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DialogTitle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.unicorn.easygo.ActivityCollector;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.ConfirmOrderRecyclerAdapter;
import com.unicorn.easygo.adapter.DemagnetizeAdapter;
import com.unicorn.easygo.db.litepal.Goods;
import com.unicorn.easygo.utils.FontUtil;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class DemagnetizeActivity extends AppCompatActivity {

    private TextView title;
    private RecyclerView recyclerView;
    private double totalPrice;


    private List<Goods> goodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demagnetize);

        title = (TextView) findViewById(R.id.title_text);
        title.setText("确认订单");
        FontUtil.setFont(title, getAssets(), 0);

        /**
         * 设置recyclerview
         */
        Map<Integer, Double> map = EGOApplication.getInstance().getGoodsIdList();
        for (Integer i : map.keySet()){
            List<Goods> goodses = DataSupport.where("id = ?", String.valueOf(i)).find(Goods.class);
            goodsList.add(goodses.get(0));
        }
        recyclerView = (RecyclerView) findViewById(R.id.rv_demagnetize);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new DemagnetizeAdapter(this, goodsList));

        ActivityCollector.addActivity(this);


        totalPrice = getIntent().getDoubleExtra("totalPrice", 0);


        Timer timer = new Timer();
        TimerTask task  = new TimerTask() {
            @Override
            public void run() {
                Looper.prepare();
                showTipDialog();
                Looper.loop();
            }
        };
        timer.schedule(task, 3000);

    }

    private void showTipDialog() {
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("消磁成功")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(),OrderDetailActivity.class);
                        intent.putExtra("totalPrice", totalPrice);
                        startActivity(intent);
                    }
                })
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
