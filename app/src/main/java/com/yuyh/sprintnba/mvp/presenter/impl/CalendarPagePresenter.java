package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;

import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.match.MatchCalendar;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.CalendarPageView;

/**
 * @author yuyh.
 * @date 2016/7/25.
 */
public class CalendarPagePresenter implements Presenter {

    private Context context;
    private CalendarPageView view;

    public CalendarPagePresenter(Context context, CalendarPageView view) {
        this.view = view;
    }

    @Override
    public void initialized() {

    }

    public void getMatchCount(int year, int month) {
        view.showLoadding();
        TencentService.getMatchCalendar(-1, year, month, false, new RequestCallback<MatchCalendar>() {
            @Override
            public void onSuccess(MatchCalendar matchCalendar) {
                if (matchCalendar != null && matchCalendar.data != null)
                    view.renderMatchCount(matchCalendar.data.matchNum);
                view.hideLoadding();
            }

            @Override
            public void onFailure(String message) {
                view.hideLoadding();
            }
        });
    }
}
