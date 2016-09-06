package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.TuwenEntity;
import com.github.hyr0318.materialnews_mvp.view.BaseView;
import java.util.List;

/**
 * Description:
 * 作者：hyr on 2016/8/30 16:46
 * 邮箱：2045446584@qq.com
 */
public class TuwenContract {
    public interface TuwenView  extends BaseView{
        void refreshListData( List<TuwenEntity> tuwenEntity);

        void  loadMoreList(List<TuwenEntity> tuwenEntity);
    }


    public interface TuwenPresenter {
        void loadListData(String requestTag, int event_tag, String keywords, int page ,boolean isSwipeRefresh);
    }


    public interface TuwenModel {
        void getCommonListData(String requestTag, final int event_tag, String keywords,int page);
    }

}