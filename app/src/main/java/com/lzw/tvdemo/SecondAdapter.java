package com.lzw.tvdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lzw.tvdemo.base.BaseRecyclerAdapter;

/**
 * @author: lzw
 * @date: 2018/1/12 上午9:53
 * @desc:
 */

public class SecondAdapter extends BaseRecyclerAdapter<String, SecondAdapter.MyViewHolder> {
    private SecondClick secondClick;

    public void setSecondClick(SecondClick secondClick) {
        this.secondClick = secondClick;
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_second;
    }

    @Override
    protected MyViewHolder onCreateItemViewHolder(View view) {
        return new MyViewHolder(view);
    }

    @Override
    protected void onBindItemViewHolder(MyViewHolder holder, final String data, final int position) {
        holder.textView.setText(data);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondClick.itemClick(position, data);
            }
        });
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.second_text);
        }
    }

    public interface SecondClick {
        void itemClick(int pos, String data);
    }
}
