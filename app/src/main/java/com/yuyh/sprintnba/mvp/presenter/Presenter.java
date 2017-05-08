package com.yuyh.sprintnba.mvp.presenter;

/*
 * Presenter 接口
 * 1.构造传 view
 * 2.model 在构造中 new
 * 3.提供 view 绑定 model 的实现逻辑 ( 具体过程还在 view上展示数据 )
 *
 * 减少了 Activity 的功能，是 act 只具备 view 的功能，controller 的功能转交给 Presenter
 */
public interface Presenter {

    void initialized();

}
