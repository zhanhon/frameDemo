package com.zhanh.utilslibrary.mvvm;

import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

import androidx.lifecycle.ViewModelProviders;

public abstract class BaseMvvmFragment<VM extends BaseViewModel> extends BaseFragment{
    protected VM mViewModel;

    public abstract Class<VM> onBindViewModel();


    @Override
    protected void initFunc() {
        super.initFunc();
        initVm();
    }

    private void initVm(){
        Class<VM> vmClass = onBindViewModel();
        mViewModel = ViewModelProviders.of(this).get(vmClass);
        getLifecycle().addObserver(mViewModel);
    }


}
