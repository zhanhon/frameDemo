package com.gopro.scan.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gopro.scan.R;
import com.gopro.scan.viewmodel.LoginViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMvvmActivity<LoginViewModel> {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.edit_user)
    EditText mEditUser;
    @BindView(R.id.edit_pwd)
    EditText mEditPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mTvTitle.setText(mViewModel.getTitle());

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


    @OnClick({R.id.image_back, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                break;
            case R.id.btn_login:
                String strUser = mEditUser.getText().toString().trim();
                String strPwd = mEditPwd.getText().toString().trim();
                mViewModel.setStrUser(strUser);
                mViewModel.setStrPwd(strPwd);
                if (mViewModel.isLoginEmpty()) {
                    login();
                }
                break;
        }
    }
}
