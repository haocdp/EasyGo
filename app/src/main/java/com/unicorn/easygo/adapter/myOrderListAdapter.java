package com.unicorn.easygo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.myOrderListItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/16.
 */

public class myOrderListAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private List<String> objects;
    private List<String> listTag =null;
    public myOrderListAdapter(Context context, List<String> objects, List<String> tags){
        super(context,0,objects);
        this.mContext = context;
        this.objects = objects;
        this.listTag = tags;
    }
    public boolean isEnabled(int position) {
        if(listTag.contains(getItem(position))){
            return false;
        }
        return super.isEnabled(position);
    }
    public View getView(int position,View convertView,ViewGroup parent){

        View view = convertView;
        if(listTag.contains(getItem(position))){
            view = LayoutInflater.from(getContext()).inflate(R.layout.myorderlist_items_tag, null);
        }else{
            view = LayoutInflater.from(getContext()).inflate(R.layout.myorderlist_items, null);
        }
        //myOrderListItem item = getItem(position);
        //显示名称
        TextView textView = (TextView)view.findViewById(R.id.group_list_item_text);
        textView.setText(getItem(position));
        return view;

    }

//    public void add(int position,myOrderListItem data){
//        if (mData == null) {
//            mData = new LinkedList<>();
//        }
//        mData.add(position,data);
//        notifyDataSetChanged();
//    }
}
