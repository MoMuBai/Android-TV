package com.lzw.tvdemo.fragment.house;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.lzw.tvdemo.main.FirstAdapter;
import com.lzw.tvdemo.R;
import com.lzw.tvdemo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lzw
 * @date: 2018/1/16 下午4:26
 * @desc:
 */

public class HouseFragment extends BaseFragment {
    private GridView gridView;

    private LinearLayout contentLayout;

    private HouseAdapter houseAdapter;

    private RecyclerView recyclerView;

    private LinearLayout detailLayout;

    private FirstAdapter firstAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected int getLayout() {
        return R.layout.fragment_house;
    }

    @Override
    protected void initView(@NonNull View view) {
        gridView = view.findViewById(R.id.grid_view);
        contentLayout = view.findViewById(R.id.content_layout);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh);
    }

    @Override
    protected void initData() {
        houseAdapter = new HouseAdapter(mActivity);
        gridView.setAdapter(houseAdapter);
        final List<String> data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("哈哈哈哈哈");
        }
        houseAdapter.addRefresh(data);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contentLayout.setVisibility(View.VISIBLE);
                if (null != contentLayout.getChildAt(0)) {
                    contentLayout.removeAllViews();
                }
                View contentView = LayoutInflater.from(mActivity).inflate(R.layout.house_detail_layout, null);
                detailLayout = contentView.findViewById(R.id.detail_layout);
                recyclerView = contentView.findViewById(R.id.recycler_view);
                contentView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                contentLayout.addView(contentView);
                firstAdapter = new FirstAdapter();
                recyclerView.setAdapter(firstAdapter);
                if (null == recyclerView.getLayoutManager()) {
                    recyclerView.setLayoutManager(layoutManager);
                }
                firstAdapter.addRefresh(data);
                firstAdapter.setFirstClick(new FirstAdapter.FirstClick() {
                    @Override
                    public void itemClick(int pos, String data) {

                    }

                    @Override
                    public void itemOtherClick(int pos) {

                    }
                });
                detailLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contentLayout.setVisibility(View.GONE);
                        contentLayout.removeAllViews();
                        recyclerView.setLayoutManager(null);
                    }
                });
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });
    }
}
