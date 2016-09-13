package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.baselibrary.widgets.XViewPager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.JokeMainContract;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiTabResult;
import com.github.hyr0318.materialnews_mvp.presenter.JokeMainPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.JokeMainFragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.widget.SmartTabLayout;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class JokeMainFragment extends BaseFragment implements JokeMainContract.JokeMainView {
    private SmartTabLayout smartTabLayout;
    private XViewPager viewPager;


    @Override protected void onFirstUserVisible() {

        JokeMainPresenterImpl jokeMainPresenter = new JokeMainPresenterImpl(mContext, this);

        if (NetUtils.isNetworkConnected(mContext)) {
            jokeMainPresenter.initialized(TAG_LOG);
        }
    }


    @Override protected void onUserVisible() {

    }


    @Override protected View getRefreshLayoutView() {
        return null;
    }


    @Override
    protected void initRefreshLayout(BGANormalRefreshViewHolder bgaNormalRefreshViewHolder) {

    }


    @Override protected void getViewById(View view) {
        smartTabLayout = (SmartTabLayout) view.findViewById(R.id.img_tab_smart);

        viewPager = (XViewPager) view.findViewById(R.id.img_viewpager);
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {

    }


    @Override protected View getLoadingView() {
        return null;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_news_layout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void initializedView(BaiSiTabResult baiSiTabResults) {
        if (null != baiSiTabResults) {


            viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);

            viewPager.setOffscreenPageLimit( baiSiTabResults.getMenus().size());

            viewPager.setAdapter(
               new JokeMainFragmentPagerAdapter(getChildFragmentManager(),baiSiTabResults.getMenus().get(1).getSubmenus()));

            smartTabLayout.setViewPager(viewPager);

            smartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }


                @Override public void onPageSelected(int position) {
                    JokeFragment jokeFragment
                        = (JokeFragment) viewPager.getAdapter()
                        .instantiateItem(viewPager, position);

                   jokeFragment.onPagerSelected(position,baiSiTabResults.getMenus().get(1).getSubmenus().get(position).getUrl());

                }


                @Override public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }
}
