package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.NBANewsDetailBiz;
import com.yuyh.sprintnba.mvp.model.impl.NBANewsDetailBizImp;
import com.yuyh.sprintnba.retrofit.bean.news.NewsDetail;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.mvp.presenter.NewsDetailPresenter;
import com.yuyh.sprintnba.mvp.view.NewsDetailView;

/**
 * @author yuyh.
 * @date 16/6/7.
 */
public class NewsDetailPresenterImpl implements NewsDetailPresenter {

    private Context mContext = null;
    private NewsDetailView mNewsView = null;
    private NBANewsDetailBiz mNewsDetailInteractor = null;

    public NewsDetailPresenterImpl(Context context, @NonNull NewsDetailView mNewsView) {

        mContext = context;
        this.mNewsView = mNewsView;
        mNewsDetailInteractor = new NBANewsDetailBizImp();
    }

    @Override
    public void initialized(String arcId) {
        mNewsDetailInteractor.getNewsDetail(arcId, new RequestCallback<NewsDetail>() {
            @Override
            public void onSuccess(NewsDetail newsDetail) {
                mNewsView.showNewsDetail(newsDetail);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
