package com.unicorn.easygo.utils;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.unicorn.easygo.R;

/**
 * Created by guojishan on 2017/6/9.
 */

public class TopMenuHeader {
    public Button leftButton;
    public TextView title;

    public TopMenuHeader(View v){
        leftButton = (Button)v.findViewById(R.id.title_back);
        title = (TextView)v.findViewById(R.id.title_text);
    }

}
