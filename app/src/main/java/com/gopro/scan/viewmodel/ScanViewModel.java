package com.gopro.scan.viewmodel;

import com.gopro.scan.model.ScanModel;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

public class ScanViewModel extends BaseViewModel<ScanModel> {
    @Override
    public ScanModel onBindModel() {
        return new ScanModel();
    }
}
