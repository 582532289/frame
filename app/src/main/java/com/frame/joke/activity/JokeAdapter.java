package com.frame.joke.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.frame.R;
import com.frame.joke.model.JokeBean;

import java.util.List;

/**
 * Created by xuning on 17/3/2.
 */

public class JokeAdapter extends BaseAdapter {

    private Context mContext;

    private List<JokeBean> list;

    public JokeAdapter(Context mainActivity, List<JokeBean> list) {
        mContext = mainActivity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(mContext, R.layout.item, null);
            holder = new ViewHolder();
            holder.time = (TextView) view.findViewById(R.id.time);
            holder.desc = (TextView) view.findViewById(R.id.desc);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.time.setText(list.get(i).getUpdatetime());
        holder.desc.setText(list.get(i).getContent());
        return view;
    }

    static class ViewHolder {

        private TextView time;

        private TextView desc;
    }
}
