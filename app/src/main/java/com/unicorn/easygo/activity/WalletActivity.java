package com.unicorn.easygo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.db.account;
import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.user;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.TopMenuHeader;

import java.util.List;

import static com.unicorn.easygo.R.drawable.goods;

/**
 * Created by guojishan on 2017/6/8.
 */

public class WalletActivity extends AppCompatActivity {

    private TextView money;
    private accountDBdao accountdao;
    private userDBdao userdao;
    private Intent intent;
    private String name;//账号

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

        money = (TextView)findViewById(R.id.money);
        money.setText("1000");
        accountdao = new accountDBdao(getApplicationContext());
        userdao = new userDBdao(getApplicationContext());
        intent = this.getIntent();
        name = intent.getStringExtra("name");// 接收登录界面的数据

        List<user> users = userdao.findByName(name);
        user demo = users.get(0);
        int userid = demo.getUserid();
        //List<account> accounts = accountdao.find(userid);



    }
}
