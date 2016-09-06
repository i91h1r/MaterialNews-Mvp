package com.github.hyr0318.materialnews_mvp.contract;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/29 10:31
 * 邮箱：2045446584@qq.com
 */
public class VideoMainContract {
    public interface VideoMainView {
        void initializedView(List<TabBaseEntity> tabBaseEntityList);
    }


    public interface VideoMainPresenter {
        void initialized();
    }


    public interface VideoMainModel {
        List<TabBaseEntity> getTabList(Context context);
    }

}