package com.gopro.scan.ui.fragment;

import android.view.View;

import com.gopro.scan.R;
import com.gopro.scan.viewmodel.MineViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

/**
 *我的
 */
public class MineFragment extends BaseMvvmFragment<MineViewModel>{
    public MineFragment() {
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public Class<MineViewModel> onBindViewModel() {
        return MineViewModel.class;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }


}
