package com.unicorn.easygo.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.db.litepal.Goods;
import com.unicorn.easygo.utils.DateUtil;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.ToastUtil;

import org.litepal.crud.DataSupport;

import java.util.Date;
import java.util.List;

public class ScanGoodsInfoActivity extends AppCompatActivity {

    private Goods goods;

    private TextView title;
    private ImageView iv_goodsImage;
    private Button btn_addOrder;
    private TextView tv_goodsInfo;
    private TextView tv_goodsContent;
    private TextView tv_goodsPrice;
    private TextView tv_goodsStartDate;
    private TextView tv_goodsDeadline;
    private TextView tv_goodsEnergy;
    private TextView tv_goodsEnergy_per;
    private TextView tv_goodsProtein;
    private TextView tv_goodsProtein_per;
    private TextView tv_goodsFat;
    private TextView tv_goodsFat_per;
    private TextView tv_goodsCarbohydrate;
    private TextView tv_goodsCarbohydrate_per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_goods_info_result);

        title = (TextView) findViewById(R.id.title_text);
        iv_goodsImage = (ImageView) findViewById(R.id.goods_image);
        btn_addOrder = (Button) findViewById(R.id.btn_add_order);
        tv_goodsInfo = (TextView) findViewById(R.id.goods_info);
        tv_goodsContent = (TextView) findViewById(R.id.content_text);
        tv_goodsPrice = (TextView) findViewById(R.id.goods_price);
        tv_goodsStartDate = (TextView) findViewById(R.id.goods_start_date);
        tv_goodsDeadline = (TextView) findViewById(R.id.goods_end_date);
        tv_goodsEnergy = (TextView) findViewById(R.id.goods_form_energy_num);
        tv_goodsEnergy_per = (TextView) findViewById(R.id.goods_form_energy_percent);
        tv_goodsProtein = (TextView) findViewById(R.id.goods_form_protein_num);
        tv_goodsProtein_per = (TextView) findViewById(R.id.goods_form_protein_percent);
        tv_goodsFat = (TextView) findViewById(R.id.goods_form_fat_num);
        tv_goodsFat_per = (TextView) findViewById(R.id.goods_form_fat_percent);
        tv_goodsCarbohydrate = (TextView) findViewById(R.id.goods_form_carbohydrate_num);
        tv_goodsCarbohydrate_per = (TextView) findViewById(R.id.goods_form_carbohydrate_percent);

        Intent intent = getIntent();
        String goodsNo = intent.getStringExtra("goodsNo");
        final List<Goods> goodsList = DataSupport.where("goodsNo = ?", goodsNo).find(Goods.class);

        goods = goodsList.get(0);

        title.setText("商品详情");
        FontUtil.setFont(title, getAssets(), 0);

        try {
            iv_goodsImage.setImageBitmap(BitmapFactory.decodeStream(
                    getApplicationContext().getAssets().open(goods.getImagepath())));
            tv_goodsInfo.setText(goods.getGoodsName());
            tv_goodsContent.setText(goods.getWeight());
            tv_goodsPrice.setText(String.valueOf(goods.getPrice()));
            tv_goodsStartDate.setText(DateUtil.date2String(goods.getProductionDate()));
            tv_goodsDeadline.setText(DateUtil.date2String(goods.getDeadline()));
            tv_goodsEnergy.setText(goods.getEnergy());
            tv_goodsEnergy_per.setText(goods.getEnergy_per());
            tv_goodsProtein.setText(goods.getProtein());
            tv_goodsProtein_per.setText(goods.getProtein_per());
            tv_goodsFat.setText(goods.getFat());
            tv_goodsFat_per.setText(goods.getFat_per());
            tv_goodsCarbohydrate.setText(goods.getCarbohydrate());
            tv_goodsCarbohydrate_per.setText(goods.getCarbohydrate_per());
        }catch (Exception e){
            e.printStackTrace();
            new AlertDialog.Builder(this)
                    .setTitle("错误")
                    .setMessage("界面出错，请稍后重试")
                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }

        btn_addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String orderNo = EGOApplication.getInstance().getOrderNo();

                    Date now = new Date();
                    if (orderNo.equals("")) {
                        orderNo = String.valueOf(now.getTime());
                        EGOApplication.getInstance().setOrderNo(orderNo);
                    }

                    EGOApplication.getInstance().getGoodsIdList().put(
                            goods.getId(),goods.getPrice());
                    ToastUtil.show(getApplicationContext(), "加入成功");

                    finish();
                } catch (Exception e){
                    e.printStackTrace();
                    ToastUtil.show(getApplicationContext(), "加入失败，请稍后重试");
                }
            }
        });
    }
}
