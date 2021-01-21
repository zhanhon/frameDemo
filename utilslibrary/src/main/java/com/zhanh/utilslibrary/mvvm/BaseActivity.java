package com.zhanh.utilslibrary.mvvm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.zhanh.utilslibrary.R;
import com.zhanh.utilslibrary.util.AppManager;
import com.zhanh.utilslibrary.util.StatusBarUtil;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    private BasePopupView mLoadingPopupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置竖屏
        mLoadingPopupView = new XPopup.Builder(this).asLoading().setTitle("加载中...");
        AppManager.getAppManager().addActivity(this);
        setStatusBar();
        initFunc();
    }

    protected void initFunc(){

    }

    public abstract void initView();
    public abstract void initData();

    protected void showLoadingDialog() {
        mLoadingPopupView.show();
    }

    protected void dismissLoadingDialog() {
        if (mLoadingPopupView.isShow()) {
            mLoadingPopupView.dismiss();
        }
    }

    protected void setStatusBar(){
        StatusBarUtil.setColor(this, getResources().getColor(R.color.main));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        mLoadingPopupView = null;
        AppManager.getAppManager().finishActivity(this);
    }

    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
