package com.mr_mo.fragmenttabhostdemo.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.mr_mo.fragmenttabhostdemo.R;
import com.mr_mo.fragmenttabhostdemo.ui.EndFragment;
import com.mr_mo.fragmenttabhostdemo.ui.IndexFragment;
import com.mr_mo.fragmenttabhostdemo.ui.MiddleFragment;

/**
 * 首页
 * Created by moguangjian on 15/8/11 13:47.
 */
public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabHost;
    private Class fragmentArray[] = {IndexFragment.class, MiddleFragment.class, EndFragment.class};
    private int iconArray[] = {R.drawable.sl_tab_bar_item_index, R.drawable.sl_tab_bar_item_middle, R.drawable.sl_tab_bar_item_end,};
    private String titleArray[] = {"首页", "中页", "尾页"};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabHost();
    }

    private void initTabHost() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.content);

        int count = fragmentArray.length;
        for (int i = 0; i < count; i++) {
            TabSpec tabSpec = tabHost.newTabSpec(titleArray[i]).setIndicator(getTabBarItemView(i));
            tabHost.addTab(tabSpec, fragmentArray[i], null);
        }
    }

    private View getTabBarItemView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.tab_bar_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        imageView.setImageResource(iconArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
        textView.setText(titleArray[index]);
        return view;
    }
}