package com.yuyh.sprintnba.mvp.view;

import com.yuyh.sprintnba.retrofit.bean.forum.ForumsData;
import com.yuyh.sprintnba.retrofit.bean.forum.ThreadListData;
import com.yuyh.sprintnba.mvp.view.base.BaseView;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/6/25.
 */
public interface ThreadListView extends BaseView {

    void onScrollToTop();

    void showThreadList(List<ThreadListData.ThreadInfo> forumInfoList, boolean isRefresh);

    void showThreadInfo(ForumsData.Forum forum);

    void onFloatingVisibility(int visibility);

    void onLoadCompleted(boolean hasMore);

    void onRefreshCompleted();

}
