package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.JokeResult;
import com.github.hyr0318.materialnews_mvp.view.BaseView;

/**
 * Description:
 * 作者：hyr on 2016/9/1 11:07
 * 邮箱：2045446584@qq.com
 */
public class JokeContract {
    public interface JokeView extends BaseView{

        void refreshListData(JokeResult jokeResult);

        void addMoreListData(JokeResult jokeResult);
    }


    public interface JokePresenter {

        void loadListData(String requestTag, int event_tag, int page,String showapi_appid,String showapi_timestamp,String showapi_sign, boolean isSwipeRefresh);
    }


    public interface JokeModel {

        void getCommonListData(String requestTag, int event_tag, int page,String showapi_appid,String showapi_timestamp,String showapi_sign);
    }

}