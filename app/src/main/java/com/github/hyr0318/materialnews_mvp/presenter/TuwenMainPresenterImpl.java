package com.github.hyr0318.materialnews_mvp.presenter;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.TuwenMainContract;
import com.github.hyr0318.materialnews_mvp.model.TuwenMainModelImpl;

/**
 * Created by MVPHelper on 2016/09/01
 */

public class TuwenMainPresenterImpl implements TuwenMainContract.TuwenMainPresenter {
    private Context mContext;

    private TuwenMainContract.TuwenMainView view;
    private final TuwenMainModelImpl tuwenMainModel;


    public TuwenMainPresenterImpl(Context mContext, TuwenMainContract.TuwenMainView view) {
        this.mContext = mContext;

        this.view = view;

        tuwenMainModel = new TuwenMainModelImpl();
    }


    @Override public void initialized() {
        view.initializedView(tuwenMainModel.getTabList(mContext));

    }
}