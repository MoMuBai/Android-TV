package com.lzw.tvdemo.main;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.lzw.tvdemo.R;
import com.lzw.tvdemo.base.BaseListAdapter;

/**
 * @author: lzw
 * @date: 2018/1/12 上午9:53
 * @desc:
 */

public class SecondAdapter extends BaseListAdapter<String, SecondAdapter.MyViewHolder> {
    public SecondAdapter(Context context) {
        super(context);
    }


    @Override
    protected int getLayout() {
        return R.layout.item_second;
    }

    @Override
    protected MyViewHolder onCreateViewHolder(View view) {
        return new MyViewHolder(view);
    }

    @Override
    protected void onBindData(MyViewHolder viewHolder, String data, int position) {
        viewHolder.textView.setText(data);
    }

    protected class MyViewHolder extends BaseListAdapter.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.second_text);
        }
    }
}
