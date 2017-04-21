
package com.yuyh.sprintnba.ui.Interactor;

import com.yuyh.sprintnba.retrofit.bean.player.Teams;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface TeamsListInteractor {

    void getAllTeams(RequestCallback<Teams> callback);
}
