package com.mr_mo.fragmenttabhostdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mr_mo.fragmenttabhostdemo.R;

import java.util.List;

/**
 * 列表适配器
 * Created by moguangjian on 15/8/11 15:39.
 */
public class ListAdapter extends BaseAdapter {

    private Context context;
    private List list;

    public ListAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String title = (String) getItem(position);
        viewHolder.tvTitle.setText(title);
        return convertView;
    }

    class ViewHolder {
        public TextView tvTitle;
    }
}
