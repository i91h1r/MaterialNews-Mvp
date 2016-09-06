package com.github.hyr0318.materialnews_mvp.contract;

import android.content.Context;
import com.github.hyr0318.baselibrary.base.fragment.BaseLazyFragment;
import com.github.hyr0318.materialnews_mvp.entity.HomeNavigationEntity;
import java.util.List;

/**
 * Author: hyr on 2016/8/28.
 * Email:2045446584@qq.com
 */
public class HomeContract {
    public interface View {

        void initializedView(List<BaseLazyFragment> fragments, List<HomeNavigationEntity> homeNavigationEntities);
    }


    public interface Presenter {

        void initialized();
    }


    public interface Model {

      List<BaseLazyFragment>  getFragments(Context context);

        List<HomeNavigationEntity> getNavigationList(Context context);
    }

}