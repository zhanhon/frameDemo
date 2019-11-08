package com.zhanh.utilslibrary.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.zhanh.utilslibrary.base.BaseAppContext;

public class ScreenUtil {
    public final static String WIDTH = "width";
    public final static String HEIGHT = "height";
    /**
     * px转dp
     */
    public static int pxToDp(float px) {
        DisplayMetrics displayMetrics = BaseAppContext.getInstance().getResources().getDisplayMetrics();
        return (int) ((px / displayMetrics.density) + 0.5f);
    }

    /**
     * dp转px
     * @param dp
     * @return
     */
    public static int dpToPx(float dp) {
        DisplayMetrics displayMetrics = BaseAppContext.getInstance().getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5f);
    }

    /**
     * 获取状态栏高度
     * @return
     */
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = BaseAppContext.getInstance().getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = BaseAppContext.getInstance().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    /**
     *
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }


}
