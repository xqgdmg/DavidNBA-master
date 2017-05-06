package com.yuyh.sprintnba.mvp.model.impl;

import android.content.Context;

import com.yuyh.sprintnba.mvp.model.HomeBiz;
import com.yuyh.sprintnba.R;
import com.yuyh.sprintnba.base.BaseLazyFragment;
import com.yuyh.sprintnba.utils.NavigationEntity;
import com.yuyh.sprintnba.ui.fragment.ForumListFragment;
import com.yuyh.sprintnba.ui.fragment.NewsFragment;
import com.yuyh.sprintnba.ui.fragment.ScheduleFragment;
import com.yuyh.sprintnba.ui.fragment.StatsRankFragment;
import com.yuyh.sprintnba.ui.fragment.TeamSortFragment;
import com.yuyh.sprintnba.ui.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

/*
 * 首页逻辑，实现类
 * 1.获取 6个 fragment
 * 2.获取导航栏的条目
 */
public class HomeBizImp implements HomeBiz {

    /*
     * 获取 6个 fragment
     */
    @Override
    public List<BaseLazyFragment> getPagerFragments() {
        List<BaseLazyFragment> fragments = new ArrayList<BaseLazyFragment>() {{
            add(new NewsFragment());
            add(new ScheduleFragment());
            add(new TeamSortFragment());
            add(new StatsRankFragment());
            add(new ForumListFragment());
            add(new OtherFragment());
        }};
        return fragments;
    }

    /*
     * 获取导航栏的条目
     */
    @Override
    public List<NavigationEntity> getNavigationList(Context context) {
        List<NavigationEntity> navigationEntities = new ArrayList<NavigationEntity>() {{
            add(new NavigationEntity(R.drawable.ic_news, "NBA头条"));
            add(new NavigationEntity(R.drawable.ic_video, "赛事直播"));
            add(new NavigationEntity(R.drawable.ic_format, "球队战绩"));
            add(new NavigationEntity(R.drawable.ic_format, "数据排行"));
            add(new NavigationEntity(R.drawable.ic_favorite, "虎扑专区"));
            add(new NavigationEntity(R.drawable.ic_other, "其他"));
        }};
        return navigationEntities;
    }
}
