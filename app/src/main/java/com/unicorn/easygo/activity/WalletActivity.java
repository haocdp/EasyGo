package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.TopMenuHeader;

/**
 * Created by guojishan on 2017/6/8.
 */

public class WalletActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);

        TextView title = (TextView)findViewById(R.id.title_text);
        TextView money = (TextView)findViewById(R.id.money);
        TextView rmb = (TextView)findViewById(R.id.rmb);
        title.setText("我的钱包");
        FontUtil.setFont(title,this.getAssets(),0);
        FontUtil.setFont(money,this.getAssets(),0);
        FontUtil.setFont(rmb,this.getAssets(),0);
    }
}
