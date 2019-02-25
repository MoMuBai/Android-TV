package com.lzw.tv.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzw.tv.MyApp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lzw
 * @date: 2018/1/12 上午9:40
 * @desc:
 */

public abstract class BaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter {

    protected List<T> mData;
    protected Context mContext;
    protected LayoutInflater inflater;

    public BaseRecyclerAdapter() {
        mData = new ArrayList<>();
        mContext = MyApp.getContext();
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(getItemLayout(), parent, false);
        return onCreateItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindItemViewHolder((VH) holder,mData.get(position), position);
    }

    protected abstract int getItemLayout();

    protected abstract VH onCreateItemViewHolder(View view);

    protected VH onCreateItemViewHolder(ViewGroup view, int viewType) {
        return null;
    }

    protected abstract void onBindItemViewHolder(VH holder, T data,int position);


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addRefresh(List<T> mData) {
        if (null == this.mData) {
            this.mData = new ArrayList<>();
        }
        this.mData.clear();
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }

    public void addLoad(List<T> mData) {
        if (null == this.mData) {
            this.mData = new ArrayList<>();
        }
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }
}
