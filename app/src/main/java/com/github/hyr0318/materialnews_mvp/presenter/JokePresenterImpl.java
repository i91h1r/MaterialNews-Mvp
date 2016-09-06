package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.JokeContract;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.JokeModelImpl;

/**
 * Created by MVPHelper on 2016/09/01
 */

public class JokePresenterImpl
    implements JokeContract.JokePresenter, BaseMultiLoadedListener<JokeResult> {
    private Context mContext;

    private JokeContract.JokeView jokeView;
    private final JokeModelImpl jokeModel;


    public JokePresenterImpl(Context mContext, JokeContract.JokeView jokeView) {
        this.mContext = mContext;

        this.jokeView = jokeView;

        jokeModel = new JokeModelImpl(this);

    }


    @Override
    public void loadListData(String requestTag, int event_tag, int page, String showapi_appid, String showapi_timestamp, String showapi_sign, boolean isSwipeRefresh) {

        if (!isSwipeRefresh) {
            jokeView.showLoading("");
        }
        jokeModel.getCommonListData(requestTag, event_tag, page, showapi_appid, showapi_timestamp,
            showapi_sign);

    }


    @Override public void onSuccess(int event_tag, JokeResult data) {
        jokeView.hideLoading();
        if (event_tag == Constants.EVENT_REFRESH_DATA) {
            jokeView.refreshListData(data);
        } else if (event_tag == Constants.EVENT_LOAD_MORE_DATA) {
            jokeView.addMoreListData(data);
        }

    }


    @Override public void onError(String msg) {
        jokeView.hideLoading();
    }


    @Override public void onException(String msg) {
        jokeView.hideLoading();
    }
}