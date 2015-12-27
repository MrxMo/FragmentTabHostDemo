package com.mr_mo.fragmenttabhostdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 首页viewpager适配器
 * Created by moguangjian on 15/8/11 15:31.
 */
public class IndexVPAdapter extends FragmentStatePagerAdapter {

    private List list;

    public IndexVPAdapter(FragmentManager fm, List list) {
        super(fm);

        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {

        return (Fragment) list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
