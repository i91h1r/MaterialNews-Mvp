package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import butterknife.BindView;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.api.ApiConstants;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.BaiSiContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;
import com.github.hyr0318.materialnews_mvp.listener.OnPagerSelectedListener;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.presenter.BaiSiPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.activity.BaiSiDetailActivity;
import com.github.hyr0318.materialnews_mvp.ui.adapter.JokeAdapter;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class JokeFragment extends BaseFragment implements BaiSiContract.BaiSiView,
    BGARefreshLayout.BGARefreshLayoutDelegate,
    OnPagerSelectedListener, OnRecyclerViewItemClickListener<BaiSiResult.ListBean> {

    @BindView(R.id.jokeList)
    RecyclerView jokeList;

    private long mCurrentPage = 0;

    private JokeAdapter jokeAdapter;

    @BindView(R.id.joke_bga)
     BGARefreshLayout bgaRefreshLayout;

    private BaiSiPresenterImpl baiSiPresenter;

    private String url;


    public JokeFragment(String url) {

        this.url = url;
    }


    @Override protected void onFirstUserVisible() {

        baiSiPresenter = new BaiSiPresenterImpl(mContext, this);

        long l = System.currentTimeMillis();

        Log.d("time=============", String.valueOf(l));

        if (NetUtils.isNetworkConnected(mContext)) {
            jokeList.postDelayed(
                () -> baiSiPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA,
                    url, mCurrentPage,
                    false),
                ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);

        }
    }


    @Override protected void onUserVisible() {

    }


    @Override protected View getRefreshLayoutView() {
        return bgaRefreshLayout;
    }


    @Override
    protected void initRefreshLayout(BGANormalRefreshViewHolder bgaNormalRefreshViewHolder) {
        bgaRefreshLayout.setDelegate(this);

        bgaRefreshLayout.setRefreshViewHolder(bgaNormalRefreshViewHolder);
    }


    @Override protected void getViewById(View view) {
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {

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


    @Override public void refreshListData(BaiSiResult baiSiResult) {
        List<BaiSiResult.ListBean> baiSiResultList = baiSiResult.getList();

        if (null != baiSiResult) {

            jokeAdapter.getBaiSiResultList().clear();

            jokeAdapter.getBaiSiResultList().addAll(baiSiResultList);

            jokeAdapter.notifyDataSetChanged();

            bgaRefreshLayout.endRefreshing();

        }

    }


    @Override public void addMoreListData(BaiSiResult baiSiResult) {
        jokeAdapter.getBaiSiResultList()
            .addAll(baiSiResult.getList());
        jokeAdapter.notifyDataSetChanged();

        Log.d("baiSiResult ====", baiSiResult.getList().get(0).getComment());
        bgaRefreshLayout.endLoadingMore();
    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        mCurrentPage = 0;
        if (NetUtils.isNetworkConnected(mContext)) {
            baiSiPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, url, mCurrentPage,
                true);
        }
    }


    int i = 1;


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {

        if (NetUtils.isNetworkConnected(mContext)) {

            i++;

            long time = Long.parseLong(
                String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));//

            mCurrentPage= time - 200000 * i;


            baiSiPresenter.loadListData(TAG_LOG, Constants.EVENT_LOAD_MORE_DATA, url, mCurrentPage
                , true);

            return true;
        }

        return false;
    }



    @Override public void onPagerSelected(int position, String type) {
        url = type;
    }


    @Override public void onItemClick(View view, BaiSiResult.ListBean entity) {

        Intent intent = new Intent();

        intent.setClass(mContext, BaiSiDetailActivity.class);

        Bundle bundle = new Bundle();

        bundle.putParcelable("entity",entity);


        intent.putExtras(bundle);

        startActivity(intent);
    }
}
