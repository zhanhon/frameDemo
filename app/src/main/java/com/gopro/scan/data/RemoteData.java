package com.gopro.scan.data;

import com.zhanh.utilslibrary.network.response.BaseObserver;
import com.zhanh.utilslibrary.network.response.ResponseEntity;
import com.zhanh.utilslibrary.network.response.ResponseTransformer;


/**
 * 远程数据
 */
public class RemoteData {
    private volatile static RemoteData mInstance;
    private RemoteData(){
    }
    public static RemoteData getInstance() {
        if (mInstance == null){
            synchronized (RemoteData.class) {
                if (mInstance == null) {
                    mInstance = new RemoteData();
                }
            }
        }
        return mInstance;
    }

    public void login(String user,String pwd,BaseObserver<ResponseEntity<String>> baseObserver){
        ApiService
                .getInstance()
                .login(user, pwd)
                .compose(ResponseTransformer.setThread())
                .subscribe(baseObserver);
    }





}
