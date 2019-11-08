package com.zhanh.utilslibrary.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Environment;

import com.zhanh.utilslibrary.R;
import com.zhanh.utilslibrary.base.BaseAppContext;

import constacne.UiType;
import listener.Md5CheckResultListener;
import model.UiConfig;
import model.UpdateConfig;
import update.UpdateAppUtils;

/**
 * 版本更新
 */
public class UpdateUtils {

    // 更新配置
    private static UpdateConfig getUpdateConfig(){
        Resources resources = BaseAppContext.getInstance().getResources();
        UpdateConfig updateConfig = new UpdateConfig();
        updateConfig.setForce(true);
        updateConfig.setCheckWifi(true);
        updateConfig.setNeedCheckMd5(false);
        updateConfig.setShowNotification(true);
        updateConfig.setApkSaveName(resources.getString(R.string.app_name));
        updateConfig.setApkSavePath(Environment.getExternalStorageDirectory().getAbsolutePath() + resources.getString(R.string.storage_path));
        return updateConfig;
    }


    // ui配置
    private static UiConfig getUiConfig(){
        UiConfig uiConfig = new UiConfig();
        uiConfig.setUiType(UiType.PLENTIFUL);
        uiConfig.setCancelBtnText("下次再说");
        uiConfig.setUpdateLogoImgRes(R.drawable.ic_update_logo);
        uiConfig.setUpdateBtnBgRes(R.drawable.bg_btn_ripple);
        uiConfig.setTitleTextColor(Color.BLACK);
        uiConfig.setTitleTextSize(16f);
        uiConfig.setDownloadingBtnText("下载中...");
        uiConfig.setCancelBtnTextColor(Color.parseColor("#88e16531"));
        return uiConfig;
    }

    public static void updateApp(String apkUrl,String updateContent){

        UpdateAppUtils
                .getInstance()
                .apkUrl(apkUrl)
                .updateTitle("版本更新")
                .updateContent(updateContent)
                .updateConfig(getUpdateConfig())
                .uiConfig(getUiConfig())
                .setMd5CheckResultListener(new Md5CheckResultListener() {
                    @Override
                    public void onResult(boolean b) {

                    }
                })
                .update();
    }


}
