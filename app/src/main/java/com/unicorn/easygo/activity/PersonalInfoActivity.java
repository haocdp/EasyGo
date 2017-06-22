package com.unicorn.easygo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;

/**
 * Created by guojishan on 2017/6/8.
 */

public class PersonalInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private Button quit;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinfo);

        init();
        FontUtil.setFont(title,this.getAssets(),0);
        FontUtil.setFont(tv1,this.getAssets(),0);
        FontUtil.setFont(tv2,this.getAssets(),0);
        FontUtil.setFont(tv3,this.getAssets(),0);
        FontUtil.setFont(tv4,this.getAssets(),0);
        FontUtil.setFont(tv5,this.getAssets(),0);
        FontUtil.setFont(tv6,this.getAssets(),0);
        FontUtil.setFont(tv7,this.getAssets(),0);
        FontUtil.setFont(tv8,this.getAssets(),0);
        FontUtil.setFont(quit,this.getAssets(),0);
    }
    private void init(){
        title = (TextView)findViewById(R.id.title_text);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);
        tv7 = (TextView)findViewById(R.id.tv7);
        tv8 = (TextView)findViewById(R.id.tv8);
        quit = (Button)findViewById(R.id.quit);

        title.setText("个人信息");
        quit.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.quit:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

}
