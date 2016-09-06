package com.github.hyr0318.materialnews_mvp.model;

import android.util.Log;
import com.github.hyr0318.materialnews_mvp.contract.JokeContract;
import com.github.hyr0318.materialnews_mvp.data.MaterialNewsApi;
import com.github.hyr0318.materialnews_mvp.data.http.BaseObserver;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import rx.schedulers.Schedulers;

/**
 * Created by MVPHelper on 2016/09/01
 */

public class JokeModelImpl implements JokeContract.JokeModel {
    private BaseMultiLoadedListener<JokeResult> multiLoadedListener;


    public JokeModelImpl(BaseMultiLoadedListener<JokeResult> multiLoadedListener) {
        this.multiLoadedListener = multiLoadedListener;

    }


    @Override
    public void getCommonListData(String requestTag, int event_tag, int page, String showapi_appid, String showapi_timestamp, String showapi_sign) {

        MaterialNewsApi materialNewsApi = new MaterialNewsApi();

        materialNewsApi.getJokeList(page,showapi_appid,showapi_timestamp,showapi_sign).subscribeOn(
            Schedulers.immediate()).subscribe(new BaseObserver<JokeResult>() {
            @Override protected void onSucceed(JokeResult result) {

                if(result != null ){
                    multiLoadedListener.onSuccess(event_tag,result);

                    Log.i("mCurrentPage",page+"");
                }
            }
        });

    }
}