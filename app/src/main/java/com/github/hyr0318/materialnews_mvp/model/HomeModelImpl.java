package com.github.hyr0318.materialnews_mvp.model;

import android.content.Context;
import com.github.hyr0318.baselibrary.base.fragment.BaseLazyFragment;
import com.github.hyr0318.materialnews_mvp.R;
import com.github.hyr0318.materialnews_mvp.contract.HomeContract;
import com.github.hyr0318.materialnews_mvp.entity.HomeNavigationEntity;
import com.github.hyr0318.materialnews_mvp.ui.fragment.ImageMainFragment;
import com.github.hyr0318.materialnews_mvp.ui.fragment.JokeMainFragment;
import com.github.hyr0318.materialnews_mvp.ui.fragment.TuwenMainFragment;
import com.github.hyr0318.materialnews_mvp.ui.fragment.VideoFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MVPHelper on 2016/08/28
 */

public class HomeModelImpl implements HomeContract.Model {

    @Override public List<BaseLazyFragment> getFragments(Context context) {
        List<BaseLazyFragment> fragments = new ArrayList<>();
        fragments.add(new JokeMainFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TuwenMainFragment());
        fragments.add(new ImageMainFragment());

        return fragments;
    }


    @Override public List<HomeNavigationEntity> getNavigationList(Context context) {
        List<HomeNavigationEntity> homeNavigationEntities = new ArrayList<>();

        String[] navigationArray = context.getResources()
            .getStringArray(R.array.nagivation_list);
        homeNavigationEntities.add(
            new HomeNavigationEntity(R.mipmap.comedy48, navigationArray[0], ""));
        homeNavigationEntities.add(
            new HomeNavigationEntity(R.mipmap.film48, navigationArray[1], ""));
        homeNavigationEntities.add(
            new HomeNavigationEntity(R.mipmap.wink, navigationArray[2], ""));
        homeNavigationEntities.add(
            new HomeNavigationEntity(R.mipmap.google_news_copyrighted48, navigationArray[3], ""));

        return homeNavigationEntities;
    }
}