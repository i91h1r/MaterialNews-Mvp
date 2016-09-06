package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.widgets.XViewPager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.ImageMainContract;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import com.github.hyr0318.materialnews_mvp.presenter.ImageMainPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.ImageMainFragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.widget.SmartTabLayout;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class ImageMainFragment extends BaseFragment implements ImageMainContract.ImageMainView {
    private SmartTabLayout smartTabLayout;
    private XViewPager viewPager;
    private ImageMainPresenterImpl imageMainPresenter;


    @Override protected void onFirstUserVisible() {

        imageMainPresenter = new ImageMainPresenterImpl(mContext,this);

        imageMainPresenter.initialized();

    }


    @Override protected void onUserVisible() {

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



    @Override public void initializedView(List<TabBaseEntity> tabBaseEntityList) {

        if (null != tabBaseEntityList) {

            viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);

            viewPager.setOffscreenPageLimit(tabBaseEntityList.size());

            viewPager.setAdapter(
                new ImageMainFragmentPagerAdapter(getChildFragmentManager(), tabBaseEntityList));

            smartTabLayout.setViewPager(viewPager);

            smartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }


                @Override public void onPageSelected(int position) {
                    ImageFragment imageFragment
                        = (ImageFragment) viewPager.getAdapter()
                        .instantiateItem(viewPager, position);

                    imageFragment.onPagerSelected(position,
                        tabBaseEntityList.get(position).getType());

                }


                @Override public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }
}
