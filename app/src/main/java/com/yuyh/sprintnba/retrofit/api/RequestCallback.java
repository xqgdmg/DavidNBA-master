package com.yuyh.sprintnba.retrofit.api;

/**
 * @author yuyh.
 * @date 16/6/4.
 *
 * 1.retrofit service 中的回调参数
 * 2.用于获取缓存之后的成功回调
 */
public interface RequestCallback<T> {

    void onSuccess(T t);

    void onFailure(String message);

}
