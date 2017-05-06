
package com.yuyh.sprintnba.mvp.model;

import com.yuyh.sprintnba.retrofit.bean.news.NewsDetail;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface NBANewsDetailBiz {

    void getNewsDetail(String arcId, RequestCallback<NewsDetail> callback);
}
