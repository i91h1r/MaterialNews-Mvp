package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.ImageResult;
import com.github.hyr0318.materialnews_mvp.view.BaseView;

/**
 * Description:
 * 作者：hyr on 2016/9/2 11:37
 * 邮箱：2045446584@qq.com
 */
public class ImageContract {
    public interface ImageContractView extends BaseView{
        void refreshListData(ImageResult ImageReult);

        void addMoreListData(ImageResult ImageReult);
    }


    public interface ImagePresenter {
        void loadListData(String requestTag, int event_tag, String word, int cl, boolean isSwipeRefresh);
    }


    public interface ImageModel {
        void getImageList(String requestTag, int event_tag, String word, int cl);
    }

}