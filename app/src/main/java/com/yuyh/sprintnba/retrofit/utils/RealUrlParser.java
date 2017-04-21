package com.yuyh.sprintnba.retrofit.utils;

import com.yuyh.sprintnba.retrofit.bean.news.VideoRealUrl;

import java.io.InputStream;

/**
 * @author yuyh.
 * @date 16/7/1.
 */
public interface RealUrlParser {

    VideoRealUrl parse(InputStream is) throws Exception;
}
