package com.yuyh.sprintnba.support;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.yuyh.library.utils.log.LogUtils;

/**
 * 设置 emptyView
 * 设置 adapter
 *
 * 自定义 RecyclerView
 */
public class SupportRecyclerView extends RecyclerView {
    private View emptyView;

     // RecyclerView 中的 adapter 数据变化的观察者
    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            LogUtils.i("smy", "adapter changed");
            Adapter adapter = getAdapter(); // RecyclerView getAdapter()
            if (adapter != null && emptyView != null) {
                if (adapter.getItemCount() == 0) {  // 数据为空
                    LogUtils.i("adapter visible");
                    emptyView.setVisibility(View.VISIBLE);
                    SupportRecyclerView.this.setVisibility(View.GONE); // 把 RecyclerView 消失
                } else {
                    LogUtils.i("adapter gone");
                    emptyView.setVisibility(View.GONE);
                    SupportRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }

        }
    };

    public SupportRecyclerView(Context context) {
        super(context);
    }

    public SupportRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SupportRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /*
     * 设置适配器，先移除原来的 adapter 和 数据监听
     */
    public void setAdapter(Adapter adapter) {
        Adapter oldAdapter = getAdapter();
        if (oldAdapter != null && emptyObserver != null) {
            oldAdapter.unregisterAdapterDataObserver(emptyObserver); // 不监听 adapter 的数据变化
        }
        super.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);// 监听 adapter 的数据变化
        }
        emptyObserver.onChanged();
    }

    /**
     * 设置一个空的布局，用 butterKnife 绑定一个布局，直接可以
     */
    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }
}