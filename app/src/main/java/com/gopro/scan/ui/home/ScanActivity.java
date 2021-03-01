package com.gopro.scan.ui.home;

import android.os.Bundle;

import com.king.zxing.CaptureActivity;
import com.king.zxing.CaptureHelper;
import com.zhanh.utilslibrary.util.MyLog;

public class ScanActivity extends CaptureActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CaptureHelper captureHelper = getCaptureHelper();
        captureHelper.vibrate(true);
    }

    @Override
    public boolean onResultCallback(String result) {
        MyLog.d("结果="+result);
        return super.onResultCallback(result);
    }

}
