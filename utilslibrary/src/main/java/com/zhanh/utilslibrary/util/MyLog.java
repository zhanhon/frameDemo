package com.zhanh.utilslibrary.util;

import com.orhanobut.logger.Logger;
import com.zhanh.utilslibrary.BuildConfig;

public class MyLog {
    private static final boolean RELEASE_VERSION_FLAG = BuildConfig.LOG_DEBUG;

    public static void d(Object msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.d(msg);
        }
    }
    public static void e(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.e(msg + "");
        }
    }
    public static void w(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.w(msg + "");
        }
    }
    public static void v(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.v(msg + "");
        }
    }
    public static void i(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.i(msg + "");
        }
    }

    public static void wtf(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.wtf(msg + "");
        }
    }

    public static void json(String msg) {
        if (RELEASE_VERSION_FLAG) {
            Logger.json(msg + "");
        }
    }

}
