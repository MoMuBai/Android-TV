package com.lzw.tv.fragment.video;

import android.support.annotation.NonNull;
import android.view.View;

import com.lzw.tv.R;
import com.lzw.tv.base.BaseFragment;

/**
 * @author: lzw
 * @date: 2018/1/16 下午4:28
 * @desc:
 */

public class VideoFragment extends BaseFragment {

//    private JCVideoPlayerStandard playerStandard;
    @Override
    protected int getLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(@NonNull View view) {
//        playerStandard = view.findViewById(R.id.videoplayer);
//        playerStandard.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "天黑闭眼睛");
//        playerStandard.startVideo();
    }

}
