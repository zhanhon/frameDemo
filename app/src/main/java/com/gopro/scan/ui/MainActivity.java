package com.gopro.scan.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.gopro.scan.R;
import com.gopro.scan.data.bean.TabFragment;
import com.gopro.scan.ui.home.ScanActivity;
import com.gopro.scan.viewmodel.MainViewModel;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhanh.utilslibrary.mvvm.BaseMvvmActivity;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * 项目使用MVVM + Rxjava + Retrofit模式
 */
public class MainActivity extends BaseMvvmActivity<MainViewModel> {
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mViewModel.initTabList();
        for (int i = 0; i < mViewModel.mFragmentList.size(); i++) {
            TabFragment tabFragment = mViewModel.mFragmentList.get(i);
            TabLayout.Tab tab = mTablayout.newTab().setIcon(tabFragment.getImageId()).setText(tabFragment.getName());
            mTablayout.addTab(tab);
        }

//        mTablayout.getTabAt(2).select();//选中指定页
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        defaultFragment(0);

    }

    @Override
    public void initData() {


    }


    private void defaultFragment(int position) {
        if (mViewModel.mFragmentList.size() > position) {
            mFragment = mViewModel.mFragmentList.get(position).getFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, mFragment).commitAllowingStateLoss();
        }
    }

    private void switchFragment(int position) {
        if (mViewModel.mFragmentList.size() > position) {
            Fragment fragment = mViewModel.mFragmentList.get(position).getFragment();
            if (mFragment != fragment) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(mFragment);
                if (fragment.isAdded()) {
                    ft.show(fragment).commitAllowingStateLoss();
                } else {
                    ft.add(R.id.content, fragment).commitAllowingStateLoss();
                }
                mFragment = fragment;
            }
        }
    }

    @Override
    public Class<MainViewModel> onBindViewModel() {
        return MainViewModel.class;
    }

}
