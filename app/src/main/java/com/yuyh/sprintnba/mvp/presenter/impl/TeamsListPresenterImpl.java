package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;
import android.support.annotation.NonNull;

import com.yuyh.sprintnba.mvp.model.TeamsListInteractor;
import com.yuyh.sprintnba.mvp.model.impl.TeamsListListInteractorImpl;
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
    private TeamsListInteractor mTeamsListInteractor = null;

    public TeamsListPresenterImpl(Context context, @NonNull TeamsView teamsView) {
        mContext = context;
        this.mTeamsView = teamsView;
        mTeamsListInteractor = new TeamsListListInteractorImpl();
    }

    @Override
    public void initialized() {
        mTeamsListInteractor.getAllTeams(new RequestCallback<Teams>() {
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
