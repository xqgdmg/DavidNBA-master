package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/6/28.
 */
public interface ReportView extends BaseView {

    void showType(List<String> list);

    void reportSuccess();
}
