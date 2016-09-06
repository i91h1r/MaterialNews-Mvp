package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.HomeContract;
import com.github.hyr0318.materialnews_mvp.model.HomeModelImpl;

/**
 * Created by MVPHelper on 2016/08/28
 */

public class HomePresenterImpl implements HomeContract.Presenter {

    private Context mContext;

    private HomeContract.View hv;
    private final HomeModelImpl homeModel;


    public HomePresenterImpl(Context context, HomeContract.View hv) {

        this.mContext = context;

        this.hv = hv;

        homeModel = new HomeModelImpl();

    }


    @Override public void initialized() {

        hv.initializedView(homeModel.getFragments(mContext), homeModel.getNavigationList(mContext));
    }
}