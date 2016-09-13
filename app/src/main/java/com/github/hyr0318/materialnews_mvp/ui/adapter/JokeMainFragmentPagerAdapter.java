package com.github.hyr0318.materialnews_mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiTabResult;
import com.github.hyr0318.materialnews_mvp.ui.fragment.JokeFragment;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/2 11:32
 * 邮箱：2045446584@qq.com
 */
public class JokeMainFragmentPagerAdapter extends FragmentPagerAdapter {

    List<BaiSiTabResult.MenusBean.SubmenusBean> submenus;


    public JokeMainFragmentPagerAdapter(FragmentManager fm, List<BaiSiTabResult.MenusBean.SubmenusBean> submenus) {
        super(fm);
        this.submenus = submenus;
    }


    @Override public Fragment getItem(int position) {
        return new JokeFragment(submenus.get(position).getUrl());
    }


    @Override public int getCount() {
        return submenus != null ? submenus.size() : 0;
    }


    @Override public CharSequence getPageTitle(int position) {
        return null != submenus ? submenus.get(position).getName() : "";
    }
}
