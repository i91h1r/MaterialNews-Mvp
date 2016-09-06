package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.VideoListContract;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.VideoListModelImpl;
import com.orhanobut.logger.Logger;

/**
 * Created by MVPHelper on 2016/08/29
 */

public class VideoListPresenterImpl
    implements VideoListContract.VideoListPresenter, BaseMultiLoadedListener<TouTiaoVideoResult> {

    private Context mContext;

    private VideoListContract.VideoListView vv;
    private final VideoListModelImpl videoListModel;


    public VideoListPresenterImpl(Context ct, VideoListContract.VideoListView vv) {
        this.mContext = ct;

        this.vv = vv;

        videoListModel = new VideoListModelImpl(this);

    }


    @Override
    public void loadListData(String requestTag, int event_tag, String keywords, int page, boolean isSwipeRefresh) {

        if (!isSwipeRefresh) {
            vv.showLoading("");
        }

        videoListModel.getCommonListData(requestTag, event_tag, keywords, page);
    }


    @Override public void onSuccess(int event_tag, TouTiaoVideoResult data) {
        vv.hideLoading();
        if (event_tag == Constants.EVENT_REFRESH_DATA) {
            vv.refreshListData(data);
        } else if (event_tag == Constants.EVENT_LOAD_MORE_DATA) {
            vv.addMoreListData(data);
        }

    }


    @Override public void onError(String msg) {

        vv.hideLoading();

        vv.showError(msg);
        Logger.e(msg);
    }


    @Override public void onException(String msg) {

        vv.hideLoading();

        vv.showException(msg);
    }
}