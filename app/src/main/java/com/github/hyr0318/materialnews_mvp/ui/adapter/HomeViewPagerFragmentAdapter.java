package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.hyr0318.baselibrary.base.fragment.BaseLazyFragment;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class HomeViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<BaseLazyFragment> fragments;


    public HomeViewPagerFragmentAdapter(FragmentManager supportFragmentManager, List<BaseLazyFragment> fragments) {
        super(supportFragmentManager);

        this.fragments = fragments;
    }


    @Override public Fragment getItem(int position) {

        if (null != fragments && position < fragments.size()) {

            return fragments.get(position);
        } else {
            return null;
        }

    }


    @Override public int getCount() {
        return null != fragments ? fragments.size() : 0;
    }
}
