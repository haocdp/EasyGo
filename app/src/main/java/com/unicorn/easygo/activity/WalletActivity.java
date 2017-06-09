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
        title.setText("我的钱包");
        FontUtil.setFont(title,this,0);
    }
}
