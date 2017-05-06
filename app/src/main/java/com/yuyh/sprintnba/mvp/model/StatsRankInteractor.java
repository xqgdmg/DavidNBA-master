
package com.yuyh.sprintnba.mvp.model;

import com.yuyh.sprintnba.app.Constant;

import java.util.Map;

public interface StatsRankInteractor {

    Map<String, Constant.TabType> getTabs();

    Map<String, Constant.StatType> getStats();
}
