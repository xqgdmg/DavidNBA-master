
package com.yuyh.sprintnba.ui.Interactor;

import com.yuyh.sprintnba.retrofit.bean.news.NewsDetail;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;

public interface NBANewsDetailInteractor {

    void getNewsDetail(String arcId, RequestCallback<NewsDetail> callback);
}
