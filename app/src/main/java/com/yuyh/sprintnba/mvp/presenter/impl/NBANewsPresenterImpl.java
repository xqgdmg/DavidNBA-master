package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.NBANewsBiz;
import com.yuyh.sprintnba.mvp.model.impl.NBANewsBizImp;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.NewsView;

/**
 * @author yuyh.
 * @date 16/6/7.
 */
public class NBANewsPresenterImpl implements Presenter {

    private Context mContext = null;
    private NewsView mNewsView = null;
    private NBANewsBiz nbaNewsBiz = null;

    public NBANewsPresenterImpl(Context context, @NonNull NewsView newsView) {
        mContext = context;
        mNewsView = newsView;
        nbaNewsBiz = new NBANewsBizImp();
    }

    /*
     * initialized() 实际上是调用 view 的方法 initializeViews 进行 view data binding
     */
    @Override
    public void initialized() {
        mNewsView.initializeViews(nbaNewsBiz.getTabs()); // nbaNewsBiz.getTabs()实际上是调用的 NBANewsBizImp 的方法，返回具体的标题内容
    }
}
