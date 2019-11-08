package com.zhanh.utilslibrary.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment{
    private BasePopupView mLoadingPopupView;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mUnbinder = ButterKnife.bind(this,view);
        mLoadingPopupView = new XPopup.Builder(getContext()).asLoading().setTitle("加载中...");
        initFunc();
        initView(view);
        initData();
    }

    protected void initFunc(){

    }

    public abstract int setLayoutId();
    public abstract void initView(View view);
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
        mUnbinder.unbind();
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
