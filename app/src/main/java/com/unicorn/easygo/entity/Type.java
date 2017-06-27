package com.unicorn.easygo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by guojishan on 2017/6/26.
 */
//存标题和数据Data集合
public class Type {
    private String title;//ListView头部显示的标题
    private List<myOrderListItem> mList;//头部对应的内容集合

    public Type(String title){
        this.title = title;
        mList = new ArrayList<>();
    }

//    添加项目
    public void addItem(myOrderListItem data){
        mList.add(data);
    }
    //如果position为1就返回标题
    public Object getItem(int position){
        if(position == 0){
            return title;
        }else{
            return mList.get(position-1);
        }
    }
    //item 数目
    public int size(){
        return mList.size() + 1;
    }
}
