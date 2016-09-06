package com.github.hyr0318.materialnews_mvp.presenter;
import android.content.Context;
import com.github.hyr0318.materialnews_mvp.contract.WelecomeContract;
import com.github.hyr0318.materialnews_mvp.model.WelecomeModelImpl;

/**
* Created by hyr on 2016/08/27
*/

public class WelecomePresenterImpl implements WelecomeContract.Presenter{

    private  Context mContext ;

    private  WelecomeContract.View wv ;
    private final WelecomeModelImpl welecomeModel;


    public WelecomePresenterImpl(Context context, WelecomeContract.View wv) {
        this.mContext = context ;
        this.wv = wv;

        welecomeModel = new WelecomeModelImpl();


    }


    @Override public void initialized() {

        wv.initializedView(welecomeModel.getVsersionName(mContext),welecomeModel.getCopyright(mContext));
    }
}