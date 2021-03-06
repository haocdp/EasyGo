package com.unicorn.easygo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.HistoryItem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/15.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<HistoryItem> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;
        TextView itemClassify;
        TextView itemPrice;
        TextView itemWeight;
        TextView itemPro_date;
        TextView itemSto_life;
        public ViewHolder(View view){
            super(view);
            itemImage = (ImageView)view.findViewById(R.id.image);
            itemName = (TextView)view.findViewById(R.id.name);
            itemClassify = (TextView)view.findViewById(R.id.classify);
            itemPrice = (TextView)view.findViewById(R.id.price);
            itemWeight = (TextView)view.findViewById(R.id.weight);
            itemPro_date = (TextView)view.findViewById(R.id.production_date);
            itemSto_life = (TextView)view.findViewById(R.id.storage_life);
        }
    }
    //构造函数，传参，数据源
    public RecyclerViewAdapter(List<HistoryItem> mList){
        this.mList = mList;
    }

    //重写以下三个方法

    /*
    *加载item子布局，，创建ViewHolder实例，将加载的子布局传入构造函数，
    * 最后返回ViewHolder实例
    * */
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    /*
    * 对子项数据进行赋值，在每个子项滚动到屏幕内的时候执行
    * */
    public void onBindViewHolder(ViewHolder holder,int position){
        HistoryItem item = mList.get(position);
        holder.itemImage.setImageResource(item.getImageId());
        holder.itemName.setText(item.getName());
        holder.itemClassify.setText(item.getClassify());
        holder.itemPrice.setText(item.getPrice());
        holder.itemWeight.setText(item.getWeight());
        holder.itemPro_date.setText(item.getProduction_date());
        holder.itemSto_life.setText(item.getStorage_life());
    }
    /*返回数据源的长度*/
    public int getItemCount(){
        return mList.size();
    }

    //动态添加item子项
    public int getItemViewType(int position){
        return position;
    }

//    public void add(int position,DataModel data){
//        if(mData == null){
//            mData = new LinkedList<>();
//        }
//        mData.add(position,data);
//        notifyItemInserted(position); //Attention!
//    }
}
