package com.yuyh.sprintnba.mvp.presenter.impl;

import android.content.Context;

import com.yuyh.sprintnba.retrofit.api.hupu.forum.HupuForumService;
import com.yuyh.sprintnba.retrofit.bean.forum.ForumsData;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.view.ForumListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 为何只看到 view需要干的事情
 */
public class ForumListPresenterImpl implements Presenter {

    private Context context;
    private ForumListView forumListView;

    public ForumListPresenterImpl(Context context, ForumListView forumListView) {
        this.context = context;
        this.forumListView = forumListView;
    }

    @Override
    public void initialized() {
        forumListView.showLoading("");
        HupuForumService.getAllForums(new RequestCallback<ForumsData>() {
            @Override
            public void onSuccess(ForumsData forumsData) {
                List<ForumsData.Forum> list = new ArrayList<>();
                ArrayList<ForumsData.ForumsResult> data = forumsData.data;
                if (data != null && !data.isEmpty()) {
                    for (ForumsData.ForumsResult result : data) {
                        if (result.fid.equals("1") || result.fid.equals("232")) { // 目前只加入NBA和CBA
                            ArrayList<ForumsData.Forums> sub = result.sub;
                            for (ForumsData.Forums forums : sub) {
                                ForumsData.Forum forum = new ForumsData.Forum();
                                forum.fid = "0";
                                forum.name = forums.name;
                                list.add(forum);
                                list.addAll(forums.data);
                            }
                            forumListView.showForumList(list);
                        }
                    }
                } else {
                    forumListView.showError("暂无数据");
                }
            }

            @Override
            public void onFailure(String message) {
                forumListView.showError(message);
            }
        });
    }
}
