package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.NBANewsInteractor;
import com.yuyh.sprintnba.mvp.model.impl.NBANewsInteractorImpl;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.NewsView;

/**
 * @author yuyh.
 * @date 16/6/7.
 */
public class NBANewsPresenterImpl implements Presenter {

    private Context mContext = null;
    private NewsView mNewsView = null;
    private NBANewsInteractor mNewsInteractor = null;

    public NBANewsPresenterImpl(Context context, @NonNull NewsView newsView) {
        mContext = context;
        mNewsView = newsView;
        mNewsInteractor = new NBANewsInteractorImpl();
    }

    @Override
    public void initialized() {
        mNewsView.initializeViews(mNewsInteractor.getTabs());
    }
}
