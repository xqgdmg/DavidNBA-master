package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.TeamsListBiz;
import com.yuyh.sprintnba.mvp.model.impl.TeamsListListBizImp;
import com.yuyh.sprintnba.retrofit.bean.player.Teams;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.TeamsView;

/**
 * @author yuyh.
 * @date 16/6/7.
 */
public class TeamsListPresenterImpl implements Presenter {

    private Context mContext = null;
    private TeamsView mTeamsView = null;
    private TeamsListBiz mTeamsListBiz = null;

    public TeamsListPresenterImpl(Context context, @NonNull TeamsView teamsView) {
        mContext = context;
        this.mTeamsView = teamsView;
        mTeamsListBiz = new TeamsListListBizImp();
    }

    @Override
    public void initialized() {
        mTeamsListBiz.getAllTeams(new RequestCallback<Teams>() {
            @Override
            public void onSuccess(Teams teams) {
                mTeamsView.showAllTeams(teams.data);
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
