package com.yuyh.sprintnba.mvp.model.impl;

import com.yuyh.sprintnba.mvp.model.NBANewsBiz;

/*
 * 逻辑只有标题的内容
 */
public class NBANewsBizImp implements NBANewsBiz {

    @Override
    public String[] getTabs() {
        return new String[]{"今日头条", "新闻资讯", "视频集锦", "最佳进球", "赛场花絮"};
    }
}
