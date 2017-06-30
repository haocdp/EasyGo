package com.unicorn.easygo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;

public class MapGoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_goods);

        TextView title = (TextView) findViewById(R.id.title_text);
        title.setText("商品位置");
        FontUtil.setFont(title, getAssets(), 0);
    }
}
