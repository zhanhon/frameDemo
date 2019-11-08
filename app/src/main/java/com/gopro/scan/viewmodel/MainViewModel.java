package com.gopro.scan.viewmodel;

import android.content.Intent;
import android.os.Bundle;

import com.gopro.scan.model.MainModel;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;
import com.zhanh.utilslibrary.util.ToastUtils;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel<MainModel> {
    public final int REQUEST_CODE = 1001;
    private MutableLiveData<String> mScanLiveData = new MutableLiveData<>();
    @Override
    public MainModel onBindModel() {
        return new MainModel();
    }






    /**
     * 处理二维码扫描结果
     */
    public void onScanResult(int requestCode,Intent data){
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    mScanLiveData.postValue(result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    ToastUtils.showShort("解析二维码失败");
                }
            }
        }
    }

    public MutableLiveData<String> getScanLiveData() {
        return mScanLiveData;
    }
}
