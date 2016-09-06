package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.ImageContract;
import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.listener.BaseMultiLoadedListener;
import com.github.hyr0318.materialnews_mvp.model.ImageModelImpl;

/**
 * Created by MVPHelper on 2016/09/02
 */

public class ImagePresenterImpl
    implements ImageContract.ImagePresenter, BaseMultiLoadedListener<ImageResult> {
    private Context mContext;

    private ImageContract.ImageContractView imageContractView;
    private final ImageModelImpl imageModel;


    public ImagePresenterImpl(Context mContext, ImageContract.ImageContractView imageContractView) {
        this.mContext = mContext;

        this.imageContractView = imageContractView;

        imageModel = new ImageModelImpl(this);

    }


    @Override
    public void loadListData(String requestTag, int event_tag, String word, int cl, boolean isSwipeRefresh) {

        if (!isSwipeRefresh) {
            imageContractView.showLoading("");
        }

        imageModel.getImageList(requestTag, event_tag, word, cl);

    }


    @Override public void onSuccess(int event_tag, ImageResult data) {
        imageContractView.hideLoading();
        if(event_tag == Constants.EVENT_REFRESH_DATA){
            imageContractView.refreshListData(data);
        }else  if(event_tag == Constants.EVENT_LOAD_MORE_DATA){
            imageContractView.addMoreListData(data);
        }
    }


    @Override public void onError(String msg) {
        imageContractView.hideLoading();
    }


    @Override public void onException(String msg) {
        imageContractView.hideLoading();
    }
}