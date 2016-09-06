package com.github.hyr0318.materialnews_mvp.model;

import android.util.Log;
import com.github.hyr0318.materialnews_mvp.contract.ImageContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/09/02
 */

public class ImageModelImpl implements ImageContract.ImageModel {

    private BaseMultiLoadedListener<ImageResult> baseMultiLoadedListener;


    public ImageModelImpl(BaseMultiLoadedListener<ImageResult> baseMultiLoadedListener) {
        this.baseMultiLoadedListener = baseMultiLoadedListener;

    }


    @Override public void getImageList(String requestTag, int event_tag, String word, int cl) {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        Log.i("word============",word);
        Log.i("cl============",cl+"");
        materialNewsApi.getImageList("resultjson_com", "rj",word, String.valueOf(cl))
            .subscribeOn(Schedulers.immediate())
            .subscribe(
                new BaseObserver<ImageResult>() {
                    @Override protected void onSucceed(ImageResult result) {
                        baseMultiLoadedListener.onSuccess(event_tag, result);
                    }
                });
    }
}