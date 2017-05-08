package com.yuyh.sprintnba.mvp.presenter;

/*
 * Presenter 接口
 * 1.构造传 view
 * 2.model 在构造中 new
 * 3.提供 view 绑定 model 的实现逻辑 ( 具体过程还在 view上展示数据 )
 *
 * 减少了 Activity 的功能，是 act 只具备 view 的功能，controller 的功能转交给 Presenter
 *
 * 实际上就是 Activity 中多写两行
 *      NewsDetailPresenter presenter = new NewsDetailPresenterImpl(this, this);
        presenter.initialized(arcId);

         presenter.initialized 实际上是调用的 Activity 中的初始化方法，只是进行了过渡，转移 controller 所在的类的位置
 */
public interface Presenter {

    void initialized();

}
