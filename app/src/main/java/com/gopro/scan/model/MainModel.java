package com.gopro.scan.model;

import com.gopro.scan.data.RemoteData;
import com.zhanh.utilslibrary.mvvm.model.BaseModel;

public class MainModel extends BaseModel {
    private RemoteData mRemoteData;
    public MainModel(){
        mRemoteData = RemoteData.getInstance();
    }


}
