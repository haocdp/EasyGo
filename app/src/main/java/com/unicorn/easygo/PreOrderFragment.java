package com.unicorn.easygo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        recyclerView.setAdapter(new PreOrderAdapter(this.getContext(), preOrderItems));


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
}
