package com.unicorn.easygo.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.unicorn.easygo.ActivityCollector;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.ToastUtil;

import java.util.Map;

public class PayActivity extends AppCompatActivity {

    private TextView title;

    private ToggleButton tb_alipay;
    private ToggleButton tb_wechat;

    private TextView tv_money;
    private TextView tv_goPay;
    private TextView tv_payWay;

    private double totalPrice;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        title = (TextView) findViewById(R.id.title_text);
        title.setText("支付");
        FontUtil.setFont(title, getAssets(), 0);


        tb_alipay = (ToggleButton) findViewById(R.id.toggleButton_alipay);
        tb_wechat = (ToggleButton) findViewById(R.id.pay_toggleButton_wechat);
        tv_goPay = (TextView) findViewById(R.id.tv_go_pay);
        tv_money = (TextView) findViewById(R.id.tv_money_num);
        tv_payWay = (TextView) findViewById(R.id.tv_selected_pay_way);


        /**
         * 计算订单总价格
         */
        /*Map<Integer, Double> goodsIdPrice =
                EGOApplication.getInstance().getGoodsIdList();
        double totalPrice = 0;
        for (Integer i : goodsIdPrice.keySet()){
            totalPrice += goodsIdPrice.get(i);
        }*/
        totalPrice = getIntent().getDoubleExtra("totalPrice",0);
        tv_money.setText(String.valueOf(totalPrice));



        tb_alipay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (tb_wechat.isChecked())
                        tb_wechat.setChecked(false);

                    flag = true;
                    tv_payWay.setText("支付宝支付");
                } else {
                    flag = false;
                    tv_payWay.setText("");
                }
            }
        });

        tb_wechat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (tb_alipay.isChecked())
                        tb_alipay.setChecked(false);

                    flag = true;
                    tv_payWay.setText("微信支付");
                } else {
                    flag = false;
                    tv_payWay.setText("");
                }
            }
        });

        tv_goPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    showTipDialog();
                } else {
                    //TODO 将订单信息持久化到数据库中

                    ToastUtil.show(getApplicationContext(), "支付成功");

                    Intent intent = new Intent(getApplicationContext(),OrderDetailActivity.class);
                    intent.putExtra("totalPrice", totalPrice);
                    startActivity(intent);
                }
            }
        });

        ActivityCollector.addActivity(this);

    }
    private void showTipDialog() {
        new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("请先选择支付方式")
                .setPositiveButton("确定", null)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }
}
