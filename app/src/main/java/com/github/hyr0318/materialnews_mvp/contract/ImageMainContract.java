package com.github.hyr0318.materialnews_mvp.contract;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.entity.TabBaseEntity;
import com.github.hyr0318.materialnews_mvp.view.BaseView;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/2 11:21
 * 邮箱：2045446584@qq.com
 */
public class ImageMainContract {
    public interface ImageMainView extends BaseView{
        void initializedView(List<TabBaseEntity> tabBaseEntityList);
    }


    public interface ImageMainPresenter {
        void initialized();
    }


    public interface ImageMainModel {
        List<TabBaseEntity> getTabList(Context context);
    }

}