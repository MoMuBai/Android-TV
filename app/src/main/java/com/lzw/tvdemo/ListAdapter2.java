package com.lzw.tvdemo;

import android.content.Context;
import android.view.View;

import com.lzw.tvdemo.base.BaseListAdapter;

/**
 * @author: lzw
 * @date: 2018/1/20 下午3:17
 * @desc:
 */

public class ListAdapter2 extends BaseListAdapter<String, ListAdapter2.MyListViewHolder2> {
    public ListAdapter2(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_list_2;
    }

    @Override
    protected MyListViewHolder2 onCreateViewHolder(View view) {
        return new MyListViewHolder2(view);
    }

    @Override
    protected void onBindData(MyListViewHolder2 viewHolder, String data, int position) {

    }


    public class MyListViewHolder2 extends BaseListAdapter.ViewHolder {

        public MyListViewHolder2(View view) {
            super(view);
        }
    }
}
