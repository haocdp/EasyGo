package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.PersonalAdapter;
import com.unicorn.easygo.entity.PersonItem;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.utils.TopMenuHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/8.
 */

public class PersonalInfoActivity extends AppCompatActivity {
    private List<PersonItem> personList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalinfo);
        TextView title = (TextView)findViewById(R.id.title_text);
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        TextView tv2 = (TextView)findViewById(R.id.tv2);
        TextView tv3 = (TextView)findViewById(R.id.tv3);
        TextView tv4 = (TextView)findViewById(R.id.tv4);
        TextView tv5 = (TextView)findViewById(R.id.tv5);
        TextView tv6 = (TextView)findViewById(R.id.tv6);
        TextView tv7 = (TextView)findViewById(R.id.tv7);
        TextView tv8 = (TextView)findViewById(R.id.tv8);


        Button quit = (Button)findViewById(R.id.quit);
        title.setText("个人信息");
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
//    private void initPersion(){
//        PersonItem usrname = new PersonItem("用户名","wallencefans");
//        personList.add(usrname);
//        PersonItem vip = new PersonItem("我的会员","");
//        personList.add(vip);
//        PersonItem sex = new PersonItem("性别","女");
//        personList.add(sex);
//        PersonItem drawback = new PersonItem("反馈","");
//        personList.add(drawback);
//        PersonItem update = new PersonItem("更新","");
//        personList.add(update);
//
//    }
}
