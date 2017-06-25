package com.unicorn.easygo.activity;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.adapter.MessageAdapter;
import com.unicorn.easygo.adapter.RecyclerViewAdapter;
import com.unicorn.easygo.entity.MessageItem;
import com.unicorn.easygo.utils.FontUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/8.
 */

public class MessageActivity extends AppCompatActivity {

    private List<MessageItem> mList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        TextView title = (TextView)findViewById(R.id.title_text);
        title.setText("消息管理");
        FontUtil.setFont(title,this.getAssets(),0);

        initItem();//初始化数据
        RecyclerView message_recyclerView = (RecyclerView)findViewById(R.id.message_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        message_recyclerView.setLayoutManager(layoutManager);
        MessageAdapter adapter = new MessageAdapter(mList);
        message_recyclerView.setAdapter(adapter);
    }
    private void initItem(){
        MessageItem item1 = new MessageItem(R.drawable.coupon,R.drawable.red_point,"优惠券提醒","您有一张中百仓储优惠券即将过期，请尽快使用");
        mList.add(item1);
        MessageItem item2 = new MessageItem(R.drawable.chongzhi,0,"充值提醒","您已成功充值人民币100元");
        mList.add(item2);
        MessageItem item3 = new MessageItem(R.drawable.coupon,R.drawable.red_point,"优惠券提醒","您有一张中百仓储优惠券即将过期，请尽快使用");
        mList.add(item3);
    }
}
