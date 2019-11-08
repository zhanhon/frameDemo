package com.gopro.scan.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.gopro.scan.R;
import com.gopro.scan.ui.home.ScanActivity;
import com.gopro.scan.viewmodel.MainViewModel;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zhanh.utilslibrary.mvvm.BaseMvvmActivity;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * 项目使用MVVM + Rxjava + Retrofit模式
 */
public class MainActivity extends BaseMvvmActivity<MainViewModel> {
    @BindView(R.id.tv_scan)
    TextView mTvScan;
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

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

    }

    @Override
    public void initData() {
        mViewModel.getScanLiveData().observe(this, s -> {
            mTvScan.setText("解析结果：" + s);
        });


    }


    @Override
    public Class<MainViewModel> onBindViewModel() {
        return MainViewModel.class;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mViewModel.onScanResult(requestCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btn_scan)
    public void onViewClicked() {
        Disposable disposable = new RxPermissions(this)
                .request(Manifest.permission.CAMERA)
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                        startActivityForResult(intent, mViewModel.REQUEST_CODE);
                    }
                });
    }

}
