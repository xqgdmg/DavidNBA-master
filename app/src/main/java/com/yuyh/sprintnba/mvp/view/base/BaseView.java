package com.yuyh.sprintnba.mvp.view.base;

/*
 * 加载中，加载完成，加载错误
 */
public interface BaseView {

    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show error message
     */
    void showError(String msg);

}
