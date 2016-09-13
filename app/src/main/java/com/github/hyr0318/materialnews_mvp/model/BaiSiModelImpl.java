package com.github.hyr0318.materialnews_mvp.model;

import com.github.hyr0318.materialnews_mvp.contract.BaiSiContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/09/09
 */

public class BaiSiModelImpl implements BaiSiContract.BaiSiModel {
    BaseMultiLoadedListener<BaiSiResult> baseMultiLoadedListener;


    public BaiSiModelImpl(BaseMultiLoadedListener<BaiSiResult> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;
    }


    @Override public void getListData(String requestTag, int event_tag, String url, long page) {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        String substring2 = url.substring(21, url.length());

        materialNewsApi.getBaiSiList(substring2,page).subscribeOn(Schedulers.immediate()).subscribe(
            new BaseObserver<BaiSiResult>() {
                @Override protected void onSucceed(BaiSiResult result) {
                    baseMultiLoadedListener.onSuccess(event_tag, result);

                }
            });

    }
}