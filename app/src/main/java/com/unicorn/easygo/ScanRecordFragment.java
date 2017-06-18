package com.unicorn.easygo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unicorn.easygo.adapter.ScanRecordAdapter;
import com.unicorn.easygo.entity.ScanRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guojishan on 2017/6/4.
 */

public class ScanRecordFragment extends Fragment {

    private List<ScanRecord> scanRecords;

    private RecyclerView recyclerView;
    private ScanRecordAdapter scanRecordAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view= inflater.inflate(R.layout.scan_record_layout, container, false);

        initDatas();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_scanRecords);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        scanRecordAdapter = new ScanRecordAdapter(this.getContext(), scanRecords);
        recyclerView.setAdapter(scanRecordAdapter);
        return view;
    }

    /**
     * 初始化数据
     */
    private void initDatas(){
        ScanRecord scanRecord1 = new ScanRecord(
                "精选蓝莓2盒",
                "images/lanmei.png",
                19.9
        );

        ScanRecord scanRecord2 = new ScanRecord(
                "泰国金枕头榴莲9-10斤",
                "images/liulian.png",
                118
        );

        ScanRecord scanRecord3 = new ScanRecord(
                "越南红心火龙果1kg",
                "images/huolongguo.png",
                19.9
        );
        ScanRecord scanRecord4 = new ScanRecord(
                "海南妃子笑荔枝500g",
                "images/lizhi.png",
                9.9
        );
        ScanRecord scanRecord5 = new ScanRecord(
                "南美白虾仁250g/包 中号",
                "images/xiaren.png",
                19.9
        );
        ScanRecord scanRecord6 = new ScanRecord(
                "泰国山竹500g",
                "images/shanzhu.png",
                19.9
        );
        ScanRecord scanRecord7 = new ScanRecord(
                "Zespri佳沛新西兰阳光金奇异果",
                "images/qiyiguo.png",
                19.9
        );
        ScanRecord scanRecord8 = new ScanRecord(
                "獐子岛蒜蓉粉丝扇贝200g",
                "images/shanbei.png",
                19.9
        );

        scanRecords = new ArrayList<>();
        scanRecords.add(scanRecord1);
        scanRecords.add(scanRecord2);
        scanRecords.add(scanRecord3);
        scanRecords.add(scanRecord4);
        scanRecords.add(scanRecord5);
        scanRecords.add(scanRecord6);
        scanRecords.add(scanRecord7);
        scanRecords.add(scanRecord8);
    }
}
