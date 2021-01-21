package com.gopro.scan.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gopro.scan.databinding.FragmentMineBinding;
import com.gopro.scan.viewmodel.MineViewModel;
import com.zhanh.utilslibrary.mvvm.BaseMvvmFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 *我的
 */
public class MineFragment extends BaseMvvmFragment<MineViewModel>{

    private FragmentMineBinding mBinding;

    public MineFragment() {
    }

    @Override
    public Class<MineViewModel> onBindViewModel() {
        return MineViewModel.class;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMineBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


}
