package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.HomeBiz;
import com.yuyh.sprintnba.mvp.model.impl.HomeBizImp;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.HomeView;

/**
 * view 和 model 结合
 * 点击标题之后切换右边的fragment
 * 具体逻辑在 view 中实现
 */
public class HomePresenterImpl implements Presenter {

    private Context mContext = null;
    private HomeView mHomeView = null;
    private HomeBiz homeBizImp = null;

    public HomePresenterImpl(Context context, @NonNull HomeView homeView) {

        mContext = context;
        mHomeView = homeView;
        homeBizImp = new HomeBizImp();
    }

    /*
     * view 调用 model
     */
    @Override
    public void initialized() {
        mHomeView.initializeViews(homeBizImp.getPagerFragments(), homeBizImp.getNavigationList(mContext));
    }
}
