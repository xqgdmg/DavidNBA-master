
package com.yuyh.sprintnba.mvp.model;

import com.yuyh.sprintnba.retrofit.bean.news.NewsDetail;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface NBANewsDetailInteractor {

    void getNewsDetail(String arcId, RequestCallback<NewsDetail> callback);
}
