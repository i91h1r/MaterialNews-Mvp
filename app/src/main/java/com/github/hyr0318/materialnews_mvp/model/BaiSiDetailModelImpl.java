package com.github.hyr0318.materialnews_mvp.model;

import com.github.hyr0318.materialnews_mvp.contract.BaiSiDetailContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiDetailResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.orhanobut.logger.Logger;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/09/13
 */

public class BaiSiDetailModelImpl implements BaiSiDetailContract.BaiSiDetailModel {

    private BaseMultiLoadedListener<BaiSiDetailResult> baseMultiLoadedListener;


    public BaiSiDetailModelImpl(BaseMultiLoadedListener<BaiSiDetailResult> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;
    }


    @Override
    public void getCommentList(String request_tag, int enent_tag, int page, String id) {

        Logger.d(id);

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        materialNewsApi.getBaiSiDetailResult(id).subscribeOn(Schedulers.immediate()).subscribe(
            new BaseObserver<BaiSiDetailResult>() {
                @Override protected void onSucceed(BaiSiDetailResult result) {

                    Logger.d(result.getTotal());

                    baseMultiLoadedListener.onSuccess(enent_tag, result);
                }
            });

    }
}