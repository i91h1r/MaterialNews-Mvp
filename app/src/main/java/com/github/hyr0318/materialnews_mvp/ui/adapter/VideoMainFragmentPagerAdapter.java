package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import com.github.hyr0318.materialnews_mvp.ui.fragment.VideoListFragment;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/29 10:48
 * 邮箱：2045446584@qq.com
 */
public class VideoMainFragmentPagerAdapter extends FragmentPagerAdapter {
    private   List<TabBaseEntity> tabBaseEntityList;
    public VideoMainFragmentPagerAdapter(FragmentManager fm, List<TabBaseEntity> tabBaseEntityList) {
        super(fm);
        this.tabBaseEntityList = tabBaseEntityList ;
    }


    @Override public Fragment getItem(int position) {
        return new VideoListFragment();
    }


    @Override public int getCount() {
        return null != tabBaseEntityList ? tabBaseEntityList.size() : 0;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return null != tabBaseEntityList ? tabBaseEntityList.get(position).getName() : null;
    }

}
