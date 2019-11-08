package com.gopro.scan.ui.fragment;


import android.view.View;

import com.gopro.scan.R;
import com.gopro.scan.viewmodel.MainViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

/**
 *我的
 */
public class MineFragment extends BaseMvvmFragment<MainViewModel>{
    public MineFragment() {
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
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
