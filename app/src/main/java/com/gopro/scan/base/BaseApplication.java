package com.gopro.scan.base;

import android.app.Application;
import android.os.Looper;

import com.gopro.scan.R;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.lxj.xpopup.XPopup;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
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
    }

    private void initDelay(){
        Looper.myQueue().addIdleHandler(() -> {
            init();
            return false;
        });
    }


    private void initLiveEventBus(){
        LiveEventBus.config()
                .lifecycleObserverAlwaysActive(false)
                .autoClear(true);
    }



}
