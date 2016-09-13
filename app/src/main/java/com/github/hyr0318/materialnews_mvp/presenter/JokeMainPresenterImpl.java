package com.github.hyr0318.materialnews_mvp.presenter;
import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.JokeMainContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiTabResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.JokeMainModelImpl;

/**
* Created by MVPHelper on 2016/09/09
*/

public class JokeMainPresenterImpl implements JokeMainContract.JokeMainPresenter,BaseMultiLoadedListener<BaiSiTabResult>{
    private  Context mContext ;

    private JokeMainContract.JokeMainView jokeMainView;
    private final JokeMainModelImpl jokeMainModel;


    public JokeMainPresenterImpl(Context mContext, JokeMainContract.JokeMainView jokeMainView) {
        this.mContext = mContext ;

        this.jokeMainView = jokeMainView;

        jokeMainModel = new JokeMainModelImpl(this);

    }


    @Override public void initialized(String requestTag) {
        jokeMainModel.getTabList(requestTag);
    }


    @Override public void onSuccess(int event_tag, BaiSiTabResult data) {

        if(null != data){

            jokeMainView.initializedView(data);
        }
    }


    @Override public void onError(String msg) {

    }


    @Override public void onException(String msg) {

    }
}