
package com.yuyh.sprintnba.mvp.model;

import com.yuyh.sprintnba.retrofit.bean.player.Players;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface PlayersListBiz {

    void getAllPlayers(RequestCallback<Players> callback);
}
