package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.match.MatchCalendar;

/**
 * @author yuyh.
 * @date 2016/7/25.
 */
public interface CalendarPageView {

    void renderMatchCount(MatchCalendar.MatchCalendarBean.MatchNum matchNum);

    void showLoadding();

    void hideLoadding();

}
