
package com.yuyh.sprintnba.mvp.model;

import com.yuyh.sprintnba.retrofit.bean.player.Players;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface PlayersListInteractor {

    void getAllPlayers(RequestCallback<Players> callback);
}
