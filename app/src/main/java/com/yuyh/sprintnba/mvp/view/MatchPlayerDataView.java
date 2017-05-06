package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.match.MatchStat;
import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 * @author yuyh.
 * @date 2016/7/5.
 */
public interface MatchPlayerDataView extends BaseView {

    void showPlayerData(List<MatchStat.MatchStatInfo.StatsBean.PlayerStats> playerStatses);
}
