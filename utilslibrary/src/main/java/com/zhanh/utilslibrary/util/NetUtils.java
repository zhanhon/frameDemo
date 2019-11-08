package com.zhanh.utilslibrary.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zhanh.utilslibrary.base.BaseAppContext;


/**
 *
 *
 */
public class NetUtils {
    /**
     * 用于查看是否有网络
     */
    public static boolean isNetworkConnected() {
            ConnectivityManager mConnectivityManager = (ConnectivityManager)BaseAppContext.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }


}
