package com.gopro.scan.model;

import com.gopro.scan.data.RemoteData;
import com.zhanh.utilslibrary.mvvm.model.BaseModel;
import com.zhanh.utilslibrary.network.response.BaseObserver;
import com.zhanh.utilslibrary.network.response.ResponseEntity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LoginModel extends BaseModel {
    private RemoteData remoteData;
    public LoginModel(){
        remoteData = RemoteData.getInstance();
    }

    public LiveData<String> login(String user, String pwd){
        MutableLiveData<String> liveData = new MutableLiveData<>();
        remoteData.login(user, pwd, new BaseObserver<ResponseEntity<String>>() {
            @Override
            public void onSuccess(ResponseEntity<String> results) {
                if (results.isSuccess()){
                    liveData.postValue(results.getData());
                }else {
                    liveData.postValue(null);
                }
            }
            @Override
            public void onFailure(Throwable e, String msg) {
                liveData.postValue(null);
            }
        });
        return liveData;
    }

}
