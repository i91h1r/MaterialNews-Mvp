package com.github.hyr0318.baselibrary.base.fragment;

import com.github.hyr0318.baselibrary.view.BaseView;

/**
 * Description:
 * 作者：hyr on 2016/9/2 16:31
 * 邮箱：2045446584@qq.com
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {
    @Override
    public void showError(String msg) {
        triggerShowError(true, msg, null);
    }


    @Override
    public void showException(String msg) {
        triggerShowError(true, msg, null);
    }


    @Override
    public void showNetError() {
        triggerNetworkError(true, null);
    }


    @Override
    public void showLoading(String msg) {
        triggerShowLoading(true, null);
    }


    @Override
    public void hideLoading() {
        triggerShowLoading(false, null);
    }
}
