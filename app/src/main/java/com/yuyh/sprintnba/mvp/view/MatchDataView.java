package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.match.MatchStat;
import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/7/2.
 */
public interface MatchDataView extends BaseView {

    void showMatchPoint(List<MatchStat.MatchStatInfo.StatsBean.Goals> list, MatchStat.MatchStatInfo.MatchTeamInfo teamInfo);

    void showTeamStatistics(List<MatchStat.MatchStatInfo.StatsBean.TeamStats> teamStats);
}
