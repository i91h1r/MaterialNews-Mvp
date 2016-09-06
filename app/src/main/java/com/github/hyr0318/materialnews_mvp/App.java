package com.github.hyr0318.materialnews_mvp;

import android.app.Application;
import com.github.hyr0318.materialnews_mvp.utils.Toaster;

public class App extends Application {

    private static App sApp;

    private static Toaster sToaster;

    public static App getInstance() {
        if (sApp == null) {
            sApp = new App();
        }
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

    }

    public static void showToast(String msg) {
        if (sToaster == null)
            sToaster = new Toaster();
        sToaster.showToast(msg);
    }

}
