package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.TuwenDetailEntity;
import com.github.hyr0318.materialnews_mvp.view.BaseView;

/**
 * Description:
 * 作者：hyr on 2016/8/31 12:11
 * 邮箱：2045446584@qq.com
 */
public class TuwenDetialContract {

    public interface TuwenDetialView extends BaseView {
        void initializedView(TuwenDetailEntity tuwenDetailEntity);
    }


    public interface TuwenDetialPresenter {
        void loadTuwenDetail(String requestTag,int event_tag,String url ,boolean isSwipeRefresh);
    }


    public interface TuwenDetialModel {
        void getTuwenDetailContent(String requestTag,int event_tag,String url);
    }

}