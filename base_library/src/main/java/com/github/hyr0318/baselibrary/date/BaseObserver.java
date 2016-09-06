package com.github.hyr0318.baselibrary.date;

import android.text.TextUtils;
import com.github.hyr0318.baselibrary.date.entity.BaseResult;
import com.orhanobut.logger.Logger;
import rx.Observer;

/**
 * 网络请求返回需要的模型
 * Created by ice on 3/3/16.
 */
public abstract class BaseObserver<T extends BaseResult> implements Observer<T> {

    protected abstract void onSucceed(T result);


    protected void onFailed(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Logger.i(msg);
        }
    }


    @Override
    public void onCompleted() {
        Logger.i("onCompleted =====", "onCompleted");
    }


    @Override
    public void onError(Throwable e) {
        Logger.i("onError====", e.toString());
        onFailed(null);
    }


    @Override
    public void onNext(T result) {
        if (result != null) {
            onSucceed(result);
        } else {
            onFailed(null);
        }

    }
}
