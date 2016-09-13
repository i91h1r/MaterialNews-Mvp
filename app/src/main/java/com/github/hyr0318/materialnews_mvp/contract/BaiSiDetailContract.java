package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.baselibrary.view.BaseView;
import com.github.hyr0318.materialnews_mvp.entity.BaiSiDetailResult;

/**
 * Description:
 * 作者：hyr on 2016/9/13 10:23
 * 邮箱：2045446584@qq.com
 */
public class BaiSiDetailContract {

    public interface BaiSiDetailView extends BaseView {

        void initCommentList(BaiSiDetailResult baiSiDetailResult);

    }


    public interface BaiSiDetailPresenter {

        void loadCommentList(String request_tag, int enent_tag, int page, String  id, boolean isRrefresh);

    }


    public interface BaiSiDetailModel {

        void getCommentList(String request_tag, int enent_tag, int page, String id);
    }

}