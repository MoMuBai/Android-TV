package com.lzw.tvdemo.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lzw
 * @date: 2018/1/18 下午3:54
 * @desc:
 */

public abstract class BaseListAdapter<T, VH extends BaseListAdapter.ViewHolder> extends BaseAdapter {

    private List<T> mData;

    private Context mContext;

    private LayoutInflater inflater;

    public BaseListAdapter(Context context) {
        this.mData = new ArrayList<>();
        this.mContext = context;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        VH viewHolder = null;
        if (view == null) {
            view = inflater.inflate(getLayout(), viewGroup, false);
            viewHolder = onCreateViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (VH) view.getTag();
        }
        T data = mData.get(position);
        onBindData(viewHolder, data, position);
        return view;
    }


    /**
     * 获取Layout
     *
     * @return
     */
    protected abstract int getLayout();


    /**
     * 创建ViewHolder
     *
     * @param view
     * @return
     */
    protected abstract VH onCreateViewHolder(View view);


    /**
     * 数据绑定
     *
     * @param viewHolder
     * @param data
     * @param position
     */
    protected abstract void onBindData(VH viewHolder, T data, int position);


    public class ViewHolder {

        protected View view;

        public ViewHolder(View view) {
            this.view = view;
        }

        public View getView() {
            return view;
        }
    }


    /**
     * 刷新数据
     *
     * @param data
     */
    public void addRefresh(List<T> data) {
        if (null == mData) {
            mData = new ArrayList<>();
        }
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * 加载数据
     *
     * @param data
     */
    public void addLoad(List<T> data) {
        if (null == mData) {
            mData = new ArrayList<>();
        }
        mData.addAll(data);
        notifyDataSetChanged();
    }
}
