package com.github.hyr0318.materialnews_mvp.contract;

import com.github.hyr0318.materialnews_mvp.entity.BaiSiTabResult;

/**
 * Description:
 * 作者：hyr on 2016/9/9 15:19
 * 邮箱：2045446584@qq.com
 */
public class JokeMainContract {

    public interface JokeMainView {
        void initializedView(BaiSiTabResult baiSiTabResults);
    }


    public interface JokeMainPresenter {
        void initialized(String requestTag);
    }


    public interface JokeMainModel {
      void   getTabList(String requestTag);
    }

}