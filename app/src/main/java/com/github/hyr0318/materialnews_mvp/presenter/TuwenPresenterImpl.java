package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.TuwenContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenEntity;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.TuwenModelImpl;
import java.util.List;

/**
 * Created by MVPHelper on 2016/08/30
 */

public class TuwenPresenterImpl implements TuwenContract.TuwenPresenter,
    BaseMultiLoadedListener<List<TuwenEntity>> {

    private Context mContext;
    private TuwenContract.TuwenView tuwenView;
    private final TuwenModelImpl tuwenModel;


    public TuwenPresenterImpl(Context mContext, TuwenContract.TuwenView tuwenView) {
        this.mContext = mContext;
        this.tuwenView = tuwenView;

        tuwenModel = new TuwenModelImpl(this);
    }


    @Override
    public void loadListData(String requestTag, int event_tag, String keywords,int page, boolean isSwipeRefresh) {


        if(! isSwipeRefresh){
            tuwenView.showLoading("");
        }
        tuwenModel.getCommonListData(requestTag, event_tag, keywords,page);

    }


    @Override public void onSuccess(int event_tag,  List<TuwenEntity> data) {
        tuwenView.hideLoading();

        if(event_tag == Constants.EVENT_REFRESH_DATA){
            tuwenView.refreshListData(data);
        }else if(event_tag == Constants.EVENT_LOAD_MORE_DATA){
            tuwenView.loadMoreList(data);
        }


    }


    @Override public void onError(String msg) {
        tuwenView.hideLoading();
    }


    @Override public void onException(String msg) {
        tuwenView.hideLoading();
    }
}