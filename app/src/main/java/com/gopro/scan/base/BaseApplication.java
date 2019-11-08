package com.gopro.scan.base;

import android.app.Application;
import android.content.Context;
import android.os.Looper;

import com.gopro.scan.R;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lxj.xpopup.XPopup;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.zhanh.utilslibrary.base.BaseAppContext;

import org.litepal.LitePal;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseAppContext.init(this);
        initDelay();

    }

    private void init() {
        LitePal.initialize(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        initLiveEventBus();
        XPopup.setPrimaryColor(getResources().getColor(R.color.main));
        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initDelay(){
        Looper.myQueue().addIdleHandler(() -> {
            init();
            return false;
        });
    }


    private void initLiveEventBus(){
        LiveEventBus.config()
                .supportBroadcast(this)
                .lifecycleObserverAlwaysActive(false)
                .autoClear(true);
    }



}
