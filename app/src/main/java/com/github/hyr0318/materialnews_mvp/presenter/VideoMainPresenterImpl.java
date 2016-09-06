package com.github.hyr0318.materialnews_mvp.presenter;
import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.VideoMainContract;
import com.github.hyr0318.materialnews_mvp.model.VideoMainModelImpl;

/**
* Created by MVPHelper on 2016/08/29
*/

public class VideoMainPresenterImpl implements VideoMainContract.VideoMainPresenter{
    private  Context mContext ;
    private VideoMainContract.VideoMainView mVv ;
    private final VideoMainModelImpl videoMainModel;


    public VideoMainPresenterImpl(Context context, VideoMainContract.VideoMainView vv) {
        this.mContext = context;

        this.mVv =vv;

        videoMainModel = new VideoMainModelImpl();


    }


    @Override public void initialized() {
        mVv.initializedView(videoMainModel.getTabList(mContext));
    }
}