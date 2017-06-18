package com.unicorn.easygo;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.unicorn.easygo.adapter.PreOrderAdapter;
import com.unicorn.easygo.utils.PreferenceUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by guojishan on 2017/6/4.
 */

public class PreOrderFragment extends Fragment {

    private List<String> preOrderItems;
    private RecyclerView recyclerView;
    private PreOrderAdapter preOrderAdapter;

    private Gson gson = new Gson();
    private Type type = new TypeToken<ArrayList<String>>(){}.getType();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pre_order_list_layout,
                container, false);

        //PreferenceUtils.clearPreference(this.getContext());
        String preOrders_temp = PreferenceUtils.getPrefString(this.getContext(),
                PreferenceUtils.PRE_ORDER_ITEMS_KEY,
                "");
        if (!preOrders_temp.equals("")) {
            preOrderItems = gson.fromJson(preOrders_temp, type);
        }

        if (preOrderItems == null)
            preOrderItems = new ArrayList<>();
        preOrderItems.add("");

        recyclerView = (RecyclerView) view.findViewById(
                R.id.recyclerView_orders);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        preOrderAdapter = new PreOrderAdapter(this.getContext(), preOrderItems);
        recyclerView.setAdapter(preOrderAdapter);

        swipeEvent();
        return view;
    }

    @Override
    public void onDestroy() {
        PreOrderAdapter preOrderAdapter = (PreOrderAdapter) recyclerView.getAdapter();
        List<String> items = preOrderAdapter.getOrderItems();
        items.remove(items.size()-1);
        PreferenceUtils.setPrefString(this.getContext(),
                PreferenceUtils.PRE_ORDER_ITEMS_KEY,
                gson.toJson(items));
        super.onDestroy();
    }

    /**
     * 使用ItemTouchHelper设置侧滑删除事件
     */
    private void swipeEvent() {
        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
        ) {

            /**
             * 拖拽事件，在本应用中不存在
             * @param recyclerView
             * @param viewHolder
             * @param target
             * @return
             */
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            /**
             * 侧滑删除事件
             * @param viewHolder
             * @param direction
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                /**
                 * 当editText编辑后在删除时，会有bug,
                 * 设置在滑动事件发生时，让editText失去焦点
                 */
                PreOrderAdapter.PreOrderViewHolder preOrderViewHolder =
                        (PreOrderAdapter.PreOrderViewHolder) viewHolder;
                preOrderViewHolder.editText.setFocusable(false);
                preOrderViewHolder.editText.setFocusableInTouchMode(false);


                int position = viewHolder.getAdapterPosition();
                ((PreOrderAdapter)recyclerView.getAdapter()).getOrderItems().remove(position);
                //preOrderItems.remove(position);
                preOrderAdapter.notifyItemRemoved(position);
            }

            /**
             * 控制item中某一项不能触发删除事件，
             * 在本应用中最后一项不能被删除
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView,
                                        RecyclerView.ViewHolder viewHolder) {
                /**
                 * 当position等于最后一项事，禁止滑动事件
                 */
                if (viewHolder.getAdapterPosition() ==
                        ((PreOrderAdapter)recyclerView.getAdapter()).getOrderItems().size() - 1)
                    return ItemTouchHelper.ACTION_STATE_IDLE;
                return super.getMovementFlags(recyclerView, viewHolder);
            }

            /**
             * 滑动时的动画显示
             * @param c
             * @param recyclerView
             * @param viewHolder
             * @param dX
             * @param dY
             * @param actionState
             * @param isCurrentlyActive
             */
            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    //滑动时改变Item的透明度
                    final float alpha = 1 - Math.abs(dX) / (float)viewHolder.itemView.getWidth();
                    viewHolder.itemView.setAlpha(alpha);
                    viewHolder.itemView.setTranslationX(dX);
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
