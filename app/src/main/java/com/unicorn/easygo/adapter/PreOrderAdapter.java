package com.unicorn.easygo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.MainActivity;
import com.unicorn.easygo.R;
import com.unicorn.easygo.activity.MapGoodsActivity;
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

    private Intent intent;

    public PreOrderAdapter (Context context, List<String> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        intent = new Intent(context, MapGoodsActivity.class);
        orderItems = list;
    }

    @Override
    public PreOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.order_item, parent, false);
        final PreOrderViewHolder preOrderViewHolder = new PreOrderViewHolder(v);


        //preOrderViewHolder.editText.setFocusable(true);
        //preOrderViewHolder.editText.setFocusableInTouchMode(true);
        preOrderViewHolder.editText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //view.setFocusable(true);
                //view.setFocusableInTouchMode(true);
                view.requestFocus();
                //view.findFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);

                inputMethodManager.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
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

        preOrderViewHolder.followMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!"".equals(EGOApplication.getInstance().getMarketName())) {
                    context.startActivity(intent);
                } else {
                    new AlertDialog.Builder(context)
                            .setTitle("提示")
                            .setMessage("请先选择超市")
                            .setNegativeButton("确定", null)
                            .show();
                }
            }
        });
        return preOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(PreOrderViewHolder holder, int position) {
        String item = orderItems.get(position);
        holder.editText.setText(item);
        FontUtil.setFont(holder.editText, context.getAssets(), 0);
        //holder.editText.setFocusableInTouchMode(false);
        holder.toggleButton.setChecked(false);

        if (position == orderItems.size() - 1) {
            holder.followMe.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public static class PreOrderViewHolder extends RecyclerView.ViewHolder {

        public ToggleButton toggleButton;
        public EditText editText;
        public ImageView followMe;
        public PreOrderViewHolder(View itemView) {
            super(itemView);
            editText = (EditText) itemView.findViewById(R.id.orderItem);
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            toggleButton = (ToggleButton) itemView.findViewById(R.id.orderItem_toggleButton);
            //toggleButton.setFocusableInTouchMode(true);
            //toggleButton.setFocusable(true);

            followMe = (ImageView) itemView.findViewById(R.id.iv_follow_me);
        }
    }

    public List<String> getOrderItems(){
        return this.orderItems;
    }
}
