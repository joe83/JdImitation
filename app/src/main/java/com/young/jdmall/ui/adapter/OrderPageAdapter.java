package com.young.jdmall.ui.adapter;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.young.jdmall.ui.fragment.CancelOdFragment;
import com.young.jdmall.ui.fragment.NoPayOdFragment;
import com.young.jdmall.ui.fragment.ReceiveOdFragment;
import com.young.jdmall.ui.fragment.TotalOdFragment;

/**
 * Created by 25505 on 2017/8/2.
 */

public class OrderPageAdapter extends FragmentPagerAdapter {
    private static final int TOTAL = 0;
    private static final int NOPAY = 1;
    private static final int RECEIVE = 2;
    private static final int CANCELOD = 3;
    private String[] titles = {"全部","近一个月","一个月前","已取消"};
    public OrderPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TOTAL:
               return new TotalOdFragment();
            case NOPAY:
                return new NoPayOdFragment();
            case RECEIVE:
                return new ReceiveOdFragment();

            case CANCELOD:
                return new CancelOdFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }


}
