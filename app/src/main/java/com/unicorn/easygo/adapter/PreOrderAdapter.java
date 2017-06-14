package com.unicorn.easygo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.unicorn.easygo.MainActivity;
import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.FontUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by haoc_dp on 2017/6/13.
 */

public class PreOrderAdapter extends RecyclerView.Adapter<PreOrderAdapter.PreOrderViewHolder> {
    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<String> orderItems;

    public PreOrderAdapter (Context context, List<String> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        orderItems = list;
    }

    @Override
    public PreOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.order_item, parent, false);
        final PreOrderViewHolder preOrderViewHolder = new PreOrderViewHolder(v);

        preOrderViewHolder.editText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                view.setFocusable(true);
                view.setFocusableInTouchMode(true);
                view.requestFocus();
                //view.findFocus();
            }
        });

        preOrderViewHolder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            String beforeText;
            String afterText;

            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    beforeText = ((EditText)view).getText().toString();
                } else {
                    afterText = ((EditText)view).getText().toString();

                    if(("".equals(beforeText) || beforeText == null) &&
                            (afterText != null && !"".equals(afterText))) {
                        orderItems.add(orderItems.size()-1 , afterText);
                    }

                    if(((!"".equals(beforeText)) && beforeText != null) &&
                            ("".equals(afterText) || afterText == null)) {
                        ((EditText)view).setText(beforeText);
                    }

                    if(!"".equals(beforeText) && beforeText != null &&
                            !"".equals(afterText) && afterText != null &&
                            !beforeText.equals(afterText))
                        orderItems.set(preOrderViewHolder.getAdapterPosition(), afterText);
                }
            }
        });

        preOrderViewHolder.toggleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*view.setFocusable(true);
                view.setFocusableInTouchMode(true);
                view.requestFocus();*/
            }
        });
        return preOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(PreOrderViewHolder holder, int position) {
        String item = orderItems.get(position);
        holder.editText.setText(item);
        FontUtil.setFont(holder.editText, context.getAssets(), 0);
        holder.editText.setFocusableInTouchMode(false);
        holder.toggleButton.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public static class PreOrderViewHolder extends RecyclerView.ViewHolder {

        public ToggleButton toggleButton;
        public EditText editText;
        public PreOrderViewHolder(View itemView) {
            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.orderItem);
            toggleButton = (ToggleButton) itemView.findViewById(R.id.orderItem_toggleButton);
        }
    }

    public List<String> getOrderItems(){
        return this.orderItems;
    }
}
