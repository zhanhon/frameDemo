package com.gopro.scan.ui.fragment;


import android.view.View;

import com.gopro.scan.R;
import com.gopro.scan.viewmodel.MainViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

/**
 *首页
 */
public class HomeFragment extends BaseMvvmFragment<MainViewModel>{
    public HomeFragment() {
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public Class<MainViewModel> onBindViewModel() {
        return MainViewModel.class;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }


}
