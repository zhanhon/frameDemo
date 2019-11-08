package com.zhanh.utilslibrary.mvvm;

import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

import androidx.lifecycle.ViewModelProviders;

public abstract class BaseMvvmActivity<VM extends BaseViewModel> extends BaseActivity {
    protected VM mViewModel;

    @Override
    protected void initFunc() {
        super.initFunc();
        initVm();
    }

    public abstract Class<VM> onBindViewModel();

    private void initVm(){
        Class<VM> vmClass = onBindViewModel();
        mViewModel = ViewModelProviders.of(this).get(vmClass);
        getLifecycle().addObserver(mViewModel);
    }





}
