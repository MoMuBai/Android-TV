package com.lzw.tvdemo;

import android.app.ProgressDialog;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.lzw.tvdemo.fragment.house.HouseFragment;
import com.lzw.tvdemo.fragment.image.ImageFragment;
import com.lzw.tvdemo.fragment.video.VideoFragment;
import com.lzw.tvdemo.fragment.webview.WebViewFragment;
import com.lzw.tvdemo.test.ScaleLayoutManager;
import com.lzw.tvdemo.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView1;

    private SecondAdapter secondAdapter;

    private FirstAdapter firstAdapter;

    private List<String> data;

    private NoScrollViewPager viewPager;

    private List<Fragment> fragments;

    private MyViewPagerAdapter myViewPagerAdapter;

    private ProgressDialog dialog;

    private ListView listView1, listView2, listViewSecond;

    private ListAdapter1 listAdapter1;

    private ListAdapter2 listAdapter2;

    private View maskView;

    private ImageView typeImg, loginImg;

    private PopupWindow popupWindowType, popupWindowLogin;

    private View popViewType, popViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setMessage("加载中");
        showDialog();
        listViewSecond = findViewById(R.id.list_view_second);
        recyclerView1 = findViewById(R.id.recycler_view_first);
        listView1 = findViewById(R.id.list_view_1);
        listView2 = findViewById(R.id.list_view_2);
        viewPager = findViewById(R.id.view_pager);
        maskView = findViewById(R.id.maskView);
        typeImg = findViewById(R.id.type_img);
        loginImg = findViewById(R.id.login_img);
        secondAdapter = new SecondAdapter(this);
        listViewSecond.setAdapter(secondAdapter);
        View view = LayoutInflater.from(this).inflate(R.layout.foot_second_layout, null);
        listViewSecond.addFooterView(view);

        firstAdapter = new FirstAdapter();
        recyclerView1.setAdapter(firstAdapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ScaleLayoutManager scaleLayoutManager = new ScaleLayoutManager.Builder(this, 20).setReverseLayout(false).build();
        scaleLayoutManager.setMoveSpeed(0.8f);
        recyclerView1.setLayoutManager(scaleLayoutManager);
        scaleLayoutManager.setInfinite(true);
//        SnapHelper snapHelperStart = new GravitySnapHelper(Gravity.START);
//        snapHelperStart.attachToRecyclerView(recyclerView1);
        data = new ArrayList<>();
        setData1();
        secondAdapter.addRefresh(getData2("静态图"));
        firstAdapter.addRefresh(data);

        listAdapter1 = new ListAdapter1(this);
        listAdapter2 = new ListAdapter2(this);
        listView1.setAdapter(listAdapter1);
        listView2.setAdapter(listAdapter2);
        firstAdapter.setFirstClick(new FirstAdapter.FirstClick() {
            @Override
            public void itemClick(int pos, String data) {
                showDialog();
                secondAdapter.addRefresh(getData2(data));
                if (data.endsWith("静态图")) {
                    viewPager.setCurrentItem(0, false);
                } else if (data.endsWith("房产信息")) {
                    viewPager.setCurrentItem(3, false);
                } else if (data.endsWith("视频")) {
                    viewPager.setCurrentItem(1, false);
                } else if (data.endsWith("WebView")) {
                    viewPager.setCurrentItem(2, false);
                }
            }

            @Override
            public void itemOtherClick(int pos) {
                showDialog();
                Toast.makeText(MainActivity.this, "特殊第一级", Toast.LENGTH_SHORT).show();
            }
        });
        fragments = new ArrayList<>();
        fragments.add(new ImageFragment());
        fragments.add(new VideoFragment());
        fragments.add(new WebViewFragment());
        fragments.add(new HouseFragment());
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.setOffscreenPageLimit(1);

        listViewSecond.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listAdapter1.addRefresh(MainActivity.this.data);
                listView1.setVisibility(View.VISIBLE);
                maskView.setVisibility(View.VISIBLE);
                listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        listView2.setVisibility(View.VISIBLE);
                        listAdapter2.addRefresh(MainActivity.this.data);
                    }
                });
            }
        });
        maskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView1.setVisibility(View.GONE);
                listView2.setVisibility(View.GONE);
                maskView.setVisibility(View.GONE);
            }
        });

        popViewType = LayoutInflater.from(this).inflate(R.layout.type_pop_view, null);
        popViewLogin = LayoutInflater.from(this).inflate(R.layout.login_pop_view, null);
        popupWindowType = new PopupWindow(popViewType, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindowType.setOutsideTouchable(true);
        popupWindowType.setBackgroundDrawable(new BitmapDrawable());
        typeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowType.showAsDropDown(typeImg);
            }
        });
        popupWindowLogin = new PopupWindow(popViewLogin, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindowLogin.setOutsideTouchable(true);
        popupWindowLogin.setBackgroundDrawable(new BitmapDrawable());
        loginImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindowLogin.showAsDropDown(loginImg);
            }
        });
    }

    private List<String> getData2(String data) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(data);
        }
        return list;
    }

    private void setData1() {
        data.add("静态图");
        data.add("房产信息");
        data.add("视频");
        data.add("WebView");
        data.add("静态图");
        data.add("房产信息");
        data.add("视频");
        data.add("WebView");
        data.add("静态图");
        data.add("房产信息");
        data.add("视频");
    }


    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private void showDialog() {
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                    dialog.cancel();
                }
            }
        }, 2000);
    }
}
