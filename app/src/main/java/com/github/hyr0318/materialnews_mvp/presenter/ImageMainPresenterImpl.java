package com.github.hyr0318.materialnews_mvp.presenter;
import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.ImageMainContract;
import com.github.hyr0318.materialnews_mvp.model.ImageMainModelImpl;

/**
* Created by MVPHelper on 2016/09/02
*/

public class ImageMainPresenterImpl implements ImageMainContract.ImageMainPresenter{
    private Context mContext ;

    private ImageMainContract.ImageMainView  imageMainView;
    private final ImageMainModelImpl imageMainModel;


    public ImageMainPresenterImpl(Context mContext, ImageMainContract.ImageMainView imageMainView) {
        this.mContext = mContext ;

        this.imageMainView = imageMainView;

        imageMainModel = new ImageMainModelImpl();
    }


    @Override public void initialized() {
        imageMainView.initializedView(imageMainModel.getTabList(mContext));

    }
}