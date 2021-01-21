package com.zhanh.utilslibrary.util;

import android.content.Context;

import com.zhanh.utilslibrary.base.BaseAppContext;

public class ResUtils {
    private ResUtils() {
    }

    /**
     * 根据图片名称获取图片的资源id的方法
     *
     * @return id
     */
    public static int getImageRes(String imageName) {
        Context ctx = BaseAppContext.getInstance();
        return ctx.getResources().getIdentifier(imageName, "drawable", ctx.getPackageName());
    }
}