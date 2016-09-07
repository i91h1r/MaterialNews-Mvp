package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.api.ApiConstants;
import com.github.hyr0318.materialnews_mvp.api.Urls;
import com.github.hyr0318.materialnews_mvp.common.Constants;
import com.github.hyr0318.materialnews_mvp.contract.VideoListContract;
import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.listener.OnPagerSelectedListener;
import com.github.hyr0318.materialnews_mvp.listener.OnRecyclerViewItemClickListener;
import com.github.hyr0318.materialnews_mvp.presenter.VideoListPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.activity.WebViewActivity;
import com.github.hyr0318.materialnews_mvp.ui.adapter.VideoListAdapter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/29 10:50
 * 邮箱：2045446584@qq.com
 */
public class VideoListFragment extends BaseFragment
    implements OnPagerSelectedListener,
    VideoListContract.VideoListView,
    BGARefreshLayout.BGARefreshLayoutDelegate,
    OnRecyclerViewItemClickListener<TouTiaoVideoResult.DataBean> {

    private String mCurrentType;
    private int mCurrentPage = 0;
    private VideoListPresenterImpl videoListPresenter;
    private RecyclerView vRecyclerView;
    private VideoListAdapter videoListAdapter;

    List<TouTiaoVideoResult.DataBean> data;
    private BGARefreshLayout bgaRefreshLayout;


    @Override protected void onFirstUserVisible() {

        mCurrentType = mContext.getResources().getStringArray(R.array.tab_array_type)[0];

        videoListPresenter = new VideoListPresenterImpl(getContext(), this);
        vRecyclerView.postDelayed(()-> videoListPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, mCurrentType,
            mCurrentPage, false),ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);


    }


    @Override protected void onUserVisible() {

    }


    @Override protected void onUserInvisible() {

    }




    @Override protected void initViewsAndEvents() {

        videoListAdapter = new VideoListAdapter(mContext, mCurrentType);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        vRecyclerView.setItemAnimator(new DefaultItemAnimator());

        vRecyclerView.setLayoutManager(layoutManager);

        vRecyclerView.setAdapter(videoListAdapter);

        videoListAdapter.setOnRecyclerViewItemClickListener(this);



    }


    @Override protected View getLoadingView() {
        return vRecyclerView;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_video_list_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }



    @Override public void onPagerSelected(int position, String type) {
        this.mCurrentType = type;
    }


    @Override public void refreshListData(TouTiaoVideoResult touTiaoVideoResult) {

        videoListAdapter.getDataList().clear();

        videoListAdapter.getDataList().addAll(touTiaoVideoResult.getData());

        videoListAdapter.notifyDataSetChanged();

        bgaRefreshLayout.endRefreshing();
    }


    @Override public void addMoreListData(TouTiaoVideoResult touTiaoVideoResult) {

        videoListAdapter.getDataList().clear();

        videoListAdapter.getDataList().addAll(touTiaoVideoResult.getData());

        videoListAdapter.notifyDataSetChanged();
    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        videoListPresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, mCurrentType,
            mCurrentPage, true);

    }


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }


    @Override public void onItemClick(View view, TouTiaoVideoResult.DataBean entity) {

        Intent intent = new Intent();

        intent.setClass(mContext, WebViewActivity.class);
        intent.putExtra("title", entity.getTitle());
        intent.putExtra("source_url", Urls.TOUTIAO_BASE_ROOT_URL + entity.getSource_url());

        startActivity(intent);

    }


    @Override protected View getRefreshLayoutView() {
        return bgaRefreshLayout;
    }


    @Override protected void initRefreshLayout(BGANormalRefreshViewHolder bgaNormalRefreshViewHolder) {
        bgaRefreshLayout.setDelegate(this);

        bgaRefreshLayout.setRefreshViewHolder(bgaNormalRefreshViewHolder);
    }


    @Override protected void getViewById(View view) {
         vRecyclerView = (RecyclerView) view.findViewById(R.id.video_List);

         bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.bga);
    }


    @Override public void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }
}
