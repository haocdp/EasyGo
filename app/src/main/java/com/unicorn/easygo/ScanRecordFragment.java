package com.unicorn.easygo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guojishan on 2017/6/4.
 */

public class ScanRecordFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.scan_record_layout, container, false);
        return view;
    }
}
