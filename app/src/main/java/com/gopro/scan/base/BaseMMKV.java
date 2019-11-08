package com.gopro.scan.base;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.tencent.mmkv.MMKV;
import com.zhanh.utilslibrary.base.BaseAppContext;


/**
 * 使用微信开源库MMKV
 *缓存小数据
 */
public class BaseMMKV {
    private static BaseMMKV mInstance;
    private final MMKV mDefaultMMKV;

    public static BaseMMKV getInstance() {
        if (mInstance == null){
            synchronized (BaseMMKV.class) {
                if (mInstance == null) {
                    mInstance = new BaseMMKV(BaseAppContext.getInstance());
                }
            }
        }
        return mInstance;
    }

    private BaseMMKV(Context context) {
        MMKV.initialize(context.getApplicationContext());
        mDefaultMMKV = MMKV.defaultMMKV();
    }

    /**
     * 是否第一次打开
     */
    public void setFirst(boolean firstTime) {
        mDefaultMMKV.encode("key_first", firstTime);
    }
    public boolean getFirst() {
        return mDefaultMMKV.decodeBool("key_first", false);
    }

    /**
     * 保存用户个人信息
     */
    public void setUserInfo(String info) {
        String json = JSON.toJSONString(info);
        mDefaultMMKV.encode("key_logininfo", json);
    }
    public String getUserInfo() {
        String json = mDefaultMMKV.decodeString("key_logininfo", null);
        if (json != null){
            return JSON.parseObject(json,String.class);
        }
        return null;
    }



}

