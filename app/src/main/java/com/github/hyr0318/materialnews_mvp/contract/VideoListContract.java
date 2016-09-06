package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.TouTiaoVideoResult;
import com.github.hyr0318.materialnews_mvp.view.BaseView;

/**
 * Description:
 * 作者：hyr on 2016/8/29 12:21
 * 邮箱：2045446584@qq.com
 */
public class VideoListContract {
    public interface VideoListView extends BaseView{

        void refreshListData(TouTiaoVideoResult touTiaoVideoResult);

        void addMoreListData(TouTiaoVideoResult touTiaoVideoResult);
    }


    public interface VideoListPresenter {
        void loadListData(String requestTag, int event_tag, String keywords, int page, boolean isSwipeRefresh);


    }


    public interface VideoListModel {
        void getCommonListData(String requestTag, final int event_tag, String keywords, int page);


    }

}