package com.unicorn.easygo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.unicorn.easygo.activity.MarketRecommendActivity;
import com.unicorn.easygo.utils.FontUtil;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private View preOrderView, scanRecordView;
    private ViewPager viewPager;
    private List<View> viewList;
    private ImageView img_cursor;
    private TextView tv_one;
    private TextView tv_two;
    private TextView appName;

    //超市推荐按钮
    private ImageButton marketRecommendView;

    private ArrayList<View> listViews;
    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面的编号
    private int bmpWidth;// 移动条图片的长度
    private int one = 0; //移动条滑动一页的距离

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setFonts();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        appName = (TextView) findViewById(R.id.textView_appName);
        img_cursor = (ImageView) findViewById(R.id.img_cursor);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        marketRecommendView  = (ImageButton)findViewById(R.id.marketRecommend);

        //下划线动画的相关设置：
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.line).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 2 - bmpWidth) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        img_cursor.setImageMatrix(matrix);// 设置动画初始位置
        //移动的距离
        one = offset * 2 + bmpWidth;// 移动一页的偏移量,比如1->2,或者2->3

        //构造适配器
        List<Fragment> fragments=new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
        viewPager.setAdapter(adapter);

        //往ViewPager填充View，同时设置点击事件与页面切换事件
        viewPager.setCurrentItem(0);          //设置ViewPager当前页，从0开始算
        indicator.setViewPager(viewPager);
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        marketRecommendView.setOnClickListener(this);


       viewPager.addOnPageChangeListener(this);
    }

    /**
     * 设置页面字体
     */
    private void setFonts(){
        FontUtil.setFont(appName, this, 0);
        FontUtil.setFont(tv_one,this, 0);
        FontUtil.setFont(tv_two, this, 0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_two:
                viewPager.setCurrentItem(1);
                break;
            case R.id.marketRecommend:
                Intent intent = new Intent(this, MarketRecommendActivity.class);
                this.startActivity(intent);
                break;
        }
    }

    public void onPageSelected(int index) {
        Animation animation = null;
        switch (index) {
            case 0:
                    animation = new TranslateAnimation(one, 0, 0, 0);
                break;
            case 1:
                    animation = new TranslateAnimation(offset, one, 0, 0);
                break;
        }
        currIndex = index;
        animation.setFillAfter(true);// true表示图片停在动画结束位置
        animation.setDuration(300); //设置动画时间为300毫秒
        img_cursor.startAnimation(animation);//开始动画
    }

    public void onPageScrollStateChanged(int i) {

    }

    public void onPageScrolled(int i, float v, int i1) {

    }
}
