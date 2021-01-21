package com.zhanh.utilslibrary.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment{
    private BasePopupView mLoadingPopupView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mLoadingPopupView = new XPopup.Builder(getContext()).asLoading().setTitle("加载中...");
        initFunc();
        initView();
        initData();
    }

    protected void initFunc(){

    }

    public abstract void initView();
    public abstract void initData();



    protected void showLoadingDialog() {
        mLoadingPopupView.show();
    }

    protected Context getMContext(){
        return getContext();
    }

    protected void dismissLoadingDialog() {
        if (mLoadingPopupView.isShow()) {
            mLoadingPopupView.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dismissLoadingDialog();
        mLoadingPopupView = null;
    }


    protected void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(getMContext(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
}
