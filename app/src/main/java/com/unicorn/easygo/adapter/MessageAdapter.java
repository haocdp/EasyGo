package com.unicorn.easygo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.HistoryItem;
import com.unicorn.easygo.entity.MessageItem;
import java.util.List;

/**
 * Created by guojishan on 2017/6/25.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<MessageItem> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView red_point;
        ImageView warn_image;
        TextView warn;
        TextView warn_detail;

        public ViewHolder(View view) {
            super(view);
            red_point = (ImageView) view.findViewById(R.id.red_point);
            warn_image = (ImageView) view.findViewById(R.id.warn_image);
            warn = (TextView) view.findViewById(R.id.warn);
            warn_detail = (TextView) view.findViewById(R.id.warn_detail);
        }
    }
    //构造函数，传参，数据源
    public MessageAdapter(List<MessageItem> mList){
        this.mList = mList;
    }

    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item,parent,false);
        MessageAdapter.ViewHolder holder = new MessageAdapter.ViewHolder(view);
        return holder;
    }
    /*
    * 对子项数据进行赋值，在每个子项滚动到屏幕内的时候执行
    * */
    public void onBindViewHolder(ViewHolder holder,int position){
        MessageItem item = mList.get(position);
        holder.red_point.setImageResource(item.getRed_point());
        holder.warn_image.setImageResource(item.getWarn_image());
        holder.warn.setText(item.getWarn());
        holder.warn_detail.setText(item.getWarn_detail());
    }
    /*返回数据源的长度*/
    public int getItemCount(){
        return mList.size();
    }

    //动态添加item子项
    public int getItemViewType(int position){
        return position;
    }
}
