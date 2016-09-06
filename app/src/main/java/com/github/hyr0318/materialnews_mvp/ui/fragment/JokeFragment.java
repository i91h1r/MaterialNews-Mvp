package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.api.ApiConstants;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.JokeContract;
import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.presenter.JokePresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.activity.WebViewActivity;
import com.github.hyr0318.materialnews_mvp.ui.adapter.JokeAdapter;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class JokeFragment extends BaseFragment implements JokeContract.JokeView,
    BGARefreshLayout.BGARefreshLayoutDelegate,
    OnRecyclerViewItemClickListener<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> {
    private RecyclerView jokeList;

    private int mCurrentPage = 1;

    private String time;
    private JokeAdapter jokeAdapter;
    private BGARefreshLayout bgaRefreshLayout;
    private JokePresenterImpl jokePresenter;


    @Override protected void onFirstUserVisible() {

        jokePresenter = new JokePresenterImpl(mContext, this);

        if (NetUtils.isNetworkConnected(mContext)) {
            jokeList.postDelayed(()->jokePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, mCurrentPage,
                Constants.SHOW_API_APP_ID, time, Constants.SHOW_API_SIGN, false),ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);

        }
    }


    @Override protected void onUserVisible() {

    }


    @Override protected void getViewById(View view) {
        bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.joke_bga);

     jokeList =    ((RecyclerView) view.findViewById(R.id.jokeList));
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {

        bgaRefreshLayout.setDelegate(this);

        BGANormalRefreshViewHolder bgaNormalRefreshViewHolder = new BGANormalRefreshViewHolder(
            mContext, true);

        bgaRefreshLayout.setRefreshViewHolder(bgaNormalRefreshViewHolder);

        jokeAdapter = new JokeAdapter(mContext, getActivity());

        jokeAdapter.setOnRecyclerViewItemClickListener(this);
        jokeList.setLayoutManager(new LinearLayoutManager(mContext));

        jokeList.setAdapter(jokeAdapter);
    }


    @Override protected View getLoadingView() {
        return jokeList;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_joke_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void refreshListData(JokeResult jokeResult) {

        bgaRefreshLayout.endRefreshing();

        if (null != jokeResult) {

            JokeResult.ShowapiResBodyBean showapi_res_body = jokeResult.getShowapi_res_body();

            JokeResult.ShowapiResBodyBean.PagebeanBean pagebean = showapi_res_body.getPagebean();

            List<JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist
                = pagebean.getContentlist();

            jokeAdapter.getContentlist().clear();

            jokeAdapter.getContentlist().addAll(contentlist);

            jokeAdapter.notifyDataSetChanged();

        }

    }


    @Override public void addMoreListData(JokeResult jokeResult) {

        jokeAdapter.getContentlist()
            .addAll(jokeResult.getShowapi_res_body().getPagebean().getContentlist());
        jokeAdapter.notifyDataSetChanged();

        bgaRefreshLayout.endLoadingMore();
    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mCurrentPage = 0;
        if (NetUtils.isNetworkConnected(mContext)) {
            jokePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, mCurrentPage,
                Constants.SHOW_API_APP_ID, time, Constants.SHOW_API_SIGN, true);
        }
    }


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {

        if (NetUtils.isNetworkConnected(mContext)) {
            mCurrentPage++;

            jokePresenter.loadListData(TAG_LOG, Constants.EVENT_LOAD_MORE_DATA, mCurrentPage,
                Constants.SHOW_API_APP_ID, time, Constants.SHOW_API_SIGN, true);

            return true;
        }

        return false;
    }


    @Override
    public void onItemClick(View view, JokeResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean entity) {

        Intent intent = new Intent();

        intent.setClass(mContext, WebViewActivity.class);
        intent.putExtra("source_url", entity.getWeixin_url());
        intent.putExtra("title", entity.getText());
        startActivity(intent);
    }
}
