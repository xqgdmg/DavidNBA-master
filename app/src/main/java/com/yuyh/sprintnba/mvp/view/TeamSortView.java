package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.player.TeamsRank;
import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 * @author yuyh.
 * @date 2016/7/5.
 */
public interface TeamSortView extends BaseView {

    void showTeamSort(List<TeamsRank.TeamBean> list);
}
