package com.zhanh.utilslibrary.util;

import android.app.Activity;

import com.zhanh.utilslibrary.mvvm.BaseActivity;

import java.util.Stack;

/**
 * Activity管理类：用于Activity管理和应用程序退出
 */
public class AppManager {
    private static Stack<BaseActivity> activityStack;
    private static AppManager instance;

    private AppManager() {
        activityStack = new Stack<>();
    }

    public static AppManager getAppManager() {
        if (instance == null){
            synchronized (AppManager.class){
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * 添加Activity到栈
     */
    public void addActivity(BaseActivity activity) {
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（栈顶Activity）
     */
    public BaseActivity currentActivity() {
        if (activityStack == null || activityStack.isEmpty()) {
            return null;
        }
        return activityStack.lastElement();
    }

    /**
     * 获取当前Activity（栈顶Activity） 没有找到则返回null
     */
    public BaseActivity findActivity(Class<?> cls) {
        BaseActivity activity = null;
        for (BaseActivity aty : activityStack) {
            if (aty.getClass().equals(cls)) {
                activity = aty;
                break;
            }
        }
        return activity;
    }

    /**
     * 结束当前Activity（栈顶Activity）
     */
    public void finishActivity() {
        BaseActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            if(activity.isFinishing()){
                activityStack.remove(activity);
            }
        }

    }

    /**
     * 结束指定的Activity(重载)
     */
    public void finishActivity(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     *
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (!(activity.getClass().equals(cls))) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (activityStack.get(i) != null) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
        System.exit(0);
    }

}
