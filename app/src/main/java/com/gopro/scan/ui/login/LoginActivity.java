package com.gopro.scan.ui.login;

import android.os.Bundle;
import android.view.View;

import com.gopro.scan.R;
import com.gopro.scan.databinding.ActivityLoginBinding;
import com.gopro.scan.viewmodel.LoginViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmActivity;


public class LoginActivity extends BaseMvvmActivity<LoginViewModel> implements View.OnClickListener {
    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initView();
        initData();
    }

    @Override
    public void initView() {
        mBinding.title.tvTitle.setText(mViewModel.getTitle());
        mBinding.title.imageBack.setOnClickListener(this);
        mBinding.btnLogin.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public Class<LoginViewModel> onBindViewModel() {
        return LoginViewModel.class;
    }

    private void login(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.btn_login:
                String strUser = mBinding.editUser.getText().toString().trim();
                String strPwd = mBinding.editPwd.getText().toString().trim();
                mViewModel.setStrUser(strUser);
                mViewModel.setStrPwd(strPwd);
                if (mViewModel.isLoginEmpty()) {
                    login();
                }
                break;
        }
    }
}
