package com.unicorn.easygo.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.R;
import com.unicorn.easygo.entity.ScanRecord;
import com.unicorn.easygo.utils.FontUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by haoc_dp on 2017/6/14.
 */

public class ScanRecordAdapter extends RecyclerView.Adapter<ScanRecordAdapter.ScanRecordViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<ScanRecord> scanRecords;

    public ScanRecordAdapter(Context context, List<ScanRecord> list) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.scanRecords = list;
    }

    @Override
    public ScanRecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.scan_record_item, parent, false);
        final ScanRecordViewHolder scanRecordViewHolder = new ScanRecordViewHolder(v);

        return scanRecordViewHolder;
    }

    @Override
    public void onBindViewHolder(ScanRecordViewHolder holder, int position) {
        try {
            ScanRecord scanRecord = scanRecords.get(position);
            holder.scanRecordImage.setImageBitmap(BitmapFactory.decodeStream(
                    context.getAssets().open(scanRecord.getImageUrl())));
            holder.scanRecordDescription.setText(scanRecord.getDescription());
            holder.scanRecordPrice.setText(String.valueOf(scanRecord.getPrice()));

            FontUtil.setFont(holder.scanRecordDescription,
                    context.getAssets(), 0);
            FontUtil.setFont(holder.scanRecordPrice,
                    context.getAssets(), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return scanRecords.size();
    }

    public class ScanRecordViewHolder extends RecyclerView.ViewHolder {

        private ImageView scanRecordImage;
        private TextView scanRecordDescription;
        private TextView scanRecordPrice;

        public ScanRecordViewHolder(View itemView) {
            super(itemView);
            scanRecordImage = (ImageView) itemView.findViewById(R.id.imageView_scanRecord);
            scanRecordDescription = (TextView) itemView.findViewById(R.id.textView_scanRecord_description);
            scanRecordPrice = (TextView) itemView.findViewById(R.id.textView_scanRecord_price);
        }
    }

}
