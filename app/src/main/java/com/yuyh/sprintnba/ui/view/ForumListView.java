package com.yuyh.sprintnba.ui.view;

import com.yuyh.sprintnba.retrofit.bean.forum.ForumsData;
import com.yuyh.sprintnba.ui.view.base.BaseView;

import java.util.List;

/**
 *
 */
public interface ForumListView extends BaseView{

    void showForumList(List<ForumsData.Forum> forumList);
}
