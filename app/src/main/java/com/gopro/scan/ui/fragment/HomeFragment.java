package com.gopro.scan.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.gopro.scan.R;
import com.gopro.scan.viewmodel.HomeViewModel;
import com.gopro.scan.viewmodel.MainViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

import butterknife.BindView;

/**
 *首页
 */
public class HomeFragment extends BaseMvvmFragment<HomeViewModel>{
    public HomeFragment() {
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public Class<HomeViewModel> onBindViewModel() {
        return HomeViewModel.class;
    }

    @Override
    public void initView(View view) {



    }

    @Override
    public void initData() {

    }


}
