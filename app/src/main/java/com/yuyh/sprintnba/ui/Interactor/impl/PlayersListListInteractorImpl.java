package com.yuyh.sprintnba.ui.Interactor.impl;

import com.yuyh.sprintnba.ui.Interactor.PlayersListInteractor;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.player.Players;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

/**
 * @author yuyh.
 * @date 16/6/24.
 */
public class PlayersListListInteractorImpl implements PlayersListInteractor {

    @Override
    public void getAllPlayers(RequestCallback<Players> callback) {
        TencentService.getPlayerList(false, callback);
    }
}
