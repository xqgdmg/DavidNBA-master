package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.player.Players;

import java.util.List;

public interface PlayersView {

    void showAllPlayers(List<Players.Player> bean);
    void failure(String msg);

}
