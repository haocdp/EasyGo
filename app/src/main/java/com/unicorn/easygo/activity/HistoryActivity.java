package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.HistoryItem;
import com.unicorn.easygo.utils.FontUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/8.
 */

public class HistoryActivity extends AppCompatActivity {

    private List<HistoryItem> mList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        TextView title = (TextView)findViewById(R.id.title_text);
        title.setText("我的足迹");
        FontUtil.setFont(title,this.getAssets(),0);

        //initItem();//初始化数据
        //RecyclerView recyclerView = (RecyclerView)findViewById(R.id.)；
    }
}
