package com.lzw.tv.fragment.house;

import android.content.Context;
import android.view.View;

import com.lzw.tv.R;
import com.lzw.tv.base.BaseListAdapter;

/**
 * @author: lzw
 * @date: 2018/1/18 下午3:54
 * @desc:
 */

public class HouseAdapter extends BaseListAdapter<String, HouseAdapter.HouseViewHolder> {

    public HouseAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayout() {
        return R.layout.item_house;
    }

    @Override
    protected HouseViewHolder onCreateViewHolder(View view) {
        return new HouseViewHolder(view);
    }

    @Override
    protected void onBindData(HouseViewHolder viewHolder, String data, int position) {

    }

    protected class HouseViewHolder extends BaseListAdapter.ViewHolder {

        public HouseViewHolder(View view) {
            super(view);
        }
    }
}
