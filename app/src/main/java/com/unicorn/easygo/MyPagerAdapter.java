package com.unicorn.easygo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;
    public MyPagerAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        mFragments=fragments;
    }
    public Fragment getItem(int arg0){
        return mFragments.get(arg0);
    }
    public int getCount() {
        return mFragments.size();
    }
}
//test