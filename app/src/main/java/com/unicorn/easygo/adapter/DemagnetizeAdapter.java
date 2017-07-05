package com.unicorn.easygo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.db.litepal.Goods;

import java.util.List;

/**
 * Created by haoc_dp on 2017/7/2.
 */

public class DemagnetizeAdapter extends RecyclerView.Adapter<DemagnetizeAdapter.DemagnetizeViewHolder>{

    private LayoutInflater layoutInflater;
    private Context context;
    private List<Goods> goodsList;

    public DemagnetizeAdapter(Context context, List<Goods> goodsList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.goodsList = goodsList;
    }

    @Override
    public DemagnetizeAdapter.DemagnetizeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.demagnetize_goods_item, parent, false);
        final DemagnetizeAdapter.DemagnetizeViewHolder demagnetizeViewHolder = new DemagnetizeAdapter.DemagnetizeViewHolder(v);
        return demagnetizeViewHolder;
    }

    @Override
    public void onBindViewHolder(DemagnetizeAdapter.DemagnetizeViewHolder holder, int position) {
        Goods goods = goodsList.get(position);
        holder.tv_orderGoodsName.setText(goods.getGoodsName());
        holder.tv_orderGoodsNum.setText("1");
        holder.tv_orderGoodsPrice.setText(String.valueOf(goods.getPrice()));
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    class DemagnetizeViewHolder extends RecyclerView.ViewHolder {

        //private ImageView iv_demagnetized;
        private TextView tv_orderGoodsName;
        private TextView tv_orderGoodsNum;
        private TextView tv_orderGoodsPrice;

        public DemagnetizeViewHolder(View itemView) {
            super(itemView);
            //iv_demagnetized = (ImageView) itemView.findViewById(R.id.iv_demagnetize);
            tv_orderGoodsName = (TextView) itemView.findViewById(R.id.tv_order_goods);
            tv_orderGoodsNum = (TextView) itemView.findViewById(R.id.tv_order_goods_num);
            tv_orderGoodsPrice = (TextView) itemView.findViewById(R.id.tv_order_goods_price);
        }
    }
}
