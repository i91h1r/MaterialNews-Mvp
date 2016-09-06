package com.github.hyr0318.materialnews_mvp.model;

import android.content.Context;
import android.content.pm.PackageManager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.WelecomeContract;

/**
 * Created by hyr on 2016/08/27
 */

public class WelecomeModelImpl implements WelecomeContract.Model {

    //获取版本号
    @Override public String getVsersionName(Context context) {

        String versionName = null;
        try {
            versionName = context.getPackageManager()
                .getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return versionName;
    }


    @Override public String getCopyright(Context context) {
        return context.getResources().getString(R.string.wele_copyright);
    }
}