package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        title.setText("个人信息");
        FontUtil.setFont(title,this.getAssets(),0);
        initPersion();
        PersonalAdapter adapter = new PersonalAdapter(this,R.layout.personalinfo_item,personList);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
    private void initPersion(){
        PersonItem usrname = new PersonItem("用户名","wallencefans");
        personList.add(usrname);
        PersonItem vip = new PersonItem("我的会员","");
        personList.add(vip);
        PersonItem sex = new PersonItem("性别","女");
        personList.add(sex);
        PersonItem drawback = new PersonItem("反馈","");
        personList.add(drawback);
        PersonItem update = new PersonItem("更新","");
        personList.add(update);

    }
}
