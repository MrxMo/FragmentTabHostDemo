package com.mr_mo.fragmenttabhostdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr_mo.fragmenttabhostdemo.R;

/**
 * 尾页
 * Created by moguangjian on 15/8/11 13:47.
 */
public class EndFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_end, container, false);

        return rootView;
    }

}
