package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.forum.ForumsData;
import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 *
 */
public interface ForumListView extends BaseView{

    void showForumList(List<ForumsData.Forum> forumList);
}
