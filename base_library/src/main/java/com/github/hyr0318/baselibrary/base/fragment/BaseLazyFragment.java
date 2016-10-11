package com.github.hyr0318.baselibrary.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.loading.LoadingViewController;
import com.github.hyr0318.baselibrary.net.NetChangeObserver;
import com.github.hyr0318.baselibrary.utils.CommonUtils;
import java.lang.reflect.Field;
import org.greenrobot.eventbus.EventBus;

/**
 * Description:
 * 作者：hyr on 2016/9/2 16:18
 * 邮箱：2045446584@qq.com
 */
public abstract class BaseLazyFragment extends Fragment {
    protected static String TAG_LOG = null;

    protected Context mContext = null;

    private NetChangeObserver netChangeObserver;
    private LoadingViewController loadingViewController;

    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG_LOG = this.getClass().getSimpleName();
        if (isBindEventBusHere()) {
            EventBus.getDefault().register(this);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getContentViewLayoutID() != 0) {
            View view = inflater.inflate(getContentViewLayoutID(), null);

            getViewById(view);


            if(getRefreshLayoutView() != null){

                BGANormalRefreshViewHolder bgaNormalRefreshViewHolder = new BGANormalRefreshViewHolder(
                    mContext, true);

                initRefreshLayout(bgaNormalRefreshViewHolder);

            }


            return view;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }


    }


    protected abstract View getRefreshLayoutView();


    protected abstract void initRefreshLayout(BGANormalRefreshViewHolder bgaNormalRefreshViewHolder);




    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);
        if (null != getLoadingView()) {
            loadingViewController = new LoadingViewController(getLoadingView());
        }

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        initViewsAndEvents();
    }


    protected abstract void getViewById(View view);



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isBindEventBusHere()) {
            EventBus.getDefault().unregister(this);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        // for bug ---> java.lang.IllegalStateException: Activity has been destroyed
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume) {
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()) {
            onUserInvisible();
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }


    protected void onFirstUserInvisible() {

    }


    protected abstract void onUserInvisible();


    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }


    /**
     * fragment 第一次可见状态时
     */
    protected abstract void onFirstUserVisible();

    protected abstract void onUserVisible();

    protected abstract void initViewsAndEvents();

    protected abstract View getLoadingView();

    protected abstract int getContentViewLayoutID();
    protected abstract boolean isBindEventBusHere();


    /**
     * 启动新的Activity
     */

    protected void startNewActivity(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }


    /**
     * 启动新的Activity,带参数
     */

    protected void startNewActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * 启动一个有返回结果的activity
     */
    protected void startNewActivityForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }


    /**
     * 启动一个带参数的有返回结果的activity
     */
    protected void startNewActivityForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    /**
     * toast
     */
    protected void showToast(String msg) {
        //防止遮盖虚拟按键
        if (null != msg && !CommonUtils.isEmpty(msg)) {
            Snackbar.make(getLoadingView(), msg, Snackbar.LENGTH_SHORT).show();
        }
    }


    /**
     * 触发显示加载进度视图
     */
    protected void triggerShowLoading(boolean toggle, String msg) {
        if (null == loadingViewController) {
            throw new IllegalArgumentException("请返回一个正确的加载进度的view");
        }

        if (toggle) {
            loadingViewController.showLoading(msg);
        } else {
            loadingViewController.restore();
        }
    }


    /**
     * 触发显示一个空的视图
     */

    protected void triggerShowEmpty(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == loadingViewController) {
            throw new IllegalArgumentException("请返回一个正确的加载进度的view");
        }

        if (toggle) {
            loadingViewController.showEmpty(msg, onClickListener);
        } else {
            loadingViewController.restore();
        }
    }


    /**
     * 触发显示一个错误的视图
     */
    protected void triggerShowError(boolean toggle, String msg, View.OnClickListener onClickListener) {
        if (null == loadingViewController) {
            throw new IllegalArgumentException("请返回一个正确的加载进度的view");
        }

        if (toggle) {
            loadingViewController.showError(msg, onClickListener);
        } else {
            loadingViewController.restore();
        }
    }


    /**
     * 触发显示一个网络错误的视图
     */
    protected void triggerNetworkError(boolean toggle, View.OnClickListener onClickListener) {
        if (null == loadingViewController) {
            throw new IllegalArgumentException("请返回一个正确的加载进度的view");
        }

        if (toggle) {
            loadingViewController.showNetworkError(onClickListener);
        } else {
            loadingViewController.restore();
        }
    }


    public void onEventMainThread(EventCenter eventCenter) {
        if (null != eventCenter) {
            onEventComming(eventCenter);
        }
    }


    protected abstract void onEventComming(EventCenter eventCenter);

}
