package com.yuyh.sprintnba.mvp.model.impl;

import com.yuyh.sprintnba.mvp.model.NBANewsDetailInteractor;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.news.NewsDetail;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.app.Constant;

/**
 * @author yuyh.
 * @date 16/6/11.
 */
public class NBANewsDetailInteractorImpl implements NBANewsDetailInteractor {
    @Override
    public void getNewsDetail(String arcId, RequestCallback<NewsDetail> callback) {
        TencentService.getNewsDetail(Constant.NewsType.BANNER, arcId, false, callback);
    }
}
