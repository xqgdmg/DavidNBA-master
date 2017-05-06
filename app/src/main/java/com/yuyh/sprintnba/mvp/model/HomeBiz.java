
package com.yuyh.sprintnba.mvp.model;

import android.content.Context;

import com.yuyh.sprintnba.base.BaseLazyFragment;
import com.yuyh.sprintnba.utils.NavigationEntity;

import java.util.List;

/*
 * 首页逻辑
 */
public interface HomeBiz {

    List<BaseLazyFragment> getPagerFragments();

    List<NavigationEntity> getNavigationList(Context context);
}
