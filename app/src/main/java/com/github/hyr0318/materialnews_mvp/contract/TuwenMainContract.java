package com.github.hyr0318.materialnews_mvp.contract;

import android.content.Context;
import com.github.hyr0318.materialnews_mvp.entity.TuwenTabBaseEntity;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/9/1 09:59
 * 邮箱：2045446584@qq.com
 */
public class TuwenMainContract {
public interface TuwenMainView{
    void initializedView(List<TuwenTabBaseEntity> tabBaseEntityList);
}

public interface TuwenMainPresenter{
    void initialized();
}

public interface TuwenMainModel{
    List<TuwenTabBaseEntity> getTabList(Context context);
}


}