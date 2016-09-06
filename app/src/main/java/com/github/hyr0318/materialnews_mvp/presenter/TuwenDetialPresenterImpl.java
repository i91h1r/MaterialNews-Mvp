package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.TuwenDetialContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenDetailEntity;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.TuwenDetialModelImpl;

/**
 * Created by MVPHelper on 2016/08/31
 */

public class TuwenDetialPresenterImpl implements TuwenDetialContract.TuwenDetialPresenter,
    BaseMultiLoadedListener<TuwenDetailEntity> {
    private Context mContext;

    private TuwenDetialContract.TuwenDetialView tv;
    private final TuwenDetialModelImpl tuwenDetialModel;


    public TuwenDetialPresenterImpl(Context cxt, TuwenDetialContract.TuwenDetialView tv) {
        this.mContext = cxt;

        this.tv = tv;

        tuwenDetialModel = new TuwenDetialModelImpl(this);
    }


    @Override
    public void loadTuwenDetail(String requestTag, int event_tag, String url, boolean isSwipeRefresh) {

      if (!isSwipeRefresh) {
            tv.showLoading("");
        }
        tuwenDetialModel.getTuwenDetailContent(requestTag, event_tag, url);
    }


    @Override public void onSuccess(int event_tag, TuwenDetailEntity data) {
        tv.hideLoading();
        tv.initializedView(data);
    }


    @Override public void onError(String msg) {

    }


    @Override public void onException(String msg) {

    }
}