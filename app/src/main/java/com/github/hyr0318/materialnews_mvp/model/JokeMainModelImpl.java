package com.github.hyr0318.materialnews_mvp.model;

import com.github.hyr0318.materialnews_mvp.contract.JokeMainContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiTabResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/09/09
 */

public class JokeMainModelImpl implements JokeMainContract.JokeMainModel {
    private BaseMultiLoadedListener<BaiSiTabResult> baseMultiLoadedListener;


    public JokeMainModelImpl(BaseMultiLoadedListener<BaiSiTabResult> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;
    }


    @Override public void getTabList(String requestTag) {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        materialNewsApi.getTabList().subscribeOn(Schedulers.immediate()).subscribe(
            new BaseObserver<BaiSiTabResult>() {
                @Override protected void onSucceed(BaiSiTabResult result) {
                    baseMultiLoadedListener.onSuccess(0, result);
                }
            });

    }
}