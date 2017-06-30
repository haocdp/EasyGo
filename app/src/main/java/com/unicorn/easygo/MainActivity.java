package com.unicorn.easygo;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps.model.Text;
import com.unicorn.easygo.activity.ConfirmOrderActivity;
import com.unicorn.easygo.activity.CouponActivity;
import com.unicorn.easygo.activity.HistoryActivity;
import com.unicorn.easygo.activity.BaseActivity;
import com.unicorn.easygo.activity.LoginActivity;
import com.unicorn.easygo.activity.MarketRecommendActivity;
import com.unicorn.easygo.activity.MessageActivity;
import com.unicorn.easygo.activity.OrderActivity;
import com.unicorn.easygo.activity.PersonalInfoActivity;
import com.unicorn.easygo.activity.WalletActivity;
import com.unicorn.easygo.db.MyDBOpenHelper;
import com.unicorn.easygo.db.accountDBdao;
import com.unicorn.easygo.db.goodDBdao;
import com.unicorn.easygo.db.scanRecordDBdao;
import com.unicorn.easygo.db.shoppingCartDBdao;
import com.unicorn.easygo.db.testDBdao;
import com.unicorn.easygo.db.userDBdao;
import com.unicorn.easygo.entity.UserProfile;
import com.unicorn.easygo.utils.FontUtil;
import com.unicorn.easygo.zxing.android.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private final static String PREORDER_FRAGMENT_TAG = "preOederFragment";
    private final static String SCANRECORD_FRAGMENT_TAG = "scanRecordFragment";
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private Intent intent;
    private String name;//账号

    private static final int REQUEST_CODE_SCAN = 0x0000;

    private View preOrderView, scanRecordView;
    //private ViewPager viewPager;
    private List<View> viewList;
    //private ImageView img_cursor;
    private TextView tv_one;
    private TextView tv_two;
    private TextView appName;

    private LinearLayout ll_shoppingCart;
    private TextView tv_shoppingCart_text;
    private TextView tv_shoppingCart_no;

    private TextView tv_market_name;

    /**
     * fragment管理
     */
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment mCurrentFragment;


    //超市推荐按钮
    private ImageButton marketRecommendView;
    //我的按钮
    private ImageButton personal;
    //左边滑动窗口（我的）
    private DrawerLayout mDrawerLayout;
    //扫一扫
    private ImageButton scanButton;
    private ImageView iv_shoppingCart;
    //个人信息编辑按钮
    private Button edit;
    //用户头像
    private CircleImageView userimage;
    //用户名
    private TextView username;

    private ArrayList<View> listViews;
    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面的编号
    private int bmpWidth;// 移动条图片的长度
    private int one = 0; //移动条滑动一页的距离
    private MyDBOpenHelper dbHelper;
    //private EGOApplication eAPP;
    private UserProfile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        initFragment();
        setFonts();
        intent = this.getIntent();
        //name = intent.getStringExtra("name");// 接收登录界面的数据
        name = EGOApplication.getInstance().getUserProfile().getUsername();
        Log.i("MainActivity",name);
        //设置共享变量
        //eAPP = (EGOApplication)getApplication();
        //userProfile = new UserProfile();
        //userProfile.setUsername(name);
        //eAPP.setUserProfile(userProfile);
        //String publicname = userProfile.getUsername();
        Log.i("publicname:",name);
        if (name == null || "".equals(name)) {
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            //对用户名进行赋值
            username.setText(name);
        }

        /**
         * 必须扫描购物车后才显示购物车编号
         */
        if (EGOApplication.getInstance().hasBundCart()) {
            ll_shoppingCart.setVisibility(View.VISIBLE);
            tv_shoppingCart_no.setText(EGOApplication.getInstance().getShoppingCartNo());
        } else {
            ll_shoppingCart.setVisibility(View.GONE);
            tv_shoppingCart_no.setText(EGOApplication.getInstance().getShoppingCartNo());
        }

        /**
         * 当有商品加入订单后才显示结账按钮
         */
        if (EGOApplication.getInstance().getGoodsIdList().size() == 0) {
            iv_shoppingCart.setVisibility(View.INVISIBLE);
        } else {
            iv_shoppingCart.setVisibility(View.VISIBLE);
        }

        /**
         * 设置超市名称
         */
        tv_market_name.setText(EGOApplication.getInstance().getMarketName());
    }

    private void initViews() {
        //左边滑动窗口（我的）
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        //viewPager = (ViewPager) findViewById(R.id.viewpager);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        appName = (TextView) findViewById(R.id.textView_appName);
        //img_cursor = (ImageView) findViewById(R.id.img_cursor);
        //CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        marketRecommendView = (ImageButton) findViewById(R.id.marketRecommend);
        personal = (ImageButton)findViewById(R.id.personal);
        scanButton = (ImageButton)findViewById(R.id.scanButton);
        iv_shoppingCart = (ImageView) findViewById(R.id.shoppingCart);

        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_order);//默认选中我的订单选项
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                switch(item.getItemId()){
                    case R.id.nav_order:
                        Intent intent_order = new Intent(MainActivity.this,OrderActivity.class);
                        startActivity(intent_order);
                        break;
                    case R.id.nav_wallet:
                        Intent intent_wallet = new Intent(MainActivity.this,WalletActivity.class);
                        //intent_wallet.putExtra("login_name",name);
                        startActivity(intent_wallet);
                        break;
                    case R.id.nav_history:
                        Intent intent_history = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intent_history);
                        break;
                    case R.id.nav_coupon:
                        Intent intent_coupon = new Intent(MainActivity.this,CouponActivity.class);
                        startActivity(intent_coupon);
                        break;
                    case R.id.nav_message:
                        Intent intent_message = new Intent(MainActivity.this,MessageActivity.class);
                        startActivity(intent_message);
                        break;
                }
                return true;
            }
        });
        View headerView = navView.getHeaderView(0);
        //用户头像
        userimage=(CircleImageView)headerView.findViewById(R.id.user_image);
        //用户名
        username=(TextView)headerView.findViewById(R.id.username);
        //编辑
        edit = (Button)headerView.findViewById(R.id.edit);


        //下划线动画的相关设置：
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.line).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 2 - bmpWidth) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        //img_cursor.setImageMatrix(matrix);// 设置动画初始位置
        //移动的距离
        one = offset * 2 + bmpWidth;// 移动一页的偏移量,比如1->2,或者2->3

        /**
         * 构造适配器
         */
        //List<Fragment> fragments = new ArrayList<Fragment>();
        //fragments.add(new Fragment1());
        //fragments.add(new Fragment2());
        //MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);

        //设定适配器
        //viewPager.setAdapter(adapter);

        //往ViewPager填充View，同时设置点击事件与页面切换事件
        //viewPager.setCurrentItem(0);          //设置ViewPager当前页，从0开始算
        //indicator.setViewPager(viewPager);
        tv_one.setOnClickListener(this);
        tv_two.setOnClickListener(this);
        marketRecommendView.setOnClickListener(this);
        personal.setOnClickListener(this);
        scanButton.setOnClickListener(this);

        /**
         * 购物车按钮
         */
        iv_shoppingCart.setOnClickListener(this);

        edit.setOnClickListener(this);
        //userimage.setOnClickListener(this);


        ll_shoppingCart = (LinearLayout) findViewById(R.id.ll_shoppingCart);
        tv_shoppingCart_text = (TextView) findViewById(R.id.tvShoppingCartNoPre);
        tv_shoppingCart_no = (TextView) findViewById(R.id.tvShoppingCartNo);

        tv_market_name = (TextView) findViewById(R.id.tvSelectMarket);

        //viewPager.addOnPageChangeListener(this);
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        PreOrderFragment preOrderFragment = new PreOrderFragment();
        ScanRecordFragment scanRecordFragment = new ScanRecordFragment();

        fragmentTransaction.add(R.id.main_frame, preOrderFragment, PREORDER_FRAGMENT_TAG)
                .add(R.id.main_frame, scanRecordFragment, SCANRECORD_FRAGMENT_TAG)
                .hide(scanRecordFragment)
                .commit();

        mCurrentFragment = preOrderFragment;
    }


    /**
     * 设置页面字体
     */
    private void setFonts() {
        FontUtil.setFont(appName, this.getAssets(), 0);
        FontUtil.setFont(tv_one, this.getAssets(), 0);
        FontUtil.setFont(tv_two, this.getAssets(), 0);
        FontUtil.setFont(tv_shoppingCart_text, this.getAssets(), 0);
        FontUtil.setFont(tv_shoppingCart_no, this.getAssets(), 0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one:
                //viewPager.setCurrentItem(0);
                tv_one.setBackground(
                        getResources().getDrawable(R.mipmap.mainpage_title_icon,
                                null));
                tv_two.setBackground(
                        getResources().getDrawable(R.mipmap.mainpage_title_unselect_icon,
                                null));
                switchFragment(SCANRECORD_FRAGMENT_TAG, PREORDER_FRAGMENT_TAG);
                break;
            case R.id.tv_two:
                //viewPager.setCurrentItem(1);
                tv_two.setBackground(
                        getResources().getDrawable(R.mipmap.mainpage_title_icon,
                                null));
                tv_one.setBackground(
                        getResources().getDrawable(R.mipmap.mainpage_title_unselect_icon,
                                null));
                switchFragment(PREORDER_FRAGMENT_TAG, SCANRECORD_FRAGMENT_TAG);
                break;
            case R.id.marketRecommend:
                Intent intent = new Intent(this, MarketRecommendActivity.class);
                this.startActivity(intent);
                break;
            case R.id.personal:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.user_image:
                break;
            case R.id.edit:
                Intent edit_intent = new Intent(this,PersonalInfoActivity.class);
                this.startActivity(edit_intent);
                break;
            case R.id.scanButton:
                Intent scan_intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivity(scan_intent);
                break;

            case R.id.shoppingCart:
                Intent confirmOrder_intent = new Intent(this, ConfirmOrderActivity.class);
                startActivity(confirmOrder_intent);
                break;
            default:
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
        ///img_cursor.startAnimation(animation);//开始动画
    }

    public void onPageScrollStateChanged(int i) {

    }

    public void onPageScrolled(int i, float v, int i1) {

    }

    /**
     * 主activity进行控制不同的fragment
     *
     * @param fromTag
     * @param toTag
     */
    public void switchFragment(String fromTag, String toTag) {
        Fragment from = fragmentManager.findFragmentByTag(fromTag);
        Fragment to = fragmentManager.findFragmentByTag(toTag);
        if (mCurrentFragment != to) {
            mCurrentFragment = to;
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {//判断是否被添加到了Activity里面去了
                transaction.hide(from).add(R.id.main_frame, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (EGOApplication.getInstance().hasBundCart()) {
            ll_shoppingCart.setVisibility(View.VISIBLE);
            tv_shoppingCart_no.setText(EGOApplication.getInstance().getShoppingCartNo());
        } else {
            ll_shoppingCart.setVisibility(View.GONE);
            tv_shoppingCart_no.setText(EGOApplication.getInstance().getShoppingCartNo());
        }

        /**
         * 当有商品加入订单后才显示结账按钮
         */
        if (EGOApplication.getInstance().getGoodsIdList().size() == 0) {
            iv_shoppingCart.setVisibility(View.INVISIBLE);
        } else {
            iv_shoppingCart.setVisibility(View.VISIBLE);
        }
    }


}
