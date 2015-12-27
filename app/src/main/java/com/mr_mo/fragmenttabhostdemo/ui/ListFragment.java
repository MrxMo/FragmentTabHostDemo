package com.mr_mo.fragmenttabhostdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mr_mo.fragmenttabhostdemo.R;
import com.mr_mo.fragmenttabhostdemo.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moguangjian on 15/8/11 15:37.
 */
public class ListFragment extends Fragment {

    private ListView listView;
    private List list;
    private ListAdapter adapter;
    private Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.listView);
        list = new ArrayList();
        for (int i = 0; i < 30; i++) {
            list.add("title is "+i);
        }

        adapter = new ListAdapter(activity, list);
        listView.setAdapter(adapter);
    }
}
