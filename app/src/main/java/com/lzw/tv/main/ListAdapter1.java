package com.lzw.tv.main;

import android.content.Context;
import android.view.View;

import com.lzw.tv.R;
import com.lzw.tv.base.BaseListAdapter;

/**
 * @author: lzw
 * @date: 2018/1/20 下午3:17
 * @desc:
 */

public class ListAdapter1 extends BaseListAdapter<String, ListAdapter1.MyListViewHolder1> {
    public ListAdapter1(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_list_1;
    }

    @Override
    protected MyListViewHolder1 onCreateViewHolder(View view) {
        return new MyListViewHolder1(view);
    }

    @Override
    protected void onBindData(MyListViewHolder1 viewHolder, String data, int position) {

    }


   public class MyListViewHolder1 extends BaseListAdapter.ViewHolder {

        public MyListViewHolder1(View view) {
            super(view);
        }
    }
}
