package com.zhanh.utilslibrary.base;

import android.content.Context;


/**
 * 获得全局上下文环境
 */
public class BaseAppContext {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }
    public static Context getInstance() {
        if (mContext == null) {
            throw new NullPointerException("the context is null,please init AppContextUtil in Application first.");
        }
        return mContext;
    }



}
