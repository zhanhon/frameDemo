package com.gopro.scan.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopro.scan.databinding.FragmentHomeBinding;
import com.gopro.scan.viewmodel.HomeViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

import androidx.annotation.Nullable;

/**
 *首页
 */
public class HomeFragment extends BaseMvvmFragment<HomeViewModel>{

    private FragmentHomeBinding mBinding;

    public HomeFragment() {
    }

    @Override
    public Class<HomeViewModel> onBindViewModel() {
        return HomeViewModel.class;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void initView() {
        mBinding.tvTest.setText("测试");

    }

    @Override
    public void initData() {

    }


}
