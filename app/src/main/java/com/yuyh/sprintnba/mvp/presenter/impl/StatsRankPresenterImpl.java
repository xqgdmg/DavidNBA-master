package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;

import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.player.StatsRank;
import com.yuyh.sprintnba.app.Constant;
import com.yuyh.sprintnba.mvp.model.StatsRankBiz;
import com.yuyh.sprintnba.mvp.model.impl.StatsRankBizImp;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.StatsRankView;

import java.util.List;

/**
 * @author yuyh.
 * @date 2016/6/22.
 */
public class StatsRankPresenterImpl implements Presenter {

    private Context context;
    private StatsRankView rankView;
    private StatsRankBiz interactor;

    public StatsRankPresenterImpl(Context context, StatsRankView rankView) {
        this.context = context;
        this.rankView = rankView;
        interactor = new StatsRankBizImp();
    }


    @Override
    public void initialized() {
        rankView.showStatsRank(interactor.getTabs(), interactor.getStats());
    }

    public void requestStatsRank(Constant.StatType curStat, Constant.TabType curTab) {
        TencentService.getStatsRank(curStat, 20, curTab, "2015", true, new RequestCallback<StatsRank>() {
            @Override
            public void onSuccess(StatsRank statsRank) {
                List<StatsRank.RankItem> list = statsRank.rankList;
                if (list != null && !list.isEmpty()) {
                    rankView.showStatList(list);
                } else {
                    rankView.showError("暂无数据");
                }
            }

            @Override
            public void onFailure(String message) {
                rankView.showError(message);
            }
        });
    }
}
