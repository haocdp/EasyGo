package com.unicorn.easygo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.PersonItem;

import java.util.List;

/**
 * Created by guojishan on 2017/6/16.
 */

public class PersonalAdapter extends ArrayAdapter<PersonItem> {
    private Context mContext;
    private List<PersonItem> objects;
    private int recourseId;
    public PersonalAdapter(Context context,int recourseId, List<PersonItem> objects){
        super(context,recourseId,objects);
        this.mContext = context;
        this.objects = objects;
        this.recourseId = recourseId;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        PersonItem item = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.personalinfo_item,parent,false);
        TextView option1 = (TextView)view.findViewById(R.id.tv1);
        TextView option2 = (TextView)view.findViewById(R.id.tv2);
        option1.setText(item.getOption1());
        option2.setText(item.getOption2());
        return view;

    }
}
