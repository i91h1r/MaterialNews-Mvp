package com.github.hyr0318.materialnews_mvp.contract;

import android.content.Context;

/**
 * Author：hyr on 2016/8/27 11:01
 * Email：2045446584@qq.com
 */
public class WelecomeContract {

    public interface View {

        void initializedView(String versionName, String copyright);
    }


    public interface Presenter {
        void initialized();
    }


    public interface Model {

        String getVsersionName(Context context);

        String getCopyright(Context context);
    }

}