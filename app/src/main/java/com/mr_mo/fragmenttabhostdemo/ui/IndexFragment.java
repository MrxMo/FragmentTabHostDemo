package com.mr_mo.fragmenttabhostdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr_mo.fragmenttabhostdemo.R;
import com.mr_mo.fragmenttabhostdemo.adapter.IndexVPAdapter;
import com.mr_mo.fragmenttabhostdemo.widget.MDScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by moguangjian on 15/8/11 13:46.
 */
public class IndexFragment extends Fragment {

    private static final String TAG = IndexFragment.class.getSimpleName();

    private MDScrollView scrollView;

    private View PopupView;
    private TextView menuTitleOnePopup;
    private TextView menuTitleTwoPopup;

    private View navBarView;
    private TextView menuTitleOne;
    private TextView menuTitleTwo;

    private ImageView ivIcon;
    private int hideHeight = 0;

    private ViewPager viewPager;
    private IndexVPAdapter adapter;
    private List list;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_index, null);
            initScrollView(rootView);
            initViewPager(rootView);
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void initScrollView(View rootView) {
        navBarView = rootView.findViewById(R.id.navBarView);
        menuTitleOne = (TextView) rootView.findViewById(R.id.menuTitleOne);
        menuTitleTwo = (TextView) rootView.findViewById(R.id.menuTitleTwo);

        PopupView = rootView.findViewById(R.id.PopupView);
        menuTitleOnePopup = (TextView) rootView.findViewById(R.id.menuTitleOnePopup);
        menuTitleTwoPopup = (TextView) rootView.findViewById(R.id.menuTitleTwoPopup);

        ivIcon = (ImageView) rootView.findViewById(R.id.ivIcon);

        scrollView = (MDScrollView) rootView.findViewById(R.id.scrollView);

        menuTitleOne.setSelected(true);
        menuTitleOnePopup.setSelected(true);

        scrollView.setOnScrollListener(new MDScrollView.OnScrollListener() {
            @Override
            public void onScroll(int scrollY) {

                if (scrollY >= hideHeight) {
                    PopupView.setVisibility(View.VISIBLE);
                } else {
                    PopupView.setVisibility(View.INVISIBLE);
                }
            }
        });

        ivIcon.post(new Runnable() {
            @Override
            public void run() {
                hideHeight = ivIcon.getHeight();
            }
        });

        menuTitleOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        menuTitleOnePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        menuTitleTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        menuTitleTwoPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

    }

    private void initViewPager(View rootView) {
        list = new ArrayList();
        list.add(new ListFragment());
        list.add(new ListFragment());

        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        adapter = new IndexVPAdapter(getFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    menuTitleOne.setSelected(true);
                    menuTitleOnePopup.setSelected(true);
                    menuTitleTwo.setSelected(false);
                    menuTitleTwoPopup.setSelected(false);

                } else {
                    menuTitleOne.setSelected(false);
                    menuTitleOnePopup.setSelected(false);
                    menuTitleTwo.setSelected(true);
                    menuTitleTwoPopup.setSelected(true);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
