package com.unicorn.easygo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.MainActivity;
import com.unicorn.easygo.R;
import com.unicorn.easygo.db.account;
import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.litepal.User;
import com.unicorn.easygo.db.user;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.TopMenuHeader;

import org.litepal.crud.DataSupport;

import java.util.List;

import static com.unicorn.easygo.R.drawable.goods;

/**
 * Created by guojishan on 2017/6/8.
 */

public class WalletActivity extends AppCompatActivity {

    private TextView money;
    //private accountDBdao accountdao;
    //private userDBdao userdao;
    private Intent intent;
    private String name;//账号

    private Button despoit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallet);

        TextView title = (TextView)findViewById(R.id.title_text);
        TextView money = (TextView)findViewById(R.id.money);
        TextView rmb = (TextView)findViewById(R.id.rmb);
        despoit = (Button) findViewById(R.id.deposit);
        title.setText("我的钱包");
        FontUtil.setFont(title,this.getAssets(),0);
        FontUtil.setFont(money,this.getAssets(),0);
        FontUtil.setFont(rmb,this.getAssets(),0);

        money = (TextView)findViewById(R.id.money);
        //accountdao = new accountDBdao(getApplicationContext());
        //userdao = new userDBdao(getApplicationContext());
        //intent = this.getIntent();
        //name = intent.getStringExtra("login_name");// 接收登录界面的数据
        //Log.i("test1:",String.valueOf(name));
        //List<user> users = userdao.findByName(name);
        //user demo = users.get(0);
        //int userid = demo.getUserid();
        //Log.i("test2:",String.valueOf(userid));
        //List<account> accounts = accountdao.findByuserId(userid);
        //account demo1 = accounts.get(0);
        //double qian = demo1.getMoney();
        //money.setText(String.valueOf(qian));

        List<User> userList = DataSupport.where("id = ?",
                String.valueOf(EGOApplication.getInstance().getUserProfile().getId()))
                                .find(User.class);
        if (userList.size() != 0) {
            money.setText(String.valueOf(userList.get(0).getMoney()));
        } else {
            money.setText("0");
        }


        /*despoit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PayActivity.class);
                startActivity(intent);
            }
        });*/

    }
}
