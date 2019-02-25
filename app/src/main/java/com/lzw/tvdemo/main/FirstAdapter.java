package com.lzw.tvdemo.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzw.tvdemo.R;
import com.lzw.tvdemo.base.BaseRecyclerAdapter;

/**
 * @author: lzw
 * @date: 2018/1/12 上午10:15
 * @desc:
 */

public class FirstAdapter extends BaseRecyclerAdapter<String, FirstAdapter.MyViewHolder> {

    private FirstClick firstClick;

    private int width;

    public void setFirstClick(FirstClick firstClick) {
        this.firstClick = firstClick;
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_first;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    protected MyViewHolder onCreateItemViewHolder(View view) {
        return new MyViewHolder(view);
    }


    @Override
    protected void onBindItemViewHolder(final MyViewHolder holder, final String data, final int position) {
        holder.textView.setText(data);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.itemView.getScaleX() != 1f || holder.itemView.getScaleY() != 1f) {
                    firstClick.itemOtherClick(position);
                } else {
                    firstClick.itemClick(position, data);
                }
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;

        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            textView = itemView.findViewById(R.id.first_text);
        }
    }

    public interface FirstClick {
        void itemClick(int pos, String data);

        void itemOtherClick(int pos);
    }
}
