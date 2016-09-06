package com.github.hyr0318.materialnews_mvp.ui.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.github.hyr0318.baselibrary.base.fragment.BaseFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.widgets.XViewPager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.TuwenMainContract;
import com.github.hyr0318.materialnews_mvp.entity.TuwenTabBaseEntity;
import com.github.hyr0318.materialnews_mvp.presenter.TuwenMainPresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.TuwenMainFragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.widget.SmartTabLayout;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/1 09:56
 * 邮箱：2045446584@qq.com
 */
public class TuwenMainFragment extends BaseFragment implements TuwenMainContract.TuwenMainView {

    private XViewPager xViewPager;
    private SmartTabLayout smartTabLayout;


    @Override protected void onFirstUserVisible() {

        TuwenMainPresenterImpl tuwenMainPresenter = new TuwenMainPresenterImpl(mContext, this);
        tuwenMainPresenter.initialized();

    }


    @Override protected void onUserVisible() {

    }


    @Override protected void getViewById(View view) {
        xViewPager = (XViewPager) view.findViewById(R.id.tuwen_viewpager);
        smartTabLayout = (SmartTabLayout) view.findViewById(R.id.tuwen_tab_smart);
    }


    @Override protected void onUserInvisible() {

    }


    @Override protected void initViewsAndEvents() {

    }


    @Override protected View getLoadingView() {
        return null;
    }


    @Override protected int getContentViewLayoutID() {
        return R.layout.fragment_main_lauout;
    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override public void initializedView(List<TuwenTabBaseEntity> tabBaseEntityList) {

        if (null != tabBaseEntityList) {

            xViewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);

            xViewPager.setOffscreenPageLimit(tabBaseEntityList.size());

            xViewPager.setAdapter(
                new TuwenMainFragmentPagerAdapter(getChildFragmentManager(), tabBaseEntityList));

            smartTabLayout.setViewPager(xViewPager);

            smartTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }


                @Override public void onPageSelected(int position) {
                    TuwenFragment tuwenFragment
                        = (TuwenFragment) xViewPager.getAdapter()
                        .instantiateItem(xViewPager, position);

                    tuwenFragment.onPagerSelected(position,
                        tabBaseEntityList.get(position).getType());

                }


                @Override public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }
}
