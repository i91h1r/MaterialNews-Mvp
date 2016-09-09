package com.github.hyr0318.materialnews_mvp.model;

import android.content.Context;
import android.content.pm.PackageManager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.WelecomeContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.HomeOneIdResult;
import com.github.hyr0318.materialnews_mvp.entity.HomeOneResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hyr on 2016/08/27
 */

public class WelecomeModelImpl implements WelecomeContract.Model {
    private BaseMultiLoadedListener<HomeOneResult> multiLoadedListener;


    public WelecomeModelImpl(BaseMultiLoadedListener<HomeOneResult> multiLoadedListener) {
        this.multiLoadedListener = multiLoadedListener;
    }


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


    @Override public void getHomeOne() {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        materialNewsApi.getHomeOneId()
            .flatMap(new Func1<HomeOneIdResult, Observable<HomeOneResult>>() {
                @Override public Observable<HomeOneResult> call(HomeOneIdResult homeOneIdResult) {
                    return materialNewsApi.getHomeOneData(homeOneIdResult.getData().get(0));
                }
            })
            .subscribeOn(Schedulers.immediate())
            .subscribe(new BaseObserver<HomeOneResult>() {
                @Override protected void onSucceed(HomeOneResult result) {

                    multiLoadedListener.onSuccess(0 ,result);

                }
            });

    }
}