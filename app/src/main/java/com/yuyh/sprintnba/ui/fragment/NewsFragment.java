package com.yuyh.sprintnba.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.yuyh.sprintnba.R;
import com.yuyh.sprintnba.base.BaseLazyFragment;
import com.yuyh.sprintnba.ui.adapter.VPNewsAdapter;
import com.yuyh.sprintnba.mvp.presenter.Presenter;
import com.yuyh.sprintnba.mvp.presenter.impl.NBANewsPresenterImpl;
import com.yuyh.sprintnba.mvp.view.NewsView;
import com.yuyh.library.utils.DimenUtils;
import com.yuyh.library.view.viewpager.indicator.IndicatorViewPager;
import com.yuyh.library.view.viewpager.indicator.ScrollIndicatorView;
import com.yuyh.library.view.viewpager.indicator.slidebar.DrawableBar;
import com.yuyh.library.view.viewpager.indicator.slidebar.ScrollBar;
import com.yuyh.library.view.viewpager.indicator.transition.OnTransitionTextListener;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Fragment 嵌套 Fragment（ViewPager 带可以滑动的标题）
 * nba 头条
 */
public class NewsFragment extends BaseLazyFragment implements NewsView {


    private IndicatorViewPager indicatorViewPager;
    private ScrollIndicatorView scrollIndicatorView;

    /*
     * 主线流程
     */
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_nba_news);
        
        Presenter presenter = new NBANewsPresenterImpl(mActivity, this);

        presenter.initialized(); // initialized() 实际上是调用 view 的方法 initializeViews 进行 view data binding
    }

    /*
     * 具体实现过程
     */
    @Override
    public void initializeViews(String[] names) {

        scrollIndicatorView = (ScrollIndicatorView) findViewById(R.id.nba_news_indicator);
        scrollIndicatorView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        scrollIndicatorView.setScrollBar(new DrawableBar(mActivity, R.drawable.round_border_white_selector, ScrollBar.Gravity.CENTENT_BACKGROUND) {
            @Override
            public int getHeight(int tabHeight) {
                return tabHeight - DimenUtils.dpToPxInt(12);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - DimenUtils.dpToPxInt(12);
            }
        });
        scrollIndicatorView.setSplitAuto(true);
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(getResources().getColor(R.color.colorPrimary), Color.WHITE));

         // Fragment 里面的 ViewPager （除了滑动标题栏）
        ViewPager viewPager = (ViewPager) findViewById(R.id.nba_news_viewPager);
        viewPager.setOffscreenPageLimit(names.length);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);

        // 这不是普通的 setAdapter，同时设置了两个 adapter
        indicatorViewPager.setAdapter(new VPNewsAdapter(mActivity, names, getChildFragmentManager()));
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mActivity.invalidateOptionsMenu(); // 重新绘制 OptionsMenu
        }
    }

    @Override
    protected void onPauseLazy() {
        super.onPauseLazy();
        JCVideoPlayer.releaseAllVideos(); // 节操视频播放器
    }
}
