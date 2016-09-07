package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.api.ApiConstants;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.TuwenContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenEntity;
import com.github.hyr0318.materialnews_mvp.listener.OnPagerSelectedListener;
import com.github.hyr0318.materialnews_mvp.presenter.TuwenPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.activity.TuwenDetailActivity;
import com.github.hyr0318.materialnews_mvp.ui.adapter.TuwenAapter;
import com.github.hyr0318.materialnews_mvp.utils.SpacesItemDecoration;
import com.github.hyr0318.materialnews_mvp.widget.OnItemClickListener;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/30 16:26
 * 邮箱：2045446584@qq.com
 */
public class TuwenFragment extends BaseFragment implements TuwenContract.TuwenView,
    OnItemClickListener, BGARefreshLayout.BGARefreshLayoutDelegate, OnPagerSelectedListener {

    private TuwenPresenterImpl tuwenPresenter;
    private RecyclerView tuwenList;
    private BGARefreshLayout bgaRefreshLayout;
    private TuwenAapter tuwenAapter;

    private int mCurrentPage = 0;

    private String type;


    @Override protected void onFirstUserVisible() {

        tuwenPresenter = new TuwenPresenterImpl(mContext, this);

        type = mContext.getResources().getStringArray(R.array.tab_array_tuwen_type)[0];

        if (NetUtils.isNetworkConnected(mContext)) {

            tuwenList.postDelayed(
                () -> tuwenPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type,
                    mCurrentPage, false), ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);

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
        tuwenList = (RecyclerView) view.findViewById(R.id.tuwen_list);

        bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.tuwen_bga);
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {

        tuwenAapter = new TuwenAapter(mContext);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL);
        tuwenList.setOverScrollMode(View.OVER_SCROLL_NEVER);
        tuwenList.setLayoutManager(staggeredGridLayoutManager);

        tuwenList.setAdapter(tuwenAapter);

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);

        tuwenList.addItemDecoration(decoration);

        tuwenAapter.setOnItemClickListener(this);
    }


    @Override protected View getLoadingView() {
        return tuwenList;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_qiushi_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void refreshListData(List<TuwenEntity> tuwenEntities) {

        tuwenAapter.setData(tuwenEntities);

        tuwenAapter.notifyDataSetChanged();

        bgaRefreshLayout.endRefreshing();
    }


    @Override public void loadMoreList(List<TuwenEntity> tuwenEntity) {
        tuwenAapter.getData().addAll(tuwenEntity);

        tuwenAapter.notifyDataSetChanged();

        bgaRefreshLayout.endLoadingMore();
    }


    @Override public void onItemClick(View view, int position, Object tag) {
        TuwenEntity tuwenEntity = (TuwenEntity) tag;

        Intent intent = new Intent();

        intent.setClass(getContext(), TuwenDetailActivity.class);
        intent.putExtra("DetialURL", tuwenEntity.getDetialURL());

        startActivity(intent);
    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        tuwenPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type, mCurrentPage,
            true);
    }


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {

        if (NetUtils.isNetworkConnected(mContext)) {

            mCurrentPage++;

            tuwenPresenter.loadListData(TAG_LOG, Constants.EVENT_LOAD_MORE_DATA, type, mCurrentPage,
                true);

            return true;

        } else {
            return false;
        }
    }


    @Override public void onPagerSelected(int position, String type) {
        this.type = type;
    }

}
