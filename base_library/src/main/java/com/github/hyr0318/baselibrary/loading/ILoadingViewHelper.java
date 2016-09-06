package com.github.hyr0318.baselibrary.loading;

import android.content.Context;
import android.view.View;

/**
 * Description:
 * 作者：hyr on 2016/9/2 15:13
 * 邮箱：2045446584@qq.com
 */
public interface ILoadingViewHelper {

    public abstract View getCurrentLayout();

    public abstract void restoreView();

    public abstract void showLayout(View view);

    public abstract View inflate(int layoutId);

    public abstract Context getContext();

    public abstract View getView();
}
