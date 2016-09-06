package com.github.hyr0318.materialnews_mvp.model;

import com.github.hyr0318.materialnews_mvp.contract.VideoListContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/08/29
 */

public class VideoListModelImpl implements VideoListContract.VideoListModel {
    private BaseMultiLoadedListener<TouTiaoVideoResult> baseMultiLoadedListener;


    public VideoListModelImpl(BaseMultiLoadedListener<TouTiaoVideoResult> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;
    }


    @Override
    public void getCommonListData(String requestTag, int event_tag, String keywords, int page) {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        materialNewsApi.getvideoList(keywords, "A13557DC737A670")
            .subscribeOn(Schedulers.immediate())
            .subscribe(
                new BaseObserver<TouTiaoVideoResult>() {
                    @Override protected void onSucceed(TouTiaoVideoResult result) {

                        if (null != result) {
                            baseMultiLoadedListener.onSuccess(event_tag, result);
                        }

                    }


                    @Override public void onError(Throwable e) {
                        baseMultiLoadedListener.onException(e.toString());
                    }


                    @Override protected void onFailed(String msg) {
                        baseMultiLoadedListener.onError(msg);
                    }
                });

    }

}