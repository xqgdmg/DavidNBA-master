package com.yuyh.sprintnba.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.library.utils.DimenUtils;
import com.yuyh.library.utils.log.LogUtils;
import com.yuyh.sprintnba.R;
import com.yuyh.sprintnba.retrofit.api.RequestCallback;
import com.yuyh.sprintnba.retrofit.api.tencent.TencentService;
import com.yuyh.sprintnba.retrofit.bean.news.NewsItem;
import com.yuyh.sprintnba.retrofit.bean.news.VideoRealUrl;
import com.yuyh.sprintnba.support.NoDoubleClickListener;
import com.yuyh.sprintnba.support.OnListItemClickListener;
import com.yuyh.sprintnba.utils.FrescoUtils;
import com.yuyh.sprintnba.utils.ItemAnimHelper;
import com.zengcanxiang.baseAdapter.recyclerView.HelperAdapter;
import com.zengcanxiang.baseAdapter.recyclerView.HelperViewHolder;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Kyrie.Y on 2016/6/6.
 * 1.不带视频
 * 2.带视频
 */
public class NewsAdapter extends HelperAdapter<NewsItem.NewsItemBean> {

    private OnListItemClickListener mOnItemClickListener = null;
    private ItemAnimHelper helper = new ItemAnimHelper();

    /**
     * @param data     数据源
     * @param context  上下文
     * @param layoutId 布局Id
     */
    public NewsAdapter(List<NewsItem.NewsItemBean> data, Context context, int... layoutId) {
        super(data, context, layoutId);
    }

    @Override
    protected void HelperBindData(final HelperViewHolder viewHolder, final int position, final NewsItem.NewsItemBean item) {

        if (item.atype.equals("2")) { // 视频
            final JCVideoPlayerStandard videoPlayer = viewHolder.getView(R.id.vpVideo); // viewHolder.getView 是第三方库
            if (TextUtils.isEmpty(item.realUrl)) { // 存放腾讯视频真实地址为空
                videoPlayer.setUp("", item.title);
                 // 重新获取地址，拼接地址
                TencentService.getVideoRealUrl(item.vid, new RequestCallback<VideoRealUrl>() {
                    @Override
                    public void onSuccess(VideoRealUrl real) {
                        String vid = TextUtils.isEmpty(real.fn) ? real.vid + ".mp4" : real.fn;
                        String url = real.url + vid + "?vkey=" + real.fvkey;
                        item.realUrl = url;
                        LogUtils.i("title：" + item.title);
                        LogUtils.i("real-url：" + url);
                        videoPlayer.setUp(url, item.title);
                    }

                    @Override
                    public void onFailure(String message) {
                        LogUtils.i("real-url：" + message);
                    }
                });
            } else {
                videoPlayer.setUp(item.realUrl, item.title); // 有实际地址，直接设置
            }

             // 节操播放器设置控制
            videoPlayer.thumbImageView.setController(FrescoUtils.getController(item.imgurl, videoPlayer.thumbImageView));
             // 设置包体和日期
            viewHolder.setText(R.id.tvVideoTitle, item.title).setText(R.id.tvVideoTime, item.pub_time);
            ViewGroup.LayoutParams params = videoPlayer.getLayoutParams();
            params.height = DimenUtils.getScreenWidth() / 2;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            videoPlayer.setLayoutParams(params); // 设置布局参数
        } else { // 图文
            SimpleDraweeView iv = viewHolder.getView(R.id.ivBannerImg);
            if (iv != null) { // @bugreport NullPointerException
                iv.setController(FrescoUtils.getController(item.imgurl, iv));
                ViewGroup.LayoutParams params = iv.getLayoutParams();
                params.height = DimenUtils.getScreenWidth() / 2;
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                iv.setLayoutParams(params);
            }
            viewHolder.setText(R.id.tvBannerTitle, item.title)
                    .setText(R.id.tvBannerTime, item.pub_time);

            viewHolder.getItemView().setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View view) {
                    if (mOnItemClickListener != null)
                        mOnItemClickListener.onItemClick(viewHolder.getItemView(), position, item);
                }
            });
        }
        helper.showItemAnim(viewHolder.getItemView(), position);
    }

    public void setOnItemClickListener(OnListItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public int checkLayoutIndex(NewsItem.NewsItemBean item, int position) {
        if (item.atype.equals("2"))
            return 1;
        return 0;
    }
}
