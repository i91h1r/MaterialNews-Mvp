package com.github.hyr0318.materialnews_mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.github.hyr0318.baselibrary.adapter.ListViewDataAdapter;
import com.github.hyr0318.baselibrary.adapter.ViewHolderBase;
import com.github.hyr0318.baselibrary.base.activity.BaseActivity;
import com.github.hyr0318.baselibrary.base.fragment.BaseLazyFragment;
import com.github.hyr0318.baselibrary.eventbus.EventCenter;
import com.github.hyr0318.baselibrary.net.NetUtils;
import com.github.hyr0318.baselibrary.widgets.XViewPager;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.HomeContract;
import com.github.hyr0318.materialnews_mvp.entity.HomeNavigationEntity;
import com.github.hyr0318.materialnews_mvp.presenter.HomePresenterImpl;
import com.github.hyr0318.materialnews_mvp.ui.adapter.HomeViewPagerFragmentAdapter;
import java.util.List;

public class MainActivity extends BaseActivity implements HomeContract.View {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private HomePresenterImpl homePresenter;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private XViewPager xViewPager;
    private ListViewDataAdapter<HomeNavigationEntity> homeNavigationEntityListViewDataAdapter;

    private int mCurrentPosition = 0;


    @Override protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }


    @Override protected void getViewById() {

        drawerList = (ListView) findViewById(R.id.drawer_left_list);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

         xViewPager = (XViewPager) findViewById(R.id.home_viewpager);
    }


    @Override protected View getLoadingView() {
        return null;
    }


    @Override protected void initViewsAndEvents() {

        homePresenter = new HomePresenterImpl(this, this);

        homePresenter.initialized();
    }


    @Override protected void getIntentExtras(Bundle extras) {

    }


    @Override protected void onNetworkConnected(NetUtils.NetType type) {

    }


    @Override protected void onNetworkDisConnected() {

    }


    @Override protected void onEventComming(EventCenter eventCenter) {

    }


    @Override protected boolean isBindEventBusHere() {
        return false;
    }


    @Override
    public void initializedView(List<BaseLazyFragment> fragments, List<HomeNavigationEntity> homeNavigationEntities) {

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, getToolbar(),
            R.string.drawer_open, R.string.drawer_close) {
            @Override public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setTitle(R.string.app_name);
                invalidateOptionsMenu();
            }


            @Override public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                setTitle(homeNavigationEntityListViewDataAdapter.getItem(mCurrentPosition)
                    .getIconName());

                invalidateOptionsMenu();
            }
        };

        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);//用于点击返回直接退出应用而不是打开或者关闭drawerlayout

        actionBarDrawerToggle.syncState();//保持和侧滑状态

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        if (null != fragments) {
            xViewPager.setEnableScroll(false);
            xViewPager.setAdapter(
                new HomeViewPagerFragmentAdapter(getSupportFragmentManager(), fragments));
        }


        homeNavigationEntityListViewDataAdapter = new ListViewDataAdapter<>(
            position -> new ViewHolderBase<HomeNavigationEntity>() {

                private TextView textView;
                private ImageView imageView;


                @Override public View createView(LayoutInflater layoutInflater) {
                    View inflate = layoutInflater.inflate(R.layout.nagavation_list_item,
                        null);
                    imageView = (ImageView) inflate.findViewById(
                        R.id.list_item_navigation_icon);

                    textView = (TextView) inflate.findViewById(
                        R.id.list_item_navigation_name);
                    return inflate;
                }


                @Override
                public void showData(int position, HomeNavigationEntity itemData) {

                    textView.setText(itemData.getIconName());

                    imageView.setImageResource(itemData.getIconResID());
                    if (mCurrentPosition == position) {
                        textView.setTextColor(
                            getResources().getColor(R.color.colorPrimary));
                    } else {
                        textView.setTextColor(
                            getResources().getColor(R.color.base_msg_color));
                    }

                }
            });

        drawerList.setAdapter(homeNavigationEntityListViewDataAdapter);

        homeNavigationEntityListViewDataAdapter.getDataList().addAll(homeNavigationEntities);

        homeNavigationEntityListViewDataAdapter.notifyDataSetChanged();

        setTitle(homeNavigationEntityListViewDataAdapter.getItem(mCurrentPosition).getIconName());

        drawerList.setOnItemClickListener((parent, view, position, id) -> {
            mCurrentPosition = position;

            homeNavigationEntityListViewDataAdapter.notifyDataSetChanged();

            xViewPager.setCurrentItem(position, false);

            drawerLayout.closeDrawer(Gravity.LEFT);
        });
    }
}
