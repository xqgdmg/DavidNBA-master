package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.match.LiveDetail;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/7/2.
 */
public interface MatchLiveView {

    void addList(List<LiveDetail.LiveDetailData.LiveContent> detail, boolean front);

    void showError(String message);
}
