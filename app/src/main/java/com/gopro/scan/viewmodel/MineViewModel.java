package com.gopro.scan.viewmodel;

import com.gopro.scan.model.HomeModel;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

public class MineViewModel extends BaseViewModel<HomeModel> {
    @Override
    protected HomeModel onBindModel() {
        return new HomeModel();
    }
}
