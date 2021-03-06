package com.yuyh.sprintnba.mvp.model.impl;

import com.yuyh.sprintnba.mvp.model.TeamsListBiz;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.player.Teams;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

/**
 * @author yuyh.
 * @date 16/6/24.
 */
public class TeamsListListBizImp implements TeamsListBiz {

    @Override
    public void getAllTeams(RequestCallback<Teams> callback) {
        TencentService.getTeamList(false, callback);
    }
}
