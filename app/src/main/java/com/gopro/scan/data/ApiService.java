package com.gopro.scan.data;

import com.gopro.scan.base.Constants;
import com.zhanh.utilslibrary.network.RetrofitFactory;

public class ApiService {
    private volatile static ApiService mInstance;
    private RequestApis nbaApiT;
    private ApiService() {
        //接口类RequestApis是服务后台数据接口，类名可自定义
        nbaApiT = RetrofitFactory
                .getInstance()
                .create(Constants.baseUrl,RequestApis.class);
    }
    public static RequestApis getInstance() {
        if (mInstance == null){
            synchronized (ApiService.class){
                if (mInstance == null){
                    mInstance = new ApiService();
                }
            }
        }
        return mInstance.nbaApiT;
    }

}
