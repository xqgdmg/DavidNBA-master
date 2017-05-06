package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.base.BaseLazyFragment;
import com.yuyh.sprintnba.utils.NavigationEntity;

import java.util.List;

/*
 * 视图，初始化视图的功能
 */
public interface HomeView {

    void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList);

}
