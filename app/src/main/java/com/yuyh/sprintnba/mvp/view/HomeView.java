package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.base.BaseLazyFragment;
import com.yuyh.sprintnba.utils.NavigationEntity;

import java.util.List;

public interface HomeView {

    void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList);

}
