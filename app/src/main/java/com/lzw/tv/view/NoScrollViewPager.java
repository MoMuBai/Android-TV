package com.lzw.tv.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author: lzw
 * @date: 2018/1/19 下午3:27
 * @desc:
 */

public class NoScrollViewPager extends ViewPager {

    private boolean noScroll;

    public NoScrollViewPager(@NonNull Context context) {
        super(context);
    }

    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(arg0);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll) {
            return false;
        } else {
            return super.onInterceptTouchEvent(arg0);
        }
    }
}
