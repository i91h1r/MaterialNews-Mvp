package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.BaiSiDetailContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiDetailResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.BaiSiDetailModelImpl;

/**
 * Created by MVPHelper on 2016/09/13
 */

public class BaiSiDetailPresenterImpl implements BaiSiDetailContract.BaiSiDetailPresenter,
    BaseMultiLoadedListener<BaiSiDetailResult> {

    private Context mContext;
    private BaiSiDetailContract.BaiSiDetailView baiSiDetailView;
    private final BaiSiDetailModelImpl baiSiDetailModel;


    public BaiSiDetailPresenterImpl(Context mContext, BaiSiDetailContract.BaiSiDetailView baiSiDetailView) {
        this.mContext = mContext;

        this.baiSiDetailView = baiSiDetailView;

        baiSiDetailModel = new BaiSiDetailModelImpl(this);

    }


    @Override
    public void loadCommentList(String request_tag, int enent_tag, int page, String id, boolean isRrefresh) {

        if (enent_tag == Constants.EVENT_REFRESH_DATA) {
            baiSiDetailModel.getCommentList(request_tag, enent_tag, page, id);
        }
    }


    @Override public void onSuccess(int event_tag, BaiSiDetailResult data) {

        if (null != data) {
            baiSiDetailView.initCommentList(data);
        }
    }


    @Override public void onError(String msg) {

    }


    @Override public void onException(String msg) {

    }
}