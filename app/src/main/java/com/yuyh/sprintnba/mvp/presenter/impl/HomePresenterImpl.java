package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.HomeBiz;
import com.yuyh.sprintnba.mvp.model.impl.HomeBizImp;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.HomeView;

/**
 * @author yuyh.
 * @date 16/6/7.
 */
public class HomePresenterImpl implements Presenter {

    private Context mContext = null;
    private HomeView mHomeView = null;
    private HomeBiz mHomeInteractor = null;

    public HomePresenterImpl(Context context, @NonNull HomeView homeView) {

        mContext = context;
        mHomeView = homeView;
        mHomeInteractor = new HomeBizImp();
    }

    @Override
    public void initialized() {
        mHomeView.initializeViews(mHomeInteractor.getPagerFragments(), mHomeInteractor.getNavigationList(mContext));
    }
}
