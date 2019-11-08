package com.zhanh.utilslibrary.util;

import android.text.TextUtils;
import android.widget.Toast;

import com.zhanh.utilslibrary.base.BaseAppContext;


/**
 * Toast统一管理类
 */
public class ToastUtils {

    private static Toast toast;
    public static boolean isShow = true;

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }



    /**
     * 短时间显示Toast
     * @param message
     */
    public static void showShort(CharSequence message) {

        if (!TextUtils.isEmpty(message) && BaseAppContext.getInstance() != null && isShow) {

            if (toast == null) {
                toast = Toast.makeText(BaseAppContext.getInstance(),message, Toast.LENGTH_SHORT);
            } else {
                toast.setText(message);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        }
    }

    /**
     * 短时间显示Toast
     * int 类型
     * @param message
     */
    public static void showShort(int message) {
        if (BaseAppContext.getInstance() != null && isShow) {

            if (toast == null) {
                toast = Toast.makeText(BaseAppContext.getInstance(),message, Toast.LENGTH_SHORT);
            } else {
                toast.setText(message);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        }

    }

    /**
     * 长时间显示Toast
     *
     */
    public static void showLong(CharSequence message) {
        if (BaseAppContext.getInstance() != null && isShow) {

            if (toast == null) {
                toast = Toast.makeText(BaseAppContext.getInstance(),message, Toast.LENGTH_LONG);
            } else {
                toast.setText(message);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        }

    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(int message) {
        if (BaseAppContext.getInstance() != null && isShow) {

            if (toast == null) {
                toast = Toast.makeText(BaseAppContext.getInstance(),message, Toast.LENGTH_LONG);
            } else {
                toast.setText(message);
                toast.setDuration(Toast.LENGTH_SHORT);
            }
            toast.show();
        }

    }

    /**
     * 自定义显示Toast时间
     *
     */
    public static void show(CharSequence message, int duration) {
        if (BaseAppContext.getInstance() != null && isShow) {
            Toast.makeText(BaseAppContext.getInstance(), message, duration).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     */
    public static void show(int message, int duration) {
        if (BaseAppContext.getInstance() != null && isShow) {
            Toast.makeText(BaseAppContext.getInstance(), message, duration).show();
        }
    }


}