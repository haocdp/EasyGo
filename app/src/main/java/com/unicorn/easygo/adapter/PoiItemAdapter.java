package com.unicorn.easygo.adapter;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.route.Path;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.unicorn.easygo.EGOApplication;
import com.unicorn.easygo.R;
import com.unicorn.easygo.utils.NetworkCheckUtil;
import com.unicorn.easygo.utils.Path2Stream;

import java.io.InputStream;
import java.util.List;

/**
 * Created by haoc_dp on 2017/6/26.
 */

public class PoiItemAdapter extends RecyclerView.Adapter<PoiItemAdapter.ViewHolder> {

    public int mSelectedItem = -1;
    public List<PoiItem> mItems;
    public PoiItem poiItem;
    private Context mContext;
    private Bitmap bitmap;

    /**
     * volly加载图片
     */
    private ImageLoader imageLoader;

    private EGOApplication egoApplication;

    public PoiItemAdapter(Context context, List<PoiItem> items) {
        this.mContext = context;
        this.mItems = items;

        RequestQueue queue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(queue, new BitmapCache());

        egoApplication = EGOApplication.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final View view = inflater.inflate(R.layout.activity_market_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        poiItem = mItems.get(position);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mSelectedItem = holder.getAdapterPosition();

                notifyItemRangeChanged(0, mItems.size());
            }
        });

        if (position == mSelectedItem) {
            holder.toggleButton.setChecked(true);
            egoApplication.setMarketName(poiItem.getTitle());
            holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(
                    R.color.assistColor_white));
        } else {
            holder.toggleButton.setChecked(false);
            holder.constraintLayout.setBackgroundColor(mContext.getResources().getColor(
                    R.color.result_text));
        }
        //Log.i("poi", poiItem.getPhotos().get(0).getUrl());

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    bitmap = Path2Stream.path2Stream(
                            poiItem.getPhotos().size() != 0 ?
                                    poiItem.getPhotos().get(0).getUrl() : "");

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

        /*try {
            if (bitmap != null)
                holder.poiPhoto.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        if (poiItem.getPhotos().size() != 0)
            holder.poiPhoto.setImageUrl(poiItem.getPhotos().get(0).getUrl(), imageLoader);
        //Log.i("poi", poiItem.getTitle());
        holder.poiTitle.setText(poiItem.getTitle());
        //Log.i("poi", poiItem.getPoiExtension().getmRating());
        holder.poiRating.setText(poiItem.getPoiExtension().getmRating());
        //Log.i("poi", poiItem.getSnippet());
        holder.poiAddress.setText(poiItem.getSnippet());
        //Log.i("poi", String.valueOf(poiItem.getDistance()));
        holder.poiDistance.setText(String.valueOf(poiItem.getDistance()));
    }

    @Override
    public int getItemCount() {
        if (mItems != null)
            return mItems.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout constraintLayout;
        //public RadioButton radioButton;
        public ToggleButton toggleButton;
        public NetworkImageView poiPhoto;
        public TextView poiTitle;
        public TextView poiRating;
        public TextView poiAddress;
        public TextView poiDistance;

        public ViewHolder(View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constraintLayout_poi);
            //radioButton = (RadioButton) itemView.findViewById(R.id.radioButton);
            toggleButton = (ToggleButton) itemView.findViewById(R.id.toggleButton2);
            poiPhoto = (NetworkImageView) itemView.findViewById(R.id.iv_poi_photo);
            poiTitle = (TextView) itemView.findViewById(R.id.tv_poi_title);
            poiRating = (TextView) itemView.findViewById(R.id.tv_poi_rating);
            poiAddress = (TextView) itemView.findViewById(R.id.tv_poi_address);
            poiDistance = (TextView) itemView.findViewById(R.id.tv_poi_distance);

            View.OnClickListener onClickListener = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyItemRangeChanged(0, mItems.size());
                }
            };

            //constraintLayout.setOnClickListener(onClickListener);
            //radioButton.setOnClickListener(onClickListener);
            //poiTitle.setOnClickListener(onClickListener);
            //poiPhoto.setOnClickListener(onClickListener);
            //poiRating.setOnClickListener(onClickListener);
            //poiAddress.setOnClickListener(onClickListener);
            //poiDistance.setOnClickListener(onClickListener);
        }
    }

    /**
     * 使用LruCache来缓存图片
     */
    public class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            // 获取应用程序最大可用内存
            int maxMemory = (int) Runtime.getRuntime().maxMemory();
            int cacheSize = maxMemory / 8;
            mCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }
}
