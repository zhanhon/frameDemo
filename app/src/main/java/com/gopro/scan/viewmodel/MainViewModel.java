package com.gopro.scan.viewmodel;

import com.gopro.scan.R;
import com.gopro.scan.data.bean.TabFragment;
import com.gopro.scan.model.MainModel;
import com.gopro.scan.ui.fragment.HomeFragment;
import com.gopro.scan.ui.fragment.MineFragment;
import com.zhanh.utilslibrary.mvvm.viewmodel.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends BaseViewModel<MainModel> {
    public List<TabFragment> mFragmentList = new ArrayList<>();

    @Override
    protected MainModel onBindModel() {
        return new MainModel();
    }

    public void initTabList(){
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new TabFragment(new HomeFragment(),"首页",R.drawable.selector_tab_btn_home));
        mFragmentList.add(new TabFragment(new MineFragment(),"我的",R.drawable.selector_tab_btn_mine));
    }






}
