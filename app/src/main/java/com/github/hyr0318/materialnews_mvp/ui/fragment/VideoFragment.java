package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.widgets.XViewPager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.VideoMainContract;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import com.github.hyr0318.materialnews_mvp.presenter.VideoMainPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.VideoMainFragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.widget.SmartTabLayout;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class VideoFragment extends BaseFragment implements VideoMainContract.VideoMainView {
    private XViewPager xViewPager;
    private SmartTabLayout smartTabLayout;


    @Override protected void getViewById(View view) {
        xViewPager = (XViewPager) view.findViewById(R.id.video_viewpager);

        smartTabLayout = (SmartTabLayout) view.findViewById(R.id.video_tab_smart);
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void onFirstUserVisible() {

        VideoMainPresenterImpl videoMainPresenter = new VideoMainPresenterImpl(mContext, this);

        videoMainPresenter.initialized();

    }


    @Override protected void onUserVisible() {

    }


    @Override protected void initViewsAndEvents() {

    }


    @Override protected View getLoadingView() {
        return xViewPager;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_video_layout;
    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override public void initializedView(List<TabBaseEntity> tabBaseEntityList) {

        if (null != tabBaseEntityList) {

            xViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);

            xViewPager.setOffscreenPageLimit(tabBaseEntityList.size());

            xViewPager.setAdapter(
                new VideoMainFragmentPagerAdapter(getChildFragmentManager(), tabBaseEntityList));

            smartTabLayout.setViewPager(xViewPager);

            smartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }


                @Override public void onPageSelected(int position) {
                    VideoListFragment videoListFragment
                        = (VideoListFragment) xViewPager.getAdapter()
                        .instantiateItem(xViewPager, position);

                    videoListFragment.onPagerSelected(position,
                        tabBaseEntityList.get(position).getType());

                }


                @Override public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }
}
