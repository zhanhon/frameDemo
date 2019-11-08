package com.gopro.scan.viewmodel;

import android.text.TextUtils;

import com.gopro.scan.model.LoginModel;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;
import com.zhanh.utilslibrary.util.ToastUtils;

import androidx.lifecycle.LiveData;

public class LoginViewModel extends BaseViewModel<LoginModel> {
    private String strUser;
    private String strPwd;
    private String title = "登录";
    @Override
    protected LoginModel onBindModel() {
        return new LoginModel();
    }

    public LiveData<String> login(){
        return mModel.login(strUser,strPwd);
    }


    public boolean isLoginEmpty(){
        if (TextUtils.isEmpty(strUser)){
            ToastUtils.showShort("账号不能为空");
            return false;
        }
        if (TextUtils.isEmpty(strPwd)){
            ToastUtils.showShort("密码不能为空");
            return false;
        }
        return true;
    }


    public void setStrUser(String strUser) {
        this.strUser = strUser;
    }

    public void setStrPwd(String strPwd) {
        this.strPwd = strPwd;
    }

    public String getTitle() {
        return title;
    }
}
