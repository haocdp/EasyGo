package com.unicorn.easygo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.db.litepal.Goods;

import java.util.List;

/**
 * Created by haoc_dp on 2017/6/30.
 */

public class ConfirmOrderRecyclerAdapter extends RecyclerView.Adapter<
        ConfirmOrderRecyclerAdapter.ConfirmOrderViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<Goods> goodsList;

    public ConfirmOrderRecyclerAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.goodsList = goodsList;
    }

    @Override
    public ConfirmOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.activity_confirm_order_item, parent, false);
        final ConfirmOrderViewHolder confirmOrderViewHolder = new ConfirmOrderViewHolder(v);
        return confirmOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(ConfirmOrderViewHolder holder, int position) {
        Goods goods = goodsList.get(position);
        holder.tv_orderGoodsName.setText(goods.getGoodsName());
        holder.tv_orderGoodsNum.setText("1");
        holder.tv_orderGoodsPrice.setText(String.valueOf(goods.getPrice()));
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class ConfirmOrderViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_orderGoodsName;
        private TextView tv_orderGoodsNum;
        private TextView tv_orderGoodsPrice;

        public ConfirmOrderViewHolder(View itemView) {
            super(itemView);
            tv_orderGoodsName = (TextView) itemView.findViewById(R.id.tv_order_goods);
            tv_orderGoodsNum = (TextView) itemView.findViewById(R.id.tv_order_goods_num);
            tv_orderGoodsPrice = (TextView) itemView.findViewById(R.id.tv_order_goods_price);
        }
    }
}
