package com.lzw.tv.fragment.webview;

import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lzw.tv.R;
import com.lzw.tv.base.BaseFragment;

/**
 * @author: lzw
 * @date: 2018/1/16 下午4:27
 * @desc:
 */

public class WebViewFragment extends BaseFragment {

    private WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_webview;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@NonNull View view) {
        webView = view.findViewById(R.id.wev_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //自适应屏幕大小
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);//防止打不开外部的链接
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://www.baidu.com/");
    }
}
