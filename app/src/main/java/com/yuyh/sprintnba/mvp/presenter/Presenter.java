package com.yuyh.sprintnba.mvp.presenter;

/*
 * Presenter 接口
 * 1.构造传 view
 * 2.bizimp 在构造中 new
 * 3.initialized 表示 view 绑定 model 的实现过程
 */
public interface Presenter {

    void initialized();

}
