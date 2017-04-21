package com.yuyh.sprintnba.support;

import android.view.View;

/**
 *  ListView 的 item 点击事件，还是 RecycleView 的 item 点击事件
 */
public interface OnListItemClickListener<T> {
    void onItemClick(View view, int position, T data);
}
