package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.BaiSiContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.BaiSiModelImpl;

/**
 * Created by MVPHelper on 2016/09/09
 */

public class BaiSiPresenterImpl
    implements BaiSiContract.BaiSiPresenter, BaseMultiLoadedListener<BaiSiResult> {
    private Context mContext;

    private BaiSiContract.BaiSiView baiSiView;
    private final BaiSiModelImpl baiSiModel;


    public BaiSiPresenterImpl(Context mContext, BaiSiContract.BaiSiView baiSiView) {
        this.mContext = mContext;

        this.baiSiView = baiSiView;

        baiSiModel = new BaiSiModelImpl(this);

    }


    @Override
    public void loadListData(String requestTag, int event_tag, String url, long page, boolean isSwipeRefresh) {
        if (!isSwipeRefresh) {
            baiSiView.showLoading("");
        }
        baiSiModel.getListData(requestTag, event_tag, url, page);

    }


    @Override public void onSuccess(int event_tag, BaiSiResult data) {
        baiSiView.hideLoading();
        if (event_tag == Constants.EVENT_REFRESH_DATA) {
            baiSiView.refreshListData(data);
        } else if (event_tag == Constants.EVENT_LOAD_MORE_DATA) {
            baiSiView.addMoreListData(data);
        }
    }


    @Override public void onError(String msg) {

    }


    @Override public void onException(String msg) {

    }
}