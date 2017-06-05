package com.unicorn.easygo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/10/8 0008.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        // TODO Auto-generated constructor stub
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return mFragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mFragments.size();
    }

}
//public class MyPagerAdapter extends PagerAdapter {
//    private ArrayList<View> viewLists;
//
//    public MyPagerAdapter() {
//    }
//
//    public MyPagerAdapter(ArrayList<View> viewLists) {
//        super();
//        this.viewLists = viewLists;
//    }
//
//    @Override
//    public int getCount() {
//        return viewLists.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        container.addView(viewLists.get(position));
//        return viewLists.get(position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewLists.get(position));
//    }
//}
