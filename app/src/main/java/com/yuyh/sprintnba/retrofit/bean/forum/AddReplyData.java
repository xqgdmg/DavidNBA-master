package com.yuyh.sprintnba.retrofit.bean.forum;

import com.yuyh.sprintnba.retrofit.bean.base.BaseError;

import java.io.Serializable;

/**
 * @author yuyh.
 * @date 2016/6/27.
 */
public class AddReplyData implements Serializable {
    public int status;
    public AddReplyResult result;
    public BaseError error;

    public static class AddReplyResult implements Serializable {
        int pid;
        String content;
        String viainfo;
        String postdate;
    }
}
