package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.entity.TuwenTabBaseEntity;
import com.github.hyr0318.materialnews_mvp.ui.fragment.TuwenFragment;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/1 10:10
 * 邮箱：2045446584@qq.com
 */
public class TuwenMainFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<TuwenTabBaseEntity> tabBaseEntityList;
    public TuwenMainFragmentPagerAdapter(FragmentManager fm, List<TuwenTabBaseEntity> tabBaseEntityList) {
        super(fm);
        this.tabBaseEntityList = tabBaseEntityList ;
    }


    @Override public Fragment getItem(int position) {
        return new TuwenFragment();
    }


    @Override public int getCount() {
        return null != tabBaseEntityList ? tabBaseEntityList.size() : 0;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return null != tabBaseEntityList ? tabBaseEntityList.get(position).getName() : "";
    }

}