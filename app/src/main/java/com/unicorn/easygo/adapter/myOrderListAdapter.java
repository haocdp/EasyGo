package com.unicorn.easygo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.Type;
import com.unicorn.easygo.entity.myOrderListItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/16.
 */

public class myOrderListAdapter extends BaseAdapter {
    private static final int TYPE_HEADER = 0; //代表标题
    private static final int TYPE_ITEM = 1;//代表项目item
    private List<Type> mList;
    private LayoutInflater inflater;
    public myOrderListAdapter(Context context, List<Type> list){
        mList = list;
        inflater = LayoutInflater.from(context);
    }
    public int getCount(){
        int count = 0;
        if(mList !=null){
            for(Type type:mList){
                count +=type.size();
            }
        }
        return count;
    }
    //根据position的不同返回不同的值
    public Object getItem(int position) {
        int head = 0;  //标题位置
        for (Type type : mList) {
            int size = type.size();
            int current = position - head;
            if (current < size) {
                //返回对应位置的值
                return type.getItem(current);
            }
            head += size;
        }

        return null;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        switch (getItemViewType(position)) {
            //分为两种情况加载item
            case TYPE_HEADER: //加载标题布局
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.myorderlist_items_tag, parent, false);
                    viewHolder.title = (TextView) convertView.findViewById(R.id.group_list_item_text);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.title.setText((CharSequence) getItem(position));
                break;
            case TYPE_ITEM: //加载数据项目布局
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.myorderlist_items, parent, false);
                    viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
                    viewHolder.iv = (ImageView) convertView.findViewById(R.id.list_image);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                myOrderListItem data = (myOrderListItem) getItem(position);
                viewHolder.tv1.setText(data.getTv());
                viewHolder.iv.setImageResource(data.getResourceId());

                break;
        }

        return convertView;
    }
    //返回item类型数目
    public int getViewTypeCount() {
        return 2;
    }

    //获取当前item的类型
    public int getItemViewType(int position) {
        int head = 0;
        for (Type type : mList) {
            int size = type.size();
            int current = position - head;
            if (current == 0) {
                return TYPE_HEADER;
            }
            head += size;
        }
        return TYPE_ITEM;
    }
    //判断当前的item是够可以点击
    public boolean isEnabled(int position) {
        return getItemViewType(position) != TYPE_HEADER;
    }
    public boolean areAllItemsEnabled() {
        return false;
    }
    private class ViewHolder {
        TextView tv1,title;
        ImageView iv;
    }

//    private Context mContext;
//    private List<myOrderListAdapter> objects;
//    private List<String> listTag =null;
//    public myOrderListAdapter(Context context, List<myOrderListAdapter> objects, List<String> tags){
//        super(context,0,objects);
//        this.mContext = context;
//        this.objects = objects;
//        this.listTag = tags;
//    }
//    public boolean isEnabled(int position) {
//        if(listTag.contains(getItem(position))){
//            return false;
//        }
//        return super.isEnabled(position);
//    }
//    public View getView(int position,View convertView,ViewGroup parent){
//
//        View view = convertView;
//        if(listTag.contains(getItem(position))){
//            view = LayoutInflater.from(getContext()).inflate(R.layout.myorderlist_items_tag, null);
//        }else{
//            view = LayoutInflater.from(getContext()).inflate(R.layout.myorderlist_items, null);
//        }
//        //myOrderListItem item = getItem(position);
//        //显示名称
//        TextView textView = (TextView)view.findViewById(R.id.group_list_item_text);
//        textView.setText(getItem(position));
//        return view;
//
//    }

//    public void add(int position,myOrderListItem data){
//        if (mData == null) {
//            mData = new LinkedList<>();
//        }
//        mData.add(position,data);
//        notifyDataSetChanged();
//    }
}
