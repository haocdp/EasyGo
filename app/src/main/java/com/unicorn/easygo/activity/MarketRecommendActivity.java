package com.unicorn.easygo.activity;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.MyLocationStyle;
import com.unicorn.easygo.R;

public class MarketRecommendActivity extends AppCompatActivity {

    private MapView mMapView = null;
    private UiSettings mUiSettings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_recommend);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

        AMap aMap = null;
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        aMap.moveCamera(CameraUpdateFactory.zoomTo(16f));
        mUiSettings = aMap.getUiSettings();
        //aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
        mUiSettings.setScaleControlsEnabled(true);
        //mUiSettings.setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。

        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style

        setViews();
    }

    private void setViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        TextView testText = (TextView) findViewById(R.id.test_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle("超市推荐");
        String text = "5.1,3.5,1.4,0.2,Iris-setosa\n" +
                "4.9,3.0,1.4,0.2,Iris-setosa\n" +
                "4.7,3.2,1.3,0.2,Iris-setosa\n" +
                "4.6,3.1,1.5,0.2,Iris-setosa\n" +
                "5.0,3.6,1.4,0.2,Iris-setosa\n" +
                "5.4,3.9,1.7,0.4,Iris-setosa\n" +
                "4.6,3.4,1.4,0.3,Iris-setosa\n" +
                "5.0,3.4,1.5,0.2,Iris-setosa\n" +
                "4.4,2.9,1.4,0.2,Iris-setosa\n" +
                "4.9,3.1,1.5,0.1,Iris-setosa\n" +
                "5.4,3.7,1.5,0.2,Iris-setosa\n" +
                "4.8,3.4,1.6,0.2,Iris-setosa\n" +
                "4.8,3.0,1.4,0.1,Iris-setosa\n" +
                "4.3,3.0,1.1,0.1,Iris-setosa\n" +
                "5.8,4.0,1.2,0.2,Iris-setosa\n" +
                "5.7,4.4,1.5,0.4,Iris-setosa\n" +
                "5.4,3.9,1.3,0.4,Iris-setosa\n" +
                "5.1,3.5,1.4,0.3,Iris-setosa\n" +
                "5.7,3.8,1.7,0.3,Iris-setosa\n" +
                "5.1,3.8,1.5,0.3,Iris-setosa\n" +
                "5.4,3.4,1.7,0.2,Iris-setosa\n" +
                "5.1,3.7,1.5,0.4,Iris-setosa\n" +
                "4.6,3.6,1.0,0.2,Iris-setosa\n" +
                "5.1,3.3,1.7,0.5,Iris-setosa\n" +
                "4.8,3.4,1.9,0.2,Iris-setosa\n" +
                "5.0,3.0,1.6,0.2,Iris-setosa\n" +
                "5.0,3.4,1.6,0.4,Iris-setosa\n" +
                "5.2,3.5,1.5,0.2,Iris-setosa\n" +
                "5.2,3.4,1.4,0.2,Iris-setosa\n" +
                "4.7,3.2,1.6,0.2,Iris-setosa\n" +
                "4.8,3.1,1.6,0.2,Iris-setosa\n" +
                "5.4,3.4,1.5,0.4,Iris-setosa\n" +
                "5.2,4.1,1.5,0.1,Iris-setosa\n" +
                "5.5,4.2,1.4,0.2,Iris-setosa\n" +
                "4.9,3.1,1.5,0.1,Iris-setosa\n" +
                "5.0,3.2,1.2,0.2,Iris-setosa\n" +
                "5.5,3.5,1.3,0.2,Iris-setosa\n" +
                "4.9,3.1,1.5,0.1,Iris-setosa\n" +
                "4.4,3.0,1.3,0.2,Iris-setosa\n" +
                "5.1,3.4,1.5,0.2,Iris-setosa\n" +
                "5.0,3.5,1.3,0.3,Iris-setosa\n" +
                "4.5,2.3,1.3,0.3,Iris-setosa\n" +
                "4.4,3.2,1.3,0.2,Iris-setosa\n" +
                "5.0,3.5,1.6,0.6,Iris-setosa\n" +
                "5.1,3.8,1.9,0.4,Iris-setosa\n" +
                "4.8,3.0,1.4,0.3,Iris-setosa\n" +
                "5.1,3.8,1.6,0.2,Iris-setosa\n" +
                "4.6,3.2,1.4,0.2,Iris-setosa\n" +
                "5.3,3.7,1.5,0.2,Iris-setosa\n" +
                "5.0,3.3,1.4,0.2,Iris-setosa\n" +
                "7.0,3.2,4.7,1.4,Iris-versicolor\n" +
                "6.4,3.2,4.5,1.5,Iris-versicolor\n" +
                "6.9,3.1,4.9,1.5,Iris-versicolor\n" +
                "5.5,2.3,4.0,1.3,Iris-versicolor\n" +
                "6.5,2.8,4.6,1.5,Iris-versicolor\n" +
                "5.7,2.8,4.5,1.3,Iris-versicolor\n" +
                "6.3,3.3,4.7,1.6,Iris-versicolor\n" +
                "4.9,2.4,3.3,1.0,Iris-versicolor\n" +
                "6.6,2.9,4.6,1.3,Iris-versicolor\n" +
                "5.2,2.7,3.9,1.4,Iris-versicolor\n" +
                "5.0,2.0,3.5,1.0,Iris-versicolor\n" +
                "5.9,3.0,4.2,1.5,Iris-versicolor\n" +
                "6.0,2.2,4.0,1.0,Iris-versicolor\n" +
                "6.1,2.9,4.7,1.4,Iris-versicolor\n" +
                "5.6,2.9,3.6,1.3,Iris-versicolor\n" +
                "6.7,3.1,4.4,1.4,Iris-versicolor\n" +
                "5.6,3.0,4.5,1.5,Iris-versicolor\n" +
                "5.8,2.7,4.1,1.0,Iris-versicolor\n" +
                "6.2,2.2,4.5,1.5,Iris-versicolor\n" +
                "5.6,2.5,3.9,1.1,Iris-versicolor\n" +
                "5.9,3.2,4.8,1.8,Iris-versicolor\n" +
                "6.1,2.8,4.0,1.3,Iris-versicolor\n" +
                "6.3,2.5,4.9,1.5,Iris-versicolor\n" +
                "6.1,2.8,4.7,1.2,Iris-versicolor\n" +
                "6.4,2.9,4.3,1.3,Iris-versicolor\n" +
                "6.6,3.0,4.4,1.4,Iris-versicolor\n" +
                "6.8,2.8,4.8,1.4,Iris-versicolor\n" +
                "6.7,3.0,5.0,1.7,Iris-versicolor\n" +
                "6.0,2.9,4.5,1.5,Iris-versicolor\n" +
                "5.7,2.6,3.5,1.0,Iris-versicolor\n" +
                "5.5,2.4,3.8,1.1,Iris-versicolor\n" +
                "5.5,2.4,3.7,1.0,Iris-versicolor\n" +
                "5.8,2.7,3.9,1.2,Iris-versicolor\n" +
                "6.0,2.7,5.1,1.6,Iris-versicolor\n" +
                "5.4,3.0,4.5,1.5,Iris-versicolor\n" +
                "6.0,3.4,4.5,1.6,Iris-versicolor\n" +
                "6.7,3.1,4.7,1.5,Iris-versicolor\n" +
                "6.3,2.3,4.4,1.3,Iris-versicolor\n" +
                "5.6,3.0,4.1,1.3,Iris-versicolor\n" +
                "5.5,2.5,4.0,1.3,Iris-versicolor\n" +
                "5.5,2.6,4.4,1.2,Iris-versicolor\n" +
                "6.1,3.0,4.6,1.4,Iris-versicolor\n" +
                "5.8,2.6,4.0,1.2,Iris-versicolor\n" +
                "5.0,2.3,3.3,1.0,Iris-versicolor\n" +
                "5.6,2.7,4.2,1.3,Iris-versicolor\n" +
                "5.7,3.0,4.2,1.2,Iris-versicolor\n" +
                "5.7,2.9,4.2,1.3,Iris-versicolor\n" +
                "6.2,2.9,4.3,1.3,Iris-versicolor\n" +
                "5.1,2.5,3.0,1.1,Iris-versicolor\n" +
                "5.7,2.8,4.1,1.3,Iris-versicolor\n" +
                "6.3,3.3,6.0,2.5,Iris-virginica\n" +
                "5.8,2.7,5.1,1.9,Iris-virginica\n" +
                "7.1,3.0,5.9,2.1,Iris-virginica\n" +
                "6.3,2.9,5.6,1.8,Iris-virginica\n" +
                "6.5,3.0,5.8,2.2,Iris-virginica\n" +
                "7.6,3.0,6.6,2.1,Iris-virginica\n" +
                "4.9,2.5,4.5,1.7,Iris-virginica\n" +
                "7.3,2.9,6.3,1.8,Iris-virginica\n" +
                "6.7,2.5,5.8,1.8,Iris-virginica\n" +
                "7.2,3.6,6.1,2.5,Iris-virginica\n" +
                "6.5,3.2,5.1,2.0,Iris-virginica\n" +
                "6.4,2.7,5.3,1.9,Iris-virginica\n" +
                "6.8,3.0,5.5,2.1,Iris-virginica\n" +
                "5.7,2.5,5.0,2.0,Iris-virginica\n" +
                "5.8,2.8,5.1,2.4,Iris-virginica\n" +
                "6.4,3.2,5.3,2.3,Iris-virginica\n" +
                "6.5,3.0,5.5,1.8,Iris-virginica\n" +
                "7.7,3.8,6.7,2.2,Iris-virginica\n" +
                "7.7,2.6,6.9,2.3,Iris-virginica\n" +
                "6.0,2.2,5.0,1.5,Iris-virginica\n" +
                "6.9,3.2,5.7,2.3,Iris-virginica\n" +
                "5.6,2.8,4.9,2.0,Iris-virginica\n" +
                "7.7,2.8,6.7,2.0,Iris-virginica\n" +
                "6.3,2.7,4.9,1.8,Iris-virginica\n" +
                "6.7,3.3,5.7,2.1,Iris-virginica\n" +
                "7.2,3.2,6.0,1.8,Iris-virginica\n" +
                "6.2,2.8,4.8,1.8,Iris-virginica\n" +
                "6.1,3.0,4.9,1.8,Iris-virginica\n" +
                "6.4,2.8,5.6,2.1,Iris-virginica\n" +
                "7.2,3.0,5.8,1.6,Iris-virginica\n" +
                "7.4,2.8,6.1,1.9,Iris-virginica\n" +
                "7.9,3.8,6.4,2.0,Iris-virginica\n" +
                "6.4,2.8,5.6,2.2,Iris-virginica\n" +
                "6.3,2.8,5.1,1.5,Iris-virginica\n" +
                "6.1,2.6,5.6,1.4,Iris-virginica\n" +
                "7.7,3.0,6.1,2.3,Iris-virginica\n" +
                "6.3,3.4,5.6,2.4,Iris-virginica\n" +
                "6.4,3.1,5.5,1.8,Iris-virginica\n" +
                "6.0,3.0,4.8,1.8,Iris-virginica\n" +
                "6.9,3.1,5.4,2.1,Iris-virginica\n" +
                "6.7,3.1,5.6,2.4,Iris-virginica\n" +
                "6.9,3.1,5.1,2.3,Iris-virginica\n" +
                "5.8,2.7,5.1,1.9,Iris-virginica\n" +
                "6.8,3.2,5.9,2.3,Iris-virginica\n" +
                "6.7,3.3,5.7,2.5,Iris-virginica\n" +
                "6.7,3.0,5.2,2.3,Iris-virginica\n" +
                "6.3,2.5,5.0,1.9,Iris-virginica\n" +
                "6.5,3.0,5.2,2.0,Iris-virginica\n" +
                "6.2,3.4,5.4,2.3,Iris-virginica\n" +
                "5.9,3.0,5.1,1.8,Iris-virginica\n" +
                "\n";

        testText.setText(text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

}
