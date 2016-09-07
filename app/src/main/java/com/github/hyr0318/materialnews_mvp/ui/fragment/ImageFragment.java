package com.github.hyr0318.materialnews_mvp.ui.fragment;

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
import com.github.hyr0318.materialnews_mvp.contract.ImageContract;
import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.listener.OnPagerSelectedListener;
import com.github.hyr0318.materialnews_mvp.presenter.ImagePresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.ImageAdapter;
import com.github.hyr0318.materialnews_mvp.utils.SpacesItemDecoration;
import com.orhanobut.logger.Logger;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/2 11:34
 * 邮箱：2045446584@qq.com
 */
public class ImageFragment extends BaseFragment
    implements OnPagerSelectedListener, ImageContract.ImageContractView,
    BGARefreshLayout.BGARefreshLayoutDelegate {

    private String type;

    private RecyclerView recyclerView;

    private int cl = 1;
    private ImageAdapter imageAdapter;
    private ImagePresenterImpl imagePresenter;
    private BGARefreshLayout bgaRefreshLayout;


    @Override protected void onFirstUserVisible() {

        type = mContext.getResources().getStringArray(R.array.baidu_image_tab_type)[0];

        imagePresenter = new ImagePresenterImpl(mContext, this);

        if (NetUtils.isNetworkConnected(mContext)) {

            recyclerView.postDelayed(
                () -> imagePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type,
                    cl, false), ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS);

        } else {
            triggerNetworkError(true, view -> recyclerView.postDelayed(
                () -> imagePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type,
                    cl, false), ApiConstants.Integers.PAGE_LAZY_LOAD_DELAY_TIME_MS));
        }
    }


    @Override protected void onUserVisible() {

    }


    @Override protected void getViewById(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.image_list);

        bgaRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.image_bga);
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {
        bgaRefreshLayout.setDelegate(this);

        BGANormalRefreshViewHolder bgaNormalRefreshViewHolder = new BGANormalRefreshViewHolder(
            mContext, true);

        bgaRefreshLayout.setRefreshViewHolder(bgaNormalRefreshViewHolder);

        imageAdapter = new ImageAdapter(this, mContext);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        SpacesItemDecoration decoration = new SpacesItemDecoration(16);

        recyclerView.addItemDecoration(decoration);

        recyclerView.setAdapter(imageAdapter);
    }


    @Override protected View getLoadingView() {
        return recyclerView;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_image_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void onPagerSelected(int position, String type) {

        this.type = type;
    }


    @Override public void refreshListData(ImageResult imageResult) {

        if (null != imageResult) {

            Logger.e(imageResult.getData().get(0).getThumbURL());
            List<ImageResult.DataBean> data = imageResult.getData();
            imageAdapter.getData().clear();
            imageAdapter.getData().addAll(data);

            imageAdapter.notifyDataSetChanged();

        }
    }


    @Override public void addMoreListData(ImageResult imageResult) {

        if (imageResult != null) {
            imageAdapter.getData().addAll(imageResult.getData());
            imageAdapter.notifyDataSetChanged();

            bgaRefreshLayout.endLoadingMore();
        }

    }


    @Override public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        if (NetUtils.isNetworkConnected(mContext)) {

            imagePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type,
                cl, true);

        } else {
            triggerNetworkError(true,
                view -> imagePresenter.loadListData(TAG_LOG, Constants.EVENT_REFRESH_DATA, type,
                    cl, true));
        }
    }


    @Override public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        if (NetUtils.isNetworkConnected(mContext)) {
            cl++;

            Logger.d(cl);
            imagePresenter.loadListData(TAG_LOG, Constants.EVENT_LOAD_MORE_DATA, type,
                cl, true);

            return true;
        }

        return false;
    }
}
