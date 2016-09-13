package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.baselibrary.view.BaseView;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiResult;

/**
 * Description:
 * 作者：hyr on 2016/9/9 15:59
 * 邮箱：2045446584@qq.com
 */
public class BaiSiContract {

    public interface BaiSiView extends BaseView{
        void refreshListData(BaiSiResult baiSiResult);

        void addMoreListData(BaiSiResult baiSiResult);
    }


    public interface BaiSiPresenter {
        void loadListData(String requestTag, int event_tag,String url , long page, boolean isSwipeRefresh);

    }


    public interface BaiSiModel {
        void getListData(String requestTag, int event_tag,String url ,  long page);
    }

}