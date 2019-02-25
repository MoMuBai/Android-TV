package com.lzw.tvdemo;

import android.app.Application;
import android.content.Context;

/**
 * @author: lzw
 * @date: 2018/1/12 上午9:42
 * @desc:
 */

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }

}
