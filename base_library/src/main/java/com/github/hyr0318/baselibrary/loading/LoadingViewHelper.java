package com.github.hyr0318.baselibrary.loading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description:
 * 作者：hyr on 2016/9/2 15:14
 * 邮箱：2045446584@qq.com
 */
public class LoadingViewHelper implements ILoadingViewHelper {
    private View view;

    private View currentView;

    private ViewGroup parentView;

    private int viewIndex;
    private ViewGroup.LayoutParams params;


    public LoadingViewHelper(View view) {
        this.view = view;
    }


    private void init() {

        params = view.getLayoutParams();

        if (view.getParent() != null) {
            parentView = (ViewGroup) view.getParent();
        } else {
            parentView = (ViewGroup) view.getRootView().findViewById(android.R.id.content);
        }
        int count = parentView.getChildCount();
        for (int index = 0; index < count; index++) {
            if (view == parentView.getChildAt(index)) {
                viewIndex = index;
                break;
            }
        }
        currentView = view;


}


    @Override public View getCurrentLayout() {
        return currentView;
    }


    @Override public void restoreView() {
        showLayout(view);
    }


    @Override public void showLayout(View view) {

        if (null == parentView) {
            init();
        }

        this.currentView = view ;

        // 如果已经是那个view，那就不需要再进行替换操作了
        if (parentView.getChildAt(viewIndex) != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
            parentView.removeViewAt(viewIndex);
            parentView.addView(view, viewIndex, params);
        }

    }


    @Override public View inflate(int layoutId) {
        return LayoutInflater.from(view.getContext()).inflate(layoutId, null);
    }


    @Override public Context getContext() {
        return view.getContext();
    }


    @Override public View getView() {
        return view;
    }
}
